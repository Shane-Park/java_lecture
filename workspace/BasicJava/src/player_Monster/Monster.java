package player_Monster;

public class Monster{
	int lv;
	int hp_max;
	int hp;
	String name;
	int attack;
	int armor;
	int exp;
	int money;
	Monster(String name, int lv, int hp, int attack, int armor, int exp, int money){
		this.lv = lv;
		this.hp = hp;
		this.hp_max = hp;
		this.name = name;
		this.attack = attack;
		this.armor = armor;
		this.exp = exp;
		this.money = money;
	}
	
	void attack(Player p){
		int damage = attack - p.armor;
		damage = damage <= 0 ? 1: damage;
		p.hp = p.hp < damage ? p.hp - p.hp : p.hp - damage;
		AllText.monsterAttack(this,p,damage);
	}


}