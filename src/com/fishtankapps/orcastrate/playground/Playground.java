package com.fishtankapps.orcastrate.playground;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Playground {

	public static void main(String[] args) throws Exception {

		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);
		System.out.println("Recognition Started");
		String word = "";
		
		while(!word.equals("quit")) {
			SpeechResult result = recognizer.getResult();
			word = result.getHypothesis();
			System.out.println(word);
		}
		
		
		
		// Pause recognition process. It can be resumed then with startRecognition(false).
		recognizer.stopRecognition();
	}
}