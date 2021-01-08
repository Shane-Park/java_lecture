package sms_;

import e_oop.ScanUtil;

public class MyGame {

		Character c;
		Monster[] m = new Monster[5];
		FoodItem[] fi = new FoodItem[5];
		PlayItem[] pi = new PlayItem[3];
		
		MyGame(){
		c = new Character();
		m[0] = new Monster("빨강 슬라임", 20, 5, 5, 1, 50);
		m[1] = new Monster("주황 슬라임", 35, 10, 10, 2, 75);
		m[2] = new Monster("노랑 슬라임", 50, 15, 15, 3, 100);
		m[3] = new Monster("초록 슬라임", 75, 25, 25, 4, 130);
		m[4] = new Monster("파랑 슬라임", 100, 40, 40, 5, 180);
		
		fi[0] = new FoodItem("라면", 500, 10, 0, 0, 0);
		fi[1] = new FoodItem("쌀밥", 800, 20, 0, 0, 0);
		fi[2] = new FoodItem("보양식", 1500, 40, 0, 0, 0);
		fi[3] = new FoodItem("초콜릿", 1000, 0, 0, 5, 0);	 
		fi[4] = new FoodItem("햄버거", 2000, 10, 0, 10, 0); 
		
		pi[0] = new PlayItem("만화책", 0, 0, 30, 0, 0);
		pi[1] = new PlayItem("게임기", 0, 0, 50, 0, 0);
		pi[2] = new PlayItem("운동기구", 0, 0, 70, 0, 0);
		}

		
		public static void main(String[] args) {
		
			
		new MyGame().start();
		
		}
	
		
	void start(){
		c.create();
		int a = 0;
		while(true){
			System.out.println("===========================================");
			System.out.println("캐릭터 : " + c.name + "   \t\t[" + c.date + "일 째 / " + c.time + "시]"); 
			System.out.println("레벨    : " + c.level + "    \t\t[Exp: " + c.exp + "  / " + c.maxExp +"]");
			System.out.println("돈       : " + c.money + "   \t\t[Hp: " + c.hp + " / " + c.maxHp + "]");
			System.out.println("===========================================");
			System.out.println("0.도움말");
			System.out.println("1.밥 먹기     \t2.탐험가기   \t3.치료하기\n4.놀아주기   \t5.잠자기       \t6.종료" );
			System.out.println("===========================================");
			c.die();
		System.out.print("할 일 선택> ");
		a = ScanUtil.nextInt();
		switch(a){
		case 0: help(); break;
		case 1: eating(); break;
		case 2: explore(); break;
		case 3: recovery(); break;
		case 4: play(); break;
		case 5: sleep(); break;
		case 6: System.out.println("게임을 종료합니다.");
				System.exit(0);
				}
		System.out.println();
		}
	}

	
	void eating(){
		if(c.hp != 0 && c.hp < c.maxHp){
			for(int i = 0; i < fi.length - 1; i++){
				System.out.print(i + 1 + "." + fi[i].name + " / ");
			}
			System.out.println("5." + fi[4].name);
			System.out.print("현재 hp : " + c.hp + " / 음식을 선택해주세요 > ");
			int num = ScanUtil.nextInt();
			
			if(c.money >= fi[num - 1].price){
				fi[num - 1].showInfo();
				System.out.println(fi[num - 1].name + "을 사용하시겠습니까? / 사용 안 할거면 'X(x)'키 입력");
				String ans = ScanUtil.nextLine();
				
				if(!ans.equals("X") && !ans.equals("x")){
					c.hp += fi[num - 1].hp;
					c.att += fi[num - 1].att;
					c.money -= fi[num - 1].price;
					c.time(2);
					}
				if(c.hp > c.maxHp){
					c.hp = c.maxHp;
				}	
			}else{
				System.out.println("돈이 부족하여 먹을 수 없습니다.");
			}
		}else if(c.hp == 0){
			System.out.println("hp가 고갈되어 음식을 먹을 수 없습니다. 치료해주세요.");
		}else{
			System.out.println("이미 hp가 최대치이므로 음식을 먹을 필요가 없습니다.");
		}
	}
	
	
	void explore(){
		if(c.hp >= 10){
		System.out.println("탐험을 시작합니다. 20칸 도착 시, 탐험이 완료됩니다.");
		System.out.println("글자입력 시, 1~6 랜덤한 숫자가 나와 그 수만큼 진행되며 몬스터와 마주칠 수도 있습니다.");
		System.out.println("진행을 위해선 10hp가 필요하며, 중도포기하실 수 있습니다.(중도포기 시 보상 절반만 획득)");
		
		for(int i = 0; i < 20;){
		System.out.println("진행을 위해 아무키나 입력해주세요.(X 또는 x 입력 시 중도 포기)");
		String a = ScanUtil.nextLine();
		if(a.equals("X") || a.equals("x")){
			System.out.println("탐험을 종료합니다.");
			break;
		}else{
		c.hp -= 10;
		c.time(0.5);
		int num = (int)(Math.random() * 6) + 1;
		int ran = (int)(Math.random() * 100) + 1;
		System.out.println(num + "이(가) 나왔습니다." + num + "칸 전진합니다.");
			if(ran <= 50){
				System.out.println("몬스터를 마주쳤습니다.");
				battle();
			}
		i += num;
			if(i < 20){
				System.out.println("탐험 진행도 : " + i + " / 20 \t 남은 hp : " + c.hp + " / " + c.maxHp);
				System.out.println();
				if(c.hp < 10){
					System.out.println("hp가 고갈되어 탐험을 종료합니다.");
					break;
				}
			}else{
				System.out.println("도착!");
				System.out.println("탐험을 종료합니다.");
			}
		}
		}
		}else{
			System.out.println("hp가 부족하여 탐험을 갈 수 없습니다.");
		}
	}
		
		
	void battle(){
		int i = (int)(Math.random() * 5);
		int j = (int)(Math.random() * 3);
		System.out.println(m[i].name + "(" + "Lv." + m[i].level + ")을 만났습니다.");
		int a = 0;
		_battle : while(true){
		System.out.println("사냥하시겠습니까?(1.사냥 / 2.도망) > ");
		a = ScanUtil.nextInt();
		switch(a){
		case 1: c.attack(m[i]);
				System.out.println();
				if(m[i].hp <= 0){
					c.getExp(m[i]);
					c.getItem(pi[j]);
					break _battle;
				}
				if(c.hp <= 0){
					break _battle;
				}
				m[i].attack(c);
				System.out.println();
				break;
		case 2: break _battle;
		}
	}
	}
	
