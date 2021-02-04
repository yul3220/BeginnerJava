package e_oop;

import java.util.*;
//=> 같은 패키지 안에서만 사용가능, 다른 패키지에 있는 클래스를 사용하고 싶은 경우 import사용
//* 사용시 java.util안에 있는 모든것 사용가능
//Ctrl + Shift + O;

public class SampleClass {
//클래스는 앞글자를 대문자로 만들것
	public static void main(String[] args){
		int local = 10;//지역변수 : 메서드 안에서만 사용하는 변수
 	}
	
	int field;//전역변수 : 클래스 전체 영역에서 사용하는 변수(field)
	//초기화하지 않아도 기본값으로 초기화된다.
	
	/*
	 * - 메서드 : 변수를 가지고 할 일
	 * - 선언 방법 : 리턴타입 메서드명(파라미터){ }
	 * - 파라미터(매개변수) : 실행에 필요한 정보
	 * - 리턴타입(반환타입) : 실행 후 돌려줘야하는 결과물
	 */
	
	void method1(){
		System.out.println("파라미터도 리턴타입도 없는 메서드");
		return;//메서드를 종료시킨다.(리턴타입이 없는데 사용하는 경우)
	}//void => 타입x , 돌려줄 값이 없다는 뜻
	
	String method2(int parameter){
		return parameter+ " 를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
	}
	//코카콜라를 사오라고 명령하는 경우
	//파라미터 => 무엇을 사오라고 하는지에 대한 정보
	//나에게 돌려주는 것이 리턴타입
	//리턴타입이 있는 경우 리턴이 없으면 에러가 남
 
	//flowTest1() 호출시 출력되는 문장에 번호를 붙여주세요.
	void flowTest1(){
		System.out.println("flowTest1 시작 : 1");
		flowTest3();//메서드 호출
		System.out.println("flowTest1 종료 : 6");
	}
	
	void flowTest2(){
		System.out.println("flowTest2 시작 : 3");
		System.out.println("flowTest2 종료 : 4");
	}
	
	void flowTest3(){
		System.out.println("flowTest3 시작 : 2");
		flowTest2();
		System.out.println("flowTest3 종료 : 5");
	}
}
