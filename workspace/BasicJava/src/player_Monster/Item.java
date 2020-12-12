package player_Monster;

public class Item {
	
	String name;                           // *       0 : Default (None) 
	int itemcode;                          // *  1 ~ 10 : Helmet
	int att,hp,def;                        // *  11~ 20 : Weapon
	int requiredLevel;                     // *  21~ 30 : Armor
	int amount;                            // *  31~ 40 : Shield
	int price; // never used yet           // *  41~ 50 : Boots
	boolean isEquipped = false;            // *  51~ 60 : Consumables  
	
	Item(int itemcode,int att, int hp, int def){
		AllText text = null;
		switch(GameMain.language){
		case 1:
			text = new AllText_ENG();
			break;
		case 2:
			text = new AllText_KOR();
			break;
		}
		
		this.name = text.getItemName(itemcode);
		this.itemcode = itemcode;
		this.requiredLevel = text.getItemLevel(itemcode);
		this.att= att;
		this.hp = hp;
		this.def = def;
	}
	
	String statsToString(){
		String stats="";
		if(att > 0){
			stats += "[att +";stats += att;	stats += "]";
		}
		if(hp > 0){
			stats += "[hp +";stats += hp;stats += "]";
		}
		if(def > 0){
			stats += "[def +";stats += def;stats += "]";
		}
		return stats;
	}

}
