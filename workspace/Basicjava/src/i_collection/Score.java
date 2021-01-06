package i_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		/*
		 * 2차원 arraylist사용
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

		ArrayList<String> students = new ArrayList<>();
		students.add("정지수");
		students.add("이현기");
		students.add("윤지혜");
		students.add("정이삭");
		students.add("박세현");//5
		students.add("오세일");
		students.add("장병길");
		students.add("배수진");
		students.add("김지훈");
		students.add("임태준");//10
		students.add("최희수");
		students.add("전형섭");
		students.add("김혜정");
		students.add("송수미");
		students.add("진예은");//15
		students.add("양지수");
		students.add("김도윤");
		students.add("김보현");
		students.add("원정훈");
		students.add("문선준");//20
		students.add("진유리");
		students.add("김동익");
		students.add("이진수");
		students.add("박초원");
		students.add("김보미");//25
		
		ArrayList<String> subject = new ArrayList<>();
		subject.add("국어");
		subject.add("영어");
		subject.add("수학");
		subject.add("사회");
		subject.add("과학");
		subject.add("Oracle");
		subject.add("java");
		
		ArrayList<Integer> addList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		ArrayList<Integer> StudentSum = new ArrayList<>();
		ArrayList<Double> StudentAvg = new ArrayList<>();
		
		//과목마다 랜덤함수를 통해 점수 0~100사이 부과 + 학생별 과목 점수 합계와 평균
		for(int i=0;i<students.size();i++){
			addList = new ArrayList<>();
			int sum = 0;
			for(int j=0;j<subject.size();j++){
				addList.add((int)(Math.random()*101));
				sum += addList.get(j);
			}
			scores.add(addList);
			StudentSum.add(sum);
			StudentAvg.add(Math.round((double)StudentSum.get(i)/subject.size()*100)/100.0);
		}
		
		
		//각각 과목별 평균과 합계
		ArrayList<Integer> SubjectSum = new ArrayList<>();
		ArrayList<Double> SubjectAvg = new ArrayList<>();
		
		for(int i =0;i<subject.size();i++){
			int num = 0;
			for(int j=0;j<students.size();j++){
				num+=scores.get(j).get(i);
			}
			SubjectSum.add(num);
			SubjectAvg.add(Math.round((double)SubjectSum.get(i)/students.size()*100)/100.0);
		}
		
		//석차 구하기
		ArrayList<Integer> ranks = new ArrayList<>();
		
		for(int i=0;i<scores.size();i++){
			ranks.add(1);
			for(int j=0;j<scores.size();j++){
				if(StudentSum.get(i)<StudentSum.get(j)){
						ranks.set(i, ranks.get(i)+1);
					}
			}
		}
		
		
		//정렬
		for(int i=0;i<students.size()-1;i++){
			int min = i;
			for(int j = i+1;j<students.size();j++){
				if(StudentSum.get(j)>StudentSum.get(min)){
					min = j;
				}
			}
			
			ArrayList<Integer> temp = scores.get(i);
			scores.set(i, scores.get(min));
			scores.set(min, temp);
			
			int temp2 = StudentSum.get(i);
			StudentSum.set(i, StudentSum.get(min));
			StudentSum.set(min, temp2);
			
			double temp3 = StudentAvg.get(i);
			StudentAvg.set(i, StudentAvg.get(min));
			StudentAvg.set(min, temp3);
			
			int temp4 = ranks.get(i);
			ranks.set(i, ranks.get(min));
			ranks.set(min, temp4);
			
			String temp5 = students.get(i);
			students.set(i, students.get(min));
			students.set(min, temp5);
		}
		
		
		for(int i = 0;i<subject.size();i++){
			System.out.print("\t"+subject.get(i));
		}
		System.out.println("\t합계\t평균\t석차");
		for(int i = 0; i < students.size(); i++){
			System.out.print(students.get(i)+"\t");
			for(int j = 0; j < subject.size(); j++){
				System.out.print(scores.get(i).get(j)+"\t");
			}
			System.out.println(StudentSum.get(i)+"\t"+StudentAvg.get(i)+"\t"+ranks.get(i));
		}
		System.out.print("과목합계\t");
		for(int i = 0;i<subject.size();i++){
			System.out.print(SubjectSum.get(i)+"\t");
		}
		System.out.println();
		System.out.print("과목평균\t");
		for(int i = 0;i<subject.size();i++){
			System.out.print(SubjectAvg.get(i)+"\t");
		}
		
	}//main
}//
