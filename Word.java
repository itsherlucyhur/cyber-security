/**
 * This class represents a word as a linked list using Letter objects. 
 * Uses methods for creating a word, converting it to a string. 
 * labeling it by comparing it with a mystery word, and checking if a letter is contained in the word. 
 * @author chaejinhur
 *
 */
public class Word {
	// private variable 
	private LinearNode<Letter> firstLetter; 
		
	
	/**
	 * constructor for the Word class that 
	 * initializes the Word object with an array of letters   
	 * @param letters an array of letters in the word 
	 */
	public Word(Letter[] letters) {
		if (letters.length >0) {
			this.firstLetter = new LinearNode<> (letters[0]); 
			LinearNode<Letter> currentNode = firstLetter; 
			
	        for (int i = 1; i < letters.length; i++) {
				// create new LinearNode objects for each objects in the letters array 
				LinearNode<Letter> newNode = new LinearNode<>(letters[i]); 
				currentNode.setNext(newNode);
				currentNode = newNode;  
			 }
		} 	
		
	} 
	

	/**
	 * returns a string representation of the word 
	 * @return word as a string 
	 */
	public String toString() {
		StringBuilder word = new StringBuilder("Word: ");

	    LinearNode<Letter> currentNode = firstLetter;

	    while (currentNode != null) {
	        word.append(currentNode.getElement().toString()).append(' ');
	        currentNode = currentNode.getNext();
	    }

	    return word.toString(); 
	}
	
	
	/**
	 * Labels the Word by comparing it with a mystery word 
	 * @param mystery The mystery word 
	 * @return true if word is the same as the mystery word, false if not. 
	 */
	public boolean labelWord(Word mystery) {
		 LinearNode<Letter> currentNode = firstLetter;
		 LinearNode<Letter> mysteryNode = mystery.firstLetter;

		 boolean identical = true;

		 
		 // compare each letter of the current word with each letter in the mystery word 
		 while (currentNode != null && mysteryNode != null) {
		     Letter currentLetter = currentNode.getElement();
		     Letter mysteryLetter = mysteryNode.getElement();
		     
		     
		     if (mystery.containsLetter(currentLetter)) {
		    	 // if mystery word contains the current letter: 
	                if (currentLetter.equals(mysteryLetter)) {
	                    currentLetter.setCorrect();		// set the current letter as correct 
	              
	                // if the current letter isn't in the correct position:     
	                } else {
	                    currentLetter.setUsed();		// set the current letter as used 
	                    identical = false;				// the word isn't the same as the mystery word 
	                }
	            
	            // if not current letter isn't in the mystery word:     
	            } else {
	                currentLetter.setUnused();		// set the current letter as unused 
	                identical = false;				// word isn't the same as mystery word 
	            }
		     
		     	currentNode = currentNode.getNext();	// update pointer to the next node in current word 
	            mysteryNode = mysteryNode.getNext();	// update pointer to the next node in mystery word 
	        }

		 	while (currentNode != null) {
		 		// if mystery word contains the letter from the current node of current word: 
		 		if (mystery.containsLetter(currentNode.getElement())) {
		 			currentNode.getElement().setUsed();			// set current letter as used 
		 		}

		 		else { 	
		 			currentNode.getElement().setUnused(); 		// set current letter as unused 
		 		}
		 		
		 		identical = false; 
		 		currentNode = currentNode.getNext();	// update pointer to next node in the current word 
		 	}		
		
		 return identical; 
	}
	
	
	/**
	 * checks if the given letter is contained in the word. 
	 * @param letter The letter to be checked 
	 * @return true if letter is found in the word, false if not. 
	 */
	private boolean containsLetter(Letter letter) {
	    LinearNode<Letter> currentNode = firstLetter;
	    
	    while (currentNode != null) {
	        Letter currentLetter = currentNode.getElement();
	        
	        // if the letter is found in the current word: 
	        if (letter.equals(currentLetter)) {
	        	letter.equals(currentLetter); 
	            return true;	
	        }
	        currentNode = currentNode.getNext();
	    }
	    
	    // if the letter isn't found in the current word: 
	    return false; 		
        
        
	}

}
