package Physio_Controllers;

//Register new physio
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

@WebServlet("/Addphysio") // Annotation servlet mapping
public class Add_physio extends HttpServlet {
    private static final long serialVersionUID = 1L; // Default identifier for class

    private PhysioDAO physioDAO; // create variable from physioDAO model class

    public Add_physio() {
        super();
        physioDAO = new PhysioDAO(); // assign new object of physioDAO defined variable
    }

    // get method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    // post method
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 try {
             insertUser(request, response); // call the function insertUser

         } catch (SQLException e) {

             e.printStackTrace();
         }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Assign values to variables that are coming from request
        String nic = request.getParameter("NIC");
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
        String password1 = request.getParameter("Password1");
        System.out.println(password);
        System.out.println(password1);
        if(password1.equals(password)) {
        	
            User newUser = new User(nic, name, email, certificate_ID, address, exp, place_name, contact_no, status, pf,
                    password);

            physioDAO.insertPhysio(newUser); // Call the function in model class with newAppointment object as parameter to
                                           // insert new appointment to database
            request.setAttribute("msg", "You have successfully Registered."); //// Success message
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/Physio_login.jsp"); // Dispatcher
                                                                                                          // return page

            requestDispatcher.forward(request, response);
        }else {
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("physio/register_physio.jsp"); // Dispatcher
            // return page
        	request.setAttribute("msg", "Your password mistmatch.");
        	requestDispatcher.forward(request, response);
        	
        }

       

    }

}
