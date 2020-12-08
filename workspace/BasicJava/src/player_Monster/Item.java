package player_Monster;
/*       0 : Default (None) 
 *  1 ~ 10 : Helmet
 *  11~ 20 : Weapon
 *  21~ 30 : Armor
 *  31~ 40 : Shield
 *  41~ 50 : Boots
 *  51~ 60 : Consumables  */
public class Item {
	
	String name;
	int itemcode;
	int att,hp,def;
	int requiredLevel;
	int amount;
	int price; // never used yet
	boolean isEquipped = false;
	
	Item(int itemcode,int att, int hp, int def){
		this.name = AllText.itemNames[itemcode];
		this.itemcode = itemcode;
		this.requiredLevel = AllText.itemLevels[itemcode];
		this.att= att;
		this.hp = hp;
		this.def = def;
	}
	
	String statsToString(){
		String stats="";
		if(att > 0){
			stats += "[att +";
			stats += att;
			stats += "]";
		}
		if(hp > 0){
			stats += "[hp +";
			stats += hp;
			stats += "]";
		}
		if(def > 0){
			stats += "[def +";
			stats += def;
			stats += "]";
		}
		return stats;
	}

}
