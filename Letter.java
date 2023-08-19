/**
 * This class represents a single letter to be used in the game. 
 * Implements labels which indicates whether it's used, unused, or correct when comparing 
 * with the mystery word. 
 * @author chaejinhur
 *
 */
public class Letter {
	// private variables
	private char letter; 
	protected int label; 
	
	// constants for the labels of the letter object 
	private final int UNSET = -1; 
	protected final static int UNUSED = 0; 
	protected final int USED = 1; 
	protected final int CORRECT = 2; 
	
	
	// constructor to initialize the letter var. and set the label as unset
	public Letter (char c) {
		this.letter = c; 	
		this.label = UNSET; 
	}
	
	// check whether otherObject is of the class Letter
	public boolean equals(Object otherObject) {
		if (this == otherObject) {		
			return true; 
		}
		
		if (otherObject == null || this.getClass() != otherObject.getClass()) {
			return false; 
		}
		
		Letter otherLetter = (Letter) otherObject; 
		return this.letter == otherLetter.letter; 
	} 
	
	public String decorator() {
		if (label == USED) {
			return "+"; 
		}
		else if (label == UNUSED) {
			return "-"; 
		}
		else if (label == CORRECT) {
			return "!"; 
		}
		else {		// UNSET 
			return " "; 
		}
		
	} 
	
	public String toString() {
		return decorator() + letter + decorator(); 
	}
	
	// change the value of attribute "label" to UNUSED 
	public void setUnused() {
		label = UNUSED; 
	}
	
	// change the value of attribute "label" to USED 
	public void setUsed() {
		label = USED; 
	}
	
	// change the value of attribute "label" to CORRECT 
	public void setCorrect() {
		label = CORRECT; 
	} 
	
	public boolean isUnused() {
		return label == UNUSED; 
	}

	
	// take the string to convert it into an array of Letter objects 
	public static Letter[] fromString(String s) {
		char[] charArray = s.toCharArray(); 		// convert input string into character array 
		Letter[] letters = new Letter[charArray.length]; 	// new array of Letter objects with length of charArray
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i]; 				// character at the current index 
			letters[i] = new Letter(c); 		// create a new Letter object with the character 
		}
		
		return letters; 	// return the array of Letter objects 
		
	}


}
