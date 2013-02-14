import java.util.ArrayList;

//visitor pattern
public abstract class Visitor {
	abstract ArrayList<String> visitTrieNode(Trie currTrie);
}
