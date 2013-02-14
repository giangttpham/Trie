import java.util.ArrayList;
import java.util.Iterator;


public class WordsWithTwoVowelsStrategy extends Strategy{

	char[] vowels;
	//Trie aTrie;
	
	public WordsWithTwoVowelsStrategy(){
		vowels = new char[5];
		vowels[0] = 'a';
		vowels[1] = 'e';
		vowels[2] = 'i';
		vowels[3] = 'o';
		vowels[4] = 'u';
	}
	
	
	@Override
	ArrayList<String> getAlgorithm(Visitor aVisitor, Trie currTrie) {
		// TODO Auto-generated method stub
		
		String currStr;
		ArrayList<String> result = new ArrayList<String>();
		
//		currTrie.currIte.startIterator(currTrie.root);
		Iterator<String> currIte = currTrie.iterator();
		
		while(currIte.hasNext()){
			currStr = currIte.next();
			if (containTwoVowels(currStr)){
				result.add(currStr);
			}
		}
		
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
		return result;
	}
	
	public boolean isVowel(char currChar){
		for (int i = 0; i < 5; i++){
			if (currChar == vowels[i])
				return true;
		}
		return false;
		
	}
	public boolean containTwoVowels(String word){
		int count = 0;
		for (int i =0; i< word.length();i++){
			
			if (isVowel(word.charAt(i)))
				count++;
			if (count == 2)
				return true;
		}
		return false;
			
	}




}
