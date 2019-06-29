package proxy;

public class Test {

	public static void main(String[] args) {
		
		IPerson person = new Girl();
		PersonProxy personProxy = new PersonProxy();
		personProxy.setPerson(person);
		
		personProxy.doSomething();
		
	}
	
}