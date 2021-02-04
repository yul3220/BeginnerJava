package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
	ArrayList<HashMap<String, String>> boardList = new ArrayList<>();
	final String NUM = "num";
	final String TITLE = "title";
	final String CONTENT = "content";
	final String WRITER = "writer";
	final String DATE = "date";
	Scanner sc = new Scanner(System.in);
	HashMap<String, String> board = new HashMap<>();
	int count = 0;

	/*{
		board = new HashMap<>();
		board.put(NUM, "1");
		board.put(TITLE, "건의합니다");
		board.put(CONTENT, "건의하고싶은내용이있습니다.");
		board.put(WRITER, "홍길동");
		board.put(DATE, "2020/12/14 18:10:15");
		boardList.add(board);

		board = new HashMap<>();
		board.put(NUM, "2");
		board.put(TITLE, "칭찬합니다.");
		board.put(CONTENT, "칭찬하고싶은내용이있습니다.");
		board.put(WRITER, "홍동길");
		board.put(DATE, "2020/12/15 03:20:00");
		boardList.add(board);
	}*/

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * number, title, content, writer, date
		 * 
		 * --------------------------------
		 * 번호	제목		작성자	작성일
		 * --------------------------------
		 * 4	안녕하세요	홍길동	12/15
		 * 3	안녕하세요	홍길동	12/15
		 * 2	안녕하세요	홍길동	12/15
		 * 1	안녕하세요	홍길동	12/15
		 * ------------------------------
		 * 1. 조회(조회를 한후 수정,삭제)  2.등록  5.종료
		 * */

		Board boards = new Board();
		boards.start();
	}//main

	void start() {
		boolean run = true;
		while(run){
			System.out.println();
			System.out.println("=========================================================");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			System.out.println("=========================================================");
			if(boardList.size()>0){
				for(int i = boardList.size()-1; 0 <= i;i--){
					HashMap<String, String> hashMap = boardList.get(i);

					System.out.print(hashMap.get(NUM)+"\t");
					System.out.print(hashMap.get(TITLE)+"\t\t");
					System.out.print(hashMap.get(WRITER)+"\t");
					System.out.print(hashMap.get(DATE)+"\t");
					System.out.println();
				}
			}else{System.out.println("게시판에 등록된 내용이 없습니다.");}
			System.out.println("=========================================================");
			System.out.println("1.조회\t2.등록\t3.나가기");
			System.out.print("선택(1.조회 2.등록 3.나가기) : ");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
			case 1:
				check();
				break;
			case 2:
				sign();
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
	}//start끝


	void sign(){
		board = new HashMap<>();
		board.put(NUM, Integer.toString(count+1));
		count++;
		System.out.print("제목을 등록하시오> ");
		String title = sc.nextLine();
		board.put(TITLE, title);
		System.out.print("내용을 등록하시오> ");
		String content = sc.nextLine();
		board.put(CONTENT, content);
		System.out.print("작성자를 등록하시오> ");
		String writer = sc.nextLine();
		board.put(WRITER, writer);
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		board.put(DATE, dateformat.format(date_now));
		boardList.add(board);
		System.out.println("등록 완료!");

	}//sign끝

	void check(){
		System.out.print("조회하고 싶은 번호를 입력> ");
		String input = sc.nextLine();
		for(int i = 0;i<boardList.size();i++){
			HashMap<String, String> hashMap = boardList.get(i);
			if(!hashMap.get(NUM).equals(input)&& i == boardList.size()){
				break;
			}
			else if(hashMap.get(NUM).equals(input)){
				System.out.println("-----------------------------");
				System.out.println("번호 : "+ hashMap.get(NUM));
				System.out.println("-----------------------------");
				System.out.println("작성자 : "+ hashMap.get(WRITER));
				System.out.println("작성날짜 : "+ hashMap.get(DATE));
				System.out.println("-----------------------------");
				System.out.println("제목 : "+ hashMap.get(TITLE));
				System.out.println("내용 : "+ hashMap.get(CONTENT));
				System.out.println("-----------------------------");

				System.out.println();
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println("1.수정\t2.삭제\t3.나가기");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.print("원하는 항목의 번호를 입력 > ");
				System.out.println();
				int input2 = Integer.parseInt(sc.nextLine());
				switch(input2){
				case 1:
					change();
					break;
				case 2:
					delete();
					break;
				case 3:
					start();
					break;
				}
			}
		}


	}//check끝


	void delete(){
		System.out.print("삭제하고 싶은 번호를 선택> ");
		String delete = sc.nextLine();
		for(int i = 0;i<boardList.size();i++){
			HashMap<String, String> hashMap = boardList.get(i);
			if(hashMap.get(NUM).equals(delete)){
				boardList.remove(i);
				System.out.println("삭제 완료!");
			}
		}
	}//delete끝

	void change(){
		System.out.print("수정하고 싶은 번호를 선택> ");
		String change = sc.nextLine();
		for(int i = 0;i<boardList.size();i++){
			HashMap<String, String> hashMap = boardList.get(i);
			if(hashMap.get(NUM).equals(change)){
				System.out.println("기존 내용 : "+hashMap.get(CONTENT));
				System.out.print("바꾸고 싶은 내용을 입력하세요> ");
				String content = sc.nextLine();
				hashMap.put(CONTENT, content);
				boardList.set(i, hashMap);
				System.out.println("수정 완료!");
			}
		}
	}//change끝

}//

