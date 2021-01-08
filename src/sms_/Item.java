package sms_;

public class Item {

	String name;
	int price;
	int hp;
	int exp;
	int att;
	int qty;
	
	Item(String name, int price, int hp, int exp, int att, int qty){
		this.name = name;
		this.price = price;
		this.hp = hp;
		this.exp = exp;
		this.att = att;
		this.qty = qty;
	}
	
	void showInfo(){ 
		if(price != 0){
			System.out.println(name + "(" + price + "원)");
		}
		else{
			System.out.println(name);
		}
		if(hp != 0){
			System.out.println("효과 > hp : " + hp);	
		}if(exp != 0){
			System.out.println("효과 > exp : " + exp + " / 현재 개수 : " + qty);
		}if(att != 0){
			System.out.println("효과 > att : +" + att);
		}	
	}
	
	
}

class FoodItem extends Item{
	
	FoodItem(String name, int price, int hp, int exp, int att, int qty){
		super(name, price, hp, exp, att, qty);
	}	
}


class PlayItem extends Item{
	
	PlayItem(String name, int price, int hp, int exp, int att, int qty){
		super(name, price, hp, exp, att, qty);
	}
	
}








