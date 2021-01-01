package j_jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


public class Jeje14 {

	public static void main(String[] args) {
		
		
		new Jeje13().start();
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "PSH";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");

}
































