package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop_get_vedio_model;
import supplement_shop_model.supplement_shop_vedios;


@WebServlet("/supplement_shop/supplement_shop_view_vedio")
public class supplement_shop_view_vedio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public supplement_shop_view_vedio() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession newsession = request.getSession();
		String company_id = (String)newsession.getAttribute("company_id");
		
		String vedio_id=(String) request.getParameter("view");
	
		supplement_shop_get_vedio_model getvedio = new supplement_shop_get_vedio_model();
		supplement_shop_vedios vedio = new supplement_shop_vedios();
		vedio = getvedio.getvedio(vedio_id);
		request.setAttribute("vedio",vedio);
		request.getRequestDispatcher("supplement_shop_view_vedio.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
