package homeworksPackage;

import e_oop.ScanUtil;

public class E_TV {
	public static void main(String[] args) {
		E_TV tv1 = new E_TV();
		tv1.showMenu();
		tvUtil:while(true){
			switch(ScanUtil.nextLine()){
			case "1":
				tv1.power();				break;
			case "2":
				tv1.volumeDown();			break;
			case "3":
				tv1.volumeUp();				break;
			case "4":
				tv1.channelDown();			break;
			case "5":
				tv1.channelUp();			break;
			case "6" :
				if(tv1.power){
				System.out.print("Channel go to > ");
				tv1.changeChannel(ScanUtil.nextInt());
				}else System.out.println("Please turn on the TV first");
				break;
			case "7" :
				tv1.channelList();
				break;
			case "9":
				tv1.showMenu();				break;
			case "0":
				System.out.println("Thank you. See you again");
				break tvUtil;
			default :
				System.out.println("NOT PROPER NUMBER"); 		break;
			}
		}
	}
	boolean power;
	int volume =5, channel =1;
	final int MAX_VOL = 10, MAX_CH = 10;
	
	void power(){
		power= !power;
		System.out.println(power?"TV is turned ON":"TV is turned OFF");
	}
	
	void isPowerOff(){
		if(!power)
			System.out.println("Please turn on the TV first");
	}
	
	void showMenu(){
		System.out.println("===========================================================================");
		System.out.println("(1)POWER	(2)Volume↓	(3)Volume↑	(4)Channel↓	(5)Channel↑");
		System.out.println("(6)Channel→	(7)Channel List			(9)ShowMenu	(0)EXIT");
		System.out.println("===========================================================================");
		System.out.println(">>");

	}
	void volumeUp(){
		isPowerOff();
		if(volume<MAX_VOL && power)
			volume++;
		if(power)
			showVolume();
	}
	
	void volumeDown(){
		isPowerOff();
		if(volume!=0 && power)
			volume--;
		if(power)
			showVolume();
	}
	
	void showVolume(){
		System.out.print("volume: ");
		for(int i=1; i<=volume; i++)
			System.out.print("■");
		for(int i=volume; i<MAX_VOL; i++)
			System.out.print("□");
		System.out.println();
	}
	
	void channelUp(){
		isPowerOff();
		if(power && channel!=MAX_CH)
			channel++;
		else if(channel==MAX_CH && power)
			channel=1;
		if(power)
			showChannel();
	}
	
	void channelDown(){
		isPowerOff();
		if(power&& channel!=1)
			channel--;
		else if(channel==1 && power)
			channel = MAX_CH;
		if(power)
			showChannel();
	}
	
	void changeChannel(int channel){
		if(power && 1 <= channel && channel <= MAX_CH){
			this.channel = channel;
			showChannel();
		}else if(power) System.out.println("["+channel+"] IS NOT VALID CHANNEL");
	}
	
	void showChannel(){
		System.out.print("Channel : "+channel);
		switch(channel){
		case 1:
			System.out.print(" [KBS]\n");		break;
		case 2:
			System.out.print(" [MBC]\n");		break;
		case 3:
			System.out.print(" [SBS]\n");		break;
		case 4:
			System.out.print(" [TVN]\n");		break;
		case 5:
			System.out.print(" [MTV]\n");		break;
		case 6:
			System.out.print(" [Arirang]\n");	break;
		case 7:
			System.out.print(" [CNN]\n");		break;
		case 8:
			System.out.print(" [BBC]\n");		break;
		case 9:
			System.out.print(" [ABC]\n");		break;
		case 10:
			System.out.print(" [FOX]\n");		break;
			
		}
		
	}
	void channelList(){
		int temp = channel;
		for(int i=1; i<=MAX_CH; i++){
			channel = i;
			showChannel();
		}
		channel=temp;
	}


}
