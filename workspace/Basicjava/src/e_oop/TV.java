package e_oop;

public class TV {//채널, 볼륨, 전원
	
	boolean power = false; //전원
	int channel = 1; //채널(제한된 숫자 안에서만 돌아가야함)
	int volume = 5; //음량(제한된 숫자 안에서만 돌아가야함)
	
	//상수로 볼륨과 채널의 최소와 최대치를 정함
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	
	void power(){//전원버튼을 누르면 커지고 켜지고=> return할것도 parameter도 필요x
		power = !power;// 버튼을 누름으로써 상태를 반대로 바꿈(false->true, true->false)
		System.out.println(power ? "TV켜짐" : "TV꺼짐");
	}
	
	//채널을 변경하는 메소드, 채널을 올리는 메소드, 채널을 내리는 메소드
	void changeChannel(int channel){//채널을 변경하다 해도 내가 얻는 것은 없음
		if(power){
			if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL){
				this.channel = channel;
				//this 전역변수와 지역변수와 이름이 똑같을떄 구분하기 위해 사용
				//this.channel은 전역변수 => 지역변수가 우선순위이기 때문에 this를 통해 전역변수 사용
			}
			System.out.println("채널 : "+this.channel);
		}
	}
	void channelUp(){
		changeChannel(channel+1);//같은 문장을 여러번 반복하지 않게 하기 위해서 위의 메소드 사용
	}

	void channelDown(){
		changeChannel(channel-1);//코드 재사용
	}
	
	void VolumnUp(){
		if(power){
			if(volume < MAX_VOLUME){//볼륨을 올릴때는 최대값이 넘으면 안되므로
				volume++;
			}
			showVolume();
		}
	}
	void VolumnDown(){
		if(power){
			if(MIN_VOLUME < volume){
				volume--;
			}
			showVolume();
		}
	}
	
	void showVolume(){
		System.out.println("음량. ");
		for(int i=MIN_VOLUME+1;i<=MAX_VOLUME;i++){
			if(i<=volume){
				System.out.print("■");
			}else{
				System.out.print("□");
			}
		}
		System.out.println();
	}
	
	//메인메소드
	public static void main(String[] args) {
		TV tv = new TV();
		
		while(true){
			System.out.println("-------------------------------");
			System.out.println("1.전원   2.채널변경   3.채널업   4.채널다운");
			System.out.println("5.볼륨 업   6.볼륨다운   0.종료");
			System.out.println("-------------------------------");
			System.out.print("번호 입력> ");
			int input = ScanUtil.nextInt();
			
			switch(input){
				case 1: tv.power();break;
				case 2:
					System.out.print("변경할 채널 입력> ");
					int ch = ScanUtil.nextInt();
					tv.changeChannel(ch);
					break;
				case 3: tv.channelUp(); break;
				case 4: tv.channelDown(); break;
				case 5: tv.VolumnUp(); break;
				case 6: tv.VolumnDown(); break;
				case 0:
					System.out.println("종료되었습니다.");
					System.exit(0);
			}
		}
	}
	
	
	//내가 하고 있던것
	/*private static Scanner sc= new Scanner(System.in);
	boolean power = false;
	int ch = 7;
	int vol = 10;
	
	public static void main(String[] args) {
		TV tv = new TV();
		System.out.print("전원을 키시겠습니까(on, off중 입력)?? ");
		String answer = sc.nextLine();
		if(answer == "ON" || answer == "on"){
		}
	}
	
	boolean onoff(){
	}
	
	String channel(int ch){
		if(power){
			return ch+"번 채널으로 이동하였습니다.";
			}
		else{return "전원이 커져있습니다.";}
	}
	
	int volumn(char sel){
		if(sel=='+'){
			vol++;
		}else if(sel=='-'){
			vol--;
		}
		return vol;
	}*/
	
}//