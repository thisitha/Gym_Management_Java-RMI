package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Interface.IGymFeedback;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class getComplaints extends JFrame {
		
	private JPanel contentPane;
//	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getComplaints frame = new getComplaints();
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
	

	
	public getComplaints() {
		setResizable(false);
		setTitle("Customer Complaint List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 126, 736, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		Object[] coloum= {"Name","Admission","Complaint"};
		//Object[] row=new Object[0];
		model.setColumnIdentifiers(coloum);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Cutomer Complaint List");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel_1.setBounds(219, 41, 353, 43);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(getComplaints.class.getResource("/GUI/Gym-Background-50.png")));
		lblNewLabel.setBounds(0, 0, 802, 576);
		contentPane.add(lblNewLabel);
		try {
			ArrayList<String> a=new ArrayList<String>();
			IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
			a=ser.getCustomerComplain();
			
			DefaultTableModel model1=(DefaultTableModel)table.getModel();
			Object[] row=new Object[3];
			for(int i=0;i<a.size();)
			{
				row[0]=a.get(i);
				row[1]=a.get(i+1);
				row[2]=a.get(i+2);
				model1.addRow(row);
				i=i+3;
			}
							
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Is the Taxiserver running?");
		} 
		
	}
}
