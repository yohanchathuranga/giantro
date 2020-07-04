package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Physio_Beans.Video;
import Physio_Models.VideoDAO;

@WebServlet("/Video_list")
public class Video_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public Video_list() {
		super();
		videoDAO = new VideoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listVideo(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listVideo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Video> listVideo = videoDAO.listAllVideos();
		request.setAttribute("listVideo", listVideo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/Video_list.jsp");
		dispatcher.forward(request, response);
	}

}
