package yunjihye;

import java.util.Scanner;

import e_oop.ScanUtil;


public class Tamagochi {

	public static void main(String[] args) {
			KakaoFriends k = null;
		
				System.out.println();
				System.out.println("◆◆◆카카오 다마고치 게임◆◆◆");
				System.out.println("◆◆◆카카오 프렌즈를 고르세요◆◆◆");
				System.out.println("1.라이언  2.죠르디  3.어피치");
				int x = ScanUtil.nextint(); 
				
				System.out.println();
				System.out.println("◆◆◆이름을 지어주세요◆◆◆");
				String name = ScanUtil.nextLine(); 
				
				
				if(x==1)
					k = new Ryan(name);
				else if(x==2)
					k = new Apeach(name);
				else if(x==3)
					k = new Jordy(name);
//				boolean flag = true;
				
				while(true)
				{
					System.out.println("-----------------MENU----------------");
					System.out.println("1. 밥\t2. 잠\t3. 운동\t4. 공부\t5. 종료");
					x = ScanUtil.nextint();
					switch(x)
					{
					case 1:
						k.eat();
						k.print();
						break;
						
					case 2:
						k.sleep();
						k.print();
						break;
						
					case 3:
						k.exercise();
						k.print();
						k.getExp(k.exp1);
						if(k.energy <= 0){
							System.out.println(name +"이(가) 죽었습니다.");
							System.exit(0);
						}
						
						break;
						
					case 4:
						k.study();
						k.print();
						k.getExp(k.exp1);
						if(k.energy <= 0){
							System.out.println(name +"이(가) 죽었습니다.");
							System.exit(0);
						}
						
						break;
						
					case 5:
						System.out.println("게임이 종료되었습니다.");
						System.exit(0);
						break;
					
						}
	    }
	}
}





