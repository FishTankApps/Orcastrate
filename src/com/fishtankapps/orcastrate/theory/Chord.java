package com.fishtankapps.orcastrate.theory;

import com.fishtankapps.orcastrate.theory.Interval.Direction;

public class Chord {

	public enum ChordType {
		MAJOR("M"), MINOR("m");
		
		private String abreviation;
		
		ChordType(String abreviation){
			this.abreviation = abreviation;
		}
		
		public String getAbreviation() {
			return abreviation;
		}
	}
	
	private ChordType type;
	private Pitch root;
	private Pitch[] notes;
	private int inversions;
	
	public Chord(Pitch root, ChordType type) {
		this(root, type, 0);
	}
	
	public Chord(Pitch root, ChordType type, int inversions) {
		this.inversions = inversions;
		this.root = root;
		this.type = type;
		
		if (type == ChordType.MAJOR) {
			Pitch[] chordArray = new Pitch[3];
			chordArray[0] = root;
			chordArray[1] = Interval.getInterval(root, Interval.MAJOR_THIRD, Direction.UP);
			chordArray[2] = Interval.getInterval(root, Interval.PERFECT_FIFTH, Direction.UP);
			
			notes = invertChord(chordArray, inversions);
			
		} else if (type == ChordType.MINOR) {
			Pitch[] chordArray = new Pitch[3];
			chordArray[0] = root;
			chordArray[1] = Interval.getInterval(root, Interval.MINOR_THIRD, Direction.UP);
			chordArray[2] = Interval.getInterval(root, Interval.PERFECT_FIFTH, Direction.UP);
			
			notes = invertChord(chordArray, inversions);
		} else		
			throw new RuntimeException("Chord type not implemented yet: " + type);
	}
	
	
	public Pitch getRootNote() {
		return root;
	}
	
	public Pitch[] getNotes() {
		return notes;
	}
	
	public int getInversionCount() {
		return inversions;
	}
	
	public ChordType getChordType() {
		return type;
	}
	
	
	public String toString() {
		return root + " " + type.getAbreviation() + " (" + inversions + ")";
	}
	
	
	public static Pitch[] invertChord(Pitch[] chord, int inversions) {
		Pitch bottom;
		
		for(; 0 > inversions; inversions--) {
			bottom = chord[0];			
			System.arraycopy(chord, 1, chord, 0, chord.length);
			chord[chord.length - 1] = Interval.getInterval(bottom, Interval.OCTAVE, Direction.UP);
		}
		
		return chord;
	}

}