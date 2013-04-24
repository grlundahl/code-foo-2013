import java.util.ArrayList;
public class Letter{
	private char letter;
	private ArrayList<Letter> neighborLetters;

	public Letter(char letter){
		this.letter = letter;
	}

	public ArrayList<Letter> getNeighbors(){
		return neighborLetters;
	}

	public String toString(){
		return Character.toString(letter);
	}
	
	public void createNeighborList(Board wordSearch, int row, int col){
		int rSize, cSize;
		cSize = wordSearch.getLetters().size();
		rSize = wordSearch.getLetters().get(0).size();
		
		for (int r = 0; r < rSize; r++){
			for (int c = 0; c < cSize; c++){
				if(r == 0 && c == 0){
					//top left corner
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c + 1));
				}else if (r == 0 && c == cSize-1){
					//top right corner
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c - 1));
				}else if (r == 0){
					//top row no corners
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
				}else if (r == rSize - 1 && c == 0){
					//bottom left corner
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
				}else if (r == rSize - 1 && c == cSize - 1){
					//bottom right corner
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
				}else if (r == rSize - 1){
					//bottom row no corners
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
				}else if (c == 0){
					//left edge no corners
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
					
				}else if(c == cSize - 1){
					//right edge no corners
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
				}else{
					//middle of the board, no edges
					neighborLetters.add(wordSearch.getLetters().get(r).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c + 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c - 1));
					neighborLetters.add(wordSearch.getLetters().get(r - 1).get(c));
					neighborLetters.add(wordSearch.getLetters().get(r + 1).get(c));
				}
			}
		}
		
		
		
		return;
	}
}
