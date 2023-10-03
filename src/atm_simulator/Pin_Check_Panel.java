package atm_simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.swing.*;

public class Pin_Check_Panel extends JFrame implements ActionListener {

	ResultSet rset;
	
	String accountNumber;
	
	String Amount;
	
	String user_Name;
	
	Pin_Check_Panel(String Account, String amt, String userName){
		
		this.accountNumber = Account;
		
		this.user_Name = userName;
		
		btnWithdrawOut = new JButton();
        jLabel2 = new JLabel();
        tfPinIn = new JTextField();
        jLabel1 = new JLabel();
        lblWithdrawAmount = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        

        btnWithdrawOut.setBackground(new java.awt.Color(102, 255, 102));
        btnWithdrawOut.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnWithdrawOut.setText("Withdraw");
        
        btnWithdrawOut.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Enter Pin");

        tfPinIn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfPinIn.setHorizontalAlignment(JTextField.CENTER);
        

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Withdraw Amount :");

        lblWithdrawAmount.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblWithdrawAmount.setText(amt);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWithdrawAmount, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnWithdrawOut, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(tfPinIn, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblWithdrawAmount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tfPinIn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnWithdrawOut, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        pack();
        setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Pin_Check_Panel("", "", "");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnWithdrawOut) {
			
			
			String Amount = lblWithdrawAmount.getText();
			
			String pin = tfPinIn.getText();
			
			if (pin.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Enter the Pin .");
				
			}
			
			else {
				
				BigDecimal withdrawAmount = new BigDecimal(Amount);
				
				String selecteQuery = "SELECT bal FROM users WHERE accNumber = '" + accountNumber + "' AND accPin = '"+ pin + "'";
				
				
	
				SQLConnection sqlop = new SQLConnection();
				
				
				
				try {
					
					rset = sqlop.stamt.executeQuery(selecteQuery);
					
					if (rset.next()) {
						
						String existingbaltext = rset.getString("bal");
						
						BigDecimal existingbal = new BigDecimal(existingbaltext);
						
						
						
						int checkvalue = existingbal.compareTo(withdrawAmount);
						
						if (checkvalue >= 0 ) {
							
							BigDecimal newBalance = existingbal.subtract(withdrawAmount);
							
							String newBalancetext = newBalance.toString();
							
							String updateQuery = "UPDATE users SET bal = '" + newBalancetext +"'  WHERE accNumber = '" + accountNumber + "'";
							
							try {
								
								
								int rowUpdate = sqlop.stamt.executeUpdate(updateQuery);
								
								if (rowUpdate > 0) {
									
									
									
									JOptionPane.showMessageDialog(null, "Withdrawal successful");
									
									setVisible(false);
									
									new UserPanel( user_Name , accountNumber).setVisible(true);;
					             	 
								}
								else {
									
									JOptionPane.showMessageDialog(null, "Transaction Failed");
									
								}
								
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
							
							
						} 
						
						else {
							
							JOptionPane.showMessageDialog(null, "Insufficient Balance ");
							setVisible(false);
							
							new UserPanel( user_Name , accountNumber).setVisible(true);;
			             	 
						}
						
//						
						
					}
	
					else {
						
						JOptionPane.showMessageDialog(null, "Please Enter the Correct Pin ");
						
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					
					e2.printStackTrace();
				}
			}
		
		}
		
		
	}
	
	
	
	private JButton btnWithdrawOut;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lblWithdrawAmount;
    private JTextField tfPinIn;
	

}
