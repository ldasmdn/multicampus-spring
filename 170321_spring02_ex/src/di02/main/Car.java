package di02.main;

import di02.tire.Tire;

public class Car {

	//-----------------------------------------------------------
	// tire에 객체를 주입하는 방법
	//-----------------------------------------------------------
	// 1. 싱글턴 스타일 (직접 new 호출 생성)
	// 2. 생성자에서 new 호출 생성
	// 3. 객체를 생성자에서 받기 ---> 생성자 주입
	// 4. 객체를 설정자에서 받기 ---> 설정자 주입
	private Tire tire;
	
	public Car() {
		
	}
	
	public Car(Tire tire) {
		System.out.println("생성자를 통한 주입");
		this.tire = tire;
	}
	
	public void drive() {
		System.out.println(tire.getTire() + "로 주행합니다.");
	}
	
}
