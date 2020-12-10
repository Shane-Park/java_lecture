package player_Monster;

public class AllText extends AllText_KOR{
	// Language setting : modify     ↑↑↑ to ENG or KOR 
	
	public AllText(){}

	static void printEnter(){
		System.out.println();}
	static void printBar(){
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");}
	
	static void mainScreen(){
		System.out.print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
		System.out.print("■     ■■■   ■■■   ■  ■■■     ■■■   ■■■■   ■■■     ■\n");
		System.out.print("■     ■  ■  ■  ■  ■   ■      ■  ■  ■  ■  ■        ■\n");
		System.out.print("■     ■  ■  ■  ■  ■   ■      ■■■   ■■    ■  ■■    ■\n");
		System.out.print("■     ■■■   ■■■   ■   ■      ■  ■  ■      ■■ ■    ■\n");
		System.out.print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");}

	static void fightScreen(Player player, Monster monster){
		int hpPercent = (int)((float)player.hp/player.hp_max*10);
		int monsterHpPercent = (int)((float)monster.hp/monster.hp_max*10);
		printEnter();
		printBar();		  
		System.out.print(  "■    ■■     ■■           ■         ■■■   ■■■       \n");
		System.out.print(  "■   ■  ■   ■  ■          ■            ■ ■          \n");
		System.out.print(  "■        ■               ■          □□■□■□□        \n");
		System.out.print(  "■       ■■■■    (👦)     ■          □□■□□■□  (💀)  \n");
		printBar();
		System.out.printf("[ %s ] HP%3d",player.name,player.hp);
		for(int i=0; i<10; i++){
			if(hpPercent>i) System.out.print("●");
			else System.out.print("○");
		}
		System.out.printf(" [LV%d %s] HP%3d",monster.lv,monster.name,monster.hp);
		for(int i=0; i<10; i++){
			if(monsterHpPercent>i) System.out.print("●");
			else System.out.print("○");
		}
		printEnter();
	}
}
