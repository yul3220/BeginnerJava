package e_oop.score;

public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		//참조형의 기본값으로  null로 들어감, null은 값이 들어간것이 아니기때문에
		//공간만 만들어지고 값이 들어간것이 아님
		//내가 원하는 타입들을 클래스에 넣어놓고 클래스를 타입처럼 사용
		
		//Student student = new Student(); 
		//=> for문밖에서 먼저 선언한 경우 학생을 한명만 만든 후 데이터를 계속바꾸는거
		String[] subjects = {"국어", "영어", "수학"};
		int[] subsum = new int[subjects.length];
		double[] subavg = new double[subjects.length];
		
		for(int i =0; i<students.length; i++){
			Student student = new Student();//10명의 학생을 만들기 위함
			
			student.name = "학생"+ (i + 1);
			student.rank = 1;
			student.kor = (int)(Math.random() * 101);
			student.eng = (int)(Math.random() * 101);
			student.math = (int)(Math.random() * 101);
			
			students[i] = student;
		}
		
		//성적관리 프로그램을 만들어주세요.
		/*for(int i=0;i<students.length;i++){
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round((double)students[i].sum/subjects.length*100)/100.0;
			subsum[0] += students[i].kor;
			subsum[1] += students[i].eng;
			subsum[2] += students[i].math;
		}
		
		for(int i=0;i<subjects.length;i++){
			subavg[i] = Math.round((double)subsum[i]/students.length*100)/100.0;
		}
		
		for(int i=0;i<students.length;i++){
			for(int j=0;j<students.length;j++){
				if(students[i].sum<students[j].sum){
					students[i].rank++;
				}
			}
		}
		
		for(int i=0;i<students.length-1;i++){
			int max=i;
			for(int j=i+1;j<students.length;j++){
				if(students[max].rank>students[j].rank){
					max=j;
				}
			}
			
			Student tmp = students[i];
			students[i] = students[max];
			students[max] = tmp;
		}
		
		
		for(int i=0;i<subjects.length;i++){
			System.out.print("\t"+subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		
		for(int i=0;i<students.length;i++)
		{
			System.out.print(students[i].name+"\t"+students[i].kor+ 
					"\t"+students[i].eng + "\t" + students[i].math + 
					"\t" + students[i].sum + "\t"+students[i].avg+
					"\t"+students[i].rank);
			System.out.println();
		}
		
		System.out.print("과목합계");
		for(int i=0;i<subjects.length;i++){
			System.out.print("\t"+subsum[i]);
		}
		System.out.println();
		System.out.print("과목평균");
		for(int i=0;i<subjects.length;i++){
			System.out.print("\t"+subavg[i]);
		}*/
		
		//교수님 해결방법
		
		//합계와 평균
		for(int i=0;i<students.length;i++){
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round(students[i].sum/3.0*100)/100.0;
		}
		
		//석차
		for(int i=0;i<students.length;i++){
			for(int j=0;j<students.length;j++){
				if(students[i].sum<students[j].sum){
					students[i].rank++;
				}
			}
		}
		
		//정렬
		for(int i=0; i < students.length; i++){
			int min = i;
			for(int j=i+1; j < students.length; j++){
				if(students[j].rank < students[min].rank){
					min=j;
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
		
		//출력
		System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for(int i=0;i<students.length;i++){
			System.out.print(students[i].name+"\t");
			System.out.print(students[i].kor+"\t");
			System.out.print(students[i].eng+"\t");
			System.out.print(students[i].math+"\t");
			System.out.print(students[i].sum+"\t");
			System.out.print(students[i].avg+"\t");
			System.out.println(students[i].rank);
		}
		
		//과목별합계
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for(int i=0;i<students.length;i++){
			korSum += students[i].kor;
			engSum += students[i].eng;
			mathSum += students[i].math;
		}
		
		//과목별평균
		double korAvg = (double)korSum / students.length;
		double engAvg = (double)engSum / students.length;
		double mathAvg = (double)mathSum / students.length;
		System.out.println("과목합계\t"+korSum + "\t"+engSum + "\t"
				+ mathSum);
		System.out.println("과목평균\t"+korAvg + "\t"+engAvg + "\t"
				+ mathAvg);
	}
}
