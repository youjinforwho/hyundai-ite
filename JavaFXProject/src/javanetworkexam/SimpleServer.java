package javanetworkexam;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class SimpleServer {
	public static void main(String[] args) throws Exception {
		//1. ServerSocket 객체를 생성 -> 임의의 포트 번호(0~65535)를 지정해줘야지 클라이언트가 해당 포트를 통해 접속할 수 있음
		//0~1023까지는 Well Known Port라고 해서 이미 용도가 정해져 있기 때문에 그 이후 값을 이용해야 함(권장, 의무X)
		//하나의 컴퓨터에서 동작하는 프로그램이 사용하는 Port 번호는 Unique해야 함
		ServerSocket serverSocket = new ServerSocket(5555); //port 번호가 conflict할 수 있는 여지가 있기 때문에 예외처리를 반드시 해줘야 함
		System.out.println("서버 소켓 객체 생성"); 
		
		Socket s = serverSocket.accept(); //일단 대기(blocking)하게 됨 until 클라이언트가 접속할 때까지 
		System.out.println("Accept가 풀렸어요"); 
		
		//이렇게 얻어진 socket에 대해서 Stream 객체를 얻어냄
		PrintWriter out = new PrintWriter(s.getOutputStream());
		out.println("서버가 전달했어요");
		
		//PrintWriter는 효율을 위해 내부 buffer를 갖고 있음
		//버퍼가 다 차거나 명시적으로 명령을 주지 않는 한 전달되지 않음 -> 명시적으로 flust를 이용해 데이터를 전달해야 함
		out.flush();

	}
}
