package h_exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Finally {

	public static void main(String[] args) {
		/*
		 * finally
		 * - 필요에 따라 try-catch 뒤에 finally 를 추가할 수 있다.
		 * - finally는 예외의 발생 여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수선언;변수선언) {} catch(Exception e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 * 
		 */
		
		FileInputStream fis = null; // 파일 읽기
		
		try{
			fis = new FileInputStream("d://file.txt");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 예외 발생    : try -> catch -> finally
		// 예외 미발생 : try -> finally 
		
		// 자동 자원 반환 ( JDK 1.7)
		try(FileOutputStream fos = new FileOutputStream("d://file.txt")){
			String str = "아무 내용이나 써보자...";
			
			byte[] bytes = str.getBytes();
			
			for(int i=0; i<bytes.length; i++){
				fos.write(bytes[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
