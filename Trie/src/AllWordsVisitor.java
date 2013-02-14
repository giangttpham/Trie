import java.util.ArrayList;

public class AllWordsVisitor extends Visitor{
	@Override
	public ArrayList<String> visitTrieNode(Trie currTrie) {
		return currTrie.getAllWords(); //call the function to get all the words in trie
	}

}
