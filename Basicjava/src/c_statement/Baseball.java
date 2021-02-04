package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 135 (내가생각하는 수)
		 * 
		 * 123 : 1S(숫자와 자릿수가 같을경우), 1B(숫자는 같으나, 자리수가 다를때),
		  		 1O(숫자도 다르고, 자릿수도 다를때)
		 * 136 : 2S, 1O	
		 */

		/*
		ex)428
		179 : 0S 0B 0O
		234 : 0S 2B 1O
		483 : 1S 1B 1O
		543 : 0S 1B 2O
		468 : 2S 0B 1O
		428 : 3S
		 */

		Scanner sc = new Scanner(System.in);
		String ans = null;
		System.out.println("숫자 야구게임 설명");
		System.out.println("컴퓨터에서 생각한 숫자와 입력한 숫자를 비교하게 됩니다.");
		System.out.println("자리와 숫자까지 모두 같으면 Strike");
		System.out.println("숫자는 맞으나 자리가 다르면 Ball");
		System.out.println("숫자와 자리 모두 다르면 Out");
		System.out.println();
		int str=0;
		int bal=0;
		int out=0;
		int input1=0, input2=0, input3 = 0;
		int no1 = (int)(Math.random()*9)+1;
		int no2 = (int)(Math.random()*9)+1;
		int no3 = (int)(Math.random()*9)+1; 
		while(no1==no2 || no2==no3 || no1==no3)
		{
			no1 = (int)(Math.random()*9)+1;
			no2 = (int)(Math.random()*9)+1;
			no3 = (int)(Math.random()*9)+1; 
		}
		System.out.println(no1+""+no2+""+no3);
		System.out.println("1-9 사이의숫자를 입력하되, 중복되지 않게 입력하시오");
		
		while(str!=3)//3S아니면=>조건
		{
			str=0;
			bal=0;
			out=0;
			System.out.print("첫번째 숫자를 입력하세요>");
			input1 = Integer.parseInt(sc.nextLine());


			System.out.print("두번째 숫자를 입력하세요>");
			input2 = Integer.parseInt(sc.nextLine());


			System.out.print("세번째 숫자를 입력하세요>");
			input3 = Integer.parseInt(sc.nextLine());

			if(no1 == input1){
				str++;
			}else if(no1 == input2 || no1==input3){
				bal++;
			}else{out++;}

			if(no2 == input2){
				str++;
			}else if(no2 == input1 || no2==input3){
				bal++;
			}else{out++;}

			if(no3 == input3){
				str++;
			}else if(no3 == input1 || no3==input2){
				bal++;
			}else{out++;}

			System.out.println(str+"S "+bal+"B "+out+"O ");
			System.out.println();
			
			sc.close();
		}
	}
}
