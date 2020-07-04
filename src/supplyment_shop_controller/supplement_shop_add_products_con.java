
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


@WebServlet("/supplement_shop/supplement_shop_add_products_con")

public class supplement_shop_add_products_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
    public supplement_shop_add_products_con () {
        super();
        // TODO Auto-generated constructor stub
    }


	
    
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 500 * 1024;
    private int maxMemSize = 10 * 1024;
    private File file ;
    private boolean succesfull_insert_or_not=true;
    private String filepath2;
    

	public void init( ){
	      // Get the file location where it would be stored.
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:55 ").append(request.getContextPath());
		
	}

	
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
		      
		      supplement_shop_product product = new supplement_shop_product();
		      
		     // supplement_shop_get_next_product_id next_id= new supplement_shop_get_next_product_id();
		      
		      
		       
		      

		      
		     // System.out.println(filePath);
		      if( !isMultipart ) {
		    	  request.setAttribute("product_add_msg", "no file uploaded");
		    	  request.getRequestDispatcher("add_supplement_product.jsp").forward(request, response);
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
		            	   image_new_url= filepath2+get_the_date+string_name;
		                  file = new File( image_url) ;
		                   
		                
		                  
		                  
		               } else {
		            	   String string_name = fileName.substring(fileName.lastIndexOf("\\")+2);
		            	   image_url = filePath + get_the_date+string_name;
		            	   	file = new File( image_url) ;
		                //  String  filePath1 = "C:\\Users\\supun chandimal\\eclipse-workspace\\GIANTROSupp\\WebContent\\images\\"; 
		            	   	image_new_url= filepath2+get_the_date+string_name;
		                    System.out.println(string_name);
		                  
			                  
		                  
		               }
		             // System.out.println(image_new_url );
		               System.out.println(file);
		               
		               
		               fi.write(file) ;
		               product.setImage_url(image_new_url);
		               request.setAttribute("product_add_msg","product added successfully");
		             
		            }else {
		            	String fieldName2= fi.getFieldName();
		            	
		            
			           // System.out.println(fieldName2);
			              String value = fi.getString();
			              
			            // System.out.println(value);
			            
			                  if(count==2) {
			                	  product.setProduct_name(value);
			                	//  System.out.println(fieldName2);
			                	  count++;
			                  }else if(count==3) {
			                	  product.setDiscount(Integer.parseInt(value));
			                	 // System.out.println(fieldName2);
			                	  count++;
			                  }else if(count==4) {
			                	  product.setPrice(Integer.parseInt(value));
			                	 // System.out.println(fieldName2);
			                	  count++;
			                  }else if(count==5) {
			            	 	product.setDescription(value);
			            	 	//System.out.println(fieldName2);
			            	 	count++;
			                  }else if(count==6){
			                	  product.setDescription(value);
				            	 //System.out.println(fieldName2);
				            	  count++;
			                  }
		            	
		            }
		         }
		         	product.setUser_id(user_id);
		         	product.set_selling_price();
		           
	            	supplement_shop_insert_products insert = new supplement_shop_insert_products();
	            	succesfull_insert_or_not= insert.insert_products(product);
	            	if(succesfull_insert_or_not ==false) {
	 	               request.setAttribute("product_add_msg","product added successfully");
	            		  request.getRequestDispatcher("add_supplement_product.jsp").forward(request, response);
	            	}
	            	
		         
		         } catch(Exception ex) {
		            System.out.println("Exception in supplement_shop_add_products_con.java"+ex);
		         }
		      }
}
	



		    