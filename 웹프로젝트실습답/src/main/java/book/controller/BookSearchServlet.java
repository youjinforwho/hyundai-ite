package book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookService;
import book.vo.BookVO;

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
		//1. 입력받고(Controller의 역할)
		//	 일반적으로 입력을 받아서 VO로 만들어요
		// 	 Post방식으로 한글이 전달될 때 Encoding처리를 해줘야 함
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		BookVO vo = new BookVO();
		vo.setBtitle(keyword);
		vo.setBprice(Integer.parseInt(price));
		//2. 로직처리해서(Service에게 위임)
		BookService service = new BookService();
		List<BookVO> list = service.getBooksByKeyword(vo);
		
		//3. 결과 출력
		//	 서비스로부터 결과를 받아서(일반적으로 VO나 List<VO>의 형태
		//   Servlet(Controller)가 출력을 담당하지 않고
		//   View의 역할을 수행하는 JSP에게 결과데이터를 넘겨줘요
		//   JSP(View)가 클라이언트에게 결과를 출력!
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>검색결과입니다</h1>");
		out.println("<h2> 검색키워드: "+keyword+"</h2>");
		out.println("<h2> 검색가격: "+price+"</h2>");
		out.println("<ul>");
		for (BookVO b: list) {
			out.println("<li>"+ b +"</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
