package supplyment_shop_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supplement_shop_model.supplement_shop_get_most_viewd_product;
import supplement_shop_model.supplement_shop_get_most_viewd_vedio;
import supplement_shop_model.supplement_shop_get_rank;
import supplement_shop_model.supplement_shop_get_viewd_count;
import supplement_shop_model.supplement_shop_product;
import supplement_shop_model.supplement_shop_vedios;
import supplement_shop_model.supplement_shop_viewd_count;


@WebServlet("/supplement_shop/supplement_shop_dashboard_con")
public class supplement_shop_dashboard_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public supplement_shop_dashboard_con() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession newsession = request.getSession();
			String company_id = (String )newsession.getAttribute("company_id"); 
		
			supplement_shop_viewd_count count_for_each_month= new supplement_shop_viewd_count();
			supplement_shop_get_viewd_count getcount= new  supplement_shop_get_viewd_count();
			supplement_shop_get_most_viewd_product getmostviewdproduct = new supplement_shop_get_most_viewd_product();
			supplement_shop_product mostviewdproduct= new supplement_shop_product();
			supplement_shop_get_most_viewd_vedio getmostviewdvedio= new supplement_shop_get_most_viewd_vedio();
			supplement_shop_vedios mostviewdvedio = new  supplement_shop_vedios();
			supplement_shop_get_rank getrank =new supplement_shop_get_rank();
			String rank= getrank.getrank(company_id);
			
			count_for_each_month = getcount.getcount(company_id);
			mostviewdproduct = getmostviewdproduct.getproduct(company_id);
			mostviewdvedio= getmostviewdvedio.getvedio(company_id);
			
			request.setAttribute("mostviewdproduct", mostviewdproduct);
			request.setAttribute("mostviewdvedio", mostviewdvedio);
			request.setAttribute("rank", rank);
			request.setAttribute("viewd_count_for_each_month", count_for_each_month);
			request.getRequestDispatcher("supplement_shop_profile.jsp").forward(request, response);
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
