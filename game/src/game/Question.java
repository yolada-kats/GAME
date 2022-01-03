package game;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;


public class Question implements ActionListener {
	
	 static ArrayList <String>  question1 = new ArrayList<String>();  
	  static {
 	  question1.add("1. Who was the king of Mycenae?");  
 	  question1.add("2. Who killed his mother in Mycenae era ?");  
 	  question1.add("3. Mycenaeans did leave behind a written language. What is it called?");  
 	  question1.add("4. What animal guarded the famous gate into Mycenae?");  
	  }
	  
	  static ArrayList <String>  question2 = new ArrayList<String>();
	  static {
		  question2.add("1. For what thing is known the Cycladitic civilization?");
		  question2.add( "2. How did the Cyclades form?");
		  question2.add("3. Where were te Cyclades located?");
		  question2.add("4. Who was born there?");
	  }
	  
	  static ArrayList <String>  question3 = new ArrayList<String>();
	  static {
		  question3.add("1. Who was the daughter of the Minoan king?");
		  question3.add("2. The ruins of a number of multi-functional architectural complexes have been excavated on the island. What is the best known of these 'palaces'?");
		  question3.add("3. Which was a sacred symbol for the Minoans?");
		  question3.add("4. Who was the gurdian of the labyrinth?");
	  }
	                     	  
	 
	  static ArrayList <String> options1 = new ArrayList<String>();
	  
	  static {
		  options1.add("Periklis");
		  options1.add("King Alexander");
		  options1.add("Agamemnon");
		  options1.add("Leonidas");
		  options1.add("Orestis");
		  options1.add("Achilleas");
		  options1.add("Patroklos");
		  options1.add("Diomidis");
	      options1.add("Linear B");
		  options1.add("Hieroglyphics");
		  options1.add("Linear A");
		  options1.add("Demotic");
		  options1.add("Tiger");
		  options1.add("Bull");
		  options1.add("Lion");
		  options1.add("Peageon");
	  }
	 
static ArrayList <String> options2 = new ArrayList<String>();
	  
	  static {
		  options2.add("War");
		  options2.add("Monuments");
		  options2.add("Art");
		  options2.add("Kings");
		  options2.add("Erruption");
		  options2.add("Earthquake");
		  options2.add("Collision");
		  options2.add("Big Bang");
	      options2.add("Attiki");
		  options2.add("Aegean");
		  options2.add("Peloponissos");
		  options2.add("Ionian Sea");
		  options2.add("Appolo and Artemis");
		  options2.add("Athena");
		  options2.add("Zeus");
		  options2.add("Aphrodite");
	  }
	
	  
static ArrayList <String> options3 = new ArrayList<String>();
	  
	  static {
		  options3.add("Ermioni");
		  options3.add("Iphigeneia");
		  options3.add("Cassandra");
		  options3.add("Ariadne");
		  options3.add("Colosseum");
		  options3.add("Delphi");
		  options3.add("Knossos");
		  options3.add("Parhenon");
	      options3.add("Sacred Horns");
		  options3.add("The Axe");
		  options3.add("The Bull");
		  options3.add("The Sea");
		  options3.add("Hydra");
		  options3.add("Minotauros");
		  options3.add("The Lion of Nemea");
		  options3.add("Ades");
	  }
	  
	
	
	
	
	
	
	char[] answers = {
			            'C',
			            'A',
			            'A',
			            'C',
	                    'C',
			            'A',
			            'B',
			            'A',
			            'D',
			            'C',
			            'A',
			            'B',
	                 };

	
	
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = 4;
	int result;
	int xi=1;
	int t=1;
	int x;
	int tt = 0;
	JFrame frame;
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	//background label
	JLabel background = new JLabel();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JButton map = new JButton();
	//next button
	JButton nextButton = new JButton();
	JLabel answer_IconA = new JLabel();
	JLabel answer_IconB = new JLabel();
	JLabel answer_IconC = new JLabel();
	JLabel answer_IconD = new JLabel();
	
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();

	ImageIcon delos = new ImageIcon("game/src/game/4.jpg");
	ImageIcon crete = new ImageIcon("game/src/game/crete.jpg");
	ImageIcon mycenae = new ImageIcon("game/src/game/mycenae.jpg");
	ImageIcon right = new ImageIcon("game/src/game/right-removebg-preview.png");
	ImageIcon wrong = new ImageIcon("game/src/game/wrong-removebg-preview.png");
	
	public Question(int x, JFrame frame) {
		this.x = x;
		this.frame = frame;
		//te background settings
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(238,236,194));
		frame.setLayout(null);
		frame.setResizable(false);
		
