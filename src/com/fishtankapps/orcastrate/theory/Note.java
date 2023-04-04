package com.fishtankapps.orcastrate.theory;

public enum Note {
	A, B, C, D, E, F, G;
	
	public Note getNextNote() {
		switch(this) {
			case A: return B;
			case B: return C;
			case C: return D;
			case D: return E;
			case E: return F;
			case F: return G;
			case G: return A;
			default:
				throw new RuntimeException("Error finding next note - Reached \"unreachable\" code.");
		}
	}
	
	public Note getPreviousNote() {
		switch(this) {
			case A: return G;
			case B: return A;
			case C: return B;
			case D: return C;
			case E: return D;
			case F: return E;
			case G: return F;
			default:
				throw new RuntimeException("Error finding next note - Reached \"unreachable\" code.");
		}
	}
}
