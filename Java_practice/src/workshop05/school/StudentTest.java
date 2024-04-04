package workshop05.school;

public class StudentTest {
	public static void main(String[] args) {
		double avg_age = 0;
		double avg_height = 0;
		double avg_weight = 0;
		
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		
		for (Student s : studentArray) {
			System.out.println(s.getName() +"\t"+ s.getAge() +"\t"+ s.getHeight() +"\t"+ s.getWeight());
			avg_age += s.getAge();
			avg_height += s.getHeight();
			avg_weight += s.getWeight();
		}
		
		int student_num = studentArray.length;
		System.out.printf("나이의 평균: %.2f\n", avg_age / student_num);
		System.out.printf("신장의 평균: %.2f\n", avg_height / student_num);
		System.out.printf("몸무게의 평균: %.2f\n", avg_weight / student_num);
	}
}
