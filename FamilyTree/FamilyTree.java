import java.util.ArrayList;
/**
 * 
 * @author Greg Lundahl
 *
 */
public class FamilyTree {
	private FamilyMember top;

	/**
	 * Constructor of a FamilyTree object
	 * @param top
	 */
	public FamilyTree(FamilyMember top){
		this.top = top;
	}
	
	/**
	 * Main function used to test the implementation of searchTree()
	 * @param args
	 */
	public static void main(String[] args){
		FamilyTree fTree = createTree();
		for(FamilyMember child: fTree.top.getChildren()){
			System.out.println("Target: " + child);
			System.out.println("Matches: " + fTree.searchTree(child, fTree));
		}
	}
	
	/**
	 * Searches the FamilyTree for any FamilyMembers that match name or generation with the target and returns them
	 * @param target
	 * @param fTree
	 * @return
	 */
	public ArrayList<FamilyMember> searchTree(FamilyMember target, FamilyTree fTree){
		ArrayList<FamilyMember> matches = new ArrayList<FamilyMember>();
		
		if((fTree.top.getName().equals(target.getName()) || fTree.top.getGen() == target.getGen()) && target != fTree.top){
			matches.add(fTree.top);
		}
		
		if(fTree.top.getSpouse().getName().equals(target.getName()) || fTree.top.getSpouse().getGen() == target.getGen()){
			matches.add(fTree.top.getSpouse());
		}
		
		if(fTree.top.getChildren().size() == 0){
			return matches;
		}
		
		for (FamilyMember child : fTree.top.getChildren()){
			matches.addAll(searchTree(target, new FamilyTree(child)));
		}
		return matches;
	}
	
	/**
	 * Creates a FamilyTree object to be used for testing
	 * @return
	 */
	public static FamilyTree createTree(){		
		FamilyTree theTree = new FamilyTree(new FamilyMember(1, "Bob", null, null, new ArrayList<FamilyMember>()));
		theTree.top.setSpouse(new FamilyMember(1, "Lisa", null, theTree.top, new ArrayList<FamilyMember>()));
		theTree.top.addChild(new FamilyMember(2, "Greg", theTree.top, null, new ArrayList<FamilyMember>()));
		theTree.top.addChild(new FamilyMember(2, "Dylan", theTree.top, null, new ArrayList<FamilyMember>()));
		theTree.top.addChild(new FamilyMember(2, "Bob", theTree.top, null, new ArrayList<FamilyMember>()));
		int i = 0;
		for (FamilyMember child: theTree.top.getChildren()){
			child.setSpouse(new FamilyMember(2, "Marisa" + i, theTree.top, child, new ArrayList<FamilyMember>()));
			i++;
		}

		return theTree;
	}
}
