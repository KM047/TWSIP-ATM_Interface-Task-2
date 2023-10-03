package atm_simulator;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UserPanel extends JFrame implements ActionListener{

	String AccountNumber;
	
	String UserName;
	
	ResultSet rSet;
	
    UserPanel(String username , String AccountNumber)  {

    	this.AccountNumber = AccountNumber;
    	
    	this.UserName = username;
        
    	jLabel1 = new JLabel();
        btnWithdraw = new JButton();
        btnCheckBal = new JButton();
        btnPinChange = new JButton();
        jLabel2 = new JLabel();
        lbluserName = new JLabel();
        btnDeposit = new JButton();
        btnExit = new JButton();

        
        lbluserName.setText(username);
        
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("User Panel");
        setVisible(true);

        jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Welcome To ATM");

        btnWithdraw.setBackground(new Color(0, 0, 0));
        btnWithdraw.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
        btnWithdraw.setForeground(new Color(255, 255, 255));
        btnWithdraw.setText("WITHDRAW");
        
        btnWithdraw.addActionListener(this);
       

        btnCheckBal.setBackground(new Color(0, 0, 0));
        btnCheckBal.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
        btnCheckBal.setForeground(new Color(255, 255, 255));
        btnCheckBal.setText("CHECK BALANCE");
        
        btnCheckBal.addActionListener(this);
       

        btnPinChange.setBackground(new Color(0, 0, 0));
        btnPinChange.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
        btnPinChange.setForeground(new Color(255, 255, 255));
        btnPinChange.setText("PIN CHANGE");
        
        btnPinChange.addActionListener(this);
        

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Account Holder name :");
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);

        btnDeposit.setBackground(new Color(0, 0, 0));
        btnDeposit.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
        btnDeposit.setForeground(new Color(255, 255, 255));
        btnDeposit.setText("DEPOSIT");
        
        btnDeposit.addActionListener(this);

        btnExit.setBackground(new Color(0, 0, 0));
        btnExit.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setText("EXIT");
        
        btnExit.addActionListener(this);
       

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbluserName, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCheckBal)
                                .addGap(78, 78, 78)
                                .addComponent(btnPinChange))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnWithdraw)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnExit)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnCheckBal, btnDeposit, btnPinChange, btnWithdraw});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbluserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWithdraw, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckBal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPinChange, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {btnCheckBal, btnDeposit, btnPinChange, btnWithdraw});

        pack();
        setLocationRelativeTo(null);
        

    }

    
    
    
    
    public static void main(String[] args) {
        
        new UserPanel("" , "");
        

    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	
    	if (e.getSource() == btnWithdraw) {
			
    		
    		setVisible(false);
    		
    		new Withdraw_Panel(AccountNumber, UserName).setVisible(true);
    		
    		
    		
    		
		}
    	
    	else if (e.getSource() == btnDeposit) {
			
    		setVisible(false);
    		
    		new Deposit_Panel(AccountNumber).setVisible(true);
    		
    		
    		
    		
		}
    	
    	else if (e.getSource() == btnCheckBal) {
    		
    		
    		SQLConnection sqlop = new SQLConnection();
    		
    		String query = "SELECT bal FROM users WHERE accNumber = '" + AccountNumber + "' " ;
    		
    		try {
    			
    			rSet = sqlop.stamt.executeQuery(query);
    			
    			if (rSet.next()) {
					
    				String balance = rSet.getString("bal");
    				
    				JOptionPane.showMessageDialog(null, "Your Balance is Rs. " + balance);
    				
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		
    		
    	}
    	
    	else if (e.getSource() == btnPinChange) {
    		
    		setVisible(false);
    		
    		new PinChange_Panel(AccountNumber);
    		
    		
    	}
    	
    	else if (e.getSource() == btnExit) {
    		
    		setVisible(false);
    		
    		new Login().setVisible(true);
    		
    	}
		
	}
    
    
    
    private JButton btnCheckBal;
    private JButton btnDeposit;
    private JButton btnExit;
    private JButton btnPinChange;
    private JButton btnWithdraw;
    private JLabel jLabel1;
    private JLabel jLabel2;
    JLabel lbluserName;
	
}
