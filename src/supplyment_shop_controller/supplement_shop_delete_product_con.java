package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop_delete_product;


@WebServlet("/supplement_shop/supplement_shop_delete_product_con")
public class supplement_shop_delete_product_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public supplement_shop_delete_product_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		supplement_shop_delete_product delete_product = new supplement_shop_delete_product();
		boolean successfull_delete= true;
		
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("company_id");
		String product_id= request.getParameter("delete");
		successfull_delete = delete_product.delete_product(user_id, product_id);
		if(successfull_delete==false) {
			
			request.getRequestDispatcher("supplement_shop_load_products").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
