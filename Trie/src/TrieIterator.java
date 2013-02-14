
import java.util.ArrayDeque;
import java.util.Iterator;

public class TrieIterator implements Iterator<String> {

	TrieNode top;
	ArrayDeque<TrieNode> currTrie = new ArrayDeque<TrieNode>();
	
	public TrieIterator(TrieNode node){
		top = node;
		currTrie.push(top);
	}
	
//	public void startIterator(TrieNode node){
//		top = node;
//		if (top.children != null)
//			getWords(currTrie,"",top);
//	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(!currTrie.isEmpty())
			return true;
		else
			return false;
	
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		//return currTrie.pop();
		TrieNode currNode = new TrieNode();
		currNode = currTrie.pop();
		boolean isWord = false;
		
		while (isWord == false){
			//			while(currNode == null)
			currNode = currTrie.pop();
			for(int i = 0; i < 26; i++)
				if (currNode.children[i] != null)
					currTrie.push(currNode.children[i]);

			isWord = currNode.endOfWord;

		}

		return getWord(currNode);
		
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	
//	public void getWords(ArrayDeque<String> result, String currStr, TrieNode currNode) {
//		TrieNode currChild; // Holds each child of the current TrieNode
//
//		currStr += currNode.nContent; //append the each character to make a word
//		
//		//go through each TrieNode and recursively call the function
//		for (int i = 0; i < 26; i++) { 
//			currChild = currNode.children[i];
//			if (currChild != null)
//				getWords(result, currStr, currChild);
//		}
//
//		// if we hit a word that contains the letters
//		if (currNode.endOfWord) 
//			result.add(currStr);
//	}
	
	public String getWord(TrieNode node){
		String currStr = "" + node.nContent;
		
		while (node.parent != null){
			node = node.parent;
			currStr = node.nContent + currStr;
		}
		
		return currStr;
	}
	

}
