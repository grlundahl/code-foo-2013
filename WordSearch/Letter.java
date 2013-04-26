import java.util.ArrayList;
/**
 *@author Greg Lundahl
 */
public class Letter{
	private char letter;
	private ArrayList<Neighbor> neighborLetters = new ArrayList<Neighbor>();

	/**
	 *Constructor of the Letter class
	 * @param char
	 */
	public Letter(char letter){
		this.letter = letter;
	}

	/**
	 * Returns the ArrayList of Neighbors for the letter
	 * @return ArrayList<Neighbor>
	 */
	public ArrayList<Neighbor> getNeighbors(){
		return neighborLetters;
	}

	/**
	 *Returns a String representation of the Letter
	 * @return String
	 */
	public String toString(){
		return Character.toString(letter);
	}

	/**
	 * returns the letter of the Letter
	 * @return char
	 */
	public char getLetter(){
		return letter;
	}

	/**
	 *Creates the neighbor list for the individual Letter
	 *@param Board 
	 *@param int
	 *@param int
	 */
	public void createNeighborList(Board wordSearch, int row, int col){
		int rSize, cSize;
		cSize = wordSearch.getLetters().size();
		rSize = wordSearch.getLetters().get(0).size();
		ArrayList<ArrayList<Letter>> letters = wordSearch.getLetters();

		if(row == 0 && col == 0){
			//top left corner
			//System.out.println("1");
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
			neighborLetters.add(new Neighbor('c', letters.get(col + 1).get(row + 1)));
		}else if (row == 0 && col == cSize-1){
			//top right corner
			//System.out.println("2");
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
			neighborLetters.add(new Neighbor('e', letters.get(col - 1).get(row + 1)));
		}else if (row == 0){
			//top row no corners
			//System.out.println("3");
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
			neighborLetters.add(new Neighbor('c', letters.get(col + 1).get(row + 1)));
			neighborLetters.add(new Neighbor('e', letters.get(col - 1).get(row + 1)));
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
		}else if (row == rSize - 1 && col == 0){
			//bottom left corner
			//System.out.println("4");
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
			neighborLetters.add(new Neighbor('b', letters.get(col + 1).get(row - 1)));
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
		}else if (row == rSize - 1 && col == cSize - 1){
			//bottom right corner
			//System.out.println("5");
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
			neighborLetters.add(new Neighbor('a', letters.get(col - 1).get(row - 1)));
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
		}else if (row == rSize - 1){
			//bottom row no corners
			//System.out.println("6");
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
			neighborLetters.add(new Neighbor('b', letters.get(col + 1).get(row - 1)));
			neighborLetters.add(new Neighbor('a', letters.get(col - 1).get(row - 1)));
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
		}else if (col == 0){
			//left edge no corners
			//System.out.println("7");
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
			neighborLetters.add(new Neighbor('c', letters.get(col + 1).get(row + 1)));
			neighborLetters.add(new Neighbor('b', letters.get(col + 1).get(row - 1)));
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
		}else if(col == cSize - 1){
			//right edge no corners
			//System.out.println("8");
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
			neighborLetters.add(new Neighbor('e', letters.get(col - 1).get(row + 1)));
			neighborLetters.add(new Neighbor('a', letters.get(col - 1).get(row - 1)));
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
		}else{
			//middle of the board, no edges
			//System.out.println("9");
			neighborLetters.add(new Neighbor('d', letters.get(col).get(row + 1)));
			neighborLetters.add(new Neighbor('t', letters.get(col).get(row - 1)));
			neighborLetters.add(new Neighbor('c', letters.get(col + 1).get(row + 1)));
			neighborLetters.add(new Neighbor('b', letters.get(col + 1).get(row - 1)));
			neighborLetters.add(new Neighbor('e', letters.get(col - 1).get(row + 1)));
			neighborLetters.add(new Neighbor('a', letters.get(col - 1).get(row - 1)));
			neighborLetters.add(new Neighbor('l', letters.get(col - 1).get(row)));
			neighborLetters.add(new Neighbor('r', letters.get(col + 1).get(row)));
		}
		return;
	}
}
