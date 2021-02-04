package e_oop.restaurant;

public class Alba {
	// 메서드 : 알바가 할 일(보스가 알바에게 시킨 일)
	// 파라미터 : 일을 하기 위해 필요한 것(보스가 알바에게 주는 것)
	// 리턴타입 : 일을 하고 난 후 돌려주는 것(알바가 보스에게 주는 것)
	// 사장님이 요리만, 알바가 주문,서빙,계산을 할수 있도록(3개의 메서드필요)
	
	//주문하기
	//주문받기 위해 필요한 것? 없음
	//주문받은 후 보스에게 줄 것? 주문서
	String[] order(){
		System.out.println("주문 하시겠습니까?");
		return new String[]{"짜장면", "탕수육"};
	}
	
	//서빙하기
	//서빙하기 위해 필요한 것? 음식
	//서빙 후에 보스에게 줄 것? 없음
	void serve(String[] foods){
		System.out.println("맛있게 드세요.");
	}
	
	//계산하기
	//계산하기 위해 필요한 것? 계산서
	//계산 후 보스에게 줄 것? 없음
	void pay(String[] order){
		System.out.println("2만원입니다. 안녕히가세요.");
	}
	
}
