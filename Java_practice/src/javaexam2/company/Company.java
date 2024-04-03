package javaexam2.company;

import java.util.HashMap;

public class Company {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		Secretary obj1 = new Secretary("Hilery", 1, "secretary", 800);
		Sales obj2 = new Sales("Clinten", 2, "sales", 1200);
		map.put(1, obj1);
		map.put(2, obj2);
		
		obj1.incentive(100);
		obj2.incentive(100);
		map.put(1, obj1);
		map.put(2, obj2);
		
		for (int i = 0; i < map.size(); i++) {
			Employee emp = (Employee) map.get(i + 1);
			System.out.println(emp.getName());
		}
		System.out.println(obj1.getSalary() + " " + obj1.tax());
		System.out.println(obj2.getSalary() + " " + obj2.tax());
	
	}
}
