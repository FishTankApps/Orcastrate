package com.fishtankapps.orcastrate.theory;

public enum Key {

	A_FLAT_MAJOR(Note.A, Accidental.FLAT, KeyType.MAJOR), A_MAJOR(Note.A, Accidental.NATURAL, KeyType.MAJOR), A_SHARP_MAJOR(Note.A, Accidental.SHARP, KeyType.MAJOR), 
	B_FLAT_MAJOR(Note.B, Accidental.FLAT, KeyType.MAJOR), B_MAJOR(Note.B, Accidental.NATURAL, KeyType.MAJOR), B_SHARP_MAJOR(Note.B, Accidental.SHARP, KeyType.MAJOR), 
	C_FLAT_MAJOR(Note.C, Accidental.FLAT, KeyType.MAJOR), C_MAJOR(Note.C, Accidental.NATURAL, KeyType.MAJOR), C_SHARP_MAJOR(Note.C, Accidental.SHARP, KeyType.MAJOR), 
	D_FLAT_MAJOR(Note.D, Accidental.FLAT, KeyType.MAJOR), D_MAJOR(Note.D, Accidental.NATURAL, KeyType.MAJOR), D_SHARP_MAJOR(Note.D, Accidental.SHARP, KeyType.MAJOR), 
	E_FLAT_MAJOR(Note.E, Accidental.FLAT, KeyType.MAJOR), E_MAJOR(Note.E, Accidental.NATURAL, KeyType.MAJOR), E_SHARP_MAJOR(Note.E, Accidental.SHARP, KeyType.MAJOR), 
	F_FLAT_MAJOR(Note.F, Accidental.FLAT, KeyType.MAJOR), F_MAJOR(Note.F, Accidental.NATURAL, KeyType.MAJOR), F_SHARP_MAJOR(Note.F, Accidental.SHARP, KeyType.MAJOR), 
	G_FLAT_MAJOR(Note.G, Accidental.FLAT, KeyType.MAJOR), G_MAJOR(Note.G, Accidental.NATURAL, KeyType.MAJOR), G_SHARP_MAJOR(Note.G, Accidental.SHARP, KeyType.MAJOR), 
	
	A_FLAT_NATURAL_MINOR(Note.A, Accidental.FLAT, KeyType.NATURAL_MINOR), A_NATURAL_MINOR(Note.A, Accidental.NATURAL, KeyType.NATURAL_MINOR), A_SHARP_NATURAL_MINOR(Note.A, Accidental.SHARP, KeyType.NATURAL_MINOR),
	B_FLAT_NATURAL_MINOR(Note.B, Accidental.FLAT, KeyType.NATURAL_MINOR), B_NATURAL_MINOR(Note.B, Accidental.NATURAL, KeyType.NATURAL_MINOR), B_SHARP_NATURAL_MINOR(Note.B, Accidental.SHARP, KeyType.NATURAL_MINOR),
	C_FLAT_NATURAL_MINOR(Note.C, Accidental.FLAT, KeyType.NATURAL_MINOR), C_NATURAL_MINOR(Note.C, Accidental.NATURAL, KeyType.NATURAL_MINOR), C_SHARP_NATURAL_MINOR(Note.C, Accidental.SHARP, KeyType.NATURAL_MINOR),
	D_FLAT_NATURAL_MINOR(Note.D, Accidental.FLAT, KeyType.NATURAL_MINOR), D_NATURAL_MINOR(Note.D, Accidental.NATURAL, KeyType.NATURAL_MINOR), D_SHARP_NATURAL_MINOR(Note.D, Accidental.SHARP, KeyType.NATURAL_MINOR),
	E_FLAT_NATURAL_MINOR(Note.E, Accidental.FLAT, KeyType.NATURAL_MINOR), E_NATURAL_MINOR(Note.E, Accidental.NATURAL, KeyType.NATURAL_MINOR), E_SHARP_NATURAL_MINOR(Note.E, Accidental.SHARP, KeyType.NATURAL_MINOR),
	F_FLAT_NATURAL_MINOR(Note.F, Accidental.FLAT, KeyType.NATURAL_MINOR), F_NATURAL_MINOR(Note.F, Accidental.NATURAL, KeyType.NATURAL_MINOR), F_SHARP_NATURAL_MINOR(Note.F, Accidental.SHARP, KeyType.NATURAL_MINOR),
	G_FLAT_NATURAL_MINOR(Note.G, Accidental.FLAT, KeyType.NATURAL_MINOR), G_NATURAL_MINOR(Note.G, Accidental.NATURAL, KeyType.NATURAL_MINOR), G_SHARP_NATURAL_MINOR(Note.G, Accidental.SHARP, KeyType.NATURAL_MINOR),
	
