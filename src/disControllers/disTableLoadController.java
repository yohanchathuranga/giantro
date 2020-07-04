package disControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import disModels.disModel;

public class disTableLoadController {
	public String disMainLoad() {
		disModel model = new disModel();
		ResultSet rs = null;
		try {
			rs = model.disMainTable();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String table = "";
		try {
			while(rs.next()) {
				table += "<tr>";
				table += "<td align='left'><a href='disQuestion?qID="+rs.getString(1) + "'><strong><big>" + rs.getString(2) + "</strong></big></a></td>";
				table += "<td>" + rs.getString(4) + "</td>";
				table += "<td>" + rs.getString(5) + "</td>";
				table += "<td>" + rs.getString(6) + "</td>";
				table += "</tr>";
			}
			return table;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}

}
