package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Physio_Beans.Appointment;
import Physio_Models.AppointmentDAO;

@WebServlet("/Update_appointment")
public class Update_appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDAO appointmentDAO;

	public Update_appointment() {
		super();
		appointmentDAO = new AppointmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			updateAppointment(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(current);
		System.out.print(txtDate);
		System.out.println(date);
		if (txtDate.compareTo(date) <= 0) {
			Appointment appointment = new Appointment(appointment_no, physio_NIC, customer_NIC, date, time, status);
			appointmentDAO.updateAppointment(appointment);
			response.sendRedirect("Physio_appointments");
			System.out.println("after");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			System.out.println("earlier");
		}

	}
}
