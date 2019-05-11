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
	// [�ֳ����̼� ���] ������ ����
	//------------------------------------------------------------------
	// �Ű������� ���� Ÿ���� ���� ������ ���ڷ� ������ ��
	// @Autowired(required=false) // �������� ������ �����ϸ� NULL���� �ְ� ���� �����ϵ��� ó��
	
//	public Car(Tire tire) {
//		System.out.println("�����ڸ� ���� ����");
//		this.tire = tire;
//	}
	
	
//	public void setTire(Tire tire) {
//		System.out.println("�����ڸ� ���� ����");
//		this.tire = tire;
//	}
	
	public void drive() {
		System.out.println(tire.getTire() + "�� �����մϴ�.");
	}
	
}
