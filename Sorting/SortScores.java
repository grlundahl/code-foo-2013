import java.util.ArrayList;
import java.util.Collection;
/**
 * 
 * @author Greg Lundahl
 *
 */
public class SortScores {
	private static ArrayList<HighScore> scores = new ArrayList<HighScore>();
	
	/**
	 * Constructor of the SortScores class
	 * @param scores
	 */
	public SortScores(Collection<HighScore> scores){
		this.scores = new ArrayList<HighScore>(scores);
	}
	
	/**
	 * Main function of the SortScores class. Used to test the sort functionality
	 * @param args
	 */
	public static void main(String[] args){
		scores.add(new HighScore(1000.0f,"Bob"));
		scores.add(new HighScore(999.9f, "Dylan"));
		scores.add(new HighScore(1001.1f, "Marquesha"));
		scores.add(new HighScore(1234.5f, "Big Mama"));
		scores.add(new HighScore(1.234f, "I'm not very good at this"));
		scores.add(new HighScore(500.1f, "Average"));
		System.out.println(scores);
		scores = sortScores(scores);
		System.out.println(scores);
	}
	
	/**
	 * Does a mergeSort on the given ArrayList of HighScore's
	 * @param scores
	 * @return ArrayList<HighScore>
	 */
	public static ArrayList<HighScore> sortScores(ArrayList<HighScore> scores){
		if (scores.size() == 1){
			return scores;
		}
		
		ArrayList<HighScore> left = new ArrayList<HighScore>();
		ArrayList<HighScore> right = new ArrayList<HighScore>();
		int mid = scores.size()/2;
		for(int i = 0; i < mid; i++){
			left.add(scores.get(i));
		}
		for(int i = mid; i < scores.size(); i++){
			right.add(scores.get(i));
		}
		left = sortScores(left);
		right = sortScores(right);
		
		return merge(left, right);
	}
	
	/**
	 * Merge used for mergeSorts. Merges the left and right ArrayLists into one.
	 * @param left
	 * @param right
	 * @return result
	 */
	public static ArrayList<HighScore> merge (ArrayList<HighScore> left, ArrayList<HighScore> right){
		ArrayList<HighScore> result = new ArrayList<HighScore>();
		
		while(left.size() > 0 || right.size() > 0){
			if (left.size() > 0 && right.size() > 0){
				if(left.get(0).compareTo(right.get(0)) <= 0){
					result.add(right.get(0));
					right.remove(0);
				}else{
					result.add(left.get(0));
					left.remove(0);
				}
			}else if(left.size() > 0){
				result.add(left.get(0));
				left.remove(0);
			}else if(right.size() > 0){
				result.add(right.get(0));
				right.remove(0);
			}
		}
		return result;
	}
}
