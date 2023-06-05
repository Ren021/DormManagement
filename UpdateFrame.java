import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class UpdateFrame extends DormManagement {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private DefaultTableModel tenantsModel;
	protected JTable tenantsTable;
	protected Object firstName;
	protected Object lastName;
	protected Vector<?> row;

	public <tenantsTable> UpdateFrame() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(89, 54, 152, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(89, 122, 152, 44);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(89, 195, 152, 44);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(89, 269, 152, 44);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(89, 345, 152, 44);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(89, 422, 152, 44);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(89, 491, 152, 44);
		contentPane.add(textField_6);
		
		JButton UpdateTenantsBtn = new JButton("Update");
		UpdateTenantsBtn.setBounds(189, 576, 85, 21);
		contentPane.add(UpdateTenantsBtn);
		UpdateTenantsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			    row[0] = tenantsModel.getText
			    		
			    tenantsModel.addRow(row);
				
				int i = tenantsTable.getSelectedRow();
				for(int i = 0; i < tableLines.length; i++)
				{
				tenantsModel.setValueAt(e, i, 0);
				tenantsModel.setValueAt(e, i, 1);
				tenantsModel.setValueAt(e, i, 2);
				tenantsModel.setValueAt(e, i, 3);
				tenantsModel.setValueAt(e, i, 4);
				tenantsModel.setValueAt(e, i, 5);
				tenantsModel.setValueAt(e, i, 6);
				}
				
			}
		});



	}
	}
	
