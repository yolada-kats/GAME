package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
public class PesVresScore {
    JFrame frame;
    int score;
    JLabel score1 = new JLabel();
    JLayeredPane score_panel = new JLayeredPane();
    JButton map = new JButton();
    JLabel pic = new JLabel();
    JLabel scroll = new JLabel();
	private String filename;
	private String data;
    static int count = 0;
    Color color;
	public PesVresScore(JFrame frame, int score) {
		this.frame = frame;
		this.score = score;
		count++;
		scorepanel();
	}
	private void scorepanel() {
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608, 800);
		frame.setBackground(new java.awt.Color(153,204,255));
	    frame.setLayout(new BorderLayout());
	    frame.setResizable(false);
	    addpics();
		score1.setText("RESULT:  " + score);
        score1.setForeground(new java.awt.Color(51,0,51));
        score1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        score1.setBounds(90,-100,400,310);
	    score1.setHorizontalAlignment(JLabel.CENTER);
	    score1.setLayout(new BorderLayout());
	    score1.setVisible(true);
	    score_panel.setBounds(0,0,608,800);
	    score_panel.add(score1,Integer.valueOf(1)); 	
		ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
			    frame.remove(score_panel);
				new Map(frame, score);
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
		score_panel.add(map,Integer.valueOf(2));  
		frame.add(score_panel);
		
		addscroll();
	}
	private void addscroll() {
		 scroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("./scroll.png")));
	     scroll.setBounds(120,90,400,590);
	     score_panel.add(scroll, Integer.valueOf(1));
	     readfile();
	}
	private void readfile() {
		int y=0;
		try {
		      File file = new File("game/src/game/"+filename);
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        data = myReader.nextLine();
		        JLabel info = new JLabel(data);
		        info.setForeground(Color.black);
	        	info.setFont(new Font("Times New Roman", Font.BOLD, 27));
	         	info.setBounds(177,-20+y,500,600);
                score_panel.add(info,Integer.valueOf(2));
              y+=27;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }		
	}
	private void addpics() {
		if (count==1) {
			pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/athens.jpg")));
			pic.setBounds(-50, -120, 5000, 1050);
			filename = "ath.txt";
			color = new Color(232,189,177);
	 		score_panel.add(pic, Integer.valueOf(0));
		}else if(count==2) {
			pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thermopiles.jpg")));
		    pic.setBounds(-50, -120, 5000, 1050);
			filename = "ther.txt";
			color = new Color(201,175,132);
	 		score_panel.add(pic, Integer.valueOf(0));
		}else if(count==3) {
			pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delfi.jpg")));
			pic.setBounds(-50, -120, 5000, 1050);
			filename = "del.txt";
			color = new Color(215,234,208);
	 		score_panel.add(pic, Integer.valueOf(0));
			count=0;
		}		
	}

}