	A_FLAT_IONIAN(Note.A, Accidental.FLAT, KeyType.IONIAN), A_IONIAN(Note.A, Accidental.NATURAL, KeyType.IONIAN), A_SHARP_IONIAN(Note.A, Accidental.SHARP, KeyType.IONIAN), 
	B_FLAT_IONIAN(Note.B, Accidental.FLAT, KeyType.IONIAN), B_IONIAN(Note.B, Accidental.NATURAL, KeyType.IONIAN), B_SHARP_IONIAN(Note.B, Accidental.SHARP, KeyType.IONIAN), 
	C_FLAT_IONIAN(Note.C, Accidental.FLAT, KeyType.IONIAN), C_IONIAN(Note.C, Accidental.NATURAL, KeyType.IONIAN), C_SHARP_IONIAN(Note.C, Accidental.SHARP, KeyType.IONIAN), 
	D_FLAT_IONIAN(Note.D, Accidental.FLAT, KeyType.IONIAN), D_IONIAN(Note.D, Accidental.NATURAL, KeyType.IONIAN), D_SHARP_IONIAN(Note.D, Accidental.SHARP, KeyType.IONIAN), 
	E_FLAT_IONIAN(Note.E, Accidental.FLAT, KeyType.IONIAN), E_IONIAN(Note.E, Accidental.NATURAL, KeyType.IONIAN), E_SHARP_IONIAN(Note.E, Accidental.SHARP, KeyType.IONIAN), 
	F_FLAT_IONIAN(Note.F, Accidental.FLAT, KeyType.IONIAN), F_IONIAN(Note.F, Accidental.NATURAL, KeyType.IONIAN), F_SHARP_IONIAN(Note.F, Accidental.SHARP, KeyType.IONIAN), 
	G_FLAT_IONIAN(Note.G, Accidental.FLAT, KeyType.IONIAN), G_IONIAN(Note.G, Accidental.NATURAL, KeyType.IONIAN), G_SHARP_IONIAN(Note.G, Accidental.SHARP, KeyType.IONIAN), 
	
	A_FLAT_DORIAN(Note.A, Accidental.FLAT, KeyType.DORIAN), A_DORIAN(Note.A, Accidental.NATURAL, KeyType.DORIAN), A_SHARP_DORIAN(Note.A, Accidental.SHARP, KeyType.DORIAN), 
	B_FLAT_DORIAN(Note.B, Accidental.FLAT, KeyType.DORIAN), B_DORIAN(Note.B, Accidental.NATURAL, KeyType.DORIAN), B_SHARP_DORIAN(Note.B, Accidental.SHARP, KeyType.DORIAN), 
	C_FLAT_DORIAN(Note.C, Accidental.FLAT, KeyType.DORIAN), C_DORIAN(Note.C, Accidental.NATURAL, KeyType.DORIAN), C_SHARP_DORIAN(Note.C, Accidental.SHARP, KeyType.DORIAN), 
	D_FLAT_DORIAN(Note.D, Accidental.FLAT, KeyType.DORIAN), D_DORIAN(Note.D, Accidental.NATURAL, KeyType.DORIAN), D_SHARP_DORIAN(Note.D, Accidental.SHARP, KeyType.DORIAN), 
	E_FLAT_DORIAN(Note.E, Accidental.FLAT, KeyType.DORIAN), E_DORIAN(Note.E, Accidental.NATURAL, KeyType.DORIAN), E_SHARP_DORIAN(Note.E, Accidental.SHARP, KeyType.DORIAN), 
	F_FLAT_DORIAN(Note.F, Accidental.FLAT, KeyType.DORIAN), F_DORIAN(Note.F, Accidental.NATURAL, KeyType.DORIAN), F_SHARP_DORIAN(Note.F, Accidental.SHARP, KeyType.DORIAN), 
	G_FLAT_DORIAN(Note.G, Accidental.FLAT, KeyType.DORIAN), G_DORIAN(Note.G, Accidental.NATURAL, KeyType.DORIAN), G_SHARP_DORIAN(Note.G, Accidental.SHARP, KeyType.DORIAN), 
	
