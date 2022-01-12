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
	JLabel city_img = new JLabel();
	private int score;
	private boolean flag;
	private JLabel lblNewLabel;
	private JButton map;
	
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
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
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
			(textFields.get(i)).setBounds(160, 150 + (i*90), 280, 45);
			(textFields.get(i)).setFont(textField_Font);
			frame.getContentPane().add(textFields.get(i));
			(textFields.get(i)).setColumns(10);
		}
		
		textField_5 = new JTextField();
		textField_5.setBounds(230, 50, 160, 61);
		textField_5.setFont(textField_Font);
		//textField_5.setBackground(Color.orange);
		textField_5.setOpaque(false);
		textField_5.setVisible(false);
		frame.getContentPane().add(textField_5);
		
		
		for(int i = 0; i < 5; i++) {
			results.add(i, new JLabel());
			(results.get(i)).setIcon(new ImageIcon(img3));
			(results.get(i)).setBounds(480, 151 + (i*90), 45, 55);
			frame.getContentPane().add(results.get(i));
			(results.get(i)).setVisible(false);
		}
		
		btnNewButton = new JButton("RESULTS");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(180, 640, 250, 45);
		btnNewButton.addActionListener(this);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setVisible(true);
		
			ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				frame.getContentPane().remove(btnNewButton);
				frame.getContentPane().remove(lblNewLabel);
				frame.remove(textField_5);
				frame.remove(map);
				frame.getContentPane().remove(city_img);
				for(int i = 0; i < 5; i++) {
					frame.getContentPane().remove(results.get(i));
				}
				for(int i = 0; i < 5; i++) {
					frame.getContentPane().remove(textFields.get(i));
				}
				new Map(frame,score*10);
			}
	 	};	
		map = new JButton("Map");
		map.setFont(new Font("Times New Roman", Font.BOLD, 50));
		map.setForeground(Color.WHITE);
		map.setOpaque(false);
		map.setBounds(190, 650, 250, 50);
		map.addActionListener(b1);
		map.setContentAreaFilled(false);
		map.setBorderPainted(false);
		frame.getContentPane().add(map);
		map.setVisible(false);
		
		
		lblNewLabel = new JLabel("Write 5 words related to the destination of: "+ place );
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(3, 35, 620, 35);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		//JLabel city_img = new JLabel();
		city_img.setIcon(new ImageIcon(img));
		city_img.setBounds(-50, -120, 5000, 1050);
		frame.getContentPane().add(city_img);
		
	
		
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
	
	@Override
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
		displayAnswers(e);
		//
	/*	if (e.getSource() == map) {
			
			frame.getContentPane().remove(btnNewButton);
			frame.getContentPane().remove(lblNewLabel);
			frame.remove(textField_5);
			frame.remove(map);
			for(int i = 0; i < 5; i++) {
				frame.getContentPane().remove(textFields.get(i));
			}
			new Map(frame,score*10);
		}*/
		   
		}
	}

	public void displayAnswers(ActionEvent e) {
		btnNewButton.setVisible(false);
		lblNewLabel.setVisible(false);
		textField_5.setVisible(true);
		map.setVisible(true);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(answers.get(i));
			if((answers.get(i)).equals("C")) {
				(results.get(i)).setIcon(new ImageIcon(img2));
			}
			(results.get(i)).setVisible(true);
		}
		
		textField_5.setText("  RESULTS: " + score*10);
		
	}
} 