package com.fishtankapps.ocrastrate.timm;

import com.fishtankapps.orcastrate.theory.Key;

public class TIMMPlayground {

	public static void main(String[] args) {
		TIMM.initialize();
		TIMM.getInstance().startListening();
		
		TIMM.getInstance().addWordDetectionListener((word) -> {
				//System.out.println(word.getHypothesis());  
				String command = word.getHypothesis();
				
				if (command.equals("introduce yourself")) {
					TIMM.getInstance().speak("Hello. My name is TIMM, which stands for Technological Inteligence Music Maker. I can play scales!");
					
				} else if (command.equals("play a note")) {
					TIMM.getInstance().playANote();
					
				} else if (command.contains("play") && command.contains("scale")) {
					TIMM.getInstance().speak("Playing " + command.substring(4, command.length() - 6) + " scale.");
					TIMM.getInstance().playScale(Key.parseKey(command.substring(4, command.length() - 6)));
				}
			});
		
		
		
		while(true);
	}
	
}
