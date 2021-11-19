import java.util.Scanner;
public class Pesvres {
Scanner sc= new Scanner(System.in);


private String []answers = new String [10];
private int score;
private String place;
	public Pesvres(String place, String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10){
		answers[0] = a1;
		answers[1] = a2;
		answers[2] = a3;
		answers[3] = a4;
		answers[4] = a5;
		answers[5] = a6;
		answers[6] = a7;
		answers[7] = a8;
		answers[8] = a9;
		answers[9] = a10;

		this.score = 0;
		this.place = place;
	}


	public void Game(){
		System.out.printf(" \n WRITE 5 WORDS-PHRASES RELATED TO THE DESTINATION: %s \n",place);
		String option= null ;
		int word = 0;
		int[] position = new int[]{-1,-1,-1,-1,-1};
			while ((!"END".equals(option))&&(score < 5)){

				System.out.printf(" \n %d:",word+1);
				option = sc.nextLine();

				boolean found = false;
				boolean stop = false;
				int i = 0;

					while ( (found==false) && (i<=9) && (stop==false)){

						if (answers[i].equals(option)){

										for(int p=0; p<5; p++){
											if (stop == false) {
												if(position[p] == -1){
													found = true;
													position[p] = i;
													break;
												}else if(position[p]==i){
													System.out.println("YOU HAVE ALREADY GIVEN THIS ANSWER. TRY ANOTHER ONE.");
													stop = true;
													break;
												}
											}
										}



						}else{
							i = i+1;
						}

					}

					if(!"END".equals(option)&&(stop == false)){
						if (found == false) {
							System.out.println("\n YOUR ATTEMPT WAS NOT SUCCESFUL. PLEASE TRY AGAIN.");
						}else{
							System.out.println("\n YOUR ANSWER IS CORRECT.");
							word++;
							score++;
						}
					}

			}
			if (score == 5){
				System.out.println("CONGRATULATIONS! YOU MANAGED TO FIND ALL 5 WORDS!");
			}

			System.out.printf(" END OF THE GAME. YOUR SCORE IS: %d AND THE SOLDIERS YOU COLLECTED: %d \n \n", score, score*100);



	}





	public void Ex(){
		for(int i=0; i<10; i++){
			System.out.printf(" \n %s ",answers[i]);
		}
	}


}