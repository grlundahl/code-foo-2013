/**
 * @author Greg Lundahl
 */
public class HighScore {
	private float score;
	private String name;
	
	/**
	 * Constructor of the HighScore class
	 * @param float score
	 * @param String name
	 */
	public HighScore(float score, String name){
		this.score = score;
		this.name = name;
	}
	
	/**
	 * returns the float value of the score
	 * @return float
	 */
	public float getScore(){
		return score;
	}
	
	/**
	 * Returns the String value of the name
	 * @return String
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Compares the scores of the current HighScore and the given HighScore.
	 * Returns a number < 0 if the given HighScore is larger. Returns 0 if they are the same.
	 * And returns a number > 0 if the given HighScore is smaller.
	 * @param hs1
	 * @return
	 */
	public float compareTo(HighScore hs1){
		return score - hs1.getScore();
	}
	
	/**
	 * Returns a string representation of the HighScore
	 * @return String
	 */
	public String toString(){
		return name + ": " + score;
	}
}
