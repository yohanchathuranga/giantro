package supplement_shop_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class supplement_shop_get_viewd_count {
	
	public supplement_shop_viewd_count getcount(String company_id) {
		supplement_shop_viewd_count count = new supplement_shop_viewd_count();
		get_connection getconnection = new get_connection();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getconnection.get_conn();
			String query = "select * from supplement_shop_viewd_count where company_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, company_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			count.setJan(rs.getString(2));
			count.setFeb(rs.getString(3));
			count.setMarch(rs.getString(4));
			count.setAprail(rs.getString(5));
			count.setMay(rs.getString(6));
			count.setJune(rs.getString(7));
			count.setJuly(rs.getString(8));
			count.setAggust(rs.getString(9));
			count.setSeptember(rs.getString(10));
			count.setOctober(rs.getString(11));
			count.setNovember(rs.getString(12));
			count.setDecember(rs.getString(13));
			count.set_prec();
			
		}catch(Exception e) {
			
			
		}
		
		return count;
	}

}
