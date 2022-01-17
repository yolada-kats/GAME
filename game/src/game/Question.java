package game;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Question implements ActionListener {
	static ArrayList <String>  question1 = new ArrayList<String>();  
	static {
		question1.add("1. Who was the king of Mycenae?");  
		question1.add("2. Who killed his mother in Mycenae?");  
		question1.add("3. Mycenaeans did leave behind a written language. What is it called?");  
		question1.add("4. What animal guarded the famous gate in Mycenae?");  
	}
	static ArrayList <String>  question2 = new ArrayList<String>();
	static {
		question2.add("1. For which thing is the Cycladitic civilization known?");
	    question2.add("2. How did the Cyclades form?");
		question2.add("3. Where are the Cyclades located?");
		question2.add("4. Who was born there?");
	}
	
	static ArrayList <String>  question3 = new ArrayList<String>();
	static {
		question3.add("1. Who was the daughter of the Minoan king?");
		question3.add("2. What is the best known architectural complexes that have been excavated in Crete?");
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
			' '
	};
	String filename;
	char guess;
	char answer;
	int index;
	String data;
	int correct_guesses = 0;
	int total_questions = 4;
	int result;
	int xi = 1;
	int t = 1;
	//the x shows in which city we are located
	int x;
	int tt = 0;
	JFrame frame;
	Image img1,img2,img3,img4,img5,img6;
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	//background label
	JLabel scrollLabel = new JLabel();
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

	
	
	
	
	//color that changes, for buttons and text areas 
	Color color;
	public Question(int x, JFrame frame) {
		this.x = x;
		this.frame = frame;
		//the background settings
		try {
			img1 = ImageIO.read(getClass().getResource("/dilos.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			img2 = ImageIO.read(getClass().getResource("/crete.jpg"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			img3 = ImageIO.read(getClass().getResource("/mycenae.jpg"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		try {
			img4 = ImageIO.read(getClass().getResource("/right-removebg-preview.png"));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		try {
			img5 = ImageIO.read(getClass().getResource("/wrong-removebg-preview.png"));
		} catch (IOException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		
		try {
			img6 = ImageIO.read(getClass().getResource("/scroll.png"));
		} catch (IOException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(238, 236, 194));
		frame.setLayout(null);
		frame.setResizable(false);
		scrollLabel.setBounds(122, 150, 350, 495);
		scrollLabel.setIcon(new ImageIcon(img6));
		scrollLabel.setForeground(Color.BLACK);
		scrollLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
		scrollLabel.setIconTextGap(-100);
		scrollLabel.setHorizontalTextPosition(JLabel.CENTER);
		scrollLabel.setVerticalTextPosition(JLabel.TOP);
		scrollLabel.setVisible(true);
		background.setSize(608, 800);
		if (x == 1) {
			background.setIcon(new ImageIcon(img1));
			color = new Color(255, 225, 185);
			filename = "myk.txt";
		} else if (x == 2) {
			background.setIcon(new ImageIcon(img2));
			color = new Color(229, 254, 255);
			filename = "dil.txt";
		} else if (x == 3) {
			background.setIcon(new ImageIcon(img3));
			color = new Color(212, 241, 255);
			filename = "cret.txt";
		}
		background.setVisible(true);
		textfield.setBounds(0, 0, 620, 50);
		textfield.setBackground(color);
		textfield.setForeground(new Color(0, 0, 0));
		textfield.setFont(new Font("Times New Roman", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createLineBorder(Color.black));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		frame.add(textfield);
		frame.setVisible(true);
		textarea.setBounds(0, 50, 608, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(color);
		textarea.setForeground(new Color(0, 0, 0));
		textarea.setFont(new Font("Times New Roman", Font.BOLD,20));
		textarea.setBorder(BorderFactory.createLineBorder(Color.black));
		textarea.setEditable(false);
		buttonA.setBounds(150,200,320,50);
		buttonA.setFont(new Font("Times New Roman",Font.BOLD, 30));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setEnabled(true);
		buttonA.setBackground(new Color(233, 232, 210));
		buttonA.setBorder(BorderFactory.createLineBorder(new Color(129, 129, 119), 2, true));
		buttonB.setBounds(150, 333, 320, 50);
		buttonB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setEnabled(true);	
		buttonB.setBackground(new Color(233, 232, 210));
		buttonB.setBorder(BorderFactory.createBevelBorder(1));
		buttonB.setBorder(BorderFactory.createLineBorder(new Color(129, 129, 119), 2, true));
		
		buttonC.setBounds(150, 466, 320, 50);
		buttonC.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setEnabled(true);	
		buttonC.setBackground(new Color(233, 232, 210));
		buttonC.setBorder(BorderFactory.createBevelBorder(1));
		buttonC.setBorder(BorderFactory.createLineBorder(new Color(129, 129, 119), 2, true));
		
		buttonD.setBounds(150, 600, 320, 50);
		buttonD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setEnabled(true);
		buttonD.setBackground(new Color(233, 232, 210));
		buttonD.setBorder(BorderFactory.createBevelBorder(1));
		buttonD.setBorder(BorderFactory.createLineBorder(new Color(129, 129,119), 2, true));
		
		answer_IconA.setBounds(50, 190, 120, 70);
		answer_IconB.setBounds(50, 323, 120, 70);
		answer_IconC.setBounds(50, 456, 120, 70);
		answer_IconD.setBounds(50, 590, 120, 70);
		 
		ImageIcon next_arrow = new ImageIcon("download-removebg-preview (1).png");
		map.setBounds(0, 100, 150, 50);
		map.addActionListener(this);
		map.setFont(new Font("Times New Roman", Font.BOLD, 25));
		map.setFocusable(false);
		map.setText("MAP");
		map.setIcon(next_arrow);
		map.setHorizontalTextPosition(JButton.LEFT);
		map.setIconTextGap(20);
		map.setBackground(color);
		map.setForeground(Color.black);
		map.setBorder(BorderFactory.createLineBorder(Color.black));
		
		nextButton.setBounds(470, 100, 150, 50);
		nextButton.addActionListener(this);
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		nextButton.setFocusable(false);
		nextButton.setText("Next");
		nextButton.setIcon(next_arrow);
		nextButton.setHorizontalTextPosition(JButton.LEFT);
		nextButton.setIconTextGap(20);
		nextButton.setBackground(color);
		nextButton.setForeground(Color.black);
		nextButton.setBorder(BorderFactory.createLineBorder(Color.black));
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
		if (c == 1) {
			if (index >= total_questions) {
				nextButton.setEnabled(false);
				buttonA.setVisible(false);
				buttonB.setVisible(false);
				buttonC.setVisible(false);
				buttonD.setVisible(false);
				frame.remove(buttonA);
				frame.remove(buttonB);
				frame.remove(buttonC);
				frame.remove(buttonD);
				results();
			} else {
				textfield.setText("Question" + (index + 1));
				textarea.setText(question1.get(index));
				buttonA.setText(options1.get(tt));
				buttonB.setText(options1.get(tt + 1));
				buttonC.setText(options1.get(tt + 2));
				buttonD.setText(options1.get(tt + 3));	
			}
		}else if (c == 2) {
			if (index >= total_questions) {
				nextButton.setEnabled(false);
				buttonA.setVisible(false);
				buttonB.setVisible(false);
				buttonC.setVisible(false);
				buttonD.setVisible(false);
				frame.remove(buttonA);
				frame.remove(buttonB);
				frame.remove(buttonC);
				frame.remove(buttonD);
				results();
			} else {
				textfield.setText("Question" + (index + 1));
				textarea.setText(question2.get(index));
				buttonA.setText(options2.get(tt));
				buttonB.setText(options2.get(tt + 1));
				buttonC.setText(options2.get(tt + 2));
				buttonD.setText(options2.get(tt + 3));
		    }
		} else if (c == 3) {
			if(index >= total_questions) {
				nextButton.setEnabled(false);
				buttonA.setVisible(false);
				buttonB.setVisible(false);
				buttonC.setVisible(false);
				buttonD.setVisible(false);
				frame.remove(buttonA);
				frame.remove(buttonB);
				frame.remove(buttonC);
				frame.remove(buttonD);
				results();
			} else {
				textfield.setText("Question" + (index + 1));
				textarea.setText(question3.get(index));
				buttonA.setText(options3.get(tt));
				buttonB.setText(options3.get(tt + 1));
				buttonC.setText(options3.get(tt + 2));
				buttonD.setText(options3.get(tt + 3));
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		if (x == 2) {
			if (e.getSource() == buttonA) {
				answer = 'A';
				if (answer == answers[xi + 3]) {
					correct_guesses++;
				} 
			}
			if (e.getSource() == buttonB) {
				answer = 'B';
				if (answer == answers[xi + 3]) {
					correct_guesses++;
				}
			}
			if (e.getSource() == buttonC) {
				answer= 'C';
				if (answer == answers[xi + 3]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonD) {
				answer = 'D';
				if (answer == answers[xi + 3]) {
					correct_guesses++;
				}
			}
		}else if (x == 1) {
			if (e.getSource() == buttonA) {
				answer= 'A';
				if (answer == answers[xi - 1]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonB) {
				answer = 'B';
				if (answer == answers[xi - 1]) {
					correct_guesses++;
				}
			}
			if (e.getSource() == buttonC) {
				answer = 'C';
				if (answer == answers[xi - 1]) {
					correct_guesses++;
				}
		     }
			if (e.getSource()==buttonD) {
				answer = 'D';
				if (answer == answers[xi - 1]) {
					correct_guesses++;
				}
			}
		}else if (x == 3) {
			if (e.getSource() == buttonA) {
				answer = 'A';
				if (answer == answers[xi + 7]) {
					correct_guesses++;
				}
			}
			if (e.getSource()==buttonB) {
				answer = 'B';
				if (answer == answers[xi + 7]) {
					correct_guesses++;
				}
			}
			if (e.getSource() == buttonC) {
				answer = 'C';
				if (answer == answers[xi + 7]) {
					correct_guesses++;
				}
		    }
			if (e.getSource()==buttonD) {
				answer = 'D';
				if (answer == answers[xi + 7]) {
					correct_guesses++;
				}
			}	
		}
		displayAnswer();
		if (e.getSource() == nextButton) {
			tt = tt + 4;
			nextPage();
			
		}
		if (e.getSource() == map) {
			frame.remove(nextButton);
			frame.remove(textfield);
			frame.remove(textarea);
			frame.remove(map);
			frame.remove(background);
			frame.remove(answer_IconA);
			frame.remove(answer_IconB);
			frame.remove(answer_IconC);
			frame.remove(answer_IconD);
			frame.remove(buttonA);
			frame.remove(buttonB);
			frame.remove(buttonC);
			frame.remove(buttonD);
			frame.remove(scrollLabel);
			new Map(frame, result);
		}
		
	}
	
	public void displayAnswer(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		answer_IconA.setIcon(new ImageIcon(img5));
		answer_IconB.setIcon(new ImageIcon(img5));
		answer_IconC.setIcon(new ImageIcon(img5));
		answer_IconD.setIcon(new ImageIcon(img5));

		if (x == 1) {
			if (answers[xi - 1] == 'A') {
				answer_IconA.setIcon(new ImageIcon(img4));
			} else if (answers[xi - 1] == 'B') {
				answer_IconB.setIcon(new ImageIcon(img4));
			} else if (answers[xi - 1] == 'C') {
				answer_IconC.setIcon(new ImageIcon(img4));
			} else if (answers[xi - 1] == 'D') {
				answer_IconD.setIcon(new ImageIcon(img4));
			}
		}else if (x == 2) {
			if (answers[xi + 3] == 'A') {
				answer_IconA.setIcon(new ImageIcon(img4));
			}else if (answers[xi + 3] == 'B') {
				answer_IconB.setIcon(new ImageIcon(img4));
			}else if (answers[xi + 3] == 'C') {
				answer_IconC.setIcon(new ImageIcon(img4));
			}else if (answers[xi + 3] == 'D') {
				answer_IconD.setIcon(new ImageIcon(img4));
			}
		} else if (x == 3) {
			if (answers[xi + 7] == 'A') {
				answer_IconA.setIcon(new ImageIcon(img4));
			} else if (answers[xi + 7] == 'B') {
				answer_IconB.setIcon(new ImageIcon(img4));
			} else if (answers[xi + 7] == 'C') {
				answer_IconC.setIcon(new ImageIcon(img4));
			} else if (answers[xi + 7] == 'D') {
				answer_IconD.setIcon(new ImageIcon(img4));
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
	
	public void results() {
		result = correct_guesses * 10;
		textfield.setText("RESULTS:" + result);
		textarea.setText("");
		int y1 =- 175;
		if(filename.equals("dil.txt")) {
			y1 =- 204;
		}
		int y = 0;
		try {
			File file = new File("game/src/game/" + filename);
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
			    JLabel info = new JLabel(data);
			    info.setForeground(Color.black);
			    info.setFont(new Font("Times New Roman", Font.BOLD, 27));
		        info.setBounds(60, y1 + y, 500, 600);
	            scrollLabel.add(info);
	            y += 27;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		background.add(scrollLabel);
	}
}
