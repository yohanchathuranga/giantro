package Physio_Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Physio_Beans.Schedule;

public class ScheduleDAO {
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

	public boolean insertSchedule(Schedule schedule) throws SQLException {
		String sql = "INSERT INTO Schedules (Physio_NIC, Customer_NIC,Age,Height,Weight,Photo) VALUES (?,?,?,?,?,?)";
		connect();
		System.out.println("Connection Successful");

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, schedule.getPhysio_NIC());
		statement.setString(2, schedule.getCustomer_NIC());
		statement.setString(3, schedule.getAge());
		statement.setString(4, schedule.getHeight());
		statement.setString(5, schedule.getWeight());
		statement.setString(6, schedule.getPhotos());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;

	}

	public boolean insertScheduleReply(Schedule schedule) throws SQLException {
		PreparedStatement statement = null;
		String sql = "INSERT INTO schedule_reply (Schedule_No,Exercise,Rep,Turn) VALUES (?,?,?,?)";
		connect();
		System.out.println("Connection Successful");
		String steps[][] = schedule.getSteps();

		for (int i = 0; i < 30; i++) {
			if (steps[i][0] == null) {
				break;
			}
			statement = jdbcConnection.prepareStatement(sql);

			statement.setInt(1, schedule.getSchedule_No());
			statement.setString(2, steps[i][0]);
			statement.setString(3, steps[i][1]);
			statement.setString(4, steps[i][2]);

			try {
				statement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

		}

		statement.close();

		disconnect();
		boolean rowInserted = false;
		return rowInserted;

	}

	public List<Schedule> listAllSchedules(String NIC) throws SQLException {
		List<Schedule> listSchedule = new ArrayList<>();

		String sql = "SELECT * FROM Schedules WHERE Physio_NIC=? AND Status='1'";

		connect();
		System.out.println(NIC);

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, NIC);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int schedule_no = resultSet.getInt("Schedule_No");
			String physio_NIC = resultSet.getString("Physio_NIC");
			String customer_NIC = resultSet.getString("Customer_NIC");
			String age = resultSet.getString("Age");
			String height = resultSet.getString("Height");
			String weight = resultSet.getString("Weight");
			String photo = resultSet.getString("Photo");

			Schedule schedule = new Schedule(schedule_no, physio_NIC, customer_NIC, age, height, weight, photo);
			listSchedule.add(schedule);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listSchedule;
	}

	public List<Schedule> listAllScheduleReplies(int schedule_no) throws SQLException {
		List<Schedule> listSchedule = new ArrayList<>();

		String sql = "SELECT * FROM Schedule_reply WHERE Schedule_No=?";

		connect();
		System.out.println("Connection Successful");
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, schedule_no);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int schedule_no1 = resultSet.getInt("Schedule_No");
			String exercise = resultSet.getString("Exercise");
			String rep = resultSet.getString("Rep");
			String turn = resultSet.getString("Turn");

			Schedule schedule = new Schedule(schedule_no1, exercise, rep, turn);
			listSchedule.add(schedule);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listSchedule;
	}

	public List<Schedule> listAllSchedulesU(String NIC) throws SQLException {
		List<Schedule> listSchedule = new ArrayList<>();

		String sql = "SELECT * FROM Schedules WHERE Customer_NIC=?";

		connect();
		System.out.println(NIC);

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, NIC);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int schedule_no = resultSet.getInt("Schedule_No");
			String physio_NIC = resultSet.getString("Physio_NIC");
			String customer_NIC = resultSet.getString("Customer_NIC");
			String age = resultSet.getString("Age");
			String height = resultSet.getString("Height");
			String weight = resultSet.getString("Weight");
			String photo = resultSet.getString("Photo");

			Schedule schedule = new Schedule(schedule_no, physio_NIC, customer_NIC, age, height, weight, photo);
			listSchedule.add(schedule);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listSchedule;
	}

	public boolean deleteSchedule(Schedule Schedule) throws SQLException {
		String sql = "UPDATE Schedules SET Status='2'";
		sql += " WHERE Schedule_No = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, Schedule.getSchedule_No());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateSchedule(Schedule Schedule) throws SQLException {
		String sql = "UPDATE Schedules SET Physio_NIC = ?, Customer_NIC = ?, Age = ?, Height = ?, Weight = ? ,Photo=?";
		sql += " WHERE Schedule_No = ?";
		connect();
		System.out.println("Connection Successful");
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, Schedule.getPhysio_NIC());
		statement.setString(2, Schedule.getCustomer_NIC());
		statement.setString(3, Schedule.getAge());
		statement.setString(4, Schedule.getHeight());
		statement.setString(5, Schedule.getWeight());
		statement.setString(6, Schedule.getPhotos());
		statement.setInt(7, Schedule.getSchedule_No());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public Schedule getSchedule(int schedule_no) throws SQLException {
		Schedule Schedule = null;
		String sql = "SELECT * FROM Schedules WHERE Schedule_No = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, schedule_no);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String physio_NIC = resultSet.getString("Physio_NIC");
			String customer_NIC = resultSet.getString("Customer_NIC");
			String age = resultSet.getString("Age");
			String height = resultSet.getString("Height");
			String weight = resultSet.getString("Weight");
			String photos = resultSet.getString("Photo");
			System.out.println(schedule_no);

			Schedule = new Schedule(schedule_no, physio_NIC, customer_NIC, age, height, weight, photos);
		}

		resultSet.close();
		statement.close();

		return Schedule;
	}

}
