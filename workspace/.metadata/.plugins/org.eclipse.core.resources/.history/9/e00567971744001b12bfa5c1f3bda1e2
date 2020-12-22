package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴(디자인 패턴 : 클래스를 설계하는 방식)
	private JDBCUtil(){
		
	}
	
	//인스턴스를 보관할 변수
	private static JDBCUtil instance;
	
	//인스턴스를 빌려주는 메서드
	static JDBCUtil getInstance(){
		if(instance == null){
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "YJH01";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * 1. Map<String, Object> selectOne(String sql)
	 * 2. Map<String, Object> selectOne(String sql, List<Object> param)
	 * 3. List<Map<String, Object>> selectList(String sql)
	 * 4. List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * 5. int update(String sql)
	 * 6. int update(String sql, List<Object> param)
	 */
	
	
	
	
	//1번 예시
	Map<String, Object> selectOne(String sql){
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
				
			
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();         
            int columnCount = md.getColumnCount();
            
            while(rs.next()) {            
               for(int i=1; i<columnCount; i++) {
                  String key = md.getColumnName(i);      //key 값
                  Object value = rs.getObject(i);         //value 값
                  map.put(key, value);               //hashMap에 한 줄을 저장
               }
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return map;
		
		
	}
	
	
	//2번 예시
	Map<String, Object> selectOne(String sql, List<Object> param){
		Map<String, Object> map = new HashMap<>();
	      
	      try {
	            con = DriverManager.getConnection(url, user, password);
	            ps = con.prepareStatement(sql);
	            
	            for(int i = 0; i< param.size(); i++) {
	               ps.setObject(i + 1, param.get(i));      //setObject(인덱스값, 실제 값)
	            }
	            
	            rs = ps.executeQuery();
	            
	            ResultSetMetaData md = rs.getMetaData();         
	            int columnCount = md.getColumnCount();
	            
	            while(rs.next()) {            
	               for(int i=1; i<columnCount; i++) {
	                  String key = md.getColumnName(i);      //key 값
	                  Object value = rs.getObject(i);         //value 값
	                  map.put(key, value);               //hashMap에 한 줄을 저장
	               }
	            }
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         } finally {
	            if(rs != null) try { rs.close(); } catch(Exception e) {}
	            if(ps != null) try { ps.close(); } catch(Exception e) {}
	            if(con != null) try { con.close(); } catch(Exception e) {}
	         }      
	         return map;
	}
	
	
	
	
	//3번 예시
	List<Map<String, Object>> selectList(String sql){
		//쿼리를 조회한 결과
        List<Map<String, Object>> list = new ArrayList<>();
        
        try {
           con = DriverManager.getConnection(url, user, password);
           
           ps = con.prepareStatement(sql);         
           rs = ps.executeQuery();
           
           ResultSetMetaData md = rs.getMetaData();         
           int columnCount = md.getColumnCount();
           
           while(rs.next()) {
              Map<String, Object> row = new HashMap<>();   //한 줄을 저장
              for(int i=1; i<columnCount; i++) {
                 String key = md.getColumnName(i);      //key 값
                 Object value = rs.getObject(i);         //value 값
                 row.put(key, value);               //hashMap에 한 줄을 저장 
              }
              list.add(row);               //ArrayList에 저장
           }
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           if(rs != null) try { rs.close(); } catch(Exception e) {}
           if(ps != null) try { ps.close(); } catch(Exception e) {}
           if(con != null) try { con.close(); } catch(Exception e) {}
        }
        
        return list;
		
		
	}
	
	
	
	
	//4번 예시
	List<Map<String, Object>> selectList(String sql, List<Object> param){
		
		//쿼리를 조회한 결과
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i <= param.size(); i++){
				ps.setObject(i +1, param.get(i));				
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
					
			int columnCount = md.getColumnCount();
			
			while(rs.next()){
				Map<String, Object> row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++){
					String key = md.getColumnName(i);
					Object value = rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
	
		}
		
		
		return list;
	}
	
	
	//5번 예시
	int update(String sql){
		 int result = 0;
         try {
            con = DriverManager.getConnection(url, user, password);
            
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
            
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
         
         return result; 
		
	}
	
	//6번 예시
	int update(String sql, List<Object> param){
		 int result = 0;
         try {
            con = DriverManager.getConnection(url, user, password);
            
            ps = con.prepareStatement(sql);
            for(int i = 0; i < param.size(); i++) {
               ps.setObject(i+1, param.get(i));
            }
            
            result = ps.executeUpdate();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

         }
		return result;
		
	}

	
}












