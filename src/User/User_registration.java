package User;

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

/**
 * Servlet implementation class User_registration
 */
@WebServlet("/User_registration")
public class User_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PhysioDAO physioDAO;		//create variable from physioDAO model class
    public User_registration() {
        super();
        physioDAO = new PhysioDAO();		//assign new object of physioDAO defined variable
    }

  //get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertUser(request, response); //call the function insertUser
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	//post method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	//Assign values to variables that are coming from request
    	String nic=request.getParameter("NIC");
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String contact_no = request.getParameter("Contact_No");
        String status = request.getParameter("Status");
        String cf = request.getParameter("CF");
        String password = request.getParameter("Password");
        String password1 = request.getParameter("Password1");
        System.out.println(password);
        System.out.println(password1);
        
        if(password1.equals(password)) {
        	
        	User newUser = new User(nic,name,email,contact_no,status,cf,password);

            physioDAO.insertUser(newUser); // Call the function in model class with newAppointment object as parameter to
                                           // insert new user to database
            request.setAttribute("msg", "You have successfully Registered."); //// Success message
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user_login.jsp"); // Dispatcher
                                                                                                          // return page

            requestDispatcher.forward(request, response);
        }else {
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/register_user_login.jsp"); // Dispatcher
            // return page
        	request.setAttribute("msg", "Your password mistmatch.");
        	requestDispatcher.forward(request, response);
        	
        }
        
    }
       
        

}
