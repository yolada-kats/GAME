import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
	public class Findthewords implements ActionListener {
			ArrayList<JButton> buttons = new ArrayList<JButton>();
			JFrame frame;
			JPanel question_panel = new JPanel();
			JLayeredPane title_panel = new JLayeredPane();
			JLabel textfield = new JLabel();
			JLabel question = new JLabel();
			JPanel button_panel;
			JLabel pic = new JLabel();
			JButton nextlevel;
			JButton next;
	        ArrayList <String> question1 = new  ArrayList<String>();
	        ArrayList <String> list1 = new  ArrayList<String>();
	        ArrayList <String> gaps = new  ArrayList<String>();
	        ArrayList <String> letters = new  ArrayList<String>();
	        ArrayList<Integer> set = new  ArrayList<Integer>();
			int k=0;
			int x;
	        protected int count=0;
	        protected int score=0;
	        private int tries=0;
			JLabel score1 = new JLabel();
			JPanel score_panel = new JPanel();

		public Findthewords(JFrame frame, int position) {
			this.frame=frame;
			frame.getContentPane().setBackground(new Color(255,236,204));
			if (position == 1) {    //level sparta
				list1.add("LEONIDAS");   //add the words in list1
				list1.add("LYKOURGOS");
				list1.add("BRAVENESS");
				list1.add("LABE");
				question1.add("He was the king of Sparta");   //add the questions in list question1
				question1.add("He invented the laws in Sparta");
				question1.add("The Spartans became known for their");
	        	question1.add("The famous phrase Leonidas said was molon");
	        	pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("./sparta.jpg")));
			} else if (position == 2) {  //level ithaca
				list1.add("ODYSSEAS");
				list1.add("PENELOPE");
				list1.add("ARGOS");
				list1.add("OMYROS");
		        question1.add("He was the king of Ithaca");
		        question1.add("She was Odyssea's wife");
		        question1.add("He was Odyssea's dog");
		        question1.add("He was the writter of Odyssea");
		        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("./ithaca.jpg")));
			} else if (position == 3) {   //level vergina
				list1.add("ALEXANDER");
				list1.add("FILLIPOS");
				list1.add("INDIA");
				list1.add("PELLA");
		        question1.add("He was the most famous king of Macedonia");
		        question1.add("He was the father of Alexander");
		        question1.add("The country that the Great Alexander arrived");
		        question1.add("The historical capital of the ancient kingdom of Macedon");
		        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("./vergina.jpg")));
			}
			createframe();
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == nextlevel) {
				score1.setVisible(false);
				score_panel.setVisible(false);
				button_panel.setVisible(false);
				nextlevel.setVisible(false);
				//Map next = new Map(frame, 2, score);
			}
			if(e.getSource() == next) {
				 for (int i1 = 0; i1 < letters.size(); i1++) {
                     (buttons.get(i1)).setVisible(false);
				 }
				 letters.clear();
				 gaps.clear();
				 set.clear();
				 buttons.removeAll(buttons);
			     question_panel.setVisible(false);
				 question.setVisible(false);
				 button_panel.setVisible(false);
				 textfield.setVisible(false);
				 next.setVisible(false);
			     createframe();
			}
		        /*
		        * Examine if the pressed button is the right letter then gaps list changes else player's tries are increased by one
		        */
				for(int i = 0; i < buttons.size(); i++) {
					  if(e.getSource() == buttons.get(i)) {
						  if((buttons.get(i).getText()).contains(letters.get(k))) {
							  gaps.set(k, letters.get(k));
							  k++;
							  buttons.get(i).setVisible(false);

			             }else {
			                  tries++;
			             }
				     }
				}
				//Display an array in the jlabel textfield
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
				  for (int i1 = 0; i1 < letters.size(); i1++) {
		    	  				buttons.get(i1).setEnabled(false);
		    	  }
				  letters.clear();
			      gaps.clear();
			      set.clear();
			      buttons.clear();
		    	  count++;
		    	  next = new JButton("Next");
				  next.setFont(new Font("Times New Roman", Font.BOLD, 30));
				  next.setBounds(500,300,100,70);
			      next.setForeground(Color.white);
			      next.setFocusable(false);
				  next.addActionListener(this);
				  next.setVisible(true);
				  next.setOpaque(true);
				  next.setContentAreaFilled(false);
			      next.setBorderPainted(false);
				  title_panel.add(next,Integer.valueOf(2));
		      }
		}

		public void wordcompleted() {
			      if (k == letters.size()) {
			    	score += 10;
				    count++;
				    next = new JButton("Next");
				    next.setFont(new Font("Times New Roman", Font.BOLD, 30));
					next.setBounds(500,300,100,70);
					next.setForeground(Color.white);
					next.setFocusable(false);
					next.addActionListener(this);
					next.setVisible(true);
					next.setOpaque(true);
					next.setContentAreaFilled(false);
					next.setBorderPainted(false);
				    title_panel.add(next,Integer.valueOf(2));
			}
		}

		public void createframe() {
			  k = 0;                  //set k to 0 for new word
			  tries = 0;			  //set tries to 0 for new word
			 /*
			  * if word is the last one display score, level completed, if not display frame with the next word
			  */
			 if (count >= 4) {
				 pic.setVisible(false);
				 textfield.setVisible(false);
				 question.setVisible(false);
				 question_panel.setVisible(false);
 				 button_panel.setVisible(false);
 				 title_panel.setVisible(false);
				 for (int i1 = 0; i1 < letters.size(); i1++) {
						buttons.get(i1).setVisible(false);
				 }
					score1.setText("Score: " + score);
			        score_panel.setBackground(new java.awt.Color(255,236,204));
			        score1.setForeground(Color.WHITE);
			        score1.setFont(new Font("Times New Roman", Font.BOLD, 40));
			        score1.setBounds(300,400,400,300);
				    score1.setHorizontalAlignment(JLabel.CENTER);
				    score1.setLayout(new BorderLayout());
				    score1.setVisible(true);
				    score_panel.setBounds(0,0,620,600);
				    score_panel.add(score1);
				    button_panel = new JPanel();
				    button_panel.setBounds(0,0,620,600);
				    button_panel.setBackground(new java.awt.Color(255,236,204));
				    nextlevel = new JButton("Back to map");
				    nextlevel.setFont(new Font("Times New Roman", Font.BOLD, 60));
					nextlevel.setBounds(310,600,200,200);
					nextlevel.setBackground(Color.white);
					nextlevel.setForeground(new java.awt.Color(51,0,51));
					nextlevel.setFocusable(false);
					nextlevel.addActionListener(this);
					nextlevel.setBorderPainted(false);
					nextlevel.setVisible(true);
					score_panel.add(score1);
					button_panel.add(nextlevel);
					score_panel.setVisible(true);
					frame.add(score_panel,BorderLayout.CENTER);
					frame.add(button_panel,BorderLayout.SOUTH);
			 }else {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(new Dimension(620,788));
					frame.setBackground(new java.awt.Color(153,204,255));
					frame.setLayout(new BorderLayout());
					frame.setLocationRelativeTo(null);
		      		frame.setResizable(false);
					question = new JLabel(question1.get(count));
					question.setFont(new java.awt.Font("Times New Roman", Font.BOLD , 30));
					question.setHorizontalAlignment(JLabel.CENTER);
					question.setForeground(new java.awt.Color(0,0,102));
			   	    question_panel.setBackground(new java.awt.Color(255,236,204));
			        question_panel.add(question);
			      	question.setVisible(true);
				    question_panel.setVisible(true);
				    question.setBounds(0,0,620,600);
				    createlists();
			       StringBuilder builder = new StringBuilder();
			 	   for(int i =0;i<letters.size();i++) {
			 		      builder.append(gaps.get(i)+" ");
			 	   }
				   textfield.setText(builder.toString());
			 	   textfield.setBackground((new java.awt.Color(255,236,204)));
			       textfield.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 30));
			       textfield.setBounds(100, 140, 410, 60);
			       textfield.setHorizontalAlignment(JLabel.CENTER);
			       textfield.setOpaque(false);
			 	   textfield.setForeground(new java.awt.Color(51,0,51));
			 	   textfield.setVisible(true);
			 	   if(count==0) {
			       pic.setBounds(0,0,610,600);
			 	   title_panel.add(pic, Integer.valueOf(0));
			 	   title_panel.add(textfield,Integer.valueOf(1));}
			 	   button_panel = new JPanel();
				   for(int i=0;i<letters.size();i++) {
						Random r = new Random();
						button_panel.setBounds(0,0,620,150);

						buttons.add( new JButton(letters.get(set.get(i))));
						button_panel.add(buttons.get(i));
						buttons.get(i).setFont(new Font("Times New Roman",Font.BOLD,40));
						buttons.get(i).setBounds(250,250,20,20);
						button_panel.setLayout(new GridLayout(letters.size()/3,letters.size()/2));
						buttons.get(i).setForeground(new java.awt.Color(r.nextInt(152), r.nextInt(203), r.nextInt(254)));
						buttons.get(i).setFocusable(false);
						buttons.get(i).addActionListener(this);
						buttons.get(i).setVisible(true);
						buttons.get(i).setContentAreaFilled(false);
						buttons.get(i).setBorderPainted(false);
					}
					button_panel.setBackground(new java.awt.Color(255,236,204));
					title_panel.setVisible(true);
					button_panel.setVisible(true);
					frame.add(title_panel,BorderLayout.CENTER);
					frame.add(question_panel,BorderLayout.NORTH);
					frame.add(button_panel,BorderLayout.SOUTH);
					frame.setVisible(true);
			 	 }
		}

		public void createlists() {
			/*
			 * Split the word and create a list with the letters of the word
			 */
			List<String> l = new ArrayList <String>(Arrays.asList(list1.get(count).split("")));
			letters.addAll(l);
			for(int i=0;i<letters.size();i++) {
				gaps.add("__");
			}
			for(int i=0;i<letters.size();i++) {
				set.add(i);
			}
			x=letters.size();
	        Random random = new Random();
			for (int i=0;i<x;i++) {
				int randomIndex = random.nextInt(x);
				int temp = set.get(randomIndex);
				set.set(randomIndex, set.get(i));
				set.set(i, temp);
			}
		}

	}

