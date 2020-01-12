package Controllers;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Beans.Appointment;
import Models.AppointmentDAO;




@WebServlet("/Appointment_edit_physio")
public class Appointment_edit_physio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppointmentDAO appointmentDAO;
    public Appointment_edit_physio() {
        super();
        appointmentDAO = new AppointmentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditFormApp(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	private void showEditFormApp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int appointment_no = Integer.parseInt(request.getParameter("appointment_no"));
        Appointment existingAppointment = appointmentDAO.getAppointment(appointment_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Appointment_Edit.jsp");
        request.setAttribute("appointment", existingAppointment);
        
        dispatcher.forward(request, response);
  
    }
	
}
