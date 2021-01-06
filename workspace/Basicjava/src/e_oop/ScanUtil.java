package e_oop;

import java.util.Scanner;

public class ScanUtil {
	
	//유틸리티 성향의 메서드인 경우 static을 붙인다.
	//Math.random(), Math.round(), System.out.println()
	//=> 이안에 static이 붙여져있기때문에 객체생성을 하지 않고도 사용가능
	
	private static Scanner s = new Scanner(System.in);
	
	public static String nextLine(){
		return s.nextLine();
	}
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
	}
	
}