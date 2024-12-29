package day01_변수_자료형;

public class Example2 {

	public static void main(String[] args) {

		// 1. boolean 타입은 true 와 false 만 저장할 수 있다.
		boolean bool1 = true;
		System.out.println("bool1 : " + bool1);
		// boolean bool2 = 3; // 오류발생 :boolean 타입에 3을 저장할 수 없다.
		boolean bool3 = false;
		System.out.println("bool3 : " + bool3);

		// 2. char 타입은 작은 따옴표를 이용한 문자 1개만 저장할 수 있다.
		char ch1 = 'A';
		System.out.println("ch1 : " + ch1);
		// char ch3 = "ABC"; // 오류발생 : 문자 1개만 저장가능 하므로 오류.
		// char ch3 = "ABC"; // 오류발생 : char 은 큰 따옴표를 사용할 수 없다.

		// 3.String 클래스타입은 큰 따옴표를 이용한 문자 여러개 저장할 수 있다. *참고로 기본타입은 아니다.
		String str1 = "ABC";
		System.out.println("str1 : " + str1);
		// string str2 = 'ABC'; // 오류발생 : 문자 여러개는 큰 따옴표로 감싸야 한다.

		// 4. byte 타입은 -128 ~ +127 까지 저장이 가능하다.
		byte b1 = 100;
		System.out.println(b1);
		// byte b2 = 300; // 오류발생 : 타입의 저장 허용범위 벗어났기 때문에 오류.

		// 5. 타입은 대략 +- 3만 정도 저장이 가능하다.
		short s1 = 32000;
		System.out.println("s1 : " + s1);

		// 6. int 타입은 대략 +- 21억 정도 저장이 가능하다.
		int i1 = 2100000000;
		System.out.println("i1 : " + i1);
		// int i2 = 3000000000; // 오류발생 : 타입의 저장 허용범위 벗어났기 때문에

		// 7. long 타입은 대략 +- 21억 이상 저장이 가능하다.
		long lo1 = 3000000000L;
		System.out.println("lo1 : " + lo1);

		// 8. float 타입은 소수점 8자리 까지 표현, 실수 리터럴 값 뒤에 F/f 붙인다.
		// float f1 = 0.123456789; // 오류발생 : 실수 리터럴 값은 double 이므로 float 에 대입할 수 없다.
		float f2 = 0.123456789123456789F;
		System.out.println("f2 : " + f2);

		// 9. double 타입은 소수점 17자리 까지 표현, 실수리터럴 값의 기본타입
		double d1 = 0.123456789123456789;
		System.out.println("d1 : " + d1);
	}

}
