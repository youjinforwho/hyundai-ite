package java2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("신사임당");
		set.add("홍길동");
		
		//반복자 객체 생성 -> set 사용시 많이 사용함
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
