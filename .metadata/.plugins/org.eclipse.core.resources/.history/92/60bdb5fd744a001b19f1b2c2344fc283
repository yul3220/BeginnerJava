package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class QuestionDao {

	private static QuestionDao instance;
	public static int insertQuestion;
	private QuestionDao(){}
	public static QuestionDao getInstance() {
		if(instance == null){
			instance = new QuestionDao();
		}
		return instance;
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static List<Map<String, Object>> selectQnaQuestion() {
		
		String sql = "SELECT A.QA_NO, A.Q_TITLE, A.Q_CONTENT, B.MEM_ID, A.Q_DATE"
				   + " FROM QNA A"
				   + " LEFT OUTER JOIN MEMBER B"
				   + " ON A.MEM_ID = B.MEM_ID"
				   + " ORDER BY A.QA_NO DESC";
		return jdbc.selectList(sql);
	}
	
	public static Map<String, Object> viewQnaQuestionList(int currentQuestionNo) {
		String sql = "SELECT A.QA_NO, A.Q_TITLE, A.Q_CONTENT, B.MEM_ID, A.Q_DATE"
				   + " FROM QNA A"
				   + " LEFT OUTER JOIN MEMBER B"
				   + " ON A.MEMBER_ID = B.MEMBER_ID"
				   + " WHERE A. QA_NO";
		List<Object> param = new ArrayList<>();
		param.add(currentQuestionNo);
		return jdbc.selectOne(sql, param);
	}
	
	public static int insertQuestion(String title, String content,
			Map<String, Object> loginMember) {
		String sql = "INSERT INTO QNA"
				   + " VALUES((SELECT NVL(MAX(QA_NO),0)+1 FROM BBB),?,?,?,sysdate)";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(loginMember.get("MEM_ID"));
		
		return jdbc.update(sql, param);
		
	}
	public static int updateQuestion(String title, String content,
			int qa_no, Map<String, Object> loginMember) {
		String sql = "UPDATE QNA"
				   + " SET TITLE = ?, CONTENT = ?"
				   + " WHERE QA_NO = ?"
				   + " AND MEM_ID = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(qa_no);
		param.add(loginMember.get("MEM_ID"));
		
		return jdbc.update(sql, param);
	}
	public static int deleteQuestion(int qa_no,
			Map<String, Object> loginMember) {
		String sql = "DELETE QNA"
				   + " WHERE QA_NO = ?"
				   + " AND MEM_ID = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(qa_no);
		param.add(loginMember.get("MEM_ID"));
		
		return jdbc.update(sql, param);
	}
	


}

