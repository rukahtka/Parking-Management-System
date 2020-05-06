import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ParkingSpace extends JFrame {

	private JPanel contentPane;
	public static int idFromCreateEntryToParkingSpace;
	public static JButton fwBtn1,fwBtn2,fwBtn3,fwBtn4,fwBtn5,fwBtn6,fwBtn7,fwBtn8,fwBtn9,fwBtn10,fwBtn11,fwBtn12;
	public static JButton twBtn1,twBtn2,twBtn3,twBtn4,twBtn5,twBtn6,twBtn7,twBtn8,twBtn9,twBtn10,twBtn11,twBtn12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingSpace frame = new ParkingSpace();
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
	public ParkingSpace() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 840);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 129, 380, 637);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		fwBtn1 = new JButton("FW Parking 1");
		fwBtn1.setForeground(new Color(0, 0, 0));
		fwBtn1.setBackground(Color.WHITE);
		fwBtn1.setBounds(12, 13, 132, 47);
		
		//fwBtn1.setBackground(Color.GREEN);
        // these next two lines do the magic..
		//fwBtn1.setContentAreaFilled(false);
		//fwBtn1.setOpaque(true);
		
		fwBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		fwBtn1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(fwBtn1);
		
		fwBtn3 = new JButton("FW Parking 3");
		fwBtn3.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn3.setBounds(12, 96, 132, 47);
		panel.add(fwBtn3);
		
		 fwBtn5 = new JButton("FW Parking 5");
		fwBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fwBtn5.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn5.setBounds(12, 178, 132, 47);
		panel.add(fwBtn5);
		
		 fwBtn7 = new JButton("FW Parking 7");
		fwBtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fwBtn7.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn7.setBounds(12, 261, 132, 47);
		panel.add(fwBtn7);
		
		 fwBtn9 = new JButton("FW Parking 9");
		fwBtn9.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn9.setBounds(12, 346, 132, 47);
		panel.add(fwBtn9);
		
		 fwBtn11 = new JButton("FW Parking 11");
		fwBtn11.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn11.setBounds(12, 435, 132, 47);
		panel.add(fwBtn11);
		
		 fwBtn2 = new JButton("FW Parking 2");
		fwBtn2.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn2.setBounds(236, 13, 132, 47);
		panel.add(fwBtn2);
		
		 fwBtn4 = new JButton("FW Parking 4");
		fwBtn4.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn4.setBounds(236, 96, 132, 47);
		panel.add(fwBtn4);
		
		 fwBtn6 = new JButton("FW Parking 6");
		fwBtn6.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn6.setBounds(236, 178, 132, 47);
		panel.add(fwBtn6);
		
		 fwBtn8 = new JButton("FW Parking 8");
		fwBtn8.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn8.setBounds(236, 261, 132, 47);
		panel.add(fwBtn8);
		
		 fwBtn10 = new JButton("FW Parking 10");
		fwBtn10.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn10.setBounds(236, 346, 132, 47);
		panel.add(fwBtn10);
		
		 fwBtn12 = new JButton("FW Parking 12");
		fwBtn12.setHorizontalAlignment(SwingConstants.LEFT);
		fwBtn12.setBounds(236, 435, 132, 47);
		panel.add(fwBtn12);
		
		JButton fwAllocateBtn = new JButton("Allocate");
		fwAllocateBtn.setForeground(Color.BLACK);
		fwAllocateBtn.setBackground(Color.BLUE);
		fwAllocateBtn.setContentAreaFilled(false);
		fwAllocateBtn.setOpaque(true);
		
		fwAllocateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fwAllocateBtn.setBackground(Color.WHITE);
		fwAllocateBtn.setBounds(22, 507, 332, 51);
		panel.add(fwAllocateBtn);
		
		JButton fwDeallocateBtn = new JButton("De-Allocate");
		fwDeallocateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fwDeallocateBtn.setBounds(22, 571, 332, 51);
		panel.add(fwDeallocateBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(418, 129, 297, 637);
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 twBtn1 = new JButton("TW Park 1");
		twBtn1.setBounds(12, 13, 111, 44);
		panel_1.add(twBtn1);
		
		 twBtn2 = new JButton("TW Park 2");
		twBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		twBtn2.setBounds(174, 13, 111, 44);
		panel_1.add(twBtn2);
		
		 twBtn3 = new JButton("TW Park 3");
		twBtn3.setBounds(12, 99, 111, 44);
		panel_1.add(twBtn3);
		
		 twBtn4 = new JButton("TW Park 4");
		twBtn4.setBounds(174, 99, 111, 44);
		panel_1.add(twBtn4);
		
		 twBtn5 = new JButton("TW Park 5");
		twBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		twBtn5.setBounds(12, 178, 111, 44);
		panel_1.add(twBtn5);
		
		 twBtn6 = new JButton("TW Park 6");
		twBtn6.setBounds(174, 178, 111, 44);
		panel_1.add(twBtn6);
		
		 twBtn7 = new JButton("TW Park 7");
		twBtn7.setBounds(12, 261, 111, 44);
		panel_1.add(twBtn7);
		
		 twBtn8 = new JButton("TW Park 8");
		twBtn8.setBounds(174, 261, 111, 44);
		panel_1.add(twBtn8);
		
		 twBtn9 = new JButton("TW Park 9");
		twBtn9.setBounds(12, 346, 111, 44);
		panel_1.add(twBtn9);
		
		 twBtn10 = new JButton("TW Park 10");
		twBtn10.setBounds(174, 346, 111, 44);
		panel_1.add(twBtn10);
		
		 twBtn11 = new JButton("TW Park 11");
		twBtn11.setBounds(12, 435, 111, 44);
		panel_1.add(twBtn11);
		
		 twBtn12 = new JButton("TW Park 12");
		twBtn12.setBounds(174, 435, 111, 44);
		panel_1.add(twBtn12);
		
		JButton twAllocateBtn = new JButton("Allocate");
		twAllocateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		twAllocateBtn.setBounds(26, 507, 243, 50);
		panel_1.add(twAllocateBtn);
		
		JButton twDeallocateBtn = new JButton("De-Allocate");
		twDeallocateBtn.setBounds(26, 570, 243, 50);
		panel_1.add(twDeallocateBtn);
		
		JButton btnLogoutBtn = new JButton("LOGOUT");
		btnLogoutBtn.setBounds(586, 13, 129, 42);
		btnLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnLogoutBtn);
		
		JLabel lblNewLabel = new JLabel("Four Wheeler Parking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 68, 380, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Two Wheeler Parking");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(418, 68, 297, 48);
		contentPane.add(lblNewLabel_1);
		
		btnLogoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ParkingSpace.this.dispose();
			}
		});
		
		
		
		//Buissness Logic ****************************************************

		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/vehicle_management_db","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=(Statement) con.createStatement();  
			ResultSet rs=stmt.executeQuery("select allocated from parking_button_table");
			
			Statement stmt2=(Statement) con.createStatement();  
			ResultSet rs2=stmt2.executeQuery("select allocated from two_wheeler_parking");
			int i=1;
			while(rs.next())  {
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			if(rs.getInt(1) == 0) {
				switch (i) {
					case 1:{
						fwBtn1.setBackground(Color.GREEN);
						fwBtn1.setContentAreaFilled(false);
						fwBtn1.setOpaque(true);
						break;
					}
					case 2:{
						fwBtn2.setBackground(Color.GREEN);
						fwBtn2.setContentAreaFilled(false);
						fwBtn2.setOpaque(true);
						break;
					}
					case 3:{
						fwBtn3.setBackground(Color.GREEN);
						fwBtn3.setContentAreaFilled(false);
						fwBtn3.setOpaque(true);
						break;
					}
					case 4:{
						fwBtn4.setBackground(Color.GREEN);
						fwBtn4.setContentAreaFilled(false);
						fwBtn4.setOpaque(true);
						break;
					}
					case 5:{
						fwBtn5.setBackground(Color.GREEN);
						fwBtn5.setContentAreaFilled(false);
						fwBtn5.setOpaque(true);
						break;
					}
					case 6:{
						fwBtn6.setBackground(Color.GREEN);
						fwBtn6.setContentAreaFilled(false);
						fwBtn6.setOpaque(true);
						break;
					}
					case 7:{
						fwBtn7.setBackground(Color.GREEN);
						fwBtn7.setContentAreaFilled(false);
						fwBtn7.setOpaque(true);
						break;
					}
					case 8:{
						fwBtn8.setBackground(Color.GREEN);
						fwBtn8.setContentAreaFilled(false);
						fwBtn8.setOpaque(true);
						break;
					}
					case 9:{
						fwBtn9.setBackground(Color.GREEN);
						fwBtn9.setContentAreaFilled(false);
						fwBtn9.setOpaque(true);
						break;
					}
					case 10:{
						fwBtn10.setBackground(Color.GREEN);
						fwBtn10.setContentAreaFilled(false);
						fwBtn10.setOpaque(true);
						break;
					}
					case 11:{
						fwBtn11.setBackground(Color.GREEN);
						fwBtn11.setContentAreaFilled(false);
						fwBtn11.setOpaque(true);
						break;
					}
					case 12:{
						fwBtn12.setBackground(Color.GREEN);
						fwBtn12.setContentAreaFilled(false);
						fwBtn12.setOpaque(true);
						break;
					}	
				}
			}
			
			else {
				
					switch (i) {
						case 1:{
							fwBtn1.setBackground(Color.RED);
							fwBtn1.setContentAreaFilled(false);
							fwBtn1.setOpaque(true);
							break;
						}
						case 2:{
							fwBtn2.setBackground(Color.RED);
							fwBtn2.setContentAreaFilled(false);
							fwBtn2.setOpaque(true);
							break;
						}
						case 3:{
							fwBtn3.setBackground(Color.RED);
							fwBtn3.setContentAreaFilled(false);
							fwBtn3.setOpaque(true);
							break;
						}
						case 4:{
							fwBtn4.setBackground(Color.RED);
							fwBtn4.setContentAreaFilled(false);
							fwBtn4.setOpaque(true);
							break;
						}
						case 5:{
							fwBtn5.setBackground(Color.RED);
							fwBtn5.setContentAreaFilled(false);
							fwBtn5.setOpaque(true);
							break;
						}
						case 6:{
							fwBtn6.setBackground(Color.RED);
							fwBtn6.setContentAreaFilled(false);
							fwBtn6.setOpaque(true);
							break;
						}
						case 7:{
							fwBtn7.setBackground(Color.RED);
							fwBtn7.setContentAreaFilled(false);
							fwBtn7.setOpaque(true);
							break;
						}
						case 8:{
							fwBtn8.setBackground(Color.RED);
							fwBtn8.setContentAreaFilled(false);
							fwBtn8.setOpaque(true);
							break;
						}
						case 9:{
							fwBtn9.setBackground(Color.RED);
							fwBtn9.setContentAreaFilled(false);
							fwBtn9.setOpaque(true);
							break;
						}
						case 10:{
							fwBtn10.setBackground(Color.RED);
							fwBtn10.setContentAreaFilled(false);
							fwBtn10.setOpaque(true);
							break;
						}
						case 11:{
							fwBtn11.setBackground(Color.RED);
							fwBtn11.setContentAreaFilled(false);
							fwBtn11.setOpaque(true);
							break;
						}
						case 12:{
							fwBtn12.setBackground(Color.RED);
							fwBtn12.setContentAreaFilled(false);
							fwBtn12.setOpaque(true);
							break;
						}	
					
				
			}
			
			}
			i++;
			}
			
			
			int j=1;
			
			
			while(rs2.next())  {
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				if(rs2.getInt(1) == 0) {
					switch (j) {
						case 1:{
							twBtn1.setBackground(Color.GREEN);
							twBtn1.setContentAreaFilled(false);
							twBtn1.setOpaque(true);
							break;
						}
						case 2:{
							twBtn2.setBackground(Color.GREEN);
							twBtn2.setContentAreaFilled(false);
							twBtn2.setOpaque(true);
							break;
						}
						case 3:{
							twBtn3.setBackground(Color.GREEN);
							twBtn3.setContentAreaFilled(false);
							twBtn3.setOpaque(true);
							break;
						}
						case 4:{
							twBtn4.setBackground(Color.GREEN);
							twBtn4.setContentAreaFilled(false);
							twBtn4.setOpaque(true);
							break;
						}
						case 5:{
							twBtn5.setBackground(Color.GREEN);
							twBtn5.setContentAreaFilled(false);
							twBtn5.setOpaque(true);
							break;
						}
						case 6:{
							twBtn6.setBackground(Color.GREEN);
							twBtn6.setContentAreaFilled(false);
							twBtn6.setOpaque(true);
							break;
						}
						case 7:{
							twBtn7.setBackground(Color.GREEN);
							twBtn7.setContentAreaFilled(false);
							twBtn7.setOpaque(true);
							break;
						}
						case 8:{
							twBtn8.setBackground(Color.GREEN);
							twBtn8.setContentAreaFilled(false);
							twBtn8.setOpaque(true);
							break;
						}
						case 9:{
							twBtn9.setBackground(Color.GREEN);
							twBtn9.setContentAreaFilled(false);
							twBtn9.setOpaque(true);
							break;
						}
						case 10:{
							twBtn10.setBackground(Color.GREEN);
							twBtn10.setContentAreaFilled(false);
							twBtn10.setOpaque(true);
							break;
						}
						case 11:{
							twBtn11.setBackground(Color.GREEN);
							twBtn11.setContentAreaFilled(false);
							twBtn11.setOpaque(true);
							break;
						}
						case 12:{
							twBtn12.setBackground(Color.GREEN);
							twBtn12.setContentAreaFilled(false);
							twBtn12.setOpaque(true);
							break;
						}	
					}
				}
				
				else {
					
						switch (j) {
							case 1:{
								twBtn1.setBackground(Color.RED);
								twBtn1.setContentAreaFilled(false);
								twBtn1.setOpaque(true);
								break;
							}
							case 2:{
								twBtn2.setBackground(Color.RED);
								twBtn2.setContentAreaFilled(false);
								twBtn2.setOpaque(true);
								break;
							}
							case 3:{
								twBtn3.setBackground(Color.RED);
								twBtn3.setContentAreaFilled(false);
								twBtn3.setOpaque(true);
								break;
							}
							case 4:{
								twBtn4.setBackground(Color.RED);
								twBtn4.setContentAreaFilled(false);
								twBtn4.setOpaque(true);
								break;
							}
							case 5:{
								twBtn5.setBackground(Color.RED);
								twBtn5.setContentAreaFilled(false);
								twBtn5.setOpaque(true);
								break;
							}
							case 6:{
								twBtn6.setBackground(Color.RED);
								twBtn6.setContentAreaFilled(false);
								twBtn6.setOpaque(true);
								break;
							}
							case 7:{
								twBtn7.setBackground(Color.RED);
								twBtn7.setContentAreaFilled(false);
								twBtn7.setOpaque(true);
								break;
							}
							case 8:{
								twBtn8.setBackground(Color.RED);
								twBtn8.setContentAreaFilled(false);
								twBtn8.setOpaque(true);
								break;
							}
							case 9:{
								twBtn9.setBackground(Color.RED);
								twBtn9.setContentAreaFilled(false);
								twBtn9.setOpaque(true);
								break;
							}
							case 10:{
								twBtn10.setBackground(Color.RED);
								twBtn10.setContentAreaFilled(false);
								twBtn10.setOpaque(true);
								break;
							}
							case 11:{
								twBtn11.setBackground(Color.RED);
								twBtn11.setContentAreaFilled(false);
								twBtn11.setOpaque(true);
								break;
							}
							case 12:{
								twBtn12.setBackground(Color.RED);
								twBtn12.setContentAreaFilled(false);
								twBtn12.setOpaque(true);
								break;
							}
				}
				
				}
				j++;
				}
			
		/*	
			fwBtn1
			fwBtn2
			fwBtn3
			fwBtn4
			fwBtn5
			fwBtn6
			fwBtn7
			fwBtn8
			fwBtn9
			fwBtn10
			fwBtn11
			fwBtn12
			
			twBtn1
			twBtn2
			twBtn3
			twBtn4
			twBtn5
			twBtn6
			twBtn7
			twBtn8
			twBtn9
			twBtn10
			twBtn11
			twBtn12
			
			*/
			
			fwBtn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(fwBtn1.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
								
						 try {
							 String[] arr = getEntry(1, 0).split(",");
							 getViewEntryUI(1, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			});
			fwBtn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn2.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(2, 0).split(",");
							 getViewEntryUI(2, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn3.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(3, 0).split(",");
							 getViewEntryUI(3, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn4.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(4, 0).split(",");
							 getViewEntryUI(4, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn5.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(5, 0).split(",");
							 getViewEntryUI(5, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn6.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(6, 0).split(",");
							 getViewEntryUI(6, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn7.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(7, 0).split(",");
							 getViewEntryUI(7, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn8.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(8, 0).split(",");
							 getViewEntryUI(8, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn9.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(9, 0).split(",");
							 getViewEntryUI(9, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn10.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(10, 0).split(",");
							 getViewEntryUI(10, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn11.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(11, 0).split(",");
							 getViewEntryUI(11, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			fwBtn12.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fwBtn12.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(12, 0).split(",");
							 getViewEntryUI(12, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			
			
			
			
			
			twBtn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn1.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(1, 1).split(",");
							 getViewEntryUI(1, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn2.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(2, 1).split(",");
							 getViewEntryUI(2, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn3.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(3, 1).split(",");
							 getViewEntryUI(3, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn4.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(4, 1).split(",");
							 getViewEntryUI(4, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn5.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(5, 1).split(",");
							 getViewEntryUI(5, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn6.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn6.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(6, 1).split(",");
							 getViewEntryUI(6, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn7.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(7, 1).split(",");
							 getViewEntryUI(7, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn8.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(8, 1).split(",");
							 getViewEntryUI(8, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn9.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(9, 1).split(",");
							 getViewEntryUI(9, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn10.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(10, 1).split(",");
							 getViewEntryUI(10, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn11.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(11, 1).split(",");
							 getViewEntryUI(11, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			twBtn12.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(twBtn12.getBackground() == Color.GREEN) {
						JOptionPane.showMessageDialog(ParkingSpace.this,"Parking space is not allocated yet...");
					}
					else {
						 try {
							 String[] arr = getEntry(12, 1).split(",");
							 getViewEntryUI(12, arr[1], arr[0], arr[2]);
							 
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
			
			
			//********************Allocate and De-allocate Button
			
						
			fwAllocateBtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								CreateEntryUI.parkMode=0;
								new CreateEntryUI().setVisible(true);
								//SwingUtilities.updateComponentTreeUI(ParkingSpace.this);
								//ParkingSpace.this.getContentPane().removeAll();
								//ParkingSpace.this.setContentPane(contentPane);
								//ParkingSpace.this.invalidate();
								//ParkingSpace.this.validate();
								//ParkingSpace.this.repaint();
							}
						});
			fwDeallocateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					 boolean st = callFeeInfoUI(0);
					
					
				}
			});
			twAllocateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					CreateEntryUI.parkMode=1;
					new CreateEntryUI().setVisible(true);
					
					
				}
			});
			twDeallocateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					boolean st = callFeeInfoUI(1);
				}
			});

//*******************Logout Button********************
			btnLogoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
					
			
			
			
			con.close();  
			}catch(Exception e)
		{ System.out.println(e);
		}
		
	
		
		
	}
	

	public static String getEntry(int btnID, int type) throws SQLException {
		String veh_no = "";
		if(type == 0) {
			Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/vehicle_management_db","root",""); 
			Statement stmt=(Statement) con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from parking_button_table where btn_id = "+btnID);
			while(rs.next()) {
				veh_no = rs.getString(2)+","+rs.getString(3)+","+rs.getString(4);
				System.out.println(veh_no);
			}
		}
		
		if(type == 1) {
			Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/vehicle_management_db","root",""); 
			Statement stmt=(Statement) con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from two_wheeler_parking where btn_id = "+btnID);
			while(rs.next()) {
				veh_no = rs.getString(2)+","+rs.getString(3)+","+rs.getString(4);
				System.out.println(veh_no);
			}
		}
		
		return veh_no;
		
	}
	
	
	
	public void getViewEntryUI(int btnID,String mobNumber,String vehNo, String duration) {
		ViewEntry.btnID	= btnID;
		ViewEntry.mobNumber = mobNumber;
		ViewEntry.durationDiff = duration;
		ViewEntry.vehicleNo = vehNo;
		new ViewEntry().setVisible(true);
	}
	
	
	
	public boolean callFeeInfoUI(int mode) {
		boolean stt = false;
		int pID = Integer.parseInt(JOptionPane.showInputDialog(ParkingSpace.this, "Enter Parking Number"));
		Connection con;
		String tbname = "";
		if(pID > 0) {
			if(mode ==0)
				tbname = "parking_button_table";
			else
				tbname = "two_wheeler_parking";
			try {
				con = (Connection) DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/vehicle_management_db","root","");
				Statement stmt=(Statement) con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from "+ tbname +" where btn_id = "+pID);
				int st = 0;
				String vehNo="";
				String mobNo="";
				String dur = "";
				while(rs.next()) {
					vehNo = rs.getString(2);
					mobNo = rs.getString(3);
					dur = rs.getString(4);
					st = rs.getInt(5);
				}
				if(st == 1) {
					FeeInfoUI.duration = dur;
					FeeInfoUI.mobileNumber = mobNo;
					FeeInfoUI.parkId = pID;
					FeeInfoUI.vehNum = vehNo;
					FeeInfoUI.parkingMode = mode;
					stt = true;
					new FeeInfoUI().setVisible(true);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(ParkingSpace.this, "Enter Valid Parking Number");
		return stt;
	}

	public void  disposeParkingSpace() {
		dispose();
	}
	
	
}
