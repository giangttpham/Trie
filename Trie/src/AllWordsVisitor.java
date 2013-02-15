public class AllWordsVisitor extends Visitor{

	@Override
	public void visitWordNode(TrieNode node) {
		//overwrite the word node method from the visitor superclass
		getChildren(node);
		String currStr = "" + node.nContent;
		while (node.parent != null){ //add all word to the result list
			node = node.parent;
			currStr = node.nContent + currStr;
		}
		
		result.add(currStr);
	}
}
   