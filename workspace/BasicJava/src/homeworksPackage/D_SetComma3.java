package homeworksPackage;

import java.util.Scanner;

public class D_SetComma3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력 해 주세요 : ");
		String str =  sc.nextLine();
		
		for(int i=0; i<str.length(); i++){
			if(i!=0 && (str.length()-i)%3==0)
				System.out.print(",");
			System.out.print(str.charAt(i));
		}

	}

}
