import java.util.ArrayList;


public abstract class Strategy {
	abstract ArrayList<String> getAlgorithm(Visitor aVisitor, Trie aTrie);
//	abstract void setStrategyVisitor(Visitor aVisitor);
}
