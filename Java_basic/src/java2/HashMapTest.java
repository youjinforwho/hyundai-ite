package java2;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	
	public static void main(String[] args) {
		//제네릭을 <key, value> 순서로 잡는다
		//데이터 저장시에는 put, 확인시에는 get
		Map<String, String> map = new HashMap<String, String>(); //List와 마찬가지로 상위타입-하위타입으로 정의
		map.put("1", "안녕하세요");
		map.put("2", "안녕히계세요");
		
		System.out.println(map.get("2"));
	
	}
}
