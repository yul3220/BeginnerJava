package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*산술연산자
		 - 사칙연산 : +, -, *, /, %(나머지)
		 - 복합연산자 : +=, -=, *=, /=, %=
		 - 증감연산자 : ++, --
		 */
		int result = 10+20 - 30 * 40  /50 % 60;
		//곱하기와 나누기가 더하기 빼기보다 우선순위가 높다.(*,/,% =>+, -)
		System.out.println(result);
		
		//나머지 연산
		result = 10/3;
		System.out.println(result);
		//3.33333....이 연산의 결과여야 하지만 타입이 int이기 때문에 정수만 표현된다.
		result = 10%3;
		System.out.println(result);
		
		//Q.5개의 산술연산자를 사용해 5개의 연산을 수행 후 출력해주세요.
		result = 30 + 10;
		System.out.println(result);
		result = 30 - 10;
		System.out.println(result);
		result = 30 * 10;
		System.out.println(result);
		result = 30 / 10;
		System.out.println(result);
		result = 30 % 10;
		System.out.println(result);
		
		//복합연산자
		//변수에 저장되어 있는 값에 연산을 수행할 때 수행할 연산자와 대입연산자를 결합해 사용할 수 있다.
		result = result+3;
		System.out.println(result);
		
		result+=3;
		System.out.println(result);
		
		result-=5;
		System.out.println(result);
		
		result*=2;
		System.out.println(result);
		
		/*Q2. 아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		result= result+10;
		result=result-2*3;
		result=result%5;
		*/
		
		result+=10;
		result-=2*3;
		result%=5;
		
		//증감연산자
		//증가연산자(++):변수의 값을 1증가시킨다
		//감소연산자(--):변수의 값을 1감소시킨다.
		int i=0;
		
		++i;//전위형 : 변수의 값을 읽어오기 전에 1증가된다.
		i++;//후위형 : 변수의 값을 읽어온 후에 1증가된다.
		--i;
		i--;
		
		i=0;
		System.out.println("++i = " + ++i);
		System.out.println(i);
		i=0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int+_double;//표현범위가 더 큰 타입으로 형변환된다.
		System.out.println(result2);
		
		long _long = 100L;
		_long = _int + _long;
		//_int = _int+ _long;//오른쪽결과가 long타입으로 바뀌었는데 int형에 대입을 해야하므로 에러가 뜸
		_int = _int+ (int)_long;
		
		byte _byte = 5;
		short _short = 10;
		int result3 = _byte + _short;//int보다 작은 타입은 int로 형변환된다.
		System.out.println(result3);
		
		
		//ASCII코드 'A':65, 'a':97
		char _char = 'a';//아스키코드 97
		char _char2 = 'b';//아스키코드 98
		_int = _char + _char2;
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127;//byte => -128 ~ +127
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
		//타입을 선택할 때 연산의 범위를 고려해야한다.
		
		//Q3. 다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456+654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값  - 654321
		//5. 4번의 결과값 % 123456
		
		long result4;
		int x = 123456;
		int y = 654321;
		result4 = x+y;
		System.out.println(result4);
		result4*=x;
		System.out.println(result4);
		result4/=x;
		System.out.println(result4);
		result4-=y;
		System.out.println(result4);
		result4%=x;
		System.out.println(result4);
		
		//Q4. 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int c=15,d=27,e=38;
		int sum = c+d+e;
		double avg = sum/ 3.0; //sum/3은 둘다 int이기떄문에 한개를  double로바꿔준다.
		System.out.println("합계 : "+sum+"\t평균 : "+avg);
		
		//반올림
		//avg = Math.round(avg);//소수점 첫번째 자리에서 반올림함
		//System.out.println(avg);
		avg = Math.round(avg*100)/100.0;//둘다 정수인경우 소수점이 제대로 나오지 않음
		System.out.println(avg);
		
		//랜덤
		int random = (int)(Math.random()*100)+1;//0.0 - 0.99999999에서 1을 더함으로써 1-100사이로 변경
		System.out.println(random);
	}
	
}
