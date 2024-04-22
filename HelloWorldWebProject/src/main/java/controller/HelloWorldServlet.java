package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */

//자바 Servlet
//웹에서 클라이언트가 직접적으로 호출하는 자바 프로그램
//controller의 역할을 수행해요. 즉, 클라이언트의 요청을 받아서
//로직을 처리하는 service의 연결시키는 역할을 수행
//@WebServlet annotation은 해당 클래스가 servlet임을 나타내고 그 안에 해당 서블릿의 url mapping을 명시함
//예전에는 이 설정을 web.xml(deployment descriptor)을 통해서 설정했어요
//편하지만 관리는 힘들어요!
@WebServlet("/first")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        //일반 생성자
        //일반적인 경우에는 이 생성자를 이용해서 객체를 초기화하는데
        //서블릿의 경우에는 생성자 말고 init()에서 초기화를 진행
    }

	@Override
	public void init() throws ServletException {
		// 서블릿의 초기화 작업을 진행
		super.init();
	}
	//service는 기본적으로 overriding을 하지 않아요
	//왜냐하면 이 method는 이미 하는 일이 있어요
	//클라이언트의 request 방법을 알아내서 doGet, doPost를 호출하는 작업을 이 service가 이미 하고 있어요
	//그렇기 때문에 특별한 경우가 아니면 굳이 overriding X
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(req, resp);
//	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트로부터 입력을 받아서 로직처리 후 그 결과를 클라이언트에게 돌려주면 돼요
		//처음이니까 입력은 받지 않아요
		//로직처리도 하지 않을거에요
		//클라이언트에게 출력처리만 해볼거에요
		//doGet()의 두 개의 parameter가 전달되는데 하나는 클라이언트의 요청객체이고
		//하나는 응답객체로 이 응답객체를 이용해서 클라이언트에게 response 처리를 하게돼요
		//제일 먼저 할 일은 클라이언트에게 데이터를 전달하기 위해서 stream을 열어요
		//stream을 만들기 이전에 인코딩 방식을 설정해야 해요
		//이번에는 전달된 데이터를 받아보아요
		//당연히 Query String으로 전달된 데이터는 무조건 문자열로 전달돼요!
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//클라이언트에게 전달하는 데이터는 거의 예외없이 HTML이에요
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>이것은 소리없는 아우성</h1>");
		out.println("<h2>" + name + "</h2>");
		out.println("<h2>" + age + "</h2>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
