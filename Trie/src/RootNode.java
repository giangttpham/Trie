
public class RootNode extends TrieNode{

	public RootNode (TrieNode node){
		//set itself to get all the information of the input node 
		nContent = node.nContent;
		parent = node.parent;
		endOfWord = node.endOfWord;
		
		for (int i = 0; i < 26; i++){
			children[i] = node.children[i];
		}
	}
	
//	@Override
	public void accept(Visitor aVisitor){
		aVisitor.visitRootNode(this);
	}
}
