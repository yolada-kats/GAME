/*package game;
import java.util.*;

public class fill_the_gap {
	private static int counter = 0;
	private String city ;
	private static String [] words1;
	private static String [] words2;
	private static String [] words3;
	
	public fill_the_gap (String city) {
		this.city = city ;
		if (counter == 0) {
			words1 = new String []{"POS","AN"} ;
			words2 = new String []{"GEIA","TI"} ;
			words3 = new String []{"OXI","NAI"};
			counter++;
		}
	}
	
	public int game() {
		int score = 0;
		Random rand = new Random();
		int randomWord ;
		int [] positionArray = new int [3];
		int cityNumber = 0;
		String word1;
		String word2;
		String word3;
		int ArrayLength;
		for (int i = 0;i < 3;i++ ) {
			if (city.equals("SPARTI")) {
				randomWord = rand.nextInt(words1.length);
				cityNumber = 1;
			}else if (city.equals("ITHAKI")) {
				randomWord = rand.nextInt(words2.length);
				cityNumber = 2;
			}else if (city.equals("VERGINA")) {
				randomWord = rand.nextInt(words3.length);
				cityNumber = 3;
			}else {
				System.out.print("Wrong City");
				return -1;
			}
			
			if ((i-1 == 0) && (randomWord == positionArray[i-1])) {
				i = i-1;
				continue;
			}else if ((i-2 == 0) && ((randomWord == positionArray[i-1]) || (randomWord == positionArray[i-2]))) {
				i = i-1;
				continue;
			}
			positionArray[i] = randomWord;
		}
		if (cityNumber == 1) {
			word1 = words1[positionArray[0]];
			word2 = words1[positionArray[1]];
			word3 = words1[positionArray[2]];
		}else if (cityNumber == 2) {
			word1 = words2[positionArray[0]];
			word2 = words2[positionArray[1]];
			word3 = words2[positionArray[2]];
		}else {
			word1 = words3[positionArray[0]];
			word2 = words3[positionArray[1]];
			word3 = words3[positionArray[2]];
		}
		String [] Array1 = word1.split("");
		String [] Array2 = word2.split("");
		String [] Array3 = word3.split("");
		
		for (int i = 0;i < 3;i++) {
			if (i == 0) {
				System.out.print(Array1[0]);
				for (int j = 1;j < Array1.length-1;j++) {
					System.out.print("_");
				}
				System.out.println(Array1[Array1.length-1]);
				ArrayLength = (Array1.length-2)*2;
				for (int k = 0;k < ArrayLength;k++) {
					System.out.println("Please type a letter");
					Scanner input = new Scanner(System.in);
					String temp = input.nextLine();
					for (int g = 0;g < Array1.length;g++) {
						if (temp == Array1[g]) {
							
						}
					}
				}
			}
			else if (i == 1) {
				System.out.print(Array2[0]);
				for (int j = 1;j < Array2.length-1;j++) {
					System.out.print("_");
				}
				System.out.println(Array2[Array2.length-1]);
			}
			else if (i == 2) {
				System.out.print(Array3[0]);
				for (int j = 1;j < Array3.length-1;j++) {
					System.out.print("_");
				}
				System.out.println(Array3[Array3.length-1]);
			}
		}
		return score;
	}

}*/
