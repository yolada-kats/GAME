package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Result extends JFrame implements ActionListener{
	JFrame frame;
	JTextField textfield = new JTextField();
	
	JButton buttonE = new JButton();
	int total_score;
	public Result (JFrame frame,int total_score) {
		this.frame = frame;
		this.total_score = total_score;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(201,240,245));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		textfield.setBounds(0,45,620,50);
		textfield.setBackground(new Color(135,206,250));
		textfield.setForeground(new Color(135,206,250));
		textfield.setFont(new Font("Sunrise",Font.BOLD,60));
		//textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(-1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		
		//frame.add(textfield);
		//frame.add(buttonC);
		//frame.setVisible(true);
		
		buttonE.setBounds(150,400,300,50);
		buttonE.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonE.setFont(new Font("Dialog", Font.ITALIC, 30));
		buttonE.setFocusable(false);
		buttonE.addActionListener(this);
		buttonE.setForeground(new Color(0,0,0));
		//buttonC.setText("C");
		
		
		buttonE.setOpaque(false);
		buttonE.setContentAreaFilled(false);
		buttonE.setBorderPainted(false);
		
		textfield.setOpaque(false);
		
		frame.add(buttonE);
		
		frame.add(textfield);
		
		frame.setVisible(true);
	    buttons();
		
	}
	
	public void buttons() {
		textfield.setText("RESULTS " + total_score);
		buttonE.setText("EXIT");
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		buttonE.setEnabled(false);
		if (e.getSource()==buttonE) {
			System.exit(0);
		}
	}
}
