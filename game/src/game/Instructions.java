package game;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Instructions implements ActionListener {
	JFrame frame;
	String data;
	JLayeredPane panel = new JLayeredPane();
	JLabel pic = new JLabel();
	BufferedImage img;
	public Instructions(JFrame frame) {
		this.frame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608, 800);
		frame.getContentPane().setBackground(new Color(201, 240, 245));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		addbutton();
        getInstructions();     
	}

	private void addbutton() {
       JButton back = new JButton("Menu");
       back.setHorizontalTextPosition(JButton.CENTER);
	   back.setVerticalTextPosition(JButton.BOTTOM);
       back.setBounds(440, 659, 130, 80);
       back.setBackground(new java.awt.Color(128, 144, 238));
       back.setForeground(Color.black);
       back.setFocusable(false);
       back.setBorderPainted(false);
       back.addActionListener(this);
       back.setFont(new Font("Times New Roman", Font.BOLD, 30));
       panel.add(back, Integer.valueOf(2));
	}

	private void getInstructions() {
		try {
			 img = ImageIO.read(getClass().getResource("/instructionspic.jpg"));
	    } catch (IOException e1) {
			 e1.printStackTrace();
	    }
   	    pic.setIcon(new ImageIcon(img));
		pic.setBounds(0, 0, 608, 800);
		pic.setVisible(true);
        panel.add(pic, Integer.valueOf(1));
		JLabel title  = new JLabel("INSTRUCTIONS:");
		title.setBounds(150, 0, 300, 100);
		title.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel.setBounds(0, 0, 608, 800);
		panel.add(title, Integer.valueOf(2));
		int y = 0;
		try {
			File file = new File("game/src/game/instructions.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
			    JLabel info = new JLabel(data);
			    info.setForeground(Color.black);
			    info.setFont(new Font("Times New Roman", Font.BOLD, 20));
		        info.setBounds(65,-200 + y, 500, 600);
	            panel.add(info,Integer.valueOf(2));
                y += 20;
            } 
			myReader.close();
		} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
			    e.printStackTrace();
		}
		frame.add(panel);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		   frame.remove(panel);
           new Menu(0, frame)	;	
	}
}
