package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
				
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
					
					String sql = "select * from member where mem_id = ?";     
					ps = con.prepareStatement(sql);
					ps.setString(1, "a001");               //물음표에 값을 넣는 메서드
//					ps.setInt(parameterIndex, x);
//					ps.setObject(parameterIndex, x);
					
					
					//★   select
					rs = ps.executeQuery();
					
					ResultSetMetaData md = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터
					
					int columnCount = md.getColumnCount(); // 컬럼 수 리턴
					
					while(rs.next()){
						for(int i = 1; 1 < columnCount; i++){
							System.out.print(rs.getObject(i) + "\t");
						}
						System.out.println();
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


























