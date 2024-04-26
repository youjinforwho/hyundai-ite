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
 * Servlet implementation class MemberJoinService
 */
@WebServlet("/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
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
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");

		MemberVO memberInfo = new MemberVO(memberId, password, firstName+lastName, age, gender, "N");
		MemberService service = new MemberService();
		int updateCheck = service.assignUserToMember(memberInfo);
		
		BoardService boardService = new BoardService();
		List<BoardVO> boardList = boardService.updateBoardList();
		request.setAttribute("boardList", boardList);
		
		HttpSession session = request.getSession(true);
		if (updateCheck != 0) {
			session.setAttribute("memberInfo", memberInfo);
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/board/board_view.jsp");
		rd.forward(request, response);
		
	}

}
