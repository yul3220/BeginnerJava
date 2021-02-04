package f_game;

public class Monster {
	String name; //이름
	int maxHp; //최대 체력
	int maxMp; //최대 마나
	int hp; //체력
	int mp; //마나
	int att; //공격력
	int def; //방어력
	Item[] items; //보유아이템
	
	Monster(String name, int hp, int mp, int att, int def, Item[] items){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.items = items;//몬스터가 사망했을 때 아이템을 랜덤으로 떨어지게끔 만듬
	}
	
	void attack(Character m){
		int damage = att - m.def;
		damage = damage<=0 ? 1: damage; 
		m.hp = m.hp < damage ? m.hp  -m.hp : m.hp - damage;
		System.out.println(name + "가 공격으로 "+m.name+"에게 "+damage+"만큼 데미지를 주었습니다.");
		System.out.println(m.name+"의 남은 HP : "+m.hp);
	}
	
	Item itemDrop(){//랜덤의 아이템을 하나 드롭하게끔 만드는 코드
		return items[(int)(Math.random()*items.length)];
	}
	
}//
