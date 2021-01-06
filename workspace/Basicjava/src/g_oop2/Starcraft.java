package g_oop2;

public class Starcraft {
	
	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		
		//scv.repair(marine);
		//인터페이스는 관계가 없는 클래스끼리 관계있게끔 할수있음
	}
}

class Unit{
	int hp;// 현재체력
	final int MAX_HP;//최대 체력
	
	Unit(int hp)
	{
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit{
	Marine() {
		super(40);
	}
	//unit생성자에 파라미터가 존재하기 때문에 자식클래스에서 에러가 뜸
	//따라서 생성자를 정의해줘야함
}

class Tank extends Unit implements Repairable{//기계
	Tank() {
		super(150);
	}
}

class Dropship extends Unit implements Repairable{//기계
	Dropship() {
		super(125);
	}
}

class SCV extends Unit{//수리
	SCV() {
		super(60);
	}
	
	void repair(Repairable r){
		//Repairable를 통해 tank와 dropship을 가지고옴
		
		//Repairable에는 최대체력에 대한 내용이 없기 때문에 형변환을 해줌
		if(r instanceof Unit){//Unit으로 형변환이 가능한지 확인
			Unit u = (Unit)r;
			
			while(u.hp<u.MAX_HP){
				u.hp++;
			}
		}
	}
}

interface Repairable{//tank와 dropship간은 관계가 없기때문에 interface만듬
	
}
