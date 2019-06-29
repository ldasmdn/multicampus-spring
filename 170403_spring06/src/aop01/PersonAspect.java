package aop01;

public class PersonAspect {

	//---------------------------------------
	// [공통관심사항] 시점 별로 구현할 메소드를 정의한다.
	//---------------------------------------
	
	public void doBefore() {
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	public void doAfterReturning() {
		System.out.println("불을 끄고 잔다.");
	}
	
	public void doAfterThrowing() {
		System.out.println("119에 신고한다.");
	}
	
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}
	
	public void around() {
		
	}
	
}
