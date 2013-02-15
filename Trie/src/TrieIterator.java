
import java.util.ArrayList;
import java.util.Iterator;

public class TrieIterator implements Iterator<String> {

	TrieNode top;
	ArrayList<TrieNode> currTrie = new ArrayList<TrieNode>();
	
	public TrieIterator(TrieNode node){
		top = node;
		currTrie.add(top);
	}
	
	@Override
	public boolean hasNext() {
		if(!currTrie.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public String next() {
		TrieNode currNode = new TrieNode();
		boolean isWord = false;

		while (isWord == false){  //if the current character isn't end of word
			currNode = currTrie.get(0);
			currTrie.remove(0); //pop the character of the top of stack
			for(int i = 0; i < 26; i++) //push all its children on the stack
				if (currNode.children[i] != null)
					currTrie.add(0,currNode.children[i]);

			isWord = currNode.endOfWord; //check if its end of word
		}

		return getWord(currNode);  //if a word is hit
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub	
	}
	
	//return a word from the current node
	public String getWord(TrieNode node){
		String currStr = "" + node.nContent;
		
		while (node.parent != null){  //trace back from the current node
			node = node.parent;
			currStr = node.nContent + currStr; //and create the word
		}
		
		return currStr;
	}
}
