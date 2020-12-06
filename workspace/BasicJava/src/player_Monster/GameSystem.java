package player_Monster;
import java.util.Scanner;

public class GameSystem {
	static private Scanner sc = new Scanner(System.in);

	static void menu(){
		AllText.menu();
	}

	void wait(int i){
		long end = System.currentTimeMillis();
		long start = System.currentTimeMillis();
		while((end-start)<i)
			end=System.currentTimeMillis();
	}

	void status(Player player){
		AllText.status(player);
		AllText.pressAny();
	}

	void welcomeMessage(Player player){
		AllText.welcomePlayer(player);
		for(int i=0; i<45; i++){
			this.wait(20);
			System.out.print("■");
		}
		AllText.loadingComplete();
	}

	void battle(Player player){
		BattleField field = new BattleField();
		field : while(true){
			fieldlist();
			System.out.print(">");
			switch(GameSystem.nextLine()){
			case "1" : 
				field.field1(player);
				break;
			case "2" : 
				field.field2(player);
				break;
			case "3" : 
				field.field3(player); 
				break;
			case "4" : 
				break field;
			default : 
				AllText.wrong();
				break;
			}
		}

	}

	void fieldlist(){
		AllText.fieldlist();
	}


	public static String nextLine(){
		return sc.nextLine();
	}
	public static int nextInt(){
		return Integer.parseInt(sc.nextLine());
	}


}

