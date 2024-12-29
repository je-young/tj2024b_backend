package day09_BoardProgram4_생성자;

public class Example3 { // class s

	public static void main(String[] args) { // main s

		// (1) new 연산자 와 생성자 Person() 이용한 인스턴스 생성
		new Person();

		// (2) 주로 생성된 인스턴스의 참조/주소/메모리 위치 값을 변수에 대입한다.
		// 1. 디폴트 생성자 사용.
		Person personLee = new Person();
		personLee.name = "이정만";

		// 2. 매개변수 1개 생성자 사용
		Person personKim = new Person("유재석");

		System.out.println(personLee.name);
		System.out.println(personKim.name);

		// 3. 매개변수 3개 생성자 사용
		Person personYou = new Person("유재석", 180.1f, 82.9f);

		System.out.println(personYou.name); // 유재석
		System.out.println(personYou.height); // 180.1
		System.out.println(personYou.weight); // 83.9

	} // main end

} // class end
