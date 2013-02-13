import java.util.ArrayList;
//import java.util.ArrayDeque;
//import java.util.Iterator;

/**
 * Class trie A trie has a root TrieNode which is null Each immediate child of the
 * root TrieNode represents the beginning of a word If we tranverse a trie from the
 * root to a leaf, we have a word
 * 
 * AUTHOR: GiangPham LAST UPDATED: Jan 24th, 2013
 */
public class Trie{


	public TrieNode root; // root of the trie
	public TrieIterator currIte = new TrieIterator();
	//public ArrayDeque<Pair> visit = new ArrayDeque<Pair>();


	public Trie() {
		root = new TrieNode(); // initialize root to a new TrieNode
	}

	/*
	 * PURPOSE: add a new word to the trie 
	 * PARAMS: 
	 *  newWord: the word is to be added to the trie 
	 * ALGORITHMS: go through each character in the new word
	 * and check if they exist in the trie, each character has to be the
	 * children of the one before it. As soon as a character isn't a child, add
	 * it to the children list.
	 */
	public boolean add(String newWord) {
		if (root.findWord(newWord))
			return false;
		else{			
			root.addWord(newWord);
			return true;
		}
	}

	/*
	 * PURPOSE: determine if a word exists in a trie 
	 * PARAMS: 
	 *  word: the word that the program is looking for 
	 * ALGORITHM: check if the first letter is the immediate child of the root 
	 * if it is, then move on and check each letter.	
	 */
	public boolean find(String word) {
		return root.findWord(word);
	}

	public ArrayList<String> getWordsWithSubstring(String letters){
//		TrieIterator currIte = new TrieIterator();
		ArrayList<String> resultList = new ArrayList<String>();
		currIte.startIterator(root);
		String currWord;

		while (currIte.hasNext()){
			currWord = currIte.next();
			if (currWord.contains(letters)){
				resultList.add(currWord);
			}
		}

		for (int i = 0 ; i < resultList.size(); i++)
			System.out.println(resultList.get(i));

		return resultList;
	}

	public ArrayList<String> getAllWords(){
//		TrieIterator currIte = new TrieIterator();
		ArrayList<String> resultList = new ArrayList<String>();
		currIte.startIterator(root);

		while (currIte.hasNext()){
			resultList.add(currIte.next());
		}

		for (int i = 0 ; i < resultList.size(); i++)
			System.out.println(resultList.get(i));

		return resultList;
	} 

	public String toString(){
		//ArrayList<String> resultList = new ArrayList<String>();
//		TrieIterator currIte = new TrieIterator();
		String resultString = "";
		currIte.startIterator(root);
		while(currIte.hasNext()){
			resultString += currIte.next() + "\n";
		}

		System.out.print(resultString);

		return resultString;
	}

	public ArrayList<String> accept(Visitor aVisitor){
		return aVisitor.visitTrieNode(this);
	}
}

