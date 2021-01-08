package sms_;

public class Monster {
	
	String name;
	int hp;
	int maxHp;
	int att;
	int def;
	int level;
	int exp;
	
	Monster(String name, int hp, int att, int def, int level, int exp){
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.att = att;
		this.def = def;
		this.level = level;
		this.exp = exp;
	}
		
	void attack(Character c){
		int damage = att - c.def;
		damage = damage <= 0? 1: damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(damage + "만큼의 데미지를 입었습니다.");
		System.out.println(c.name + "의 남은 hp : " + c.hp);
	}
	
	
	
	
}
