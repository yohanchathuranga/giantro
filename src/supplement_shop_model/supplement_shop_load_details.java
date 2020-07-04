package supplement_shop_model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

public class supplement_shop_load_details {

  public supplement_shop getdetails(String username) {
	  supplement_shop shop = new supplement_shop();
	  get_connection getconnection= new get_connection();
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  
	
		  Connection con = getconnection.get_conn();
		  Statement stmt=con.createStatement();
		  String query = "select * from user where place_name ='"+username+"'";
		  ResultSet rs = stmt.executeQuery(query);
			rs.next();
			shop.setCompany_id(rs.getString(1)); 
			shop.setCompany_name(rs.getString(8));
			shop.setOwnername(rs.getString(3)); 
			shop.setPassword(rs.getString(16)); 
			shop.setNic(rs.getString(2));
			shop.setEmail(rs.getString(4));
			shop.setPhonenumber(rs.getString(9));
		  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  return shop;
  }
}
