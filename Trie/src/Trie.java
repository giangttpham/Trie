import java.util.ArrayList;
//import java.util.ArrayDeque;
//import java.util.Iterator;
import java.util.Iterator;

/**
 * Class trie A trie has a root TrieNode which is null Each immediate child of the
 * root TrieNode represents the beginning of a word If we tranverse a trie from the
 * root to a leaf, we have a word
 * 
 * AUTHOR: GiangPham LAST UPDATED: Jan 24th, 2013
 */
public class Trie implements Iterable<String>{

	public TrieNode root; // root of the trie

	public Trie() {
		root = new TrieNode(); // initialize root to a new TrieNode
	}

	public boolean add(String newWord) {
		if (root.findWord(newWord)) //check if the word already exists
			return false;
		else{	//add if it doesn't exist		 
			root.addWord(newWord);
			return true;
		}
	}

	
	public boolean find(String word) {
		return root.findWord(word);
	}

	public ArrayList<String> getWordsWithSubstring(String letters){
		ArrayList<String> resultList = new ArrayList<String>();
		String currWord;
		Iterator<String> currIte = iterator();

		while (currIte.hasNext()){ //iterate through each word
			currWord = currIte.next();
			if (currWord.contains(letters)){  //if it contains the substring, add to result list
				resultList.add(currWord);
			}
		}

		return resultList;
	}

	public ArrayList<String> getAllWords(){
		ArrayList<String> resultList = new ArrayList<String>();
		String currWord;
		Iterator<String> currIte = iterator();

		while (currIte.hasNext()){ //iterate through each word
			currWord = currIte.next();
			resultList.add(currWord); //add to result list
		}

		return resultList;
	}
	
	//toString will return all the words into a string with a space between each word
	public String toString(){
		String resultString = "";
		Iterator<String> currIte = iterator();
		
		while(currIte.hasNext()) //iterate through each word and append it to the string
			resultString += currIte.next() + " ";

		return resultString;
	}

	//invoke the appropriate visitor
	public ArrayList<String> accept(Visitor aVisitor){
		return aVisitor.visitTrieNode(this);
	}

	//create the iterator for the trie
	@Override
	public Iterator<String> iterator() {
		TrieIterator currIte = new TrieIterator(root);
		return currIte;
	}
}

