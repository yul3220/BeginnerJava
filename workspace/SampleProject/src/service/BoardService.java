package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;

public class BoardService {

	private static BoardService instance;
	private BoardService(){}
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	private int currentBoardNo;//전역변수를 통해 현재 조회한 게시판의 넘버를 넘겨줌
	
	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("=======================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------");
		for(int i = 0; i< boardList.size(); i++){
			Map<String, Object> board = boardList.get(i);
			System.out.println(board.get("BOARD_NO")+ "\t"
					+ board.get("TITLE")+"\t"
					+ board.get("USER_NAME")+"\t"
					+ board.get("REG_DATE"));
		}
		System.out.println("=======================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print("입력> ");
		
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1:
			System.out.print("게시글 번호 입력> ");
			currentBoardNo = ScanUtil.nextInt();
			return View.BOARD_VIEW;
		case 2:
			return View.BOARD_INSERT_FORM;
		case 0:
			Controller.LoginUser = null;
			return View.HOME;
		}
		return View.BOARD_LIST;
	}
	
	public int boardview(){
		
		Map<String, Object> board = boardDao.viewBoardList(currentBoardNo);
		
		System.out.println("---------------------------------");
		System.out.println("게시판번호 : "+board.get("BOARD_NO"));
		System.out.println("---------------------------------");
		System.out.println("작성자 : "+board.get("USER_NAME"));
		System.out.println("게시일 : "+board.get("REG_DATE"));
		System.out.println("---------------------------------");
		System.out.println("제목 : "+board.get("TITLE"));
		System.out.println("내용 : "+board.get("CONTENT"));
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("1.수정\t2.삭제\t0.되돌아가기");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.print("번호 입력> ");
		int input = ScanUtil.nextInt();
		switch(input){
		case 1: return View.BOARD_UPDATE_FORM; 
		case 2: return View.BOARD_DELETE_FORM;
		case 0: break;
		}
		return View.BOARD_LIST;
	}
	
	public int boardupdate(Map<String, Object> loginUser){
		System.out.print("바꾸고 싶은 제목을 입력> ");
		String title = ScanUtil.nextLine();
		System.out.print("바꾸고 싶은 내용을 입력> ");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.UpdateBoard(title, content, currentBoardNo, loginUser);
		
		if(result>0){
			System.out.println("수정완료!!");
		}else{
			System.out.println("수정실패!!");
		}
		return View.BOARD_LIST;
	}
	
	public int boarddelete(Map<String, Object> loginUser){
		int result = boardDao.DeleteBoard(currentBoardNo, loginUser);
		
		if(result>0){
			System.out.println("삭제완료!!");
		}else{
			System.out.println("삭제실패!!");
		}

		return View.BOARD_LIST;
	}
	
	public int boardinsert(Map<String, Object> loginUser){
		System.out.print("제목을 입력> ");
		String title = ScanUtil.nextLine();
		System.out.print("내용을 입력> ");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.InsertBoard(title, content, loginUser);
		
		if(result>0){
			System.out.println("등록완료!!");
		}else{
			System.out.println("등록실패!!");
		}
		return View.BOARD_LIST;
	}
	
}//
