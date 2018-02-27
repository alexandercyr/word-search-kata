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

	public String findAllMatches() {
		String firstCharacters = "";
		String foundWords = "";
		for(int i = 0; i < wordList.size(); i++) {
			firstCharacters = firstCharacters + wordList.get(i).charAt(0);
		}
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				String letterAtIndex = rowOfLetters.get(j);
				int letterInWordListIndex = firstCharacters.indexOf(letterAtIndex);
				if (letterInWordListIndex >= 0) {
					while(letterInWordListIndex >= 0) {
						String word = wordList.get(letterInWordListIndex);
						foundWords = foundWords + findHoriz(word, j, i);
						foundWords = foundWords + findVert(word, j, i);
						foundWords = foundWords + findDiag(word, j, i);
						letterInWordListIndex = firstCharacters.indexOf(letterAtIndex, letterInWordListIndex+1);     
					}
				}
			}
		}
		System.out.println(foundWords);
		return foundWords;
	}
	public String findHoriz(String word, int x, int y) {
		
		if(word.length() <= wordTable.size() - x) {
			String found = word + ": ";
			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y).get(x + i))){

					found = found + "(" + (x + i) + "," +  y + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		if(word.length() <= x+1){
			String found = word + ": ";
			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y).get(x - i))){
					found = found + "(" + (x - i) + "," +  y + ")";
					if (i == (word.length()-1)) {
						return found +"\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		return "";
	}
	public String findVert(String word, int x, int y) {
		if(word.length() <= wordTable.size() - y) {
			String found = word + ": ";
 
			for(int i = 0; i < word.length(); i++) {

				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(i+y).get(x))){
					found = found + "(" + x + "," +  (i+y) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}

			}
		}
		if(word.length() <= y + 1) {
			String found = word + ": ";
 
			for(int i = 0; i < word.length(); i++) {

				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y-i).get(x))){
					found = found + "(" + x + "," +  (y-i) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}

			}
		}
		return "";
	}
	public String findDiag(String word, int x, int y) {
		if(word.length() <= wordTable.size() - x && word.length() <= wordTable.size() - y) {
			String found = word + ": ";

			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y+i).get(x+i))){
					found = found + "(" + (x + i) + "," +  (y+i) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		if(word.length() <= wordTable.size() - x && word.length() <=  y+1) {
			String found = word + ": ";

			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y-i).get(x+i))){
					found = found + "(" + (x + i) + "," +  (y-i) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		
		if(word.length() <= 1 + x && word.length() <= 1 + y) {
			String found = word + ": ";

			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y-i).get(x-i))){
					found = found + "(" + (x - i) + "," +  (y-i) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		if(word.length() <= 1 + x && word.length() <= wordTable.size() - y) {
			String found = word + ": ";

			for(int i = 0; i < word.length(); i++) {
				String letterAtIndex = "" + word.charAt(i);
				if (letterAtIndex.equalsIgnoreCase(wordTable.get(y+i).get(x-i))){
					found = found + "(" + (x - i) + "," +  (y+i) + ")";
					if (i == (word.length()-1)) {
						return found + "\n";
					}
					else {
						found = found + ",";
					}
				}
				else {
					break;
				}
			}
		}
		return "";
	}
	
	public String findHoriz(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j) {
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
							else {
								break;
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
			for(int j = 0; j < wordTable.get(i).size(); j++) {
				ArrayList<String> rowOfLetters = wordTable.get(i);

				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - i) {

						for(int y = 0; y < word.length(); y++) {

							String letterAtIndex = "" + word.charAt(y);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i+y).get(j))){
								found = found + "(" + j + "," +  (i+y) + ")";
								if (y == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							else {
								break;
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
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j && word.length() <= rowOfLetters.size() - i) {
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
							else {
								break;
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
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= rowOfLetters.size() - j && word.length() <=  (i+1)) {
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
							else {
								break;
							}
						}
					}
				}
			}
		}
		
		return "Not found diagonally ascending.";
	}
	public String findHorizBackward(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= j+1) {
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(rowOfLetters.get(j - x))){
								found = found + "(" + (j - x) + "," +  i + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							else {
								break;
							}
						}
					}
				}
			}
		}
		return "Not found horizontally backwards.";
	}
	public String findVertBackward(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			for(int j = 0; j < wordTable.get(i).size(); j++) {
				ArrayList<String> rowOfLetters = wordTable.get(i);

				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= i+1) {

						for(int y = 0; y < word.length(); y++) {

							String letterAtIndex = "" + word.charAt(y);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i-y).get(j))){
								found = found + "(" + j + "," +  (i-y) + ")";
								if (y == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							else {
								break;
							}

						}
					}
				}
			}
		}
		return "Not found vertically backwards.";
	}
	public String findDiagDescendingBackward(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= j+1 && word.length() <= i+1) {
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i-x).get(j-x))){
								found = found + "(" + (j - x) + "," +  (i-x) + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							else {
								break;
							}
						}
					}
				}
			}
		}
		
		return "Not found diagonally descending backwards.";
	}
	public String findDiagAscendingBackward(String word) {
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					String found = word + ": ";
					if(word.length() <= j+1 && word.length() <=  rowOfLetters.size() - i) {
						for(int x = 0; x < word.length(); x++) {
							String letterAtIndex = "" + word.charAt(x);
							if (letterAtIndex.equalsIgnoreCase(wordTable.get(i+x).get(j-x))){
								found = found + "(" + (j - x) + "," +  (i+x) + ")";
								if (x == (word.length()-1)) {
									return found;
								}
								else {
									found = found + ",";
								}
							}
							else {
								break;
							}
						}
					}
				}
			}
		}
		
		return "Not found diagonally ascending backward.";
	}
	/*
	public ArrayList<String> findCharactersInTable(String word){
		ArrayList<String> letterCoords = new ArrayList<String>();
		String letter = "" + word.charAt(0);
		for(int i = 0; i < wordTable.size(); i++) {
			ArrayList<String> rowOfLetters = wordTable.get(i);
			for(int j = 0; j < rowOfLetters.size(); j++) {
				if(letter.equalsIgnoreCase(rowOfLetters.get(j))) {
					letterCoords.add(j + "," + i);
				}
			}
		}
		return letterCoords;
	}*/

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
