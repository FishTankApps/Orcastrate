package com.fishtankapps.orcastrate.midi;

import java.util.ArrayList;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class MidiKeyboard {

	private MidiDevice device;
	private ArrayList<MidiListener> listeners;
	
	private MidiKeyboard(MidiDevice device) {
		this.device = device;
		listeners = new ArrayList<>();
		
		Transmitter trans;
		try {
			trans = device.getTransmitter();
			trans.setReceiver(new Receiver() {
				public void send(MidiMessage message, long timeStamp) {
					
					for(MidiListener listener : listeners)
						listener.onMidiEvent(message);
				}	
				public void close() {}				
			});
			
		} catch (MidiUnavailableException e) {
		}		
	}
	
	public void addListener(MidiListener listener) {
		this.listeners.add(listener);
	}
	
	public void close() {
		device.close();
	}
	
	
	
	public static MidiKeyboard[] findKeyboards() {
		ArrayList<MidiDevice> devices = new ArrayList<>();
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		
		for (MidiDevice.Info info : infos) {
			try {
				device = MidiSystem.getMidiDevice(info);
				device.open();				
				devices.add(device);

			} catch (MidiUnavailableException e) {}
		}
		
		
		MidiKeyboard[] keyboards = new MidiKeyboard[devices.size()];
		
		for(int index = 0; index < keyboards.length; index++)
			keyboards[index] = new MidiKeyboard(devices.get(index));		
		
		return keyboards;
	}

}
