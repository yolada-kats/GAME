import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.w3c.dom.css.CSSMediaRule;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.FormatFlagsConversionMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;

public class Pesvresframe extends JFrame implements ActionListener{

	/**
	 *
	 */
	private JPanel contentPane;
	private JButton btnNewButton;
	private String answer1, answer2 , answer3, answer4, answer5;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesvresframe frame = new Pesvresframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pesvresframe() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(262, 108, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(262, 139, 124, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel = new JLabel("Please enter your answers;");
		lblNewLabel.setBounds(230, 83, 197, 14);
		lblNewLabel.setForeground(new Color(204, 153, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setBounds(262, 170, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(262, 201, 124, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(262, 232, 124, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(282, 263, 89, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnNewButton) {
			answer1 = textField.getText();
			answer2 = textField_1.getText();
			answer3 = textField_2.getText();
			answer4 = textField_3.getText();
			answer5 = textField_4.getText();

			checkAnswers(answer1, answer2, answer3, answer4, answer5);
		}
	}

	public void checkAnswers(String a, String b, String c, String d, String e) {
		String []answers = new String[5];

		answers[0] = a;
		answers[1] = b;
		answers[2] = c;
		answers[3] = d;
		answers[4] = e;

		for(int i=0; i<4; i++) {
			for(int j=i+1; j<=4; j++) {
				if(answers[i]!=null && answers[j]!=null && answers[i].equals(answers[j])) {
					JOptionPane.showMessageDialog(null,"You have entered the same answer. Please change one!", "SAME ANSWER", JOptionPane.ERROR_MESSAGE);
					flag = true;
					break;
				}
			}
			if(flag==true) {
				break;
			}
		}
	}

	public void result() {

	}
}