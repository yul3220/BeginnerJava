package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JYR03";
		String password = "java";
		
		Connection con = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		/*try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from member where mem_id = ? ";
			//물음표를 사용해서 들어갈 값을 대체함
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001");//?에 값을 넣는 메소드
			//parameterIndex는 ?의 인덱스, x는 넣고 싶은 값
			//다른 타입의 값을 넣고 싶으면 setInt, setObject를 통해 넣으면 됨
			
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();// 메타데이터 : 데이터에 대한 데이터
			//행이 몇개인지, 컬럼이 몇개인지같은 데이터를 얻음
			//컬럼명이 많을 때 한꺼번에 받는 방법
			
			int columnCount = md.getColumnCount();//컬럼수
			
			while(rs.next()){
				//while문의 행의 개수를 알아서 처리
				for(int i = 1; i <= columnCount;i++){//i라는 변수를 인덱스로 사용
					System.out.print(rs.getObject(i)+"\t");
					//모든컬럼의 데이터가 다른경우 Object를 통해서 한꺼번에 받음
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null)try{rs.close();}catch(Exception e){}
			if(ps != null)try{rs.close();}catch(Exception e){}
			if(con != null)try{rs.close();}catch(Exception e){}
		}*/
		
		/*try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into lprod values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 11);
			ps.setString(2, "P601");
			ps.setString(3, "식품");
			
			int result = ps.executeUpdate();
			System.out.println("영향받은 행의 수 : "+result);
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null)try{rs.close();}catch(Exception e){}
			if(ps != null)try{rs.close();}catch(Exception e){}
			if(con != null)try{rs.close();}catch(Exception e){}
		}*/

	}//main
}//
