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
import member.vo.MemberVO;

/**
 * Servlet implementation class BoardUpdateCheckController
 */
@WebServlet("/check")
public class BoardUpdateCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		MemberVO memberId = (MemberVO)session.getAttribute("memberInfo");
		String boardId = request.getParameter("param1");
		int boardNum = Integer.parseInt(request.getParameter("param2"));
		
		BoardService service = new BoardService();
		BoardVO boardDetail = service.viewBoardDetail(boardNum);
		request.setAttribute("boardDetail", boardDetail);
		if (memberId.getMember_id().equals(boardId)) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_update.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("수정할 수 없습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_detail.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
