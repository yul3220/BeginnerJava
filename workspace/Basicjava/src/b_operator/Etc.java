package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자
		 - |, &, ^, ~, <<, >>
		 - 비트 단위로 연산한다
		 =>특정분야에서만 사용(결과 예측이 쉽지 않음)
		  
		 * 기타연산자
		 - .(참조연산자) : 특정 범위 내에 속해 있는 멤버를 지정할 때 사용한다
		 - (type) : 형변환
		  ★ ?:(삼항연산자) => 조건식 ? 조건식이 참일 경우 수행할 문항 : 조건식이 거짓일 경우 수행할 문장
		 */
		//1byte : 01010101
		
		System.out.println(10 | 15);// | : 둘다 0인 경우 0 그외 1
		//10 : 00001010
		//15 : 00001111
		//결과 : 00001111
		
		int x = 10;
		int y = 20;
		int result = x<y ? x : y;//결과적으로 식은 int result = x;
		System.out.println(result);
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		//int regNO = 1;
		//String gender = regNO==1? "남자" : "여자";
		// 문제점은 1이 아닌 어떤 숫자가 오더라도 여자로만 뜸
		//System.out.println("당신의 성별은 "+gender+"입니다.");
		
		//gender = regNO == 1? "남자" : (regNO == 2 ? "여자" : "확인불가");//삼항연산자를 중첩해서 사용
		//System.out.println("당신의 성별은 "+gender+"입니다.");
		
		//Q. 2개의 숫자를 입력하고, 둘 중 더 큰 숫자를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자>");
		int num2 = Integer.parseInt(sc.nextLine());
		int result2;
		result2 = num1 > num2 ? num1 : num2;
		System.out.println(result2);
		
		//Q2. 숫자를 입력받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		//그 외의 숫자를 입력하면 확인불가를 출력해주세요.
		System.out.print("숫자를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		String gender1 = num==1||num==3 ? "남자" : (num==2 || num==4? "여자":"확인불가");
		System.out.println("당신의 성별은 "+gender1+"입니다.");
		
	}

}
