package player_Monster;

public class Player{
	int lv;
	int exp_max;
	int exp;
	int hp_max;
	int hp;
	int gold;
	int atk;
	int def;
	int bonusStats;
	String name;
	int[] equips = new int[5]; // { Helmet, Weapon, Armor, Shield, Boots}
	Item[] inventory = new Item[10];
	int inventoryCount=0;
	int[] exp_table = {0, 10, 30, 80, 220, 300, 500, 800, 2500};

	Player(){
		this(1,80,10);	// Constructor (START LEVEL, START HP, START GOLD)
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
		this.atk = 30;
		this.def = 1;
		this.bonusStats = 3;
		
		final int startItem = 11; 						// Getting free start item
		inventory[0] = new Item(startItem,5,0,0);		// start item is a basic sword Item(int itemcode,int att, int hp, int def)		
		inventoryCount++;								// It's not equipped yet
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
		atk += 3;
		def += 1;
		hp = hp_max;
		bonusStats += lv/10+1;
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
		int damage = atk - m.def;
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

	void hpup(){
		if(bonusStats>0){
			int bonusHp = 30;
			hp_max += bonusHp;
			hp+= bonusHp;	// recover as much as bonus HP is
			bonusStats --;
		}
	}
	void atkup(){
		if(bonusStats>0){
			atk += 3;
			bonusStats --;
		}

	}
	void defup(){
		if(bonusStats>0){
			def += 1;
			bonusStats --;
		}
	}

	void buyItem(int itemcode, int price){
		AllText.buyItem();
		switch(GameSystem.nextLine()){
		case "1":
			if(gold<price){
				AllText.notEnoughMoney(price, gold);
				return;
			}
			gold -= price;
			this.newItem(itemcode);
			AllText.buySuccess(price);
			break;
		case "2":
			break;
		default:
			AllText.wrong();
			break;
		}
	}
	void newItem(int itemcode){
		int i;
		for(i=0; i<inventory.length; i++){
			if(inventory[i] == null)
				break;
		}
		if(inventory[i] != null){
			AllText.inventoryFull();
			return;
		}else{
			if(i!=0){	// check duplicated items only when player have any item
				for(int j=0; j<inventoryCount; j++){
					if(inventory[j].itemcode==itemcode){
						inventory[j].amount++;
						return;
					}
				}
			}

			inventory[i] = new Item(itemcode,0,0,0); //(int itemcode,int att, int hp, int def)
			inventoryCount++;
			inventory[i].amount++;
		}
	}

	void itemList(){
		AllText.itemList(this);
		AllText.pressAny();
	}

	void sellItem(){

	}

	void equiplist(){
		int equipSelect = 0;
		equipSelect : while(true){
			AllText.printBar();
			if(equipSelect ==0) System.out.print("■"); else System.out.print("□");
			AllText.helmet(equips[0]);
			if(equipSelect ==1) System.out.print("■"); else System.out.print("□");
			AllText.weapon(equips[1]);
			if(equipSelect ==2) System.out.print("■"); else System.out.print("□");
			AllText.armor(equips[2]);
			if(equipSelect ==3) System.out.print("■"); else System.out.print("□");
			AllText.sheild(equips[3]);
			if(equipSelect ==4) System.out.print("■"); else System.out.print("□");
			AllText.boots(equips[4]);	
			AllText.printBar();
			AllText.selectEquip();
			String input = GameSystem.nextLine();
			switch(input){
			case "0" : 
				break equipSelect;
			case "1" :
				if(0<= equipSelect && equipSelect <=3)
					equipSelect++;
				else equipSelect = 0;
				break;
			case "2" :
				if(1<= equipSelect && equipSelect <=4)
					equipSelect--;
				else equipSelect = 4;
				break;
			case "3" :
				changeEquip(equipSelect);
				break;
			default :
				AllText.wrong();
			}
		}
	}
	
	void changeEquip(int equipSelect){
		int showlists = 5;
		Item[] equipList = new Item[showlists];
		int count=0;
		int[] rememberInventory = new int[showlists];
		for(int i=0; i<inventoryCount; i++){
			if((inventory[i].itemcode-1)/10==equipSelect){
				equipList[count] = inventory[i];
				rememberInventory[count] = i;
				count++;
			}		
		}
		Item blank = new Item(0,0,0,0);
		for(int i=count; i<showlists; i++)
			equipList[i] = blank;	
		AllText.equipList(equipSelect, equipList);
		System.out.print("착용하고 싶은 장비를 선택해주세요. (0) 돌아가기 (1~5) 아이템 선택 \n>");
		
		String input = GameSystem.nextLine();
		switch(input){
		case "0": break;
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
			int n = Integer.parseInt(input); // use n to find equipment
			// wear(equipSelect,inventory[rememberInventory[]] // (Type of Equipment,Equipment)
			break;
		default :
			AllText.wrong();
		}
	}



}



