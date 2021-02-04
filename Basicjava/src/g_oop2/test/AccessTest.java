package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier{

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		System.out.println(am.publicVar);
		am.publicMethod();
		//접근제한이 없기때문에 다른클래스, 다른패키지에서도 모두 사용가능ㄴ
		
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
		// => 다른 패키지에 있기 때문에 사용불가,같은 패키지가 아니라도 상속받는 경우 사용가능

//		System.out.println(am.defaultVar);
//		am.defaultMethod();//다른 패키지에 있기 때문에 사용불가
		
		//System.out.println(am.privateVar);
		//am.privateMethod();
		//같은 클래스안에서만 사용가능하기때문에, 컴파일 오류 발생
		
		AccessTest at = new AccessTest();
		System.out.println(at.protectedVar);
		at.protectedMethod();
		//=>상속을 받았기 때문에 자신의 것처럼 사용해야 컴파일 에러 안뜸
	}
}
