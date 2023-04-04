package com.fishtankapps.orcastrate.theory;


public enum Interval {

	UNISON(0, "P1"),           MINOR_SECOND(1, "m2"),     MAJOR_SECOND(2, "M2"), 
	MINOR_THIRD(3, "m3"),      MAJOR_THIRD(4, "M3"),      PERFECT_FOURTH(5, "P4"), 
	AUGMENTED_FOURTH(6, "A4"), DIMINISHED_FIFTH(6, "d5"), PERFECT_FIFTH(7, "P5"), 
	MINOR_SIXTH(8, "m6"),	   MAJOR_SIXTH(9, "M6"),      MINOR_SEVENTH(10, "m7"), 
	MAJOR_SEVENTH(11, "M7"),   OCTAVE(12, "P8"), 
	HALF_STEP(1, "H"),         WHOLE_STEP(2, "W");
	
	private String abrevation;
	private int halfSteps;
	
	Interval(int halfSteps, String abrevation) {
		this.abrevation = abrevation;
		this.halfSteps = halfSteps;
	}
	
	public int getNumberOfHalfSteps() {
		return halfSteps;
	}
	
	public String toString() {
		return abrevation;
	}

	public boolean isEqual(Interval i) {
		return i.halfSteps == halfSteps;
	}
	
	public enum Direction {
		UP, DOWN;
	}
	
	public static Pitch getInterval(Pitch note, Interval interval, Direction direction) {
		return Pitch.getPitch(note.getMidiKey() + ((direction == Direction.UP) 
							? interval.getNumberOfHalfSteps() : -interval.getNumberOfHalfSteps()));
	}
	
	public static Interval getInterval(Pitch note1, Pitch note2) {
		
		int gap = Math.abs(note1.getMidiKey() - note2.getMidiKey()) % 12;
		
		for(Interval i : Interval.values())
			if(i.halfSteps == gap)
				return i;
		
		return null;
	}

	public static Interval measureInterval(AppliedAccidental note1, AppliedAccidental note2) {
		int halfsteps = Math.abs((note2.getIntervalValue() - note1.getIntervalValue() + 24) % 12);
		
		for(Interval i : Interval.values())
			if(i.halfSteps == halfsteps)
				return i;
		
		throw new RuntimeException("Error measuring interval - Reached \"unreachable\" code.");
	}
}
