import java.util.ArrayList;


public class AllWordsVisitor extends Visitor{

//	ArrayList<String> result = new ArrayList<String>();
	
	@Override
	public ArrayList<String> visitTrieNode(Trie currTrie) {
		// TODO Auto-generated method stub
		return currTrie.getAllWords();
	}

}
