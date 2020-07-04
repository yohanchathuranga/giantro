package Physio_Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logout(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Cookie cEmail = new Cookie("cookemail", null);
		Cookie cPassword = new Cookie("cookpass", null);
		Cookie cRemember = new Cookie("cookrem", null);
		cEmail.setMaxAge(0);
		cPassword.setMaxAge(0);
		cRemember.setMaxAge(0);
		response.addCookie(cEmail);
		response.addCookie(cPassword);
		response.addCookie(cRemember);
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		request.setAttribute("msg", "You have successfully logged out.");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
		requestDispatcher.forward(request, response);
	}

}
