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

public class DormManagement extends JFrame {

	private JPanel contentPane;
	 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DormManagement frame = new DormManagement();
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
	public DormManagement() {
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton StatusCheckerBtn = new JButton("");
		StatusCheckerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		StatusCheckerBtn.setBorder(null);
		StatusCheckerBtn.setBounds(684, 512, 476, 78);
		StatusCheckerBtn.setContentAreaFilled(false);
		contentPane.add(StatusCheckerBtn);
		StatusCheckerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StatusChecker Jfsc = new StatusChecker();
				Jfsc.setVisible(true);
				dispose();
			}
		});
		
		JButton ClockInandOutBtn = new JButton("");
		ClockInandOutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ClockInandOutBtn.setBorder(null);
		ClockInandOutBtn.setBounds(684, 285, 476, 78);
		ClockInandOutBtn.setContentAreaFilled(false);
		contentPane.add(ClockInandOutBtn);
		ClockInandOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClockInandOut Jfcio = new ClockInandOut();
				Jfcio.setVisible(true);
				dispose();
			}
		});
		
		JButton VisitorDocBtn = new JButton("");
		VisitorDocBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VisitorDocBtn.setBorder(null);
		VisitorDocBtn.setBounds(684, 399, 469, 78);
		VisitorDocBtn.setContentAreaFilled(false);
		contentPane.add(VisitorDocBtn);
		VisitorDocBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VisitorDocumentation Jfvd = new VisitorDocumentation();
				Jfvd.setVisible(true);
				dispose();
			}
		});
		
		JButton LandlordDashboardBtn = new JButton("");
		LandlordDashboardBtn.setBorder(null);
		LandlordDashboardBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LandlordDashboardBtn.setBounds(687, 172, 476, 78);
		LandlordDashboardBtn.setContentAreaFilled(false);
		contentPane.add(LandlordDashboardBtn);
		LandlordDashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LandLordDatabase Jfll = new LandLordDatabase(true);
				Jfll.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\isaia\\Downloads\\Frame.png"));
		lblNewLabel.setBounds(0, 0, 1186, 763);
		contentPane.add(lblNewLabel);
	}
}
