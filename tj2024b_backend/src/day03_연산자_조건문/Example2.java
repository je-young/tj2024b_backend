package day03_연산자_조건문; // 클래스가 위치한 패키지명/폴더명

public class Example2 {

	public static void main(String[] args) {
		// p.88 연습문제

		// 1.
		int myAge = 23; // (1) =
		int teacherAge = 38;

		boolean value = (myAge > 25);
		System.out.println(value);

		System.out.println(myAge <= 25);
		System.out.println(value);

		System.out.println(myAge <= 25);
		System.out.println(myAge == teacherAge); // (2) ==

		char ch;
		ch = (myAge > teacherAge) ? 'T' : 'F';
		System.out.println(ch);

		// 2.
		int num;
		num = -5 + 3 * 10 / 2;
		System.out.println(num); // 10

		// 3.
		int num2 = 10;
		System.out.println(num2); // 10
		System.out.println(num2++); // 10
		System.out.println(num2); // 10
		System.out.println(--num2); // 10

		// 4.
		int num3 = 10;
		int num4 = 20;
		boolean result;

		result = ((num3 > 10) && (num4 > 10));
		System.out.println(result); // false

		result = ((num3 > 10) || (num4 > 10));
		System.out.println(result); // true
		System.out.println(!result); // false

		// 6.
		int num5 = 8;
		System.out.println(num5 += 10); // (1) 18
		System.out.println(num5 -= 10); // (2) 8

		// 7.
		int num6 = 10;
		int num7 = 20;
		int result2 = num6 >= 10 ? num7 + 10 : num7 - 10;
		// 만약에 num6값이 10이상이면 num7값에 10를 더한값을 아니면 num7값에 10를 뺀값을 result2에 대입한다.
		System.out.println(result2); // (1) 30

	}

}
