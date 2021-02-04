package g_oop2;

public interface SampleInterface {
	//인터페이스 => 상수와 추상메서드만 가질수 있음
	//부모클래스의 역할만 함
	//추상클래스보다 인터페이스를 더 자주사용
	
	//인터페이스와 모든 멤버변수는 public static final 제어자를 사용해야한다.
	public static final int NUM1 = 1;
	
	//모든 멤버변수와 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 = 2;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다.
	public abstract void method1();
	
	//모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();
}

class SampleImplement implements SampleInterface, SampleInterface2{
	//인터페이스를 상속할 때는 implements 사용
	//인터페이스는 다중상속이 가능하다.
	
	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}

interface SampleInterface2{
	void method1();
	void method3();
}