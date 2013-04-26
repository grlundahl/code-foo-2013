import java.util.ArrayList;

/**
 *@author Greg Lundahl
 */
public class WordSearch{
	private static Board theBoard;
	
	/**
	 *Main function
	 *@param String[]
	 */
	public static void main(String[] args){
		theBoard = new Board();
		for(String word: theBoard.getWords()){
			findWord(word, theBoard);
		}
	}

	/**
	 * Function to find the given word in the given Board
	 * @param String
	 * @param Board
	 */
	public static void findWord(String word, Board theBoard){
		ArrayList<ArrayList<Letter>> letters = theBoard.getLetters();
		for (int c = 0; c < letters.size(); c++){
			for (int r = 0; r < letters.get(0).size(); r++){
				//System.out.println(word.charAt(0) + " " + letters.get(c).get(r).getLetter());
				if(Character.toLowerCase(word.charAt(0)) == letters.get(c).get(r).getLetter()){
					if(trace(letters.get(c).get(r), word, theBoard)){
						System.out.println(word + " starts at row  " + (c+1) + " and column " + (r+1));
					}
				}
			}
		}
	}

	/**
	 * Traces a path to see if there is a complete word on the Board
	 * @param Letter
	 * @param String
	 * @param Board
	 */
	public static boolean trace(Letter let, String word, Board theBoard){
		Letter current = let;
		char dir = ' ';
		boolean hasNeighbor = false;

		for (Neighbor n : current.getNeighbors()){
			if (n.getLetter().getLetter() ==Character.toLowerCase(word.charAt(1))){
				hasNeighbor = true;
				dir = n.getDirection();

				current = n.getLetter();
				break;
			}
		}

		if (!hasNeighbor){
			return false;
		}

		for(int i = 2; i < word.length(); i++){
			hasNeighbor = false;
			for (Neighbor n: current.getNeighbors()){
				if (n.getLetter().getLetter() == word.charAt(i) && n.getDirection() == dir){

					hasNeighbor = true;
					current = n.getLetter();
					break;
				}
			}

			if (!hasNeighbor){
				return false;
			}
		}
		return true;
	}
}