		background.setBounds(0, 0, 608, 800);
		if (x==1) {
			background.setIcon(mycenae);
		}else if (x==2) {
			background.setIcon(delos);
		}else if (x==3) {
			
			background.setIcon(crete);
		}
		background.setVisible(true);
		
		textfield.setBounds(0,0,620,50);
		textfield.setBackground(new Color(238,236,194));
		textfield.setForeground(new Color(0,0,0));
		textfield.setFont(new Font(" CASTELLAR",Font.BOLD,30));
		//textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		frame.add(textfield);
		frame.setVisible(true);
		
		textarea.setBounds(0,50,800,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(238,236,194));
		textarea.setForeground(new Color(0,0,0));
		textarea.setFont(new Font("Times New Roman",Font.BOLD,20));
		//textarea.setFont(new Font("MV BOLI",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		
		buttonA.setBounds(150,150,300,50);
		buttonA.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonA.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setEnabled(true);
		//buttonA.setIcon(column);
		
		/*buttonA.setOpaque(false);
		buttonA.setContentAreaFilled(false);
		buttonA.setBorderPainted(false);*/
		
		//buttonA.setText("A");
		
		buttonB.setBounds(150,245,300,50);
		buttonB.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonB.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setEnabled(true);
		//buttonB.setText("B");
		
		
		/*buttonB.setOpaque(false);
		buttonB.setContentAreaFilled(false);
		buttonB.setBorderPainted(false);*/
		
		buttonC.setBounds(150,345,300,50);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setEnabled(true);
		//buttonC.setText("C");
		
		
		/*buttonC.setOpaque(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);*/
		
		buttonD.setBounds(150,455,300,50);
		//buttonD.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonD.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setEnabled(true);
		
		
		/*buttonD.setOpaque(false);
		buttonD.setContentAreaFilled(false);
		buttonD.setBorderPainted(false);*/
		
		answer_IconA.setBounds(50, 160, 100, 70);
		answer_IconB.setBounds(50, 245, 100, 70);
		answer_IconC.setBounds(50, 345, 100, 70);
		answer_IconD.setBounds(50, 455, 100, 70);
		
		//the button for the next question 
		ImageIcon next_arrow = new ImageIcon("download-removebg-preview (1).png");
		map.setBounds(0,100,150,50);
		map.addActionListener(this);
		map.setFont(new Font("Times New Roman",Font.BOLD,25));
		map.setFocusable(false);
		map.setText("MAP");
		map.setIcon(next_arrow);
		map.setHorizontalTextPosition(JButton.LEFT);
		map.setIconTextGap(20);
		map.setBackground(new Color(238,236,194));
		map.setForeground(Color.black);
		map.setBorder(BorderFactory.createBevelBorder(1));
		
		nextButton.setBounds(470,100,150,50);
		nextButton.addActionListener(this);
		nextButton.setFont(new Font("Times New Roman",Font.BOLD,25));
		nextButton.setFocusable(false);
		nextButton.setText("Next");
		nextButton.setIcon(next_arrow);
		nextButton.setHorizontalTextPosition(JButton.LEFT);
		nextButton.setIconTextGap(20);
		nextButton.setBackground(new Color(238,236,194));
		nextButton.setForeground(Color.black);
		nextButton.setBorder(BorderFactory.createBevelBorder(1));
		
