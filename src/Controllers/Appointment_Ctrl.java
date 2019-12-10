package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import Models.AppointmentDAO;

import Models.PhysioDAO;
import Models.ScheduleDAO;
import Schedule.Schedule;
import User.User;
import appointment.Appointment;

@javax.servlet.annotation.MultipartConfig
//@WebServlet("/")
public class Appointment_Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//initilize DAO variables
    private AppointmentDAO appointmentDAO;
    private PhysioDAO physioDAO;
    private ScheduleDAO scheduleDAO;
    
	
    //constructor initialize
    public Appointment_Ctrl() {
        super();
        //Create DAO objects
        scheduleDAO= new ScheduleDAO();
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
		            case "/list_a_u":
		            	listAppointmentU(request, response);			//list of appointments
		                break;
		            case "/list_a":
		            	listAppointment(request, response);			//list of appointments
		                break;
		            case "/new_u":
		                showNewFormU(request, response);			//load user form
		                break;
		            case "/insert_u":
		                insertUser(request, response);				//insert new user
		                break;
		                
		            case "/profile_u":
		                showEditFormProfile(request, response);			//Show Physio profile
		                
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
		            	listUser(request, response);				//list of physio
		                break;
		            case "/Alogin_u":
		            	loginUser(request, response);				//login of physio
		                break;
		            case "/logout":
		            	logout(request, response);				//logout of physio
		                break;
		            case "/reset_password":
		            	logout(request, response);				//logout of physio
		                break;
		            case "/new_s":
		                showNewFormSchedule(request, response);			//load user form
		                break;
		            case "/insert_s":
		                insertSchedule(request, response);				//insert new user
		                break;
		            case "/profile_p":
		                showEditFormP(request, response);			//Show Physio profile
		                
		                break;
		            case "/delete_s":
		                deleteSchedule(request, response);				// delete user
		                break;
		            case "/edit_s":
		                showEditFormSchedule(request, response);			//edit user form
		                break;
		            case "/update_s":
		                updateSchedule(request, response);				//update an existing user
		                break;
		            case "/list_s":
		            	listSchedule(request, response);				//list of physio
		                break;
		            case "/list_s_u":
		            	listScheduleU(request, response);				//list of physio
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
		
		HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
		
        List<Appointment> listAppointment = appointmentDAO.listAllAppointments(NIC);
        request.setAttribute("listAppointment", listAppointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/AppointmentListPhysio.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listAppointmentU(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
		
        List<Appointment> listAppointment = appointmentDAO.listAllAppointmentsU(NIC);
        request.setAttribute("listAppointment", listAppointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/AppointmentListPhysio.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewFormApp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String NIC=request.getParameter("NIC");
    	System.out.println(NIC);
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Appointment_form.jsp");
        request.setAttribute("NIC", NIC);
        dispatcher.forward(request, response);
    }
    
    
    
 
    private void showEditFormApp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int appointment_no = Integer.parseInt(request.getParameter("appointment_no"));
        Appointment existingAppointment = appointmentDAO.getAppointment(appointment_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Appointment_Edit.jsp");
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
        	request.setAttribute("alertMsg", "Appointment Success");
          	response.sendRedirect("list_a_u");
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
          	response.sendRedirect("list_a_u");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/PhysioList.jsp");
        dispatcher.forward(request, response);
    }
    
 
    private void showNewFormU(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/register_physio.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditFormU(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String NIC = request.getParameter("NIC");
        User existingUser = physioDAO.getUser(NIC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/edit_physio.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
  
    }
    private void showEditFormProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String NIC = request.getParameter("NIC");
        User existingUser = physioDAO.getUser(NIC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Profile.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
  
    }
    
    private void showEditFormP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
        User existingUser = physioDAO.getUser(NIC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/physio_profile.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
  
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
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(request, response);

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
        response.sendRedirect("physio/physio_dashboard.jsp");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String NIC = request.getParameter("NIC");
 
        User user = new User(NIC);
        physioDAO.deleteUser(user);
        response.sendRedirect("list");
 
    }
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
    	
    	String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String one="1";
		if (email != null && email.trim().length() > 0 && password != null && password.trim().length() > 0) {
			System.out.println(email + ":" + password);
			if (email != null && email.length() != 0 && password != null
					&& password.length() != 0 && PhysioDAO.validate(email, password)) {
				User existingUser = physioDAO.getUserDetail(email,password);
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
		

    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
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
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(request, response);
    }
    
//-------------------------------------------------------------------------------Schedule------------------------------------------------------------------------>
    
    
    private void listSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
    	System.out.println(NIC);
    	List<Schedule> listSchedule = scheduleDAO.listAllSchedules(NIC);
        
        request.setAttribute("listSchedule", listSchedule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/scheduleList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listScheduleU(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
    	System.out.println(NIC);
    	List<Schedule> listSchedule = scheduleDAO.listAllSchedulesU(NIC);
        
        request.setAttribute("listSchedule", listSchedule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/scheduleList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewFormSchedule(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/schedule_form.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditFormSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int schedule_no = Integer.parseInt(request.getParameter("Schedule_No"));
        Schedule existingSchedule = scheduleDAO.getSchedule(schedule_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/schedule_form.jsp");
        request.setAttribute("schedule", existingSchedule);
        dispatcher.forward(request, response);
  
    }
 
    private void insertSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	System.out.println("dfghfgh");
//    	int schedule_no=Integer.parseInt(request.getParameter("Schedule_No"));
    	String physio_NIC = request.getParameter("Physio_NIC");
        String customer_NIC = request.getParameter("Customer_NIC");
        String age = request.getParameter("Age");
        String height = request.getParameter("Height");
        String weight = request.getParameter("Weight");
        //String photo = request.getParameter("Photo");
        
        Part filePart = request.getPart("Photo");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!
	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File("WebContent/uploaded-files/" + filePart.getSubmittedFileName());
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//get the URL of the uploaded file
		String fileUrl = "http://localhost:8080/uploaded-files/" + filePart.getSubmittedFileName();
		
		//You can get other form data too
		String name = request.getParameter("name");
		
		//create output HTML that uses the 
		response.getOutputStream().println("<p>Thanks " + name + "! Here's a link to your uploaded file:</p>");
		response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
		response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/index.jsp\">here</a>.</p>");	
        
//        InputStream inputStream = null;
//
//        // obtains the upload file part in this multipart request
//        Part filePart = request.getPart("photo");
//        if (filePart != null) {
//            // debug messages
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//
//            // obtains input stream of the upload file
//            inputStream = filePart.getInputStream();
//            byte[] photo = IOUtils.toByteArray(inputStream);
//        }
        
 
        Schedule newSchedule = new Schedule(physio_NIC,customer_NIC,age,height,weight,fileUrl);
        
        scheduleDAO.insertSchedule(newSchedule);
        response.sendRedirect("list_s_u");
    }
 
    private void updateSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int schedule_no = Integer.parseInt(request.getParameter("Schedule_No"));
        String physio_NIC = request.getParameter("Physio_NIC");
        String customer_NIC = request.getParameter("Customer_NIC");
        String age = request.getParameter("Age");
        String height = request.getParameter("Height");
        String weight = request.getParameter("Weight");
        String photo = request.getParameter("Photo");
       
//        InputStream inputStream = null;
//
//        // obtains the upload file part in this multipart request
//        Part filePart = request.getPart("photo");
//        if (filePart != null) {
//            // debug messages
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//
//            // obtains input stream of the upload file
//            inputStream = filePart.getInputStream();
//            byte[] photo = IOUtils.toByteArray(inputStream);
//        }
// 
        Schedule schedule = new Schedule(schedule_no,physio_NIC,customer_NIC,age,height,weight,photo);
        
        scheduleDAO.updateSchedule(schedule);
        response.sendRedirect("list_s_u");
    }
 
    private void deleteSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int schedule_no = Integer.parseInt(request.getParameter("Schedule_No"));
 
        Schedule schedule = new Schedule(schedule_no);
        scheduleDAO.deleteSchedule(schedule);
        response.sendRedirect("list_s");
 
    }
	


}
