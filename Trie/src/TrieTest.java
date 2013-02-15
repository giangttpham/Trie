import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

	Trie testTrie;
	ArrayList<String> result = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		testTrie = new Trie();
		testTrie.add("call");
		testTrie.add("recalling");
		testTrie.add("hello");
		testTrie.add("thermometer");
		testTrie.add("setup");
		testTrie.add("attacking");
		testTrie.add("back");
		testTrie.add("cake");
		testTrie.add("they");
	}

	@After
	public void tearDown() throws Exception {
		testTrie = new Trie();
		result = new ArrayList<String>();
	}

	@Test
	public void testAdd() {
		String addWord = "baby";
		testTrie.add(addWord);
		assertTrue(testTrie.find(addWord));
	}

	@Test
	public void testFind() {
		String findWord = "they";
		assertTrue(testTrie.find(findWord));
	}

	@Test
	public void testGetWordsWithSubstring() {
		String substring = "ck";
		
		result = testTrie.getWordsWithSubstring(substring);
		printToScreen("Words With Substring \"ck\" Using Iterator",result);
		assertTrue(result.size() == 2);
	}

	@Test
	public void testToString() {
		String result;
		result = testTrie.toString();
		//displaying string for confirmation purpose only
		System.out.println(result);
		System.out.println();
	}

	@Test
	public void testAllWordsVisitor() {
		AllWordsVisitor testVisitor = new AllWordsVisitor();
		RootNode testNode = new RootNode(testTrie.root);

		testNode.accept(testVisitor);
		result = testVisitor.result;

		printToScreen("All Words Visitor",result);
		assertTrue(result.size() == 9);
	}
	
	@Test
	public void testWordsWithSubstringVisitor() {
		WordsWithSubstringVisitor testVisitor = new WordsWithSubstringVisitor("ck");
		//the visitor start from root of trie
		RootNode testNode = new RootNode(testTrie.root);

		testNode.accept(testVisitor);
		result = testVisitor.result;
		
		printToScreen("Words With Substring \"ck\" Visitor",result);
		assertTrue(result.size() == 2);
	}
	
	@Test
	public void testWordsWithSubstringStrategy() {
		WordsWithSubstringStrategy testStra = new WordsWithSubstringStrategy("th");
		StrategyVisitor testVisitor = new StrategyVisitor(testStra);
		//the visitor start from root of trie
		RootNode testNode = new RootNode(testTrie.root);
		
		testNode.accept(testVisitor);
		result = testVisitor.result;
		
		printToScreen("Words With Substring \"th\" Strategy",result);
		assertTrue(result.size() == 2);	
	}
	
	@Test
	public void testWordsWithTwoVowelsStrategy() {
		WordsWithTwoVowelsStrategy testStra = new WordsWithTwoVowelsStrategy();
		StrategyVisitor testVisitor = new StrategyVisitor(testStra);
		//the visitor start from root of trie
		RootNode testNode = new RootNode(testTrie.root);

		testNode.accept(testVisitor);
		result = testVisitor.result;
		
		printToScreen("Words With More Than 2 Vowels Strategy",result);
		assertTrue(result.size() == 3);
	}
	
	//this function is for displaying words to screen
	//it's for confirmation purpose only and doesn't affect any functionality
	//of the package
	public void printToScreen(String testName, ArrayList<String> result){
		System.out.println(testName);
		for (int i = 0; i< result.size(); i++)
			System.out.println(result.get(i));
		System.out.println();
	}
}
