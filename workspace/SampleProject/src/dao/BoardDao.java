package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {
	
	private static BoardDao instance;
	private BoardDao(){}
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A.USER_ID = B.USER_ID"
				+ " ORDER BY A.BOARD_NO DESC";
		
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> viewBoardList(int BoardNo){
		String sql ="SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A.USER_ID = B.USER_ID"
				+ " WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(BoardNo);
		
		return jdbc.selectOne(sql, param);
	}
	
	public  int UpdateBoard(String title, String content, int boardNo, Map<String, Object> loginUser){
		String sql = "update tb_jdbc_board "
				+ " set title =? , content = ? "
				+ " where board_no = ? "
				+ " and user_id =?";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		param.add(loginUser.get("USER_ID"));
		
		return jdbc.update(sql, param);
	}
	
	public int DeleteBoard(int BoardNo, Map<String, Object> loginUser){
		String sql = "delete tb_jdbc_board "
				+ " where board_no = ? "
				+ " and user_id =?";
		
		List<Object> param = new ArrayList<>();
		param.add(BoardNo);
		param.add(loginUser.get("USER_ID"));
		return jdbc.update(sql, param);
	}
	
	public int InsertBoard(String title, String content, Map<String, Object> loginUser){
		String sql = "insert into tb_jdbc_board "
				+ "values((SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD), ?, ?, ?, sysdate)";
		
		List<Object> param = new ArrayList<>();
		
		param.add(title);
		param.add(content);
		param.add(loginUser.get("USER_NAME"));
		
		return jdbc.update(sql, param);
	}
	
	
}//
