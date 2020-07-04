package Physio_Models;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Physio_Beans.User;

public class PhysioDAO {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/giantro";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    private static Connection jdbcConnection;

    protected static void connect() throws SQLException {
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

    public boolean insertPhysio(User user) throws SQLException {
        String sql = "INSERT INTO user (NIC, Name,Email,Certificate_ID,Address,Exp,Place_Name,Contact_No,Status,PF,Pass) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        statement.setString(10, user.getPF());
        statement.setString(11, user.getPass());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user (NIC, Name,Email,Certificate_ID,Address,Exp,Place_Name,Contact_No,Status,CF,Pass) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        statement.setString(10, user.getCF());
        statement.setString(11, user.getPass());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public boolean insertCustomer(User user) throws SQLException {
        String sql = "INSERT INTO user (NIC, Name,Email,Contact_No,Status,CF,Pass) VALUES (?,?,?,?,?,?,?)";
        connect();
        System.out.println("Connection Successful");

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, user.getNIC());
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getContact_No());
        statement.setString(5, user.getStatus());
        statement.setString(6, user.getCF());
        statement.setString(7, user.getPass());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();

        String sql = "SELECT * FROM user WHERE PF='1' AND Status='1'";

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
            String status = resultSet.getString("Status");

            User user = new User(NIC, name, email, certificate_ID, address, exp, place_name, contact_no, status);
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
        String sql = "UPDATE user SET Name = ?, Email = ?, Certificate_ID = ?, Address = ?, Exp=?, Place_Name = ?, Contact_No = ?";
        sql += " WHERE NIC = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getCertificate_ID());
        statement.setString(4, user.getAddress());
        statement.setString(5, user.getExp());
        statement.setString(6, user.getPlace_Name());
        statement.setString(7, user.getContact_No());
        // statement.setString(8, user.getPass());
        statement.setString(8, user.getNIC());

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
            String status = resultSet.getString("Status");
            String pf = resultSet.getString("PF");
            String cf = resultSet.getString("CF");
            String gf = resultSet.getString("GF");
            String sf = resultSet.getString("SF");
            String af = resultSet.getString("AF");
            String password = resultSet.getString("Pass");

            user = new User(NIC, name, email, certificate_ID, address, exp, place_name, contact_no, status, pf, cf, gf,
                    af, sf, password);

        }

        resultSet.close();
        statement.close();

        return user;
    }

    public static boolean login_Physio(String Email, String Password) throws SQLException {
        User user = null;
        boolean status1 = false;
        String sql = "SELECT * FROM user WHERE Email = ? AND Pass=? AND Status='1'";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Password);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            status1 = true;
            String NIC = resultSet.getString("NIC");
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String certificate_ID = resultSet.getString("Certificate_ID");
            String address = resultSet.getString("Address");
            String exp = resultSet.getString("Exp");
            String place_name = resultSet.getString("Place_Name");
            String contact_no = resultSet.getString("Contact_No");
            String status = resultSet.getString("Status");
            String password = resultSet.getString("Pass");

            user = new User(NIC, name, email, certificate_ID, address, exp, place_name, contact_no, status, password);

        }

        resultSet.close();
        statement.close();

        return status1;
    }

    public static boolean validate(User user) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giantro", "root", "");
            // String pass1=setPassword(pass);
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement("select * from user where (Email=? or Place_Name=?) and Pass=? AND Status='1'");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPass());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public User getUserDetail(User userin) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE (Email = ? OR Place_Name=?) AND Pass=? AND Status='1'";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, userin.getEmail());
        statement.setString(2, userin.getEmail());
        statement.setString(3, userin.getPass());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String NIC = resultSet.getString("NIC");
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String certificate_ID = resultSet.getString("Certificate_ID");
            String address = resultSet.getString("Address");
            String exp = resultSet.getString("Exp");
            String place_name = resultSet.getString("Place_Name");
            String contact_no = resultSet.getString("Contact_No");
            String status = resultSet.getString("Status");
            String pf = resultSet.getString("PF");
            String cf = resultSet.getString("CF");
            String gf = resultSet.getString("GF");
            String sf = resultSet.getString("SF");
            String af = resultSet.getString("AF");
            String password = resultSet.getString("Pass");

            user = new User(NIC, name, email, certificate_ID, address, exp, place_name, contact_no, status, pf, cf, gf,
                    sf, af, password);

        }

        resultSet.close();
        statement.close();

        return user;
    }

    public int[] notification(String NIC) throws SQLException {
        int summary[] = new int[5];
        String sql1 = "SELECT Appointment_No FROM Appointment WHERE Physio_NIC=? AND Status='1' AND Date>=CURDATE() ";
        String sql2 = "SELECT Schedule_No FROM Schedules WHERE Physio_NIC=? AND Status='0'";
        String sq3 = "SELECT Appointment_No FROM appointment WHERE Physio_NIC=? AND (Status='1' OR Status='0')  AND Date=CURDATE()";
        connect();
        System.out.println("Connection Successful");
        PreparedStatement statement = jdbcConnection.prepareStatement(sql1);
        statement.setString(1, NIC);
        ResultSet resultSet1 = statement.executeQuery();
        resultSet1.last();
        summary[0] = resultSet1.getRow();

        PreparedStatement statement1 = jdbcConnection.prepareStatement(sql2);
        statement1.setString(1, NIC);
        ResultSet resultSet2 = statement1.executeQuery();
        resultSet2.last();
        summary[1] = resultSet2.getRow();

        PreparedStatement statement2 = jdbcConnection.prepareStatement(sql2);
        statement2.setString(1, NIC);
        ResultSet resultSet3 = statement2.executeQuery();
        resultSet3.last();
        summary[2] = resultSet3.getRow();

        System.out.println(summary[0]);
        System.out.println(summary[1]);
        resultSet1.close();
        resultSet2.close();
        statement.close();

        return summary;

    }

}
