package player_Monster;

public class GameMain {
	public static int language;
	
	public static void main(String[] args) {
		System.out.print("(1)ENG (2)한국어 \n>");
		
		AllText text = null;
		switch(GameSystem.nextLine()){
		case "2" :
			text = new AllText_KOR();
			language = 2;
			break;
		case "1" :
		default:
			text = new AllText_ENG();
			language = 1;
			break;
		}
		
		GameSystem game = new GameSystem();
		Player player1 = new Player();
		game.welcomeMessage(player1);
		
		while(true){
			text.menu();
			switch(GameSystem.nextLine()){
			case "1": game.status(player1);	break;
			case "2": game.battle(player1);	break;
			case "3": player1.recover();	break;
			case "4" :game.shop(player1);	break;
			case "5":
				text.bye(player1.name);
				System.exit(0);
			default:
				text.wrong();
				break;
			}
		}

	}


}
