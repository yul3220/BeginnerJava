package e_oop;

public class UserDefinedDataType {
//클래스은 여러개 있어도 상관은 없으나, public class은 하나만 있어야된다.
	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입(클래스)
		 - 데이터의 최종 진화 형태이다.(기본형 -> 배열 -> 클래스)
		 - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 - 변수와 매서드를 구성할 수 있다.
		 */

		//11.30은 변수만 설명
		//기본형타입(1개의 변수에 1개의 데이터만 저장)
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		String name;
		
		//배열(같은 타입의 데이터를 여러개 저장)]
		int[] scores;
		int sum2;
		double avg2;
		String name2;
		
		//클래스(관련된 변수를 다 묶어서 저장)
		Student student ;//변수하나로  Student클래스안에있는 변수 모두 사용가능
		student = new Student(); //객체 생성(인스턴스화)
		// => student를 사용하기 위해 메모리에 올려놓는 것
		
		student.kor = 80;
		student.eng = 90;
		student.math = 60;
		student.sum = student.kor + student.eng + student.math;
		student.avg = student.sum/3.0;
		student.name = "홍길동";
		
		System.out.println(student.name);
		System.out.println(student.avg);
	}
}

//클래스 내용을 사용하기 위해서 메모리에 올려놓은것 => 객체
class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
}