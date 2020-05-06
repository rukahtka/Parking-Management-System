import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateEntryUI extends JFrame {

	private JPanel contentPane;
	private JTextField createEntryTxtVehicleNumber;
	private JTextField createEntryMobileNumber;
	private JComboBox btnIdComboBox;
	public static int parkMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					CreateEntryUI frame = new CreateEntryUI();
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
	public CreateEntryUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 154, 116, 35);
		contentPane.add(lblNewLabel);
		
		createEntryTxtVehicleNumber = new JTextField();
		createEntryTxtVehicleNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createEntryTxtVehicleNumber.setBounds(179, 154, 230, 35);
		contentPane.add(createEntryTxtVehicleNumber);
		createEntryTxtVehicleNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(51, 216, 116, 35);
		contentPane.add(lblNewLabel_1);
		
		createEntryMobileNumber = new JTextField();
		createEntryMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createEntryMobileNumber.setColumns(10);
		createEntryMobileNumber.setBounds(179, 216, 230, 35);
		contentPane.add(createEntryMobileNumber);
		
		JButton btnCreateEntry = new JButton("Create Entry");
		btnCreateEntry.setBounds(114, 290, 230, 42);
		contentPane.add(btnCreateEntry);
		
		JLabel lblParkingNumber = new JLabel("Parking Number");
		lblParkingNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblParkingNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParkingNumber.setBounds(51, 88, 116, 35);
		contentPane.add(lblParkingNumber);
		
		 btnIdComboBox = new JComboBox();
		btnIdComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		btnIdComboBox.setBounds(179, 88, 230, 35);
		contentPane.add(btnIdComboBox);
		
		
		
		btnCreateEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String str = createEntryTxtVehicleNumber.getText();
				if((str.charAt(2) != ' ') || str.charAt(5) != ' ') {
					
					
				}
				String str2 = createEntryMobileNumber.getText();
				if((str2.length() != 10) ) {
					
				}
					
				
				
				
				boolean status = addParkingEntry(parkMode,Integer.parseInt((String) btnIdComboBox.getSelectedItem()),
						createEntryTxtVehicleNumber.getText(),createEntryMobileNumber.getText(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				if(status) {
					JOptionPane.showMessageDialog(CreateEntryUI.this,"Entry Created Successfully !!!");
					//****************************************************************
					
					if(parkMode == 0) {
						switch(Integer.parseInt((String)btnIdComboBox.getSelectedItem())) {
						case 1:{
							ParkingSpace.fwBtn1.setBackground(Color.RED);
							ParkingSpace.fwBtn1.setContentAreaFilled(false);
							ParkingSpace.fwBtn1.setOpaque(true);
							break;
							}
						case 2:{
							ParkingSpace.fwBtn2.setBackground(Color.RED);
							ParkingSpace.fwBtn2.setContentAreaFilled(false);
							ParkingSpace.fwBtn2.setOpaque(true);
							break;
							}
						case 3:{
							ParkingSpace.fwBtn3.setBackground(Color.RED);
							ParkingSpace.fwBtn3.setContentAreaFilled(false);
							ParkingSpace.fwBtn3.setOpaque(true);
							break;
							}
						case 4:{
							ParkingSpace.fwBtn4.setBackground(Color.RED);
							ParkingSpace.fwBtn4.setContentAreaFilled(false);
							ParkingSpace.fwBtn4.setOpaque(true);
							break;
							}
						case 5:{
							ParkingSpace.fwBtn5.setBackground(Color.RED);
							ParkingSpace.fwBtn5.setContentAreaFilled(false);
							ParkingSpace.fwBtn5.setOpaque(true);
							break;
							}
						case 6:{
							ParkingSpace.fwBtn6.setBackground(Color.RED);
							ParkingSpace.fwBtn6.setContentAreaFilled(false);
							ParkingSpace.fwBtn6.setOpaque(true);
							break;
							}
						case 7:{
							ParkingSpace.fwBtn7.setBackground(Color.RED);
							ParkingSpace.fwBtn7.setContentAreaFilled(false);
							ParkingSpace.fwBtn7.setOpaque(true);
							break;
							}
						case 8:{
							ParkingSpace.fwBtn8.setBackground(Color.RED);
							ParkingSpace.fwBtn8.setContentAreaFilled(false);
							ParkingSpace.fwBtn8.setOpaque(true);
							break;
							}
						case 9:{
							ParkingSpace.fwBtn9.setBackground(Color.RED);
							ParkingSpace.fwBtn9.setContentAreaFilled(false);
							ParkingSpace.fwBtn9.setOpaque(true);
							break;
							}
						case 10:{
							ParkingSpace.fwBtn10.setBackground(Color.RED);
							ParkingSpace.fwBtn10.setContentAreaFilled(false);
							ParkingSpace.fwBtn10.setOpaque(true);
							break;
							}
						case 11:{
							ParkingSpace.fwBtn11.setBackground(Color.RED);
							ParkingSpace.fwBtn11.setContentAreaFilled(false);
							ParkingSpace.fwBtn11.setOpaque(true);
							break;
							}
						case 12:{
							ParkingSpace.fwBtn12.setBackground(Color.RED);
							ParkingSpace.fwBtn12.setContentAreaFilled(false);
							ParkingSpace.fwBtn12.setOpaque(true);
							break;
							}
						
						}
						}
						
						//*************************TW*****************************
						else {
							switch(Integer.parseInt((String)btnIdComboBox.getSelectedItem())) {
							case 1:{
								ParkingSpace.twBtn1.setBackground(Color.RED);
								ParkingSpace.twBtn1.setContentAreaFilled(false);
								ParkingSpace.twBtn1.setOpaque(true);
								break;
								}
							case 2:{
								ParkingSpace.twBtn2.setBackground(Color.RED);
								ParkingSpace.twBtn2.setContentAreaFilled(false);
								ParkingSpace.twBtn2.setOpaque(true);
								break;
								}
							case 3:{
								ParkingSpace.twBtn3.setBackground(Color.RED);
								ParkingSpace.twBtn3.setContentAreaFilled(false);
								ParkingSpace.twBtn3.setOpaque(true);
								break;
								}
							case 4:{
								ParkingSpace.twBtn4.setBackground(Color.RED);
								ParkingSpace.twBtn4.setContentAreaFilled(false);
								ParkingSpace.twBtn4.setOpaque(true);
								break;
								}
							case 5:{
								ParkingSpace.twBtn5.setBackground(Color.RED);
								ParkingSpace.twBtn5.setContentAreaFilled(false);
								ParkingSpace.twBtn5.setOpaque(true);
								break;
								}
							case 6:{
								ParkingSpace.twBtn6.setBackground(Color.RED);
								ParkingSpace.twBtn6.setContentAreaFilled(false);
								ParkingSpace.twBtn6.setOpaque(true);
								break;
								}
							case 7:{
								ParkingSpace.twBtn7.setBackground(Color.RED);
								ParkingSpace.twBtn7.setContentAreaFilled(false);
								ParkingSpace.twBtn7.setOpaque(true);
								break;
								}
							case 8:{
								ParkingSpace.twBtn8.setBackground(Color.RED);
								ParkingSpace.twBtn8.setContentAreaFilled(false);
								ParkingSpace.twBtn8.setOpaque(true);
								break;
								}
							case 9:{
								ParkingSpace.twBtn9.setBackground(Color.RED);
								ParkingSpace.twBtn9.setContentAreaFilled(false);
								ParkingSpace.twBtn9.setOpaque(true);
								break;
								}
							case 10:{
								ParkingSpace.twBtn10.setBackground(Color.RED);
								ParkingSpace.twBtn10.setContentAreaFilled(false);
								ParkingSpace.twBtn10.setOpaque(true);
								break;
								}
							case 11:{
								ParkingSpace.twBtn11.setBackground(Color.RED);
								ParkingSpace.twBtn11.setContentAreaFilled(false);
								ParkingSpace.twBtn11.setOpaque(true);
								break;
								}
							case 12:{
								ParkingSpace.twBtn12.setBackground(Color.RED);
								ParkingSpace.twBtn12.setContentAreaFilled(false);
								ParkingSpace.twBtn12.setOpaque(true);
								break;
								}
							
							}
							}
					
					//****************************************************************
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(CreateEntryUI.this,"Unable to create entry...");
					dispose();
				}
			}});
		
		
	}
	
	
	
	public boolean addParkingEntry(int mode,int bId,String vehNo,String MobNo,String duration) {
		String tbName;
		int rs = 0;
		if(mode == 0)
			tbName = "parking_button_table";
		else
			tbName = "two_wheeler_parking";
		Connection con;
		try {
			con = (Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/vehicle_management_db","root","");
		
		Statement stmt=(Statement) con.createStatement();  
		 rs=stmt.executeUpdate("update "+tbName+" set vehicle_number = '"+vehNo+
				"', mobile_number = '"+ MobNo +"', time_parked = '"
				+duration+"', allocated = 1 where btn_id = "+ bId+" and allocated = 0");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs > 0)
			return true;
		else
			return false;
					
	}
}
