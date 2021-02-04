package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자(산술연산자5개)를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자>");
	    double num1 = Double.parseDouble(sc.nextLine());
		System.out.print("두번째 숫자>");
		double num2 = Double.parseDouble(sc.nextLine());
		System.out.print("연산자 입력>");
		String operator = sc.nextLine();
		double result;
		result = operator.equals("+") ? num1+num2 
				: (operator.equals("-")? num1-num2
						:(operator.equals("*")? num1*num2 
								: (operator.equals("/")? num1/num2 
										: (operator.equals("%")? num1%num2 : 0))));
		System.out.println("사칙연산 결과 : "+ Math.round(result*100)/100.0);
		System.out.println(num1 + " " + operator + " " + num2 + "=" + result);
		
	}
}
