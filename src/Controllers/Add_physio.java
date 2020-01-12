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



@WebServlet("/Addphysio")
public class Add_physio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PhysioDAO physioDAO;
    public Add_physio() {
        super();
        physioDAO = new PhysioDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertUser(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	String nic=request.getParameter("NIC");
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String certificate_ID = request.getParameter("Certificate_ID");
        String address = request.getParameter("Address");
        String exp = request.getParameter("Exp");
        String place_name = request.getParameter("Place_Name");
        String contact_no = request.getParameter("Contact_No");
        String status = request.getParameter("Status");
        String pf = request.getParameter("PF");
        String password = request.getParameter("Password");
        System.out.println(pf);
 
        User newUser = new User(nic,name,email,certificate_ID,address,exp,place_name,contact_no,status,pf,password);
        
        physioDAO.insertUser(newUser);
        request.setAttribute("msg", "You have successfully Registered.");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		
		requestDispatcher.forward(request, response);
		
    }

}