	void recovery(){
		if(c.hp <= 0){
			System.out.println("치료제는 3000원 입니다.(최대 체력의 70%회복)");
			if(c.money >= 3000){
				System.out.println("치료를 위해 아무키나 입력해주세요.");
				String a = ScanUtil.nextLine();
				c.hp = (int)(c.maxHp * 0.7);
				c.money -= 3000;
				c.time(2);
			}else{
				System.out.println("돈이 부족하여 치료할 수 없습니다.");
			}
		}else{
			System.out.println("체력이 너무 많아 치료를 할 수 없습니다.");
		}
	}
		
	void play(){
		System.out.println();
		for(int i = 0; i < pi.length - 1; i++){
		System.out.print(i + 1 + "." + pi[i].name + " / ");
		}
		System.out.println("3." + pi[2].name);
		System.out.print("사용하실 놀이기구를 선택해주세요>");
		int a = ScanUtil.nextInt();
		pi[a - 1].showInfo();
		System.out.println();
		if(pi[a - 1].qty <= 0){
			System.out.println("해당 놀이기구가 없어 사용할 수 없습니다.");
		}else{
			System.out.println(pi[a - 1].name + "은(는) 현재 " + pi[a - 1].qty + "개 있습니다. "
							+ "사용하시겠습니까? / 사용 안 할거면 'X(x)'키 입력");
			String x = ScanUtil.nextLine();
			if(!x.equals("X") && !x.equals("x")){
			pi[a - 1].qty--;
			c.exp += pi[a - 1].exp;
			c.time(1);
			c.levelUp();
			}
			}
	}
	
