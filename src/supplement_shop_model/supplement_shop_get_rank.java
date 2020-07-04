package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_get_rank {
	public String getrank(String company_id) {
		String rank=null;
		
		Connection con = null;
		get_connection getconnection = new get_connection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			
			String query = "select * from supplement_shop_rank where company_id=?" ;
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, company_id);
			ResultSet rs= ps.executeQuery();
			rs.next();
			rank = rs.getString(2);
			
		}catch(Exception e) {
			
		}
		
		
		
		return rank;
	}

}
