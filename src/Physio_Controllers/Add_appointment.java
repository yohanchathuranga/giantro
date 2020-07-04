package Physio_Controllers;

//Add new appointment 
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Physio_Beans.Appointment;
import Physio_Models.AppointmentDAO;

@WebServlet("/Add_appointment") // Annotation servlet mapping

public class Add_appointment extends HttpServlet {
	private static final long serialVersionUID = 1L; // Default identifier for class

	private AppointmentDAO appointmentDAO; // create variable from appointmentDAO model class

	public Add_appointment() {
		super();
		appointmentDAO = new AppointmentDAO(); // assign new object of appointmentDAO defined variable
	}

	// get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			insertAppointment(request, response); // call the function insertAppointment
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// post method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, Exception {
		// Assign values to variables that are coming from request
		String physio_NIC = request.getParameter("physio_NIC");
		String customer_NIC = request.getParameter("customer_NIC");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String status = request.getParameter("status");

		Date current = new Date(); // create date object
		String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(current);// convert date to string

		if (txtDate.compareTo(date) <= 0) { // validate date
			Appointment newAppointment = new Appointment(physio_NIC, customer_NIC, date, time, status); // assign values
																										// to new
																										// appointment
																										// object

			appointmentDAO.insertAppointment(newAppointment); // Call the function in model class with newAppointment
																// object as parameter to
																// insert new appointment to database
			request.setAttribute("alertMsg", "Appointment Success");// Success message

			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp"); // Dispatcher return page
			request.setAttribute("NIC", customer_NIC);
			dispatcher.forward(request, response);
			response.sendRedirect("User_appointments");

		} else {
			JOptionPane.showMessageDialog(null, "Invalid Date"); // If date invalid warning message

		}

	}
}
