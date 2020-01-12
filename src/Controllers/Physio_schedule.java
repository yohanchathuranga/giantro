package Controllers;

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

import Beans.Schedule;
import Models.ScheduleDAO;



@WebServlet("/Physio_schedule")
public class Physio_schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ScheduleDAO scheduleDAO;
    public Physio_schedule() {
        super();
        scheduleDAO= new ScheduleDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listSchedule(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	HttpSession httpSession = request.getSession();
    	String NIC=(String) httpSession.getAttribute("NIC");
    	System.out.println(NIC);
    	List<Schedule> listSchedule = scheduleDAO.listAllSchedules(NIC);
        
        request.setAttribute("listSchedule", listSchedule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("physio/scheduleList.jsp");
        dispatcher.forward(request, response);
    }
}
