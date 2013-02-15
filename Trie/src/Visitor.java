import java.util.ArrayList;

//visitor pattern
public class Visitor {
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<TrieNode> currTrie = new ArrayList<TrieNode>();
	
	void visitRootNode(TrieNode node){
		TrieNode currNode;
		getChildren(node); //get all the children of root
		
		while (!currTrie.isEmpty()){
			currNode = currTrie.get(0);
			currTrie.remove(0);
			
			//go through the stack and call the appropriate function
			if (!currNode.endOfWord)
				visitNonWordNode(currNode);
			else
				visitWordNode(currNode);
		}
	}
	
	//if a node is non-word, just add all the children
	public void visitNonWordNode(TrieNode node){
		getChildren(node);
	}
	
	//this fuction will be over ridden based on the visitor
	public void visitWordNode(TrieNode node){};
	
	//push all children of the current node on the stack
	public void getChildren(TrieNode node){
		for (int i = 0; i < 26; i++){
			if (node.children[i] != null)
				currTrie.add(0,node.children[i]);
		}
	}
}
