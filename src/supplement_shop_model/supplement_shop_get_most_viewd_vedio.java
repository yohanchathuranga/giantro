package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_get_most_viewd_vedio {
	public supplement_shop_vedios getvedio(String company_id) {
		supplement_shop_vedios vedio = new supplement_shop_vedios ();
		

		Connection con = null;
		get_connection getconnection = new get_connection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query = "select * from supplement_shop_vedios where user_id =? ORDER BY viewd_count DESC ";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, company_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			vedio.setVedio_id(rs.getString(2));
			vedio.setDescription(rs.getString(4));
			vedio.setViewd_count(rs.getString(6));;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return vedio;
	}
}
