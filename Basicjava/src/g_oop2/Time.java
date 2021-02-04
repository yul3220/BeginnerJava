package g_oop2;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	//Source메뉴에서 Generate Getters and Setters를 통해서 가져옴
	public int getHour() {//Getter /gethour를 통해 값을 가져온후
		return hour;
	}

	public void setHour(int hour) {//Setter /sethour를 통해 값을 저장
		if(hour<0){
			this.hour = 0;
		}else if(23<hour){
			this.hour = 0;

		}else{
			this.hour = hour;
		}
		
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute<0){
			this.minute = 0;
		}else if(59<minute){
			this.minute = 0;
			setHour(hour+1);
		}else{
			this.minute = minute;
		}
		
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second<0){
			this.second = 0;
		}else if(59<second){
			this.second = 0;
			setMinute(minute+1);
		}else{
			this.second = second;
		}
		
	}

	String getTime(){
		return hour+":"+minute+":"+second;
	}
	
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(100);//1000=>1s
			setSecond(second+1);
		}
	}
	
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	//시계를 만들기 위한 부수적인 메서드, 사용자가 필요한 메서드는 아니다.
	//=>따라서 private를 붙여줌
}//
