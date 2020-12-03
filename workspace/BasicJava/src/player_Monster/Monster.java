package player_Monster;

public class Monster{
	int lv;
	int hp;
	String name;
	int power;
	Monster(String name, int lv){
		this.hp = lv * 80;
		this.power = lv*80;
		this.name = name;
	}


}