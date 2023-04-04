package com.fishtankapps.orcastrate.midi;

import javax.sound.midi.MidiMessage;

public interface MidiListener {

	public void onMidiEvent(MidiMessage e);
	
}
