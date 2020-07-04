package disModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import disBeans.disAddQuestionBean;

public class disModel {
	Connection conn;
	PreparedStatement pst;
	String sql;
	
	String jdbcURL="jdbc:mysql://localhost:3306/giantro";
    String jdbcUsername="root";
    String jdbcPassword="";
     

     
    protected void connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
	
	public ResultSet disMainTable() throws ClassNotFoundException {
		sql="SELECT Question_No,Topic,Body,Category,(SELECT COUNT(*) FROM reply WHERE question.Question_No=reply.Question_No) AS Replies,Views FROM question WHERE Status = '1' ORDER BY Date DESC";
		
		try {
			connect();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int addQuestion(disAddQuestionBean disBean) throws ClassNotFoundException {
		sql = "INSERT INTO question(NIC,Topic,Body,Category) VALUES(?,?,?,?)";
		int result = 0;
		
		try {
			connect();
			pst=conn.prepareStatement(sql);
			pst.setString(1, disBean.getNic());
			pst.setString(2, disBean.getTopic());
			pst.setString(4, disBean.getCategory());
			pst.setString(3, disBean.getQuestion());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet question(String qID) throws ClassNotFoundException {
		String sql = "SELECT Question_No,Name,Topic,Body,Category,Date FROM question INNER JOIN user ON question.NIC=user.NIC WHERE Question_No=?";
		try {
			connect();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(qID));
			ResultSet rs = pst.executeQuery();
			
			if(rs!=null) {
				sql="UPDATE question SET Views=Views+1 WHERE Question_No=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(qID));
				pst.execute();
			} 
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet replyCollect(String qID) throws ClassNotFoundException {
		String sql = "SELECT Body FROM reply WHERE Question_No=? ORDER BY Date";
		try {
			connect();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(qID));
			ResultSet rs = pst.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int addReply(String qno, String reply) throws ClassNotFoundException {
		sql = "INSERT INTO reply(Question_No,Body) VALUES(?,?)";
		int result = 0;
		
		try {
			connect();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(qno));
			pst.setString(2, reply);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
