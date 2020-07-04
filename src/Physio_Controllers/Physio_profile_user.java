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
import Physio_Models.PhysioDAO;

@WebServlet("/Physio_profile_user")
public class Physio_profile_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhysioDAO physioDAO;

	public Physio_profile_user() {
		super();
		physioDAO = new PhysioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			showEditFormProfile(request, response);
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

	private void showEditFormProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String NIC = request.getParameter("NIC1");
		User existingUser = physioDAO.getUser(NIC);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/PhysioProfile.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
}
