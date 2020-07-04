package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Physio_Beans.Schedule;
import Physio_Models.ScheduleDAO;

@WebServlet("/Schedule_reply_form")
public class Schedule_reply_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO scheduleDAO;

	public Schedule_reply_form() {
		super();
		scheduleDAO = new ScheduleDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			showEditFormSchedule(request, response);
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

	private void showEditFormSchedule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
		int scount = Integer.parseInt(request.getParameter("noofstep"));
		Schedule existingSchedule = scheduleDAO.getSchedule(schedule_no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/Schedule_reply_form.jsp");
		request.setAttribute("schedule", existingSchedule);
		request.setAttribute("scount", scount);
		dispatcher.forward(request, response);

	}
}
