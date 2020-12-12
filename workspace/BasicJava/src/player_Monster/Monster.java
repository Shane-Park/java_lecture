package player_Monster;

public class Monster{
	int lv;
	int hp_max;
	int hp;
	String name;
	int atk;
	int def;
	int exp;
	int money;
	int monstercode;

	AllText text = null;
	Monster(int monstercode,int lv, int hp, int attack, int def, int exp, int money){
		switch(GameMain.language){
		case 1:
			text = new AllText_ENG();
			break;
		case 2:
			text = new AllText_KOR();
			break;
		}
		
		this.lv = lv;
		this.hp = hp;
		this.hp_max = hp;
		this.name = text.getMonsterName(monstercode);
		this.atk = attack;
		this.def = def;
		this.exp = exp;
		this.money = money;
		this.monstercode = monstercode;
	}
	
	void attack(Player p){
		int damage = atk - p.def;
		damage = damage <= 0 ? 1: damage;
		p.hp = p.hp < damage ? p.hp - p.hp : p.hp - damage;
		text.monsterAttack(this,p,damage);
	}


}