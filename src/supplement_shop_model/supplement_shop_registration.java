package supplement_shop_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;

public class supplement_shop_registration {
	
	public static boolean register(supplement_shop sh) {
		 
		Connection con= null;
		get_connection getconnection = new get_connection();
		boolean status=true;
		//following comments according to the database table 
		String owner_name =  sh.getOwnername();//4th column
		String password = sh.getPassword();//3rd column
		String company_name =   sh.getCompany_name();//2nd column
		String phonenumber=sh.getPhonenumber();//7th column
		String email =      sh.getEmail();//6th column
		String nic = sh.getNic();//5th column
		
		try {
			//get data base connection		
			Class.forName("com.mysql.jdbc.Driver");
			con= getconnection.get_conn();
			String query = "insert into user(Place_Name,Pass,Name,NIC,Email,Contact_No,SF)"+"values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,company_name);
			ps.setString(2, password); 
			ps.setString(3,owner_name );
			ps.setString(4, nic);
			ps.setString(5, email);
			ps.setString(6,phonenumber);
			ps.setString(7, "1");
			status = ps.execute();

		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
			
	}
	public void set_viewd_count(String company_name, String password) {
		Connection con= null;
		get_connection getconnection = new get_connection();

		try {
			//get data base connection		
			Class.forName("com.mysql.jdbc.Driver");
			con= getconnection.get_conn();
			String query1 ="select id from user where Place_Name =? and Pass=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setString(1, company_name);
			ps1.setString(2, password);
			ResultSet rs = ps1.executeQuery();
			rs.next();
			String query2= "insert into supplement_shop_viewd_count (company_id)"+"values(?)";
			PreparedStatement ps2= con.prepareStatement(query2);
			ps2.setString(1, rs.getString(1));
			ps2.execute();
		
		}catch(Exception e) {
			System.out.println(e);
		}

		
	}
}
