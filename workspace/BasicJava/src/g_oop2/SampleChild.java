package g_oop2;

public class SampleChild extends SampleParent {
	void ChildMethod(){
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);
		System.out.println(method(7,13));
	}
	
	// 오버라이딩 : 상속받은 내용을 변경하는것
	// super , super() : 부모/자식 이름같을떄 구분위해, 부모클래스의 생성자를 호출
	// 다형성
	
	// 오버라이딩  : 상속받은 메서드의 내용을 재정의 하는 것.
	@Override  // 어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것.
	int method(int a,int b){ // 리턴 타입, 메서드 명, 파라미터 모두 같아야 한다.
		return a*b;
	}
	
	// super , super()
	int var;
	
	void test(double var){
		System.out.println(var);		//지역변수
		System.out.println(this.var);	//인스턴스 변수
		System.out.println(super.var);	//부모 클래스의 인스턴스 변수
		// super :  부모 클래스의 멤버와 자식 클래스의 멤버가
		// 			이름이 중복될 때 둘을 구분하기 위해 사용한다.
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20));
	}

	SampleChild(){
		super(); // 부모 클래스의 생성자 호출
		//super()를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
	}
	
}
