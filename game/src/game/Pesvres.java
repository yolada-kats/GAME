package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Pesvres extends JFrame implements ActionListener{



	private JPanel contentPane;
	private String place;
	static ArrayList <String> solutions = new ArrayList<String>();
	static ArrayList <String> answers = new ArrayList<String>();
	static ArrayList <JTextField> textFields = new ArrayList<JTextField>();
	private ArrayList <JLabel> results = new ArrayList<JLabel>();
	Image img, img2, img3;
	private JButton btnNewButton;
	private JTextField textField_5;
	private int score;
	private boolean flag;
	private JLabel lblNewLabel;
	
	public Pesvres(String place, Frame frame) {
		this.place = place;
		this.score = 0;
		this.flag = false;
		
		img2 = new ImageIcon(this.getClass().getResource("/right.png")).getImage();
		img3 = new ImageIcon(this.getClass().getResource("/wrong.png")).getImage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(place.equals("ATHENS")) {
			img = new ImageIcon(this.getClass().getResource("/athens.jpg")).getImage();
		} else if(place.equals("THERMOPYLES")) {
			img = new ImageIcon(this.getClass().getResource("/thermopiles.jpg")).getImage();
		} else {
			img = new ImageIcon(this.getClass().getResource("/delfi.jpg")).getImage();
		}
		
		Font textField_Font = new Font("Times New Roman", Font.BOLD, 15);
		for(int i = 0; i < 5; i++) {
			textFields.add(i, new JTextField());
			(textFields.get(i)).setBounds(200, 100 + (i*60), 280, 35);
			(textFields.get(i)).setFont(textField_Font);
			contentPane.add(textFields.get(i));
			(textFields.get(i)).setColumns(10);
		}
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 420, 100, 35);
		textField_5.setFont(textField_Font);
		contentPane.add(textField_5);
		
		for(int i = 0; i < 5; i++) {
			results.add(i, new JLabel());
			(results.get(i)).setIcon(new ImageIcon(img3));
			(results.get(i)).setBounds(490, 100 + (i*60), 45, 35);
			contentPane.add(results.get(i));
			(results.get(i)).setVisible(false);
		}
		
		btnNewButton = new JButton("RESULTS");
		btnNewButton.setBounds(520, 420, 230, 35);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Write 5 words related to the destination of; "+ place +"!");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 55, 620, 35);
		contentPane.add(lblNewLabel);
		
		JLabel city_img = new JLabel();
		city_img.setIcon(new ImageIcon(img));
		city_img.setBounds(0, 0, 784, 461);
		contentPane.add(city_img);
	}
	
	public void setValues() {
	   	if("ATHENS".equals(place)) {
	   		solutions.clear();
		  		
		   	solutions.add("ACROPOLIS");
		  	solutions.add("PERICLES");
	 		solutions.add("GOLDEN AGE");
	 		solutions.add("PARTHENON");
		   	solutions.add("DEMOCRACY");
		  	solutions.add("CAPITAL CITY");
	    	solutions.add("SOCRATES");
	   		solutions.add("CIVILIZATION");
	   		solutions.add("PLATO");	
	   		solutions.add("ATHENA");
	 
	   	} else if("THERMOPYLES".equals(place)) {
	   		solutions.clear();
	    		
	    	solutions.add("LEONIDAS");
	   	 	solutions.add("XERXES");
		 	solutions.add("BATTLE");
		 	solutions.add("EPHIALTES");
			solutions.add("PERSIANS");
			solutions.add("HERODOTUS");
			solutions.add("SPARTANS");
			solutions.add("THEMISTOCLES");
			solutions.add("480BC");
			solutions.add("MOLON LABE");
			
	   	} else {
	   		solutions.add("DELPHI");
			solutions.add("PYTHIA");
			solutions.add("FUTURE");
			solutions.add("APOLLO");
			solutions.add("ORACLE");
			solutions.add("TEMPLE OF APOLLO");
			solutions.add("PROPHETIC");
			solutions.add("MUSES");
			solutions.add("PYTHIO");
			solutions.add("OMPHALOS");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			setValues();
			
			answers.clear();
			
			for(int i = 0; i < 5; i++) {
				answers.add((textFields.get(i)).getText());
			}
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < solutions.size(); j ++) {
					if(answers.get(i).equalsIgnoreCase(solutions.get(j))) {
					 	flag = true;
					 	solutions.remove(j);
					 	score++;
					 	break;
				 	}
			 	}
			 	if(flag == true) {
			 		
			 		answers.remove(i);
			 		answers.add(i, "C");
			 		flag = false;
			 	} else {
			 		answers.remove(i);
			 		answers.add(i, "W");
		 		}
			}
			displayAnswers();
		}
	}

	public void displayAnswers() {
		for(int i = 0; i < 5; i++) {
			System.out.println(answers.get(i));
			if((answers.get(i)).equals("C")) {
				(results.get(i)).setIcon(new ImageIcon(img2));
			}
			(results.get(i)).setVisible(true);
		}
		
		textField_5.setText("Your Score: " + score);
		
	}
} 