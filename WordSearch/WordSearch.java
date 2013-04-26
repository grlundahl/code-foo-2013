import java.util.ArrayList;

public class WordSearch{
	private static Board theBoard;
	
	public static void main(String[] args){
		theBoard = new Board();
		for(String word: theBoard.getWords()){
			findWord(word, theBoard);
		}
	}

	public static void findWord(String word, Board theBoard){
		ArrayList<ArrayList<Letter>> letters = theBoard.getLetters();
		for (int c = 0; c < letters.size(); c++){
			for (int r = 0; r < letters.get(0).size(); r++){
				//System.out.println(word.charAt(0) + " " + letters.get(c).get(r).getLetter());
				if(Character.toLowerCase(word.charAt(0)) == letters.get(c).get(r).getLetter()){
					if(trace(letters.get(c).get(r), word, theBoard)){
						System.out.println("starting at row  " + (c+1) + " and column " + (r+1));
					}
				}
			}
		}
	}

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
		if(dir == 'a'){
			System.out.print(word + " goes towards the top left ");
		}else if(dir == 't'){
			System.out.print(word + " goes towards the top ");
		}else if(dir == 'b'){
			System.out.print(word + " goes towards the top right ");
		}else if(dir == 'r'){
			System.out.print(word + " goes towards the right ");
		}else if(dir == 'c'){
			System.out.print(word + " goes towards the bottom right ");
		}else if(dir == 'd'){
			System.out.print(word + " goes towards the bottom ");
		}else if(dir == 'e'){
			System.out.print(word + " goes towards the bottom left ");
		}else{
			System.out.print(word + " goes towards the left ");
		}
		return true;
	}
}
