package game;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Map extends JFrame {
	JFrame frame;
    int level;
	JLabel pic;
	JLayeredPane panel = new JLayeredPane();
	JLabel totalscore = new JLabel();
	static int total_score=0;
	static int count=0;
	static ArrayList <String> cities = new  ArrayList<String>();
	public Map(JFrame frame,int score) {
		this.frame = frame;
		total_score = score + total_score ;
		createmapframe();
	}
	private void createmapframe() {
		//Create frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(608, 800);
	    frame.setBackground(new java.awt.Color(153,204,255));
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		JLabel title = new JLabel("Map You");
		title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 60));
		title.setForeground(new java.awt.Color(51,0,51));
		title.setBounds(150, -19, 1400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		panel.add(title, Integer.valueOf(1));
		panel.setBounds(0, 0, 608, 800);
		pic = new JLabel();
		pic.setBounds(0,0,608, 800);
		pic.setVisible(true);
    	pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("./Map.png")));
    	panel.add(pic, Integer.valueOf(0));
    	totalscore.setText(" Score:"+ total_score);
    	totalscore.setBackground((new java.awt.Color(255,236,204)));
	    totalscore.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	    totalscore.setBounds(510, 715, 90, 40);
	    panel.add(totalscore,Integer.valueOf(1));
	    totalscore.setOpaque(true);
	 	totalscore.setForeground(new java.awt.Color(51,0,51));
	 	totalscore.setVisible(true);
    	panel.setVisible(true);
    	createcities();
    	createxitbutton();
        frame.add(panel);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	private void createxitbutton() {
		ActionListener b10 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 			    panel.setVisible(false);
	 			    System.exit(ABORT);
			}
	 	};
	    JButton exit = new JButton("Exit");
	    exit.setBounds(510, 675, 90, 40);
	    exit.setVisible(true);
	    exit.setBackground(new java.awt.Color(23,0,29));
	    exit.setForeground(Color.white);
	    exit.setFocusable(false);
	    exit.setBorderPainted(false);
	    exit.addActionListener(b10);
		panel.add(exit, Integer.valueOf(1));
	}
	private void createcities() {
		ActionListener b1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 			    panel.setVisible(false);
	 				Findthewords ithaci = new Findthewords(frame, 2);
	 				cities.add("Ithaca");
	 				count++;
			}
	 	};
	 	ActionListener b2 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 				panel.setVisible(false);
	 				Findthewords sparti = new Findthewords(frame, 1);
	 				cities.add("Sparta");
	 				count++;
	 		}
	 	};
	 	ActionListener b3 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Findthewords bergina = new Findthewords(frame, 3);
	 		 	   cities.add("Vergina");
	 		 	   count++;
	 		}
	 	};
	 	ActionListener b4 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Question creta = new Question(3, frame);
	 		 	   cities.add("Crete");
	 		 	   count++;
	 		}
	 	};
	 	ActionListener b5 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Question mecynes = new Question(1, frame);
	 		 	   cities.add("Mecynae");
	 		 	   count++;
	 		}
	 	};
	 	ActionListener b6 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Question dilo = new Question(2, frame);
	 		 	   cities.add("Dilos");
	 		 	   count++;
	 		}
	 	};
		ActionListener b7 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Pesvres athena = new Pesvres("ATHENS");
	 		 	   cities.add("Athens");
	 		 	   count++;
	 		}
	 	};
	 	ActionListener b8 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Pesvres delfi = new Pesvres("DELPHI");
	 		 	   cities.add("Delphi");
	 		       count++;
	 		}
	 	};
	 	ActionListener b9 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 		 	   panel.setVisible(false);
	 		 	   Pesvres thermopiles = new Pesvres("THERMOPYLAE");
	 		 	   cities.add("Thermopylae");
	 		 	   count++;
	 		}
	 	};

        JButton ithaca = new JButton("Ithaca");
        ithaca.setBackground((new java.awt.Color(255,236,204)));
	    ithaca.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	    ithaca.setBounds(36, 320, 100, 40);
	    ithaca.setHorizontalAlignment(JLabel.CENTER);
	    ithaca.setOpaque(false);
	    ithaca.setFocusable(false);
	    ithaca.addActionListener(b1);
	    ithaca.setContentAreaFilled(false);
	    ithaca.setBorderPainted(false);
	 	ithaca.setForeground(new java.awt.Color(51,0,51));
	 	ithaca.setVisible(true);
	 	JButton sparta = new JButton("Sparta");
	 	sparta.setBackground((new java.awt.Color(255,236,204)));
	 	sparta.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	sparta.setBounds(165, 440, 100, 40);
	 	sparta.setHorizontalAlignment(JLabel.CENTER);
	 	sparta.setOpaque(false);
	 	sparta.setFocusable(false);
		sparta.addActionListener(b2);
	 	sparta.setContentAreaFilled(false);
	 	sparta.setBorderPainted(false);
	 	sparta.setForeground(new java.awt.Color(51,0,51));
	 	sparta.setVisible(true);
	 	JButton vergina = new JButton("Vergina");
	 	vergina.setBackground((new java.awt.Color(255,236,204)));
	 	vergina.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	vergina.setBounds(270, 90, 100, 40);
	 	vergina.setHorizontalAlignment(JLabel.CENTER);
	 	vergina.setOpaque(false);
	 	vergina.setFocusable(false);
		vergina.addActionListener(b3);
	 	vergina.setContentAreaFilled(false);
	 	vergina.setBorderPainted(false);
	 	vergina.setForeground(new java.awt.Color(51,0,51));
	 	vergina.setVisible(true);
	 	JButton crete = new JButton("Crete");
	 	crete.setBackground((new java.awt.Color(255,236,204)));
	 	crete.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	crete.setBounds(343, 685, 100, 40);
	 	crete.setHorizontalAlignment(JLabel.CENTER);
	 	crete.setOpaque(false);
	 	crete.setFocusable(false);
	 	crete.addActionListener(b4);
	 	crete.setContentAreaFilled(false);
	 	crete.setBorderPainted(false);
	 	crete.setForeground(new java.awt.Color(51,0,51));
	 	crete.setVisible(true);
	 	JButton mycenae = new JButton("Myceneae");
	 	mycenae.setBackground((new java.awt.Color(255,236,204)));
	 	mycenae.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	mycenae.setBounds(125, 340, 120, 40);
	 	mycenae.setHorizontalAlignment(JLabel.CENTER);
	 	mycenae.setOpaque(false);
	 	mycenae.setFocusable(false);
	 	mycenae.addActionListener(b5);
	 	mycenae.setContentAreaFilled(false);
	 	mycenae.setBorderPainted(false);
	 	mycenae.setForeground(new java.awt.Color(51,0,51));
	 	mycenae.setVisible(true);
	 	JButton dilos = new JButton("Dilos");
	 	dilos.setBackground((new java.awt.Color(255,236,204)));
	 	dilos.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	dilos.setBounds(340, 450, 120, 40);
	 	dilos.setHorizontalAlignment(JLabel.CENTER);
	 	dilos.setOpaque(false);
	 	dilos.setFocusable(false);
	 	dilos.addActionListener(b6);
	 	dilos.setContentAreaFilled(false);
	 	dilos.setBorderPainted(false);
	 	dilos.setForeground(new java.awt.Color(51,0,51));
	 	dilos.setVisible(true);
	 	JButton athens = new JButton("Athens");
	 	athens.setBackground((new java.awt.Color(255,236,204)));
	 	athens.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	athens.setBounds(290, 380, 100, 40);
	 	athens.setHorizontalAlignment(JLabel.CENTER);
	 	athens.setOpaque(false);
	 	athens.setFocusable(false);
	 	athens.addActionListener(b7);
	 	athens.setContentAreaFilled(false);
	 	athens.setBorderPainted(false);
	 	athens.setForeground(new java.awt.Color(51,0,51));
	 	athens.setVisible(true);
	 	JButton delphi = new JButton("Delphi");
	 	delphi.setBackground((new java.awt.Color(255,236,204)));
	 	delphi.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
	 	delphi.setBounds(160, 250, 100, 40);
	 	delphi.setHorizontalAlignment(JLabel.CENTER);
	 	delphi.setOpaque(false);
	 	delphi.setFocusable(false);
	 	delphi.addActionListener(b8);
	 	delphi.setContentAreaFilled(false);
	 	delphi.setBorderPainted(false);
	 	delphi.setForeground(new java.awt.Color(51,0,51));
	 	delphi.setVisible(true);
		JButton thermopylae = new JButton("Thermopylae");
		thermopylae.setBackground((new java.awt.Color(255,236,204)));
		thermopylae.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 17));
		thermopylae.setBounds(243, 270, 140, 40);
		thermopylae.setHorizontalAlignment(JLabel.CENTER);
		thermopylae.setOpaque(false);
		thermopylae.setFocusable(false);
		thermopylae.addActionListener(b9);
		thermopylae.setContentAreaFilled(false);
		thermopylae.setBorderPainted(false);
		thermopylae.setForeground(new java.awt.Color(51,0,51));
		thermopylae.setVisible(true);
		if(count!=0) {
			for(int i=0; i<cities.size();i++) {
				if(cities.get(i).equals("Ithaca")) {
					ithaca.setEnabled(false);
				}else if(cities.get(i).equals("Sparta")) {
					sparta.setEnabled(false);
				}else if(cities.get(i).equals("Vergina")) {
					vergina.setEnabled(false);
				}else if(cities.get(i).equals("Crete")) {
					crete.setEnabled(false);
				}else if(cities.get(i).equals("Mecynae")) {
					mycenae.setEnabled(false);
				}else if(cities.get(i).equals("Dilos")) {
					dilos.setEnabled(false);
				}else if(cities.get(i).equals("Athens")) {
					athens.setEnabled(false);
				}else if(cities.get(i).equals("Delphi")) {
					delphi.setEnabled(false);
				}else if(cities.get(i).equals("Thermopylae")) {
					thermopylae.setEnabled(false);
				}
			}
		}
	 	panel.add(ithaca,Integer.valueOf(2));
	 	panel.add(sparta,Integer.valueOf(2));
	 	panel.add(vergina,Integer.valueOf(2));
	 	panel.add(crete,Integer.valueOf(2));
	 	panel.add(mycenae,Integer.valueOf(2));
	 	panel.add(dilos,Integer.valueOf(2));
	 	panel.add(athens,Integer.valueOf(2));
	 	panel.add(delphi,Integer.valueOf(2));
	 	panel.add(thermopylae,Integer.valueOf(2));
	}
}
