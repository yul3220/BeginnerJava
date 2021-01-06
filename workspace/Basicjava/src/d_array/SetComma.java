package d_array;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//10000000000 => 10,000,000,000 => 숫자를 입력받을때 int타입말고 string타입으로 입력받기

		/*
		 - equals() : 문자열의 내용이 같은지 반환한다.
		 - length() : 문자열의 길이를 반환한다.
		 - charAt() : 특정 인덱스에 위치한 문자를 반환한다.
		 - substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 - indexOf() :  문자열 내의 특정 문자의 인덱스를 반환한다.
		 - contains() : 문자열이 특정 문자열을 포함하고 있는지 반환한다.
		 - split() : 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 - trim() : 문자열 앞뒤의 공백을 제거해 반환한다.//맨얖이나 맨뒤의 공백만 제거
		 - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 */

		/*Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력>");
		String num = sc.nextLine();
		int comma = num.length() % 3;
		String savenum = "";
		if(comma!=0){
			savenum = num.substring(0,comma);
			savenum+=",";
		}
			
		for(int i=comma;i<num.length()-2;i+=3)
		{
			if(i==num.length()-3)
			{
				savenum += num.substring(i,i+3);
				break;
			}
			else
			{
				savenum+=num.substring(i,i+3);
				savenum += ",";
			}
		}
		System.out.println(savenum);*/
		
		//교수님 방식
		Scanner s = new Scanner(System.in);
		System.out.println("숫자 입력>");
		String number = s.nextLine();
		String comma=" ";
		int count = 0 ;//숫자가 3번 다 들어왔는지 확인하는 용도
		
		for(int i=number.length()-1;i>=0;i--){
			comma = number.charAt(i) + comma;
			count++;
			if(count%3==0 && count != number.length()){
				comma =","+comma;
			}//앞의 조건은 3번이 다 들어왔는지, 뒤의 조건은 맨앞의 콤마를 없애기 위해
			//길이와 같지 않게끔 만듬
		}
		System.out.println(comma);
		
		
		
	}
}
