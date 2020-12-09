package g_oop2;

public abstract class SampleAbstractParent {
	
	abstract void abstractMethod();
	// 추상메서드 : 선언부만 있고 구현부는 없는 메서드
	

}

class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("추상 메서드를 상속받아 내용을 만들어 줌.");
	}
	
	
}