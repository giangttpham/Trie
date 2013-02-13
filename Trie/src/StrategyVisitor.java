import java.util.ArrayList;


public class StrategyVisitor extends Visitor {

	Strategy currStra;
	Trie aTrie;
	ArrayList<String> result = new ArrayList<String>();
	
	public StrategyVisitor(Strategy newStra){
		currStra = newStra;
	}
	@Override
	ArrayList<String> visitTrieNode(Trie currTrie) {
		// TODO Auto-generated method stub
		aTrie = currTrie;
		return accept();
	}
	public ArrayList<String> accept(){
		return currStra.getAlgorithm(this,aTrie);
	}
}
