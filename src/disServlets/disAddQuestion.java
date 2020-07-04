package disServlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import disBeans.disAddQuestionBean;
import disModels.disModel;

/**
 * Servlet implementation class disAddQuestion
 */
@WebServlet("/Discussion/disAddQuestion")
public class disAddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public disAddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String topic = request.getParameter("topic");
		String category = request.getParameter("category");
		String question = request.getParameter("question");
		//HttpSession session = request.getSession();
		HttpSession httpSession = request.getSession();
    	String nic=(String) httpSession.getAttribute("NIC");
		
		disAddQuestionBean disBean = new disAddQuestionBean(nic,topic,category,question);
		disModel model = new disModel();
		
		int result = 0;
		try {
			result = model.addQuestion(disBean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 0) {
			request.setAttribute("message", "1");
		}else {
			request.setAttribute("message", "2");
		}
		
		request.getRequestDispatcher("disMessage.jsp").forward(request, response);

	}

}