	void sleep(){
		if(c.time < 5){
			System.out.println("시간이 너무 일러 잠을 잘 수 없습니다.");
		}else{
			c.date++;
			c.time = 0;
			c.hp = c.maxHp;
			System.out.println();
			System.out.println("잠을 잡니다");
			System.out.println("...");
			System.out.println("다음날");
		}
	}
	
	void help(){
		System.out.println();
		System.out.println(c.name + "을(를) 키우는 게임입니다.");
		System.out.println(c.name + "은(는) 다양한 활동을 통해 레벨을 올릴 수 있습니다.");
		System.out.println("다양한 활동을 위해서는 hp가 필요합니다.");
		System.out.println("hp는 밥 먹기, 잠자기, 치료하기, 레벨업을 통해 충전할 수 있습니다.");
		int a = 0;
		while(a < 6){
		System.out.println("===========================================");
		System.out.println("그 외 도움말 \n1.밥 먹기 \n2.탐험가기 \n3.치료하기 \n4.놀아주기 \n5.잠자기\n6.나가기");
		System.out.println("===========================================");
		System.out.print("도움말 번호 선택> ");
		a = ScanUtil.nextInt();
		System.out.println();
		switch(a){
		case 1: System.out.println("1.밥 먹기");
				System.out.println("라면 / 쌀밥 / 보양식을 먹으면 각각 음식에 따라 hp를 충전할 수 있습니다.");
				System.out.println("밥을 먹기위해선 돈이 필요합니다. 돈이 부족할 경우 밥을 먹을 수 없습니다.");
				System.out.println("hp가 0이 되면 치료가 필요하며, 밥을 먹을 수 없습니다.");
				System.out.println("hp가 가득차면 밥을 먹을 수 없습니다.");
				System.out.println("밥을 먹으면 2시간이 흘러갑니다.");
				break;
		case 2: System.out.println("X(x)를 제외한 키를 누르면 탐험을 시작합니다.");
				System.out.println("탐험을 하기 위해서는 각 움직임마다 10hp가 필요하며 0.5시간이 흘러갑니다.");
				System.out.println("한 번에 1칸에서 6칸까지 이동할 수 있으며, 20칸을 이동하면 탐험이 종료됩니다.");
				System.out.println("hp가 0이 되면 탐험이 종료됩니다. X(x) 키를 눌러 탐험을 중도포기할 수 있습니다.");
				System.out.println("탐험을 하다보면 몬스터를 마주칠 수 있으며 몬스터를 처치하면 경험치를 얻을 수 있습니다.");
				System.out.println("몬스터를 처치하면 일정량의 돈 또는 \'4번 놀아주기\'를 위한 아이템을 얻을 수 있습니다.");
				break;
		case 3: System.out.println("hp가 0이 되면 치료가 필요합니다. hp가 0이 아니면 치료할 수 없습니다.");
				System.out.println("치료를 위해선 3000원의 돈이 필요하며 돈이 부족하면 치료할 수 없습니다.");
				System.out.println("치료를 하면 최대 체력의 70%가 회복됩니다.");
				System.out.println("치료를 하면 2시간이 흘러갑니다.");
				break;
		case 4: System.out.println("탐험을 통해 얻은 아이템으로 놀아주기를 할 수 있습니다.");
				System.out.println("놀아주기를 하면 각 아이템에 따른 경험치를 획득할 수 있습니다.");
				System.out.println("놀아주기를 하면 1시간이 흘러갑니다.");
				break;
		case 5:	System.out.println("시간이 5시 이후가 되면 잠을 잘 수 있습니다.");
				System.out.println("잠을 자면 hp가 최대치로 충전됩니다.");
				System.out.println("잠을 자면 다음날 0시로 넘어갑니다.");
				break;
		case 6: break;
		}
		}
	}
	
}










