package d_array;

import java.util.Arrays;

public class Scores {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, java 점수를
		 * 0~100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 		  국어          영어           수학          사회        과학            Oracle   java   합계       평균             석차
		 *홍길동       90     90      90     90     90     90       90     480   90.00    1
		 *홍길동       90     90      90     90     90     90       90     480   90.00    2
		 *홍길동       90     90      90     90     90     90       90     480   90.00    3
		 *홍길동       90     90      90     90     90     90       90     480   90.00    4
		 *홍길동       90     90      90     90     90     90       90     480   90.00    5
		 *과목합계    450    450     450    450    450    450      450
		 *과목평균    90.00  90.00   90.00  90.00  90.00  90.00    90.00          
		 * */
		
		//정지수, 이현기, 윤지혜, 정이삭, 박세현, 오세일, 장병길, 배수진, 김지훈, 임태준, 
		//최희수, 전형섭, 김혜정, 송수미, 진예은, 양지수, 김도윤, 김보현, 원정훈, 문선준
		//진유리, 김동익, 이진수, 박초원, 김보미
		
		String []students = {"정지수", "이현기", "윤지혜", "정이삭", "박세현", "오세일", "장병길",
				"배수진", "김지훈", "임태준", "최희수", "전형섭", "김혜정", "송수미", "진예은",
				"양지수", "김도윤", "김보현", "원정훈", "문선준", "진유리", "김동익", "이진수",
				"박초원","김보미"};
		String[] sub={"국어", "영어", "수학", "사회", "과학", "Oracle","java"};
		
		int[][] scores = new int[students.length][sub.length];
		int[] sum = new int[scores.length];
		double []avg = new double[scores.length];
		int[] sub_sum = new int[sub.length];
		double [] sub_avg = new double[sub.length];
		int[] rank = new int[scores.length];
		
		for(int i=0;i<scores.length;i++){
			for(int j=0;j<scores[i].length;j++){
				scores[i][j] = (int)(Math.random()*101);
			}
		}//과목마다 랜덤함수를 통해 점수 0~100사이 부과
		
		for(int i=0;i<scores.length;i++){
			for(int j=0;j<scores[i].length;j++){
				sum[i]+=scores[i][j];
			}
			avg[i]=Math.round((double)sum[i]/sub.length*100)/100.0;
		}//학생별 과목 점수 합계와 평균
		
		for(int i=0;i<sub.length;i++){
			for(int j=0;j<scores.length;j++){
				sub_sum[i]+=scores[j][i];
			}
			sub_avg[i]= Math.round((double)sub_sum[i]/scores.length*100)/100.0;
		}//각각 과목별 평균과 합계
		
		for(int i=0;i<scores.length;i++){
			rank[i]=1;
			for(int j=0;j<scores.length;j++){
				if(sum[i]<sum[j]){
					rank[i]++;
				}
			}
		}//석차 구하기
		
		//정렬
		for(int i=0;i<sum.length-1;i++){
			int max=i;
			for(int j=i+1;j<sum.length;j++){
				if(sum[max]<sum[j]){
					max=j;
				}
			}
			int[] temp = scores[i];
			scores[i] = scores[max];
			scores[max]=temp;
			
			int temp2 = sum[i];
			sum[i] = sum[max];
			sum[max] = temp2;
			
			double temp3 = avg[i];
			avg[i] = avg[max];
			avg[max] = temp3;
			
			int temp4 = rank[i];
			rank[i] = rank[max];
			rank[max] = temp4;
			
			String temp5 = students[i];
			students[i] =students[max];
			students[max] = temp5;
		}
		
		//출력
		for(int i=0;i<sub.length;i++){
			System.out.print("\t"+sub[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		for(int i=0;i<scores.length;i++)
		{
			System.out.print(students[i]);
			for(int j=0;j<scores[i].length;j++)
			{
				System.out.print("\t"+scores[i][j]);
			}
			System.out.println("\t"+sum[i]+"\t"+avg[i]+"\t"+rank[i]);
		}
		
		System.out.print("과목합계");
		for(int i=0;i<sub.length;i++){
			System.out.print("\t"+sub_sum[i]);
		}
		System.out.println();
		System.out.print("과목평균");
		for(int i=0;i<sub.length;i++){
			System.out.print("\t"+sub_avg[i]);
		}
		
	}
}
