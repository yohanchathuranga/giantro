package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Physio_Beans.User;
import Physio_Beans.Video;
import Physio_Models.VideoDAO;

@WebServlet("/View_video")
public class View_video extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public View_video() {
		super();
		videoDAO = new VideoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ViewVideo(request, response);
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

	private void ViewVideo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int vid = Integer.parseInt(request.getParameter("VID"));
		Video existingVideo = videoDAO.getVideo(vid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/Video_Show.jsp");
		request.setAttribute("video", existingVideo);
		dispatcher.forward(request, response);

	}
}
