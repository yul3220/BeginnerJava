package g_oop2;

public class SampleChild extends SampleParent {
	void childMethod(){
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);//상속받은 변수
		System.out.println(method(7,13));//상속받은 메서드
	}
	
	//오버라이딩
	//=>부모클래스에서 상속받은 내용을 변경하는 것
	//super, super()
	//=>부모클래스와 자식클래스의 이름이 같을떄 부모클래스에 super를 붙여준다.
	//super()=>부모클래스의 생성자를 호출하기 위해 사용
	//★다형성 => 자주 사용됨
	
	//오버라이딩 : 상속받은 메서드의 내용을 재정의하는것
	@Override // 어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것
	int method(int a, int b){//리턴타입 메서드명 파라미터 모두 같아야 한다.
		return a * b;
	}
	//어노테이션을 통해 부모 클래스와 비교하여 오버라이딩이 됬는지 확인
	//어노테이션을 통해 메서드명과 파라미터명이 같은지 확인 , 없으면 에러가 뜨지 않음
	
	//super, super()
	int var;
	
	void test(double var){
		System.out.println(var);//지역변수=>메서드 안에서 사용되는 지역변수
		System.out.println(this.var);//인스턴스 변수
		System.out.println(super.var);//부모 클래스의 인스턴스 변수
		//super : 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될때 
	    //        둘을 구분하기 위해 사용한다.
		System.out.println(this.method(10,20));
		System.out.println(super.method(10,20));
	}
	
	SampleChild(){
		super();//부모클래스의 생성자 호출
		//super()를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
		//super() 가장 첫줄에 있어야지 컴파일 발생x
	}
	
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		//Samplechild2
		//sp = new Samplechild2();
		//Samplechild3
		//sp = new Samplechild3();
		//sp라는 변수가 여러개의 메서드를 표현할수 있다.
		//부모타입의 변수로 자식타입의 객체를 사용하는 것이 다형성이다.
		//=> 서로 상속관계에 있을때만
		
		//부모와 자식간에는 서로 형변환이 가능하다 => 다형성이 성립되는 이유
		sc = (SampleChild)sp;
		sp = (SampleParent)sc;
		//자식타입 => 부모타입 형변환은 생략할 수 있다.
		
		SampleChild sc2=(SampleChild)new SampleParent();
		//SampleParent는 2개의 멤버를 가지고 있다.
		//SampleChild는 5개의 멤버를 가지고 있다.
		//SampleChild 타입의 변수는 5개의 맴버를 사용할 수 있어야 하는데
		//SampleParent 객체는 2개의 멤버만 가지고 있다.
		//그러므로 부모타입의 객체를 자식타입으로  형변환 하는것은 에러가 발생시킨다.
		
		//SampleParent 타입의 변수로는
		//SampleChild 객체를 가지고도 2개의 멤버만 사용할 수 있다.
		sp = sc;
		System.out.println(sp.var);
		System.out.println(sp.method(10, 20));
		
	}
}//
