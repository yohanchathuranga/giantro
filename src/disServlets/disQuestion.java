package disServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import disModels.disModel;

/**
 * Servlet implementation class disQuestion
 */
@WebServlet("/Discussion/disQuestion")
public class disQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public disQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qId = request.getParameter("qID");
		disModel model = new disModel();
		ResultSet rsQ = null;
		try {
			rsQ = model.question(qId);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rsR = null;
		try {
			rsR = model.replyCollect(qId);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String out = "";

		try {
			while (rsR.next()) {
				out = out + "<p>" + rsR.getString(1) + "</p>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("reply", out);
		try {
			if (rsQ.next()) {
				request.setAttribute("qno", rsQ.getString(1));
				request.setAttribute("name", rsQ.getString(2));
				request.setAttribute("topic", rsQ.getString(3));
				request.setAttribute("body", rsQ.getString(4));
				request.setAttribute("cat", rsQ.getString(5));
				request.setAttribute("date", rsQ.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("disQuestion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
