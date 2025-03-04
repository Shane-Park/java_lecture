package e_oop;
import java.util.Scanner;
/*
 * 어떤 대상을 잡아 클래스를 만들어주세요.
 * 메서드의 내용은 구체적이지 않아도 괜찮습니다.
 * 파라미터와 리턴 타입 위주로 만들어주세요.
 * 클래스에 메서드를 만들어보면서 파라미터와 리턴 타입을 생각해보는 것이 중요합니다.
 * 만들어진 클래스를 main 매서드에서 사용해주세요.
 */
public class Homework_Class {

	String homeworks = "";
	int homeworkCount = 0;
	Scanner sc = new Scanner(System.in);

	void addHomework(String str){
		homeworks += " "+str;
		homeworkCount ++;
		System.out.println(str+"가 숙제에 등록되었습니다.");
	}

	void doHomework(String str){
		homeworks = homeworks.substring(0,homeworks.indexOf(str)-1) + homeworks.substring(homeworks.indexOf(str)+str.length());
		homeworkCount--;
		System.out.println(str+"를 완료하고 숙제 목록에서 제거했습니다.");
	}

	int checkHomework(){
		return homeworkCount;
	}

	void printHomework(){
		System.out.println("남은숙제는 ["+homeworks+" ]입니다. 총 "+checkHomework()+"개의 숙제가 남았습니다.");
	}

	void menu(String input){
		String str="";
		switch(input){
		case "1" :
			System.out.print("추가할 숙제를 입력해주세요: ");
			str = sc.nextLine();
			addHomework(str);
			break;
		case "2" :
			System.out.print("완료한 숙제를 입력해주세요: ");
			str = sc.nextLine();
			if(homeworks.contains(str))
				doHomework(str);
			else System.out.println("해당 숙제는 숙제 목록에 없습니다. 다시 한번 확인해주세요");
			break;
		case "3" :
			printHomework();
			break;
		case "0" : 
			System.out.println("프로그램을 종료합니다.");
			break;
		case "clear" :
			System.out.println("숨겨진 기능을 발동했습니다. 모든 숙제가 삭제됩니다.");
			homeworks = "";
			homeworkCount = 0;
			break;
		default : 
			System.out.println("올바르지 않은 명령입니다. (1, 2, 3, 0) 중 하나를 다시 입력해주세요.");
			break;
		}
	}
}

