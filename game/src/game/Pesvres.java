package game;

import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;  

public class Pesvres implements ActionListener{  
    static JTextField tf1,tf2,tf3,tf4,tf5;  
    static JButton b1,b2; 
    private int score = 0 ;
    JLabel contentPane;
    static ArrayList <String> solutions = new ArrayList<String>();
    
    ImageIcon right = new ImageIcon("game/src/game/right-removebg-preview.png");
	ImageIcon wrong = new ImageIcon("game/src/game/wrong-removebg-preview.png");
	ImageIcon athens = new ImageIcon("game/src/game/athens.jpg");

	JLabel answer_IconA = new JLabel();
	JLabel answer_IconB = new JLabel();
	JLabel answer_IconC = new JLabel();
	JLabel answer_IconD = new JLabel();
	JLabel answer_IconE = new JLabel();
	JLabel background = new JLabel();
	
	JTextField textfield = new JTextField();
	
    private String place;
	private Object answer1;
	private Object answer2;
	private Object answer3;
	private Object answer4;
	private Object answer5;
	private boolean f1, f2, f3, f4, f5;
	
	
	 JFrame f= new JFrame();
    
    	Pesvres(String place){ 
    	this.place = place; 
    		
        
      //the background settings
      		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		f.setSize(800,500);
      		f.getContentPane().setBackground(new Color(250,200,153));
      		f.setLayout(null);
      		f.setResizable(false);
      		
      		background.setBounds(0, 0, 100, 100);
      		if ("ATHENS".contentEquals(place)) {
      			background.setIcon(athens);
      		}else if ("THERMOPYLES".contentEquals(place)) {
      			//
      		}else if ("DELFOI".contentEquals(place)) {
      			//background.setIcon();
      		}
      		background.setVisible(true);
      		f.add(background);
     
        tf1=new JTextField();  
        tf1.setBounds(190, 120, 180, 30);  
        tf2=new JTextField();  
        tf2.setBounds(190, 170, 180, 30); 
        tf4=new JTextField();  
        tf4.setBounds(190, 220, 180, 30); 
        tf5=new JTextField();  
        tf5.setBounds(190, 270, 180, 30); 
        tf3=new JTextField();  
        tf3.setBounds(190, 320, 180, 30);  
        
        JLabel lblNewLabel = new JLabel("Write 5 words-phrases related to this destination");
		lblNewLabel.setBounds(90, 30, 500, 80);
		lblNewLabel.setForeground(new Color(200, 100, 102));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
	
		answer_IconA.setBounds(150, 120, 100, 70);
		answer_IconB.setBounds(150, 170, 100, 70);
		answer_IconC.setBounds(150, 210, 100, 70);
		answer_IconD.setBounds(150, 250, 100, 70);
		answer_IconE.setBounds(150, 290, 100, 70);
		
		f.add(answer_IconA);
		f.add(answer_IconB);
		f.add(answer_IconC);
		f.add(answer_IconD);
		f.add(answer_IconE);
         
        b1=new JButton("Back to Map");  
        b1.setBounds(90,420,150,35);  
        b2=new JButton("Next");  
        b2.setBounds(370,420,80,35);  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);f.add(b2); f.add(tf4);f.add(tf5);f.add(lblNewLabel);
        f.setSize(600,600);  
        f.setLayout(null);  
        f.setVisible(true);  
    }    
    
    
    public void setValues () {
    		if("ATHENS".equals(place)) {
    			solutions.clear();
    		
    		     solutions.add("ACROPOLIS");
    		     solutions.add("PERICLES");
    			 solutions.add("GOLDEN AGE");
    			 solutions.add("PARTHENON");
    			 solutions.add("DEMOCRACY");
    			 solutions.add("CAPITAL CITY");
    			 solutions.add("SOCRATES");
    			 solutions.add("CIVILIZATION");
    			 solutions.add("PLATO");
    		
    		
    	} else if("THERMOPYLES".equals(place)) {
    		solutions.clear();
    		
    		 solutions.add("LEONIDAS");
			 solutions.add("XERXES");
			 solutions.add("BATTLE");
			 solutions.add("EPHIALTES");
			 solutions.add("PERSIANS");
			 solutions.add("HERODOTUS");
			 solutions.add("SPARTANS");
			 solutions.add("THEMISTOCLES");
			 solutions.add("480BC");
			 solutions.add("MOLON LABE");
    	}
    		actionPerformed(null);
    }
    						
    	 @Override
    	 public void actionPerformed(ActionEvent e) { 

			while(e.getSource()!=b1)
				answer1 = tf1.getText();  	
				answer2 = tf2.getText();
				answer3 = tf3.getText();	
				answer4 = tf4.getText();
				answer5 = tf5.getText();	
				
				if(solutions.contains(answer1) && (f1==false))	{
					f1 = true;
					this.score++;
				}	
				if(solutions.contains(answer2) && (f2==false)){
					f2 = true;
					this.score++;
				}
				if(solutions.contains(answer3) && (f3==false)){
					f3 = true;
					this.score++;
				}
				if(solutions.contains(answer4) && (f4==false)){
					f4 = true;
					this.score++;
				}
				if(solutions.contains(answer5) && (f5==false)){
					f5 = true;
					this.score++;
				}
				displayAnswer(f1,f2,f3,f4,f5);
		}	
				
    		
    	 public void displayAnswer(boolean f1, boolean f2, boolean f3, boolean f4, boolean f5) {
    		    answer_IconA.setIcon(wrong);
    			answer_IconB.setIcon(wrong);
    			answer_IconC.setIcon(wrong);
    			answer_IconD.setIcon(wrong);
    			b1.setEnabled(false);
    			
			if(f1 == true) {
				answer_IconA.setIcon(right);
			}
			if(f2 == true) {
				answer_IconB.setIcon(right);
			}
			if(f3 == true) {
				answer_IconC.setIcon(right);
			}
			if(f4 == true) {
				answer_IconD.setIcon(right);
			}
			if(f5 == true) {
				answer_IconE.setIcon(right);
			}
			;
			textfield.setText("Your score is : "+ score);
			f.add(textfield);
    	 }	
				 
        	
public static void main(String[] args) {  
   /* new Pesvres("ATHENS");*/
	Pesvres athens = new Pesvres("ATHENS");
	athens.setValues();
    
} }  