import java.util.ArrayList;

public class WordsWithSubstringVisitor extends Visitor{

	String letters;
	ArrayList<String> result = new ArrayList<String>();
	
	public WordsWithSubstringVisitor(String substring){
		letters = substring;
	}
	@Override
	ArrayList<String >visitTrieNode(Trie currTrie) {
		// TODO Auto-generated method stub
		return currTrie.getWordsWithSubstring(letters);
	}

}
