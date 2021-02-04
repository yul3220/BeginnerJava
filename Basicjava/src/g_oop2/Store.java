package g_oop2;

public class Store {
	public static void main(String[] args){
		Desktop d1 = new Desktop("삼성 컴퓨터", 100000);
		Desktop d2 = new Desktop("LG 컴퓨터", 100000);
		
		AirCon ac1 = new AirCon("삼성 에어컨", 200000);
		AirCon ac2 = new AirCon("LG 에어컨", 200000);
		
		Tv tv1 = new Tv("삼성 TV",300000);
		Tv tv2 = new Tv("LG TV",300000);
		
		Customer c = new Customer();
		
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		c.buy((Product)d1);
		//Product로 형변환하는것이 숨겨져 있음 , 형변환이 가능하기 때문에 파라미터로 넘길수 있음
		
		System.out.println(ac1.getInfo());
		System.out.println(ac2.getInfo());
		c.buy(ac2);
		
		System.out.println(tv1.getInfo());
		System.out.println(tv2.getInfo());
		c.buy(tv2);
		
		c.showItem();
	}
}


class Product{
	String name;//이름
	int price;//가격
	
	Product(String name, int price){//파라미터를 받고 초기화시킴
		this.name = name;
		this.price = price;
	}
	
	//상품의 정보를 반환하는 메서드
	String getInfo(){
		return name + "("+price+"원)";
	}
}

class Desktop extends Product{
	//파라미터가 있는 부모코드의 생성자를 호출을 해줘야한다.=>파라미터 없는것만 호출안하고 가능
	Desktop(String name, int price){
		super(name,price);
	}
	
	void programing(){
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(String name, int price){
		super(name,price);
	}
	
	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}


class Tv extends Product{
	Tv(String name, int price){
		super(name,price);
	}
	
	void setChannel(){
		System.out.println("채널을 변경합니다.");
	}
}

class Customer{
	int money = 10000000;
	
	Product[] item = new Product[100];
	//3개의 상품을 집어넣기 위해 부모클래스로 item 만듬
	
	void buy(Product p){
		//3가지의 타입을 다 사용해야하기 때문에 Product타입으로 받음 => 다형성
		if(money<p.price){
			System.out.println("잔돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		
		for(int i=0;i<item.length;i++){
			if(item[i]==null){
				item[i]=p;
				break;
			}
		}
		System.out.println(p.getInfo()+"을 구매했다");
	}
	
	void showItem(){
		System.out.println("==========장바구니==========");
		for(int i=0;i<item.length;i++){
			if(item[i]==null){
				break;
			}else{
				System.out.println(item[i].getInfo());
			}
		}
		System.out.println("==========================");
	}
	
	
}//

