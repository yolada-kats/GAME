package game;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Question implements ActionListener {
	
	String[] questions1 = {
			                  "1. Who was the king of Mycenae?",
						      "2. Who killed his mother in Mycenae era ? ",
			                  "3. Which amateur archaeologist, perhaps better known for discovering Troy, also uncovered Mycenaean grave circles?",
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
	                     	  "3. Which of the following has been proposed as a contributing, or correlating, factor in the decline of the Minoan civilisation?",
	                     	  "4. Who was the gurdian of the labyrinth?",
	                     };
	
	String[][] options1 =  {
			                {"Periklis","King Alexander","Agamemnon","Leonidas"},
			                {"Orestis","Achilleas","Patroklos","Diomidis" },
			                {"Arthur Evans","Heinrich Schliemann","Howard Carter","Lord Carnavon"},
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
			                {"Eruption of volcanic island Thera (modern day Santorini)","Conquest by Alexander the Great.","Invasion and occupation by Mycenaeans","Decline in use of bronze in favour of iron"},
			                {"Hydra","Minotayros","the lion of Nemea","Ades"}
			
			
	                      };
	
	char[] answers = {
			            'C',
			            'A',
			            'B',
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
	//int seconds=10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	//JLabel time_label = new JLabel();
	
	JTextField number_right = new JTextField();
	//JTextField seconds_left = new JTextField();
	JTextField percentage = new JTextField();
	int x;
	public Question(int x) { 
		this.x = x;
		
		//te background settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(255,255,153));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(51,153,255));
		textfield.setForeground(new Color(255,255,153));
		textfield.setFont(new Font(" CASTELLAR",Font.BOLD,30));
		//textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		frame.add(textfield);
		frame.setVisible(true);
		
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(51,153,255));
		textarea.setForeground(new Color(255,255,153));
		textarea.setFont(new Font("Times New Roman",Font.BOLD,20));
		//textarea.setFont(new Font("MV BOLI",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonA.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("Times New Roman",Font.BOLD,30));
		//buttonB.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		//buttonD.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonD.setFont(new Font("Times New Roman",Font.BOLD,30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(51,153,255));
		answer_labelA.setForeground(new Color(51,153,255));
		answer_labelA.setFont(new Font("MV BOLI",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(51,153,255));
		answer_labelB.setForeground(new Color(51,153,255));
		answer_labelB.setFont(new Font("MV BOLI",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(51,153,255));
		answer_labelC.setForeground(new Color(51,153,255));
		answer_labelC.setFont(new Font("MV BOLI",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(51,153,255));
		answer_labelD.setForeground(new Color(51,153,255));
		answer_labelD.setFont(new Font("MV BOLI",Font.PLAIN,35));
		
		//seconds_left.setBounds(535,510,100,100);
		//seconds_left.setBackground(new Color(25,25,25));
		//seconds_left.setForeground(new Color(255,0,0));
		//seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		//seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		//seconds_left.setOpaque(true);
		//seconds_left.setHorizontalAlignment(JTextField.CENTER);
		//seconds_left.setText(String.valueOf(seconds));
		
		//time_label.setBounds(535,475,100,25);
		//time_label.setBackground(new Color(50,50,50));
		//time_label.setForeground(new Color(255,0,0));
		//time_label.setFont(new Font("Ink Free",Font.PLAIN,16));
		//time_label.setHorizontalAlignment(JTextField.CENTER);
		//time_label.setText("timer");

		
		
		
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		
		//frame.add(time_label);
		//frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		
		
		nextQuestion(x);
		
		
    }
	
	 
	
	
	public  void nextQuestion(int c) {
		
	if (c==0) {
			
		
		if(index>=total_questions) {
			results();
		}else {
			
			textfield.setText("Question"+(index+1));
			textarea.setText(questions1[index]);
			answer_labelA.setText(options1[index][0]);
			answer_labelB.setText(options1[index][1]);
			answer_labelC.setText(options1[index][2]);
			answer_labelD.setText(options1[index][3]);
			
		}
		
	}else if (c==1) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(questions2[index]);
				answer_labelA.setText(options2[index][0]);
				answer_labelB.setText(options2[index][1]);
				answer_labelC.setText(options2[index][2]);
				answer_labelD.setText(options2[index][3]);
				
			
		    }
		}else if (c==2) {
			
			if(index>=total_questions) {
				results();
			}else {
				
				textfield.setText("Question"+(index+1));
				textarea.setText(questions3[index]);
				answer_labelA.setText(options3[index][0]);
				answer_labelB.setText(options3[index][1]);
				answer_labelC.setText(options3[index][2]);
				answer_labelD.setText(options3[index][3]);
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		 
		
	  if(x==1) {
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
	  }
		
		displayAnswer();
		
	}
		
	
	public void displayAnswer(){
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
	  if(x==1) {
		
		if (answers[xi+3] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if (answers[xi+3] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if (answers[xi+3] != 'C')
		answer_labelC.setForeground(new Color(255,0,0));
		if (answers[xi+3] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
	
		
		Timer pause = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(51,153,255));
				answer_labelB.setForeground(new Color(51,153,255));
				answer_labelC.setForeground(new Color(51,153,255));
				answer_labelD.setForeground(new Color(51,153,255));
				
				//answer = ' ' ;
				//seconds=10;
				//seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				xi++;
				
				//int w= returnCalcu(calcu);
				nextQuestion(x);
				
				
				
			 } 	
		
		});
		pause.start();
	  }	
   }
	
	public void results(){
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("(" +correct_guesses+ "/"+total_questions +")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
		
		
		
	}
	

}

