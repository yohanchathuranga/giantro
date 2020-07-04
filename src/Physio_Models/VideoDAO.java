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
import Physio_Beans.User;
import Physio_Beans.Video;

public class VideoDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/giantro";
    private static String jdbcVideoname = "root";
    private static String jdbcPassword = "";
    private static Connection jdbcConnection;

    protected static void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcVideoname, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Video> listAllVideos() throws SQLException {
        List<Video> listVideo = new ArrayList<>();

        String sql = "SELECT * FROM Video WHERE Status='1' ";

        connect();
        System.out.println("Connection Successful");

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int video_ID = resultSet.getInt("Video_ID");
            String topic = resultSet.getString("Topic");
            String user_NIC = resultSet.getString("User_NIC");
            String videopath = resultSet.getString("Video");
            String category = resultSet.getString("Category");
            String status = resultSet.getString("Status");

            Video video = new Video(video_ID, topic, user_NIC, videopath, category, status);
            listVideo.add(video);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listVideo;
    }

    public Video getVideo(int vid) throws SQLException {
        Video Video = null;
        String sql = "SELECT * FROM Video WHERE Video_ID = ? AND Status='1'";
        String sql1 = "UPDATE Video SET View_Count=(View_Count+1) WHERE Video_ID = ? AND Status='1'";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, vid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String topic = resultSet.getString("Topic");
            String user_NIC = resultSet.getString("User_NIC");
            String video = resultSet.getString("Video");
            String category = resultSet.getString("Category");

            Video = new Video(vid, topic, user_NIC, video, category);
        }
        PreparedStatement statement1 = jdbcConnection.prepareStatement(sql1);
        statement1.setInt(1, vid);
        statement1.executeUpdate();
        resultSet.close();
        statement.close();

        return Video;
    }

    public boolean insertVideo(Video video) throws SQLException {
        String sql = "INSERT INTO Video (Topic,User_NIC,Video,Category) VALUES (?,?,?,?)";
        connect();
        System.out.println("Connection Successful");

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, video.getTopic());
        statement.setString(2, video.getUser_NIC());
        statement.setString(3, video.getVideo());
        statement.setString(4, video.getCategory());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;

    }
}
