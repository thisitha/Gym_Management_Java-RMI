package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface.IGymFeedback;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class generateChart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateChart frame = new generateChart();
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
	public generateChart() {
		setResizable(false);
		setTitle("Generate Result Chart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(346, 120, 270, 32);
		comboBox.addItem("Q1");
		comboBox.addItem("Q2");
		comboBox.addItem("Q3");
		comboBox.addItem("Q4");
		comboBox.addItem("Q5");
		comboBox.addItem("Q6");
		comboBox.addItem("Q7");
		comboBox.addItem("Q8");
		comboBox.addItem("Q9");
		contentPane.add(comboBox);
		
		JLabel chartLabel = new JLabel();
			chartLabel.setForeground(Color.PINK);
			chartLabel.setBackground(Color.BLUE);
			chartLabel.setBounds(33, 171, 1011, 601);
			contentPane.add(chartLabel);   
		
		JButton btnNewButton = new JButton("Get Chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String value = comboBox.getSelectedItem().toString();
				
				try {
					IGymFeedback ser = (IGymFeedback) Naming.lookup("rmi://127.0.0.1:1010/GymService2020");
					
					System.out.print(ser.AdminLogin("kavinda", "123"));
					 //ser.getCh("Q2");
					String url1 = ser.getCh(value);
					 System.out.print(url1);
					 
					// URL url= new URL("https://quickchart.io/chart?c={type:'bar',data:{labels:[2012,2013,2014,2015,2016],datasets:[{label:'Users','hello',data:[120,60,50,180,120]}]}}");
					
					 URL url= new URL(url1);
					 BufferedImage image = ImageIO.read(url.openStream());
					 
					 
					 
						// JFrame frame = new JFrame();
					//	 frame.setBounds(900, 100, 800, 650);
					 Icon  icon= new ImageIcon(image);
						// JLabel label = new JLabel(new ImageIcon(image));
						chartLabel.setIcon(icon);
					  //      frame.getContentPane().add(label);
					  //      frame.setVisible(true);
					
					
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 19));
		btnNewButton.setBounds(779, 122, 232, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select The Question Number");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 123, 294, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenerateChart = new JLabel("Generate Chart");
		lblGenerateChart.setForeground(Color.WHITE);
		lblGenerateChart.setFont(new Font("Segoe Print", Font.PLAIN, 31));
		lblGenerateChart.setBounds(415, 10, 346, 82);
		contentPane.add(lblGenerateChart);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(generateChart.class.getResource("/GUI/question.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1175, 772);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
