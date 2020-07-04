package supplement_shop_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class supplement_shop_login_class {
	
	public  static boolean is_valid(String company_name, String password) {
		Connection con= null;
		get_connection getconnection = new get_connection();
		boolean status=false;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			Statement stmt=con.createStatement();
			String query = "SELECT * FROM `user` WHERE Place_name= '" +company_name+"' AND Pass = '"+password+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			status = rs.next();
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		return status;
	}
	
	public static String get_id (String company_name, String password ) {
		String company_id=null;
		Connection con= null;
		get_connection getconnection = new get_connection();
		boolean status=false;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			Statement stmt=con.createStatement();
			String query = "SELECT * FROM `user` WHERE Place_name= '" +company_name+"' AND Pass = '"+password+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			 rs.next();
			company_id= rs.getString(1);
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
	

		
		return company_id;
	}
	public static String get_log_url (String company_name,String password) {
		String company_logo=null;
		Connection con= null;
		get_connection getconnection = new get_connection();
		boolean status=false;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			Statement stmt=con.createStatement();
			String query = "SELECT * FROM `user` WHERE Place_name= '" + company_name+"' AND Pass = '"+password+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			 rs.next();
			company_logo = rs.getString(17);
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
	

		
		return company_logo;
	}
}
