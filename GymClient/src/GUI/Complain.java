package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Interface.IGymFeedback;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Complain extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAdmission;
	private JTextField txtComplain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complain frame = new Complain();
					frame.setVisible(true);
					frame.getContentPane().add(new JLabel(new ImageIcon("slide1.jpg")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Complain() {
		setTitle("New Complaint");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Complain");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.PLAIN, 31));
		lblNewLabel.setBounds(403, 42, 323, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bodoni MT Black", Font.BOLD, 22));
		lblName.setBounds(45, 161, 120, 96);
		contentPane.add(lblName);
		
		JLabel lblAdmissionNumber = new JLabel("Admission Number");
		lblAdmissionNumber.setForeground(Color.WHITE);
		lblAdmissionNumber.setFont(new Font("Bodoni MT Black", Font.BOLD, 22));
		lblAdmissionNumber.setBounds(45, 278, 232, 96);
		contentPane.add(lblAdmissionNumber);
		
		JLabel lblComplain = new JLabel("Complain");
		lblComplain.setForeground(Color.WHITE);
		lblComplain.setFont(new Font("Bodoni MT Black", Font.BOLD, 22));
		lblComplain.setBounds(45, 399, 120, 96);
		contentPane.add(lblComplain);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtName.setBounds(280, 183, 286, 46);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAdmission = new JTextField();
		txtAdmission.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtAdmission.setColumns(10);
		txtAdmission.setBounds(280, 317, 286, 46);
		contentPane.add(txtAdmission);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 408, 596, 113);
		contentPane.add(scrollPane);
		
		txtComplain = new JTextField();
		scrollPane.setViewportView(txtComplain);
		txtComplain.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtComplain.setColumns(10);
	//contentPane.add(scrollPane);
		
	
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			
			
			
			public void actionPerformed(ActionEvent arg0) {
			
				
				

		
				
				if (txtName.getText().equals("")||txtComplain.getText().equals("")||txtAdmission.getText().equals("")) {
				//	Icon  icon= new ImageIcon("background.jpg");
				//	hello.setIcon(icon);
					
					JOptionPane.showMessageDialog(null, "Please Fill Out All Fields","Error!", JOptionPane.WARNING_MESSAGE);
					
					
				}else {
				
				
				try {
					IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
					ser.AddComplain(txtName.getText(), txtAdmission.getText(), txtComplain.getText());
					JOptionPane.showMessageDialog(null, "Complaint Has Been Recived Thank You","", JOptionPane.WARNING_MESSAGE);
					dispose();
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(756, 554, 120, 37);
		contentPane.add(btnNewButton);
		
		JLabel hello = new JLabel();
		hello.setIcon(new ImageIcon("C:\\Users\\Thisitha Kavinda\\Desktop\\CIS RMI\\eclipse-workspace.zip_expanded\\GymClient\\src\\GUI\\slide1.jpg"));
		hello.setBounds(0, 0, 993, 618);
		contentPane.add(hello);
		
		
	}
}
