package e_oop;

import java.util.Arrays;


public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
		 - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */

		SampleClass sc = new SampleClass();//클래스를 사용하기 위해 객체 생성 , new사용
		//샘플클래스가 메모리에 올라가고, 메모리에 저장된 주소를 반환한다.
		//대부분은 변수에 저장
		
		System.out.println(sc.field);
		
		sc.method1();
		String returnValue = sc.method2(5);//리턴값이 있어서 변수를 만들어야 함
		System.out.println(returnValue);
		
		sc.flowTest1();
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456+654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
		Calculator cal = new Calculator();
		double result = 0;
		
		result = cal.add(123456, 654321);
		System.out.println("1. 123456+654321 = "+result);
		
		result = cal.mul(result, 123456);
		System.out.println("2. 1번의 결과값 * 123456 = "+result);
		
		result = cal.div(result, 123456);
		System.out.println("3. 2번의 결과값 / 123456 = "+result);
		
		result = cal.sub(result, 654321);
		System.out.println("4. 3번의 결과값 - 654321 = "+result);
		
		result = cal.remainder(result, 123456);
		System.out.println("5. 4번의 결과값 % 123456 = "+result);
		
		/*
		 * 어떤 대상을 잡아 클래스를 만들어주세요.
		 * 메서드의 내용은 구체적이지 않아도 괜찮습니다.
		 * 파라미터와 리턴타입 위주로 만들어주세요.
		 * 클래스에 메서드를 만들어보면서 파라미터와 리턴타입을 생각해보는것이 중요합니다.
		 * 만들어진 클래스를 main메서드에서 사용해주세요.
		 * */
		
		Shoppingmall shopping = new Shoppingmall();
		String[] order = shopping.make_order();
		System.out.println(Arrays.toString(order));
		shopping.take_order(order);
		
		String[] product = {"옷->후드티","악세사리->목걸이","신발->운동화"};
		shopping.find_prod(product);
		shopping.delivery(order);
		System.out.println("배송이 완료되었습니다.");
	}
}
