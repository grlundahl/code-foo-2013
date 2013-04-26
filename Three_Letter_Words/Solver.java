import java.util.ArrayList;

/**
 * 
 * @author Greg Lundahl
 *
 */
public class Solver {
	/**
	 * Constructor for the Solver class
	 */
	public Solver(){
		
	}
	
	/**
	 * Solves the ThreeLetterWords to find the shortest path between two words changing one character at a time
	 * using a breadth first search algorithim
	 * @param ThreeLetterWords solveThis
	 * @return ArrayList<String>
	 */
	public ArrayList<String> solve(ThreeLetterWords solveThis){
		boolean found = false;
		ArrayList<ArrayList<String>> queue = new ArrayList<ArrayList<String>>();
		ArrayList<String> first = new ArrayList<String>();
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> current = new ArrayList<String>();
		
		first.add(solveThis.getStart());
		queue.add(first);
		
		if (solveThis.isGoal(first.get(0))){
			found = true;
		}
		
		while(queue.size() != 0 && !found){
			current = queue.remove(0);
			for(String neighbor: solveThis.getNeighbors( current.get(current.size()-1))){
				ArrayList<String> nextConfig = new ArrayList<String>();
				for(int i = 0; i < current.size(); i++){
					nextConfig.add(current.get(i));
				}
				
				if (!visited.contains(neighbor)){
					nextConfig.add(neighbor);
					if(solveThis.isGoal(nextConfig.get(nextConfig.size()-1))){
						current = nextConfig;
						found = true;
						visited.add(neighbor);
						break;
					}else{
						visited.add(neighbor);
						queue.add(nextConfig);
					}
				}
			}
		}
		if(found){
			return current;
		}else{
			return null;
		}
	}
}
