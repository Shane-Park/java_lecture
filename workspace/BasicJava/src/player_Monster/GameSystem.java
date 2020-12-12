package player_Monster;
import java.util.Scanner;

public class GameSystem {
	AllText text = null;
	GameSystem(){
		switch(GameMain.language){
		case 1:
			text = new AllText_ENG();
			break;
		case 2:
			text = new AllText_KOR();
			break;
		}
	}
	
	static private Scanner sc = new Scanner(System.in);

	void welcomeMessage(Player player){
		text.welcomePlayer(player);
		for(int i=0; i<51; i++){
			GameSystem.wait(50);
			System.out.print("■");
		}
		text.loadingComplete();
	}
	

	static void wait(int i){
		long end = System.currentTimeMillis();
		long start = System.currentTimeMillis();
		while((end-start)<i)
			end=System.currentTimeMillis();
	}

	void status(Player player){
		status : while(true){
			text.status(player);
			switch(GameSystem.nextLine()){
			case "0" :
				break status;
			case "1" :
				player.equiplist();
				break;
			case "2" :
				player.itemList();
				break;
			case "3" : 
				if(player.bonusStats==0){
					text.wrong();
				}else bonusSystem(player);
				break;
			default : 
				text.wrong();
				break;	
			}
		}
	}
	void bonusSystem(Player player){
		bonus : while(player.bonusStats>0){
			text.bonusText(player);
			switch(GameSystem.nextLine()){
			case "1":
				player.hpUp();
				break;
			case "2": 
				player.atkUp();
				break;
			case "3":
				player.defUp();
				break;
			case "0":
				break bonus;
			default:
				text.wrong();
				break;

			}
		}

	}

	void battle(Player player){
		BattleField field = new BattleField();
		field : while(true){
			fieldlist();
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
			case "0" : 
				break field;
			default : 
				text.wrong();
				break;
			}
		}

	}
	
	void shop(Player player){
		shop: while(true){
			text.shopMenu();
			switch(GameSystem.nextLine()){
			case "1" : player.buyItem(51,1); // item code 1 (potion) / price 1
				break;
			case "2" : player.sellItem();
				break;
			case "3" :
				break;
			case "0" :
				break shop;
			default :
				text.wrong();

			}
		}
	}

	void fieldlist(){
		text.fieldlist();
	}


	public static String nextLine(){
		return sc.nextLine();
	}
	public static int nextInt(){
		return Integer.parseInt(sc.nextLine());
	}
	


}

