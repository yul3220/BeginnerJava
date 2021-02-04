package d_array;

public class StringSpeedTest {

	public static void main(String[] args) {
		String str = "a";
		//str+= "a";=>a+a가 더해지는 것이 아니라 a를 버리고 aa로 바꾼다.
		//문자열은 변경을 하면 기존에 있던것을 붙이는게 아니라 아예 새로운 것을 만든다.
		
		/*long start = System.currentTimeMillis();
		for(int i=0;i<200000;i++){
			str+="a";
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start + "ms");
		//10000=>47ms , 100000=> 1740ms , 200000=> 6311ms
		 */		
		
		StringBuffer sb = new StringBuffer("a");
		//String의 문제점을 해결하기 위해 나온 함수 : StringBuffer
		
		long start = System.currentTimeMillis();
		for(int i=0;i<200000000;i++){
			sb.append("a");
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start + "ms");
		//200000=>7ms정도, 200000000=>3717ms
	}
}
