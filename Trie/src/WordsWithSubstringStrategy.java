import java.util.ArrayList;


public class WordsWithSubstringStrategy extends Strategy {

	String letters;
	
	public WordsWithSubstringStrategy(String substring){
		letters = substring;
	}
	
	@Override
	ArrayList<String> getAlgorithm(Visitor currVisitor, Trie currTrie) {
		//strategy to call the function to return words with the substring
		return currTrie.getWordsWithSubstring(letters);
	}

}
