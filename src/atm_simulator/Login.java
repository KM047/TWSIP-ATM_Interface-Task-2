
package atm_simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.security.auth.login.FailedLoginException;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
	ResultSet rSet = null;
	
    Login(){

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnSignIn = new JButton();
        btnClear = new JButton();
        tfSI_AccNum = new JTextField();
        tfSI_Pin = new JPasswordField();


        setSize(600, 500);
        setVisible(true);

        setLocation(300,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setTitle("Login Panel");
        setAlwaysOnTop(true);


        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome To ATM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter Account No.  :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Pin :");

        btnSignIn.setBackground(new java.awt.Color(51, 102, 255));
        btnSignIn.setText("Sign In");

        btnSignIn.addActionListener(this);


        
        

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setText("Clear");

        btnClear.addActionListener(this);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfSI_AccNum, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSI_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSI_AccNum, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSI_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, tfSI_AccNum, tfSI_Pin});

        pack();
        setLocationRelativeTo(null);


    }

    

    public static void main(String[] args) {
        
        new Login();
    }

    private JButton btnClear;
    private JButton btnSignIn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField tfSI_AccNum;
    private JPasswordField tfSI_Pin;
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnSignIn){

            String AccNum = tfSI_AccNum.getText();
            
            
            String AccPin = tfSI_Pin.getText();
            
                
                if(AccNum.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the Account Number");

                }
                if(AccPin.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the Pin");

                }
                
                else{
                    
                    SQLConnection sqlop = new SQLConnection();

                    String query = "SELECT * FROM users WHERE accNumber = '"+AccNum +"' AND accPin = '"+ AccPin +"'";
		

                    try {
                    	
                     rSet	= sqlop.stamt.executeQuery(query);
                     
                     
                     
                     if (rSet.next()) {
						
                    	 String name = rSet.getString("user_name");
                    	 
                         
                    	 setVisible(false);
                    	 
                    	 new UserPanel(name, AccNum).setVisible(true);;
                    	 
                    	 
                     }  
                     
                     else {
						
                    	 JOptionPane.showMessageDialog(this, "Incorrect Account Number or Pin. ");
					}
						
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2);
					}

                }
            
        }

        else if(e.getSource() == btnClear){

            tfSI_AccNum.setText("");
            tfSI_Pin.setText("");
            
            setVisible(false);
            
            int  ch = JOptionPane.showConfirmDialog(null, "Are You Want to Exit ?");
            
            if (ch != 0) {
				
            	setVisible(true);
            	
			}
            
         
        }

    }
   

}
