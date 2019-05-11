package di02;

import org.springframework.stereotype.Component;

// 같은 타입이 2개 이상이면 변수명이라도 같은지 확인해서 넣어 줌
// 빈 등록 시 아이디를 변수명에 맞춰서 등록하면 됨
// @Component
@Component
public class KoreaTire implements Tire {
	
	public String getTire() { return "국산타이어"; }
	
}
