package supplement_shop_model;

import java.sql.Connection;
import java.sql.DriverManager;

public class get_connection {
	private String user= "root";
	private String password= "";
	private String url ="jdbc:mysql://localhost:3306/giantro";
	
	public Connection get_conn() {
		Connection con = null;
		try {
			 con=DriverManager.getConnection(url,user,password); 
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
	

}
