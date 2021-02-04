package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		// 거스름돈 동전 갯수
		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 
		 *  거스름돈 : 2860
		 *  500원 : 5개
		 *  100원 : 3개
		 *  50원 : 1개
		 *  10원 : 1개
		 */
		
		int money = (int)(Math.random()*500)*10;//10 ~ 4990
		int[] coin= {500,100,50,10};
		int[] s = new int[coin.length];
		
		/*System.out.println("거스름돈 : "+money);
		for(int i=0;i<coin.length;i++)
		{
			s[i] = money / coin[i];
			money = money%coin[i];
			System.out.println(coin[i]+"원 : "+s[i]+"개");
		}*/
		
		/*int a = 0;
		for(int i=0;i<coin.length;i++)
		{
			a = money / coin[i];
			money = money%coin[i];
			System.out.println(coin[i]+"원 : "+ a +"개");
		}
		*/
		//그래프 그리기
		/*
		 * 1~5의 숫자가 발생된(횟수) 만큼 *을 사용해 그래프를 그려주세요.
		 * ex)
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : * 1
		 */
		//첫번째방법
		int[] arr=new int[20];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		
		int[] count=new int[5];
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < count.length;j++)
			{
				if(arr[i] == j+1)
				{
					count[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		
		for(int i=0; i < count.length;i++)
		{
			System.out.print(i+1 + " : ");
			for(int j=0;j < count[i];j++)
			{
				System.out.print("*");
			}
			System.out.println(" "+count[i]);
		}
		
		//두번째방법
		/*for(int i=0;i<5;i++){
			int count2=0;
			System.out.print(i+1 + " : ");
			for(int j=0;j<arr.length;j++){
				if(arr[j]==i+1)
				{
					System.out.print("*");
					count2++;
				}
			}
			System.out.println(" "+count2);
		}*/
		
		//프로그래머스=> 레벨1. 같은 숫자는 싫어
		int[] arr2 = new int[10];
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr2));
		
		/*
		 * 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * [1, 3, 3, 2, 1, 4, 5, 5, 1, 3]
		 *  [1, 3, 2, 4, 5]
		 */
		
		int[] temp=new int[10];
		int index = 0;
		for(int i=0;i<arr2.length;i++)
		{
			boolean flag=false;
			for(int j=0;j<temp.length;j++)
			{
				if(arr2[i]==temp[j])//같은게 1번이라도 있으면 중복
				{
					flag=true;
				}
			}
			if(!flag)
			{
				temp[index++]=arr2[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result= new int[index];
		for(int i=0;i<result.length;i++){
			result[i]=temp[i];
		}
		System.out.println(Arrays.toString(result));
		
		//과제 
		//나누어 떨어지는 숫자배열
		/*
		 * 2~5사이의 랜덤한 수로 나누어 떨어지는 숫자로만 이루어진 배열을 
		 * 정렬(오름차순)하여 출력해주세요.
		 * 5
		 * [5,10,15,20,25,.....]*/
		
		arr = new int[100];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100)+1;
		}//100개의 랜덤 변수를 받기 위한 과정
		
		
		int random = (int)(Math.random()*4)+2;//나누기 위한 랜덤한 수 발생
		int[] answer = new int[100];//나눌수 있는 값들을 받기 위한 배열
		index = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%random==0){
				answer[index++]=arr[i];
			}
		}
		System.out.println(random);
		System.out.println(Arrays.toString(answer));//그중 나누어떨어지는 수들을 보여줌
		
		result=new int[index];//null값들이 들어있는 것들을 없애기 위한 함수
		for(int i=0;i<result.length;i++){
			result[i]=answer[i];
		}
		
		System.out.println(Arrays.toString(result));//null값들을 없앤 후
		
		for(int i=0;i<result.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<result.length;j++){
				if(result[min]>result[j]){
					min=j;
				}
			}
			int tmp=result[i];
			result[i]=result[min];
			result[min]=tmp;
		}
		
		System.out.println(Arrays.toString(result));//정렬후 결과
		
		answer=new int[index];
		index=0;
		for(int i=0;i<result.length;i++)
		{
			boolean flag2 = false;
			for(int j=0;j<answer.length;j++){
				if(result[i]==answer[j]){
					flag2=true;
				}
			}
			if(!flag2)
			{
				answer[index++]=result[i];
			}
		}
		System.out.println(Arrays.toString(answer));
		
		result = new int[index];
		for(int i=0;i<result.length;i++){
			result[i]=answer[i];
		}
		System.out.println(Arrays.toString(result));
		
		//코드
		/*int n = (int)(Math.random()*4)+2;
		temp = new int[100];
		index=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%n==0){
				temp[index++] =arr[i];
			}
		}
		
		arr = new int[index];
		for(int i=0;i<arr.length;i++){
			arr[i]=temp[i];
		}
		
		for(int i=0;i<arr.length-1;i++){
			int min=i;
			for(int j=0;j<arr.length;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			int tmp=arr[i];
			arr[i]=arr[min];
			arr[min]=tmp;
		}
		
		System.out.println("n : "+n);
		System.out.println(Arrays.toString(arr));*/
		
		
		
	}
}
