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
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class EightLetters implements ActionListener{
	    
		JButton[] buttons = new JButton[8];
		JFrame frame= new JFrame();
		JPanel question_panel = new JPanel();
		JPanel title_panel = new JPanel();
		JPanel button_panel = new JPanel();
		JLabel textfield = new JLabel();
		JLabel question = new JLabel();
		int k;
		boolean t = false;
		private String[] word = new String[6];
		String[] array = new String[8];
		int n[] = new int[8];
		int[] results = new int[8];
		String[] question1 = new String[6];
                private int count;
                private int score=0;
                private int tries=0;
        
	public EightLetters(String[] word,String[] question1) {
		
		//set fields
		this.question1=question1;
		this.word = word;
		createframe();
		
	}
	
	public void actionPerformed(ActionEvent e) {	
		
		for(int i=0;i<8;i++) {
		  if(e.getSource()==buttons[i]) {
			  if(buttons[i].getText().equals(array[k])) {	  
				   if(k==0) {
					  textfield.setText(array[k]+" __ __ __ __ __ __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==1) {
					  textfield.setText(array[0]+" "+array[1]+" __ __ __ __ __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==2) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" __ __ __ __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
				      k++;
				  }else if(k==3) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" __ __ __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==4) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" "+array[4]+" __ __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==5) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" "+array[4]+" "+array[5]+" __ __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==6) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" "+array[4]+" "+array[5]+" "+array[6]+" __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==6) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" "+array[4]+" "+array[5]+" "+array[6]+" __"); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
				  }else if(k==7) {
					  textfield.setText(array[0]+" "+array[1]+" "+array[2]+" "+array[3]+" "+array[4]+" "+array[5]+" "+array[6]+" "+array[7]); 
		              title_panel.add(textfield);
		              buttons[i].setEnabled(false);
					  k++;
					  count++;
					  score++;
				  }
		       break;
			  }else {
				  tries++;
			  }
		  }  
	  } 
		
	 	if(k==8) {
			textfield.setVisible(false);
			question.setVisible(false);
			for(int i1=0;i1<8;i1++) {
				buttons[i1].setVisible(false);
			}
	       		createframe();
	       }
	  
	       if(tries==3) {
		        textfield.setVisible(false);
			question.setVisible(false);
			for(int i1 =0;i1<8;i1++) {
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
			 
		       //Create score panel and score label
	        	  JPanel score_panel = new JPanel();
			  JLabel score1 = new JLabel("Score "+score+"/5");
			  score_panel.add(score1);
		          score_panel.setBounds(0,0,900,4);
	                  score_panel.setBackground(Color.orange);
	                  score1.setForeground(Color.WHITE);
	                  score1.setFont(new Font("Ink Free",Font.BOLD,75));
		          score1.setHorizontalAlignment(JLabel.CENTER);
	 	          score1.setForeground(Color.black);	
	                  score1.setBackground(Color.YELLOW);
	 	          score1.setLayout(new BorderLayout());	
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
		          question.setFont(new Font("Ink Free",Font.BOLD,50));
			  question.setHorizontalAlignment(JLabel.CENTER);
		   	  question.setForeground(Color.WHITE); 
		   	  question_panel.setBackground(Color.BLUE);
		          question_panel.add(question);
		        
		       //Create textfield label and panel
                          textfield = new JLabel("__ __ __ __ __ __ __ __"); 
			  textfield.setBounds(0,0,900,4);
		          textfield.setBackground(Color.orange);
		          textfield.setForeground(Color.WHITE);
		          textfield.setFont(new Font("Ink Free",Font.BOLD,75));
			  textfield.setHorizontalAlignment(JLabel.CENTER);
		 	  textfield.setForeground(Color.black);	
		          title_panel.setBackground(Color.YELLOW);
		 	  textfield.setLayout(new BorderLayout());	
	                  title_panel.add(textfield);

		        
		       //Split the word and create an array with the letters of the word
		           array = word[count].split("");	 
				
		       //Create an array of random numbers from 1 to 7;
			    for(int i1=0;i1<8;i1++) {
			     	n[i1]=i1;	
			     }
			 
		       //Swap the index of the array n[i] with the index of n[randomIndex] so that the letters appear shuffled
		              Random random = new Random();
		              for (int i=0;i<n.length;i++) {
					int randomIndex = random.nextInt(n.length);
					int temp = n[randomIndex];
					n[randomIndex] = n[i];
					n[i] = temp;
			      }
				
			//Create buttons 
			       for(int i=0;i<8;i++) {
					buttons[i] = new JButton(array[n[i]]);
					button_panel.add(buttons[i]);
					buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
					buttons[i].setBackground(Color.ORANGE);
					buttons[i].setForeground(Color.white);
					buttons[i].setFocusable(false);
					buttons[i].addActionListener(this);
				 }
				
			//Add panels to frame 
				button_panel.setBackground(Color.WHITE);
				title_panel.setBounds(0,0,800,100);
				frame.add(title_panel,BorderLayout.CENTER);
				frame.add(question_panel,BorderLayout.NORTH);
				frame.add(button_panel,BorderLayout.SOUTH);
			
		    }
	}
}
		


	



        
