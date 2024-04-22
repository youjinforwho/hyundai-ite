package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		//입력받고
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");
		
		//로직처리해서
		int result = Integer.parseInt(num1) + Integer.parseInt(num2);
		
		//출력하면 돼요
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//클라이언트에게 전달하는 데이터는 거의 예외없이 HTML이에요
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>숫자의 합은</h1>");
		out.println("<h2>" + result + "</h2>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
