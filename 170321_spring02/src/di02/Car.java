package di02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import di02.Tire;

@Component
@Lazy()
@Scope("prototype")
public class Car {

	 @Autowired
	 @Qualifier("koreaTire")
	private Tire tire;
	
	//------------------------------------------------------------------
	// [애노테이션 방식] 생성자 주입
	//------------------------------------------------------------------
	// 매개변수와 같은 타입의 빈을 생성자 인자로 주입해 줌
	// @Autowired(required=false) // 의존관계 설정에 실패하면 NULL값을 넣고 정상 진행하도록 처리
	
//	public Car(Tire tire) {
//		System.out.println("생성자를 통한 주입");
//		this.tire = tire;
//	}
	
	
//	public void setTire(Tire tire) {
//		System.out.println("설정자를 통한 주입");
//		this.tire = tire;
//	}
	
	public void drive() {
		System.out.println(tire.getTire() + "로 주행합니다.");
	}
	
}
