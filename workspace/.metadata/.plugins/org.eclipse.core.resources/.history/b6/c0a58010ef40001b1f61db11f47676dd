package j_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import j_jdbc.JDBCUtil;

public class JDBC {

	public static void main(String[] args) {
		/*JDBCUtil instance = JDBCUtil.getInstance();
		System.out.println(instance);
		JDBCUtil instance2 = JDBCUtil.getInstance();
		System.out.println(instance2);
		JDBCUtil instance3 = JDBCUtil.getInstance();
		System.out.println(instance3);
		//하나의 주소를 사용*/
		
		/*
		 * JDBC(Java DataBase Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성단계
		 * 1. Connection생성
		 * 2. Statement 생성(쿼리)
		 * 3. Query실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기 => 닫아주지않으면 메모리가 계속 남아있음
		 */
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "select * from department_id where department_id = ? ";
		
		List<Object> param = new ArrayList();
		param.add(10);
		
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		System.out.println(list);
		
		//데이터베이스 접속 정보 필요 (총 3개 필요 => 주소, 아이디, 비밀번호)
		/*String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JYR03";
		String password = "java";
		
		Connection con = null; // 커넥션생성
		// finally해서 닫아야하기 때문에 바깥에 변수를 만듬
		PreparedStatement ps = null;
		ResultSet rs = null; //결과를 담을 resultset 생성 후 결과 담기
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//DriverManager 클래스는 JDBC 드라이버를 통하여 Connection을 만드는 역할을 합니다.
			//접속정보로 JDBC연결 커넥션 생성
			
			String sql = "select * from member";//쿼리를 문자열로 작성
			ps = con.prepareStatement(sql);//작성한 쿼리를 파라미터로 넣김
			
			//★★ executeQuery() : select에서 사용
			rs = ps.executeQuery();
			
			
			//★★ executeUpdate() : insert, update, delete에 사용
			//쿼리를 통해 영향받은 행(row)의 수를 리턴
			// int result = ps.executeUpdate();
			
			while(rs.next()){//select인경우만 존재
				//next() : resultset의 다음행이 있는지 없는지에 대한 여부를 알려주는 메소드
				//다음 행이 존재하면 계속진행되고, 없으면 진행이 멈춤
				String memId = rs.getString(1);//인덱스로 값을 가져오기(인덱스는 1부터 시작)
				String memPass = rs.getString("MEM_PASS");//컬럼명으로 값을 가져오기
				System.out.println("MEM_ID : "+memId + " / MEM_PASS : "+memPass );
				//get을 통해 받고 뒤에는 받고자하는 타입을 적어야함
				//getString의 파라미터에 따른 다른점 : int타입은 인덱스로 값을 가져오기/ String은  컬럼명으로 값을 가져오기	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//닫을때는 열었던 순사와 반대로 닫아야함
			if(rs != null)try{rs.close();}catch(Exception e){}
			if(ps != null)try{rs.close();}catch(Exception e){}
			if(con != null)try{rs.close();}catch(Exception e){}
		}*/
		  
		/*try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from departments where department_id = 50";
			ps = con.prepareStatement(sql);
			while(rs.next()){
				String deptid = rs.getString("department_id");
				String deptname = rs.getString("department_name");
				String parentid = rs.getString("parent_id");
				String managerid = rs.getString("manager_id");
				String createdate = rs.getString("create_date");
				String updatedate = rs.getString("update_date");
				
				System.out.println("DEPT_ID : "+ deptid + " / DEPT_NAME : "+deptname + 
						" / PARENT_ID : "+ parentid + " / MANAGER_ID : "+ managerid + 
						" / CREATE_DATE : "+createdate + " / UPDATE_DATE : "+ updatedate);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null)try{rs.close();}catch(Exception e){}
			if(ps != null)try{rs.close();}catch(Exception e){}
			if(con != null)try{rs.close();}catch(Exception e){}
		}*/
		
		
		
		
	}//main
}//
