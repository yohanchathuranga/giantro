package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Schedule;
import Models.ScheduleDAO;



@WebServlet("/Schedule_edit")
public class Schedule_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO scheduleDAO;
    
    public Schedule_edit() {
        super();
        scheduleDAO= new ScheduleDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditFormSchedule(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showEditFormSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
        Schedule existingSchedule = scheduleDAO.getSchedule(schedule_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/schedule_edit.jsp");
        request.setAttribute("schedule", existingSchedule);
        dispatcher.forward(request, response);
  
    }
}
