package com.fishtankapps.orcastrate.theory;

public enum Accidental {

	DOUBLE_FLAT("bb"), FLAT("b"), NATURAL(""), SHARP("#"), DOUBLE_SHARP("x");
	
	public String textSymbol;
	
	private Accidental(String textSymbol) {
		this.textSymbol = textSymbol;
	}
}
