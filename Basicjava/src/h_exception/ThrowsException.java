package h_exception;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		/*
		 * 메서드에 예외 선언하기
		  - 메서드 호출시 발생할 수 있는 예외를 선언해줄 수 있다.
		  - void method() throws IOException => 이메서드를 선언하면 IOException가 발생할 수 있다.
		  => IOException가 처리하는게 아니라 메서드가 처리를 한다.
		  - 메서드의 구현부 끝에 throws 예약어와 예외 클래스명으로 예외를 선언할 수 있다.
		  - 예외를 선언하면 예외처리를 하지 않고 자신을 호출한 메서드로 예외처리를 남겨준다.
		 */
		
		//new FileInputStream("");//어디있는지 알고싶으면 F3(단축어)누르기
		
		//호출한 부분에서 예외를 처리해야한다.
		try {
			method();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

	}

	private static void method() throws IOException {
		throw new IOException();
		
	}
}
