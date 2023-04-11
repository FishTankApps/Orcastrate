package com.fishtankapps.ocrastrate.timm;

import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;

import com.fishtankapps.orcastrate.midi.VirtualPiano;
import com.fishtankapps.orcastrate.theory.AppliedAccidental;
import com.fishtankapps.orcastrate.theory.Key;
import com.fishtankapps.orcastrate.theory.Pitch;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class TIMM {

	static {
		initialize();
	}
	
	private static ArrayList<WordDetectionListener> wordDetectionListeners;
	private static LiveSpeechRecognizer recognizer;	
	private static Thread wordDetectionThread;
	
	private static VirtualPiano piano;
	
	private static Voice voice;
	
	private static void initializeSpeechDetection() {
		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		configuration.setGrammarPath("resource:/edu/cmu/sphinx/demo/dialog/");
		
		configuration.setUseGrammar(true);
		configuration.setGrammarName("timm-dialog");

		wordDetectionListeners = new ArrayList<>();
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
			
			wordDetectionThread = new Thread( () -> {
					System.out.println("Ready to Listen");
					try {
						while(!Thread.interrupted() && recognizer != null) {
							SpeechResult result = recognizer.getResult();						
							for(WordDetectionListener listener : wordDetectionListeners)
								new Thread( () -> listener.onWordDetected(result) ).start();
						}
					} catch (Exception e) {
						System.out.println("WordDetectionThread exception: " + e.getLocalizedMessage());
					}					
				});
			
		} catch (Exception e) {
			System.err.println("Error setting up live speech recognizer.");
			e.printStackTrace();
		}
	}
	private static void initializeTextToSpeech() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice("kevin16");
	    if (voice != null) {
	        voice.allocate();// Allocating Voice
	        try {
	            voice.setRate(240);  // Setting the rate of the voice
	            voice.setPitch(100); // Setting the Pitch of the voice
	            voice.setVolume(1);  // Setting the volume of the voice
	        } catch (Exception e1) {
	        	System.err.println("Error setting up text to speech.");
	            e1.printStackTrace();
	        }

	    } else {
	    	
	        throw new IllegalStateException("Cannot find voice: kevin16");
	    }
	}
	private static void initializeVirtualPiano() {
		piano = new VirtualPiano();
	}
	
	public static void addWordDetectionListener(WordDetectionListener listener) {
		wordDetectionListeners.add(listener);
	}
	
	public static void startListening() {
		recognizer.startRecognition(true);
		wordDetectionThread.start();
	}
	
	public static void speak(String text) {
		voice.speak(text);
	}
	
	public static void playANote() {
		try {
			piano.playNoteAsync(Pitch.C_NATURAL_4, 100, 1000);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public static void playScale(Key key) {

		try {
			AppliedAccidental[] notes = key.getNotesInKey();
			
			for(int index = 0; index < notes.length; index++) {
				piano.playNoteAsync(Pitch.getPitch(notes[index], (byte) 4), 100, 500);
				Thread.sleep(500);
			}
			
			piano.playNoteAsync(Pitch.getPitch(notes[0], (byte) 4), 100, 500);
			Thread.sleep(500);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void initialize() {
		initializeSpeechDetection();
		initializeTextToSpeech();
		initializeVirtualPiano();
	}
	public static void close() {
		wordDetectionThread.interrupt();
		recognizer.stopRecognition();
		recognizer = null;
	}

}
