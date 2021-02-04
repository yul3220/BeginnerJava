package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 - if문
		 - switch문

		 *if문
		 - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
		 - else if(조건식){} : 다수의 조건이 필요할때 if뒤에 추가한다.
		 - else() : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
		 
		 문자열정렬하는법 => ctrl+A이후 ctrl+I(※가끔의 오류 발생)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int a = 1;

		if(a == 1){
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}

		if(a == 0){
			System.out.println("조건식의 연산결과가 false이면 수행되지 않는다.");
		}

		if(a == 1){
			System.out.println("a가 1인 경우에 하고 싶은 것");
		}else if(a == 2){
			System.out.println("a가 2인 경우에 하고 싶은 것");
		}else if(a == 3){
			System.out.println("a가 3인 경우에 하고 싶은 것");
		}else{
			System.out.println("이외의 경우에 하고 싶은 것");
		}

		if(a<10){
			System.out.println("a가 10보다 작다.");
		}if(a<20){
			System.out.println("a가 20보다 작다.");
		}//if가 연속이면 별개의 if이다.

		//Q. 시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 50;
		if(60 <= score){
			System.out.println("합격입니다.");
		}else{
			System.out.println("불합격입니다.");
		}

		//Q2. 성적에 등급을 부여하는 프로그램을 만들어보자.
		score = 59;
		String grade = null;

		if(score >= 90){
			grade = "A";
		}else if(90>score&&score>=80){
			grade = "B";
		}else if(80>score&&score>=70){
			grade = "C";
		}else if(70>score&&score>=60){
			grade = "D";
		}else {grade ="F";}
		System.out.println("당신의 성적은 "+ grade +"입니다.");	

		score = 93;
		grade = null;
		if(score>=90){
			grade = "A";
			if(score>=97){ 
				grade += "+";
			}else if(score<=93){
				grade += "-";
			}
		}else if(score>=80){
			grade = "B";
			if(score>=87){ 
				grade += "+";
			}else if(score<=83){
				grade += "-";
			}
		}else if(score>=70){
			grade = "C";
			if(score>=77){ 
				grade += "+";
			}else if(score<=73){
				grade += "-";
			}
		}else if(score>=60){
			grade = "D";
			if(score>=67){
				grade += "+";
			}else if(score<=63){
				grade += "-";
			}
		}else {grade = "F";}

		System.out.println("당신의 성적은 "+ grade +"입니다.");	

		/*
		 * switch문
		 - switch(int/String){case 1: break;}
		 - 조건식의 결과는 정수의 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */

		
		a = 1;
		
		switch(a){
		case 1:
			System.out.println("a가 1인 경우에 하고싶은 것");
			break;
		case 2:
			System.out.println("a가 2인 경우에 하고싶은 것");
			break;
		case 3:
			System.out.println("a가 3인 경우에 하고싶은 것");
			break;
		default://if문의 else와 역할이 같음
			System.out.println("이외의 경우에 하고싶은 것");
		}
		
		String b = "a";
		
		switch(b){
		case "a":
			System.out.println("b가 \"a\"인 경우에 하고싶은 것");
			break;
		case "b":
			System.out.println("b가 \"b\"인 경우에 하고싶은 것");
			break;
		default:
			System.out.println("이외의 경우의 하고싶은 것");
			break;
		}
		// \=>이스케이프 
		// 위에 \"a\"=> 역슬래시를 사용함으로써 ""를 문자열 안에 사용할수 있게됨
		// =>원래 ""는 string에 들어가는 말이나 출력하는 말을 쓰기 위해 사용되는것

		//Q3.주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 3;
		String season = null;
		
		switch(month){
		case 3:
		case 4:
		case 5://일치하는 것을 만난후 break문을 빠져나오기때문에 case여러개를 나열해도 됨
			season = "봄";
			break;
		case 6:case 7:case 8:
			season = "여름";
			break;
		case 9:case 10:case 11:
			season = "가을";
			break;
		case 12:case 1:case 2:
			season = "겨울";
			break;
		default:
			season = "없음";
		}
		System.out.println("게절은 " + season + "입니다");
		
		score = 90;
		grade = null;
		
		switch(score/10){
		case 10: case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		System.out.println(score+"점에 대한 등급은 "+grade+"입니다.");
		
		//Q4. 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		/*System.out.print("숫자를 입력하시오 : ");
		int number = Integer.parseInt(sc.nextLine());
		if(number == 0){
			System.out.println("0입니다.");
		}else{System.out.println("0이 아닙니다.");}
		
		
		//Q5. 숫자를 입력받아 그 숫자 홀수인지 짝수인지 출력해주세요.
		System.out.print("숫자를 입력하시오 : ");
		int num4 = Integer.parseInt(sc.nextLine());
		if(num4 % 2 == 0){
			System.out.println("짝수입니다.");
		}else{System.out.println("홀수입니다.");}*/
		
		//Q6. 정수 3개를 입력받아 총점, 평균을 구하고, 평균에 대한 등급을 출력해주세요.
		/*System.out.print("국어>");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어>");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학>");
		int math = Integer.parseInt(sc.nextLine());
		
		double sum = kor+eng+math;
		double avg = Math.round((sum/3)*10)/10.0;
		String grade1 = null;
		
		if(avg>=90){
			grade1 = "A";
		}else if(90>avg&&avg>=80){
			grade1 = "B";
		}else if(80>avg&&avg>=70){
			grade1 = "C";	
		}else if(70>avg&&avg>=60){
			grade1 = "D";	
		}else {grade1 = "F";}
		System.out.println("당신의 평균은  "+avg +" 등급은 " + grade1 +"입니다");*/
		
		
		//Q7. 1~100사이의 랜덤한 숫자를 3개를 발생시키고 오름차순으로 출력해주세요.
		// a b c
		int x = (int)(Math.random()*100)+1;
		int y = (int)(Math.random()*100)+1;
		int z= (int)(Math.random()*100)+1;
		int tmp = 0;
		
		if(x > y){
			tmp = x;
			x = y;
			y = tmp;
		}
		if(x > z){
			tmp = x;
			x=z;
			z=tmp;
		}
		if(y > z){
			tmp=y;
			y=z;
			z=tmp;
		}
		System.out.println(x+" "+y+" "+z);
		 
		sc.close();
	}
}

