package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import User.User;

public class PhysioDAO {

	private String jdbcURL="jdbc:mysql://localhost:3306/giantrodb";
    private String jdbcUsername="root";
    private String jdbcPassword="";
    private Connection jdbcConnection;
     
//    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
//        this.jdbcURL = jdbcURL;
//        this.jdbcUsername = jdbcUsername;
//        this.jdbcPassword = jdbcPassword;
//    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user (NIC, Name,Email,Certificate_ID,Address,Exp,Place_Name,Contact_No,Status) VALUES (?,?,?,?,?,?,?,?,?)";
        connect();
        System.out.println("Connection Successful");
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, user.getNIC());
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getCertificate_ID());
        statement.setString(5, user.getAddress());
        statement.setString(6, user.getExp());
        statement.setString(7, user.getPlace_Name());
        statement.setString(8, user.getContact_No());
        statement.setString(9, user.getStatus());
       ;
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();
         
        String sql = "SELECT * FROM user WHERE PF='1'";
         
        connect();
        System.out.println("Connection Successful");
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String NIC = resultSet.getString("NIC");
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String certificate_ID = resultSet.getString("Certificate_ID");
            String address = resultSet.getString("Address");
            String exp = resultSet.getString("Exp");
            String place_name = resultSet.getString("Place_Name");
            String contact_no = resultSet.getString("Contact_No");
            String status =resultSet.getString("Status");
             
            User user = new User(NIC,name,email,certificate_ID,address,exp,place_name,contact_no,status);
            listUser.add(user);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUser;
    }
     
    public boolean deleteUser(User User) throws SQLException {
        String sql = "DELETE FROM user where NIC = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, User.getNIC());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET Name = ?, Email = ?, Certificate_ID = ?, Address = ?, Exp=?, Place_Name = ?, Contact_No = ?, Status = ?";
        sql += " WHERE User_No = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getCertificate_ID());
        statement.setString(4, user.getAddress());
        statement.setString(5, user.getExp());
        statement.setString(6, user.getPlace_Name());
        statement.setString(7, user.getContact_No());
        statement.setString(8, user.getStatus());
        statement.setString(9, user.getNIC());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public User getUser(String NIC) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE NIC = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, NIC);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String certificate_ID = resultSet.getString("Certificate_ID");
            String address = resultSet.getString("Address");
            String exp = resultSet.getString("Exp");
            String place_name = resultSet.getString("Place_Name");
            String contact_no = resultSet.getString("Contact_No");
            String status =resultSet.getString("Status");
             
            user = new User(NIC,name,email,certificate_ID,address,exp,place_name,contact_no,status);
           
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }

}
