package homeworksPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class I_Board {
	/*
	 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
	 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
	 * 
	 * 번호(PK), 제목, 내용, 작성자, 작성일
	 * 
	 * ----------------------------
	 * 번호	제목		작성자	작성일
	 * ----------------------------
	 * 4	안녕하세요	홍길동	12/15
	 * 3	안녕하세요	홍길동	12/15
	 * 2	안녕하세요	홍길동	12/15
	 * 1	안녕하세요	홍길동	12/15
	 * ----------------------------
	 * 1.조회 2.등록 3.종료
	 */

	static int PER_PAGE = 4;	// numbers of contents on a page
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Methods methods = new Methods();
		ArrayList<HashMap<String,String>> list = new ArrayList<>();
		methods.basicAdd(list);
		
		int page=1;
		while(true){
			int totalPage = (list.size()-1)/I_Board.PER_PAGE+1;
			
			methods.printBoard(list,page);
			methods.mainMenu(page,list);
			
			switch(I_Board.sc.nextLine()){
			case "1":
				int temp = totalPage;
				methods.contents(list);	
				if( temp !=(list.size()-1)/I_Board.PER_PAGE+1 )	// if total page changed, page--
					page--;
				break;
			case "2":
				methods.register(list);
				break;
			case "3":
				if(page != 1)
					page--;
				break;
			case "4":
				if(page!= totalPage)
					page++;
				break;
			case "0":
				System.out.println("[프로그램 종료 완료]");
				System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n>");
				break;
			}
			
		}
	}
}



class Methods{
	public void printBoard(ArrayList<HashMap<String,String>> list, int page){
		this.printBar();
		System.out.println(" 번호	제목		작성자	작성일");
		this.printBar();
		int number =list.size();
		int lists=0;	// variable to count the number of contents on the page
		for(int i=list.size()-1-(page-1)*I_Board.PER_PAGE; (i>=0 && i>list.size()-1-(page-1)*I_Board.PER_PAGE-I_Board.PER_PAGE); i--){
			HashMap<String,String> table = list.get(i);
			System.out.printf("%2d\t",(number--)-I_Board.PER_PAGE*(page-1));
			System.out.printf("%-14s\t",table.get("title"));
			System.out.print(table.get("writer")+"\t");
			System.out.print(table.get("date")+"\t\n");
			lists++;
		}
		for(int i=lists;i<I_Board.PER_PAGE;i++)	 	// line up
			System.out.println();					// 
		System.out.printf("===================================[%d 페이지]==\n",page);
	}
	
	public void register(ArrayList<HashMap<String,String>> list){
		HashMap<String,String> post = new HashMap<>();
		System.out.print("작성할 글 제목을 써주세요 : ");			post.put("title",I_Board.sc.nextLine());
		System.out.print("작성할 글 내용을 써주세요 : ");			post.put("contents",I_Board.sc.nextLine());
		System.out.print("작성자 이름을 써주세요 : ");			post.put("writer",I_Board.sc.nextLine());
		System.out.print("작성 일자를 써주세요(MM/DD) : ");		post.put("date",I_Board.sc.nextLine());
		list.add(post);
		System.out.printf("[%s]을(를) 성공적으로 등록했습니다. 계속 하려면 [Enter]키를 눌러주세요..",post.get("title"));	I_Board.sc.nextLine();
	}

	public void read(int n,ArrayList<HashMap<String,String>> list){
		HashMap<String,String> table = list.get(n-1);
		this.printBar();
		System.out.printf("[작성자] %s\t[작성일] %s\n",table.get("writer"),table.get("date"));
		System.out.printf("[제목] %s\n\n",table.get("title"));
		System.out.printf("[내용] %s\n",table.get("contents"));
		this.printBar();
	}

	public void edit(int n,ArrayList<HashMap<String,String>> list){
		HashMap<String,String> table = list.get(n-1);
		System.out.print("수정할 제목을 입력해주세요.\n>");		table.put("title",I_Board.sc.nextLine());
		System.out.print("수정할 내용을 입력해주세요.\n>");		table.put("contents",I_Board.sc.nextLine());
	}

	public void mainMenu(int page,ArrayList<HashMap<String,String>> list){
		int totalPage=1;
		if(list.size() != 0)
			totalPage=(list.size()-1)/I_Board.PER_PAGE+1;
		System.out.print("(1)조회 (2)등록 ");
		if(page != 1)				System.out.print("(3)이전페이지 ");
		if(page != totalPage)		System.out.print("(4)다음페이지 ");
		System.out.print("(0)종료\n>");
	}

	public void basicAdd(ArrayList<HashMap<String,String>> list){
		HashMap<String,String> post = new HashMap<>();
		post.put("title","안녕하세요");
		post.put("contents","기본 글입니다\n휴지는 휴지통에\n인터넷 개통을 축하합니다.");
		post.put("writer","김씨");
		post.put("date","12/14");
		list.add(post);

		HashMap<String,String> post2 = new HashMap<>();
		post2.put("title","진짜 되나?");
		post2.put("contents","이거 되는건가?\n테스트1234\nㅁㄴㅇㄻㄴㅇㅎ");
		post2.put("writer","ㅇㅇ");
		post2.put("date","12/14");
		list.add(post2);

		HashMap<String,String> post3 = new HashMap<>();
		post3.put("title","잘보고가요~~");
		post3.put("contents","제 블로그도 와주세요.\n따봉 구독 좋아요 부탁해요\nㅂㅂ.");
		post3.put("writer","블로거");
		post3.put("date","12/15");
		list.add(post3);

		HashMap<String,String> post4 = new HashMap<>();
		post4.put("title","이거 실화냐?");
		post4.put("contents","미안하다 이거 보여 주려고 어그로 끌었다.\n그 찐다같던 이클립스가 게시판이라니 ㄹㅇ실화냐?\n가슴이 웅장해진다.");
		post4.put("writer","웅장해진다");
		post4.put("date","12/15");
		list.add(post4);

		HashMap<String,String> post5 = new HashMap<>();
		post5.put("title","최근글은 내꺼");
		post5.put("contents","ㅎㅇ.\n내가 젤 최신글\nㅅㄱㅇ.");
		post5.put("writer","최근빌런");
		post5.put("date","12/15");
		list.add(post5);

	}

	public void contents(ArrayList<HashMap<String,String>> list){
		System.out.print("조회할 글 번호 입력 > ");
		try{
			int select = Integer.parseInt(I_Board.sc.nextLine());
			if(select<=list.size() && select!=0)
				this.read(select, list);
			else{
				System.out.print("해당하는 글 번호가 없습니다.\n");
				return;
			}
			System.out.print("(1)뒤로가기 (2)편집 (3) 글 삭제\n>");
			switch(I_Board.sc.nextLine()){
			case "1":												break;
			case "2":	this.edit(select,list);						break;
			case "3":	list.remove(select-1);						break;
			default:	System.out.println("올바르지 않은 입력입니다.");		break;
			}
		}catch(NumberFormatException e){
		}

	}
	void printBar(){
		System.out.println("=============================================");
	}


}
