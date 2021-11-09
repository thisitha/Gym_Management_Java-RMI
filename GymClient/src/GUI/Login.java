package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.tools.javac.util.Log;

import Interface.IGymFeedback;


import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	IGymFeedback serr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
////2016050
	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea txtUserName = new JTextArea();
		txtUserName.setFont(new Font("Monospaced", Font.PLAIN, 23));
		txtUserName.setBackground(SystemColor.inactiveCaptionBorder);
		txtUserName.setBounds(196, 88, 186, 32);
		contentPane.add(txtUserName);
		
		JButton btnStartQuestionare = new JButton("Start Feedback form");
		btnStartQuestionare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedBack_questions q = new FeedBack_questions();
				q.setVisible(true);
			}
		});
		btnStartQuestionare.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnStartQuestionare.setBounds(111, 289, 271, 32);
		contentPane.add(btnStartQuestionare);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String UserName=txtUserName.getText();
			//	String password=passwordField.getText();
				
				if (txtUserName.getText().equals("") || passwordField.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Enter Username & Password",
							"Warning Text!", JOptionPane.WARNING_MESSAGE);
				} else {

					try {
						//Registry serverObj = LocateRegistry.getRegistry(1121);
						
					//	serr=(IGymFeedback)serverObj.lookup("GymService2020");
						
						IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
						
						
						if (ser.AdminLogin(txtUserName.getText(), passwordField.getText())) {

							txtUserName.setText("");
							passwordField.setText("");
							AdminReport window = new AdminReport();
							window.setVisible(true);
						

						} else {
							JOptionPane.showMessageDialog(null, "Invalid Username or Password",
									"Error!", JOptionPane.WARNING_MESSAGE);
							passwordField.setText("");
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.toString());
						
					}
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(185, 188, 110, 32);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 131, 186, 31);
		contentPane.add(passwordField);
		
		JButton btnFileAComplaint = new JButton("File A Complaint");
		btnFileAComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Complain c = new Complain();
				c.setVisible(true);
				
			}
		});
		btnFileAComplaint.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnFileAComplaint.setBounds(111, 250, 271, 32);
		contentPane.add(btnFileAComplaint);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 33));
		lblNewLabel_1.setBounds(222, 10, 101, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(40, 80, 146, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(40, 129, 139, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/GUI/log.jpg")));
		lblNewLabel.setBounds(-476, -186, 1375, 811);
		contentPane.add(lblNewLabel);
		
		
	}
}
