package supplement_shop_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_load_product_details_model {
	
	 public  supplement_shop_product details(String user_id) {
		supplement_shop_product product = new supplement_shop_product();
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query ="Select * from supplement_products where product_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,user_id);
			ps.execute();
			
			ResultSet result = ps.executeQuery();
			result.next();
			product.setProduct_id(result.getString(1));
			//System.out.println(product.getProduct_id());
			product.setProduct_name(result.getString(3));
			//System.out.println(product.getProduct_name());
			product.setPrice(Integer.parseInt(result.getString(4)));
			//System.out.println(product.getPrice());
			product.setDiscount(Integer.parseInt(result.getString(5)));
			//System.out.println(product.getDiscount());
			product.set_selling_price();
			//System.out.println(product.getSelling_price());
			product.setDescription(result.getString(7));
			
			System.out.println("hi"+product.getDescription());
			product.setArticle_url(result.getString(8));
			//System.out.println(product.getArticle_url());
			product.setImage_url(result.getString(9));
			//System.out.println(product.getImage_url());
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		return product;
		
	}

}







