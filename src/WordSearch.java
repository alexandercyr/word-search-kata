import java.util.ArrayList;
import java.util.Arrays;

/**
 * WordSearch
 * @author alexcyr
 *
 */

public class WordSearch {
	ArrayList <String> wordList = new ArrayList<String>();
	ArrayList<ArrayList<String>> wordTable = new ArrayList<ArrayList<String>>();
	
	public WordSearch() {
		
	}
	
	public void populateSearch(String txt) {
		String[] lines = txt.split("\n");
		setWordList( new ArrayList<String>(Arrays.asList(lines[0].split(","))));
	}

	public ArrayList<String> getWordList() {
		return wordList;
	}

	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}

	public ArrayList<ArrayList<String>> getWordTable() {
		return wordTable;
	}

	public void setWordTable(ArrayList<ArrayList<String>> wordTable) {
		this.wordTable = wordTable;
	}
}
