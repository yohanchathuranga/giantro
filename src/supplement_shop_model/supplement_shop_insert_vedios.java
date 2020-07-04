package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class supplement_shop_insert_vedios {
	
	public boolean instert_vedios(supplement_shop_vedios vedio) {
		boolean success_flag=true;
		Connection con = null;
		get_connection getconnection = new get_connection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query = "insert into supplement_shop_vedios (user_id,vedio_url,vedio_description)"+"values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, vedio.getUser_id());
			ps.setString(2, vedio.getVedio_url());
			ps.setString(3, vedio.getDescription());
			success_flag= ps.execute();
		}catch(Exception e) {
			System.out.println("exception in supplement shop_insert_vedios.java"+e);
		}
		return success_flag;
		
	}

}
