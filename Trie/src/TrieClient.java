import java.util.ArrayList;


/********************************************************************
 * AUTHOR: Giang Pham
 * DATE: Jan 24th, 2013
 * CS635 - Assignment 1
 * This assignment implements the trie structure with some basic
 * functions such as add words and find words, print words, etc...
 ********************************************************************/

/**
 * Class Client tests all the functions of class Trie and Node
 * 
 * AUTHOR: Giang Pham
 * LAST UPDATED: Jan 24th, 2013
 */
public class TrieClient {
	/*
	 * Main function is the starting point of the program
	 */

	public static void main(String[] args) {
		//create new trie
		Trie testTrie = new Trie();
		ArrayList<String> result;
		
		//insert words into the trie
		testTrie.add("call");
		testTrie.add("recalling");
		testTrie.add("hello");
		testTrie.add("setup");
		testTrie.add("attacking");
		testTrie.add("back");
		testTrie.add("cake");

		//search for the word "set"
		if (testTrie.find("set"))
			System.out.println("Found \"set\" ");
		else{
			System.out.println("Didn't find \"set\"");
			testTrie.add("set");
			System.out.println("Added \"set\" ");
		}
		
		//get all the words that contain letters "ck"
		System.out.println("All the wods that contain \"ck\"");
		testTrie.getWordsWithSubstring("ck");

		//print all function
		System.out.println("All the words in the trie");
		testTrie.toString();

//		AllWordsVisitor testPrintAll = new AllWordsVisitor();
//		WordsWithSubstringVisitor testPrint = new WordsWithSubstringVisitor("ck");
//		WordsWithTwoVowelsStrategy testTwoVowels = new WordsWithTwoVowelsStrategy();
//		StrategyVisitor testStra = new StrategyVisitor(testTwoVowels);
		//result = testTrie.accept(testPrintAll);
		//testTrie.accept(testPrint);
//		result = testTrie.accept(testStra);
		System.exit(0);
	}
}
