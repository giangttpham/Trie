import java.util.ArrayList;

//visitor to decide between strategies
public class StrategyVisitor extends Visitor {
	Strategy currStra;
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<TrieNode> currTrie = new ArrayList<TrieNode>();
	
	public StrategyVisitor(Strategy newStra){
		currStra = newStra; //get the strategy passed in to the constructor
	}

	@Override
	public void visitWordNode(TrieNode node) {
		//overwrite the word node method from the visitor superclass
		getChildren(node);
		String currStr = "" + node.nContent;
		while (node.parent != null){ //get each word
			node = node.parent;
			currStr = node.nContent + currStr;
		}
		if (accept(currStr)) //invoke the appropriate strategy
			result.add(currStr);
	}
	
	//function used to invoke strategy
	public boolean accept(String word){
		return currStra.getAlgorithm(this,word);
	}
}
