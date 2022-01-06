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

public class Result extends JFrame {
	JFrame frame;
	JTextField textfield = new JTextField();
	
	JButton buttonC = new JButton();
	
	public Result (JFrame frame) {
		this.frame = frame;
		
		
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
		
		
		frame.add(textfield);
		frame.add(buttonC);
		frame.setVisible(true);
		
		buttonC.setBounds(150,400,300,50);
		//buttonC.setFont(new Font("MV BOLI",Font.BOLD,35));
		buttonC.setFont(new Font("Dialog", Font.ITALIC, 30));
		buttonC.setFocusable(false);
		buttonC.addActionListener((ActionListener) this);
		buttonC.setForeground(new Color(0,0,0));
		//buttonC.setText("C");
		
		
		buttonC.setOpaque(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		
		textfield.setOpaque(false);
		frame.add(buttonC);
		
		frame.add(textfield);
		
		frame.setVisible(true);
		buttons();
		
	}
	
	public void buttons() {
		textfield.setText("RESULTS");
		buttonC.setText("EXIT");
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		buttonC.setEnabled(false);
		if (e.getSource()==buttonC) {
			System.exit(0);
		}
	}
}
