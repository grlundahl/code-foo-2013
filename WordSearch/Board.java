import java.util.ArrayList;
import java.lang.Scanner;

public class Board{
	private ArrayList<ArrayLIst<char>> letters;
	private ArrayList<String> words;
	private Scanner in = new Scanner(System.in);
	
	public Board(){
		this.letters = new ArrayList<ArrayList<char>>();
		this.words = new ArrayList<String>;
	}

	public void parseBoard(){
		String fileName;
		Scanner fileRead;
		System.out.println("Enter the name of the text file of the board: ");
		fileName = in.next()
		try{
			fileRead = new Scanner(fileName);
		}catch(FileNotFoundException e){
			System.out.println("Invalid file name");
			return;
		}catch (InvalidArgumentException e){
			System.out.println("Invalid file name");
			return;
		}

		while(fileRead.hasNextLIne()){
			line = fileRead.nextLIne();
			boolean isWords = false;
			int line = 0;
			if (line.charAt(o).equals(' ')){
				 break;
			}else if (line.contains("Words to find:")){
				isWords = true;
			}else if(isWords){
				words.add(line);
			}else{
				String [] charList = line.split("\t");
				
			}
				
}
