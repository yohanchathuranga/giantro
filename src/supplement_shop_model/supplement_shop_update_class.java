package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class supplement_shop_update_class {
	public boolean update (supplement_shop shop) {
		Connection con = null;
		boolean status = true;
		get_connection getconnection = new get_connection();
		String company_name= shop.getCompany_name();
		String owner_name= shop.getOwnername();
		String nic = shop.getNic();
		String phonenumber= shop.getPhonenumber();
		String password = shop.getPassword();
		String email = shop.getEmail();
		String company_id= shop.getCompany_id();
		System.out.println(company_id);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con  = getconnection.get_conn();
			String query = "UPDATE user SET Place_Name = ?, Pass = ?, Name = ?, Nic = ? , Contact_No= ? WHERE id = ?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,company_name);
			ps.setString(2, password);
			ps.setString(3,owner_name );
			ps.setString(4, nic);
			ps.setString(5,phonenumber);
			ps.setString(6,company_id);
			status= ps.execute();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
		
}
