package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class supplement_shop_delete_product {
	
		public boolean delete_product(String user_id, String product_id) {
			boolean successfull_delete= true;
			Connection con = null;
			get_connection getconnection = new get_connection();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = getconnection.get_conn();
				
				String query ="UPDATE supplement_products SET delete_or_not=? where user_id= ? AND product_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, 0);
				ps.setString(2, user_id);
				ps.setString(3,product_id);
				successfull_delete= ps.execute();
				

				
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return successfull_delete;
		}

}
