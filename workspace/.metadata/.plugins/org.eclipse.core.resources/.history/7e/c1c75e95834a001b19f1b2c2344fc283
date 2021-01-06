package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.JDBCUtil;

public class ManagerProdcutDao {
	private static ManagerProdcutDao instance;
	private ManagerProdcutDao(){}
	public static ManagerProdcutDao getInstance() {
		if(instance == null){
			instance = new ManagerProdcutDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> newproductname(String name) {
		String sql = "select a.prod_id, a.prod_name, a.prod_writer, b.buyer_name"
				+ " from prod a, buyer b"
				+ " where a.buyer_id = b.buyer_id"
				+ " and prod_name like %||?||%";
		
		List<Object> param = new ArrayList<>();
		param.add(name);
		return jdbc.selectList(sql, param);
	}
	
	
}//
