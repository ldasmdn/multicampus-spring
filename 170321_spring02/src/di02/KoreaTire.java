package di02;

import org.springframework.stereotype.Component;

// ���� Ÿ���� 2�� �̻��̸� �������̶� ������ Ȯ���ؼ� �־� ��
// �� ��� �� ���̵� ������ ���缭 ����ϸ� ��
// @Component
@Component
public class KoreaTire implements Tire {
	
	public String getTire() { return "����Ÿ�̾�"; }
	
}
