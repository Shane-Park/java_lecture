package player_Monster;

public class Player{
	int lv;
	int exp_max;
	int exp;
	int hp_max;
	int hp;
	int gold;
	int attack;
	int armor;
	String name;
	int[] exp_table = {0, 10, 30, 80, 220, 300, 500, 800, 2500};

	Player(){
		this(1,80,0);
		AllText.welcome();
		this.name = GameSystem.nextLine();
	}
	Player(int lv, int hp, int gold){
		this.lv = lv;
		this.exp = 0;
		this.exp_max = exp_table[lv];
		this.hp_max = hp;
		this.hp = hp;
		this.gold = gold;
		this.attack = 30;
		this.armor = 1;
	}

	void getExp(int exp){
		this.exp += exp;
		AllText.expGet(exp,this.exp_max,this.exp);
		while( exp_max <= this.exp){
			this.exp -= exp_max;
			lvup();
		}
	}

	void lvup(){
		lv++;
		exp_max = exp_table[lv];
		hp_max += 10;
		attack += 3;
		armor += 1;
		hp = hp_max;
		AllText.levelup(lv);
	}

	void getGold(int gold){
		this.gold+=gold;
		AllText.getGold(gold,this.gold);
	}
	void recover(){
		int recoverPrice = 1;
		if(this.hp == this.hp_max){
			AllText.alreadyFull();
		}else if(gold >= recoverPrice){
			this.gold -= recoverPrice;
			this.hp = this.hp_max;
			AllText.recover(recoverPrice);
		}
		else
			AllText.notEnoughMoney(recoverPrice,gold);
		AllText.pressAny();
	}

	void attack(Monster m){
		int damage = attack - m.armor;
		damage = damage <= 0 ? 1: damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		AllText.playerAttack(this,m,damage);
	}

	void die(){
		int goldMinus = lv;
		if(gold> goldMinus) gold -= goldMinus;
		else gold = 0;
		AllText.PlayerDie(name,goldMinus,hp_max/10,hp_max,gold);
		hp = hp_max/10;
		AllText.pressAny();
	}

}



