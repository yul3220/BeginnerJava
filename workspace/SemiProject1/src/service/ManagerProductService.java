package service;

import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import dao.ManagerProdcutDao;

public class ManagerProductService {
	private static ManagerProductService instance;
	private ManagerProductService(){}
	public static ManagerProductService getInstance() {
		if(instance == null){
			instance = new ManagerProductService();
		}
		return instance;
	}
	
	ManagerProdcutDao managerproductdao = ManagerProdcutDao.getInstance();
	
	public int ManagerNewProductMain(){
		System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
		System.out.println("1.등록\t2.수정\t3.삭제\t0.돌아가기");
		System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
		System.out.print("번호 입력 : ");
		int input = ScanUtil.nextInt();
		switch(input){
			case 1: break;
			case 2: break;
			case 3: break;
			case 0: break;
		}
		return View.MANAGERPRODUCT_MAIN;
	}
	
	public int ManagerNewProductInsert(){
		System.out.println("***********일반상품 등록***********");
		System.out.print("책 이름을 입력 : ");
		String name = ScanUtil.nextLine();
		List<Map<String, Object>> list = managerproductdao.newproductname(name);
		for(int i =0; i<list.size();i++){
			System.out.println("상품ID : "+list.get(i).get("PROD_ID"));
			System.out.println("제목 : "+list.get(i).get("PROD_NAME"));
			System.out.println("저자 : "+list.get(i).get("PROD_WRITER")
					+"\t 출판사 : ");
		}
		return 0;
	} 
}//
