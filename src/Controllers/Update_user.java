package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.User;
import Models.PhysioDAO;




@WebServlet("/Update_user")
public class Update_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhysioDAO physioDAO;
    public Update_user() {
        super();
        physioDAO = new PhysioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			updateUser(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String NIC = request.getParameter("NIC");
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String certificate_ID = request.getParameter("Certificate_ID");
        String address = request.getParameter("Address");
        String exp = request.getParameter("Exp");
        String place_name = request.getParameter("Place_Name");
        String contact_no = request.getParameter("Contact_No");
        String status = request.getParameter("Status");
        String password = request.getParameter("Password");
 
        User user = new User(NIC,name,email,certificate_ID,address,exp,place_name,contact_no,status,password);
        
        physioDAO.updateUser(user);
        response.sendRedirect("user/user_dashboard.jsp");
    }
}

