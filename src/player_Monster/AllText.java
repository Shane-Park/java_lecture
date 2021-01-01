package player_Monster;

public abstract class AllText{

	void printEnter(){
		System.out.println();}
	void printBar(){
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");}
	
	void mainScreen(){
		System.out.print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
		System.out.print("■     ■■■   ■■■   ■  ■■■     ■■■   ■■■■   ■■■     ■\n");
		System.out.print("■     ■  ■  ■  ■  ■   ■      ■  ■  ■  ■  ■        ■\n");
		System.out.print("■     ■  ■  ■  ■  ■   ■      ■■■   ■■    ■  ■■    ■\n");
		System.out.print("■     ■■■   ■■■   ■   ■      ■  ■  ■      ■■ ■    ■\n");
		System.out.print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");}

	void fightScreen(Player player, Monster monster){
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
	
	abstract void welcome();
	abstract void bye(String name);
	abstract void wrong();
	abstract void status(Player player);
	abstract void welcomePlayer(Player player);
	abstract void loadingComplete();
	abstract void alreadyFull();
	abstract void recover(int price);
	abstract void fieldlist();
	abstract void levelup(int level);
	abstract void menu();
	abstract void pressAny();
	abstract void playerAttack(Player player, Monster monster,int damage);
	abstract void monsterAttack(Monster monster,Player player,int damage);
	abstract void fightStart(Player player,Monster monster);
	abstract void killed(String str);
	abstract void getGold(int gold,int playerGold);
	abstract void expGet(int exp,int expMax,int playerExp);
	abstract void PlayerDie(String player,int gold, int hp, int hpMax,int goldRemain);
	abstract void notEnoughMoney(int price,int gold);
	abstract void noBonusStats();
	abstract void bonusText(Player player);
	abstract void hpUp(Player player);
	abstract void atkUp(Player player);
	abstract void defUp(Player player);
	abstract void shopMenu();
	abstract void buyItem();
	abstract void buySuccess(int price);
	abstract void inventoryFull();
	abstract void itemList(Player player);
	abstract void chooseEquip();
	abstract void equips(int equipcode,Item item);
	abstract void selectEquip();
	abstract void showEquiplist(int equipSelect, Item[] list, Player player);
	abstract void getItem(Item item);
	abstract void dumpItem(Item item);
	abstract String getMonsterName(int number);
	abstract String getItemName(int number);
	abstract int getItemLevel(int number);
	
	
	
	
	
	
	
	
	
}
