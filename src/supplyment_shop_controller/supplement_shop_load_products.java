package supplyment_shop_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop_get_product_list;
import supplement_shop_model.supplement_shop_product;


@WebServlet("/supplement_shop/supplement_shop_load_products")
public class supplement_shop_load_products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public supplement_shop_load_products() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user_id= (String)session.getAttribute("company_id");
		supplement_shop_get_product_list list =new supplement_shop_get_product_list();
		List<supplement_shop_product> products= new ArrayList<supplement_shop_product>();
		products= list.getproductlist(user_id);
		request.setAttribute("product_list", products);
		
		
		request.getRequestDispatcher("supplement_shop_products.jsp").forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
