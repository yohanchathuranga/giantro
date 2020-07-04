package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supplement_shop_model.supplement_shop_product;
import supplement_shop_model.supplement_shop_update_product_details_model;

import java.util.*;



@WebServlet("/supplement_shop/supplement_shop_update_product_details")
public class supplement_shop_update_product_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public supplement_shop_update_product_details() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// supplement_shop_update_product_details_model  product_detail = new supplement_shop_update_product_details_model();
		supplement_shop_update_product_details_model update  =  new supplement_shop_update_product_details_model();
		supplement_shop_product product  = new supplement_shop_product();
		product.setProduct_id(request.getParameter("product_id"));
		//System.out.println(request.getParameter("product_id"));
		//System.out.println(product.getProduct_id());
		
		product.setProduct_name(request.getParameter("product_name"));
		//System.out.println(request.getParameter("product_name"));
		//System.out.println(request.getParameter("product_name"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		//System.out.println(request.getParameter("price"));
		product.setDiscount(Integer.parseInt(request.getParameter("discount")));
		product.set_selling_price();
		product.setDescription(request.getParameter("description"));
		

		
		boolean status = update.update_prdouct(product);
		if(status == false) {
			System.out.println("update product successfull");
			request.setAttribute("edit", product.getProduct_id());
			request.getRequestDispatcher("supplement_shop_load_products").forward(request,response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
