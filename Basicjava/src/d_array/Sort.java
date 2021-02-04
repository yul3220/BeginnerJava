package d_array;

import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args){
		
		/*
		 * 정렬
		 - 석차구하기 : 정수를 비교해 작은 정수의 등수를 증가시키는 방식
		 - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 - 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식*/
		
		//석차구하기
		int[] arr = new int[10];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(" "+Arrays.toString(arr));
		
		
		int[] rank = new int[arr.length];
		for(int i = 0;i < rank.length; i++){
			rank[i]=1;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			//rank[i]=1; 넣어도 상관x
			for(int j=0;j<rank.length;j++)
			{
				if(arr[i]<arr[j])
				{
					rank[i]++;
				}
			}
		}
		System.out.println("석차 :"+Arrays.toString(rank));
		
		int[] arr2 = new int[10];
		
		for(int i=0;i<arr2.length;i++){
			arr2[i] = (int)(Math.random()*100)+1;
		}
		
		System.out.println("선택정렬 전 : "+Arrays.toString(arr2));

		//선택정렬
		/* i, j(i+1)
		 * 0,1	0,2	  0,3   0,4   0,5   0,6   0,7  0,8  0,9  
		 * 1,2	1,3   1,4   1,5   1,6   1,7   1,8  1,9
		 * 2,3  2,4   2,5   2,6   2,7   2,8   2,9
		 * 3,4  3,5   3,6   3,7   3,8   3,9
		 * 4,5  4,6   4,7   4,8   4,9 
		 * 5,6  5,7   5,8   5,9
		 * 6,7  6,8   6,9
		 * 7,8  7,9
		 * 8,9
		 => i는 9가 없기 때문에 arr2.length-1, j는 i다음행부터 비교해야 함으로 i+1*/
		
		for(int i=0;i<arr2.length-1;i++)
		{
			int min=i;//값을 찾는게 아니라 인덱스의 위치를 찾아야 하기 때문에
			for(int j=i+1;j<arr2.length;j++)
			{
				if(arr2[min]>arr2[j]){
					min=j;//최소값을 가지는 인덱스 번호를 알수 있음
				}
			}
			int temp=arr2[i];
			arr2[i]=arr2[min];
			arr2[min]=temp;
			//System.out.println(Arrays.toString(arr2));
		}
		System.out.println("선택정렬 후 :"+Arrays.toString(arr2));
		
		//버블정렬
		//0번인덱스부터 시작해서 바로 뒤의 숫자와 비교해서 맨뒤로 보냄
		/* j, j+1
		 * 0,1	1,2	  2,3   3,4   4,5   5,6   6,7  7,8  8,9  i=0
		 * 0,1	1,2	  2,3   3,4   4,5   5,6   6,7  7,8  i=1
		 * 0,1	1,2	  2,3   3,4   4,5   5,6   6,7  i=2
		 * 0,1	1,2	  2,3   3,4   4,5   5,6   i=3
		 * 0,1	1,2	  2,3   3,4   4,5   i=4
		 * 0,1	1,2	  2,3   3,4   i=5
		 * 0,1	1,2	  2,3   i=6
		 * 0,1	1,2	   i=7
		 * 0,1	 i=8 */
		
		
		//버블정렬 + 한번도 자리를 안바꾸는 경우 for문을 끝내게 하긴 위해
		for(int i=0;i<arr.length;i++)
		{
			boolean flag = false;//boolean타입의 결과를 통해 들어온 경우를 알수 있음
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1]){	
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					flag = true;
				}//자리를 바꿨다는 것은 if문에 한번이라도 들어오는 경우
			}
			//flag==false
		
			if(!flag){//!false=>true여서 참이기 때문에 if문 실행
				break;
			}
			
		}
		System.out.println("버블정렬:"+Arrays.toString(arr));
		
		//삽입정렬
		//두번째 숫자를 변수에 저장한다.
		//앞의 숫자와 비교해서 큰수를 만나면 한칸뒤로 보낸다.
		//작은수를 만나면 작은수의 바로 뒷칸에 변수의 값을 저장하고 반복문을 빠져나간다.
		/* i,j
		 * 1,0
		 * 2,1	2,0
		 * 3,2	3,1	  3,0
		 * 4,3	4,2	  4,1  4,0
		 * 5,4	5,3	  5,2  5,1  5,0
		 * 6,5  6,4	  6,3  6,2  6,1  6,0
		 * 7,6  7,5   7,4  7,3  7,2  7,1  7,0
		 * 8,7  8,6   8,5  8,4  8,3  8,2  8,1  8,0
		 * 9,8  9,7   9,6  9,5  9,4  9,3  9,2  9,1  9,0*/
		
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int j = 0;
			for(j = i-1 ; j>=0 ; j--)
			{
				if(temp<arr[j])
				{
					arr[j+1] = arr[j];//여기까지 했음
				}else{
					break;
				}
			}
			arr[j+1] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
