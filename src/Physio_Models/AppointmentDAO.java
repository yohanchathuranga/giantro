package Physio_Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Physio_Beans.Appointment;

public class AppointmentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/giantro";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection jdbcConnection;

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

    public boolean insertAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointment (Physio_NIC, Customer_NIC,Date,Time,Status) VALUES (?,?,?,?,?)";
        connect();
        System.out.println("Connection Successful");

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        // statement.setInt(1,appointment.getAppointment_No());
        statement.setString(1, appointment.getPhysio_NIC());
        statement.setString(2, appointment.getCustomer_NIC());
        statement.setString(3, appointment.getDate());
        statement.setString(4, appointment.getTime());
        statement.setString(5, appointment.getStatus());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;

    }

    public List<Appointment> listAllAppointments(String NIC) throws SQLException {
        List<Appointment> listAppointment = new ArrayList<>();

        String sql = "SELECT * FROM appointment WHERE Physio_NIC=? AND (Status='1' OR Status='0') AND Date >=CURDATE() ";

        connect();
        System.out.println(NIC);
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, NIC);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int appointment_no = resultSet.getInt("Appointment_No");
            String physio_NIC = resultSet.getString("Physio_NIC");
            String customer_NIC = resultSet.getString("Customer_NIC");
            String date = resultSet.getString("Date");
            String time = resultSet.getString("Time");
            String status = resultSet.getString("Status");

            Appointment appointmentr = new Appointment(appointment_no, physio_NIC, customer_NIC, date, time, status);
            listAppointment.add(appointmentr);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listAppointment;
    }

    public List<Appointment> listAllAppointmentsU(String NIC) throws SQLException {
        List<Appointment> listAppointment = new ArrayList<>();

        String sql = "SELECT * FROM appointment WHERE Customer_NIC=? AND (Status='1' OR Status='0') AND Date >=CURDATE() ";

        connect();
        System.out.println(NIC);
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, NIC);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int appointment_no = resultSet.getInt("Appointment_No");
            String physio_NIC = resultSet.getString("Physio_NIC");
            String customer_NIC = resultSet.getString("Customer_NIC");
            String date = resultSet.getString("Date");
            String time = resultSet.getString("Time");
            String status = resultSet.getString("Status");

            Appointment appointmentr = new Appointment(appointment_no, physio_NIC, customer_NIC, date, time, status);
            listAppointment.add(appointmentr);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listAppointment;
    }

    public boolean deleteAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE appointment SET Status ='2'  WHERE Appointment_No = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, appointment.getAppointment_No());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE appointment SET Physio_NIC = ?, Customer_NIC = ?, Date = ?, Time = ?, Status = ?";
        sql += " WHERE Appointment_No = ?";
        connect();
        System.out.println("Connection Successful");
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, appointment.getPhysio_NIC());
        statement.setString(2, appointment.getCustomer_NIC());
        statement.setString(3, appointment.getDate());
        statement.setString(4, appointment.getTime());
        statement.setString(5, appointment.getStatus());
        statement.setInt(6, appointment.getAppointment_No());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public boolean MarkCompleted(Appointment appointment) throws SQLException {
        String sql = "UPDATE appointment SET Status = ?";
        sql += " WHERE Appointment_No = ?";
        connect();
        System.out.println("Connection Successful");
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, appointment.getStatus());
        statement.setInt(2, appointment.getAppointment_No());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Appointment getAppointment(int appointment_no) throws SQLException {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointment WHERE Appointment_No = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, appointment_no);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            appointment_no = resultSet.getInt("Appointment_No");
            String physio_NIC = resultSet.getString("Physio_NIC");
            String customer_NIC = resultSet.getString("Customer_NIC");
            String date = resultSet.getString("Date");
            String time = resultSet.getString("Time");
            String status = resultSet.getString("Status");
            System.out.println("appointment_no");

            appointment = new Appointment(appointment_no, physio_NIC, customer_NIC, date, time, status);
        }

        resultSet.close();
        statement.close();

        return appointment;
    }

}
