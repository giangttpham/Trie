public class WordsWithSubstringStrategy extends Strategy {

	String letters;
	
	public WordsWithSubstringStrategy(String substring){
		letters = substring;
	}
	
	@Override
	boolean getAlgorithm(Visitor currVisitor, String word) {
		//strategy to call the function to return words with the substring
		
		if (word.contains(letters))
			return true;
		else 
			return false;
	}
}
