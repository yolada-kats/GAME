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

public class Pesvres  implements ActionListener{


	JFrame frame;
	//private JPanel contentPane;
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
	JButton nextlevel;
	
	public Pesvres(String place,JFrame frame) {
		this.place = place;
		this.score = 0;
		this.flag = false;
		this.frame = frame;
		
		img2 = new ImageIcon(this.getClass().getResource("/right.png")).getImage();
		img3 = new ImageIcon(this.getClass().getResource("/wrong.png")).getImage();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(608,800);
		frame.getContentPane().setBackground(new Color(238,236,194));
		frame.setLayout(null);
		frame.setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 500);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
		if(place.equals("ATHENS")) {
			img = new ImageIcon(this.getClass().getResource("/athens.jpg")).getImage();
		} else if(place.equals("THERMOPYLES")) {
			img = new ImageIcon(this.getClass().getResource("/thermopiles.jpg")).getImage();
		} else {
			img = new ImageIcon(this.getClass().getResource("/delfi.jpg")).getImage();
		}
		
		Font textField_Font = new Font("Times New Roman", Font.BOLD, 22);
		for(int i = 0; i < 5; i++) {
			textFields.add(i, new JTextField());
			(textFields.get(i)).setBounds(180, 150 + (i*90), 280, 45);
			(textFields.get(i)).setFont(textField_Font);
			frame.add(textFields.get(i));
			(textFields.get(i)).setColumns(10);
		}
		
		textField_5 = new JTextField();
		textField_5.setBounds(250, 60, 150, 50);
		textField_5.setFont(textField_Font);
		//textField_5.setBackground(Color.orange);
		textField_5.setOpaque(false);
		textField_5.setVisible(false);
		frame.add(textField_5);
		
		
		for(int i = 0; i < 5; i++) {
			results.add(i, new JLabel());
			(results.get(i)).setIcon(new ImageIcon(img3));
			(results.get(i)).setBounds(480, 151 + (i*90), 45, 55);
			frame.add(results.get(i));
			(results.get(i)).setVisible(false);
		}
		
		btnNewButton = new JButton("RESULTS");
		btnNewButton.setBounds(190, 640, 250, 45);
		btnNewButton.addActionListener(this);
		frame.add(btnNewButton);
		btnNewButton.setVisible(true);
		
		lblNewLabel = new JLabel("Write 5 words related to the destination of: "+ place );
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 60, 620, 35);
		frame.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		JLabel city_img = new JLabel();
		city_img.setIcon(new ImageIcon(img));
		city_img.setBounds(-400, -30, 3000, 800);
		frame.add(city_img);
		
		nextlevel = new JButton("Map"); 
	    nextlevel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		nextlevel.setBounds(200,600,300,50);
		//nextlevel.setForeground(new java.awt.Color(51,0,51));
		nextlevel.setOpaque(false);
		nextlevel.setContentAreaFilled(false);
		nextlevel.setBorderPainted(false);
		nextlevel.setVisible(true);
		frame.add(nextlevel);
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
		btnNewButton.setVisible(false);
		lblNewLabel.setVisible(false);
		textField_5.setVisible(true);
		nextlevel.setVisible(true);
		for(int i = 0; i < 5; i++) {
			System.out.println(answers.get(i));
			if((answers.get(i)).equals("C")) {
				(results.get(i)).setIcon(new ImageIcon(img2));
			}
			(results.get(i)).setVisible(true);
		}
		
		textField_5.setText(" RESULTS: " + score*10);
		ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				new Map(frame,score*10);
			}
		};
		nextlevel.addActionListener(b1);
		
	}
} 