	A_FLAT_PHRYGIAN(Note.A, Accidental.FLAT, KeyType.PHRYGIAN), A_PHRYGIAN(Note.A, Accidental.NATURAL, KeyType.PHRYGIAN), A_SHARP_PHRYGIAN(Note.A, Accidental.SHARP, KeyType.PHRYGIAN), 
	B_FLAT_PHRYGIAN(Note.B, Accidental.FLAT, KeyType.PHRYGIAN), B_PHRYGIAN(Note.B, Accidental.NATURAL, KeyType.PHRYGIAN), B_SHARP_PHRYGIAN(Note.B, Accidental.SHARP, KeyType.PHRYGIAN), 
	C_FLAT_PHRYGIAN(Note.C, Accidental.FLAT, KeyType.PHRYGIAN), C_PHRYGIAN(Note.C, Accidental.NATURAL, KeyType.PHRYGIAN), C_SHARP_PHRYGIAN(Note.C, Accidental.SHARP, KeyType.PHRYGIAN), 
	D_FLAT_PHRYGIAN(Note.D, Accidental.FLAT, KeyType.PHRYGIAN), D_PHRYGIAN(Note.D, Accidental.NATURAL, KeyType.PHRYGIAN), D_SHARP_PHRYGIAN(Note.D, Accidental.SHARP, KeyType.PHRYGIAN), 
	E_FLAT_PHRYGIAN(Note.E, Accidental.FLAT, KeyType.PHRYGIAN), E_PHRYGIAN(Note.E, Accidental.NATURAL, KeyType.PHRYGIAN), E_SHARP_PHRYGIAN(Note.E, Accidental.SHARP, KeyType.PHRYGIAN), 
	F_FLAT_PHRYGIAN(Note.F, Accidental.FLAT, KeyType.PHRYGIAN), F_PHRYGIAN(Note.F, Accidental.NATURAL, KeyType.PHRYGIAN), F_SHARP_PHRYGIAN(Note.F, Accidental.SHARP, KeyType.PHRYGIAN), 
	G_FLAT_PHRYGIAN(Note.G, Accidental.FLAT, KeyType.PHRYGIAN), G_PHRYGIAN(Note.G, Accidental.NATURAL, KeyType.PHRYGIAN), G_SHARP_PHRYGIAN(Note.G, Accidental.SHARP, KeyType.PHRYGIAN), 
	
