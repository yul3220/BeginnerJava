package g_oop2;

public abstract class Animal {
	
	void run(){
		System.out.println("달려간다~~~");
	}
	
	abstract void sound();
	//추상을 통해 상속받는 클래스에서 정의를 할수있게끔
	
}

class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍!!");
	}
	
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("냐옹!!");		
	}
	
}

class Chick extends Animal{
	
	@Override
	void sound() {
		System.out.println("삐약삐약!!");		
	}
	
}






















