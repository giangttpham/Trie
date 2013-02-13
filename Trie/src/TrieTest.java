import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TrieTest {

	Trie testTrie = new Trie();
	@Before
	public void setUp() throws Exception {
		testTrie.add("call");
		testTrie.add("recalling");
		testTrie.add("hello");
		testTrie.add("setup");
		testTrie.add("attacking");
		testTrie.add("back");
		testTrie.add("cake");
	}

	@After
	public void tearDown() throws Exception {
		testTrie = new Trie();
	}

//	@Test
//	public void testTrie() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testAddWord() {
		String newWord = "test";
		testTrie.add(newWord);
		
		assertTrue(testTrie.find(newWord));
	}

	@Test
	public void testFindWord() {
		String currWord = "attacking";
		assertTrue(testTrie.find(currWord));
	}

	
	@Test
	public void testPrintWordsContainSubstring() {
		String substring = "ck";
		ArrayList<String> resultList = new ArrayList<String>();
		
		resultList = testTrie.getWordsWithSubstring(substring);
		
		assertTrue(resultList.size() == 2);
	}

	@Test
	public void testToString() {
		//ArrayList<String> resultList = new ArrayList<String>();
		String resultString;
		resultString = testTrie.toString();
		
		assertTrue(!resultString.isEmpty());
		
	}

}
