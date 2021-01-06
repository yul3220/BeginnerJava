package e_oop;

public class JVM {

	public static void main(String[] args) {
		/*
		 * JVM(Java Virtual Machine)
		 * - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * - 운영체제 -> JVM -> 자바 프로그램
		 * - 장점 : 운영체제에 상관없이 실행할 수 있다.(JVM을 사용하기 떄문에)
		 * - 단점 : 속도가 느리다.(중간에 하나를 거쳐서 실행해야 하기 때문에)
		 * 
		 * JVM 메모리 구조(★ 3가지는 알기)
		 * - Method Area(메서드영역) : 클래스 멤버가 저장된다. => static 붙은 것들이 저장됨
		 * - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다.(현재 실행되는 메소드)
		 * - Heap : 객체가 저장된다.(생성된 객체가 저장된다)
		 * => new연산자로 생성된 객체와 배열을 저장하는 공간 / 클래스 영역에 로드된 클래스만 생성가능
		 */
		
		//1. 프로그램 실행시 main(), classVar, classMethod()가 MethodArea에 저장됨
		//=> 프로그램 실행하게 되면 static붙인것들이 메모리에 올라감
		//2. main()이 호출되어 CallStack에 저장됨
		
		System.out.println(classVar);
		//3. System클래스의 out(변수)이 MethodArea에 저장됨 / out이라는 변수는 계속 저장되어 있음
		//4. println()이 호출되어 CallStack에 저장됨
		//5. println()이 classVar를 출력 후 CallStack에서 삭제됨
		
		classMethod();
		//6. classMethod()가 호출되면 CallStack에 저장됨
		//7. instanceVar는 메모리에 존재하지 않기 때문에 사용할 수 없음
		//8. println()이 호출되어 CallStack에 저장됨
		//9. println()이 classVar를 출력 후 CallStack에서 삭제됨
		//10. classMethod()의 실행이 종료되어 CallStack에서 삭제됨
		
		JVM jvm = new JVM();//jvm은 지역변수(메인메소드가 없어질때 같이 없어짐) 
		//11. JVM객체가 Heap에 저장됨
		//12. jvm변수가 CallStack에 생성되고, JVM객체의 주소가 저장됨
		
		System.out.println(jvm.instanceVar);
		//13. println()이 호출되어 CallStack에 저장됨
		//14. println()이 instanceVar를 출력 후 CallStack에서 삭제됨
		
		jvm.instanceMethod();
		//15. instanceMethod()가 호출되어 CallStack에 저장됨
		//16. println()이 호출되어 CallStack에 저장됨
		//17. println()이 instanceVar를 출력 후 CallStack에서 삭제됨
		//18. println()이 호출되어 CallStack에 저장됨
		//19. println()이 classVar를 출력 후 CallStack에서 삭제됨
		//20. instanceMethod()의 실행이 종료되어 CallStack에서 삭제됨
		
		jvm = null;
		//21. jvm변수에 null이 저장됨
		//22. 어디에서도 주소를 참조하지 않는 JVM객체는 GarbageCollector에 의해 삭제됨
		
		//23. main()이 실행이 종료되어 CallStack에서 삭제됨
		//24. 프로그램이 종료되고 MethodArea의 데이터가 삭제됨 
	}
	
	int instanceVar;
	static int classVar;
	
	void instanceMethod(){
		System.out.println(instanceVar);
		System.out.println(classVar);
	}
	
	static void classMethod(){//프로그램이 시작과 동시에 메모리에 올라감
		//System.out.println(new JVM().instanceVar);=> 객체를 생성한 경우에는 사용 가능
		//System.out.println(instanceVar); // 아직 메모리에 올라가지 않은 상태(객체 생성을 하지 않았기 때문에)
		System.out.println(classVar);
	}
	
	
	
}


