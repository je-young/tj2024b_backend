package day08_BoardProgram3_메소드;

public class Example2 { // class s

	public static void main(String[] args) { // main s

		// [1] 함수 호출하고 값 반환하기
		int num1 = 10;
		int num2 = 20;

		// 내가 만든 add 함수에 num1 값과 num2 값을 인수로 전달하고 반환값을 sum 변수에 대입한다.
		int sum = add(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + sum + "입니다.");

	} // main end

	// (1) 함수 정의하기, 반환타입: int, 함수명: add, 매개변수: int n1 int n2
	private static int add(int n1, int n2) { // add s

		int result = n1 + n2;
		return result; // 반환값: 함수가 종료되면서 현재 함수를 호출했던 곳으로 반환값

	} // add end

} // class end
