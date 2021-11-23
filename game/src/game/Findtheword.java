import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Findtheword implements ActionListener{
	    
		JButton[] buttons = new JButton[15];
		JFrame frame= new JFrame();
		JPanel question_panel = new JPanel();
		JPanel title_panel = new JPanel();
		JLabel textfield = new JLabel();
		JLabel question = new JLabel();
		JPanel button_panel = new JPanel();
		int k;
		boolean t = false;
		private String[] word = new String[6];
		String[] array = new String[15];
		int n[] = new int[15];
		int[] results = new int[8];
		String[] question1 = new String[6];
        private int count=0;
        private int score=0;
        private int tries=0;
		private String[] gaps = new String[15];
        
	public Findtheword(String[] word,String[] question1) {
		
		//set fields
		this.question1=question1;
		this.word = word;
		k=0;
		createframe();
		
	}
	
	public void actionPerformed(ActionEvent e) {	
		
	//Examine if the pressed button is the right letter then gaps array changes else player's tries are increased by one
		for(int i=0;i<gaps.length;i++) {
			if(e.getSource()==buttons[i]) {    
				  if(buttons[i].getText().equals(array[k])) {	
					  gaps[k]=array[k];
					  k++;
					  buttons[i].setEnabled(false);
					  
		      if(k==array.length) {
		       score++;
			   count++;
			   textfield.setVisible(false);
			   question.setVisible(false);
			   question_panel.setVisible(false);
				for(int i1=0;i1<array.length;i1++) {
					buttons[i1].setVisible(false);
				}
			    createframe();
		       }
	             }else {
	        	tries++;
	        }
		}
	}
		
		//Display an array in the jlabel textfield
		 StringBuilder builder = new StringBuilder();
		   for(int i=0;i<array.length;i++) {
			      builder.append(gaps[i]+" ");	      
		   }
		  textfield.setText(builder.toString());
		  textfield.setBackground(Color.orange);
	      textfield.setFont(new java.awt.Font("Segoe Print", Font.BOLD, 50));
	      textfield.setBackground(new java.awt.Color(255, 153, 51));
		  textfield.setHorizontalAlignment(JLabel.CENTER);
		  textfield.setForeground(Color.black);	
		  textfield.setLayout(new BorderLayout());	
		  title_panel.add(textfield);
		  frame.add(title_panel);
		
	  
	  if(tries==3) {
		    textfield.setVisible(false);
			question.setVisible(false);
			button_panel.setVisible(false);
			question_panel.setVisible(false);
			for(int i1 =0;i1<array.length;i1++) {
				buttons[i1].setVisible(false);
			}
		  count++;
		  createframe();
	  } 
	 
	  
    }
	
	void createframe(){

		  //set k to 0 for new word
		   k=0;
		  //set tries to 0 for new word
		  tries=0;
	
		 //if count=5 then display score level completed ,or not display frame with the next word
		 if(count==5) {
			 textfield.setVisible(false);
			 question.setVisible(false);
			 question_panel.setVisible(false);
			 title_panel.setVisible(false);
			 button_panel.setVisible(false);
			 for(int i1=0;i1<array.length;i1++) {
					buttons[i1].setVisible(false);
				}
			  JPanel score_panel = new JPanel();
			  JLabel score1 = new JLabel("Congratulations your score is "+score+"/5");
	          score_panel.setBackground(Color.orange);
	          score1.setForeground(Color.WHITE);
	          score1.setFont(new Font("Ink Free",Font.BOLD,75));
		      score1.setHorizontalAlignment(JLabel.CENTER);
	          score1.setBackground(Color.YELLOW);
	 	      score1.setLayout(new BorderLayout());	
	 	      score_panel.add(score1);
			  frame.add(score_panel);
			 
		 }else {
			 
		        //Create frame
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1500,800);
				frame.getContentPane().setBackground(new Color(50,50,50));
				frame.setLayout(new BorderLayout());
				frame.setVisible(true);
		 
		   	  
		        //Create question label and panel
				question = new JLabel(question1[count]);
				question.setFont(new java.awt.Font("Segoe Print", Font.BOLD , 50));
				question.setHorizontalAlignment(JLabel.CENTER);
				question.setForeground(new java.awt.Color(255, 255, 153));
		   	    question.setForeground(Color.WHITE); 
		   	    question_panel.setBackground(new java.awt.Color(255, 153, 51));
		        question_panel.add(question);      
		      	question.setVisible(true);
			    question_panel.setVisible(true);	        
		 	    //Split the word and create an array with the letters of the word
				array = word[count].split("");	 
				
				
				for(int i=0;i<array.length;i++) {
					gaps [i]="__";
				}
				//Create an array of random numbers from 1 to 7;
				for(int i1=0;i1<array.length;i1++) {
					n[i1]=i1;	
				}
				
				int x=array.length;
				//Swap the index of the array n[i] with the index of n[randomIndex] so that the letters appear shuffled
		        Random random = new Random();
				for (int i=0;i<x;i++) {
					int randomIndex = random.nextInt(x);
					int temp = n[randomIndex];
					n[randomIndex] = n[i];
					n[i] = temp;
				} 
				
				//Create textfield label and panel
		        StringBuilder builder = new StringBuilder();
		 	   for(int i =0;i<array.length;i++) {
		 		      builder.append(gaps[i]+" ");   
		 	   }
		 	   textfield.setText(builder.toString());
		 	   textfield.setBackground(Color.orange);
		       textfield.setFont(new java.awt.Font("Segoe Print", Font.BOLD, 50));
		       textfield.setBackground(new java.awt.Color(255, 153, 51));
		       textfield.setHorizontalAlignment(JLabel.CENTER);
		 	   textfield.setForeground(Color.black);	
		 	   textfield.setLayout(new BorderLayout());	
		 	   title_panel.add(textfield);
		 	   textfield.setVisible(true);
			   title_panel.setVisible(true);
				
				//Create buttons 
				for(int i=0;i<x;i++) {
					buttons[i] = new JButton(array[n[i]]);
					button_panel.add(buttons[i]);
					buttons[i].setFont(new Font("Segoe Print",Font.BOLD,120));
					buttons[i].setBackground(new java.awt.Color(255, 153, 51));
					buttons[i].setForeground(new java.awt.Color(255, 255, 153));
					buttons[i].setFocusable(false);
					buttons[i].addActionListener(this);
					buttons[i].setVisible(true);
				 } 
				button_panel.setVisible(true);
				
				//Add panels to frame 
				button_panel.setBackground(Color.WHITE);
				title_panel.setBounds(0,0,800,100);
				frame.add(title_panel,BorderLayout.CENTER);
				frame.add(question_panel,BorderLayout.NORTH);
				frame.add(button_panel,BorderLayout.SOUTH);
			
		    }
	}

	
}