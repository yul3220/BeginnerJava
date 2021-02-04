package g_oop2;

public class AccessModifier {
	//public => 접근제어자
	public String publicVar = "public : 접근제한이 없음";
	protected String protectedVar = "protected : 같은패키지 + 상속받은 클래스에서 접근 가능"; 
	String defaultVar = "default : 같은패키지에서만 접근 가능"; //default는 써주지 말고, 생략하면 자동으로 default로 들어감
	private String privateVar = "private : 클래스 내에서만 접근가능" ;
	
	public void publicMethod(){
		System.out.println(publicVar);
	}
	
	protected void protectedMethod(){
		System.out.println(protectedVar);
	}
	
	void defaultMethod(){
		System.out.println(defaultVar);
	}
	
	private void privateMethod(){
		System.out.println(privateVar);
	}
	
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMethod();
		
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
		System.out.println(am.privateVar);
		am.privateMethod();
		
		Time t = new Time();
		
//		t.hour = 9;
//		t.minute = 380;
//		t.second = -30;
		//값을 변수에 직접 넣으면 값을 제한할 방법 없음, 메소드를 통해 간접적으로 넣으면 값을 제어할수있음
		//private를 통해 다른 클래스에서 접근못하게 막음
		//내가원하는 방향으로 쓰는 사람들이 입력을 안할수도 있음
		
		t.setHour(23);
		t.setMinute(58);
		t.setSecond(0);
		
		System.out.println(t.getTime());
		
		/* 접근제어자를 사용하는 이유
		 - 데이터를 보호하기 위해
		 - 사용하는데 불필요한 멤버를 숨기기 위해
		 */
		
		t.clock();
	}
}
