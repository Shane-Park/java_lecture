package yunjihye;

public class KakaoFriends {
	
		String race; 
		String name; 
		int power; 
		int energy; 
		int level = 1;
		int exp1;
	
			public KakaoFriends() {
				System.out.println();
				System.out.println("◆◆◆시작◆◆◆");
				System.out.println();
			}
	
			void eat() {
				System.out.println();
				System.out.println("♥식사중♥");
				System.out.println("밥만 먹을 건가요...?");
				energy += 30;
				power += 10;
			}
	
			void sleep() {
				System.out.println();
				System.out.println("♥꿀잠중♥");
				System.out.println("잠만 잘 건가요...?");
				energy += 20;
				power += 10;
			}
	
			void exercise() {
				System.out.println();
				System.out.println("♥운동중♥");
				System.out.println("열심히 운동하면 다이어트에 성공할거에요!");
				energy -= 20;
				power += 30;
				exp1 += 20;
			}
	
			void study() {
				System.out.println();
				System.out.println("♥공부중♥");
				System.out.println("열심히 공부하면 취직할 수 있어요!");
				energy -= 20;
				power -= 30;
				exp1 += 20;
			}
	
			void levelUp(){
				if(100 <= this.exp1){
					level++;
					System.out.println("★☆레벨업!! "+ level + " level★☆");
				}
				
			}
			
			
			void getExp(int exp1){
				while(100 <= this.exp1){
					levelUp();
					this.exp1 -= 100;
				}
			}
			
	
	
			void print() {
				System.out.println();
				System.out.println("====="+ name + "의 현재상태=====");
				System.out.println("에너지 : " +energy);
				System.out.println("파워 : " +power);
				System.out.println("경험치 : " +exp1);
				System.out.println("레벨 : " +level);
				System.out.println();
			}
}

