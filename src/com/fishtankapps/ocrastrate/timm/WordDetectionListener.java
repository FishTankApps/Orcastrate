package com.fishtankapps.ocrastrate.timm;

import edu.cmu.sphinx.api.SpeechResult;

public interface WordDetectionListener {

	public void onWordDetected(SpeechResult speechResult);
	
}
