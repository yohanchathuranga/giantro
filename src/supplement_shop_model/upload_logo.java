package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class upload_logo {
	
	public boolean updatelogo(String user_id, String url) {
		boolean success_or_not= true;
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= getconnection.get_conn();
			String query = "update user set logo =? where id= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, url);
			ps.setString(2, user_id);
			success_or_not= ps.execute();
			
		}catch(Exception e ) {
			System.out.println("Exception in update logo supplement_shop_model "+e);
		}
		
		
		return success_or_not;
	}

}
