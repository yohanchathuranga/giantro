package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_select
 */
@WebServlet("/User_select")
public class User_select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_select() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserSelect(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void UserSelect(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String user = request.getParameter("user");
		System.out.println(user);
		if (user == "Gym") {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("gym/gym_login.jsp");
			requestDispatcher.forward(request, response);

		} else if (user == "Physio") {
			System.out.println(user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);

		} else if (user == "Supplement") {

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("supplement_shop/supplement_shop_login.jsp");
			requestDispatcher.forward(request, response);

		} else if (user == "Customer") {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/User_login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
