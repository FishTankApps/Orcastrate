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

	private ArrayList<WordDetectionListener> wordDetectionListeners;
	private LiveSpeechRecognizer recognizer;	
	private Thread wordDetectionThread;
	
	private VirtualPiano piano;
	
	private Voice voice;
	
	private TIMM() {
		initializeSpeechDetection();
		initializeTextToSpeech();
		initializeVirtualPiano();
	}
	
	private void initializeSpeechDetection() {
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
					while(!Thread.interrupted() && recognizer != null) {
						SpeechResult result = recognizer.getResult();						
						for(WordDetectionListener listener : wordDetectionListeners)
							new Thread( () -> listener.onWordDetected(result) ).start();
					}
				});
			
		} catch (Exception e) {
			System.err.println("Error setting up live speech recognizer.");
			e.printStackTrace();
		}
	}
	private void initializeTextToSpeech() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice("kevin16");
	    if (voice != null) {
	        voice.allocate();// Allocating Voice
	        try {
	            //voice.setRate(120);  // Setting the rate of the voice
	            //voice.setPitch(150); // Setting the Pitch of the voice
	            //voice.setVolume(3);  // Setting the volume of the voice
	        } catch (Exception e1) {
	        	System.err.println("Error setting up text to speech.");
	            e1.printStackTrace();
	        }

	    } else {
	    	
	        throw new IllegalStateException("Cannot find voice: kevin16");
	    }
	}
	private void initializeVirtualPiano() {
		piano = new VirtualPiano();
	}
	
	public void addWordDetectionListener(WordDetectionListener listener) {
		wordDetectionListeners.add(listener);
	}
	
	public void startListening() {
		recognizer.startRecognition(true);
		wordDetectionThread.start();
	}
	
	public void speak(String text) {
		voice.speak(text);
	}
	
	public void playANote() {
		try {
			piano.playNoteAsync(Pitch.C_NATURAL_4, 100, 1000);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public void playScale(Key key) {

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
	
	
	private static TIMM timm = null;	
	public static TIMM getInstance() {
		return timm;
	}
	public static void initialize() {
		if(timm == null)
			timm = new TIMM();
	}

	public static void close() {
		if(timm != null) {
			timm.wordDetectionThread.interrupt();
			timm.recognizer.stopRecognition();
			timm.recognizer = null;
		}
	}
}
