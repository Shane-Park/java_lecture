package e_oop;

import java.util.Scanner;

public class Homework_Class_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Homework_Class mine = new Homework_Class();
		String input;
		do{
			System.out.print("기능을 선택해주세요 : (1:숙제추가, 2:숙제완료, 3:남은숙제 확인, 0:프로그램 종료) : ");
			input = sc.nextLine();
			mine.menu(input);
		}while(!input.equals("0"));

	}
}