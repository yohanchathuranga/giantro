
package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PhysioDAO;
import User.User;

/**
 * Servlet implementation class Physio_Ctrl
 */
@WebServlet("/Physio_Ctrl")
public class Physio_Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhysioDAO physioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Physio_Ctrl() {
        super();
        physioDAO = new PhysioDAO();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action = request.getServletPath();
				
				try {
		            switch (action) {
		            case "/new":
		                showNewForm(request, response);
		                break;
		            case "/insert":
		                insertUser(request, response);
		                
		                break;
		            case "/delete":
		                deleteUser(request, response);
		                break;
		            case "/edit":
		                showEditForm(request, response);
		                break;
		            case "/update":
		                updateUser(request, response);
		                break;
		            case "/list1":
		            	listUser(request, response);
		            	System.out.println("sdfg");
		                break;
		            default:
		                listUser(request, response);
		                break;
		            }
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
		
		
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = physioDAO.listAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PhysioList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String NIC = request.getParameter("NIC");
        User existingUser = physioDAO.getUser(NIC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
  
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
//    	int User_no=Integer.parseInt(request.getParameter("User_no"));
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String certificate_ID = request.getParameter("Certificate_ID");
        String address = request.getParameter("Address");
        String exp = request.getParameter("Exp");
        String place_name = request.getParameter("Place_Name");
        String contact_no = request.getParameter("Contact_No");
        String status = request.getParameter("Status");
 
        User newUser = new User(name,email,certificate_ID,address,exp,place_name,contact_no,status);
        
        physioDAO.insertUser(newUser);
        response.sendRedirect("list");
    }
 
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String NIC = request.getParameter("User_No");
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String certificate_ID = request.getParameter("Certificate_ID");
        String address = request.getParameter("Address");
        String exp = request.getParameter("Exp");
        String place_name = request.getParameter("Place_Name");
        String contact_no = request.getParameter("Contact_No");
        String status = request.getParameter("Status");
 
        User user = new User(name,email,certificate_ID,address,exp,place_name,contact_no,status);
        
        physioDAO.insertUser(user);
        response.sendRedirect("list");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String NIC = request.getParameter("User_no");
 
        User user = new User(NIC);
        physioDAO.deleteUser(user);
        response.sendRedirect("list");
 
    }
	

}
