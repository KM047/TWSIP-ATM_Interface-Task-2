package atm_simulator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class PinChange_Panel extends JFrame implements ActionListener {

	ResultSet rset;
	
	String accountNumber;
	
	PinChange_Panel( String accountNum) {
		
		// TODO Auto-generated constructor stub
		
		this.accountNumber = accountNum;

		jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        tfMobileNum = new JTextField();
        jLabel4 = new JLabel();
        tfPin1 = new JTextField();
        tfPin2 = new JTextField();
        jLabel5 = new JLabel();
        btnChangePin = new JButton();
        btnClear = new JButton();
        btnBack = new JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Pin Change");
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Change Pin");

        jLabel2.setText("Enter Your Mobile No. :");

        tfMobileNum.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        

        jLabel4.setText(" New Account Pin :");

        tfPin1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        

        tfPin2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        

        jLabel5.setText("Confirm Account Pin : ");

        btnChangePin.setBackground(new java.awt.Color(51, 255, 51));
        btnChangePin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangePin.setText("Change Pin");
        
        btnChangePin.addActionListener(this);

        btnClear.setBackground(new java.awt.Color(51, 255, 51));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        
        btnClear.addActionListener(this);

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setText("Back");
        
        btnBack.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfPin1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnChangePin, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfPin2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfMobileNum, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMobileNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPin1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPin2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, tfMobileNum});

        pack();
        setLocationRelativeTo(null);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new PinChange_Panel("");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String mobile = tfMobileNum.getText();
		
		String pin1 = tfPin1.getText();

		String pin2 = tfPin2.getText();
		
		
		
		
		if (e.getSource() == btnChangePin) {
			
			if (mobile.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Enter the Mobile Number");
				
			} 
			
			else if (pin1.equals("")) {

				JOptionPane.showMessageDialog(null, "Enter the Pin ");
				
			}
			
			else if (pin2.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Enter the Pin ");
				
			}
			
			if (pin1.equals(pin2)) {
				
				
				SQLConnection sqlop = new SQLConnection();

	            String query = "SELECT * FROM users WHERE u_mobileNum = '"+ mobile +"' ";

	            try {
					
	            	rset = sqlop.stamt.executeQuery(query);
	            	
	            	if (rset.next()) {
						
	            		String updateQuery = "UPDATE users SET accPin = '" + pin1 +"'  WHERE u_mobileNum = '" + mobile + "' ";
						
						try {
							
							
							int rowUpdate = sqlop.stamt.executeUpdate(updateQuery);
							
							if (rowUpdate > 0) {
								
								JOptionPane.showMessageDialog(null, "Pin Change successfully");
								
								setVisible(false);
								
								new Login().setVisible(true);
								
							}
							else {
								
								JOptionPane.showMessageDialog(null, "Server Error...");
								
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
	            		
					} 
	            	
	            	else {

	            		JOptionPane.showMessageDialog(null, "Please Enter the Correct Mobile Number ");
	            		
					}
	            	
				} 
	            
	            catch (Exception e2) {
					// TODO: handle exception
	            	e2.printStackTrace();
				}

				
			} 
			
			else {

				JOptionPane.showMessageDialog(null, "Please Enter the Correct Pin");
				
			}
			
			
		} 
		
		else if(e.getSource() == btnClear) {
			
			tfMobileNum.setText("");
			tfPin1.setText("");
			tfPin2.setText("");
			

		}
		
		else if (e.getSource() == btnBack) {
			

			
			SQLConnection sqlop = new SQLConnection();

            String query = "SELECT * FROM users WHERE accNumber = '"+ accountNumber +"' ";


			
			try {
				
				rset = sqlop.stamt.executeQuery(query);
                
              
              if (rset.next()) {
					
             	 String name = rset.getString("user_name");
             	 
//             	 System.out.println(name);
                  
             	 setVisible(false);
             	 
             	 new UserPanel(name, accountNumber).setVisible(true);;
             	 
             	 
              }
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		}
		
	}

	
	
	private JButton btnBack;
    private JButton btnChangePin;
    private JButton btnClear;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField tfMobileNum;
    private JTextField tfPin1;
    private JTextField tfPin2;
	
}
