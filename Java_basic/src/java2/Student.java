package java2;

public class Student {
	
	//field
	private String name;
	private int age;
	
	//constructor
	public Student() {
		
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//setter & getter => private field로 잡았으므로
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//method
	@Override
	public boolean equals(Object obj) {
		//인자로 들어온 instance가 equals method를 갖고 있는
		//instance의 내용과 같으면 같은 객체로 판별하는 로직 작성
		//당연히 처음은 두 인스턴스의 타입을 똑같이 맞춰줘야 함
		//원래는 들어온 인스턴스가 캐스팅이 가능한지 검증하는 과정이 먼저 필요
		Student target = (Student)obj; //새로 들어온 인스턴스의 타입을 Student 객체로 형변환
		boolean result = false;
		if(this.getName() == target.getName() && 
				this.getAge() == target.getAge()) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		//문자열로 변환하는 함수 새로 작성해주기
		return this.getName() + " : " + this.getAge();
	}
}

class MyTest {
	
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 20);
		Student s2 = new Student("홍길동", 20);
		
		// = 와 equal 연산자 모두 변수 안의 값이 같은지 direct로 확인 => 메모리 주소값 비교 
		//다른 의미로 정의하기 위해 equals 메서드를 오버라이딩해서 사용
		boolean result = s1 == s2;
		
		System.out.println(s1); //메모리 시작 주소(의 해시코드) 출력
		System.out.println(s1.equals(s2)); //true
	}
}
