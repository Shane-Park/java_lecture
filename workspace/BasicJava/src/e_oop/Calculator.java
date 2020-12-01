package e_oop;

public class Calculator {
	// 두개의 파라미터를 받아서 연산을 함. 그래서 그 결과를 리턴. 그런 메서드가 5개 ( +,-,*,/,%)
	
	double add(double a, double b){
		return a+b;
	}
	
	double subtract(double a,double b){
		return a-b;
	}
	
	double multiply(double a,double b){
		return a*b;
	}
	
	double divide(double a,double b){
		if(b!=0)
			return Math.round((double)a/b)*100/100.0;
		else{
			System.out.println("0 으로 나눌 수 없습니다.");
			return 0;
		}
	}
	
	double remain(double a, double b){
		return a%b;
	}

}
