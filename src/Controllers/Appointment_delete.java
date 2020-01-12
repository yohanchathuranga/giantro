package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Appointment;
import Models.AppointmentDAO;


/**
 * Servlet implementation class Appointment_delete
 */
@WebServlet("/Appointment_delete")
public class Appointment_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppointmentDAO appointmentDAO;
    public Appointment_delete() {
        super();
        appointmentDAO = new AppointmentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteAppointment(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int appointment_no = Integer.parseInt(request.getParameter("appointment_no"));
 
        Appointment appointment = new Appointment(appointment_no);
        appointmentDAO.deleteAppointment(appointment);
        response.sendRedirect("Physio_appointments");
 
    }
}
