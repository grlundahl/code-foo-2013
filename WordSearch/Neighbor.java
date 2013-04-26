/**
 *@author Greg Lundahl
 */
public class Neighbor{
	private char direction;
	private Letter letter;

	/**
	 *Constructor for the Neighbor class
	 * @param char
	 * @param Letter
	 */
	public Neighbor(char direction, Letter letter){
		this.direction = direction;
		this.letter = letter;
	}

	/**
	 * Returns the direction of the neighbor represented by a char. (a for top-left, t for top, b for top-right
	 * r for right, c for bottom-right, d for bottom, and e for bottom-left.
	 * @return char
	 */
	public char getDirection(){
		return direction;
	}

	/**
	 * Returns the Letter value of the neighbor
	 * @return Letter
	 */
	public Letter getLetter(){
		return letter;
	}

	/**
	 *Returns a String representation of the Letter
	 */
	public String toString(){
		return direction + " : " + letter;
	}
}
