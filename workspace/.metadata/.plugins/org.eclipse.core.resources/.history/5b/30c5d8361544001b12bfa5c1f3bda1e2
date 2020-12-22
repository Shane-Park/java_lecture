package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBC {

	public static void main(String[] args) {
		
		
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성단계
		 * 1. Connection 생성
		 * 2. Statement 생성(쿼리)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		
//		JDBCUtil jdbc = JDBCUtil.getInstance();
//		
//		String sql = "select * from member where mem_id = ?";
//		
//		List<Object> param = new ArrayList<>();
//		param.add("a001");
//		
//		List<Map<String, Object>> list = jdbc.selectList(sql, param);
//		
//		System.out.println(list);
//		
		
		
		
		//데이터베이스 접속 정보
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "YJH01";
		String password = "java";
		
		//Connection 생성
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(ur1, user, password);
			
			String sql = "select * from member";     //쿼리작성
			ps = con.prepareStatement(sql);
			
			//★   select에서 사용
			rs = ps.executeQuery();
			
			//★  insert, update, delete에서 사용
//			int result = ps.executeUpdate();         //영향받은 행(row)의 수를 리턴
			
			
			while(rs.next()){
				String memId = rs.getString(1);      //인덱스로 값을 가져오기 (인덱스를 1부터 시작)
				String memPass = rs.getString("MEM_PASS");       //컬럼명으로 값을 가져오기
				System.out.println("MEM_ID : " + memId + " / MEM_PASS : " + memPass);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		
		
		
	

	}

}
