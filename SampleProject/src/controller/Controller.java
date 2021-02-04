package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연(약 15분)
		 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능
		 * Dao : 쿼리작성
		 * 
		 * 12/31 : 프로젝트 발표
		 * 메뉴 구조 : 이 프로그램이 어떤 구조로 이루어져있는지 소개
		 * 화면이동 => 메인에서 다른메뉴로 이동할때의 이동하는 것
		 */
		
		new Controller().start();
	}
	
	public static Map<String, Object> LoginUser;
	//이 변수에 값이 들어있다는 것은 해당 유저가 로그인을 했다는 것이고, 값이 들어있지 않는경우 로그인을 하지 않은 상태
	
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		int view = View.HOME;
		//다음 화면에 대한 리턴을 받아야 함
		
		while(true){
			switch(view){
				case  View.HOME: view = home(); break;
				case  View.LOGIN: view = userService.login(); break;
				case  View.JOIN: view = userService.join(); break;
				case  View.BOARD_LIST: view = boardService.boardList(); break;
				case  View.BOARD_VIEW: view = boardService.boardview(); break;
				case  View.BOARD_INSERT_FORM: view = boardService.boardinsert(LoginUser);break;
				case  View.BOARD_UPDATE_FORM: view = boardService.boardupdate(LoginUser); break;
				case  View.BOARD_DELETE_FORM: view = boardService.boarddelete(LoginUser); break;
			}
		}		
	}
	
	private int home(){
		System.out.println("------------------------------------------------");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("------------------------------------------------");
		System.out.print("번호 입력> ");
		
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0: System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
		}
		return View.HOME;
	}
	
}//
