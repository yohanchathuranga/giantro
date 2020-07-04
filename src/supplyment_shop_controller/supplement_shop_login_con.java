package supplyment_shop_controller;
import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.*;


@WebServlet("/supplement_shop/supplement_shop_login_con")
public class supplement_shop_login_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public supplement_shop_login_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username= request.getParameter("username");
		String password = setPassword(request.getParameter("pass"));
		//System.out.println(username+password);
		supplement_shop user = null;
		supplement_shop_login_class getone = new supplement_shop_login_class();
	
		if(getone.is_valid(username, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("company_id", getone.get_id(username, password));
			session.setAttribute("company_logo",getone.get_log_url(username, password));
			response.sendRedirect("supplement_shop_dashboard_con");
		}else {
			request.setAttribute("error", "username or password is wrong!");
			request.getRequestDispatcher("supplement_shop_login.jsp").forward(request, response);
		}
		
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
	        //System.out.println("encrypted password is"+password1);
	        return password1;
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}

}
