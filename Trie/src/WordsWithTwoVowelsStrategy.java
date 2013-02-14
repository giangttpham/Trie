import java.util.ArrayList;
import java.util.Iterator;

public class WordsWithTwoVowelsStrategy extends Strategy{

	char[] vowels;
	
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
		String currStr;
		ArrayList<String> result = new ArrayList<String>();
		Iterator<String> currIte = currTrie.iterator();
		
		while(currIte.hasNext()){  //iterate through the currTrie
			currStr = currIte.next();
			if (containTwoVowels(currStr)){  //check if each word has more than 2 vowels
				result.add(currStr);  //if true, add it to result
			}
		}

		return result;
	}
	
	//check if a character is a vowel
	public boolean isVowel(char currChar){
		for (int i = 0; i < 5; i++){
			if (currChar == vowels[i]) //true if the character matches any of the vowels
				return true;  
		}
		
		return false;		
	}
	
	//check if a word contains more than 2 vowels
	public boolean containTwoVowels(String word){
		int count = 0;
		
		for (int i =0; i< word.length();i++){
			if (isVowel(word.charAt(i))) //get each character and check if its a vowel
				count++;
			if (count > 2) //true as soon as we hit more than 2 vowels
				return true;
		}
		
		return false;			
	}
}
