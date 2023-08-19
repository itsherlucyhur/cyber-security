/**
 * The classes for this assignment implement a solution for word comparison using linked lists. 
 * The overall approach taken was to represent words as linked lists with each letter represented by nodes. 
 * The Word class creates a word as a linked list of Letter objects, and the WordLL class is used for the linked list of Word objects 
 * with methods to guess words and uses a string to represent all the guessed words in history.  
 * The Letter class represents a single letter, with its methods comparing, labeling,
 * and creating string representations of the letter, which the ExtendedLetter class extends as a child class.
 * 
 * I tested the classes implemented by using the provided test case file that checked the proper implementation of each classes, 
 * its functionality with the different methods including labeling, guessing words, and comparing letters accurately. 
 * A challenge was faced when testing the last case. When I printed out wll2, I realized that only the '.' (dots) weren't 
 * being printed out (e.g. -9H- instead of .9H.) The problem was in the private method, containsLetter in the Word class. 
 * The implementation of the equals() within this private helper method was modifying an instance variable, which normally goes against 
 * good programming practices. To fix this logic error, I had to reverse the order of calling equals between letter and currentLetter. 
 * Usually when you call an equals() method, the order shouldn't matter because we're just asking if they're the same or not. 
 * In this case, since it would change an instance variable, we wanted the change to happen on the guess word instead of the mystery word. 
 * Although calling equals() shouldn't normally change the objects being compared, this adjustment had to be made to align with the 
 * functionality of the code.  
 * 
 * @author chaejinhur
 *
 */
public class WordLL {
	
	// private variables 
	private Word mysteryWord; 
	private LinearNode<Word> history; 
	
	// constructor that initializes the history and mysteryWord variables 
	public WordLL(Word mystery) {
		this.history = null; 
		this.mysteryWord = mystery; 
	}
	
	/**
	 * This method tries to guess a word by comparing it with the mystery word. 
	 * @param guess The word to be guessed
	 * @return true if guess is the mystery word, and false if not.
	 */
	public boolean tryWord(Word guess) {
		// call the labelWord method of the guess object 
	    boolean labeled = guess.labelWord(mysteryWord);		// pass the mysteryWord as the parameter
	    
	    // create a new node containing the guess object to be passed to the linked list
	    LinearNode<Word> newNode = new LinearNode<>(guess);
	    newNode.setNext(history);
	    history = newNode;
	    
	   
	    return labeled;
	}
	


	/**
	 * This method creates a string representation of WordLL by traversing through
	 * the linked list history. 
	 */
	public String toString() {	
		StringBuilder string = new StringBuilder(); 
		
		// initialize pointer to track the current node starting from the history
		LinearNode<Word> currentNode = history; 
		
		// until current node is null 
		while (currentNode != null) {
	        string.append(currentNode.getElement().toString()).append("\n");
			currentNode = currentNode.getNext(); 	// update current node to the next node
		}
		
		return string.toString(); 
	}
}
