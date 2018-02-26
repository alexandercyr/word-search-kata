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
		if (lines.length > 1) {
			for(int i = 1; i< lines.length; i++) {
				wordTable.add(( new ArrayList<String>(Arrays.asList(lines[i].split(",")))));
			}
		}
	}

	public void findAllMatches() {
		String firstCharacters = "";
		for(int i = 0; i < wordList.size(); i++) {
			firstCharacters = firstCharacters + wordList.get(i).charAt(0);
		}
		System.out.println(firstCharacters);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				String letterAtIndex = rowOfLetters.get(j);
				int letterInWordListIndex = firstCharacters.indexOf(letterAtIndex);
				if (letterInWordListIndex >= 0) {
					while(letterInWordListIndex >= 0) {
						System.out.println(letterAtIndex + ": ("+ j+", "+i+")");
						//findHoriz()
						//findVert()
						//findDiag()
						letterInWordListIndex = firstCharacters.indexOf(letterAtIndex, letterInWordListIndex+1);     
					}
				}
			}
		}
	}
	public String findHoriz(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size() - word.length() + 1; j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j)
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(rowOfLetters.get(j + x))){
								found = found + "(" + (j + x) + "," +  i + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
						}
				}
			}
		}
		return "Not found horizontally.";
	}

	public String findVert(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			for(int j = 0; j < wordTable.get(i).size() - word.length() + 1; j++) {
				ArrayList<String> rowOfLetters = wordTable.get(j);

				if(letter.equalsIgnoreCase(rowOfLetters.get(i))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - i) {

						for(int y = 0; y < word.length(); y++) {

							String letterAtIndex = "" + word.charAt(y);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(j+y).get(i))){
								found = found + "(" + i + "," +  (j+y) + ")";
								if (y == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}

						}
					}
				}
			}
		}
		return "Not found vertically.";
	}
	
	public String findDiagDescending(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size() - word.length() + 1; j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j && word.length() <= rowOfLetters.size() - i)
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i+x).get(j+x))){
								found = found + "(" + (j + x) + "," +  (i+x) + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
						}
				}
			}
		}
		
		return "Not found diagonally descending.";
	}
	public String findDiagAscending(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size() - word.length() + 1; j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j && word.length() <=  (i+1))
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i-x).get(j+x))){
								found = found + "(" + (j + x) + "," +  (i-x) + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							System.out.println(found);

						}

				}
			}
		}
		
		return "Not found diagonally ascending.";
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
