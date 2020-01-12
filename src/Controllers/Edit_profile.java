package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.User;
import Models.PhysioDAO;



@WebServlet("/Edit_profile")
public class Edit_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PhysioDAO physioDAO;
    public Edit_profile() {
        super();
        physioDAO = new PhysioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			EditProfile(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void EditProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String NIC = request.getParameter("NIC");
        User existingUser = physioDAO.getUser(NIC);
        if((existingUser.CF)!=null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/EditUser.jsp");
			request.setAttribute("user", existingUser);
			requestDispatcher.forward(request, response);
		}else if((existingUser.PF)!=null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
			request.setAttribute("user", existingUser);
			requestDispatcher.forward(request, response);
		}else if((existingUser.SF)!=null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
			request.setAttribute("user", existingUser);
			requestDispatcher.forward(request, response);
		}else if((existingUser.GF)!=null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
			request.setAttribute("user", existingUser);
			requestDispatcher.forward(request, response);
		}else if((existingUser.AF)!=null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
			request.setAttribute("user", existingUser);
			requestDispatcher.forward(request, response);
		}
//        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
  
    }
}
