package homeworksPackage;
import java.util.Scanner;

public class A_Scanner {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String id, name, bar = "========";
		int password, age;
		double height;
		
		System.out.print(bar+" 회원 가입 "+bar+"\n아이디 >");
		id = sc.nextLine();

		System.out.print("비밀번호(4자리 숫자) >");
		password = Integer.parseInt(sc.nextLine());
		
		System.out.print("이름 >");
		name = sc.nextLine();
		
		System.out.print("나이 >");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.print("키 >");
		height = Double.parseDouble(sc.nextLine());
		
		System.out.println(bar+bar+bar+
				"\n아이디 : "+id+
				"\n비밀번호 : "+password+
				"\n이름 : "+name+
				"\n나이 : "+age+"세"+
				"\n키    : "+height+"cm"+
				"\n"+bar+bar+bar);
	}
}

