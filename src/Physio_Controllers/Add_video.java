package Physio_Controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Physio_Beans.Schedule;
import Physio_Beans.Video;
import Physio_Models.ScheduleDAO;
import Physio_Models.VideoDAO;
import supplement_shop_model.supplement_shop_insert_vedios;
import supplement_shop_model.supplement_shop_vedios;

@MultipartConfig
@WebServlet("/Add_video")
public class Add_video extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Add_video() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean isMultipart;
	private String filePath;
	private String filepath2;
	private int maxFileSize = 500000 * 1024;
	private int maxMemSize = 10000 * 1024;
	private File file;
	private boolean succesfull_insert_or_not = true;

	public void init() {
		// Get the file location where it would be stored.

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Check that we have a file upload request
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("company_id");
		filePath = "C:\\Users\\supun chandimal\\eclipse-workspace\\GIANTROSupp\\WebContent\\images\\";
		filepath2 = "images\\";
		isMultipart = ServletFileUpload.isMultipartContent(request);

		response.setContentType("text/html");

		// java.io.PrintWriter out = response.getWriter( );

		String RelPath = "C:\\Users\\supun chandimal\\eclipse-workspace\\GIANTROSupp\\WebContent\\images";

		request.setAttribute("product_add_msg", null);

		supplement_shop_vedios vedio = new supplement_shop_vedios();

		// System.out.println(filePath);
		if (!isMultipart) {
			request.setAttribute("product_add_msg", "no file uploaded");
			System.out.println("no vedios");
			request.getRequestDispatcher("supplement_shop_add_vedios.jsp").forward(request, response);
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(RelPath));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			int count = 2;

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();

				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					System.out.println("check veido fieldName");
					// System.out.println("check1"+fieldName);
					String fileName = fi.getName();
					// System.out.println("check2"+fileName+" ");
					String contentType = fi.getContentType();
					// System.out.println("check3"+contentType);
					long sizeInBytes = fi.getSize();

					DateFormat dateformat = new SimpleDateFormat("HH_mm_ss");
					Date date = new Date();
					String get_the_date = dateformat.format(date);
					String vedio_url = null;
					String new_Vedio_url;

					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						String string_name = fileName.substring(fileName.lastIndexOf("\\") + 1);
						vedio_url = filePath + get_the_date + string_name;
						new_Vedio_url = filepath2 + get_the_date + string_name;
						file = new File(vedio_url);

					} else {
						String string_name = fileName.substring(fileName.lastIndexOf("\\") + 2);
						vedio_url = filePath + get_the_date + string_name;
						new_Vedio_url = filepath2 + get_the_date + string_name;
						file = new File(vedio_url);
						// String filePath1 = "C:\\Users\\supun
						// chandimal\\eclipse-workspace\\GIANTROSupp\\WebContent\\images\\";
						System.out.println(string_name);

					}
					// System.out.println(image_new_url );
					System.out.println(file);

					fi.write(file);
					vedio.setVedio_url(new_Vedio_url);
					System.out.println(new_Vedio_url);
					request.setAttribute("vedio_add_msg", "product added successfully");

				} else {
					String fieldName2 = fi.getFieldName();

					String value = fi.getString();

					if (count == 2) {
						vedio.setDescription(value);
						;

						count++;
					}

				}
			}
			vedio.setUser_id(user_id);
			System.out.println(vedio.getDescription());

			supplement_shop_insert_vedios insert = new supplement_shop_insert_vedios();
			succesfull_insert_or_not = insert.instert_vedios(vedio);
			if (succesfull_insert_or_not == false) {
				request.setAttribute("vedio_add_msg", "product added successfully");
				request.getRequestDispatcher("add_supplement_vedios.jsp").forward(request, response);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
