import java.awt.EventQueue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class VisitorDocumentation extends DormManagement {

	private JPanel contentPane;
	private JTextField visitorsName;
	private JTextField dateVisited;
	private JLabel lblNewLabel;
	private JTextField bodyTemp;
	private JTextField time;

	/**
	 * Create the frame.
	 */
	public VisitorDocumentation() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		visitorsName = new JTextField();
		visitorsName.setText("Name");
		visitorsName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		visitorsName.setBorder(null);
		visitorsName.setOpaque(false);
		visitorsName.setBackground(new Color(0, 0, 0, 0));
		visitorsName.setBounds(314, 162, 743, 68);
		contentPane.add(visitorsName);
		visitorsName.setColumns(10);
				
		bodyTemp = new JTextField();
		bodyTemp.setText("Temperature");
		bodyTemp.setOpaque(false);
		bodyTemp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bodyTemp.setColumns(10);
		bodyTemp.setBorder(null);
		bodyTemp.setBackground(new Color(0, 0, 0, 0));
		bodyTemp.setBounds(314, 293, 743, 68);
		contentPane.add(bodyTemp);
			
		dateVisited = new JTextField();
		dateVisited.setText("Date");
		dateVisited.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dateVisited.setBorder(null);
		dateVisited.setColumns(10);
		dateVisited.setOpaque(false);
		dateVisited.setBackground(new Color(0, 0, 0, 0));
		dateVisited.setBounds(314, 423, 736, 68);
		contentPane.add(dateVisited);
		
		time = new JTextField();
		time.setText("Time");
		time.setOpaque(false);
		time.setFont(new Font("Tahoma", Font.PLAIN, 25));
		time.setColumns(10);
		time.setBorder(null);
		time.setBackground(new Color(0, 0, 0, 0));
		time.setBounds(314, 549, 743, 68);
		contentPane.add(time);
		
		String filePath = "C:\\Users\\isaia\\OneDrive\\Desktop\\VisitorsData.txt";
		File file = new File(filePath);
		
		JButton SubmitBtn = new JButton("");
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
						 bw.write(visitorsName.getText() + "/" + bodyTemp.getText()+ "/" + dateVisited.getText()  
						 + "/" + time.getText() );
						 bw.newLine();
						 bw.close();
						 JOptionPane.showMessageDialog(null, "Record Saved Successfully");
					 } catch(Exception ex) {
						 ex.printStackTrace();
					 }
				
			}
		});
		SubmitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SubmitBtn.setBorder(null);
		SubmitBtn.setBounds(866, 638, 171, 61);
		SubmitBtn.setContentAreaFilled(false);
		contentPane.add(SubmitBtn);
		
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\isaia\\Downloads\\MicrosoftTeams-image (28).png"));
		lblNewLabel.setBounds(0, 0, 1186, 763);
		contentPane.add(lblNewLabel);
	}
}
