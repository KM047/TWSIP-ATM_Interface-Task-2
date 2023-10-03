package atm_simulator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.*;

import java.util.*;


public class SQLOperations {
	
	Connection con;
	
	SQLOperations() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/atm", "root", "root");
				
//		String query = "insert into student values(? ,?, ?, ?, ?, ?)";
		String query = "SELECT * FROM users WHERE accNumber= ";
        
		
    }
	
public ResultSet check(String accNum, String pin) throws SQLException{
		
		String query = "SELECT * FROM users WHERE accNumber = '"+ accNum + "' AND pin = '"+ Integer.parseInt(pin)+"'";
		
		Statement stm = con.prepareStatement(query);
		
		ResultSet restat = stm.executeQuery(query);
		
		return restat;
	}
    
	public void Op_Deposit(int amt, String accNum) throws SQLException {
		
		String query = "UPDATE users SET bal = bal + "+ amt +" WHERE accNumber= " + accNum;
		
		Statement stm = con.prepareStatement(query);
		stm.executeUpdate(query);
		
	}
	
	public int Op_Withdraw(int amt, String accNum) throws SQLException {
		
		int bal = Op_CheckBal(Integer.parseInt(accNum));
		
		if (bal >= amt ) {
			
			String query = "UPDATE users SET bal = bal  - "+ amt +" WHERE accNumber= " + accNum + "";
			
			Statement stm = con.prepareStatement(query);
			stm.executeUpdate(query);

			return 1;
		} 
		
		return 0;
		
	}
	
	public int Op_CheckBal(int accNum) throws SQLException {
		
		String query = "SELECT bal FROM users WHERE accNum =  "+ accNum;
		
		Statement stm = con.prepareStatement(query);
		ResultSet rstat = stm.executeQuery(query);
		
		rstat.next();
		return rstat.getInt("bal");
		
		
	}
	
	public void Op_PinChange(int pin, String accNum) throws SQLException {
		
		String query = "UPDATE users SET accPin = "+ pin +" WHERE accNumber= " + accNum;
		
		Statement stm = con.prepareStatement(query);
		stm.executeUpdate(query);
		
		
	}

	public void Op_AddUser(String name,  String accNum , int pin, String mobileNum , String bal) throws SQLException {
		
		String query = "INSERT INTO users(user_name, accNumber, accPin,  u_mobileNum , bal ) values("+name+","+accNum+","+pin+","+mobileNum+","+bal+")";
		
		Statement stm = con.prepareStatement(query);
		stm.executeUpdate(query);
		
	}
	
	public ResultSet statemt(int accNum) throws SQLException{
		
		String query = "SELECT * FROM transactions WHERE accNumber = "+ accNum + "order by transid desc";
		
		Statement stm = con.prepareStatement(query);
		
		ResultSet restat = stm.executeQuery(query);
		
		return restat;
	}
	
	public boolean Op_PinCheck(int pin, String accNum) throws SQLException {
		
		String query = "SELECT accPin FROM users WHERE accNumber= " + accNum;
		
		Statement stm = con.prepareStatement(query);
		int pinc = stm.executeUpdate(query);
		
		if (pin == pinc) {
			
			return true;
			
		}
		
		return false;
		
		
	}
	
}
