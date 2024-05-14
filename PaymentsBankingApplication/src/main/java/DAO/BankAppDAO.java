package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BankAppClasses.bankinfo;
import BankAppClasses.userinfo;

public class BankAppDAO {

	public boolean insertuser(userinfo user) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
			Statement stmt = con.createStatement();
			String query = "insert into users(FirstName,LastName,PhoneNo,DateOfBirth,Address,PassWord,email) values('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getPhno()+"','"+user.getDOB()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
			stmt.execute(query);
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	
public boolean validuser(String uname, String upass) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
			Statement stmt = con.createStatement();
			String query = "select * from users  where PhoneNo='"+uname+"' and PassWord='"+upass+"' ";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		return false;
	}


public boolean userexistswithphono(String phno) {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "select * from users  where PhoneNo='"+phno+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()) {
			return true;
		}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return false;
	}
	
	return false;
}



public userinfo userbyphono(String phno) {
	userinfo user = new userinfo();
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "select * from users  where PhoneNo='"+phno+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()) {
			
			
			String fname = rs.getString("FirstName");
			String lname = rs.getString("LastName");
			String Phone = rs.getString("PhoneNo");
		    int userId = rs.getInt("UserId");
		    double currwallbal = rs.getDouble("CurrWalletBal");
		    
		    user.setFirstname(lname);
		    user.setLastname(fname);
		    user.setPhno(Long.parseLong(Phone));
		    user.setUserId(userId);
		    user.setCurrWallBalance(currwallbal);
		    
			
			
		}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
	
	return user;
}

public List<bankinfo> Bankbyuserid(int userId) {
	List<bankinfo> banklist = new ArrayList<bankinfo>();
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "select * from bankaccounts  where UserId='"+userId+"' ";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			bankinfo bi = new bankinfo();
			
			String accno = rs.getString("BankAcctNo");
			String bankname = rs.getString("BankName");
			int accid = rs.getInt("AcctTypeId");
			String ifsc = rs.getString("BankIFSCCode");
			int userid = rs.getInt("UserId");
			double currbal = rs.getDouble("CurrBankAcctBalance");
			
			bi.setBankAccnum(accno);
			bi.setBankName(bankname);
			bi.setAcctypeId(accid);
			bi.setBankIFSCcode(ifsc);
			bi.setUserId(userid);
			bi.setCurrAccBal(currbal);
			banklist.add(bi);
			
		    
			
			
		}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
	
	return banklist;
}




public bankinfo Bankdetailsbyuserid(int userId) {
	bankinfo bib = new bankinfo();
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "select * from bankaccounts  where UserId='"+userId+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()) {
			
			String accno = rs.getString("BankAcctNo");
			String bankname = rs.getString("BankName");
			int accid = rs.getInt("AcctTypeId");
			String ifsc = rs.getString("BankIFSCCode");
			int userid = rs.getInt("UserId");
			double currbal = rs.getDouble("CurrBankAcctBalance");
			
			bib.setBankAccnum(accno);
			bib.setBankName(bankname);
			bib.setAcctypeId(accid);
			bib.setBankIFSCcode(ifsc);
			bib.setUserId(userid);
			bib.setCurrAccBal(currbal);
			
			
		    
			
			
		}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
	
	return bib;
}

public boolean insertBankdetails(bankinfo bankd) {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "insert into BankAccounts(BankAcctNo,BankName,AcctTypeId,BankIFSCCode,BankAcctPin,UserId,CurrBankAcctBalance) values('"+bankd.getBankAccnum()+"','"+bankd.getBankName()+"','"+bankd.getAcctypeId()+"','"+bankd.getBankIFSCcode()+"','"+bankd.getPin()+"','"+bankd.getUserId()+"','"+bankd.getCurrAccBal()+"')";
		stmt.execute(query);
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return false;
	}
	
	return false;
}

public boolean validphno(String phno) {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Sivasai@2001");
		Statement stmt = con.createStatement();
		String query = "select * from users  where PhoneNo='"+phno+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()) {
			return true;
		}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return false;
	}
	
	return false;
}



}
