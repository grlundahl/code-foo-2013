import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board{
	private ArrayList<ArrayList<Letter>> letters;
	private ArrayList<String> words;
	private Scanner in = new Scanner(System.in);

	public Board(){
		this.letters = new ArrayList<ArrayList<Letter>>();
		this.words = new ArrayList<String>();
		parseBoard();
		for (int i = 0; i < words.size(); i++){
			if (words.get(i).isEmpty()){
				words.remove(words.get(i));
			}
		}
		createNeighbors(this);
	}

	public void parseBoard(){
		String fileName;
		FileReader fileRead;
		System.out.println("Enter the name of the text file of the board: ");
		fileName = in.next();

		try{
			fileRead = new FileReader(fileName);
		}catch (IllegalArgumentException e){
			System.out.println("Invalid file name");
			return;
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
			return;
		}
		int i = 0;
		boolean isWords = false;
		try {
			int ch = fileRead.read();
			while (ch != -1 ){
				if (isWords){
					if(ch == 32){
						break;
					}else{
						String word = new String();
						while(ch != 10){
							word += Character.toString((char)ch);
							ch = fileRead.read();
						}
						ch = fileRead.read();
						words.add(word);
					}
				}else{
					if (ch == 10){
						isWords = true;
					}else{
						ArrayList<Letter> line = new ArrayList<Letter>();
						while (ch != 10){
							//is not a new line
							if(ch != 9){
								// is not a tab
								line.add(new Letter((char)ch));
							}
							ch = fileRead.read();
						}
						ch = fileRead.read();
						letters.add(line);
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			fileRead.close();
		} catch (IOException e){ 
			e.printStackTrace();
		}
		words.remove("Words to find:");
		words.remove(null);

		return;
	}

	public ArrayList<ArrayList<Letter>> getLetters(){
		return letters;
	}

	public ArrayList<String> getWords(){
		return words;
	}

	public static void createNeighbors(Board wordSearch){
		int r, c;
		r = 0;
		c = 0;
		for(ArrayList<Letter> line : wordSearch.letters){
			for (Letter character: line){
				character.createNeighborList(wordSearch, c, r);
				c++;
			}
			r++;
			c = 0;
		}
	}

}
