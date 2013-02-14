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
		assertTrue(result.size() == 2);
	}

	@Test
	public void testToString() {
		String result;
		result = testTrie.toString();
		System.out.println(result);
	}

	@Test
	public void testAllWordsVisitor() {
		AllWordsVisitor testVisitor = new AllWordsVisitor();
		
		result = testTrie.accept(testVisitor);
		assertTrue(result.size() == 9);
	}
	
	@Test
	public void testWordsWithSubstringVisitor() {
		WordsWithSubstringVisitor testVisitor = new WordsWithSubstringVisitor("ck");
		
		result = testTrie.accept(testVisitor);
		assertTrue(result.size() == 2);
	}
	
	@Test
	public void testWordsWithSubstringStrategy() {
		WordsWithSubstringStrategy testStra = new WordsWithSubstringStrategy("th");
		StrategyVisitor testVisitor = new StrategyVisitor(testStra);
		
		result = testTrie.accept(testVisitor);
		assertTrue(result.size() == 2);
		
	}
	
	@Test
	public void testWordsWithTwoVowelsStrategy() {
		WordsWithTwoVowelsStrategy testStra = new WordsWithTwoVowelsStrategy();
		StrategyVisitor testVisitor = new StrategyVisitor(testStra);
		result = testTrie.accept(testVisitor);
		assertTrue(result.size() == 3);
	}
//	@Test
//	public void testAccept() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIterator() {
//		fail("Not yet implemented");
//	}

}
