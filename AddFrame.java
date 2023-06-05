import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;


public class AddFrame extends DormManagement{

	private JPanel contentPane;
	private JTextField roomNumberField;
	private JTextField nameField;
	private JTextField contactNumberField;
	private JTextField rentDueField;
	private JTextField rentStatus;
	private JButton back;
	int rowCount;

	
	public AddFrame(int rowCount) {
		
		this.rowCount = rowCount;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roomNumberField = new JTextField();
		roomNumberField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomNumberField.setBorder(null);
		roomNumberField.setBounds(231, 177, 735, 57);
		roomNumberField.setOpaque(false);
		roomNumberField.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(roomNumberField);
		roomNumberField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBorder(null);
		nameField.setBounds(231, 264, 735, 57);
		nameField.setOpaque(false);
		nameField.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		contactNumberField = new JTextField();
		contactNumberField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contactNumberField.setBorder(null);
		contactNumberField.setColumns(10);
		contactNumberField.setBounds(231, 350, 735, 57);
		contactNumberField.setOpaque(false);
		contactNumberField.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(contactNumberField);
		
		rentDueField = new JTextField();
		rentDueField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rentDueField.setBorder(null);
		rentDueField.setColumns(10);
		rentDueField.setBounds(231, 432, 735, 57);
		rentDueField.setOpaque(false);
		rentDueField.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(rentDueField);
		
		rentStatus = new JTextField();
		rentStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rentStatus.setBorder(null);
		rentStatus.setColumns(10);
		rentStatus.setBounds(231, 518, 735, 57);
		rentStatus.setOpaque(false);
		rentStatus.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(rentStatus);
		
		String filePath = "C:\\Users\\isaia\\OneDrive\\Desktop\\TenantsData.txt";
		File file = new File(filePath);
		
		JButton add = new JButton("");
		add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add.setBorder(null);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rowCount == 15) {
					JOptionPane.showMessageDialog(null, "Can't Add more tenants");
					dispose();
					
				}else {
					
					try {
					 BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
						 bw.write(roomNumberField.getText() + "/" + nameField.getText()+ "/" + contactNumberField.getText()  
						 + "/" + rentDueField.getText() + "/" + rentStatus.getText());
						 bw.newLine();
						 bw.close();
						 JOptionPane.showMessageDialog(null, "Record Saved Successfully");
					 } catch(Exception ex) {
						 ex.printStackTrace();
					 }
				}
				
				
				
			}
		});
		add.setBounds(837, 599, 138, 49);
		add.setContentAreaFilled(false);
		contentPane.add(add);
		
		back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setBorder(null);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean visible = true;
				LandLordDatabase back = new LandLordDatabase (visible);
				back.setVisible(true);
				dispose();
			}
		});
		back.setBounds(666, 599, 138, 49);
		back.setContentAreaFilled(false);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\isaia\\Downloads\\MicrosoftTeams-image (27).png"));
		lblNewLabel.setBounds(0, 0, 1186, 763);
		contentPane.add(lblNewLabel);
	}


	
}
