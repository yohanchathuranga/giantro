package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_get_vedio_model {
	
	public supplement_shop_vedios getvedio(String vedio_id) {
		supplement_shop_vedios vedio = new supplement_shop_vedios();
		
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= getconnection.get_conn();
			String query = "select * from supplement_shop_vedios where vedio_id=? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, vedio_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vedio.setVedio_id(rs.getString(1));
			vedio.setVedio_url(rs.getString(3));
			vedio.setDescription(rs.getString(4));
	
		}catch(Exception e ) {
			System.out.println(e);
		}
		
		
		
		
		return vedio;
	}

}
