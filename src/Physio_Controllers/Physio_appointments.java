package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Physio_Beans.Appointment;
import Physio_Models.AppointmentDAO;

/**
 * Servlet implementation class Physio_appointments
 */
@WebServlet("/Physio_appointments")
public class Physio_appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AppointmentDAO appointmentDAO;

	public Physio_appointments() {
		super();
		appointmentDAO = new AppointmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listAppointment(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void listAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession httpSession = request.getSession();
		String NIC = (String) httpSession.getAttribute("NIC");

		List<Appointment> listAppointment = appointmentDAO.listAllAppointments(NIC);
		request.setAttribute("listAppointment", listAppointment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/AppointmentListPhysio.jsp");
		dispatcher.forward(request, response);
	}
}
