package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		//sysout + Ctrl + Spacebar : System.out.println()
		//라인삭제 : Ctrl+D
		//라인복사 : Ctrl+Alt+방향기(위/아래)
		//라인이동 : Alt+방향키(위/아래)
		
		/*
		 * 배열
		 - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 - 참조형 타입이다.(값을 저장한 주소를 찾아서 하는것)
		 - 인텍스로 값을 구분한다.
		 - 길이를 변경할 수 없다(배열은 개수를 선언하는데, 추후에 변경이 불가하다.)
		 */
		
		//배열을 만드는 첫번째 방법
		int[] array;//배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5];// 배열이 생성되고 그 주소가 저장된다. / new를 통해 선언
		//배열 초기화시 기본값(내가 저장하지 않을 때 기본적으로 저장되는 값)이 저장된다. 
		
		/*
		 * 기본값
		  - 정수 : 0
		  - 실수 : 0.0
		  - 문자 : ' '(0이 공백을 나타냄)
		  - 논리 : false
		  - 참조형 : null
		  */
		
		/*대부분 반복문 쓰면서 선언은 먼저 되어야되기때문에 int[] array 선언 후 
		array = new int[5];/array= new int[]{1, 2, 3, 4, 5};
		int[] array2 = {1, 2, 3, 4, 5};사용된다.*/
		
		//배열을 만드는 두번째 방법
		array= new int[]{1, 2, 3, 4, 5};//중괄호를 통해 값을 넣어준다. 
		//값의 개수가 배열의 길이가 됨
		
		//array = {1, 2, 3, 4, 5}; => 컴파일 에러 발생(선언과 초기화를 따로 한경우)
		//선언과 초기화를 동시에 해야한다.
		
		//배열을 만드는 세번째 방법
		int[] array2 = {1, 2, 3, 4, 5};//new int[]를 생략할 경우 바로 선언하는 경우
		//값의 개수가 배열의 길이가 됨
		
		System.out.println(array[0]);//변수뒤에 []: index , 0부터 시작
		System.out.println(array[1]);//배열을 사용할때는 인덱스 사용
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		//[] : 배열을 사용할때 붙이는것은 인덱스, 배열을 만들때 사용하는 것은 배열의 길이를 저장
		
		//배열의 값을 저장할때
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		//배열은 for문과 사용하는 경우가 많음
		
		int sum = 0;
		for(int i=0; i < array.length; i++){
			sum += array[i];
		}
		System.out.println("합계 : "+ sum);
		//array.length => 배열의 길이를 알려주는 변수(위의 경우는 5이기때문에 0 ~ 4까지 돔)
		
		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] array3 = new int[10];
		
		//Q.배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for(int i=0;i<array3.length;i++){
			array3[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(array3));
		// 만약에 에러가 발생하면 import하기
		
		//배열에 저장된 모든 값의 합계와 평균을 구해주세요.
		int sum1=0;
		double avg=0;
		
		for(int i=0;i<array3.length;i++){
			sum1 += array3[i];
		}
		avg = (double)sum1/array3.length; //둘다 int형이기 때문에 형변환 해줘야함
		System.out.println("합계는 "+sum1+" 평균은  "+avg);
		
		//Q2. 배열(array3)에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		//1. 최소값과 최대값을 저장할 변수를 만들고 0번 인덱스의 값을 저장한다.
		//2. 배열의 모든것을 비교하기 위해 0번 인덱스 부터 마지막인덱스까지 반복한다.
		int min = array3[0];
		int max = array3[0];
		
		for(int i=0;i<array3.length;i++)
		{
			//3. 최소값과 배열의 모든 인덱스 값을 비교해 더 작은 값을 만나면 최소값으로 저장한다.
			if(min>array3[i])
			{
				min = array3[i];
			}
			
			//4. 최대값과 배열의 모든 인덱스 값을 비교해 더 큰 값을 만나면 최대값으로 저장한다.
			if(max<array3[i])
			{
				max = array3[i];
			}
		}
		
		System.out.println("최소값 : "+min+" 최댓값 : "+max);
		
		//------------------------------
		int[] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i+1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//Q3. 배열의 값을 섞어주세요.
		int tmp = 0;
		
		for(int i=0;i<100;i++){
			//0-9사이의 랜덤한 인덱스를 발생시킨다.
			int index = (int)(Math.random()*shuffle.length);
			
			//0번인덱스의 값과 랜덤한 인덱스와 값을 바꾼다.
			tmp = shuffle[0];
			shuffle[0] = shuffle[index];
			shuffle[index] = tmp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		
		//Q4. 1~10사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] array4 = new int[500];
		int[] count = new int[10];
		int sum3 = 0;
		
		for(int i =0 ;i<array4.length;i++)
		{
			array4[i] = (int)(Math.random()*10)+1;
			for(int j=1;j<=count.length;j++)
			{
				if(j == array4[i])
				{
					count[j-1] +=1;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		
		for(int i=0;i<count.length;i++)
		{
			System.out.println(i+1 + "의 횟수는 "+ count[i]);
			sum3 += count[i];
			System.out.println(sum3);
		}
			
		//과제
		//위 문제의 최소값, 최대값, 발생횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		//최소값~최대값, 발생횟수
		//실질적으로 random함수는 0.0~0.99....까지출력
		//=>100곱하고 int형으로 바꿔줌으로써 0-99=>+1하면 1-100
		Scanner sc = new Scanner(System.in);
		System.out.print("최소값을 입력하시오(0이상의 값)> ");
		int min2= Integer.parseInt(sc.nextLine());
		System.out.print("최대값을 입력하시오(0이상의 값)> ");
		int max2= Integer.parseInt(sc.nextLine());
		System.out.print("발생횟수을 입력하시오(0이상의 값)> ");
		int occ_count= Integer.parseInt(sc.nextLine());
		
		int[] array5 = new int[occ_count];
		int[] count2 = new int[max2-min2+1];
		int sum4=0;
		
		for(int i=0;i<array5.length;i++)
		{
			array5[i] = (int)(Math.random()*(max2-min2+1))+min2;
			for(int j = 0;j<max2-min2+1;j++)
			{
				if(j+min2 == array5[i])
				{
					count2[j] +=1;
				}
			}
		}
		
		System.out.println(Arrays.toString(array5));
		System.out.println(Arrays.toString(count2));
		System.out.println("==================");
		System.out.println("횟수                            합계");
		System.out.println("==================");
		
		for(int i=0;i<count2.length;i++)
		{
			System.out.print(i+min2 + "의 횟수는 "+ count2[i]+"번");
			sum4 += count2[i];
			System.out.print("\t"+sum4+"\n");
		}
		
		
		System.out.print("최소값> ");
		int _min= Integer.parseInt(sc.nextLine());
		System.out.print("최대값> ");
		int _max= Integer.parseInt(sc.nextLine());
		System.out.print("발생횟수)> ");
		int _repeat= Integer.parseInt(sc.nextLine());
		
		int[] counts = new int[_max-_min+1];
	
		for(int i=0;i<_repeat;i++){
			int random=(int)(Math.random()*(_max-_min+1))+_min;
			
			counts[random-_min]++;	
		}
		
		
	}
}
