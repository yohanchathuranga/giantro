package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.User;
import Models.PhysioDAO;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private PhysioDAO physioDAO;
    
    public Login() {
        super();
        physioDAO = new PhysioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			loginUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
    	
    	String email = request.getParameter("Email");
		String password = request.getParameter("Password");
//		String pass=User.setPassword(password);
	//	String one="1";
		if (email != null && email.trim().length() > 0 && password != null && password.trim().length() > 0) {
			System.out.println(email + ":" + password);
			if (email != null && email.length() != 0 && password != null
					&& password.length() != 0 && PhysioDAO.validate(email, password)) {
				User existingUser = physioDAO.getUserDetail(email,password);
//				String[] not=physioDAO.notification(existingUser.NIC);
				if (request.getParameter("RememberMe") != null) {
					String remember = request.getParameter("RememberMe");
					System.out.println("RememberMe : " + remember);
					Cookie cEmail = new Cookie("cookemail", email.trim());
					Cookie cPassword = new Cookie("cookpass", password.trim());
					Cookie cRemember = new Cookie("cookrem", remember.trim());
					cEmail.setMaxAge(60 * 60 * 24 * 15);// 15 days
					cPassword.setMaxAge(60 * 60 * 24 * 15);
					cRemember.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(cEmail);
					response.addCookie(cPassword);
					response.addCookie(cRemember);
				}
				System.out.println(existingUser.PF);
				if((existingUser.CF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}else if((existingUser.PF)!=null) {
//					System.out.println(not);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}else if((existingUser.SF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}else if((existingUser.GF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}else if((existingUser.AF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("sessuser", email.trim());
				httpSession.setAttribute("NIC",existingUser.NIC );
				request.setAttribute("user", existingUser);
				
//				
			} else {
				System.out.println("Authentication failure.");
				request.setAttribute("msg", "Authentication failure.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
			}
		} else {
			System.out.println("Username and Password are required fields.");
			request.setAttribute("msg", "Username and Password are required fields.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
