package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그램을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */
//		SampleClass sc = new SampleClass();
//		System.out.println(sc.field);
//		sc.method1();
//		System.out.println(sc.method2(1));
//		sc.flowTest1();
		
		// 다음을 한 줄씩 계산해서 최종 결과값을 출력해주세요.
		Calculator calc = new Calculator();
		
		// 1. 123456 + 654321
		double number = calc.add(123456,654321);
		System.out.println((long)number);
		
		// 2. 1번의 결과값 * 123456
		number = calc.multiply(number,123456);
		System.out.println((long)number);
		
		// 3. 2번의 결과값 / 123456
		number = calc.divide(number,123456);
		System.out.println(number);
		
		// 4. 3번의 결과값 - 654321
		number = calc.subtract(number,654321);
		System.out.println(number);
		
		// 5. 4번의 결과값 % 123456
		number = calc.divide(number, 654321);
		System.out.println(number);


	}

}
