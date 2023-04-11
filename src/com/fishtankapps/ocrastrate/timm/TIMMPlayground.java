package com.fishtankapps.ocrastrate.timm;

import com.fishtankapps.orcastrate.theory.AppliedAccidental;
import com.fishtankapps.orcastrate.theory.Key;

public class TIMMPlayground {

	public static void main(String[] args) {

		TIMM.startListening();

		TIMM.addWordDetectionListener((word) -> {
				String command = word.getHypothesis();
				
				if (command.equals("introduce yourself")) {
					TIMM.speak("Hello. My name is TIMM, which stands for Technological Inteligence Music Maker. I can play scales!");
					
				} else if (command.equals("play a note")) {
					TIMM.playANote();
					
				} else if (command.contains("play") && command.contains("scale")) {
					TIMM.speak("Playing " + command.substring(4, command.length() - 6) + " scale.");
					TIMM.playScale(Key.parseKey(command.substring(4, command.length() - 6)));
				} else if (command.contains("goodbye")) {
					TIMM.speak("Good bye!");
					TIMM.close();
				} else if (command.contains("what notes")) {
					Key key = Key.parseKey(command.substring(19, command.length() - 6));
					String speak = "The notes in a " + command.substring(19, command.length() - 6) + " are, ";
					AppliedAccidental[] notes = key.getNotesInKey();
		
					for(int i = 0; i < notes.length - 1; i++)
						speak += notes[i].toSpeakableString() + ", ";
					
					speak += "and " + notes[notes.length - 1].toSpeakableString();
					TIMM.speak(speak);
				} else if (command.contains("thank you")) {
					TIMM.speak("You are welcome.");
				}
			});
		
		
		
		while(true);
	}
	
}
