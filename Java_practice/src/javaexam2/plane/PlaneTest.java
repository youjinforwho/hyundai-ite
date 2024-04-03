package javaexam2.plane;

public class PlaneTest {
	public static void main(String[] args) {
		Airplane air = new Airplane("L747", 1000);
		Cargoplane cargo = new Cargoplane("C40", 1000);
		air.flight(100);
		cargo.flight(100);
		System.out.println(air.getPlaneName() +" "+air.getFuelSize());
		System.out.println(cargo.getPlaneName() +" "+ cargo.getFuelSize());	
		air.refuel(200);
		cargo.refuel(200);
		System.out.println(air.getPlaneName() +" "+ air.getFuelSize());
		System.out.println(cargo.getPlaneName() +" "+ cargo.getFuelSize());
	}
}
