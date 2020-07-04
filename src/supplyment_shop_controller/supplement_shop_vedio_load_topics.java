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

import supplement_shop_model.supplement_shop_get_vedio_topics;
import supplement_shop_model.supplement_shop_vedios;

/**
 * Servlet implementation class supplement_shop_vedio_load_topics
 */
@WebServlet("/supplement_shop/supplement_shop_vedio_load_topics")
public class supplement_shop_vedio_load_topics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplement_shop_vedio_load_topics() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession newsession = request.getSession();
			String company_id = (String) newsession.getAttribute("company_id");
			supplement_shop_get_vedio_topics gettopics = new supplement_shop_get_vedio_topics();
			List<supplement_shop_vedios> topics = new ArrayList<supplement_shop_vedios>();
			topics= gettopics.gettopics(company_id);
			request.setAttribute("topics", topics);
			
			request.getRequestDispatcher("supplement_shop_view_vedio_list.jsp").forward(request, response);
			
			
			
			
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
