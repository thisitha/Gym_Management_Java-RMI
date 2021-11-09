package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Interface.IGymFeedback;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class AdminReport extends JFrame {

	private JPanel contentPane;
	private JTextField Q1;
	private JTextField Q2;
	//private String questiontxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminReport frame = new AdminReport();
					frame.setVisible(true);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminReport() {
		setResizable(false);
		setTitle("Administrator DashBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea adminName = new JTextArea();
		adminName.setEditable(false);
		adminName.setText("Admin DAshBoard");
		adminName.setBackground(SystemColor.menu);
		adminName.setFont(new Font("Ravie", Font.PLAIN, 38));
		adminName.setBounds(229, 24, 455, 114);
		adminName.setOpaque(false);
		contentPane.add(adminName);
	 
		
		JTextArea txtrAddNewQuestion = new JTextArea();
		txtrAddNewQuestion.setBackground(SystemColor.menu);
		txtrAddNewQuestion.setEditable(false);
		txtrAddNewQuestion.setText("Add A New Admin");
		txtrAddNewQuestion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 21));
		txtrAddNewQuestion.setBounds(28, 109, 253, 46);
		txtrAddNewQuestion.setOpaque(false);
		contentPane.add(txtrAddNewQuestion);
		
		
		
		JButton btnViewAnalyseReport = new JButton("View/ Analyse Report");
		btnViewAnalyseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			generateChart window = new generateChart();
				window.setVisible(true);
			///	dispose(); 
				
				
			}
		});
		btnViewAnalyseReport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewAnalyseReport.setBounds(285, 359, 231, 46);
		contentPane.add(btnViewAnalyseReport);
		
		Q1 = new JTextField();
		Q1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Q1.setBounds(259, 196, 247, 28);
		Q1.setOpaque(false);
		contentPane.add(Q1);
		Q1.setColumns(10);
		
		Q2 = new JPasswordField();
		Q2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Q2.setOpaque(false);
		Q2.setColumns(10);
		
		Q2.setBounds(259, 257, 247, 28);
		contentPane.add(Q2);
		
		JButton btnNewButton = new JButton("Add New Admin");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 
				String userName = Q1.getText().toString();

			 
				String password = Q2.getText().toString();
				
				 
				
				
					try {
						IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
						ser.AddAdmin(userName, password);
						
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Admin Added");
				}
			
		});
		btnNewButton.setBounds(561, 362, 165, 41);
		contentPane.add(btnNewButton);
		
		JTextArea txtrAdminPassword = new JTextArea();
		txtrAdminPassword.setText("Admin Password");
		txtrAdminPassword.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		txtrAdminPassword.setEditable(false);
		txtrAdminPassword.setBackground(SystemColor.menu);
		txtrAdminPassword.setBounds(28, 257, 165, 41);
		txtrAdminPassword.setOpaque(false);
		contentPane.add(txtrAdminPassword);
		
		
		
		JTextArea txtrAdminUsername = new JTextArea();
		txtrAdminUsername.setText("Admin Username");
		txtrAdminUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		txtrAdminUsername.setEditable(false);
		txtrAdminUsername.setBackground(SystemColor.menu);
		txtrAdminUsername.setBounds(28, 196, 165, 36);
		txtrAdminUsername.setOpaque(false);
		contentPane.add(txtrAdminUsername);
		
		JButton btnViewComplaints = new JButton("View Complaints");
		btnViewComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getComplaints window = new getComplaints();
				window.setVisible(true);
			}
		});
		btnViewComplaints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewComplaints.setBounds(41, 359, 231, 46);
		contentPane.add(btnViewComplaints);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminReport.class.getResource("/GUI/Gym-Background-50.png")));
		lblNewLabel.setBounds(-12, 0, 877, 502);
		contentPane.add(lblNewLabel);
		
	
		
		
		
		
	}
}
