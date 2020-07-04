package supplyment_shop_controller;
import java.io.*;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import supplement_shop_model.supplement_shop_insert_products;
import supplement_shop_model.supplement_shop_product;
import supplement_shop_model.upload_logo;
/**
 * Servlet implementation class supplement_shop_upload_logo
 */
@WebServlet("/supplement_shop/supplement_shop_upload_logo")
public class supplement_shop_upload_logo extends HttpServlet {
	
	public supplement_shop_upload_logo() {
        super();
        // TODO Auto-generated constructor stub
    }
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
    private String filePath;
    private String filepath2;
    private int maxFileSize = 5000 * 1024;
    private int maxMemSize = 1000 * 1024;
    private File file ;
    private boolean succesfull_insert_or_not=true;
    String image_url_gloabal;

	public void init( ){
	      // Get the file location where it would be stored.
		
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Check that we have a file upload request
		 HttpSession session = request.getSession();
		 String user_id=  (String) session.getAttribute("company_id");
		 filePath = "E:\\eclipse project\\GIANTROALL\\WebContent\\images\\"; 
		 filepath2="images\\";
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      
	      response.setContentType("text/html");
	      
	      String RelPath = "E:\\eclipse project\\GIANTROALL\\WebContent\\images";
	      
	      request.setAttribute("product_add_msg", null);
	    
	       
	      

	      
	     // System.out.println(filePath);
	      if( !isMultipart ) {
	    	  request.setAttribute("product_add_msg", "no file uploaded");
	    	  request.getRequestDispatcher("supplement_shop_uplaod_logo.jsp").forward(request, response);
	      }
	  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	   
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	   
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File(RelPath));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	   
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try { 
	         // Parse the request to get file items.
	         List fileItems = upload.parseRequest(request);
	        
	         // Process the uploaded file items
	         Iterator i = fileItems.iterator();

	         int count=2;
	  
	         while ( i.hasNext () ) {
	            FileItem fi = (FileItem)i.next();
	            if ( !fi.isFormField () ) {
	               //Get the uploaded file parameters
	               String fieldName = fi.getFieldName();
	               // System.out.println("check1"+fieldName);
	               String fileName = fi.getName();
	              // System.out.println("check2"+fileName+"     ");
	               String contentType = fi.getContentType();
	              // System.out.println("check3"+contentType);
	               long sizeInBytes = fi.getSize();
	               
	               String image_new_url;
	               
	               DateFormat dateformat= new SimpleDateFormat("HH_mm_ss");
	               Date date = new Date();
	               String get_the_date = dateformat.format(date);
	               String image_url=null;
	         
	               
	               // Write the file
	               if( fileName.lastIndexOf("\\") >= 0 ) {
	            	   String string_name = fileName.substring(fileName.lastIndexOf("\\")+1);
	            	   image_url= filePath +get_the_date+string_name;
	            	   image_new_url =filepath2 +get_the_date+string_name;
	                  file = new File( image_url) ;
	                  this.image_url_gloabal=image_url;
	                
	                  
	                  
	               } else {
	            	   String string_name = fileName.substring(fileName.lastIndexOf("\\")+2);
	            	   image_url = filePath +get_the_date+string_name;
	            	   image_new_url =filepath2 +get_the_date+string_name;
	            	   	file = new File( image_url) ;
	                //  String  filePath1 = "C:\\Users\\supun chandimal\\eclipse-workspace\\GIANTROSupp\\WebContent\\images\\"; 
	                   // System.out.println(string_name);
	                    this.image_url_gloabal=image_new_url;
		                  
	                  
	               }
	             // System.out.println(image_new_url );
	               //System.out.println(file);
	               
	               
	               fi.write( file ) ;
	              
	               request.setAttribute("logo_add_msg","logo updated successfully");
	             
	            }else {
	            	
	            	
	            }
	            
	            upload_logo newone= new upload_logo();
	            succesfull_insert_or_not = newone.updatelogo(user_id,image_url_gloabal);
	         }
	         	
           	if(succesfull_insert_or_not ==false) {
	               request.setAttribute("logo_add_msg","product added successfully");
	              session.setAttribute("company_logo", image_url_gloabal);
           		  request.getRequestDispatcher("supplement_shop_upload_logo.jsp").forward(request, response);
           	}
           	
	         
	         } catch(Exception ex) {
	            System.out.println("Exception in supplement_shop_upload_logo.java"+ex);
	         }
	      }

}
