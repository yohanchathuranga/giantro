package supplement_shop_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class supplement_shop_get_product_list {
	
	public static List<supplement_shop_product> getproductlist(String company_id) {
		List<supplement_shop_product> products=new ArrayList<supplement_shop_product>();
		
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			
			String query = "select * from supplement_products where user_id ='"+company_id+"' and delete_or_not='1'";
			Statement stmt = con.createStatement();
			ResultSet result= stmt.executeQuery(query);
			
			//result.next();
			while(result.next()) {
				supplement_shop_product product= new supplement_shop_product();
				product.setProduct_id(result.getString(1));
				product.setUser_id(result.getString(2));
				product.setProduct_name(result.getString(3));
				product.setPrice(Integer.parseInt(result.getString(4)));
				product.setImage_url(result.getString(9));
				product.setDiscount(Integer.parseInt(result.getString(5)));
				product.set_selling_price();
				 
				products.add(product);
			
				
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	
	
		return products;
	}
}
