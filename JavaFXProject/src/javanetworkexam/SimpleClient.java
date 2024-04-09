package javanetworkexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) throws Exception {
		//클라이언트는 능동적으로 서버 프로세서(ServerSocket)에 접속을 시도함
		//서버에게 본인의 IP와 Port를 알려줘야 함
		//접속 방법? -> 자바가 제공해주는 Socket이라는 객체 사용
		//IP는 당연히 목적지의 IP 주소를 넣어야 함
		//지금은 서버 프로그램이 같은 컴퓨터에 있기 때문에 IP 주소를 현재 수행되고 있는 컴퓨터를 지칭하는 특별한 IP(127.0.0.1, IP에 할당된 문자열은 localhost) 주소를 사용
		//접속 시도 후 접속에 성공하면 진짜 객체가 생성됨
		//접속 실패 시 null이 반환됨
		Socket s = new Socket("localhost", 5555);
		System.out.println("접속 성공성공");
		
		//서버에서 보낸 데이터 받기
		InputStreamReader isr = new InputStreamReader(s.getInputStream()); //InputStream을 얻어냄 -> 조금 더 좋은 inputstream으로 확장
		BufferedReader br = new BufferedReader(isr);
		String msg = br.readLine(); //한 줄을 받겠다는 의미
		System.out.println(msg);
	}
}