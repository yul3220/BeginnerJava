package service;

import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.UserDao;

public class UserService {
	
	private static UserService instance;
	private UserService(){}
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	//회원가입
	public int join(){
		System.out.println("=============== 회원가입 ==================");
		System.out.print("아이디 > ");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호 > ");
		String password = ScanUtil.nextLine();
		System.out.print("이름 > ");
		String userName = ScanUtil.nextLine();
		
		//아이디 중복확인, 비밀번호 확인, 정규표현식(유효성검사) => 현재는 생략
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		int result = userDao.insertUser(param);
		
		if(0<result){
			System.out.println("회원가입성공");
		}else{
			System.out.println("회원가입실패");
		}
		//Service에서는 DB에 접속하면 안됨, Dao를 통해 접속
		
		return View.HOME;
	}
	
	public int login() {
		System.out.println("=============== 로그인 ===============");
		System.out.print("아이디> ");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String password = ScanUtil.nextLine();
		//아이디와 비밀번호가 같은 사람을 찾기
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){//user.size() == 0
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			System.out.println("로그인 성공");
			
			//로그인이 성공했다는 것은 user의 아이디를 어딘가에 저장하고 있다는 뜻
			//Controller에 변수를 만들어서 저장
			Controller.LoginUser = user;
			
			return View.BOARD_LIST;//로그인을 성공하면 메인 화면으로 넘어감
		}
		
		return View.LOGIN;
	}
	 
}//
