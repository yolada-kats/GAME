package game;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Menu  implements ActionListener {
	int ind = 0;
	char answer;
	
	JTextField textfield = new JTextField();
	 JFrame frame = new JFrame();

	JLabel background = new JLabel();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JLabel answer_IconA = new JLabel();
	JLabel answer_IconB = new JLabel();
	JLabel answer_IconC = new JLabel();
	
	ImageIcon menuback = new ImageIcon("game/src/game/SANTA.PNG");
	public Menu(int ind) {
		this.ind=ind;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(72,61,139));
		frame.setLayout(null);
		frame.setResizable(false);
		background.setBounds(0, 0, 960,600);
		background.setIcon(menuback);
		background.setVisible(true);
		
		textfield.setBounds(0,45,620,50);
		textfield.setBackground(new Color(135,206,250));
		
		textfield.setForeground(new Color(135,206,250));
		textfield.setFont(new Font("Sunrise",Font.BOLD,60));
		//textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(-1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		frame.add(textfield);
		frame.setVisible(true);
	
		buttonA.setBounds(150,200,300,50);
		buttonA.setFont(new Font("Sunrise",Font.BOLD,30));
		//buttonA.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setForeground(new Color(175,175,255));
		//buttonA.setIcon(column);
		
		buttonA.setOpaque(false);
		buttonA.setContentAreaFilled(false);
		buttonA.setBorderPainted(false);
		
		//buttonA.setText("A");
		
		buttonB.setBounds(150,300,300,50);
		buttonB.setFont(new Font("Sunrise",Font.BOLD,30));
		//buttonB.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setForeground(new Color(175,175,255));
		//buttonB.setText("B");
		
		
		buttonB.setOpaque(false);
		buttonB.setContentAreaFilled(false);
		buttonB.setBorderPainted(false);
		
		buttonC.setBounds(150,400,300,50);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Sunrise",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setForeground(new Color(175,175,255));
		//buttonC.setText("C");
		
		
		buttonC.setOpaque(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		
		textfield.setOpaque(false);
		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(answer_IconA);
		frame.add(answer_IconB);
		frame.add(answer_IconC);
		frame.add(textfield);
		frame.setVisible(true);
		frame.add(background);
		
		buttons(ind);
	}
	
	public void buttons(int x ) {
		textfield.setText("MAP YOU");
		buttonA.setText("INSTRUCTIONS");
		buttonB.setText("PLAY");
		buttonC.setText("EXIT");
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		
		if (e.getSource()==buttonA) {
			answer= 'A';
			//getMenu();
		}
		if (e.getSource()==buttonB) {
			answer= 'B';
			//Map star = new Map();
			
		}
		if (e.getSource()==buttonC) {
			answer= 'C';
			System.exit(0);
		}
	}
	
	public void getMenu() {
		
	}
}
