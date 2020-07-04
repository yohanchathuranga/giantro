package Physio_Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Physio_Beans.Appointment;
import Physio_Beans.Schedule;
import Physio_Beans.User;
import Physio_Models.AppointmentDAO;
import Physio_Models.PhysioDAO;
import Physio_Models.ScheduleDAO;

@WebServlet("/")
public class Navigator extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ScheduleDAO scheduleDAO;
    private AppointmentDAO appointmentDAO;
    private PhysioDAO physioDAO;

    public Navigator() {
        super();
        scheduleDAO = new ScheduleDAO();
        appointmentDAO = new AppointmentDAO();
        physioDAO = new PhysioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/nav1":
                    nav1(request, response); // load appointment form
                    break;
                case "/nav2":
                    nav2(request, response); // insert new Appointment

                    break;
                case "/Completed":
                    MarkAsCompletedSchedule(request, response); // delete appointment
                    break;

                default:
                    // listAppointment(request, response); //Default function load
                    break;
            }

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

    private void nav1(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String nic = request.getParameter("NIC1");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Appointment_form.jsp");
        request.setAttribute("NIC1", nic);
        dispatcher.forward(request, response);

    }

    private void nav2(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String nic = request.getParameter("NIC1");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/schedule_form.jsp");
        request.setAttribute("NIC1", nic);
        dispatcher.forward(request, response);

    }

    private void MarkAsCompletedSchedule(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int Ano = Integer.parseInt(request.getParameter("appointment_no"));
        String Status = "2";
        Appointment appointment = new Appointment(Ano, Status);

        appointmentDAO.MarkCompleted(appointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("User_appointments");
        dispatcher.forward(request, response);

    }
}
