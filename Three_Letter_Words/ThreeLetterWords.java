import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author Greg Lundahl
 *
 */
public class ThreeLetterWords {
	private static String startWord = new String();
	private static String endWord = new String();
	private static ArrayList<String> threeLetterWords = new ArrayList<String>();
	private static FileReader readWords;
	private static Solver solver = new Solver();
	private Scanner read = new Scanner(System.in);
	
	/**
	 * Constructor for the ThreeLetterWords class. Reads in all the three letter words
	 * and gets input for the starting and ending word.
	 */
	public ThreeLetterWords(){
		try{
			readWords = new FileReader("three-letter-words.txt");
		}catch (FileNotFoundException e){
			System.out.println("Invalid File Name!");
			return;
		}
		
		readWords();
		
		do{
			do{
				System.out.print("Enter the three letter word to start at: ");
				if(read.hasNext()){
					startWord = read.next();
				}
			}while(startWord.length() != 3);
		}while(!isValidWord(startWord));
				
		do{
			do{
				System.out.print("Enter the three letter word to end at: ");
				if(read.hasNext()){
					endWord = read.next();
				}
			}while(endWord.length() != 3);
		}while(!isValidWord(endWord));
	}

	/**
	 * Main function. Runs the solver on the ThreeLetterWords class created by the constructor above.
	 * @param args
	 */
	public static void main(String[] args){
		ArrayList<String> results = new ArrayList<String>();
		results = solver.solve(new ThreeLetterWords());
		
		if (results == null){
			System.out.println("No Solution");
		}else{
			if(results.size() == 0){
				System.out.println("They are the same word!");
			}else{
				System.out.println("Number of steps: " + (results.size() - 1));
			}
			
			for (String word : results){
				System.out.println(word.toUpperCase());
			}
		}
		
	}
	
	/**
	 * Returns a booelean representing if the given word is a valid 3 letter word
	 * @param String word
	 * @return boolean
	 */
	public static boolean isValidWord(String word){
		return threeLetterWords.contains(word.toUpperCase());
	}
	
	/**
	 * Returns an ArrayList of Strings representing all the words that are 1 character off the given word
	 * @param String word
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getNeighbors(String word){
		ArrayList<String> neighbors = new ArrayList<String>();
		for (String w : threeLetterWords){
			int same = 0;
			for (int i = 0; i < 3; i++){
				if(Character.toLowerCase(w.charAt(i)) ==  Character.toLowerCase(word.charAt(i))){
					same++;
				}
			}
			if (same == 2){
				neighbors.add(w);
			}
		}
		return neighbors;
	}
	
	/**
	 * Returns the starting word
	 * @return String
	 */
	public String getStart(){
		return startWord;
	}
	
	/**
	 * Returns a boolean representing if the given word was the goal
	 * @param String
	 * @return boolean
	 */
	public boolean isGoal(String word){
		return endWord.toLowerCase().equals(word.toLowerCase());
	}
	
	/**
	 * Reads all the words in from the text file of all the three letter words
	 */
	public static void readWords(){
		try {
			int ch = readWords.read();
			while(ch != -1){
				String word = new String();
				while(ch != 10 && ch != -1){
					word += (char)ch;
					ch = readWords.read();
				}
				threeLetterWords.add(word);
				ch = readWords.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
