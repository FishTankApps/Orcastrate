package com.fishtankapps.orcastrate.playground;


import javax.sound.midi.ShortMessage;

import com.fishtankapps.orcastrate.midi.MidiKeyboard;
import com.fishtankapps.orcastrate.midi.VirtualPiano;

public class MidiDataForwardingTest {

	public static void main(String[] args) throws Exception {
		VirtualPiano piano = new VirtualPiano();		
		MidiKeyboard[] keyboards = MidiKeyboard.findKeyboards();
		
		for(MidiKeyboard keyboard : keyboards) {
			keyboard.addListener((event) -> {				
				piano.sendMidi((ShortMessage) event);
			});
		}
		
		while(true) {}
	}
	
}
