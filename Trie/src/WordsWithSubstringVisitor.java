public class WordsWithSubstringVisitor extends Visitor{

	String letters;
	
	public WordsWithSubstringVisitor(String substring){
		letters = substring;
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
		
		//if the word contains the substring add it to result
		if (currStr.contains(letters))
			result.add(currStr);
	}

}
