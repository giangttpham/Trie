
public class WordNode extends TrieNode {
	public void accept(Visitor aVisitor){
		aVisitor.visitWordNode(this);
	}
}
