package selfstudy_test;

public class Study_test_04 {
	public static void main(String[] args) {

		byte a=127;
		System.out.println(a);
		
		a = a++;
		System.out.println(a);
		
		System.out.println((byte)(a+1));
		
		a = -128;
		System.out.println("\n"+a);
		
		a = a--;
		System.out.println(a);
		
		System.out.println(a-1);
		
		System.out.println((byte)(a-1));



	}

}
