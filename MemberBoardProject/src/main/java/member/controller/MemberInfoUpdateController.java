package member.controller;

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
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberInfoUpdateController
 */
@WebServlet("/memberupdate")
public class MemberInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoUpdateController() {
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
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		String memberGender = request.getParameter("memberGender");
		MemberVO memberInfo = new MemberVO(memberId, memberPw, memberName, memberAge, memberGender, "N");
		MemberService service = new MemberService();

		int updateCheck = service.updateMemberProfile(memberInfo);
		if (updateCheck != 0) {
			System.out.println("성공적으로 수정되었어요!");
		} else {
			System.out.println("수정 실패 ...");
		}
		session.setAttribute("memberInfo", memberInfo);
		RequestDispatcher rd = request.getRequestDispatcher("/member/member_profile.jsp");
		rd.forward(request, response);
	}

}
