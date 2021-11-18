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


	public void Directions(){
		System.out.printf ("\n ���������� ���� ���������: %s .",place);
		System.out.println("��� �� ����������� ���� �� �������, ������ �� ������� �� ��������: ��� ����");
		System.out.println("�� ������� ��� ���������� ����� �����. ������ �� ����� ��� �� ��������������� 5 ������-������� �������� �� ��� ��������� ��� ���������");
		System.out.println(" ������� ��� ���� �� ���������� ������� ������ ��� ������� ��� ��� ��������� ��� �������.");
		System.out.println("�� ���������� ��� ������ �� ����� ��������� �� �������� �������� ��������");
		System.out.println("�������� 10 ������ ����������, ��� ����� ������ ����������� �� ����� 5 ��� �����.");
		System.out.println("��� �� ���������� �� ������� ���� START");
		System.out.println("���� ������������ ��� ���������� ��� ���� END, ��� �� ���������� �� ���� ��� ��� �� ���������� ��� ��������� �� ���������");
	}



	public void Game(){
		System.out.printf(" \n ����� 5 ������-������� �������� �� ��� ���������: %s \n",place);
		String option= null ;
		int word = 0;

			while ((option != "END")&&(score != 5)){
				System.out.printf(" \n %d:",word+1);
				option = sc.nextLine();

				boolean found = false;
				int[] position = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
				int pos = 0;
				int i = 0;

					while ( (found==false) && (i<=9)){
						System.out.printf ("\n ���������� %s, %s",option, answers[i]);
						if (answers[i] == option){

								for(int p=0; p<10; p++){
									if(position[p] != i){
										found = true;
										position[p] = i;
									}else{
										System.out.println("����� ����� ��� ���� �� ����. ���������� ����.");
									}
								}
						}else{
							i = i+1;
						}
						System.out.printf ("\n %b",found);
					}

					if (found == false) {
						System.out.println("� ���������� ��� ��� ���� ��������. ���������� ����");
					}else{
						System.out.println(" � �������� ��� ���� �����");
						word++;
						score++;
					}

			}

			if (score == 5){
				System.out.println("������������! ��������� �� ����� ��� ��� 5 ������!");
			}

			System.out.printf(" To ���� ��� �����: %d ��� �� ���������� ��� �������: %d ", score, score*10);



	}





	public void Ex(){
		for(int i=0; i<10; i++){
			System.out.printf(" \n %s ",answers[i]);
		}
	}


}