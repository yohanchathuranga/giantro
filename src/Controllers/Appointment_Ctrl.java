package Controllers;

import java.io.IOException;
//import java.sql.Date;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Models.AppointmentDAO;
import Models.PhysioDAO;
import User.User;
import appointment.Appointment;


@WebServlet("/")
public class Appointment_Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//initilize DAO variables
    private AppointmentDAO appointmentDAO;
    private PhysioDAO physioDAO;
	
    //constructor initialize
    public Appointment_Ctrl() {
        super();
        //Create DAO objects
        appointmentDAO = new AppointmentDAO();
        physioDAO = new PhysioDAO();
    }
    
    
    

	//get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Select Action
		String action = request.getServletPath();
				
				try {
		            switch (action) {
		            case "/new_a":
		                showNewFormApp(request, response);			//load appointment form
		                break;
		            case "/insert_a":
		                insertAppointment(request, response);		//insert new Appointment
		                
		                break;
		            case "/delete_a":
		                deleteAppointment(request, response);		//delete appointment
		                break;
		            case "/edit_a":
		                showEditFormApp(request, response);			// edit an existing appointment form
		                break;
		            case "/update_a":
		                updateAppointment(request, response);		//update an appointment
		                break;
		            case "/list_a":
		            	listAppointment(request, response);			//list of appointments
		                break;
		            case "/new_u":
		                showNewFormU(request, response);			//load user form
		                break;
		            case "/insert_u":
		                insertUser(request, response);				//insert new user
		            case "/profile_u":
		                showEditFormU(request, response);			//Show Physio profile
		                
		                break;
		            case "/delete_u":
		                deleteUser(request, response);				// delete user
		                break;
		            case "/edit_u":
		                showEditFormU(request, response);			//edit user form
		                break;
		            case "/update_u":
		                updateUser(request, response);				//update an existing user
		                break;
		            case "/list_u":
		            	listUser(request, response);				//list of physios
		            	
		                break;
		            default:
//		                listAppointment(request, response);			//Default function load
		                break;
		            }
		        } catch (Exception ex) {
		            throw new ServletException(ex);
		        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
		
		
	}
	
//<-----------------------------------------------------------------------Appointment-------------------------------------------------------------------->
	
	private void listAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Appointment> listAppointment = appointmentDAO.listAllAppointments();
        request.setAttribute("listAppointment", listAppointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AppointmentListUser.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewFormApp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String NIC=request.getParameter("NIC");
    	System.out.println(NIC);
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("Appointment_form.jsp");
        request.setAttribute("NIC", NIC);
        dispatcher.forward(request, response);
    }
    
    
    
 
    private void showEditFormApp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int appointment_no = Integer.parseInt(request.getParameter("appointment_no"));
        Appointment existingAppointment = appointmentDAO.getAppointment(appointment_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Appointment_Edit.jsp");
        request.setAttribute("appointment", existingAppointment);
        
        dispatcher.forward(request, response);
  
    }
 
    private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
//    	int appointment_no=Integer.parseInt(request.getParameter("appointment_no"));
        String physio_NIC = request.getParameter("physio_NIC");
        String customer_NIC = request.getParameter("customer_NIC");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String status = request.getParameter("status");
        
        
 
        Date current = new Date();
        String txtDate=new SimpleDateFormat("yyyy-MM-dd").format(current);
        System.out.print(txtDate);
        System.out.println(date);
        if (txtDate.compareTo(date) <= 0) {
        	Appointment newAppointment = new Appointment(physio_NIC,customer_NIC,date,time,status);
          
        	appointmentDAO.insertAppointment(newAppointment);
          	response.sendRedirect("list_a");
            System.out.println("after");
        }else {
        	JOptionPane.showMessageDialog(null, "Invalid Date");
        	System.out.println("earlier");
        }

        
        
    }
 
    private void updateAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	int appointment_no = Integer.parseInt(request.getParameter("appointment_No"));
        String physio_NIC = request.getParameter("physio_NIC");
        String customer_NIC = request.getParameter("customer_NIC");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String status = request.getParameter("status");
        
        Date current = new Date();
        String txtDate=new SimpleDateFormat("yyyy-MM-dd").format(current);
        System.out.print(txtDate);
        System.out.println(date);
        if (txtDate.compareTo(date) <= 0) {
        	 Appointment appointment = new Appointment(appointment_no,physio_NIC,customer_NIC,date,time,status);
             appointmentDAO.updateAppointment(appointment);
          	response.sendRedirect("list_a");
            System.out.println("after");
        }else {
        	JOptionPane.showMessageDialog(null, "Invalid Date");
        	System.out.println("earlier");
        }
 
       
        
    }
 
    private void deleteAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int appointment_no = Integer.parseInt(request.getParameter("appointment_no"));
 
        Appointment appointment = new Appointment(appointment_no);
        appointmentDAO.deleteAppointment(appointment);
        response.sendRedirect("list_a");
 
    }
    
    
    
    
//    <--------------------------------------------------------------USER---------------------------------------------------------------------------------->
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = physioDAO.listAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PhysioList.jsp");
        dispatcher.forward(request, response);
    }
    
 
    private void showNewFormU(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditFormU(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String NIC = request.getParameter("NIC");
        User existingUser = physioDAO.getUser(NIC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");
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
        response.sendRedirect("list_u");
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
        response.sendRedirect("list_u");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String NIC = request.getParameter("User_no");
 
        User user = new User(NIC);
        physioDAO.deleteUser(user);
        response.sendRedirect("list");
 
    }
	


}
