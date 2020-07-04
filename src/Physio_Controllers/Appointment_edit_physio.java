package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Physio_Beans.Appointment;
import Physio_Models.AppointmentDAO;

@WebServlet("/Appointment_edit_physio") // annotation servlet mapping
public class Appointment_edit_physio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AppointmentDAO appointmentDAO;

	public Appointment_edit_physio() {
		super();
		appointmentDAO = new AppointmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			showEditFormApp(request, response); // call showEditFormApp function
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

	private void showEditFormApp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int appointment_no = Integer.parseInt(request.getParameter("appointment_no")); // catch the parameter
																						// appointment no coming through
																						// request

		Appointment existingAppointment = appointmentDAO.getAppointment(appointment_no); // assign the details of
																							// appointment to
																							// appointment object
		HttpSession httpSession = request.getSession();
		String type = (String) httpSession.getAttribute("type");
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/Appointment_Edit_Physio.jsp"); // dispatcher
																											// return
																											// page

		request.setAttribute("appointment", existingAppointment); // reset parameters to return page

		dispatcher.forward(request, response);

	}

}
