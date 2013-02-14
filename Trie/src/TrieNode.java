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

	
	char nContent; 			//The character that each TrieNode holds
	boolean endOfWord;		//Indicates if this TrieNode is the end of a word
	TrieNode[] children;//List of all the characters followed the current character
	TrieNode parent;  //reference to parent node
	
	public TrieNode(){
		endOfWord = false;					
		children = new TrieNode[26];	
	}

	public TrieNode(char newChar){
		nContent = newChar;					
		endOfWord = false;					
		children = new TrieNode[26];	
	
	}
	
	public void addWord(String word) {
		if (word.length() == 0 ) {
			endOfWord = true;
			return;
		}
		TrieNode forWord = addNode(word); //get first charater and add it to trie
		forWord.parent = this;
		forWord.addWord(word.substring(1)); //keep calling itself until the whole word is added
	}
	
	private TrieNode addNode(String word) {
		char c = word.charAt(0);
		int index = c - 'a';
		if (children[index] == null)
			children[index] = new TrieNode(c); //insert the new character into the correct position
		return children[index]; 
	}
	
	
	public TrieNode findNode(char currChar){
		int index = currChar - 'a';
		return children[index];		//return matching node
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
	
	


}

