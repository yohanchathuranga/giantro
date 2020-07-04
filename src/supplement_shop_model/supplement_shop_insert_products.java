package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class supplement_shop_insert_products {
	
	public boolean insert_products(supplement_shop_product product) {
		boolean successfull_insert= true;
		Connection con= null;
		get_connection getconnection = new get_connection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query = "insert into supplement_products (user_id,product_name,price,discount,selling_price,description,article_url,image_url)"+"values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, product.getUser_id());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, Integer.toString(product.getPrice()));
			ps.setString(4, Integer.toString(product.getDiscount()));
			ps.setString(5, Double.toString(product.getSelling_price()));
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getArticle_url());
			ps.setString(8, product.getImage_url());
			
			 successfull_insert =ps.execute();
			
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		return successfull_insert;
	}

}
