package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Schedule;
import Models.ScheduleDAO;



/**
 * Servlet implementation class Schedule_delete
 */
@WebServlet("/Schedule_delete")
public class Schedule_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO scheduleDAO; 
    
    public Schedule_delete() {
        super();
        scheduleDAO= new ScheduleDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteSchedule(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
 
        Schedule schedule = new Schedule(schedule_no);
        scheduleDAO.deleteSchedule(schedule);
        response.sendRedirect("Physio_schedule");
 
    }
}
