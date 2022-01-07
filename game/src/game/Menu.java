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
	 JFrame frame;

	JLabel background2 = new JLabel();
	JLabel background3 = new JLabel();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JLabel answer_IconB = new JLabel();
	JLabel answer_IconC = new JLabel();
	
	ImageIcon sky = new ImageIcon("game/src/game/menuBackground.jpg");
	
	public Menu(int ind, JFrame frame) {
		this.frame = frame;
		this.ind=ind;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(201,240,245));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		
		background3.setBounds(0, 0, 600, 800);
		background3.setIcon(sky);
		background3.setVisible(true);
		
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
	
		
		buttonA.setBounds(150,300,300,50);
		buttonA.setFont(new Font("Dialog", Font.ITALIC, 30));
		//buttonA.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setForeground(new Color(0,0,0));
		//buttonA.setIcon(column);
		
		buttonA.setOpaque(false);
		buttonA.setContentAreaFilled(false);
		buttonA.setBorderPainted(false);
		
		//buttonA.setText("A");
		
		buttonB.setBounds(150,200,300,50);
		buttonB.setFont(new Font("Dialog", Font.ITALIC, 30));
		//buttonB.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setForeground(new Color(0,0,0));
		//buttonB.setText("B");
		
		
		buttonB.setOpaque(false);
		buttonB.setContentAreaFilled(false);
		buttonB.setBorderPainted(false);
		
		buttonC.setBounds(150,400,300,50);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Dialog", Font.ITALIC, 30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setForeground(new Color(0,0,0));
		//buttonC.setText("C");
		
		
		buttonC.setOpaque(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		
		textfield.setOpaque(false);
		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
	
		frame.add(textfield);
		
		frame.setVisible(true);
		frame.add(background3);
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
			frame.remove(buttonA);
			frame.remove(buttonB);
			frame.remove(textfield);
			frame.remove(buttonC);
			frame.remove(background3);
			frame.remove(answer_IconB);
			
			Map star = new Map(frame, 0);
			
		}
		if (e.getSource()==buttonC) {
			answer= 'C';
			System.exit(0);
		}
	}
	
	public void getMenu() {
		
	}
}
