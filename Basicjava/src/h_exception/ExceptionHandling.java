package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		/*
		 * 에러
		 - 컴파일 에러 : 컴파일 시에 발생되는 에러(빨간줄)
		 - 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것(버그)
		 - 런타임 에러 : 실행 시에 발생되는 에러
		 
		 *런타임 에러 
		 - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 - 에러 : 프로그램 코드에 의해 수습할 수 없는 심각한 오류(처리불가)
		 - 예외 : 프로그램 코드에 의해 수습할 수 있는 다소 미약한 오류(처리가능)
		 
		 * 예외
		 - 모든 에러는 Exception 클래스의 자식 클래스이다. => 해도되구 안해도됨
		 - RuntimeException 클래스와 그 자식들은 예외처리가 강제되지 않는다.
		 - [RuntimeException 클래스와 그 자식들을 제외한]
		   Exception 클래스와 자식들은 예외처리가 강제된다.
		   => 에러가 나는 곳에서 가서 에러 해결방안을 봤을 때 try-catch가 있으면 그때만 한다는 뜻(강제된다는 뜻의 의미)
		  
		 * 예외처리(try-catch)
		 - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지할 수 있다.
		 - try {} catch(Exception e) {} => {}와 ()안의 파라미터가 일치하면 실행
		 - try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다
		 - catch의 ()안에는 처리할 예외를 지정해줄 수있다.
		 - 여러 종류의 예외를 처리할 수 있도록 catch는 하나 이상 올 수 있다.
		 - 발생한 예외와 일치하는 catch 블럭안의 내용이 수행된 후 try-catch를 빠져나간다.
		 - 발생한 예외와 일치하는 catch가 없을 경우 예외는 처리되지 않는다.
		 */
		//★ 에러발생 이유를 읽는 게 중요!!
		
		try{
			int result = 10/0; //정수는 0으로 나눌 수 없기때문에 에러발생
			System.out.println(result);
		}catch(ArithmeticException | IndexOutOfBoundsException e){
			e.printStackTrace();//에러 메세지를 출력한다.
		}catch(NullPointerException e){
			
		}catch(Exception e){
			//Exception e를 붙이면 모든 에러의 경우를 해결할 수 있음
		}
		
		//★★★NullPointerException과 IndexOutOfBoundsException을 자주보게 확률이 높음
		//IndexOutOfBoundsException : 배열을 사용할때 배열의 크기를 넘어가는 것을 사용할떄 발생
//		int[] arr = new int[5];
//		System.out.println(arr[5]);
		
		//NullPointerException : null에서 참조를 했다.
		String str = null;
		System.out.println(str.charAt(1));//이라인안에 어딘가 null이존재
		
		test1();

	}//main

	private static void test1() {
		test2();
	}

	private static void test2() {
		/*
		 * CallStack
		 * 
		 * |		|
		 * |  test2 |
		 * |  test1	|
		 * |__main__|
		 * 
		 * 항상 맨위에 경우에서 에러가 나는 것은 아니다.
		 * 맨위가 아닌 경우 내가 만든 메소드를 찾으면 그부분에서 에러가 난것이다.
		 * 
		 */
		//System.out.println(10/0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//컴파일 발생 이유 : 예외처리를 안했기 때문에
	}
		
}

