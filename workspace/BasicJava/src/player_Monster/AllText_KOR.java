package player_Monster;

import java.util.Scanner;

public class AllText_KOR {
	static Scanner sc = new Scanner(System.in);

	static void welcome(){
		System.out.print("이름을 입력하세요 > ");
	}
	static void bye(String name){
		System.out.printf("[%s] 님 이용해 주셔서 감사합니다. 아직 세이브 기능은 제공하지 않습니다.",name);
	}
	static void wrong(){
		System.out.println("잘못된 명령어입니다. 다시 입력해주세요");
	}
	static void status(Player player){
		int expPercent = (int)((float)player.exp/player.exp_max*10);
		int hpPercent = (int)((float)player.hp/player.hp_max*10);
		System.out.print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
		System.out.print("■ʕʘ̅͜ʘ̅ʔ▬▬ι═══════ﺤ   ■ EXP ");System.out.printf("%3d/%3d ",player.exp,player.exp_max);
		for(int i=0; i<10; i++){
			if(expPercent>i) System.out.print("●");
			else System.out.print("○");
		}
		System.out.print(" ■\n■   -═══════ι▬▬ʕʘ̅͜ʘ̅ʔ■  HP ");System.out.printf("%3d/%3d ",player.hp,player.hp_max);
		for(int i=0; i<10; i++){
			if(hpPercent>i) System.out.print("●");
			else System.out.print("○");
		}
		
		System.out.printf(" ■\n■■■■■■■■■■■■■■■■■■■■ attack %3d\tarmor%3d    ■\n■  ",player.attack,player.armor);
		System.out.printf("[Lv %2d %-10s] %4d gold\n",player.lv,player.name,player.gold);
		System.out.print(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
	}


	static void welcomePlayer(Player player){
		System.out.println("게임월드에 오신것을 환영합니다 ["+player.name+"] 님. 잠시만 기다려주세요 ");
	}
	static void loadingComplete(){
		System.out.println("\n■■■■■■■■■■■■■  로딩이 완료되었습니다     ■■■■■■■■■■■■■■");
	}
	static void alreadyFull(){
		System.out.println("[무료] 당신의 체력은 이미 가득 찼습니다.");
	}
	static void recover(int price){
		System.out.printf("[-%d gold] 체력을 회복중입니다...",price);
		System.out.println("체력이 가득 찼습니다!");
	}
	static void fieldlist(){
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■■■ 참여하고자 하는 사냥터를 고르세요 . 숫자를 입력해주세요 ■■■■");
		System.out.println(  "■■■1.초급자 1 [ 레벨 1 몬스터만 출몰합니다.] ");
		System.out.println(  "■■■2.초급자 2 [ 레벨 1 ~ 2 몬스터가 출몰합니다.]");
		System.out.println(  "■■■3.초급자 3 [ 레벨 2 ~ 3 몬스터가 출몰합니다.]");
		System.out.println(  "■■■4.메뉴로 돌아가기  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	static void levelup(int level){
		System.out.printf(" 레벨업!! 축하합니다 레벨 [%d] 이(가) 되었습니다.\n",level);
	}
	
	static void expGet(int exp,int expMax,int playerExp){
		System.out.printf("[%d] 의 경험치를 획득하였습니다.(%3d/%3d)\n",exp,playerExp,expMax);
	}
	
	static String[] monsterNames = {"토끼","늑대","고블린"};
	
	static void killed(String str){
		System.out.println(str + "을 처치하였습니다.");
	}
	
	static void menu(){
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■■ 1.캐릭터   | 2.사냥터   |  3.회복     | 4.게임      ■■■■■■");
		System.out.println(  "■■    정보    |    이동   |         |   종료      ■■■■■■");
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.print(  "> ");
	}
	
	static void getGold(int gold,int playerGold){
		System.out.printf("[%d] 의 골드를 획득하였습니다. (%d gold 소지중)\n",gold,playerGold);
	}
	
	static void pressAny(){
		System.out.print("계속 하려면 엔터키를 눌러주세요 ..");
		sc.nextLine();
	}
	static void damage(String attaker,String enemy,int damage,int enemyHp){
		System.out.printf("[%s]이(가) 공격으로 [%s]에게 %d 만큼 데미지를 주어었습니다.\n",attaker,enemy,damage);
		System.out.printf("%s의 남은 HP : %d\n",enemy,enemyHp);
	}
	
	static void PlayerDie(String player,int gold, int hp, int hpMax,int goldRemain){
		System.out.printf("[%s]이(가) 사망했습니다.\n",player);
		System.out.printf("%d 의 골드를 잃고 부활했습니다. 현재체력 %d/%d 잔여골드 %d.\n",gold,hp,hpMax,goldRemain);
	};

}
