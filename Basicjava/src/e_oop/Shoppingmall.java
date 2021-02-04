package e_oop;

import java.util.Arrays;

public class Shoppingmall {
	
	String[] make_order(){
		System.out.println("상품을 주문하시겠습니까??");
		return new String[]{"옷", "악세사리", "신발"};
	}
	
	void take_order(String[] order){
		System.out.println("주문을 확인했습니다.");
	}
	
	void find_prod(String[] product){
		System.out.println(Arrays.toString(product)+"제품을 찾았습니다.");
	}
	
	void delivery(String[] order){
		System.out.println("상품 배송을 하겠습니다.");
	}
	
}