	A_FLAT_LYDIAN(Note.A, Accidental.FLAT, KeyType.LYDIAN), A_LYDIAN(Note.A, Accidental.NATURAL, KeyType.LYDIAN), A_SHARP_LYDIAN(Note.A, Accidental.SHARP, KeyType.LYDIAN), 
	B_FLAT_LYDIAN(Note.B, Accidental.FLAT, KeyType.LYDIAN), B_LYDIAN(Note.B, Accidental.NATURAL, KeyType.LYDIAN), B_SHARP_LYDIAN(Note.B, Accidental.SHARP, KeyType.LYDIAN), 
	C_FLAT_LYDIAN(Note.C, Accidental.FLAT, KeyType.LYDIAN), C_LYDIAN(Note.C, Accidental.NATURAL, KeyType.LYDIAN), C_SHARP_LYDIAN(Note.C, Accidental.SHARP, KeyType.LYDIAN), 
	D_FLAT_LYDIAN(Note.D, Accidental.FLAT, KeyType.LYDIAN), D_LYDIAN(Note.D, Accidental.NATURAL, KeyType.LYDIAN), D_SHARP_LYDIAN(Note.D, Accidental.SHARP, KeyType.LYDIAN), 
	E_FLAT_LYDIAN(Note.E, Accidental.FLAT, KeyType.LYDIAN), E_LYDIAN(Note.E, Accidental.NATURAL, KeyType.LYDIAN), E_SHARP_LYDIAN(Note.E, Accidental.SHARP, KeyType.LYDIAN), 
	F_FLAT_LYDIAN(Note.F, Accidental.FLAT, KeyType.LYDIAN), F_LYDIAN(Note.F, Accidental.NATURAL, KeyType.LYDIAN), F_SHARP_LYDIAN(Note.F, Accidental.SHARP, KeyType.LYDIAN), 
	G_FLAT_LYDIAN(Note.G, Accidental.FLAT, KeyType.LYDIAN), G_LYDIAN(Note.G, Accidental.NATURAL, KeyType.LYDIAN), G_SHARP_LYDIAN(Note.G, Accidental.SHARP, KeyType.LYDIAN), 
	
