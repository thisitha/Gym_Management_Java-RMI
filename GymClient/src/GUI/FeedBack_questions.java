package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface.IGymFeedback;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FeedBack_questions extends JFrame {

	private JPanel contentPane;
	  
	/**
	 * Launch the application.
	 */
	private String Q1;
	private String Q2;
	private String Q3;
	private String Q4;
	private String Q5;
	private String Q6;
	private String Q7;
	private String Q8;
	private String Q9;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBack_questions frame = new FeedBack_questions();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.getAlignmentX();
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FeedBack_questions() {
		setTitle("FeedBack Form");
		setResizable(false);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1613, 1012);
		contentPane = new JPanel() ;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrFeedbackForm = new JTextArea();
		txtrFeedbackForm.setForeground(Color.WHITE);
		txtrFeedbackForm.setBackground(SystemColor.menu);
		txtrFeedbackForm.setFont(new Font("Monospaced", Font.BOLD, 31));
		txtrFeedbackForm.setEditable(false);
		txtrFeedbackForm.setText("FeedBack Form");
		txtrFeedbackForm.setBounds(575, 24, 275, 58);
		txtrFeedbackForm.setOpaque(false);
		contentPane.add(txtrFeedbackForm);
		
		JTextArea txtrwhereDidYou = new JTextArea();
		txtrwhereDidYou.setForeground(Color.WHITE);
		txtrwhereDidYou.setBackground(SystemColor.menu);
		txtrwhereDidYou.setText("1)Where Did You Hear About Us?");
		txtrwhereDidYou.setFont(new Font("Monospaced", Font.BOLD, 28));
		txtrwhereDidYou.setEditable(false);
		txtrwhereDidYou.setBounds(10, 122, 525, 45);
		txtrwhereDidYou.setOpaque(false);
		txtrwhereDidYou.setOpaque(false);
		contentPane.add(txtrwhereDidYou);
		
		JTextArea txtrWhatIsYour = new JTextArea();
		txtrWhatIsYour.setForeground(Color.WHITE);
		txtrWhatIsYour.setBackground(SystemColor.menu);
		txtrWhatIsYour.setText("2)What Is Your Weight Range?");
		txtrWhatIsYour.setFont(new Font("Monospaced", Font.BOLD, 28));
		txtrWhatIsYour.setEditable(false);
		txtrWhatIsYour.setBounds(10, 269, 525, 45);
		txtrWhatIsYour.setOpaque(false);
		contentPane.add(txtrWhatIsYour);
		
		JTextArea txtrhowLongHave = new JTextArea();
		txtrhowLongHave.setForeground(Color.WHITE);
		txtrhowLongHave.setBackground(SystemColor.menu);
		txtrhowLongHave.setText("3)How Long Have You Been Using A Gym For?");
		txtrhowLongHave.setFont(new Font("Monospaced", Font.BOLD, 28));
		txtrhowLongHave.setEditable(false);
		txtrhowLongHave.setBounds(10, 402, 712, 45);
		txtrhowLongHave.setOpaque(false);
		contentPane.add(txtrhowLongHave);
		
		JRadioButton A1 = new JRadioButton("Social Media");
		A1.setForeground(Color.WHITE);
		A1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		A1.setBounds(86, 186, 158, 21);
		A1.setActionCommand("Social Media");
		A1.setOpaque(false);
		contentPane.add(A1);
		
		JRadioButton A3 = new JRadioButton("From A Friend");
		A3.setForeground(Color.WHITE);
		A3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		A3.setBounds(450, 186, 193, 21);
		 A3.setActionCommand("From a Friend");
		 A3.setOpaque(false);
		contentPane.add(A3);
		
		 
		 
		 JRadioButton A2 = new JRadioButton("From An Add");
		 A2.setForeground(Color.WHITE);
		 A2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 A2.setBounds(262, 186, 169, 21);
		 A2.setActionCommand("From a Add");
		 A2.setOpaque(false);
		 contentPane.add(A2);
		 
		 JRadioButton B1 = new JRadioButton("80>");
		 B1.setForeground(Color.WHITE);
		 B1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 B1.setBounds(86, 345, 76, 21);
		 B1.setActionCommand("80>");
		 B1.setOpaque(false);
		 contentPane.add(B1);
		 
		 JRadioButton B2 = new JRadioButton("80-65");
		 B2.setForeground(Color.WHITE);
		 B2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 B2.setBounds(210, 345, 113, 21);
		 B2.setActionCommand("80-65");
		 B2.setOpaque(false);
		 contentPane.add(B2);
		 
		 
		 
		 JRadioButton B4 = new JRadioButton("55<");
		 B4.setForeground(Color.WHITE);
		 B4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 B4.setBounds(389, 345, 158, 21);
		 B4.setActionCommand("55<");
		 B4.setOpaque(false);
		 contentPane.add(B4);
		 
		 JRadioButton C1 = new JRadioButton("1 - 2 Months");
		 C1.setForeground(Color.WHITE);
		 C1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 C1.setBounds(87, 465, 158, 21);
		 C1.setActionCommand("1 - 2 Months");
		 C1.setOpaque(false);
		 contentPane.add(C1);
		 
		 JRadioButton C2 = new JRadioButton("2 - 3 Months");
		 C2.setForeground(Color.WHITE);
		 C2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 C2.setBounds(247, 465, 158, 21);
		 C2.setActionCommand("2 - 3 Months");
		 C2.setOpaque(false);
		 contentPane.add(C2);
		 
		 JRadioButton C3 = new JRadioButton("Greater Than 4 Months");
		 C3.setForeground(Color.WHITE);
		 C3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 C3.setBounds(407, 465, 253, 21);
		 C3.setActionCommand("Greater Than 4 Months");
		 C3.setOpaque(false);
		 contentPane.add(C3);
		 
		 JTextArea txtrWhatTimeDo = new JTextArea();
		 txtrWhatTimeDo.setForeground(Color.WHITE);
		 txtrWhatTimeDo.setBackground(SystemColor.menu);
		 txtrWhatTimeDo.setText("4)What Time Do You Prefer To Workout?");
		 txtrWhatTimeDo.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrWhatTimeDo.setEditable(false);
		 txtrWhatTimeDo.setBounds(10, 529, 712, 45);
		 txtrWhatTimeDo.setOpaque(false);
		 contentPane.add(txtrWhatTimeDo);
		 
		 JRadioButton D2 = new JRadioButton("AfterNoon");
		 D2.setForeground(Color.WHITE);
		 D2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 D2.setBounds(208, 592, 126, 21);
		 D2.setActionCommand("AfterNoon");
		 D2.setOpaque(false);
		 contentPane.add(D2);
		 
		 JRadioButton D1 = new JRadioButton("Morning");
		 D1.setForeground(Color.WHITE);
		 D1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 D1.setBounds(87, 592, 158, 21);
		 D1.setActionCommand("Morning");
		 D1.setOpaque(false);
		 contentPane.add(D1);
		 
		 JRadioButton D3 = new JRadioButton("Night");
		 D3.setForeground(Color.WHITE);
		 D3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 D3.setBounds(338, 592, 158, 21);
		 D3.setActionCommand("Night");
		 D3.setOpaque(false);
		 contentPane.add(D3);
		 
		 JTextArea txtrwhatIsYour = new JTextArea();
		 txtrwhatIsYour.setForeground(Color.WHITE);
		 txtrwhatIsYour.setBackground(SystemColor.menu);
		 txtrwhatIsYour.setText("5)What Is Your Top reason For Joining Us?");
		 txtrwhatIsYour.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrwhatIsYour.setEditable(false);
		 txtrwhatIsYour.setBounds(10, 646, 712, 45);
		 txtrwhatIsYour.setOpaque(false);
		 contentPane.add(txtrwhatIsYour);
		 
		 JRadioButton E1 = new JRadioButton("Affordability");
		 E1.setForeground(Color.WHITE);
		 E1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 E1.setBounds(87, 722, 149, 21);
		 E1.setActionCommand("Affordability");
		 E1.setOpaque(false);
		 contentPane.add(E1);
		 
		 JRadioButton E2 = new JRadioButton("Facilities");
		 E2.setForeground(Color.WHITE);
		 E2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 E2.setBounds(247, 722, 107, 21);
		 E2.setActionCommand("Facilities");
		 E2.setOpaque(false);
		 contentPane.add(E2);
		 
		 JRadioButton E3 = new JRadioButton("Parking");
		 E3.setForeground(Color.WHITE);
		 E3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 E3.setBounds(359, 722, 107, 21);
		 E3.setOpaque(false);
		 contentPane.add(E3);
		 
		 JRadioButton E4 = new JRadioButton("Trainers");
		 E4.setForeground(Color.WHITE);
		 E4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 E4.setBounds(468, 722, 158, 21);
		 E4.setActionCommand("Trainers");
		 E4.setOpaque(false);
		 contentPane.add(E4);
		

		 JTextArea txtrhowWeeThe = new JTextArea();
		 txtrhowWeeThe.setForeground(Color.WHITE);
		 txtrhowWeeThe.setText("6)How Were The parking Facilities?");
		 txtrhowWeeThe.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrhowWeeThe.setEditable(false);
		 txtrhowWeeThe.setBackground(SystemColor.menu);
		 txtrhowWeeThe.setBounds(731, 122, 575, 45);
		 txtrhowWeeThe.setOpaque(false);
		 contentPane.add(txtrhowWeeThe);
		 
		 JRadioButton F1 = new JRadioButton("Good");
		 F1.setForeground(Color.WHITE);
		 F1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 F1.setBounds(772, 186, 94, 21);
		 F1.setActionCommand("Good");
		 F1.setOpaque(false);
		 contentPane.add(F1);
		 
		 JRadioButton F2 = new JRadioButton("Average");
		 F2.setForeground(Color.WHITE);
		 F2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 F2.setBounds(875, 186, 111, 21);
		 F2.setActionCommand("Average");
		 F2.setOpaque(false);
		 contentPane.add(F2);
		 
		 JRadioButton F3 = new JRadioButton("Poor");
		 F3.setForeground(Color.WHITE);
		 F3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 F3.setBounds(1002, 186, 158, 21);
		 F3.setActionCommand("Poor");
		 F3.setOpaque(false);
		 contentPane.add(F3);
		 
		 JTextArea txtrO = new JTextArea();
		 txtrO.setForeground(Color.WHITE);
		 txtrO.setText("7)How Was The Cleanliness?");
		 txtrO.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrO.setEditable(false);
		 txtrO.setBackground(SystemColor.menu);
		 txtrO.setBounds(731, 245, 575, 45);
		 txtrO.setOpaque(false);
		 contentPane.add(txtrO);
		 
		 JRadioButton G1 = new JRadioButton("Good");
		 G1.setForeground(Color.WHITE);
		 G1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 G1.setBounds(772, 308, 94, 21);
		 G1.setActionCommand("Good");
		 G1.setOpaque(false);
		 contentPane.add(G1);
		 
		 JRadioButton G2 = new JRadioButton("Moderate");
		 G2.setForeground(Color.WHITE);
		 G2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 G2.setBounds(868, 308, 118, 21);
		 G2.setActionCommand("Moderate");
		 G2.setOpaque(false);
		 contentPane.add(G2);
		 
		 JRadioButton G3 = new JRadioButton("Poor");
		 G3.setForeground(Color.WHITE);
		 G3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 G3.setBounds(1002, 308, 158, 21);
		 G3.setActionCommand("Poor");
		 G3.setOpaque(false);
		 contentPane.add(G3);
		 
		 JTextArea txtrareTheEquipments = new JTextArea();
		 txtrareTheEquipments.setForeground(Color.WHITE);
		 txtrareTheEquipments.setText("8)Are The Equipments Upto Standard?");
		 txtrareTheEquipments.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrareTheEquipments.setEditable(false);
		 txtrareTheEquipments.setBackground(SystemColor.menu);
		 txtrareTheEquipments.setBounds(732, 371, 611, 45);
		 txtrareTheEquipments.setOpaque(false);
		 contentPane.add(txtrareTheEquipments);
		 
		 JRadioButton H1 = new JRadioButton("Yes");
		 H1.setForeground(Color.WHITE);
		 H1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 H1.setBounds(772, 427, 94, 21);
		 H1.setActionCommand("Yes");
		 H1.setOpaque(false);
		 contentPane.add(H1);
		 
		 JRadioButton H3 = new JRadioButton("No");
		 H3.setForeground(Color.WHITE);
		 H3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 H3.setBounds(1038, 427, 94, 21);
		 H3.setActionCommand("No");
		 H3.setOpaque(false);
		 contentPane.add(H3);
		 
		 JRadioButton H2 = new JRadioButton("Moderate");
		 H2.setForeground(Color.WHITE);
		 H2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 H2.setBounds(875, 427, 135, 21);
		 H2.setActionCommand("Moderate");
		 H2.setOpaque(false);
		 contentPane.add(H2);
		 
		 JTextArea txtrWasTheStaff = new JTextArea();
		 txtrWasTheStaff.setForeground(Color.WHITE);
		 txtrWasTheStaff.setText("9)Was The Staff Friendly And Easy To Deal With?");
		 txtrWasTheStaff.setFont(new Font("Monospaced", Font.BOLD, 28));
		 txtrWasTheStaff.setEditable(false);
		 txtrWasTheStaff.setBackground(SystemColor.menu);
		 txtrWasTheStaff.setBounds(732, 478, 818, 45);
		 txtrWasTheStaff.setOpaque(false);
		 contentPane.add(txtrWasTheStaff);
		 
		 JRadioButton I2 = new JRadioButton("Kind Of");
		 I2.setForeground(Color.WHITE);
		 I2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 I2.setBounds(905, 554, 123, 21);
		 I2.setActionCommand("Kind Of");
		 I2.setOpaque(false);
		 contentPane.add(I2);
		 
		 JRadioButton I1 = new JRadioButton("Of Cource");
		 I1.setForeground(Color.WHITE);
		 I1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 I1.setBounds(772, 554, 131, 21);
		 I1.setActionCommand("Of Cource");
		 I1.setOpaque(false);
		 contentPane.add(I1);
		 
		 JRadioButton I3 = new JRadioButton("Absolutely Yes");
		 I3.setForeground(Color.WHITE);
		 I3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		 I3.setBounds(1049, 554, 188, 21);
		 I3.setActionCommand("Absolutely Yes");
		 I3.setOpaque(false);
		 contentPane.add(I3);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 ButtonGroup A = new ButtonGroup();
		  A.add(A1);
		  A.add(A2);
		  A.add(A3);
		  
		 ButtonGroup B = new ButtonGroup();
		 B.add(B1);
		 B.add(B2);
		
		 B.add(B4);
		 
		 ButtonGroup C = new ButtonGroup();
		 C.add(C1);
		 C.add(C2);
		 C.add(C3);
		 
		 ButtonGroup D = new ButtonGroup();
		 D.add(D1);
		 D.add(D2);
		 D.add(D3);
		 
		 ButtonGroup E = new ButtonGroup();
		 E.add(E1);
		 E.add(E2);
		 E.add(E3);
		 E.add(E4);
		 
		 ButtonGroup F = new ButtonGroup();
		 F.add(F1);
		 F.add(F2);
		 F.add(F3);
		 
		 ButtonGroup G = new ButtonGroup();
		 G.add(G1);
		 G.add(G2);
		 G.add(G3);
		 
		 ButtonGroup H = new ButtonGroup();
		 H.add(H1);
		 H.add(H2);
		 H.add(H3);
		 
		 ButtonGroup I = new ButtonGroup();
		 I.add(I1);
		 I.add(I2);
		 I.add(I3);
		 
		 
		
		 
		 
		 JButton btnNewButton = new JButton("Submit");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 			 Q1 = A.getSelection().getActionCommand();
		 			 Q2 = B.getSelection().getActionCommand();
		 			 Q3 = C.getSelection().getActionCommand();
		 			 Q4 = D.getSelection().getActionCommand();
		 			 Q5 = E.getSelection().getActionCommand();
		 			 Q6 = F.getSelection().getActionCommand();
		 			 Q7 = G.getSelection().getActionCommand();
		 			 Q8 = H.getSelection().getActionCommand();
		 			 Q9 = I.getSelection().getActionCommand();
		 			
		 			
		 			try {
						IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
						
						
						ser.AddAnswer(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9);
						JOptionPane.showMessageDialog(null, "Thank you for your feedback");
						//dispose();
					} catch (MalformedURLException | RemoteException | NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			
		 			
		 			
		 			
		 	}
		 });
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		 btnNewButton.setBounds(1247, 722, 193, 35);
		 contentPane.add(btnNewButton);
		 
		 JButton btnNewComplaint = new JButton("Make A Complaint");
		 btnNewComplaint.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		Complain c = new Complain();
				c.setVisible(true);
				 
		 	}
		 });
		 btnNewComplaint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		 btnNewComplaint.setBounds(1182, 767, 312, 35);
		 contentPane.add(btnNewComplaint);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(FeedBack_questions.class.getResource("/GUI/login.jpg")));
		 lblNewLabel.setBounds(-374, 0, 1927, 931);
		 contentPane.add(lblNewLabel);
		 
		
		 
		 
		 
		
		
		
	}
}
