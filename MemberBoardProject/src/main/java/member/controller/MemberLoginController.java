package member.controller;

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
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPassword");
		
		MemberVO vo = new MemberVO();
		vo.setMember_id(id);
		vo.setMember_pw(password);

		MemberService memberService = new MemberService();
		MemberVO memberInfo = memberService.checkPasswordIsTrue(vo);
		
		HttpSession session = request.getSession(true);
		
		if (memberInfo != null) {
			session.setAttribute("memberInfo", memberInfo);
			BoardService boardService = new BoardService();
			List<BoardVO> boardList = boardService.updateBoardList();
			request.setAttribute("boardList", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_view.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
			rd.forward(request, response);
		}
		

	}

}
