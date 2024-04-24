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
 * Servlet implementation class BoardContentDeleteController
 */
@WebServlet("/delete")
public class BoardContentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardContentDeleteController() {
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
		
		if (memberId.getMember_id().equals(boardId)) {
			int ifBoardIsDeleted = 0;
			
			ifBoardIsDeleted = service.deleteBoardContent(boardNum);
			if (ifBoardIsDeleted != 0) System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 수 없습니다.");
		}
		
		List<BoardVO> boardList = service.updateBoardList();
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
