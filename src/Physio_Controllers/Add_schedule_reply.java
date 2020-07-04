package Physio_Controllers;
//Make reply for schedule request

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Physio_Beans.Schedule;
import Physio_Models.ScheduleDAO;

@WebServlet("/Add_schedule_reply") // annotation servlet mapping
public class Add_schedule_reply extends HttpServlet {
	private static final long serialVersionUID = 1L; // default identifier for class
	private ScheduleDAO scheduleDAO; // create variable from scheduleDAO model class

	public Add_schedule_reply() {
		super();
		scheduleDAO = new ScheduleDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			insertScheduleReply(request, response);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void insertScheduleReply(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int schedule_no = Integer.parseInt(request.getParameter("Schedule_No"));// catct the request parameters and
																				// assign values to variables
		// int scount=Integer.parseInt(request.getParameter("scount"));
		String[][] steps = new String[30][3];
		for (int i = 1; i <= 30; i++) {
			String exercise = request.getParameter("exercise" + i);
			String rep = request.getParameter("rep" + i);
			String turn = request.getParameter("turn" + i);

			steps[i - 1][0] = exercise;
			steps[i - 1][1] = rep;
			steps[i - 1][2] = turn;
		}

		Schedule newSchedulereply = new Schedule(schedule_no, steps); // create schedule bean object

		scheduleDAO.insertScheduleReply(newSchedulereply); // call the insertScheduleReply function
		RequestDispatcher dispatcher = request.getRequestDispatcher("physio/physio_dashboard.jsp");
		dispatcher.forward(request, response);

	}

}
