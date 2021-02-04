package h_exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Finally {
	public static void main(String[] args) {
		/*
		 * finally
	  		- 필요에 의해 try-catch 뒤에 finally를 추가할 수 있다.
	  		- finally는 예외의 발생예부와 상관없이 가장 마지막에 수행된다
		 * 
		 * 자동 자원 반환
	  		- try(변수선언;변수선언) {} catch(Exception e) {}
	  		- 사용 후 반환이 필요한 객체를 try의 {}안에서 선언하면 try 블럭 종료시 자동으로 반환한다.
		 */

		FileInputStream fis = null;//파일 읽기
		
		try {
			fis = new FileInputStream("d:/file.txt");//경로를 지정해준곳에 파일이 없는 경우 에러발생
			fis.close();
			//FileInputStream을 실행하면 반드시 close를 해야 한다.
			//=> java내에서 하는 것이 아닌 운영체제에서 하는 것이기 때문이다. / 닫지 않으면 운영체제의 자원이 낭비가 됨
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // 이 위에서 에러가 날경우 close까지 안가기때문에 finally에 close추가
		}
		//예외발생 : try -> catch -> finally
		//예외 미발생 : try-> finally
		
		
		//자동 자원 반환(JDK1.7부터 사용가능) => close를 사용할려면 try-catch안에 try-catch문 2번 발생
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){
			String str = "아무내용이나 써보자.......";
			
			byte[] bytes = str.getBytes();//문자열 바이트로 변환
			
			for(int i = 0;i<bytes.length;i++){
				fos.write(bytes[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//try ()안에 객체를 생성해서 사용하면 자동으로 close 반환
		
		
	}// main
}//
