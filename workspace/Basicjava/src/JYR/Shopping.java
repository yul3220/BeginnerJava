package JYR;

import java.util.Scanner;

public class Shopping {//쿠폰, 등급 
	Scanner sc = new Scanner(System.in);
	final int MAX_CART = 10;//장바구니 최대개수

	String[] types= {"상의","하의","아우터","악세사리","신발"};
	String[][] items = {{"후드티","티셔츠","맨투맨","니트","블라우스"}, 
			{"스커트","청바지","면바지","슬랙스","레깅스"},
			{"가디건","야상","자켓","패딩","플리스"},
			{"목걸이","모자","벨트","양말","스타킹"},
			{"단화","운동화","구두","워커","샌들"}};
	int[][] amount = {{17900, 11900, 18500, 13900, 14000},
			{12900, 13500, 15000, 14900, 7900},
			{15900, 37500, 29000, 55000, 23000},
			{5000, 9900, 5900, 2000, 3000},
			{12500, 14800, 27000, 28000, 18000}};
	int[] cart = new int[MAX_CART];//장바구니
	int total_money = 0;//장바구니 금액
	int money = 0;//잔액
	int count = 0;
	double mileage = 0;//마일리지
	String level ="";
	int ordermoney = 0;
	int ordercount;
	double milepercent = 0;

	//마이페이지
	void mypage(){
		System.out.println("========== My page ==========");
		System.out.println("충전금액 : "+ money+"원");
		System.out.println("마일리지 : "+mileage+"원");
		System.out.println("등급 : "+level);
		System.out.println("=============================");
		System.out.println();
	}

	//상품보기
	void show_items(){
		for(int i=0;i<types.length;i++){
			System.out.print((i+1)+"."+types[i]+"\t");
		}
		System.out.println();
		System.out.print("보고싶은 카테고리을 선택하세요 > ");
		int input = Integer.parseInt(sc.nextLine()); 
		for(int i=0;i<types.length;i++){
			if(input==i+1){
				for(int j=0;j<items[i].length;j++){
					System.out.print(items[i][j]+"\t");
				}
				System.out.println();
				for(int j=0;j<items[i].length;j++){
					System.out.print(amount[i][j]+"원\t");
				}
			}
		}
		System.out.println();
		System.out.print("선택(1.다시보기\t2.홈) : ");
		int sel = Integer.parseInt(sc.nextLine());
		
		switch(sel){
		case 1: System.out.println(); show_items();break;
		case 2: break;
		default : System.out.println("잘못입력하셨습니다."); break;
		}
	}

	//상품선택
	void sel_items(){
		int num_count=0;
		for(int i=0;i<items.length;i++){
			for(int j=0;j<items[i].length;j++){
				num_count++;
				System.out.print(num_count+ "."+items[i][j]);
				System.out.print(" "+ amount[i][j]+"원\t");
			}
			System.out.println();
		}
		System.out.print("주문하고 싶은 상품의 개수를 입력하시오> ");
		int num = Integer.parseInt(sc.nextLine());

		if(num+count<=10){
			for(int i=count;i<num+count;i++){
				System.out.print("상품 번호를 입력(1~25사이의 수) > ");
				int input = Integer.parseInt(sc.nextLine());
				cart[i] = input;
			}
			count += num;
		}else{System.out.println("장바구니가 꽉 찼습니다.");}
		System.out.println();
	}
	//장바구니를 통해서 cart에 있는 값들을 저장하게끔했기 때문에 상품의 합계를 보기위해서는 cart메뉴를 이용해야한다.
	//cart는 아이템의이름이 아닌 번호를 저장(상품선택후 => 장바구니 선택 필수)

	//장바구니 내역보기
	void cart_show(){
		int number = 0;
		int a = 0;
		for(int i=0;i<cart.length;i++){	
			for(int j=0;j<25;j++){
				if(cart[i]==j+1){
					int x = j/5;
					int y = j%5;
					System.out.println(a+"."+items[x][y]+"\t"+amount[x][y]+"원");
					number += amount[x][y];
					a++;
				}
			}
		}
		total_money = number;
		System.out.println();
		System.out.println("합계 : "+total_money+"원");
	}

