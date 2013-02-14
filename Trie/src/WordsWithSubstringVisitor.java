import java.util.ArrayList;
import java.util.Iterator;

public class WordsWithSubstringVisitor extends Visitor{

	String letters;
	
	public WordsWithSubstringVisitor(String substring){
		letters = substring;
	}
	
	@Override
	ArrayList<String >visitTrieNode(Trie currTrie) {
		//visitor to print words with substring
		return currTrie.getWordsWithSubstring(letters);
	}

}
