
public class NonWordNode extends TrieNode{
	public void accept(Visitor aVisitor){
		aVisitor.visitNonWordNode(this);
	}
}
