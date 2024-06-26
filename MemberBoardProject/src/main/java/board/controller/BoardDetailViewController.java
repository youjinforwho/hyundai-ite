package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import comment.service.CommentService;
import comment.vo.CommentVO;

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
		
		//board 정보
		BoardVO boardDetail = new BoardVO();
		BoardService boardService = new BoardService();
		
		boardDetail = boardService.viewBoardDetail(boardNum);
		
		//comment 정보
		CommentService commentService = new CommentService();
		List<CommentVO> commentList = commentService.findAllComments(boardNum);

		request.setAttribute("boardDetail", boardDetail);
		request.setAttribute("commentList", commentList);
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
