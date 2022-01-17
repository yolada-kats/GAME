package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
public class PesVresScore {
    JFrame frame;
    int score;
    JLabel score1 = new JLabel();
    JLayeredPane score_panel = new JLayeredPane();
    JButton map;
    JLabel pic = new JLabel();
    JLabel scroll = new JLabel();
	private String filename;
	private String data;
    static int count = 0;
    Color color;
    boolean flag = false;
    BufferedImage img;
    BufferedImage img1;
	public PesVresScore(JFrame frame, int score) {
		this.frame = frame;
		this.score = score;
		count++;
		scorepanel();
	}
	private void scorepanel() {
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608, 800);
		frame.setBackground(new java.awt.Color(153 ,204, 255));
	    frame.setLayout(new BorderLayout());
	    frame.setResizable(false);
	    addpics();
		score1.setText("RESULT:  " + score);
        score1.setForeground(new java.awt.Color(51, 0, 51));
        score1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        score1.setBounds(90, -100, 400, 310);
	    score1.setHorizontalAlignment(JLabel.CENTER);
	    score1.setLayout(new BorderLayout());
	    score1.setVisible(true);
	    score_panel.setBounds(0, 0, 608, 800);
	    score_panel.add(score1, Integer.valueOf(1)); 	
		ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					frame.remove(score_panel);
					Map m = new Map();
					int score1 = m.getresult();
					score1 = score + score1 ;
					new Result(frame, score1);
			    } else {
			    	frame.remove(score_panel);
					new Map(frame, score);
			    }
			}
		};	
		map = new JButton("MAP");
		map.setFont(new Font("Times New Roman", Font.BOLD, 25));
		map.setForeground(Color.black);
		map.setBackground(color);
		map.setFocusable(false);
		map.setBorder(BorderFactory.createBevelBorder(1));
		map.setBounds(10, 160, 100, 80);
		map.addActionListener(b1);
		map.setVisible(true);
		score_panel.add(map, Integer.valueOf(2));  
		frame.add(score_panel);
		addscroll();
	}
	
	private void addscroll() {
		 try {
			 img = ImageIO.read(getClass().getResource("/scroll.png"));
		 } catch (IOException e1) {
			 e1.printStackTrace();
		 }
    	 scroll.setIcon(new ImageIcon(img));
	     scroll.setBounds(120, 90, 400, 590);
	     score_panel.add(scroll, Integer.valueOf(1));
	     readfile();
	}
	
	private void readfile() {
		int y = 0;
		try (FileReader fileReader = new FileReader("game/src/game/\" + filename"); 
			      BufferedReader reader = new BufferedReader(fileReader)) {
			      String contents = reader.lines()
			      .collect(Collectors.joining(System.lineSeparator()));
			      JLabel info = new JLabel(contents);
		    	  info.setForeground(Color.black);
		    	  info.setFont(new Font("Times New Roman", Font.BOLD, 27));
		    	  info.setBounds(177, -20 + y, 500, 600);
		    	  score_panel.add(info, Integer.valueOf(2));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
		      File file = new File("game/src/game/" + filename);
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		    	  data = myReader.nextLine();
		    	  JLabel info = new JLabel(data);
		    	  info.setForeground(Color.black);
		    	  info.setFont(new Font("Times New Roman", Font.BOLD, 27));
		    	  info.setBounds(177, -20 + y, 500, 600);
		    	  score_panel.add(info, Integer.valueOf(2));
		    	  y += 27;
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}	*/	
	}
	
	private void addpics() {
		if (count == 1) {
			 try {
				 img1 = ImageIO.read(getClass().getResource("/athens.jpg"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	pic.setIcon(new ImageIcon(img1));
			pic.setBounds(-50, -120, 5000, 1050);
			filename = "ath.txt";
			color = new Color(232, 189, 177);
	 		score_panel.add(pic, Integer.valueOf(0));
		} else if (count == 2) {
			try {
				 img1 = ImageIO.read(getClass().getResource("/thermopiles.jpg"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	pic.setIcon(new ImageIcon(img1));
		    pic.setBounds(-50, -120, 5000, 1050);
			filename = "ther.txt";
			color = new Color(201, 175, 132);
	 		score_panel.add(pic, Integer.valueOf(0));
		} else if (count == 3) {
			try {
				 img1 = ImageIO.read(getClass().getResource("/delfi.jpg"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	pic.setIcon(new ImageIcon(img1));
			pic.setBounds(-50, -120, 5000, 1050);
			filename = "del.txt";
			color = new Color(215, 234, 208);
	 		score_panel.add(pic, Integer.valueOf(0));
			count = 0;
			flag  = true;
		}		
	}

}
