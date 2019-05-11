package di01;

import di01.Tire;

public class Car {

	//-----------------------------------------------------------
	// tire�� ��ü�� �����ϴ� ���
	//-----------------------------------------------------------
	// 1. �̱��� ��Ÿ�� (���� new ȣ�� ����)
	// 2. �����ڿ��� new ȣ�� ����
	// 3. ��ü�� �����ڿ��� �ޱ� ---> ������ ����
	// 4. ��ü�� �����ڿ��� �ޱ� ---> ������ ����
	private Tire tire;
	
	public Car(Tire tire) {
		System.out.println("�����ڸ� ���� ����");
		this.tire = tire;
	}
	
//	public void setTire(Tire tire) {
//		System.out.println("�����ڸ� ���� ����");
//		this.tire = tire;
//	}
	
	public void drive() {
		System.out.println(tire.getTire() + "�� �����մϴ�.");
	}
	
}
