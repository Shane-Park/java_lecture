package player_Monster;


public class BattleField {				//Monster(name lv    hp    att   amr   exp  money)
	Monster m0 = new Monster(AllText.monsterNames[0],   1,   40,     5,    2,   5,   1);
	Monster m1 = new Monster(AllText.monsterNames[1],   2,   100,   10,    3,   8,   2);
	Monster m2 = new Monster(AllText.monsterNames[2],   3,   250,   20,   10,   20,  5);
	Monster monster;
	void field1(Player player){	
		monster = m0;
		battle(player,monster);
	}
	void field2(Player player){	
		monster = (int)(Math.random()*2)==1? m0 : m1;
		battle(player,monster);
	}
	void field3(Player player){	
		monster = (int)(Math.random()*2+1)==2? m1 : m2;
		battle(player,monster);
	}
	
	void battle(Player player,Monster m0){
		final int fight_delay = 1000;
		battle : while(true){
			player.attack(m0);
			wait(fight_delay);
			if(m0.hp <= 0){
				AllText.killed(m0.name);
				m0.hp=m0.hp_max;
				player.getGold(m0.money);
				player.getExp(m0.exp);
				AllText.pressAny();
				break battle;
			}
			m0.attack(player);
			wait(fight_delay);
			if(player.hp <=0){
				player.die();
				break;
			}
		}
	}
	
	void wait(int i){
		long end = System.currentTimeMillis();
		long start = System.currentTimeMillis();
		while((end-start)<i)
			end=System.currentTimeMillis();
	}

}
