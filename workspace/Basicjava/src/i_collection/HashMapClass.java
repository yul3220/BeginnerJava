package i_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 저장된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		//HashMap은 인덱스로 저장하는게 아니라 키를 통해서 저장한다.
		
		HashMap<String, Object> map = new HashMap<>();
		//제네릭을 설정할때도 키의 타입과 값의 타입 두개를 작성해야한다.
		//키를 알면 값의 타입도 어느정도 알수 있기때문에 Object를 사용하는 경우도 있다.
		
		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Scanner(System.in));
		//타입이 Object이기때문에 모든 타입 저장 가능
		//키를 우리가 지정하는 것이기때문에 순서라는 개념이 존재하지 않음
		
		System.out.println(map);
		
		map.put("b", "이순신");// 덮어쓴다.(같은키를 사용하는 경우)
		System.out.println(map);
		
		map.remove("c");
		System.out.println(map);

		Object value = map.get("b");
		System.out.println(value);

		//Object타입을 사용하는 경우  => 사용하기 불편하기 때문에 형변환시킴
		int value1 = (Integer)map.get("a");
		String value2 = (String)map.get("b");
		
		//Set keySet() => map에 저장된 키를 모르거나 모든값을 가지고 오고 싶을 때 사용
		Set<String> keys = map.keySet();//저장된 모든키
		
		//keys에 있는 모든 값들을 key에 저장해서 돌림
		//keySet을 사용하는 경우의 for문형식은 이런경우에 자주 사용
		//타입은 keys의 타입으로 지정
	    for(String key: keys){
	    	System.out.println(key + " : "+map.get(key));
	    }
	    
	    ArrayList<Integer> list = new ArrayList<>();
		
	    for(int i : list){
	    	
	    }
	    
	    //해쉬맵을 사용하는 경우 : 데이터베이스의 테이블을 표현할때 사용
	    //회원테이블 : 아이디, 비밀번호, 이름, 전화번호
	    /*
	     * id		password	name	tel
	     * admin	admin123	관리자	010-1234-5678
	     */
	    
	    HashMap<String, String> user = new HashMap<>();//HashMap하나가 한줄이 됨
	    user.put("id", "admin");
	    user.put("password", "admin123");
	    user.put("name", "관리자");
	    user.put("tel","010-1234-5678");
	    
	    System.out.println(user);
	    
	    
	    //여러개의 HashMap을 리스트에 저장하면 하나의 테이블이된다.
	    ArrayList<HashMap<String, String>> table = new ArrayList<>();
	    table.add(user);
	    
	    HashMap<String, String> user2 = new HashMap<>();
	    user2.put("id", "admin2");
	    user2.put("password","admin21234");
	    user2.put("name", "관리자22");
	    user2.put("tel", "010-5678-1234");
	    table.add(user2);
	    
	    //첫번째방법
	    for(HashMap<String, String> hashmap: table){
	    	Set<String> users = hashmap.keySet();
	    	for(String key: users){
	    		System.out.println(hashmap.get(key));
	    	}
	    }
	    
	    //두번째방법
	    for(int i = 0; i<table.size();i++){
	    	HashMap<String, String> hashMap = table.get(i);
	    	Set<String> keySet = hashMap.keySet();
	    	for(String key: keySet){
	    		System.out.println(key+" : "+hashMap.get(key));
	    	}
	    	System.out.println("-----------------------------------");
	    }
	    
	  
	}//main
}//
