package f_game;

public class Character {
	
	String name; //이름
	int maxHp; //최대 체력
	int maxMp; //최대 마나
	int hp; //체력
	int mp; //마나
	int att; //공격력
	int def; //방어력
	int level; //레벨
	int exp; //경험치
	Item[] items; //보유아이템
	
	//생성자를 만들어서 위의 값들을 초기화
	Character(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;
		this.items = new Item[10];
	}
	
	//캐릭터의 정보를 볼수 있는 상태창
	void showInfo(){
		System.out.println("=======================================");
		System.out.println("-----------------상태-------------------");
		System.out.println("이름 : "+name);
		System.out.println("레벨 : "+level+"{"+exp+"/100}");
		System.out.println("체력 : "+maxHp);
		System.out.println("마나 : "+maxMp);
		System.out.println("공격 : "+att);
		System.out.println("방어 : "+def);
		System.out.println("----------------아이템-------------------");
		for(int i=0;i<items.length;i++){
			if(items[i]!=null){
				System.out.println(items[i].ItemInfo());
			}
		}
		System.out.println("=======================================");
	}
	
	void attack(Monster m){//공격하는 메서드(공격하는 대상이 필요=>몬스터를 파라미터로 넣음)
		int damage = att - m.def;//캐릭터의 공격력에서 몬스터의 방어력을 뺌
		damage = damage<=0 ? 1: damage; //데미지가 0보다 작으면 1만큼의 데미지를 줌
		m.hp = m.hp < damage ? m.hp  -m.hp : m.hp - damage;
		//hp가 damage보다 작으면 hp만큼 떨어뜨림으로써 몬스터를 죽임
		System.out.println(name + "가 공격으로 "+m.name+"에게 "+damage+"만큼 데미지를 주었습니다.");
		System.out.println(m.name+"의 남은 HP : "+m.hp);
	}
	
	void getExp(int exp){// 경험치를 얻는 메서드(파리미터=>얼만큼의 경험치를 얻을지 정하는 것)
		System.out.println(exp+"의 경험치를 획득하였습니다.");
		this.exp += exp;
		while(100<=this.exp){//경험치가 100보다 클때 레벨 1씩 증가(100이상 경험치가 들어올경우에도 레벨1씩 계속 증가 될수 있게 while문 사용)
			levelUp();
			this.exp -= 100;//다시 경험치를 0으로 낮춤
		}
	}
	
	void levelUp(){//레벨업이 되는 경우 체력과 마나가 풀상태로 참
		level++;
		maxHp += 10;
		maxMp += 5;
		att += 2;
		def += 2;
		hp = maxHp;
		mp = maxMp;
		System.out.println("LEVEL UP!!");
	}
	
	
	void getItem(Item item){//파라미터=>어떤 아이템을 얻을것인지 , 레벨업하면 아이템을 얻을 수 있음
		System.out.println(item.name+"을 획득하였습니다.");
		for(int i=0;i<items.length;i++){
			if(items[i]==null){
				items[i]=item;
				break;
			}
		}
		//아이템을 얻음으로써 능력치 증가
		maxHp += item.hp;
		maxMp += item.mp;
		att += item.att;
		def += item.def;
	}
		
}//