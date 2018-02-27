import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * WordSearchTest
 * @author alexcyr
 *
 */

public class WordSearchTest {
	
	WordSearch wordSearch = new WordSearch();
	String txtWordSearch = "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA,CAT\n" + 
			"U,M,K,H,U,L,K,I,N,V,J,O,C,W,T\n" + 
			"L,L,S,H,K,Z,Z,W,Z,C,G,J,U,A,G\n" + 
			"H,S,U,P,J,P,R,J,D,H,S,B,C,T,G\n" + 
			"B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E\n" + 
			"A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D\n" + 
			"S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F\n" + 
			"B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z\n" + 
			"O,K,R,I,K,A,M,M,R,M,F,B,A,P,P\n" + 
			"N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S\n" + 
			"E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K\n" + 
			"S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D\n" + 
			"T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K\n" + 
			"O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H\n" + 
			"W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S\n" + 
			"K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B";
	
	@Test
	public void getFirstLineOfWordsInitialTest() {
		wordSearch.populateSearch("one,two,three");
		assertEquals("[one, two, three]", wordSearch.getWordList().toString());
	}
	
	@Test
	public void getFirstLineOfWordsTestWithFullList() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("[BONES, KHAN, KIRK, SCOTTY, SPOCK, SULU, UHURA, CAT]", wordSearch.getWordList().toString());
	}
	
	@Test
	public void getFirstRowOfWordSearchTable() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("[U, M, K, H, U, L, K, I, N, V, J, O, C, W, T]", wordSearch.getWordTable().get(0).toString());
	}
	
	@Test
	public void getLastElementOfWordSearchTable() {
		wordSearch.populateSearch(txtWordSearch);
		ArrayList<ArrayList<String>> wordTable = wordSearch.getWordTable();
		assertEquals("B", wordTable.get(wordTable.size()-1).get(wordTable.size()-1).toString());
	}
	
	@Test
	public void findWordsOnTheXAxis() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)", wordSearch.findHoriz("SCOTTY"));
	}
	
	@Test
	public void findWordsOnTheYAxis() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)", wordSearch.findVert("BONES"));
	}
	
	@Test
	public void findWordsDiagDescending() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)", wordSearch.findDiagDescending("SPOCK"));
	}
	
	@Test 
	public void findWordsDiagAscending() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("CAT: (12,2),(13,1),(14,0)", wordSearch.findDiagAscending("CAT"));

	}
	
	@Test
	public void findWordsBackwardsOnTheXAxis() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("KIRK: (4,7),(3,7),(2,7),(1,7)", wordSearch.findHorizBackward("KIRK"));
	}
	
	@Test
	public void findWordsBackwardsOnTheYAxis() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("KHAN: (5,9),(5,8),(5,7),(5,6)", wordSearch.findVertBackward("KHAN"));
	}
	
	@Test
	public void findWordsBackwardDiagDescending() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("SULU: (3,3),(2,2),(1,1),(0,0)", wordSearch.findDiagDescendingBackward("SULU"));

	}
	
	@Test
	public void findWordsBackwardDiagAscending() {
		wordSearch.populateSearch(txtWordSearch);
		assertEquals("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)", wordSearch.findDiagAscendingBackward("UHURA"));
	}
	
	/*@Test
	public void iterateThroughTableToCheckMatchesForEachWordFirstCharacter() {
		wordSearch.populateSearch(txtWordSearch);
		wordSearch.findAllMatches();
	}*/
	
	
}
