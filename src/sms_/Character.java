package sms_;

import e_oop.ScanUtil;

public class Character{
	
	MyGame game;
	String name;	
	FoodItem[] fi;
	PlayItem[] pi;
	Monster[] m;
	int money;		
	int hp;			
	int maxHp;		
	int maxExp;
	int exp;		
	int level;		
	int att;		
	int def;
	double time;	
	int date;		
	
	Character(){
		this.money = 3000;
		this.maxHp = 100;
		this.hp = this.maxHp;
		this.maxExp = 100;
		this.exp = 0;
		this.att = 15;
		this.def = 10;
		this.level = 1;
		this.time = 0.0;
		this.date = 1;
	}
	
	void create(){
		System.out.print("캐릭터 이름을 입력하세요(2글자 이상)>");
		this.name = ScanUtil.nextLine();
	}
	
	
	void attack(Monster m){
		int damage = att - m.def;
		damage = damage < 0? 1: damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println(m.name + "에게 " + damage + "만큼의 데미지를 입혔습니다.");
		System.out.println(m.name + "의 남은 hp : " + m.hp);
	}
		
	void getExp(Monster m){
		System.out.println(m.exp + "의 경험치를 획득하였습니다.");
		this.exp += m.exp;
		levelUp();
	}
	
	void levelUp(){
		if(this.exp >= this.maxExp){
			this.level++;
			this.exp = 0;
			this.maxExp += 100;
			this.maxHp += 50;
			this.att += 20;
			this.def += 20;
			this.hp = this.maxHp;
			System.out.println("Level Up!");
		}
	}
	
	void getItem(PlayItem pi){
		int ran = (int)(Math.random() * 101) + 1;
		if(ran <= 80){
			getMoney();
		}
		else{
			pi.qty++;
			System.out.println(pi.name + "를 획득했습니다. 현재 " + pi.name + "의 개수는 " + pi.qty + "개입니다.");
		}
	}
	
	void getMoney(){
		int coin = (int)(Math.random() * 400) + 100;
		this.money += coin;
		System.out.println(coin + "원을 획득했습니다.");
	}
	
	void time(double i){
		this.time += i;
		if(this.time >= 8){
			this.date++;
			this.time = 0;
		}
	}
	
	void die(){
		boolean b1 = (this.hp <= 0) && (this.money < 3000);
		boolean b2 = (0 < this.hp) && (this.hp < 10) && (this.money < 500);
		if(b1 == true || b2 == true){
			System.out.println("GAME OVER!");
			System.exit(0);
		}
	}
	
}












