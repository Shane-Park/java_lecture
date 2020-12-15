package homeworksPackage;

import java.util.Scanner;

public class D_SetComma1 {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력 받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		// 10000000 -> 10,000,000 
		// 숫자를 입력 받을때는 string type 으로 입력받으세요 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력 해 주세요 : ");
		String str = sc.nextLine();
		String str2 = "";
		for ( int i=str.length()-1, j=1; i>=0; i--,j++){
			str2 += str.charAt(i);
			if(j!=str2.length()-1 && j%3==0){
				str2+= ",";
			}
		}

		for(int i=str2.length()-1; i>=0; i--)
			System.out.print(str2.charAt(i));
	}

}