	//카트삭제
	void cartdelete(){
		int num1 = 0;
		for(int i=0;i<cart.length;i++){
			if(cart[i]!=0){
				num1++;
			}
		}
		System.out.print("삭제하고 싶은 상품의 번호를 선택(장바구니의 번호) : ");
		int index = Integer.parseInt(sc.nextLine());
		int i = index;
		for(int j=0;j<25;j++){
			if(cart[index]==j+1){
				int x = j/5;
				int y = j%5;
				total_money -= amount[x][y];
			}
		}
		while(i<num1){
			cart[i] = cart[i+1];
			i++;
		}
		i=0;
	}

	//장바구니 전체메뉴
	void cartMenu(){
		boolean sel = true;
		while(sel){
			System.out.print("선택(1.전체 내역  2.장바구니 삭제  3.홈) : ");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
			case 1: cart_show();break;
			case 2: cartdelete();break;
			case 3: sel= false; break;
			default : System.out.println("잘못입력하셨습니다."); break;
			}
		}
	}

	//주문하기
	void allorder(){
		if(money>=total_money&&count!=0){
			System.out.println("장바구니의 상품을 주문했습니다.");
			System.out.println("주문 금액 : "+total_money);
			mileage = total_money*(milepercent/100) + mileage;
			ordermoney += total_money;
			money = money-total_money;
			System.out.println("계좌잔액 : "+money);
			ordercount++;
			for(int i=count;i>=0;i--){
				cart[i]=0;
				total_money=0;
			}
			count = 0;
		}
		else if(money<total_money){
			System.out.println("현재 잔액 : "+ money);
			System.out.println(total_money-money+"원 만큼의 잔액이 부족합니다. 충전해주세요.");
		}
		else if(count==0){System.out.println("주문할 내역이 없습니다.");}
	}

	//마일리지 사용
	void usemileage(){//마일리지 사용
		if(mileage>0&&money>=total_money&&count>0){
			System.out.print("마일리지를 사용하시겠습니까(0:사용 / 1:미사용)? :");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
				case 0: 
					System.out.println("현재 마일리지 :"+mileage+"원 / 마일리지 사용전 금액 : "+total_money+"원");
					System.out.print("사용금액 : ");
					int input2=Integer.parseInt(sc.nextLine());
					total_money -= input2;
					mileage-=input2;
					System.out.println("남은 마일리지 :"+mileage+"원 / 마일리지 사용후 금액 : "+total_money+"원");
					break;
				case 1: 
					break;
				default : System.out.println("잘못입력하셨습니다."); break;
			}
		}
		else if(mileage<=0){
			System.out.println("마일리지가 존재하지 않습니다.");
		}
		else if(total_money<money){System.out.println("돈을 충전해주세요..");}
		else{System.out.println("주문 내역이 없습니다.");}
	}
	
	//전체적인 주문메뉴
	void orderMenu(){
		boolean sel = true;
		while(sel){
			System.out.print("선택(1.주문하기  2.마일리지 사용  3.홈) : ");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
			case 1: allorder();level();break;
			case 2: usemileage();break;
			case 3: sel= false; break;
			default : System.out.println("잘못입력하셨습니다."); break;
			}
		}
	}
	
	//충전하기
	void charge(){
		System.out.println("현재 충전금액 : "+ money);
		System.out.print("얼만큼 충전하시겠습니까?");
		int add_money = Integer.parseInt(sc.nextLine());
		money += add_money;
		System.out.println("충전후 금액 : "+ money);
	}
	
	//등급
	void level(){
		if(ordercount==0&&ordermoney==0){
			level="NEW";
			milepercent=5;
		}else if(ordercount==1&&ordermoney<20000){
			level = "SILVER";
			milepercent=5;
		}else if(20000<=ordermoney&&ordermoney<50000){
			level = "GOLD";
			milepercent=7;
		}else if(50000<=ordermoney&&ordermoney<100000){
			level="VIP";
			milepercent=8;
		}else if(100000<=ordermoney&&ordermoney<200000){
			level ="VVIP";
			milepercent=10;
		}else if(200000<=ordermoney){
			level = "DIAMOND";
			milepercent=15;
		}
	}
	

}//
