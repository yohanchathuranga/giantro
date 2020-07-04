package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop;
import supplement_shop_model.supplement_shop_load_details;

/**
 * Servlet implementation class supplement_shop_profile_details_load_con
 */
@WebServlet("/supplement_shop/supplement_shop_profile_details_load_con")
public class supplement_shop_profile_details_load_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplement_shop_profile_details_load_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//System.out.println("check edit profile load");
		String username= (String) session.getAttribute("username");
		supplement_shop_load_details load = new supplement_shop_load_details();
		supplement_shop shop  = new supplement_shop();
		shop= load.getdetails(username);
		
		request.setAttribute("company_id", session.getAttribute("company_id"));
		request.setAttribute("company_name",shop.getCompany_name());
		request.setAttribute("owner_name", shop.getOwnername());
		request.setAttribute("nic", shop.getNic());
		request.setAttribute("passowrd",shop.getPassword());
		request.setAttribute("phone", shop.getPhonenumber());
		//System.out.println(shop.getPhonenumber());
		request.setAttribute("email",shop.getEmail());
		//System.out.println(request.getAttribute("company_name"));
		request.getRequestDispatcher("Edit_supplement_shop_profile.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
