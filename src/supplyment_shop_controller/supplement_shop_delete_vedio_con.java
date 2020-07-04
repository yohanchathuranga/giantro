package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop_delete_vedio;


@WebServlet("/supplement_shop/supplement_shop_delete_vedio_con")
public class supplement_shop_delete_vedio_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public supplement_shop_delete_vedio_con() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession newsession = request.getSession();
		String user_id = (String)newsession.getAttribute("company_id");
		supplement_shop_delete_vedio delete_vedio = new supplement_shop_delete_vedio();
		boolean success_or_not = true;
		String vedio_id= request.getParameter("delete");
		success_or_not= delete_vedio.deletevedio(user_id, vedio_id);
		if(success_or_not==false) {
		
		request.getRequestDispatcher("supplement_shop_vedio_load_topics").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