		number_right.setBounds(100, 183, 400, 400);
		number_right.setBackground(new Color(238,236,194));
		number_right.setForeground(new Color(0,0,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		frame.add(nextButton);
		frame.add(map);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(answer_IconA);
		frame.add(answer_IconB);
		frame.add(answer_IconC);
		frame.add(answer_IconD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		//adds background
		frame.add(background);
		
		
		nextQuestion(x);
    }	
	
	public  void nextQuestion(int c) {
		
	if (c==1) {
			
		
		if(index>=total_questions) {
			results();
		}else {
			
			textfield.setText("Question"+(index+1));
			textarea.setText(question1.get(index));
			buttonA.setText(options1.get(tt));
			buttonB.setText(options1.get(tt+1));
			buttonC.setText(options1.get(tt+2));
			buttonD.setText(options1.get(tt+3));
			
			
		}
		
	}else if (c==2) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(question2.get(index));
				buttonA.setText(options2.get(tt));
				buttonB.setText(options2.get(tt+1));
				buttonC.setText(options2.get(tt+2));
				buttonD.setText(options2.get(tt+3));
		    }
	}else if (c==3) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(question3.get(index));
				buttonA.setText(options3.get(tt));
				buttonB.setText(options3.get(tt+1));
				buttonC.setText(options3.get(tt+2));
				buttonD.setText(options3.get(tt+3));
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

	  if(x==2) {
		if (e.getSource()==buttonA) {
			answer= 'A';
			if (answer == answers[xi+3]) {
				correct_guesses++;
			} 
		}
		if (e.getSource()==buttonB) {
			answer= 'B';
			if (answer == answers[xi+3]) {
				correct_guesses++;
			}
		}
		if (e.getSource()==buttonC) {
			answer= 'C';
			if (answer == answers[xi+3]) {
				correct_guesses++;
			}
	     }
		if (e.getSource()==buttonD) {
			answer= 'D';
			if (answer == answers[xi+3]) {
				correct_guesses++;
			}
		}
	  }else if (x == 1) {
			if (e.getSource()==buttonA) {
				answer= 'A';
				if (answer == answers[xi-1]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonB) {
				answer= 'B';
				if (answer == answers[xi-1]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonC) {
				answer= 'C';
				if (answer == answers[xi-1]) {
					correct_guesses++;
				}
		     }
			if (e.getSource()==buttonD) {
				answer= 'D';
				if (answer == answers[xi-1]) {
					correct_guesses++;
				}
			}
	  }else if (x == 3) {
			if (e.getSource()==buttonA) {
				answer= 'A';
				if (answer == answers[xi+7]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonB) {
				answer= 'B';
				if (answer == answers[xi+7]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonC) {
				answer= 'C';
				if (answer == answers[xi+7]) {
					correct_guesses++;
				}
		     }
			if (e.getSource()==buttonD) {
				answer= 'D';
				if (answer == answers[xi+7]) {
					correct_guesses++;
				}
			}
	}
		
		displayAnswer();
		if (e.getSource()==nextButton) {
			tt = tt+4;
			nextPage();
			
		}
		if (e.getSource()==map) {
			nextButton.setVisible(false);
			textfield.setVisible(false);
			textarea.setVisible(false);
			map.setVisible(false);
			percentage.setVisible(false);
			number_right.setVisible(false);
			background.setVisible(false);
			answer_IconA.setVisible(false);
			answer_IconB.setVisible(false);
			answer_IconC.setVisible(false);
			answer_IconD.setVisible(false);
			Map men = new Map(frame , result);
		}
		
	}
	
	public void displayAnswer(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		answer_IconA.setIcon(wrong);
		answer_IconB.setIcon(wrong);
		answer_IconC.setIcon(wrong);
		answer_IconD.setIcon(wrong);

		if (x == 1) {
			if (answers[xi-1] == 'A') {
				answer_IconA.setIcon(right);
			}else if (answers[xi-1] == 'B') {
				answer_IconB.setIcon(right);
			}else if (answers[xi-1] == 'C') {
				answer_IconC.setIcon(right);
			}else if (answers[xi-1] == 'D') {
				answer_IconD.setIcon(right);
			}
		}else if (x == 2) {
			if (answers[xi+3] == 'A') {
				answer_IconA.setIcon(right);
			}else if (answers[xi+3] == 'B') {
				answer_IconB.setIcon(right);
			}else if (answers[xi+3] == 'C') {
				answer_IconC.setIcon(right);
			}else if (answers[xi+3] == 'D') {
				answer_IconD.setIcon(right);
			}
		}else if (x == 3) {
			if (answers[xi+7] == 'A') {
				answer_IconA.setIcon(right);
			}else if (answers[xi+7] == 'B') {
				answer_IconB.setIcon(right);
			}else if (answers[xi+7] == 'C') {
				answer_IconC.setIcon(right);
			}else if (answers[xi+7] == 'D') {
				answer_IconD.setIcon(right);
			}
		}
	}
			
	//@Override
	public void nextPage() {		
		answer_IconA.setIcon(null);
		answer_IconB.setIcon(null);
		answer_IconC.setIcon(null);
		answer_IconD.setIcon(null);
		
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);
		buttonD.setEnabled(true);
		index++;
		xi++;		
		nextQuestion(x);
					
	}
	
	public void results(){
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		//nextButton.setAction();
		result = correct_guesses*20;
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		buttonA.setText("");
		buttonB.setText("");
		buttonC.setText("");
		buttonD.setText("");
		
		number_right.setText(""+result);
		
		frame.add(number_right);
		frame.add(percentage);
		frame.remove(buttonA);
		frame.remove(buttonB);
		frame.remove(buttonC);
		frame.remove(buttonD);
		//we have to add a timer or a button to go back on the map(preferable a button)
	}

}
