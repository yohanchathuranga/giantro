package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class supplement_shop_update_product_details_model {
		public boolean update_prdouct(supplement_shop_product product) {
			boolean status = true;
			get_connection getconnection = new get_connection();
			Connection con = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = getconnection.get_conn();
				String qurey= "update supplement_products set product_name=? ,price=? , discount=? ,selling_price=? ,description = ?  where product_id =?";
				PreparedStatement ps = con.prepareStatement(qurey);
				ps.setString(1, product.getProduct_name());
				ps.setInt(2, product.getPrice());
				ps.setInt(3, product.getDiscount());
				ps.setFloat(4,(float) product.getSelling_price());
				ps.setString(5, product.getDescription());
				
				ps.setString(6, product.getProduct_id());
				
				status = ps.execute();
				
			}catch(Exception e) {
				System.out.println("exception occur in supplement_shop_update_product_details_model"+e);
			}
			
			
			return status;
		}
}
