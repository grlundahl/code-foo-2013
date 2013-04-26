import java.util.ArrayList;

/**
 * 
 * @author Greg Lundahl
 *
 */
public class FamilyMember {
	private FamilyMember parent; 
	private FamilyMember spouse;
	private ArrayList<FamilyMember> children;
	private int generation;
	private String name;
	
	/**
	 * Constructs a FamilyMember object
	 * @param generation
	 * @param name
	 * @param parents
	 * @param spouse
	 * @param children
	 */
	public FamilyMember(int generation, String name, FamilyMember parents, FamilyMember spouse, ArrayList<FamilyMember> children){
		this.parent = parents;
		this.spouse = spouse;
		this.children = children;
		this.generation = generation;
		this.name = name;
	}

	/**
	 * Returns the parent FamilyMember object
	 * @return
	 */
	public FamilyMember getParents(){
		return parent;
	}
	
	/**
	 * Returns the spouse of the FamilyMember
	 * @return
	 */
	public FamilyMember getSpouse(){
		return spouse;
	}
	
	/**
	 * Sets the Spouse of the FamilyMember
	 * @param spouse
	 */
	public void setSpouse(FamilyMember spouse){
		this.spouse = spouse;
	}
	
	/**
	 * Returns a list of the children of the FamilyMember
	 * @return
	 */
	public ArrayList<FamilyMember> getChildren(){
		return children;
	}
	
	/**
	 * Returns the generation of the FamilyMember
	 * @return
	 */
	public int getGen(){
		return generation;
	}
	
	/**
	 * Returns the name of the FamilyMember
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Adds a child to the FamilyMember
	 * @param child
	 */
	public void addChild(FamilyMember child){
		children.add(child);
	}
	
	/**
	 * Returns a String representation of the FamilyMember
	 */
	public String toString(){
		return name + ": " + generation ;
	}
}
