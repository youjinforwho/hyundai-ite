package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class BoardDetailViewController
 */
@WebServlet("/detail")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		int boardNum = Integer.parseInt(request.getParameter("param1"));
		
		BoardVO boardDetail = new BoardVO();
		BoardService service = new BoardService();
		
		boardDetail = service.viewBoardDetail(boardNum);
		
		request.setAttribute("boardDetail", boardDetail);
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
