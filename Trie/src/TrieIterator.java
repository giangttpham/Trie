import java.util.ArrayDeque;
import java.util.Iterator;

public class TrieIterator implements Iterator<String> {

	TrieNode top;
	ArrayDeque<String> wholeTrie = new ArrayDeque<String>();
	
	public TrieIterator(){
		top = null;
	}
	
	public void startIterator(TrieNode node){
		top = node;
		if (top.children != null)
			getWords(wholeTrie,"",top);
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(!wholeTrie.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return wholeTrie.pop();
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void getWords(ArrayDeque<String> result, String currStr, TrieNode currNode) {
		TrieNode currChild; // Holds each child of the current TrieNode

		currStr += currNode.nContent; //append the each character to make a word
		
		//go through each TrieNode and recursively call the function
		for (int i = 0; i < 26; i++) { 
			currChild = currNode.children[i];
			if (currChild != null)
				getWords(result, currStr, currChild);
		}

		// if we hit a word that contains the letters
		if (currNode.endOfWord) 
			result.add(currStr);
	}
	

}
