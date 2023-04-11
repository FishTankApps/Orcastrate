package com.fishtankapps.orcastrate.theory;

import com.fishtankapps.ocrastrate.timm.Speakable;

public enum Accidental implements Speakable {

	DOUBLE_FLAT("bb"), FLAT("b"), NATURAL(""), SHARP("#"), DOUBLE_SHARP("x");
	
	public String textSymbol;
	
	private Accidental(String textSymbol) {
		this.textSymbol = textSymbol;
	}

	public String toSpeakableString() {
		return name().replace('_', ' ');
	}
}
