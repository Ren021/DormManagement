import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LandLordDatabase extends DormManagement {

	private JPanel contentPane;
	private JTable tenantsTable;
	private JTable visitorsTable;
	private DefaultTableModel tenantsModel;
	private DefaultTableModel visitorsModel;
	private Boolean visibility;

	/**
	 * Create the frame.
	 */
	public LandLordDatabase(Boolean visibility) {
		
		this.visibility = visibility;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel tenantsPanel = new JPanel();
		tenantsPanel.setBounds(0, 104, 1194, 659);
		contentPane.add(tenantsPanel);
		tenantsPanel.setVisible(false);
		tenantsPanel.setLayout(null);	
		
		JScrollPane tenantScrollPane = new JScrollPane();
		tenantScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tenantScrollPane.setBounds(110, 30, 975, 551);
		tenantsPanel.add(tenantScrollPane);		
		tenantScrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex = tenantsTable.getSelectedRow();
                System.out.println("Clicked row index: " + rowIndex);

                Object[] rowData = new Object[TableRow.CENTER];
                for (int i = 0; i < TableRow.CENTER; i++) {
                    rowData[i] = tenantsTable.getValueAt(rowIndex, i);
                }
                System.out.println("Clicked row data: " + java.util.Arrays.toString(rowData));
			}
		});
		
		
		tenantsTable = new JTable();
		tenantsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room no.", "Name", "Contact", "Due date", "Rent status", "In", "Out"
			}
		));
		tenantScrollPane.setViewportView(tenantsTable);
		
		String filePath = "C:\\Users\\isaia\\OneDrive\\Desktop\\TenantsData.txt";
		File file = new File(filePath);
		
		JButton TeanantsAddBtn = new JButton("Add");
		TeanantsAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowCount = tenantsTable.getRowCount();
		        	
					AddFrame addPage = new AddFrame(rowCount);
					addPage.setVisible(true);
					
					dispose();
					
					BufferedReader br = new BufferedReader(new FileReader(file));
			        
		            Object[] tableLines = br.lines().toArray();

		            for(int i = 0; i < tableLines.length; i++)
		            {
		                String line = tableLines[i].toString().trim();
		                String[] dataRow = line.split("/");
		                tenantsModel.addRow(dataRow);
		            }
		            br.close();
		            
		            
		            
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
			}
		});
		
		if (visibility == true) {
			try {
	        	
				tenantsModel = (DefaultTableModel)tenantsTable.getModel();
				
				BufferedReader br = new BufferedReader(new FileReader(file));
		        
	            Object[] tenantsTableLines = br.lines().toArray();

	            for(int i = 0; i < tenantsTableLines.length; i++)
	            {
	                String line = tenantsTableLines[i].toString().trim();
	                String[] dataRow = line.split("/");
	                tenantsModel.addRow(dataRow);
	            }
	            br.close();
	            
	            
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		TeanantsAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TeanantsAddBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		TeanantsAddBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TeanantsAddBtn.setForeground(Color.WHITE);
		TeanantsAddBtn.setBackground(new Color(33, 150, 243));
		TeanantsAddBtn.setBounds(633, 591, 144, 35);
		tenantsPanel.add(TeanantsAddBtn);
		
		JButton TenantsUpdateBtn = new JButton("Update");
		TenantsUpdateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenantsUpdateBtn.setForeground(Color.WHITE);
		TenantsUpdateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TenantsUpdateBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		TenantsUpdateBtn.setBackground(new Color(33, 150, 243));
		TenantsUpdateBtn.setBounds(787, 591, 144, 35);
		tenantsPanel.add(TenantsUpdateBtn);

		TenantsUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateFrame jfuf = new UpdateFrame();
				jfuf.setVisible(true);
				dispose();
			}
		});
		
		JButton TenantsDeleteBtn = new JButton("Delete");
		TenantsDeleteBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		TenantsDeleteBtn.setForeground(Color.WHITE);
		TenantsDeleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TenantsDeleteBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		TenantsDeleteBtn.setBackground(new Color(33, 150, 243));
		TenantsDeleteBtn.setBounds(941, 591, 144, 35);
		tenantsPanel.add(TenantsDeleteBtn);
		
		String filePath1 = "\"C:\\Users\\isaia\\OneDrive\\Desktop\\TenantsData.txt\"";
		File file1 = new File(filePath1);
		TenantsDeleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = findRowIndexByFilePath(tenantsModel, file1);
				if(i >= 0) {
					tenantsModel.removeRow(i);


				
				}
			}
		});
		
		JButton TenantsBackBtn = new JButton("Back");
		TenantsBackBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TenantsBackBtn.setForeground(Color.WHITE);
		TenantsBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenantsBackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		TenantsBackBtn.setBackground(new Color(33, 150, 243));
		TenantsBackBtn.setBounds(110, 591, 144, 35);
		tenantsPanel.add(TenantsBackBtn);
		
		JPanel visitorsPanel = new JPanel();
		visitorsPanel.setBounds(0, 104, 1194, 659);
		contentPane.add(visitorsPanel);
		visitorsPanel.setVisible(false);
		visitorsPanel.setLayout(null);
		
		JScrollPane visitorsScrollPane = new JScrollPane();
	    visitorsScrollPane.setBounds(110, 25, 975, 551);
	    visitorsPanel.add(visitorsScrollPane);		
		
		
	    visitorsTable = new JTable();
		visitorsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Temperature", "Date", "Time in", "Time out"
			}
		));
		visitorsScrollPane.setViewportView(visitorsTable);
		
		JButton BackBtn = new JButton("Back");
		BackBtn.setForeground(Color.WHITE);
		BackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BackBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		BackBtn.setBackground(new Color(33, 150, 243));
		BackBtn.setBounds(110, 586, 134, 36);
		visitorsPanel.add(BackBtn);
		
		JButton UpdateBtn = new JButton("Update");
		UpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		UpdateBtn.setForeground(Color.WHITE);
		UpdateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UpdateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UpdateBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		UpdateBtn.setBackground(new Color(33, 150, 243));
		UpdateBtn.setBounds(951, 586, 134, 36);
		visitorsPanel.add(UpdateBtn);
		
		
		JButton VisitorsDatabaseBtn = new JButton("");
		VisitorsDatabaseBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VisitorsDatabaseBtn.setContentAreaFilled(false);
		VisitorsDatabaseBtn.setBorder(null);
		VisitorsDatabaseBtn.setBounds(603, 0, 600, 105);
		contentPane.add(VisitorsDatabaseBtn);
		VisitorsDatabaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				visitorsPanel.setVisible(true);
				tenantsPanel.setVisible(false);
				
				try {
		        	
					visitorsModel = (DefaultTableModel)visitorsTable.getModel();
					String filePath = "C:\\Users\\isaia\\OneDrive\\Desktop\\VisitorsData.txt";
					File file = new File(filePath);
					
					BufferedReader br = new BufferedReader(new FileReader(file));
			        
		            Object[] visitorsTableLines = br.lines().toArray();

		            for(int i = 0; i <  visitorsTableLines .length; i++)
		            {
		                String line =  visitorsTableLines [i].toString().trim();
		                String[] dataRow = line.split("/");
		                visitorsModel.addRow(dataRow);
		            }
		            br.close();
		            
		            
		            
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		
		JButton TenantsDatabaseBtn = new JButton("");
		TenantsDatabaseBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TenantsDatabaseBtn.setBorder(null);
		TenantsDatabaseBtn.setBounds(0, 0, 600, 105);
		TenantsDatabaseBtn.setContentAreaFilled(false);
		contentPane.add(TenantsDatabaseBtn);
		TenantsDatabaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tenantsPanel.setVisible(true);
				visitorsPanel.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\isaia\\Downloads\\MicrosoftTeams-image (26).png"));
		lblNewLabel.setBounds(0, 0, 1258, 812);
		contentPane.add(lblNewLabel);
	}

	protected int findRowIndexByFilePath(DefaultTableModel tenantsModel2, File file1) {
		// TODO Auto-generated method stub
		return 0;
	}


	}


