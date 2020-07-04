package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supplement_shop_model.supplement_shop_load_product_details_model;
import supplement_shop_model.supplement_shop_product;


@WebServlet("/supplement_shop/supplement_shop_load_product_details_con")
public class supplement_shop_load_product_details_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public supplement_shop_load_product_details_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("edit");
		supplement_shop_load_product_details_model getdetails= new supplement_shop_load_product_details_model();
		
		supplement_shop_product product = new supplement_shop_product();
		product = getdetails.details(user_id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("supplement_shop_update_product_details.jsp").forward(request,response);
		
		
		
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}