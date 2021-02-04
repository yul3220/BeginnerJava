package b_operator;

public class ComparingOperation {

	public static void main(String[] args) {
		/*
		 * 비교연산자(이항연산자이기때문에 두값의 타입이 같아야한다.)
		 - <, >, <=, >=, ==, !=
		 - 문자열비교 : equals()
		 * */
		
		int x = 10;
		int y = 20;
		boolean b = x < y;//비교연산자의 연산결과는 boolean이다.
		System.out.println(b);
		
		b= x <= y-15;//산술연산 후 비교연산을 수행한다.
		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "abc";
		b = str1 == str2;//문자열의 내용이 아닌 주소를 비교한 것이다.
		System.out.println(b);
		
		//String의 내용을 비교하기 위해서는 equals()메서드를 사용한다.
		b= str1.equals(str2);//괄호안이 비교하고 싶은 변수
		System.out.println(b);
		b= !str1.equals(str2);//!는 앞에 붙여야 한다.
		System.out.println(b);
		
		//Q. 다음의 문장들을 코드로 작성해주세요
		//1.x는 y보다 작거나 같다.
		b = x <= y;
		System.out.println(b);
		//2. x+5와 y는 같다.
		b = x+5 == y;
		System.out.println(b);
		//3. y는 홀수이다.(헷갈려했음)
		b = y%2 == 1;
		System.out.println(b);
		//4. "기본형"과 "참조형"은 다르다. 
		b =!"기본형".equals("참조형");
		System.out.println(b);
	}

}
