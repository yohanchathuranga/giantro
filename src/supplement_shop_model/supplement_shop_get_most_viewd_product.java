package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_get_most_viewd_product {
	public supplement_shop_product getproduct(String company_id) {
		supplement_shop_product product = new supplement_shop_product();
		
		Connection con = null;
		get_connection getconnection = new get_connection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query = "select * from supplement_products where user_id =? ORDER BY viewd_count DESC ";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, company_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			product.setImage_url(rs.getString(9));
			product.setProduct_name(rs.getString(3));
			product.setViewd_count(rs.getString(11));
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return product;
	}

}
