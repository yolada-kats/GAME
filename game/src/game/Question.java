package game;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.*;
import javax.swing.*;


public class Question implements ActionListener {
	
	String[] questions1 = {
			                  "1. Who was the king of Mycenae?",
						      "2. Who killed his mother in Mycenae era ? ",
			                  "3. Mycenaeans did leave behind a written language. What is it called?"/* don't know the answer*/,
	                     	  "4. What animal guarded the famous gate into Mycenae?",
                          };
	                     	  
	String[] questions2 = {
							  "1. For what thing is known the Cycladitic civilization?",
	                     	  "2. How did the Cyclades form?",
	                     	  "3. Where were te Cyclades located?",
	                     	  "4. In Delos were born...?",
						};
	                     	 
	String[] questions3 = {   "1. Who was the daughter of the Minoan king?",
	                     	  "2. The ruins of a number of multi-functional architectural complexes have been excavated on the island. What is the best known of these 'palaces'?",
	                     	  "3. Which was a sacred symbol for the Minoans?",
	                     	  "4. Who was the gurdian of the labyrinth?",
	                     };
	
	String[][] options1 =  {
			                {"Periklis","King Alexander","Agamemnon","Leonidas"},
			                {"Orestis","Achilleas","Patroklos","Diomidis" },
			                {"Linear B","Hieroglyphics","Linear A","Demotic"},
			                {"Tiger","Panther","Lion","Dog"},
			                
	                       };
	
	String[][] options2 =  {
							{"War","Monuments","Art","Kings"},
			                {"Erruption","Earthquake","Collision","Big Bang"},
			                {"Attiki","Aegean","Peleponissos","Ionian sea"},
			                {"Apollo and Artemis","Athena","Zeus","Aphrodite"},
			                
						   };
	
	String[][] options3 = {
							{"Ermioni","Iphigeneia","Cassandra","Ariadne"},
			                {"Colosseum","Delphi","Knossos","Parthenon"},
			                {"sacred horns","the axe","the bull","the sea"},
			                {"Hydra","Minotayros","the lion of Nemea","Ades"}
			
			
	                      };
	
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
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	//background label
	JLabel background = new JLabel();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	//next button
	JButton nextButton = new JButton();
	JLabel answer_IconA = new JLabel();
	JLabel answer_IconB = new JLabel();
	JLabel answer_IconC = new JLabel();
	JLabel answer_IconD = new JLabel();
	
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	ImageIcon delos = new ImageIcon("game/src/game/delos.png");
	ImageIcon right = new ImageIcon("game/src/game/right-removebg-preview.png");
	ImageIcon wrong = new ImageIcon("game/src/game/wrong-removebg-preview.png");
	
	public Question(int x) {
		this.x = x;
		
		//te background settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,580);
		frame.getContentPane().setBackground(new Color(255,255,153));
		frame.setLayout(null);
		frame.setResizable(false);
		
		background.setBounds(0, 0, 960, 600);
		if (x==1) {
			//background.setIcon();
		}else if (x==2) {
			background.setIcon(delos);
		}else if (x==3) {
			//background.setIcon();
		}
		background.setVisible(true);
		
		textfield.setBounds(0,0,800,50);
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
		
		
		buttonA.setBounds(250,150,300,50);
		buttonA.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonA.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		//buttonA.setIcon(column);
		
		buttonA.setOpaque(false);
		buttonA.setContentAreaFilled(false);
		buttonA.setBorderPainted(false);
		
		//buttonA.setText("A");
		
		buttonB.setBounds(250,245,300,50);
		buttonB.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonB.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		//buttonB.setText("B");
		
		
		buttonB.setOpaque(false);
		buttonB.setContentAreaFilled(false);
		buttonB.setBorderPainted(false);
		
		buttonC.setBounds(250,345,300,50);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		//buttonC.setText("C");
		
		
		buttonC.setOpaque(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		
		buttonD.setBounds(250,455,300,50);
		//buttonD.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonD.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		
		buttonD.setOpaque(false);
		buttonD.setContentAreaFilled(false);
		buttonD.setBorderPainted(false);
		
		answer_IconA.setBounds(150, 150, 100, 70);
		answer_IconB.setBounds(150, 245, 100, 70);
		answer_IconC.setBounds(150, 345, 100, 70);
		answer_IconD.setBounds(150, 455, 100, 70);
		
		//the button for the next question 
		ImageIcon next_arrow = new ImageIcon("download-removebg-preview (1).png");
		
		nextButton.setBounds(650,100,150,50);
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
		
		number_right.setBounds(200, 130, 400, 400);
		number_right.setBackground(new Color(238,236,194));
		number_right.setForeground(new Color(0,0,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		frame.add(nextButton);
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
			textarea.setText(questions1[index]);
			buttonA.setText(options1[index][0]);
			buttonB.setText(options1[index][1]);
			buttonC.setText(options1[index][2]);
			buttonD.setText(options1[index][3]);
			
		}
		
	}else if (c==2) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(questions2[index]);
				buttonA.setText(options2[index][0]);
				buttonB.setText(options2[index][1]);
				buttonC.setText(options2[index][2]);
				buttonD.setText(options2[index][3]);
		    }
	}else if (c==3) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(questions3[index]);
				buttonA.setText(options3[index][0]);
				buttonB.setText(options3[index][1]);
				buttonC.setText(options3[index][2]);
				buttonD.setText(options3[index][3]);
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
			nextPage();
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
		//we have to add a timer or a button to go back on the map(preferable a button)
	}

}
