package g_oop2;

public abstract class SampleAbstractParent {
	
	void method(){
		
	}
	
	//추상메서드 => 선언부가 있고 구현부는 없는 메서드
	//추상메서드를 사용하기 위해서는 클래스도 추상클래스여야한다.
	//객체생성을 할수없음 => 내용이 없기 때문에
	//부모클래스의 역할을 한다
	//추상클래스를 사용하는 경우가 거의 없음
	abstract void abstractMethod();
}

class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		System.out.println("추상메서드를 상속받아 내용을 만들어줌.");
	}
}