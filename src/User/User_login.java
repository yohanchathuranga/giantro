package User;

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

import Physio_Beans.User;
import Physio_Models.PhysioDAO;



@WebServlet("/User_login")
public class User_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private PhysioDAO physioDAO;
    
    public User_login() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
    	
    	String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		User user = new User(email,password);

		if (email != null && email.trim().length() > 0 && password != null && password.trim().length() > 0) {
			System.out.println(email + ":" + password);
			if (email != null && email.length() != 0 && password != null
					&& password.length() != 0 && PhysioDAO.validate(user)) {
				User existingUser = physioDAO.getUserDetail(user);
				int[] not=physioDAO.notification(existingUser.NIC);

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
				int app =not[0];
				int sch =not[1];
				int today=not[2];
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("sessuser", email.trim());
				httpSession.setAttribute("NIC",existingUser.NIC );
				request.setAttribute("user", existingUser);
				httpSession.setAttribute("app",app);
				httpSession.setAttribute("sch",sch);
				httpSession.setAttribute("today",today);
				if((existingUser.CF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user_dashboard.jsp");
					requestDispatcher.forward(request, response);
					
				}else if((existingUser.SF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("supplement_shop_login_con");
					request.setAttribute("username",email);
					request.setAttribute("pass",password);
					requestDispatcher.forward(request, response);
				}else if((existingUser.PF)!=null) {
//					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
					request.setAttribute("app",app);
					request.setAttribute("sch",sch);
					
				
				}else if((existingUser.GF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("supplement_shop/supplement_shop_profile.jsp");
					requestDispatcher.forward(request, response);
				}else if((existingUser.AF)!=null) {
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/physio_dashboard.jsp");
					requestDispatcher.forward(request, response);
				}
				
				
				
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
