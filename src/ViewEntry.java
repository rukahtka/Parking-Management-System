import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ViewEntry extends JFrame {

	private JPanel contentPane;
	private JTextField feeInfoParkId;
	private JTextField feeInfoVehNumber;
	private JTextField feeInfoDuration;
	private JTextField txtMobileNumber;
	
	static int btnID;
	static String mobNumber;
	static String vehicleNo;
	static String durationDiff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEntry frame = new ViewEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	

	public String getTimeDiff(String strDate) throws ParseException {
		String timeDiff;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String strDate2 = dateFormat.format(date);
		
		Date d1 = dateFormat.parse(strDate);
		Date d2 = dateFormat.parse(strDate2);
		float diff = d2.getTime() - d1.getTime();
		//diff = diff/1000;
		//diff = diff/(60*60);
		double diff2 = diff / (60 * 60 * 1000) % 24;
		timeDiff = ""+diff2;
		System.out.println("D2 date: "+d2.getTime()+" and d1:  "+d1.getTime());
		return timeDiff;
		
	}
	
	public ViewEntry() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 439);
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
		lblDuration.setBounds(38, 251, 131, 32);
		contentPane.add(lblDuration);
		
		feeInfoDuration = new JTextField();
		feeInfoDuration.setEditable(false);
		feeInfoDuration.setColumns(10);
		feeInfoDuration.setBounds(183, 251, 197, 32);

		contentPane.add(feeInfoDuration);
		
		JButton feeInfoDeallocateBtn = new JButton("OK");
		feeInfoDeallocateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		feeInfoDeallocateBtn.setBounds(99, 305, 205, 50);
		contentPane.add(feeInfoDeallocateBtn);
		
		JLabel label3 = new JLabel("Mobile Number");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(38, 189, 131, 32);
		contentPane.add(label3);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setEditable(false);
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(183, 189, 197, 32);
		txtMobileNumber.setText(mobNumber);
		
		try {
			feeInfoDuration.setText(getTimeDiff(durationDiff));
			feeInfoParkId.setText(""+btnID);
			feeInfoVehNumber.setText(vehicleNo);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(txtMobileNumber);
	}

}
