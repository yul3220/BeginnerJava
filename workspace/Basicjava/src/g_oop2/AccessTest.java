package g_oop2;

public class AccessTest {

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMethod();
		
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
		//System.out.println(am.privateVar);
		//am.privateMethod();
		//같은 클래스안에서만 사용가능하기때문에, 컴파일 오류 발생
	}
}
