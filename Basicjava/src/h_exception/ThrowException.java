package h_exception;

import java.io.IOException;

public class ThrowException {
	public static void main(String[] args) {
		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 * - throw 예약어와 예외 클래스의 객체로 예외를 고의로 발생시킬 수 있다.
		 */
		
		IOException ioe = new IOException();
		
		try {
			throw ioe;
		} catch (IOException e) {
			e.printStackTrace();
		}//RuntimeException자식이 아니기때문에 try-catch작성
		
		throw new NullPointerException();// RuntimeException의 자식 예외이기 때문에 컴파일 발생 x
		
		
		
		
	}//main
}//

