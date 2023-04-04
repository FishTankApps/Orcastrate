package com.fishtankapps.orcastrate.midi;

import java.io.File;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;

import com.fishtankapps.orcastrate.theory.Pitch;
import com.synthbot.audioio.vst.JVstAudioThread;
import com.synthbot.audioplugin.vst.vst2.JVstHost2;

public class VirtualPiano {

	private static final String KEYZONE_PATH = "./lib/jvsthost/piano.dll";
	
	private JVstHost2 pianoVst;
	
	public VirtualPiano() {
		
		try {
			pianoVst = JVstHost2.newInstance(new File(KEYZONE_PATH), 48_000, 1024);
			JVstAudioThread audioThread = new JVstAudioThread(pianoVst);
			
			Thread thread = new Thread(audioThread);
			thread.setName("Audio Thread");
			thread.setDaemon(true);
			thread.start();		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMidi(ShortMessage message) {
		pianoVst.queueMidiMessage(message);
	}
	
	public void playNote(Pitch note, int velocity, int length) throws InvalidMidiDataException, InterruptedException {
		playNotes (new Pitch[] {note}, new int[] {velocity}, new int[] {length});
	}
	public void playNotes(Pitch[] notes, int[] velocities, int[] lengths) throws InvalidMidiDataException, InterruptedException {
		
		playNotesAsync(notes, velocities, lengths);
		
		int longestLength = 0;
		for(int length : lengths)
			if(length > longestLength)
				longestLength = length;
		
		Thread.sleep(longestLength);
	}

	public void playNoteAsync(Pitch note, int velocity, int length) throws InvalidMidiDataException {
		playNotesAsync(new Pitch[] {note}, new int[] {velocity}, new int[] {length});		
	}	
	public void playNotesAsync(Pitch[] notes, int[] velocities, int[] lengths) throws InvalidMidiDataException {
		
		if(notes.length != velocities.length || notes.length != lengths.length)
			throw new IllegalArgumentException("All arrays must have the same length.");
		
		for(int index = 0; index < notes.length; index++) {
			int thisIndex = index;
			
			ShortMessage smNoteOn = new ShortMessage();
			smNoteOn.setMessage(ShortMessage.NOTE_ON, 0, notes[index].getMidiKey(), velocities[index]);
			pianoVst.queueMidiMessage(smNoteOn);
			
			new Thread(() -> {
				try {				
					Thread.sleep(lengths[thisIndex]);
					
					ShortMessage smNoteOff = new ShortMessage();
					smNoteOff.setMessage(ShortMessage.NOTE_OFF, 0, notes[thisIndex].getMidiKey(), 0);
					pianoVst.queueMidiMessage(smNoteOff);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		
	}
}