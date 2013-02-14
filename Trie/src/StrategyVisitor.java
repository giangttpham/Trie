import java.util.ArrayList;

//visitor to decide between strategies
public class StrategyVisitor extends Visitor {
	Strategy currStra;
	Trie aTrie;
	
	public StrategyVisitor(Strategy newStra){
		currStra = newStra; //get the strategy passed in to the constructor
	}
	@Override
	ArrayList<String> visitTrieNode(Trie currTrie) {
		aTrie = currTrie;
		return accept(); 
	}
	
	//invoke the appropriate strategy
	public ArrayList<String> accept(){
		return currStra.getAlgorithm(this,aTrie);
	}
}
