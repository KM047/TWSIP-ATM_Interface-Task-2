package atm_simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.swing.*;

public class Withdraw_Panel extends JFrame implements ActionListener {

	ResultSet rset;
	
	
	String AccountNumber; 
	
	String user_Name;
	
	Withdraw_Panel( String Account, String user){
		
		this.AccountNumber = Account;
		
		this.user_Name = user;
		
		
		jLabel1 = new JLabel();
        tfWithdrawIn = new JTextField();
        btnWithdrawNext = new JButton();
        jLabel3 = new JLabel();
        btnBack = new JButton();
        jLabel2 = new JLabel();
        lblAccNumber = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Withdraw Panel");
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Enter amount");

        tfWithdrawIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfWithdrawIn.setHorizontalAlignment(JTextField.CENTER);
        

        btnWithdrawNext.setBackground(new java.awt.Color(102, 255, 102));
        btnWithdrawNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnWithdrawNext.setText("Next");
        
        btnWithdrawNext.addActionListener(this);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("₹");

        btnBack.setBackground(new java.awt.Color(51, 255, 255));
        btnBack.setText("Back");
        
        btnBack.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Account Number :");
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);

        lblAccNumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblAccNumber.setText(AccountNumber);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(btnWithdrawNext, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfWithdrawIn, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAccNumber, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAccNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tfWithdrawIn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addComponent(btnWithdrawNext, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Withdraw_Panel("", "");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String amount = tfWithdrawIn.getText();
		
		String account = lblAccNumber.getText();
		
		
		if (e.getSource() == btnWithdrawNext) {
			
			
			if (amount.equals("")) {
				
				
				JOptionPane.showMessageDialog(null, "Enter the amount to withdraw");
			}
			
			setVisible(false);
			
			new Pin_Check_Panel(AccountNumber, amount, user_Name);
			
			
		}
		
		else if (e.getSource() == btnBack) {
			

			
			SQLConnection sqlop = new SQLConnection();

            String query = "SELECT * FROM users WHERE accNumber = '"+ AccountNumber +"' ";


			
			try {
				
				rset = sqlop.stamt.executeQuery(query);
                
              
              if (rset.next()) {
					
             	 String name = rset.getString("user_name");
             	 
             	 
//             	 System.out.println(name);
                  
             	 setVisible(false);
             	 
             	 new UserPanel(name, AccountNumber).setVisible(true);;
             	 
             	 
              }
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		
			
		}
		
		
	}
	
	
	private JButton btnBack;
    private JButton btnWithdrawNext;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel lblAccNumber;
    private JTextField tfWithdrawIn;
	

}
