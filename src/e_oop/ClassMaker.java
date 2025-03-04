package e_oop;

public class ClassMaker {
	int v= 0;
	// 전역 변수 하나를 선언 빛 초기화 해주세요.
	
	// 리턴 타입과 파라미터가 없는 메서드 하나를 만들어주세요.
	// 메서드 안에서 전역변수를 출력해주세요.
	void Method1(){
		System.out.println(v);
	}
	
	// 전역 변수와 동일한 타입의 리턴 타입이 있고 파라미터는 없는 메서드 하나를 만들어주세요.
	// 메서드 안에서 전역변수를 리턴해주세요.
	int Method2(){
		return v;
	}
	
	// 리턴 타입은 없고 파라미터가 있는 메서드를 하나 만들어주세요.
	// 메서드 안에서 파라미터를 출력해주세요.
	void Method3(int a){
		System.out.println(a);
	}
	
	// int 타입의 리턴 타입과 int 타입의 파라미터 두 개가 있는 메서드 하나를 만들어주세요.
	// 메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요.
	int Method4(int a, int b){
		return a * b;
	}
	


}
