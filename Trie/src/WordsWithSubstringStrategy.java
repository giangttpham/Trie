import java.util.ArrayList;


public class WordsWithSubstringStrategy extends Strategy {

	//ArrayList<String> result = new ArrayList<String>();
	String letters;
	
	public WordsWithSubstringStrategy(String substring){
		letters = substring;
	}
	
	@Override
	ArrayList<String> getAlgorithm(Visitor currVisitor, Trie currTrie) {
		// TODO Auto-generated method stub
		return currTrie.getWordsWithSubstring(letters);
		
	}

}
