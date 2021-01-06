package JYR;

import java.util.Scanner;

public class Work {
	Shopping shop = new Shopping();
	Scanner sc = new Scanner(System.in);
	Board board = new Board();
	String id;
	String password;
	boolean userState = false;
	String session = new String();
	Member[] users;
	int number;
	int index;

	{
		this.id = "";
		this.password="";
		this.users = new Member[3];
		this.index=0;
	}

	void join(){
		System.out.println("회원가입");
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				index=users[i].number+1;
			}
		}
		if(users[index]==null)
		{
			System.out.print("id를 입력하세요(최소 2자리)> ");
			id = sc.nextLine();
			for(int i=0;i<index;i++){
				if(users[i].id.equals(id)){
					System.out.println("중복된 아이디입니다.");
					return;
				}
			}
			System.out.print("password를 입력하세요(최소 4자리)> ");
			password=sc.nextLine();	
		}else if(users[5]!=null){
			System.out.println("아이디가 이미 존재합니다.");
			return;
		}
		
		int idstr = id.length();
		int pwstr = password.length();
		if(idstr>=2&&pwstr>=4){
			users[index]=new Member(id, password, index);
			index++;
			System.out.println("회원가입 완료!!!");
			System.out.println("id : "+id+"/ password : "+password);
		}else if(idstr<2){
			System.out.println("ID를 좀 더 길게 작성해주세요...");
		}else if(pwstr<4){
			System.out.println("비밀번호를 좀 더 길게 작성해주세요...");
		}else if(idstr<2&&pwstr<4){
			System.out.println("아이디와 비밀번호 모두 길게 작성해주세요...");
		}

	}


	void login(){
		int pwIndex =0;
		System.out.println("로그인");
		System.out.print("id를 입력하세요> ");
		String id = sc.nextLine();
		System.out.print("password 입력하세요>");
		String password = sc.nextLine();
		
		for(int i=0;i<index;i++){
			if(users[i].getId().equals(id))
			{
				pwIndex = i;
				
				if(users[pwIndex].getPassword().equals(password))
				{
					System.out.println("로그인 성공!!");
					userCheck();
					session = id;
					return;
				}
				else
				{
					System.out.println("비밀번호가 틀립니다..");
					return;
				}
			}
		}
		System.out.println("아이디가 존재하지 않습니다..");
	}
	
	void userCheck(){
		userState = !userState;
		if(userState==false){
			session = new String();
		}
	}
	
	boolean menu(){
		System.out.println("==============메인===============");
		System.out.print("선택(1. 회원가입    2.로그인  3.나가기) : ");
		int input = Integer.parseInt(sc.nextLine());

		switch(input){
		case 1: 
			join();
			System.out.println();
			return false;
		case 2:
			login();
			System.out.println();
			return false;
		case 3:
			System.exit(0);
			return false;
		default:
			System.out.println("다시 입력하세요.");
			System.out.println();
			return false;
		}
	}

	void menuLogin(){
		while(true){
			System.out.println("==============Shopping=============");
			System.out.println("1.마이페이지  2.상품보기   3.상품선택   4.장바구니");
			System.out.println("5.주문하기      6.충전하기     7.게시판   8.로그아웃");
			System.out.println("===================================");
			System.out.print("번호 입력> "); 
			int input = Integer.parseInt(sc.nextLine());

			switch(input){
			case 1: shop.level();
					shop.mypage();break;
			case 2: shop.show_items(); break;
			case 3: shop.sel_items(); break;
			case 4: shop.cartMenu(); break;
			case 5: shop.orderMenu();break;
			case 6: shop.charge();break;
			case 7: board.BoardMenu();break;
			case 8: System.out.println();
			menu(); break;
			}
		}
	}


	void show(){
		boolean sel = false;

		while(sel==false){
			if(userState){
				menuLogin();
			}else{
				sel = menu();
			}
		}
	}

}//
