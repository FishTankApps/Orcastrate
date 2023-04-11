package com.fishtankapps.orcastrate.theory;

import com.fishtankapps.ocrastrate.timm.Speakable;

public enum AppliedAccidental implements Speakable {

	A_DOUBLE_FLAT(Note.A, Accidental.DOUBLE_FLAT, -2), A_FLAT(Note.A, Accidental.FLAT, -1), A_NATURAL(Note.A, Accidental.NATURAL, 0),  A_SHARP(Note.A, Accidental.SHARP, 1),  A_DOUBLE_SHARP(Note.A, Accidental.DOUBLE_SHARP, 2),
	B_DOUBLE_FLAT(Note.B, Accidental.DOUBLE_FLAT, 0),  B_FLAT(Note.B, Accidental.FLAT, 1),  B_NATURAL(Note.B, Accidental.NATURAL, 2),  B_SHARP(Note.B, Accidental.SHARP, 3),  B_DOUBLE_SHARP(Note.B, Accidental.DOUBLE_SHARP, 4),
	C_DOUBLE_FLAT(Note.C, Accidental.DOUBLE_FLAT, 1),  C_FLAT(Note.C, Accidental.FLAT, 2),  C_NATURAL(Note.C, Accidental.NATURAL, 3),  C_SHARP(Note.C, Accidental.SHARP, 4),  C_DOUBLE_SHARP(Note.C, Accidental.DOUBLE_SHARP, 5),
	D_DOUBLE_FLAT(Note.D, Accidental.DOUBLE_FLAT, 3),  D_FLAT(Note.D, Accidental.FLAT, 4),  D_NATURAL(Note.D, Accidental.NATURAL, 5),  D_SHARP(Note.D, Accidental.SHARP, 6),  D_DOUBLE_SHARP(Note.D, Accidental.DOUBLE_SHARP, 7),
	E_DOUBLE_FLAT(Note.E, Accidental.DOUBLE_FLAT, 5),  E_FLAT(Note.E, Accidental.FLAT, 6),  E_NATURAL(Note.E, Accidental.NATURAL, 7),  E_SHARP(Note.E, Accidental.SHARP, 8),  E_DOUBLE_SHARP(Note.E, Accidental.DOUBLE_SHARP, 9),
	F_DOUBLE_FLAT(Note.F, Accidental.DOUBLE_FLAT, 6),  F_FLAT(Note.F, Accidental.FLAT, 7),  F_NATURAL(Note.F, Accidental.NATURAL, 8),  F_SHARP(Note.F, Accidental.SHARP, 9),  F_DOUBLE_SHARP(Note.F, Accidental.DOUBLE_SHARP, 10),
	G_DOUBLE_FLAT(Note.G, Accidental.DOUBLE_FLAT, 8),  G_FLAT(Note.G, Accidental.FLAT, 9),  G_NATURAL(Note.G, Accidental.NATURAL, 10), G_SHARP(Note.G, Accidental.SHARP, 11), G_DOUBLE_SHARP(Note.G, Accidental.DOUBLE_SHARP, 12);
	
	private Accidental accidental;
	private Note note;
	private int value;
	
	private AppliedAccidental(Note note, Accidental accidental, int value) {
		this.accidental = accidental;
		this.note = note;
		this.value = value;
	}

	public Accidental getAccidental() {
		return accidental;
	}

	public Note getNote() {
		return note;
	}
	
	int getIntervalValue() {
		return value;
	}
	
	public String toString() {
		return note.name() + accidental.textSymbol;
	}
	
	public static AppliedAccidental getApplyAccidental(Note note, Accidental accidental) {
		for(AppliedAccidental aa : AppliedAccidental.values())
			if(aa.note.equals(note) && aa.accidental.equals(accidental))
				return aa;
		
		throw new RuntimeException("Error applying accidental - Reached \"unreachable\" code.");
	}

	@Override
	public String toSpeakableString() {
		return note.toSpeakableString() + " " + accidental.toSpeakableString();
	}
		
}
