package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	ImageIcon final1 = new ImageIcon("game/src/game/final.jpg");
	ImageIcon final2 = new ImageIcon("game/src/game/final2.jpg");
	ImageIcon flames = new ImageIcon("game/src/game/flame.gif");
	Color color;
	int total_score;
	
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
		if (total_score > 230) {
			background.setIcon(final1);
			flame.setBounds(165, 62, 400, 600);
			flame.setIcon(flames);
			flame.setVisible(true);
			color = new Color(0, 0, 0);
		}else {
			background.setIcon(final2);
			color = new Color(255, 255, 255);
		}
		background.setVisible(true);
		
		textfield.setBounds(0, 45, 620, 50);
		textfield.setBackground(new Color(135, 206, 250));
		textfield.setForeground(color);
		textfield.setFont(new Font("Sunrise", Font.BOLD, 60));
		textfield.setBorder(BorderFactory.createBevelBorder(-1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		playagain.setBounds(150, 100, 300, 50);
		playagain.setFont(new Font("MV BOLI", Font.BOLD, 35));
		playagain.setFont(new Font("Dialog", Font.ITALIC, 30));
		playagain.setFocusable(false);
		playagain.addActionListener(this);
		playagain.setForeground(color);
		playagain.setOpaque(false);
		playagain.setContentAreaFilled(false);
		playagain.setBorderPainted(false);
		
		
		buttonE.setBounds(150, 150, 300, 50);
		buttonE.setFont(new Font("MV BOLI", Font.BOLD, 35));
		buttonE.setFont(new Font("Dialog", Font.ITALIC, 30));
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
