//import java.util.ArrayList;

/**
 * Class TrieNode represents each TrieNode in a trie.
 * Each TrieNode holds a character and a list of character following it
 * If a TrieNode is represent the end of a word, it's marked
 * 
 * AUTHOR: Giang Pham
 * LAST UPDATED: Jan 24th, 2013
 */
public class TrieNode {

	/*************************************DATA MEMBERS**********************************/
	char nContent; 			//The character that each TrieNode holds
	boolean endOfWord;		//Indicates if this TrieNode is the end of a word
	TrieNode[] children;//List of all the characters followed the current character
	TrieNode parent;
	
	/***********************************METHOD FUNCTIONS********************************/
	/*
	 * PURPOSE: default constructor
	 */
	public TrieNode(){
		endOfWord = false;					//Assume the new TrieNode isn't the end of a word
		children = new TrieNode[26];	//Instantiate the children list
		//parent = new TrieNode();
	}

	/*
	 * PURPOSE: constructor to create a new TrieNode with a given character
	 * PARAMS: 
	 * 	newChar: input character
	 */
	public TrieNode(char newChar){
		nContent = newChar;					//Set content to the given character
		endOfWord = false;					//Assume the new TrieNode isn't the end of a word
		children = new TrieNode[26];	//Instantiate the children list
		//parent = new TrieNode();		//initialize the parent node to null
	}
	
	public void addWord(String word) {
		if (word.length() == 0 ) {
			endOfWord = true;
			return;
		}
		TrieNode forWord = nodeFor(word);
		forWord.parent = this;
		forWord.addWord(word.substring(1));
	}
	
	private TrieNode nodeFor(String word) {
		char c = word.charAt(0);
		int index = c - 'a';
		if (children[index] == null)
			children[index] = new TrieNode(c);
		return children[index];
	}
	
	/*
	 * PURPOSE: determine if a character is a child of the current TrieNode
	 * PARAMS:
	 * 	currChar: the character the program is looking for
	 * ALGORITHM: the function goes through the children list of the current TrieNode
	 * and looks at each child. If the content of any child matches the given
	 * character, the function will return that child TrieNode. If not, it'll return null.
	 */
	public TrieNode findNode(char currChar){
		int index = currChar - 'a';
		return children[index];								//if none of the child matches, return null
	}
	
	public boolean findWord(String word){
		TrieNode currNode = this;
		// loop through each character of the word
		for (int i = 0; i < word.length(); i++) { 
			//get the child that matches the char
			currNode = currNode.findNode(word.charAt(i)); 
			if (currNode == null) // if the character isn't found
				return false;
		}

		if (currNode.endOfWord) //if the last character doesn't mark a word 
			return true;
		else
			return false;
	}
	
	public TrieNode findNextChild(char currChild){
		int i;
		
		for (i = currChild - 'a'+1; i < 26; i++){
			if (children[i] != null)
				return children[i];
		}
		
		return null;
	}
	
	public TrieNode findFirstChild(){
		
		for (int i = 0; i < 26; i++){
			if (children[i] != null)
				return children[i];
		}
		return null;
		
	}

}

