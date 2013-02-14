import java.util.ArrayList;

//strategy pattern
public abstract class Strategy {
	abstract ArrayList<String> getAlgorithm(Visitor aVisitor, Trie aTrie);
}