	A_FLAT_MIXOLYDIAN(Note.A, Accidental.FLAT, KeyType.MIXOLYDIAN), A_MIXOLYDIAN(Note.A, Accidental.NATURAL, KeyType.MIXOLYDIAN), A_SHARP_MIXOLYDIAN(Note.A, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	B_FLAT_MIXOLYDIAN(Note.B, Accidental.FLAT, KeyType.MIXOLYDIAN), B_MIXOLYDIAN(Note.B, Accidental.NATURAL, KeyType.MIXOLYDIAN), B_SHARP_MIXOLYDIAN(Note.B, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	C_FLAT_MIXOLYDIAN(Note.C, Accidental.FLAT, KeyType.MIXOLYDIAN), C_MIXOLYDIAN(Note.C, Accidental.NATURAL, KeyType.MIXOLYDIAN), C_SHARP_MIXOLYDIAN(Note.C, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	D_FLAT_MIXOLYDIAN(Note.D, Accidental.FLAT, KeyType.MIXOLYDIAN), D_MIXOLYDIAN(Note.D, Accidental.NATURAL, KeyType.MIXOLYDIAN), D_SHARP_MIXOLYDIAN(Note.D, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	E_FLAT_MIXOLYDIAN(Note.E, Accidental.FLAT, KeyType.MIXOLYDIAN), E_MIXOLYDIAN(Note.E, Accidental.NATURAL, KeyType.MIXOLYDIAN), E_SHARP_MIXOLYDIAN(Note.E, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	F_FLAT_MIXOLYDIAN(Note.F, Accidental.FLAT, KeyType.MIXOLYDIAN), F_MIXOLYDIAN(Note.F, Accidental.NATURAL, KeyType.MIXOLYDIAN), F_SHARP_MIXOLYDIAN(Note.F, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	G_FLAT_MIXOLYDIAN(Note.G, Accidental.FLAT, KeyType.MIXOLYDIAN), G_MIXOLYDIAN(Note.G, Accidental.NATURAL, KeyType.MIXOLYDIAN), G_SHARP_MIXOLYDIAN(Note.G, Accidental.SHARP, KeyType.MIXOLYDIAN), 
	
	A_FLAT_AEOLIAN(Note.A, Accidental.FLAT, KeyType.AEOLIAN), A_AEOLIAN(Note.A, Accidental.NATURAL, KeyType.AEOLIAN), A_SHARP_AEOLIAN(Note.A, Accidental.SHARP, KeyType.AEOLIAN), 
	B_FLAT_AEOLIAN(Note.B, Accidental.FLAT, KeyType.AEOLIAN), B_AEOLIAN(Note.B, Accidental.NATURAL, KeyType.AEOLIAN), B_SHARP_AEOLIAN(Note.B, Accidental.SHARP, KeyType.AEOLIAN), 
	C_FLAT_AEOLIAN(Note.C, Accidental.FLAT, KeyType.AEOLIAN), C_AEOLIAN(Note.C, Accidental.NATURAL, KeyType.AEOLIAN), C_SHARP_AEOLIAN(Note.C, Accidental.SHARP, KeyType.AEOLIAN), 
	D_FLAT_AEOLIAN(Note.D, Accidental.FLAT, KeyType.AEOLIAN), D_AEOLIAN(Note.D, Accidental.NATURAL, KeyType.AEOLIAN), D_SHARP_AEOLIAN(Note.D, Accidental.SHARP, KeyType.AEOLIAN), 
	E_FLAT_AEOLIAN(Note.E, Accidental.FLAT, KeyType.AEOLIAN), E_AEOLIAN(Note.E, Accidental.NATURAL, KeyType.AEOLIAN), E_SHARP_AEOLIAN(Note.E, Accidental.SHARP, KeyType.AEOLIAN), 
	F_FLAT_AEOLIAN(Note.F, Accidental.FLAT, KeyType.AEOLIAN), F_AEOLIAN(Note.F, Accidental.NATURAL, KeyType.AEOLIAN), F_SHARP_AEOLIAN(Note.F, Accidental.SHARP, KeyType.AEOLIAN), 
	G_FLAT_AEOLIAN(Note.G, Accidental.FLAT, KeyType.AEOLIAN), G_AEOLIAN(Note.G, Accidental.NATURAL, KeyType.AEOLIAN), G_SHARP_AEOLIAN(Note.G, Accidental.SHARP, KeyType.AEOLIAN), 
	
	A_FLAT_LOCRIAN(Note.A, Accidental.FLAT, KeyType.LOCRIAN), A_LOCRIAN(Note.A, Accidental.NATURAL, KeyType.LOCRIAN), A_SHARP_LOCRIAN(Note.A, Accidental.SHARP, KeyType.LOCRIAN), 
	B_FLAT_LOCRIAN(Note.B, Accidental.FLAT, KeyType.LOCRIAN), B_LOCRIAN(Note.B, Accidental.NATURAL, KeyType.LOCRIAN), B_SHARP_LOCRIAN(Note.B, Accidental.SHARP, KeyType.LOCRIAN), 
	C_FLAT_LOCRIAN(Note.C, Accidental.FLAT, KeyType.LOCRIAN), C_LOCRIAN(Note.C, Accidental.NATURAL, KeyType.LOCRIAN), C_SHARP_LOCRIAN(Note.C, Accidental.SHARP, KeyType.LOCRIAN), 
	D_FLAT_LOCRIAN(Note.D, Accidental.FLAT, KeyType.LOCRIAN), D_LOCRIAN(Note.D, Accidental.NATURAL, KeyType.LOCRIAN), D_SHARP_LOCRIAN(Note.D, Accidental.SHARP, KeyType.LOCRIAN), 
	E_FLAT_LOCRIAN(Note.E, Accidental.FLAT, KeyType.LOCRIAN), E_LOCRIAN(Note.E, Accidental.NATURAL, KeyType.LOCRIAN), E_SHARP_LOCRIAN(Note.E, Accidental.SHARP, KeyType.LOCRIAN), 
	F_FLAT_LOCRIAN(Note.F, Accidental.FLAT, KeyType.LOCRIAN), F_LOCRIAN(Note.F, Accidental.NATURAL, KeyType.LOCRIAN), F_SHARP_LOCRIAN(Note.F, Accidental.SHARP, KeyType.LOCRIAN), 
	G_FLAT_LOCRIAN(Note.G, Accidental.FLAT, KeyType.LOCRIAN), G_LOCRIAN(Note.G, Accidental.NATURAL, KeyType.LOCRIAN), G_SHARP_LOCRIAN(Note.G, Accidental.SHARP, KeyType.LOCRIAN);
	
	
	public enum KeyType {
		MAJOR             (Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.WHOLE_STEP,  Interval.HALF_STEP),
		NATURAL_MINOR     (Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP,  Interval.WHOLE_STEP),
		IONIAN            (Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.WHOLE_STEP,  Interval.HALF_STEP), 
		DORIAN            (Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,   Interval.WHOLE_STEP), 
		PHRYGIAN          (Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP,  Interval.WHOLE_STEP), 
		LYDIAN            (Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP,  Interval.HALF_STEP), 
		MIXOLYDIAN        (Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,   Interval.WHOLE_STEP),
		AEOLIAN           (Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP,  Interval.WHOLE_STEP),
		LOCRIAN           (Interval.HALF_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP, Interval.HALF_STEP,  Interval.WHOLE_STEP,  Interval.WHOLE_STEP, Interval.WHOLE_STEP);
		
		
		private Interval[] intervals;
		private KeyType(Interval... intervals) {
			this.intervals = intervals;
		}
	}
	

	private AppliedAccidental[] notesInKey;
	private KeySigniture keySigniture;
	private KeyType type;    
	
	private Key(Note rootPitch, Accidental accidental, KeyType type) {
		this.type = type;
		
		notesInKey = new AppliedAccidental[type.intervals.length];		
		notesInKey[0] = AppliedAccidental.getApplyAccidental(rootPitch, accidental);
		
		for(int index = 1; index < notesInKey.length; index++) {
			Note nextNote = notesInKey[index - 1].getNote().getNextNote();
			Interval targetInterval = type.intervals[index - 1];
			AppliedAccidental aaNote;
			
			if(Interval.measureInterval(notesInKey[index - 1], 
					aaNote = AppliedAccidental.getApplyAccidental(nextNote, Accidental.NATURAL)).isEqual(targetInterval))
				notesInKey[index] = aaNote;
			else if(Interval.measureInterval(notesInKey[index - 1], 
					aaNote = AppliedAccidental.getApplyAccidental(nextNote, Accidental.SHARP)).isEqual(targetInterval))
				notesInKey[index] = aaNote;
			else if(Interval.measureInterval(notesInKey[index - 1], 
					aaNote = AppliedAccidental.getApplyAccidental(nextNote, Accidental.FLAT)).isEqual(targetInterval))
				notesInKey[index] = aaNote;
			else if(Interval.measureInterval(notesInKey[index - 1], 
					aaNote = AppliedAccidental.getApplyAccidental(nextNote, Accidental.DOUBLE_SHARP)).isEqual(targetInterval))
				notesInKey[index] = aaNote;
			else if(Interval.measureInterval(notesInKey[index - 1], 
					aaNote = AppliedAccidental.getApplyAccidental(nextNote, Accidental.DOUBLE_FLAT)).isEqual(targetInterval))
				notesInKey[index] = aaNote;
			else
				throw new RuntimeException("Error generating key: " + this.name() + " - Reached \"unreachable\" code.");
		}
		
		keySigniture = KeySigniture.getKeySigniture(this);
	}
	
	public KeyType getKeyType() {
		return type;
	}
	
	public AppliedAccidental[] getNotesInKey() {
		return notesInKey;
	}
	
	public KeySigniture getKeySigniture() {
		return keySigniture;
	}
	
	public void printKey() {
		for(int index = 0; index < notesInKey.length - 1; index++) {
			System.out.print(notesInKey[index] + " ");
		}
		
		System.out.println(notesInKey[notesInKey.length - 1]);
	}

	public static Key parseKey(String string) {
		string = string.trim();
		Note tonicNote = Note.valueOf((string.charAt(0)+"").toUpperCase());
		
		Accidental tonicAccidental = Accidental.NATURAL;
		
		if(string.contains("sharp"))
			tonicAccidental = Accidental.SHARP;
		else if(string.contains("flat"))
			tonicAccidental = Accidental.FLAT;
		
		AppliedAccidental tonic = AppliedAccidental.getApplyAccidental(tonicNote, tonicAccidental);
		
		KeyType keyType = KeyType.MAJOR;
		if(string.contains("minor"))
			keyType = KeyType.NATURAL_MINOR;
			
		for(Key key : Key.values())
			if(key.type.equals(keyType) && key.notesInKey[0].equals(tonic))
				return key;
		
		return null;
	}
}