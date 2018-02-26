import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * WordSearchTest
 * @author alexcyr
 *
 */

public class WordSearchTest {
	
	WordSearch wordSearch = new WordSearch();
	String txtWordSearch = "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA\n" + 
			"U,M,K,H,U,L,K,I,N,V,J,O,C,W,E\n" + 
			"L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G\n" + 
			"H,S,U,P,J,P,R,J,D,H,S,B,X,T,G\n" + 
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
		System.out.println(wordSearch.getWordList().toString());
		assertEquals("[one, two, three]", wordSearch.getWordList().toString());

		
	}
}
