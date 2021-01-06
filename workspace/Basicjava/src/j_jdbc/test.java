package j_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();

		String sql = "select * from tb_jdbc_board where board_no = (?)";

		List<Object> param = new ArrayList();
		
		
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		for(int i = 0; i< list.size();i++){
			Map<String, Object> map = list.get(i);
			
			System.out.println(map.get("USER_ID"));
			System.out.println(map.get("CONTENT"));
			System.out.println(map.get("BOARD_NO"));
			System.out.println(map.get("TITLE"));
			System.out.println("---------------------");
		}
		System.out.println(list);
	}

}