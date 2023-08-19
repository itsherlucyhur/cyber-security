/**
 * This class extends the Letter class by using a String instance variable
 * and add additional methods to better the functionality of the Letter class. 
 * @author chaejinhur
 *
 */
public class ExtendedLetter extends Letter {
	// private variables
	private String content; 
	private int family; 		// family of related letters 
	private boolean related;	// if the letter is related to others  
	private final int SINGLETON = -1;

	/**
	 * Constructor to initialize the superclass variables 
	 * and the private variables in this class
	 * @param s The content in the extended letter 
	 */
	public ExtendedLetter(String s) {
		super('c'); 	// initialize superclass variables 
		this.content = s; 
		this.related = false; 
		this.family = SINGLETON; 
	}
	
	/**
	 * Constructor that initializes the instance variables of the superclass
	 * and the instance variables: content, related, and family 
	 * @param s Content of the extended letter 
	 * @param fam The family of related letters 
	 */
	public ExtendedLetter(String s, int fam) {
		super('c'); 
		this.content = s; 
		this.related = false; 
		this.family = fam; 
	}
	
	
	public boolean equals(Object other) {
		// if the other object is null or not an instance of ExtendedLetter: return false 
	    if (other == null || other instanceof ExtendedLetter == false) {
			return false; 
		}
	    
	    // cast the other object to type ExtendedLetter 
		ExtendedLetter otherLetter = (ExtendedLetter) other; 
		
		// if the family of this (ExtendedLetter) and the other ExtendedLetter are the same: 
		if (this.family == otherLetter.family) {
			this.related = true; 
		}
		
		// compares the content of the current ExntedLetter object and the other ExtendedLetter object 
		return this.content.equals(otherLetter.content); 	
	}
	
	
	@Override
	  public String toString() {
        if (label == UNUSED && related) {		// check if the label value is unused 
            return "." + content + ".";
            
        } else {
        	// return the content with decorators from the superclass 
            return super.decorator() + content + super.decorator();		
        }
    }
	
	/**
	 * Creates an array of ExtendedLetter objects from the string content and family codes  
	 * @param content The array of strings that contains the content of the extended letters 
	 * @param codes The array of integers that contain the family codes of the extended letter
	 * @return The array of Extended Letter objects 
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		
		// create an array of Letter objects: 
		Letter[] letters = new Letter[content.length];		// using size of the array content
		
		for (int i = 0; i < content.length; i++) {
			if (codes == null) {		// if code is null: 
				letters[i] = new ExtendedLetter(content[i]); 		// create an ExtendedLetter object and store it in letters[i] 
			}
			
			else {
				// create an ExtendedLEtter object with the appropriate family code and store it in letters[i] 
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		
		return letters; 	// return the array of ExtendedLetter objects 
	}
	
	
	
}
