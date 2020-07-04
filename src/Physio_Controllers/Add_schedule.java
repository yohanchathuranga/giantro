package Physio_Controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Physio_Beans.Schedule;
import Physio_Models.ScheduleDAO;

@MultipartConfig
@WebServlet("/Add_schedule")
public class Add_schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO scheduleDAO;

	public Add_schedule() {
		super();
		scheduleDAO = new ScheduleDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			insertSchedule(request, response);
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

	private void insertSchedule(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// int schedule_no=Integer.parseInt(request.getParameter("Schedule_No"));-
		String physio_NIC = request.getParameter("Physio_NIC");
		String customer_NIC = request.getParameter("Customer_NIC");
		String age = request.getParameter("Age");
		String height = request.getParameter("Height");
		String weight = request.getParameter("Weight");
		// String photo = request.getParameter("Photo");
		File file = new File(
				"E:\\eclipse project\\GIANTROALL\\WebContent\\Resources\\physio\\uploaded-files\\" + customer_NIC);
		file.mkdir();
		Part filePart = request.getPart("Photo");

		// get the InputStream to store the file somewhere
		InputStream fileInputStream = filePart.getInputStream();

		// for example, you can copy the uploaded file to the server
		// note that you probably don't want to do this in real life!
		// upload it to a file host like S3 or GCS instead
		// File fileToSave = new File("giantro/WebContent/uploaded-files/" +
		// filePart.getSubmittedFileName());
		Path destpath = Paths.get("E:\\eclipse project\\GIANTROALL\\WebContent\\Resources\\physio\\uploaded-files"
				+ "\\" + customer_NIC + "\\" + filePart.getSubmittedFileName());
		Files.copy(fileInputStream, destpath, StandardCopyOption.REPLACE_EXISTING);

		// get the URL of the uploaded file
		String fileUrl = "Resources/physio/uploaded-files" + "/" + customer_NIC + "/" + filePart.getSubmittedFileName();
		System.out.println(filePart.getSubmittedFileName());
		// You can get other form data too

		Schedule newSchedule = new Schedule(physio_NIC, customer_NIC, age, height, weight, fileUrl);

		scheduleDAO.insertSchedule(newSchedule);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/scheduleList.jsp");
		dispatcher.forward(request, response);

	}

}
