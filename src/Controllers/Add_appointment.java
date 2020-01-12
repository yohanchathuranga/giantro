package Controllers;

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

import Beans.Appointment;
import Models.AppointmentDAO;



@WebServlet("/Add_appointment")
public class Add_appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppointmentDAO appointmentDAO;   
    
    public Add_appointment() {
        super();
        appointmentDAO = new AppointmentDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertAppointment(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
//    	int appointment_no=Integer.parseInt(request.getParameter("appointment_no"));
        String physio_NIC = request.getParameter("physio_NIC");
        String customer_NIC = request.getParameter("customer_NIC");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String status = request.getParameter("status");
        
        
 
        Date current = new Date();
        String txtDate=new SimpleDateFormat("yyyy-MM-dd").format(current);
        System.out.print(txtDate);
        System.out.println(date);
        if (txtDate.compareTo(date) <= 0) {
        	Appointment newAppointment = new Appointment(physio_NIC,customer_NIC,date,time,status);
          
        	appointmentDAO.insertAppointment(newAppointment);
        	request.setAttribute("alertMsg", "Appointment Success");
          	response.sendRedirect("user/AppointmentListUser.jsp");
            System.out.println("after");
        }else {
        	JOptionPane.showMessageDialog(null, "Invalid Date");
        	System.out.println("earlier");
        }

        
        
    }
}
