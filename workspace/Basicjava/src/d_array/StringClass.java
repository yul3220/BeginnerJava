package d_array;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 - 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 *
		 * ★ String의 주요 메서드(메서드 종류는 많으나 이중 가장 많이 사용하는 9개)
		 - equals() : 문자열의 내용이 같은지 반환한다.
		 - length() : 문자열의 길이를 반환한다.
		 - charAt() : 특정 인덱스에 위치한 문자를 반환한다.
		 - substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 - indexOf() :  문자열 내의 특정 문자의 인덱스를 반환한다.
		 - contains() : 문자열이 특정 문자열을 포함하고 있는지 반환한다.
		 - split() : 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 - trim() : 문자열 앞뒤의 공백을 제거해 반환한다.//맨얖이나 맨뒤의 공백만 제거
		 - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 () : 메서드, 데이터를 받는 부분
		 * */
		
		boolean equals = "문자열".equals("문자열");
		System.out.println(equals);
		
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2));
		//System.out.println(str2.equals(str1));
		//str.equals에서 .은 참조연산자 => str안에 참조하여 사용
		// null에는 equals가 존재x => null이 있을 수 있는 변수를 앞에 두지 않는다.
		// null이 메소드안에 들어갈수는 있으나 앞에 사용하지 말것
		
		String str = "12345";
		int length = str.length();//길이를 int타입을 통해 알려줌
		for(int i=0;i<length;i++){
			char charAt = str.charAt(i);
			System.out.println(charAt);
		}
		
		//문자열뒤집기
		String rev = "";//12345 => 54321
		for(int i=str.length()-1; 0<=i ;i--){
			rev += str.charAt(i);
		}
		System.out.println(rev);
		
		str = "0123456789";
		String sub1 = str.substring(3);//3번 인덱스부터 잘라서 반환한다.
		System.out.println(sub1);
		String sub2 = str.substring(5,8);
		//5번 인덱스부터 8번 인덱스전까지 잘라서 반환한다.
		System.out.println(sub2);
		
		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지");//오렌지의 시작 인덱스를 반환한다.
		System.out.println("인덱스는 "+ index);
		
		//substring과 indexOf를 조합해서 문자열 자르기
		String[] menu={
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원"
		};
		
		for(int i=0; i<menu.length; i++){
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
		}//이름 다음에 공백이 들어가기 때문에 공백의 인덱스를 추출하여 처음시작부터 공백전까지 출력
		
		//가격만 잘라서 int타입 변수에 저장해주세요.
		for(int i=0;i<menu.length;i++){
			int num = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1, 
					menu[i].indexOf("원")));
			System.out.println(num);
		}
		
		str = "abcd";
		boolean contains = str.contains("c");
		System.out.println(contains);
		
		//오렌지가 메뉴의 몇번 인덱스에 있는지 찾기
		for(int i=0 ; i< menu.length;i++){
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는  "+i+"번 인덱스에 있습니다.");
			}
		}
		
		str="a/b/c";
		String[] split=str.split("/");
		System.out.println(Arrays.toString(split));
		//기준이 되는 문자열은 없어지고, 나머지 값만 들어감
		
		//메뉴명과  가격 나누기
		for(int i=0;i<menu.length;i++){
			split = menu[i].split(" ");
			System.out.println("메뉴명 : "+split[0]+" / 가격 : "+split[1]);
		}
		
		str = " 문 자 열 ";
		String trim = str.trim();
		System.out.println("["+str+"] --> ["+trim+"]");
		// 맨앞이나 맨뒤에 공백만 제거, 중간부분의 공백은 제거x
		
		String id = " myid";
		String password = "myPassword ";
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());
		//로그인할때 실수로 공백을 입력하는 경우에 사용, 공백도 데이터로 생각하기 때문에 이부분때문에
		//회원가입은 되나 로그인이 안될때가 있다.
		
		int number = 10;
		str = number+"";//int와 string타입이 만나 string타입으로 바뀐다./ 편법
		str = String.valueOf(number);// 정석
		System.out.println(str);
			
	}
}
