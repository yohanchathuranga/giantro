package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class supplement_shop_get_vedio_topics {
	
	public List<supplement_shop_vedios> gettopics(String company_id){
		List<supplement_shop_vedios> topics = new ArrayList<>();
		
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= getconnection.get_conn();
			String query = "select * from supplement_shop_vedios where user_id=? and delete_or_not= 1";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, company_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				supplement_shop_vedios vedio = new supplement_shop_vedios();
				vedio.setUser_id(company_id);
				vedio.setVedio_id(rs.getString(1));
				vedio.setVedio_url(rs.getString(3));
				vedio.setDescription(rs.getString(4));
				topics.add(vedio);
				
			}
			
			
		}catch(Exception e ) {
			System.out.println(e);
		}
		
		
		
		
		return topics;
		
	}

}
