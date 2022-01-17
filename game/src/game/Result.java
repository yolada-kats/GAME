package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class Result extends JFrame implements ActionListener{
	JLayeredPane panel = new JLayeredPane();
	JFrame frame;
	JTextField textfield = new JTextField();
	JButton playagain = new JButton();
	JButton buttonE = new JButton();
	JLabel background = new JLabel();
	JLabel flame = new JLabel();
	Color color;
	int total_score;
	BufferedImage img;
	private BufferedImage img1;
	
	public Result (JFrame frame, int total_score) {
		this.frame = frame;
		this.total_score = total_score;	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608, 800);
		frame.getContentPane().setBackground(new Color(163, 155, 213));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	
		panel.setBounds(0, 0, 608, 800);
		background.setBounds(0, 0, 608, 800);
		if (total_score >= 230) {
			try {
				 img = ImageIO.read(getClass().getResource("/final.jpg"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	background.setIcon(new ImageIcon(img));
	    	try {
				 img1 = ImageIO.read(getClass().getResource("/flame.gif"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	flame.setIcon(new ImageIcon(img1));
			flame.setBounds(165, 62, 400, 600);
			flame.setVisible(true);
			color = new Color(0, 0, 0);
			addgif("SANTA4.gif");
		}else {
			try {
				 img = ImageIO.read(getClass().getResource("/final2.jpg"));
		    } catch (IOException e1) {
				 e1.printStackTrace();
		    }
	    	background.setIcon(new ImageIcon(img));
			color = new Color(255, 255, 255);
			addgif("SANTA3.gif");
		}
		background.setVisible(true);	
		textfield.setBounds(0, 45, 620, 50);
		textfield.setBackground(new Color(135, 206, 250));
		textfield.setForeground(color);
		textfield.setFont(new Font("Times New Roman", Font.BOLD, 60));
		textfield.setBorder(BorderFactory.createBevelBorder(-1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);	
		playagain.setBounds(150, 100, 300, 50);
		playagain.setFont(new Font("Times New Roman", Font.BOLD, 35));
		playagain.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		playagain.setFocusable(false);
		playagain.addActionListener(this);
		playagain.setForeground(color);
		playagain.setOpaque(false);
		playagain.setContentAreaFilled(false);
		playagain.setBorderPainted(false);	
		buttonE.setBounds(150, 150, 300, 50);
		buttonE.setFont(new Font("Times New Roman", Font.BOLD, 35));
		buttonE.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		buttonE.setFocusable(false);
		buttonE.addActionListener(this);
		buttonE.setForeground(color);
		buttonE.setOpaque(false);
		buttonE.setContentAreaFilled(false);
		buttonE.setBorderPainted(false);	
		textfield.setOpaque(false);
		buttons();
		panel.add(buttonE, Integer.valueOf(2));	
		panel.add(textfield, Integer.valueOf(2));
		panel.add(playagain, Integer.valueOf(2));
		panel.add(background, Integer.valueOf(0));
		panel.add(flame, Integer.valueOf(1));
		frame.add(panel);
		frame.setVisible(true);	
	}
	
	private void addgif(String s) {
		JLabel pic1 = new JLabel();
		pic1.setBounds(0, 450, 320, 320);
		pic1.setVisible(true);
		try {
			 img = ImageIO.read(getClass().getResource("/" + s));
	    } catch (IOException e1) {
			 e1.printStackTrace();
	    }
   	    pic1.setIcon(new ImageIcon(img));
    	panel.add(pic1, Integer.valueOf(2));
	}
	
	public void buttons() {
		textfield.setText("RESULTS " + total_score);
		buttonE.setText("EXIT");
		playagain.setText("PLAY AGAIN");	
	}
	
	public void actionPerformed(ActionEvent e) {
		buttonE.setEnabled(false);
		if (e.getSource() == buttonE) {
			System.exit(0);
		}
		if (e.getSource() == playagain) {
			frame.remove(panel);
			new Map(frame, 0, 0);
		}
	}
}
