package atm_simulator;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
/**
 * AdminPanel
 */
public class AdminPanel extends JFrame implements ActionListener  {

    long randomNum;

    AdminPanel(){

        Random random = new Random();

        randomNum = Math.abs((random.nextLong() % 10000000000L) + 1000L);



        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        tfAdname = new JTextField();
        tfAdAcnum = new JTextField(""+randomNum);
        tfAdpin = new JTextField();
        btnAddUser = new JButton();
        btnReset = new JButton();
        jLabel5 = new JLabel();
        tfMobileUser = new JTextField();
        jLabel6 = new JLabel();
        tfBalance = new JTextField();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle("Admin Panel");
        setPreferredSize(new java.awt.Dimension(600, 500));
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Gilroy-Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Admin Panel");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Enter User Name : ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Enter User Account Number : ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Enter User Pin : ");

        

        btnAddUser.setBackground(new java.awt.Color(0, 255, 255));
        btnAddUser.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(this);

        btnReset.setBackground(new java.awt.Color(0, 255, 255));
        btnReset.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(this);


        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Enter User Mobile No. : ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Enter User Balance. : ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfAdname)
                        .addComponent(tfAdAcnum, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfAdpin, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMobileUser, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBalance, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnReset)
                        .addGap(120, 120, 120))))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddUser, btnReset});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAdname, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tfAdAcnum)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAdpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMobileUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {tfMobileUser, tfAdAcnum, tfAdname, tfAdpin});

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {btnAddUser, btnReset});

        pack();
        setLocationRelativeTo(null);



    }
    

    


    public static void main(String[] args) {
        
        new AdminPanel();

    }

    private JButton btnAddUser;
    private JButton btnReset;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField tfMobileUser;
    private JTextField tfBalance;
    private JTextField tfAdAcnum;
    private JTextField tfAdname;
    private JTextField tfAdpin;
    
    
    
    public void ClearScreen() {
    	
    	tfAdAcnum.setText("");
        tfAdname.setText("");
        tfAdpin.setText("");
        tfMobileUser.setText("");
        tfBalance.setText("");
		
	}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource() == btnAddUser){

            String AccNum = "" + randomNum;

            String name = tfAdname.getText();

            String pin = tfAdpin.getText();

            String mobileNum = tfMobileUser.getText();

            String balance = tfBalance.getText();


            try {
                
                if(name.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the Name");

                }
                if(AccNum.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the AccNum");

                }
                if(pin.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the pin");

                }
                if(mobileNum.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the mobileNum");

                }
                if(balance.equals("")){

                    JOptionPane.showMessageDialog (this, "Please enter the balance");

                }

                else {

                    SQLConnection sqlop = new SQLConnection();

                    String query = "INSERT INTO users(user_name, accNumber, accPin,  u_mobileNum , bal ) values('"+ name +"' , '"+ AccNum +"' , '"+ pin +"' , '"+ mobileNum +"' , '"+ balance +"' )";
		
                    int rowUpdate = sqlop.stamt.executeUpdate(query);
                    
					
					if (rowUpdate > 0) {
						
						ClearScreen();

	                    JOptionPane.showMessageDialog (this, "User Add Successfully");
	                    setVisible(false);
	                    
	                    new AdminPanel().setVisible(true);

						
						
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Server Error...");
						
					}

                }

            } catch (Exception ex) {
                
            	// TODO: handle exception

            	
                System.out.println(ex);
            }
            
        }

        else if(e.getSource() == btnReset){

            tfAdAcnum.setText("" + randomNum);
            tfAdname.setText("");
            tfAdpin.setText("");
            tfMobileUser.setText("");
            tfBalance.setText("");
            
            
            
        }


    }
}