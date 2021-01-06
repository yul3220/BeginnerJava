package e_oop;

import java.util.Arrays;
import java.util.Scanner;

public class Shopping {

	Scanner sc = new Scanner(System.in);

	final int MAX_CART = 10;

	String[] items = {"1.후드티", "2.티셔츠", "3.바지", "4.치마", 
			"5.귀걸이", "6.목걸이"};
	int[] amount = {30000, 10000, 15000, 12000, 5000, 8000};
	int[] cart = new int[MAX_CART];
	String[] see_item = new String[MAX_CART];
	String[] result = new String[MAX_CART];
	int total_money = 0;
	int money = 0;
	int count = 0;
	int count2 = 0;

	void show_items(){
		for(int i=0;i<items.length;i++){
			System.out.print(items[i]+"\t");
		}
		System.out.println();
		for(int i=0;i<items.length;i++){
			System.out.print(amount[i]+"원\t");
		}
		System.out.println();
	}

	void sel_items(){
		show_items();
		System.out.print("주문하고 싶은 상품의 개수를 입력하시오> ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i=count2;i<num+count2;i++)
		{
			System.out.print("상품 번호를 입력> ");
			int input = Integer.parseInt(sc.nextLine());
			cart[i] = input;
			for(int j=0;j<items.length;j++){
				if(input==j+1){
					see_item[i]=items[j];
					count++;
				}
			}
		}
		count2 += num;
	}

	void cart_show(){
		for(int i=0;i<cart.length;i++){
			for(int j=0;j<items.length;j++){
				if(cart[i]==j+1){
					System.out.print(items[j]+"\t");
					total_money+=amount[j];
				}
			}
		}
		System.out.println();
		System.out.println("합계 : "+total_money+"원");
	}


	void order(){
		result = new String[count];
		for(int i=0;i<count;i++){
			result[i]=see_item[i];
		}
		if(money>=total_money&&count!=0){
			System.out.println("장바구니의 "+Arrays.toString(result)+"이 주문되었습니다.");
			money = money-total_money;
			System.out.println("계좌잔액 : "+money);
			for(int i=count2;i>=0;i--){
				cart[i]=0;
				total_money=0;
				see_item[i]=null;
			}
			count=0;
		}
		else if(money<total_money){
			System.out.println(total_money-money+"원 만큼의 잔액이 부족합니다. 충전해주세요.");
		}
		else if(count==0){System.out.println("주문할 내역이 없습니다.");}
	}


	void charge(){
		System.out.println("현재 충전금액 : "+ money);
		System.out.print("얼만큼 충전하시겠습니까?");
		int add_money = Integer.parseInt(sc.nextLine());
		money += add_money;
		System.out.println("충전후 금액 : "+ money);
	}

	void mypage(){
		System.out.println("충전금액 : "+ money+"원");
	}

	public static void main(String[] args) {
		Shopping shop = new Shopping();
		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.println("----------Shopping-------------");
			System.out.println("1.마이페이지  2.상품보기   3.상품선택   4.장바구니 내역 ");
			System.out.println("5.주문하기   6.충전하기   7.나가기");
			System.out.println("-------------------------------");
			System.out.print("번호 입력> ");
			int input = sc.nextInt();

			switch(input){
			case 1: shop.mypage();break;
			case 2: shop.show_items(); break;
			case 3: shop.sel_items(); break;
			case 4: shop.cart_show(); break;
			case 5: shop.order();break;
			case 6: shop.charge();break;
			case 7: System.exit(0);
			}
		}
	}
}
