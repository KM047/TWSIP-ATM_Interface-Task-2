package atm_simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;

import atm_simulator.SQLConnection;
import javax.swing.*;

import java.util.*;


public class Deposit_Panel extends JFrame implements ActionListener {

	ResultSet rset;
	
	String AccountNumber; 
	
	Deposit_Panel(String Account){
		
		this.AccountNumber = Account;
		
		jLabel1 = new JLabel();
        tfDepositeIn = new JTextField();
        btnDeposit = new JButton();
        jLabel2 = new JLabel();
        lblAccNumber = new JLabel();
        jLabel3 = new JLabel();
        btnBack = new JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Deposit Panel");
        

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Enter ammount");

        tfDepositeIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tfDepositeIn.setHorizontalAlignment(JTextField.CENTER);
        
        

        btnDeposit.setBackground(new java.awt.Color(102, 255, 102));
        btnDeposit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDeposit.setText("Deposit");
        
        btnDeposit.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Account Number :");
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);

        lblAccNumber.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        
        lblAccNumber.setText(Account);
        

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("₹");

        btnBack.setBackground(new java.awt.Color(51, 255, 255));
        btnBack.setText("Back");
        
        btnBack.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 314, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAccNumber, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDepositeIn, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAccNumber, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDepositeIn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addComponent(btnBack))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) {
		
		new Deposit_Panel("");
		
	}
	
	 private JButton btnBack;
	 private JButton btnDeposit;
	 private JLabel jLabel1;
	 private JLabel jLabel2;
	 private JLabel jLabel3;
	 private JLabel lblAccNumber;
	 private JTextField tfDepositeIn;
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		String Account = lblAccNumber.getText();
		
		
		
		
		if (e.getSource() == btnDeposit) {
			
			String Amount = tfDepositeIn.getText();
			
			
			
			if (Amount.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Enter the Deposit Amount.");
				
			}
			
			else {
				
				BigDecimal addamount = new BigDecimal(Amount);
				
				String selecteQuery = "SELECT bal FROM users WHERE accNumber = '" + Account + "' ";
				
				
	
				SQLConnection sqlop = new SQLConnection();
				
				
				
				try {
					
					rset = sqlop.stamt.executeQuery(selecteQuery);
					
					if (rset.next()) {
						
						String existingbaltext = rset.getString("bal");
						
						BigDecimal existingbal = new BigDecimal(existingbaltext);
						
						BigDecimal newBalance = existingbal.add(addamount);
						
						String newBalancetext = newBalance.toString();
						
						String updateQuery = "UPDATE users SET bal = '" + newBalancetext +"'  WHERE accNumber = '" + Account + "' ";
						
						try {
							
							
							int rowUpdate = sqlop.stamt.executeUpdate(updateQuery);
							
							if (rowUpdate > 0) {
								
								JOptionPane.showMessageDialog(null, "Transaction successful");
								
								
								
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
						
						JOptionPane.showMessageDialog(null, "Account Not Found ");
						
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					
					e2.printStackTrace();
				}
			}
		
		}
		
		
		else if (e.getSource() == btnBack) {
			
			SQLConnection sqlop = new SQLConnection();

            String query = "SELECT * FROM users WHERE accNumber = '"+ Account +"' ";


			
			try {
				
				rset = sqlop.stamt.executeQuery(query);
                
              
              if (rset.next()) {
					
             	 String name = rset.getString("user_name");
             	 
//             	 System.out.println(name);
                  
             	 setVisible(false);
             	 
             	 new UserPanel(name, Account).setVisible(true);;
             	 
             	 
              }
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		} 
		
		
	}
	
}
