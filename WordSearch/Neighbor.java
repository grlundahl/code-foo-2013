public class Neighbor{
	private char direction;
	private Letter letter;

	public Neighbor(char direction, Letter letter){
		this.direction = direction;
		this.letter = letter;
	}

	public char getDirection(){
		return direction;
	}

	public Letter getLetter(){
		return letter;
	}

	public String toString(){
		return direction + " : " + letter;
	}
}
