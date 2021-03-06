package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
public class Findthewords implements ActionListener {
	ArrayList<JButton> buttons = new ArrayList<JButton>(); 
	ArrayList <String> question1 = new  ArrayList<String>();
	ArrayList <String> list1 = new  ArrayList<String>();
    ArrayList <String> gaps = new  ArrayList<String>();
    ArrayList <String> letters = new  ArrayList<String>();
    ArrayList<Integer> set = new  ArrayList<Integer>();
    JFrame frame;
	JPanel question_panel = new JPanel();
	JLayeredPane title_panel = new JLayeredPane();
	JLabel textfield = new JLabel();
	JLabel question = new JLabel();
	JPanel button_panel;
	JLabel pic = new JLabel();
	JLabel scrollpic = new JLabel();
	JButton nextlevel;   
	JButton next;       
	JLabel score1 = new JLabel();
	JPanel score_panel = new JPanel();       
	String filename;
    int picposition_y;
    int k = 0;  //counts the number of the letters that the user finds
    protected int count = 0;   //the index of a word in the arraylist
    private int tries = 0;
    int score = 0;	
    int color1;
	int color2;
	int color3;
	String data;
	BufferedImage pics;
	
	public Findthewords(JFrame frame, int position) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 236, 204));
		if (position == 1) {    //level sparta
			list1.add("LEONIDAS");   //add the words in list1
			list1.add("LYCURGUS");
			list1.add("BRAVENESS");
			list1.add("LAVE");
			question1.add("He was the king of Sparta");   //add the questions in list question1
			question1.add("He invented the laws in Sparta");
			question1.add("The Spartans became known for their");
	        question1.add("The famous phrase Leonidas said was molon");
	        try {
				pics = ImageIO.read(getClass().getResource("/sparta.jpeg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        pic.setIcon(new ImageIcon(pics));
	        color1 = 196;
	        color2 = 218;
	        color3 = 241;
	        filename = "spart.txt";
	        picposition_y = -10;
		} else if (position == 2) {  //level ithaca
			list1.add("ODYSSEUS");
			list1.add("PENELOPE");
			list1.add("ARGOS");
			list1.add("HOMER");	
		    question1.add("He was the king of Ithaca");
		    question1.add("She was Odyssea's wife");
		    question1.add("He was Odyssea's dog");
		    question1.add("He was the writter of Odyssey");
		    try {
				pics = ImageIO.read(getClass().getResource("/ithaca.jpeg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        pic.setIcon(new ImageIcon(pics));
		    color1 = 232;
		    color2 = 179;
	        color3 = 179;
	        filename = "ith.txt";
	        picposition_y = -10;
		} else if (position == 3) {   //level vergina
			list1.add("ALEXANDER");
			list1.add("PHILIP");
			list1.add("INDIA");
			list1.add("PELLA");	
		    question1.add("He was the most famous king of Macedonia");
		    question1.add("He was the father of Alexander");
		    question1.add("The country that the Great Alexander arrived");
		    question1.add("The historical capital of Macedonia");
		    try {
				pics = ImageIO.read(getClass().getResource("/vergina.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        pic.setIcon(new ImageIcon(pics));
		    color1 = 241;
	        color2 = 229;
	        color3 = 108;
	        filename = "verg.txt";
	        picposition_y = -95;
		}
		createframe();
	}
	public void actionPerformed(ActionEvent e) {
		/*
		 * Examine if the pressed button is the right letter then gaps list changes else player's tries are increased by one
		 */
		for (int i = 0; i < buttons.size(); i++) {
			if (e.getSource() == buttons.get(i)) {   
				if ((buttons.get(i).getText()).contains(letters.get(k))) {	
					gaps.set(k, letters.get(k));
					k++;
					buttons.get(i).setVisible(false);
				}else {
			         tries++;
			    }
			}  
		}
		StringBuilder builder = new StringBuilder();
		for (String gap : gaps) {
			builder.append(gap + " ");	      
		}
		textfield.setText(builder.toString()); 
		textfield.setVisible(true);
		wordcompleted();
		nextword();	
	}		        	
	public void nextword() {
		if (tries == 3) {
			StringBuilder builder = new StringBuilder();
			for (String letters : letters) {
				builder.append(letters + " ");	      
			}
			textfield.setVisible(true);
			textfield.setText(builder.toString()); 
			for (int i1 = 0; i1 < letters.size(); i1++) {
		    	buttons.get(i1).setEnabled(false);
		    }
			for (int i1 = 0; i1 < letters.size(); i1++) {
		    	buttons.get(i1).setEnabled(false);
		    }
			letters.clear();
			gaps.clear();
			set.clear();
			buttons.clear();
			count++;
			ActionListener b2 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {	  
					for (int i1 = 0; i1 < letters.size(); i1++) {
						button_panel.remove(buttons.get(i1));
					}   
					frame.remove(button_panel);         
					next.setVisible(false);
					letters.clear();
					gaps.clear();
					set.clear();
					question.setVisible(false);
					buttons.removeAll(buttons);
					title_panel.remove(next);
					frame.remove(next);
					createframe();	
				}
			};	
			next = new JButton("Next");
		    next.setFont(new Font("Times New Roman", Font.BOLD, 30));
			next.setBounds(500, 0, 100, 70);
			next.setForeground(new java.awt.Color(23, 36, 24));
			next.setFocusable(false);
			next.addActionListener(b2);
			next.setVisible(true);
			next.setBorder(BorderFactory.createBevelBorder(1));
			next.setOpaque(true);
			next.setBackground(new java.awt.Color(color1, color2, color3));
			title_panel.add(next,Integer.valueOf(2));
		}	 
	}
	public void wordcompleted() {
		if (k == letters.size()) {
			score += 10;
			count++;  
			ActionListener b2 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {	  
					for (int i1 = 0; i1 < letters.size(); i1++) {
						button_panel.remove(buttons.get(i1));
					}   
					frame.remove(button_panel);         
					next.setVisible(false);
					letters.clear();
					gaps.clear();
					set.clear();
					question.setVisible(false);
					buttons.removeAll(buttons);
					title_panel.remove(next);
					frame.remove(next);
					createframe();	
				}
			};	
			next = new JButton("Next");
			next.setFont(new Font("Times New Roman", Font.BOLD, 30));
			next.setBounds(500, 0, 100, 70);
			next.setForeground(new java.awt.Color(23, 36, 24));
			next.setFocusable(false);
			next.addActionListener(b2);
			next.setVisible(true);
			next.setBorder(BorderFactory.createBevelBorder(1));
			next.setOpaque(true);
			next.setBackground(new java.awt.Color(color1, color2, color3));
			title_panel.add(next, Integer.valueOf(2));
		}	
	}
	public void createframe() {  
		k = 0;                  //set k to 0 for new word
		tries = 0;			  //set tries to 0 for new word
		/*
		 * if word is the last one display score, level completed, if not display frame with the next word
		 */
		if (count >= 4) {
			scorepanels();
		} else {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(608, 800));
			frame.getContentPane().setBackground(new java.awt.Color(color1, color2, color3));
			frame.setLayout(new BorderLayout());
			frame.setLocationRelativeTo(null);   
		    frame.setResizable(false);
			question = new JLabel(question1.get(count));
			question.setFont(new java.awt.Font("Times New Roman", Font.BOLD , 29));
			question.setHorizontalAlignment(JLabel.CENTER);
			question.setForeground(new java.awt.Color(0, 0, 102));
			question_panel.setBackground(new java.awt.Color(color1, color2, color3));
			question_panel.add(question);
			question.setVisible(true);
			question_panel.setVisible(true);
			question.setBounds(0, 0, 620, 300);
			createlists();   
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < letters.size(); i++) {
				builder.append(gaps.get(i)+" ");   
				textfield.setText(builder.toString());
			} 	  
			textfield.setBackground((new java.awt.Color(color1, color2, color3)));
			textfield.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 30));
			textfield.setBounds(107, 95, 385, 50);
			textfield.setHorizontalAlignment(JLabel.CENTER);
			textfield.setOpaque(true);
			textfield.setForeground(new java.awt.Color(51, 0, 51));
			textfield.setVisible(true);
			if (count == 0) { 
				 pic.setBounds(0, picposition_y, 610, 800);
				 title_panel.add(pic, Integer.valueOf(0));
				 title_panel.add(textfield, Integer.valueOf(1));
			}
			button_panel = new JPanel();   
			for (int i = 0; i<letters.size(); i++) {
				Random r = new Random();  
				button_panel.setBounds(0, 0, 608, 100);	
				buttons.add( new JButton(letters.get(set.get(i))));
				button_panel.add(buttons.get(i));
				buttons.get(i).setFont(new Font("Times New Roman", Font.BOLD, 35));
				buttons.get(i).setBounds(250, 250, 20, 20);
				button_panel.setLayout(new GridLayout(letters.size() / 3, letters.size() / 2));
				buttons.get(i).setForeground(new java.awt.Color(r.nextInt(152), r.nextInt(203), r.nextInt(254)));
				buttons.get(i).setFocusable(false);
				buttons.get(i).addActionListener(this);
				buttons.get(i).setVisible(true);	
				buttons.get(i).setContentAreaFilled(false);
				buttons.get(i).setBorderPainted(false);
			} 		
			button_panel.setBackground(new java.awt.Color(color1, color2, color3));
			title_panel.setVisible(true);
			button_panel.setVisible(true);
			frame.add(title_panel,BorderLayout.CENTER);
			frame.add(question_panel,BorderLayout.NORTH);
			frame.add(button_panel,BorderLayout.SOUTH);		
			frame.setVisible(true);
		}	 
	}
	private void scorepanels() {
		frame.remove(question_panel);
		frame.remove(next);
		frame.remove(button_panel);
		frame.remove(title_panel);
		for (int i1 = 0; i1 < letters.size(); i1++) {
			button_panel.remove(buttons.get(i1));
		}
		score1.setText("RESULT:  " + score);
		score_panel.setBackground(new java.awt.Color(color1, color2, color3));
		score_panel.setBorder(BorderFactory.createBevelBorder(1));
		score1.setForeground(new java.awt.Color(51, 0, 51));
		score1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		score1.setBounds(300, 400, 400, 310);
		score1.setHorizontalAlignment(JLabel.CENTER);
		score1.setLayout(new BorderLayout());
		score1.setVisible(true);
		score_panel.setBounds(0, 0, 608, 200);
		score_panel.add(score1); 
		ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				frame.remove(score_panel);
				frame.remove(button_panel);
				frame.remove(title_panel);
				new Map(frame, score);
			}
		};	
		nextlevel = new JButton("MAP"); 
		nextlevel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		nextlevel.setBounds(0, 0, 100, 80);
		nextlevel.setForeground(new java.awt.Color(51, 0, 51));
		nextlevel.setBackground(new java.awt.Color(color1, color2, color3));
		nextlevel.setFocusable(false);
		nextlevel.setBorder(BorderFactory.createBevelBorder(1));
		nextlevel.addActionListener(b1);
		nextlevel.setVisible(true);
		title_panel = new JLayeredPane();
		title_panel.setBounds(0, -80, 608, 800);
		pic.setBounds(0, picposition_y, 610, 800);
		title_panel.add(pic, Integer.valueOf(0));
		try {
			pics = ImageIO.read(getClass().getResource("/scroll.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        scrollpic.setIcon(new ImageIcon(pics));
		scrollpic.setBounds(120, -10, 400, 590);
		title_panel.add(scrollpic, Integer.valueOf(1));
		readfile();
		score_panel.add(score1);
		score_panel.setVisible(true);
		title_panel.setVisible(true);
		title_panel.add(nextlevel, Integer.valueOf(1));
		frame.add(score_panel, BorderLayout.NORTH);		
		frame.add(title_panel);			
	}
	private void readfile() {
		int y = 0;
		try (InputStream inputStream = getClass().getResourceAsStream("/"+filename);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			    while (reader.readLine()!=null) {
			      String contents = reader.readLine();
		    	  JLabel info = new JLabel(contents);
		    	  info.setForeground(Color.black);
		    	  info.setFont(new Font("Times New Roman", Font.BOLD, 27));
		    	  info.setBounds(177, -150 + y, 500, 600);
		    	  title_panel.add(info, Integer.valueOf(2));
		    	  y += 27;
			    }
			} catch (IOException e1) {
				e1.printStackTrace();
		}
	}
	public void createlists() {
		/*
		* Split the word and create a list with the letters of the word 
		*/
		List<String> l = new ArrayList <String>(Arrays.asList(list1.get(count).split("")));
		letters.addAll(l);			
		for(int i = 0; i < letters.size(); i++) {
			gaps.add("__");
		}
		for(int i = 0; i < letters.size(); i++) {
			set.add(i);
		}
		int x = letters.size();
	    Random random = new Random();
		for (int i = 0; i < x; i++) {
			int randomIndex = random.nextInt(x);
			int temp = set.get(randomIndex);
			set.set(randomIndex, set.get(i));
			set.set(i, temp);
		} 
	}
}

