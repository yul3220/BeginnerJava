package c_statement;

import java.util.Scanner;

public class selfTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("탄수화물 중독 자가진단 테스트");
		System.out.println("Y or N로 대답하시오.(대문자 or 소문자)");
		int count = 0;
		String ans = null;
		System.out.print("아침을 배불리 먹은 후 점심시간 전에 배가 고프다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("정말 배고프지 않더라도 먹을 때가 있다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("스트레스를 받으면 자꾸 먹고 싶어진다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		System.out.print("다이어트를 위해 식이조절을 하는데 3일도 못간다>");
		ans = s.nextLine();
		if(ans.equals("Y") || ans.equals("y")){
			count++;
		}
		
		System.out.println("당신은 해당사항은 " + count + "개입니다.");
		if(count<=2){
			System.out.println("탄수화물 중독이 아닙니다.");
		}else if(count==3){
			System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
		}else if(4<=count&&count<=6){
			System.out.println("위헙! 탄수화물 섭치 줄위기 위한 식습관 개선이 필요함");
		}else if(count>=7){
			System.out.println("중독! 전문의 상담이 필요함");
		}
		
		s.close();
	}

}
