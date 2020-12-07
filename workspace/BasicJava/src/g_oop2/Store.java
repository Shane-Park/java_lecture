package g_oop2;

public class Store {
	public static void main(String[] args) {
		Desktop d1 = new Desktop("삼성 컴퓨터",1_000_000);
		Desktop d2 = new Desktop("LG 컴퓨터",1_000_000);
		
		AirCon ac1 = new AirCon("삼성 에어컨", 200_000);
		AirCon ac2 = new AirCon("LG 에어컨", 180_000);
		
		TV tv1 = new TV("삼성 TV", 300_000);
		TV tv2 = new TV("LG TV", 680_000);
		
		Customer c = new Customer();
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		c.buy((Product)d1);
		System.out.println(ac1.getInfo());
		System.out.println(ac2.getInfo());
		c.buy((Product)ac2);
		System.out.println(tv1.getInfo());
		System.out.println(tv2.getInfo());
		c.buy(tv1);
		
		c.showItem();
		
		Product p = new Desktop("컴퓨터",1000);
		Desktop d = (Desktop) p;
		d.programming();
		
	}
}

class Product{
	String name;//이름
	int price;	//가격

	Product(String name, int price){
		this.name = name;
		this.price = price;
	}

	// 상품의 정보를 반환하는 메서드
	String getInfo(){
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	Desktop(String name, int price){
		super(name,price);
	}

	void programming(){
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(String name,int price){
		super(name,price);
	}

	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV(String name, int price){
		super(name,price);
	}

//	void setChannel(){
//		System.out.println("채널을 변경합니다.");
//	}
}

class Customer{
	int money = 10_000_000;
	Product[] item = new Product[100];

	void buy(Product p){
		if(money < p.price){
			System.out.println("잔돈이 부족합니다.");
			return;
		}

		money -= p.price;

		for(int i=0; i< item.length; i++){
			if(item[i] == null){
				item[i] = p;
				break;
			}
		}
		System.out.println(p.getInfo() +"를 구매했습니다.");
	}

	void showItem(){
		System.out.println("========= 장바구니 =========");
		for(int i=0; i<item.length; i++){
			if(item[i] == null){
				break;
			}else System.out.println(item[i].getInfo());

		}
	}
}






