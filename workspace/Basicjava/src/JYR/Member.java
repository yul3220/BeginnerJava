package JYR;

public class Member {
	String id;
	String password;
	int number;
	
	Member(String id, String password,int number){
		this.id = id;
		this.password = password;
		this.number = number;
	}
	
	String print(){
		return "아이디 : "+id+"   / 비밀번호 : "+password;
	}
	
	String getId(){
		return id;
	}
	
	String getPassword(){
		return password;
	}
}
