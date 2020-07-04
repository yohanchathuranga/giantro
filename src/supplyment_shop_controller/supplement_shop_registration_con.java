package supplyment_shop_controller;
import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supplement_shop_model.*;



/**
 * Servlet implementation class supplement_shop_registration_con
 */
@WebServlet("/supplement_shop/supplement_shop_registration_con")
public class supplement_shop_registration_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplement_shop_registration_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		supplement_shop_registration register= new supplement_shop_registration();
		supplement_shop shop = new supplement_shop();
		
		
		shop.setCompany_name(request.getParameter("company_name"));
		shop.setPassword(setPassword(request.getParameter("password1")));
		shop.setEmail(request.getParameter("email"));
		shop.setNic(request.getParameter("nic"));
		shop.setOwnername(request.getParameter("owner_name"));
		shop.setPhonenumber(request.getParameter("phone"));
		String password1= request.getParameter("password1");
		String password2= request.getParameter("password2");
		
		if(!password1.equals(password2)) {
			request.setAttribute("error_msg_reg", "password is incorrect check again");
			request.setAttribute("company_name", shop.getCompany_name());
			request.setAttribute("email",shop.getEmail());
			request.setAttribute("nic", shop.getNic());
			request.setAttribute("phone", shop.getPhonenumber());
			request.setAttribute("owner_name",shop.getOwnername());
			request.getRequestDispatcher("supplement_shop_registration.jsp").forward(request,response);;
		}else {
		
				boolean status;
				status = register.register(shop);
				register.set_viewd_count(shop.getCompany_name(),shop.getPassword());
				if(status==false) {
					//System.out.println("register successfull");
					request.setAttribute("successfull_msg","successfully registerd! please login");
					request.getRequestDispatcher("supplement_shop_login.jsp").forward(request,response);
				}else {
					System.out.println("unsuccessfull");
				}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String setPassword(String password) {
		try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(password.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();
	        String password1;

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        
	        password1=hexString.toString();
	        System.out.println("encrypted password is"+password1);
	        return password1;
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}

}
