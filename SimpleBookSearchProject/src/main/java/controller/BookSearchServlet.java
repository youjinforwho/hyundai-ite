package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import vo.BookVO;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/search")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("check_price");
		
		BookService service = new BookService();
		List<BookVO> list = service.searchBookByKeyword(keyword, Integer.parseInt(price));
		//출력하면 돼요
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//클라이언트에게 전달하는 데이터는 거의 예외없이 HTML이에요
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>검색결과입니다</h1>");
		out.println("<h2> 검색키워드: "+keyword+"</h2>");
		out.println("<h2> 검색가격: "+price+"</h2>");
		out.println("<ul>");
		for (int i = 0; i < list.size(); i++) {
			out.println("<li>");
			out.println(list.get(i));
			out.println("</li>");
			out.println("<br>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
