import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FeeInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField feeInfoParkId;
	private JTextField feeInfoVehNumber;
	private JTextField feeInfoDuration;
	private JTextField txtMobNumber;
	private JButton feeInfoDeallocateBtn;
	
	public static String vehNum;
	public static int parkingMode;
	public static int parkId;
	public static String duration;
	public static String mobileNumber;
	private JLabel lblAmount;
	private JTextField feeInfoAmount;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeeInfoUI frame = new FeeInfoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public String getTimeDiff(String strDate) throws ParseException {
		String timeDiff;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String strDate2 = dateFormat.format(date);
		
		Date d1 = dateFormat.parse(strDate);
		Date d2 = dateFormat.parse(strDate2);
		float diff = d2.getTime() - d1.getTime();
		diff = diff/1000;
		diff = diff/(60*60);
		//timeDiff = ""+diff;
		
		System.out.println("D2 date: "+d2.getTime()+" and d1:  "+d1.getTime());
		
		return ""+diff;
		
	}
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FeeInfoUI() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel feeInf = new JLabel("Parking ID");
		feeInf.setHorizontalAlignment(SwingConstants.CENTER);
		feeInf.setBounds(38, 46, 131, 32);
		contentPane.add(feeInf);
		
		feeInfoParkId = new JTextField();
		feeInfoParkId.setEditable(false);
		feeInfoParkId.setBounds(183, 46, 197, 32);
		contentPane.add(feeInfoParkId);
		feeInfoParkId.setColumns(10);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleNumber.setBounds(38, 109, 131, 32);
		contentPane.add(lblVehicleNumber);
		
		feeInfoVehNumber = new JTextField();
		feeInfoVehNumber.setEditable(false);
		feeInfoVehNumber.setColumns(10);
		feeInfoVehNumber.setBounds(183, 114, 197, 32);
		contentPane.add(feeInfoVehNumber);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setBounds(38, 247, 131, 32);
		contentPane.add(lblDuration);
		
		feeInfoDuration = new JTextField();
		feeInfoDuration.setEditable(false);
		feeInfoDuration.setColumns(10);
		feeInfoDuration.setBounds(183, 247, 197, 32);
		contentPane.add(feeInfoDuration);
		
		feeInfoDeallocateBtn = new JButton("De-Allocate");
		feeInfoDeallocateBtn.setBounds(98, 382, 205, 50);
		contentPane.add(feeInfoDeallocateBtn);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setBounds(38, 183, 131, 32);
		contentPane.add(lblMobileNumber);
		
		txtMobNumber = new JTextField();
		txtMobNumber.setEditable(false);
		txtMobNumber.setColumns(10);
		txtMobNumber.setBounds(183, 183, 197, 32);
		contentPane.add(txtMobNumber);
		
		feeInfoParkId.setText(""+parkId);
		feeInfoVehNumber.setText(vehNum);
		txtMobNumber.setText(mobileNumber);
		if(duration != null)
			feeInfoDuration.setText(getTimeDiff(duration));
		
		lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(38, 303, 131, 32);
		contentPane.add(lblAmount);
		
		feeInfoAmount = new JTextField();
		feeInfoAmount.setText((String) null);
		feeInfoAmount.setEditable(false);
		feeInfoAmount.setColumns(10);
		feeInfoAmount.setBounds(183, 308, 197, 32);
		contentPane.add(feeInfoAmount);
		if(duration != null)
		feeInfoAmount.setText(""+(Float.parseFloat(getTimeDiff(duration)) * 30));
		
		
		feeInfoDeallocateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean st = deallocateParkingSpace(parkingMode,parkId);
				if(st) {
					JOptionPane.showMessageDialog(FeeInfoUI.this, "Parking space is free now...");
					if(parkingMode == 0) {
					switch(parkId) {
					case 1:{
						ParkingSpace.fwBtn1.setBackground(Color.GREEN);
						ParkingSpace.fwBtn1.setContentAreaFilled(false);
						ParkingSpace.fwBtn1.setOpaque(true);
						break;
						}
					case 2:{
						ParkingSpace.fwBtn2.setBackground(Color.GREEN);
						ParkingSpace.fwBtn2.setContentAreaFilled(false);
						ParkingSpace.fwBtn2.setOpaque(true);
						break;
						}
					case 3:{
						ParkingSpace.fwBtn3.setBackground(Color.GREEN);
						ParkingSpace.fwBtn3.setContentAreaFilled(false);
						ParkingSpace.fwBtn3.setOpaque(true);
						break;
						}
					case 4:{
						ParkingSpace.fwBtn4.setBackground(Color.GREEN);
						ParkingSpace.fwBtn4.setContentAreaFilled(false);
						ParkingSpace.fwBtn4.setOpaque(true);
						break;
						}
					case 5:{
						ParkingSpace.fwBtn5.setBackground(Color.GREEN);
						ParkingSpace.fwBtn5.setContentAreaFilled(false);
						ParkingSpace.fwBtn5.setOpaque(true);
						break;
						}
					case 6:{
						ParkingSpace.fwBtn6.setBackground(Color.GREEN);
						ParkingSpace.fwBtn6.setContentAreaFilled(false);
						ParkingSpace.fwBtn6.setOpaque(true);
						break;
						}
					case 7:{
						ParkingSpace.fwBtn7.setBackground(Color.GREEN);
						ParkingSpace.fwBtn7.setContentAreaFilled(false);
						ParkingSpace.fwBtn7.setOpaque(true);
						break;
						}
					case 8:{
						ParkingSpace.fwBtn8.setBackground(Color.GREEN);
						ParkingSpace.fwBtn8.setContentAreaFilled(false);
						ParkingSpace.fwBtn8.setOpaque(true);
						break;
						}
					case 9:{
						ParkingSpace.fwBtn9.setBackground(Color.GREEN);
						ParkingSpace.fwBtn9.setContentAreaFilled(false);
						ParkingSpace.fwBtn9.setOpaque(true);
						break;
						}
					case 10:{
						ParkingSpace.fwBtn10.setBackground(Color.GREEN);
						ParkingSpace.fwBtn10.setContentAreaFilled(false);
						ParkingSpace.fwBtn10.setOpaque(true);
						break;
						}
					case 11:{
						ParkingSpace.fwBtn11.setBackground(Color.GREEN);
						ParkingSpace.fwBtn11.setContentAreaFilled(false);
						ParkingSpace.fwBtn11.setOpaque(true);
						break;
						}
					case 12:{
						ParkingSpace.fwBtn12.setBackground(Color.GREEN);
						ParkingSpace.fwBtn12.setContentAreaFilled(false);
						ParkingSpace.fwBtn12.setOpaque(true);
						break;
						}
					
					}
					}
					
					//*************************TW*****************************
					else {
						switch(parkId) {
						case 1:{
							ParkingSpace.twBtn1.setBackground(Color.GREEN);
							ParkingSpace.twBtn1.setContentAreaFilled(false);
							ParkingSpace.twBtn1.setOpaque(true);
							break;
							}
						case 2:{
							ParkingSpace.twBtn2.setBackground(Color.GREEN);
							ParkingSpace.twBtn2.setContentAreaFilled(false);
							ParkingSpace.twBtn2.setOpaque(true);
							break;
							}
						case 3:{
							ParkingSpace.twBtn3.setBackground(Color.GREEN);
							ParkingSpace.twBtn3.setContentAreaFilled(false);
							ParkingSpace.twBtn3.setOpaque(true);
							break;
							}
						case 4:{
							ParkingSpace.twBtn4.setBackground(Color.GREEN);
							ParkingSpace.twBtn4.setContentAreaFilled(false);
							ParkingSpace.twBtn4.setOpaque(true);
							break;
							}
						case 5:{
							ParkingSpace.twBtn5.setBackground(Color.GREEN);
							ParkingSpace.twBtn5.setContentAreaFilled(false);
							ParkingSpace.twBtn5.setOpaque(true);
							break;
							}
						case 6:{
							ParkingSpace.twBtn6.setBackground(Color.GREEN);
							ParkingSpace.twBtn6.setContentAreaFilled(false);
							ParkingSpace.twBtn6.setOpaque(true);
							break;
							}
						case 7:{
							ParkingSpace.twBtn7.setBackground(Color.GREEN);
							ParkingSpace.twBtn7.setContentAreaFilled(false);
							ParkingSpace.twBtn7.setOpaque(true);
							break;
							}
						case 8:{
							ParkingSpace.twBtn8.setBackground(Color.GREEN);
							ParkingSpace.twBtn8.setContentAreaFilled(false);
							ParkingSpace.twBtn8.setOpaque(true);
							break;
							}
						case 9:{
							ParkingSpace.twBtn9.setBackground(Color.GREEN);
							ParkingSpace.twBtn9.setContentAreaFilled(false);
							ParkingSpace.twBtn9.setOpaque(true);
							break;
							}
						case 10:{
							ParkingSpace.twBtn10.setBackground(Color.GREEN);
							ParkingSpace.twBtn10.setContentAreaFilled(false);
							ParkingSpace.twBtn10.setOpaque(true);
							break;
							}
						case 11:{
							ParkingSpace.twBtn11.setBackground(Color.GREEN);
							ParkingSpace.twBtn11.setContentAreaFilled(false);
							ParkingSpace.twBtn11.setOpaque(true);
							break;
							}
						case 12:{
							ParkingSpace.twBtn12.setBackground(Color.GREEN);
							ParkingSpace.twBtn12.setContentAreaFilled(false);
							ParkingSpace.twBtn12.setOpaque(true);
							break;
							}
						
						}
						}
					//*************************TW*****************************
					dispose();
				}
			}
		});
		
		
	}
	
	
	public boolean deallocateParkingSpace(int pMode,int bId) {
		String tbName;
		int rs = 0;
		if(pMode == 0)
			tbName = "parking_button_table";
		else
			tbName = "two_wheeler_parking";
		Connection con;
		try {
			con = (Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/vehicle_management_db","root","");
		
		Statement stmt=(Statement) con.createStatement();  
		 rs=stmt.executeUpdate("update "+tbName+" set vehicle_number = '', mobile_number = '', "
		 		+ "time_parked = '0000-00-00 00:00:00', allocated = 0 where btn_id = "+ bId+" and allocated = 1");
		
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
