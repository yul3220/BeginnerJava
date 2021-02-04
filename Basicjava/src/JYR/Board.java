package JYR;

import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	String[][] notices = new String[5][];
	int seq = 1;
	int index = 0;
	
	void levelboard(){
		System.out.println("================ 등급혜택 ========================");
		System.out.println(" 회원등급   |        등급기준                   |      혜택        ");
		System.out.println("------------------------------------------------");
		System.out.println("  NEW   |       구매이력 없음              |   5%  구매적립    ");
		System.out.println(" SILVER |  1회 구매 혹은 2만원 이하 구매  |   5% 구매적립    ");
		System.out.println("  GOLD  |  2만원 이상 5만원 미만 구매      |   7% 구매적립  ");
		System.out.println("  VIP   |   5만원 이상 10만원 미만 구매  |   8% 구매적립  ");
		System.out.println("  VVIP  |  10만원 이상 20만원 미만 구매  |  10% 구매적립  ");
		System.out.println("DIAMOND |      20만원이상 구매             |  15% 구매적립  ");
		System.out.println("================================================");
		System.out.println();
	}
	
	void createboard(){
		if(index==notices.length){
			System.out.println("게시물이 모두 찼습니다.");
			return;
		}
		String num = String.valueOf(seq);
		System.out.println("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String  content = sc.nextLine();
		
		String[] notice = new String[3];
		notice[0]=num;
		notice[1]=title;
		notice[2]=content;
		
		notices[index++] = notice;
		seq++;
		
		System.out.println("게시물 등록이 완료되었습니다.");
	}
	
	void showboard(){
		for(int i=0;i<notices.length;i++){
			if(notices[i]==null) continue;
			
			System.out.println("--------------------------");
			System.out.println("번호 : " + notices[i][0]); 
			System.out.println("제목 : " + notices[i][1]); 
			System.out.println("내용 : " + notices[i][2]);
			System.out.println("--------------------------");
			System.out.println();
		}
	}
	
	void InquiryMenu(){
		boolean run = true;
		while(run){
			System.out.print("선택(1. 등록하기  2.내역보기  3.나가기) : ");
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input){
			case 1: createboard(); break;
			case 2: showboard(); break;
			case 3: run = false; break;
			default : System.out.println("잘못입력하셨습니다."); break;
			}
		}
	}
	
	void BoardMenu(){
		boolean run = true;
		
		while(run){
			System.out.print("선택(1.등급기준표  2. 문의  3. 홈) : ");
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input){
			case 1: levelboard(); break;
			case 2: InquiryMenu(); break;
			case 3: run =false; break;
			default : System.out.println("잘못입력하셨습니다."); break;
			}
		}
	}
}



