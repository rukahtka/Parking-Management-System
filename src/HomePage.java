import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField adminUsername;
	private JTextField adminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 13, 195, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 88, 110, 28);
		contentPane.add(lblNewLabel_1);
		
		adminUsername = new JTextField();
		adminUsername.setBounds(151, 88, 201, 28);
		contentPane.add(adminUsername);
		adminUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblPassword.setBounds(12, 151, 110, 28);
		contentPane.add(lblPassword);
		
		adminPassword = new JTextField();
		adminPassword.setColumns(10);
		adminPassword.setBounds(151, 151, 201, 28);
		contentPane.add(adminPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnLogin.setBounds(90, 200, 195, 40);
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean status = verifyAdmin(adminUsername.getText(),adminPassword.getText());
				if(status)
					new ParkingSpace().setVisible(true);
				else
					JOptionPane.showMessageDialog(HomePage.this, "Login Failed...");
			}
		});
		
		
		
	}
	
	public boolean verifyAdmin(String username, String password) {
		if(username.equals("admin") && password.equals("admin123"))
			return true;
		else
			return false;
	}
}
