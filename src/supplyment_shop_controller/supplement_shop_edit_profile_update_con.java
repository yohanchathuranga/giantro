package supplyment_shop_controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import supplement_shop_model.supplement_shop;
import supplement_shop_model.supplement_shop_update_class;

/**
 * Servlet implementation class supplement_shop_edit_profile_update_con
 */
@WebServlet("/supplement_shop/supplement_shop_edit_profile_update_con")
public class supplement_shop_edit_profile_update_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplement_shop_edit_profile_update_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500*1024;
	private int maxMemSize = 10*1024;
	private File file;
	private boolean succesfull_insert_or_not = true;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession newsession= request.getSession();
		supplement_shop shop = new supplement_shop();
		supplement_shop_update_class update= new supplement_shop_update_class();
		boolean status =true;
		shop.setCompany_id(newsession.getAttribute("company_id").toString());
		
		
		
		shop.setCompany_name(request.getParameter("company_name"));
		//System.out.println(shop.getCompany_name()+"=company name");
		newsession.setAttribute("username", shop.getCompany_name());
		shop.setNic(request.getParameter("owner_id"));
		//System.out.println(shop.getNic()+"=owner_id");
		
		shop.setOwnername(request.getParameter("owner_name"));
		//System.out.println(shop.getOwnername()+"=owner_nmae");
		shop.setPassword(request.getParameter("password"));
		//System.out.println(shop.getPassword()+"=password");
		shop.setPhonenumber(request.getParameter("phone"));
		//System.out.println(shop.getPhonenumber()+"=phone number");
		
		
		status =update.update(shop);
		
		if(status==false) {
			request.setAttribute("update_msg","update sccessesfull");
			request.getRequestDispatcher("supplement_shop_profile_details_load_con").forward(request, response);
			//System.out.println("we are good in update");
		}else {
			//System.out.println("there is error in update!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
