package day13_BoardProgram8_싱글톤_MVC패턴_DB생성과삭제;

public class Example1 { // class s

	public static void main(String[] args) { // main s

		// 단계4 : 싱클톤 호출
		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();

		// - 두 변수가 참조하는(갖는) 객체는 동일한 (싱글톤)객체 이다.
		System.out.println(myCompany1); // day13.Company@2a139a55
		System.out.println(myCompany2); // day13.Company@2a139a55

		// 참고1 : 다른 클래스에서 Company 객체를 만들수 없다.
		// Company myCompany3 = new Company(); // 오류

		// 참고2 : 싱글톤 내부의 메소드 호출하는 방법
		Company.getInstance().method();
		// - 유재석.밥먹기().공부하기();
		// 실행순서1 : 유재석.밥먹기()
		// 실행순서2 : 밥먹기결과값.공부하기()

		// 실행순서1 : Company.gerInstance() => 싱글톤(instance)
		// 실행순서2 : instance.method();

	} // main end

} // class end
