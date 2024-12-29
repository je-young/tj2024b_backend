package day06_BoardProgram1_클래스;

import java.util.Scanner;

/*
 	자바 과제3 : (식당) 대기번호 발행 프로그램
 	- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문)
 	- 전화번호, 인원수 를 입력받아서 저장/출력 구현
 	- 총 대기명단은 3개 까지 가능하다. 대기 명단 1개당 전화번호/인원수 저장소(변수) 2개 필요, 대기명단 3개 --> 변수 6개 필요.
*/

public class Example1 { // class start

	public static void main(String[] args) { // main start

		// [5] 각 사용자에게 입력받은 값들을 저장할 변수 선언
		String phone1 = null;
		int count1 = 0;
		String phone2 = null;
		int count2 = 0;
		String phone3 = null;
		int count3 = 0;

		try (Scanner scan = new Scanner(System.in)) { // [3] 입력함수 , Scanner 객체필요
			while (true) { // [1] while 반복문, while(true){ } 무한반복문, 대기 명단을 등록과 출력을 24시간 하기 위해서 무한루프 사용했다.
				System.out.println(">>> 대기번호 발행 프로그램 <<<");
				System.out.print(">> 1.대기등록	>> 2.대기현황 >> 3.종료 : "); // [2] 출력함수, print() , 사용자에게 등록과 출력 메뉴를 보여준다.

				int choose = scan.nextInt(); // 사용자에게 입력받은 값을 변수에 저장

				// [4] 논리 연산에 따른 제
				if (choose == 1) {
					System.out.println(">>> 대기명단 등록 <<<"); // [6] 출력함수, println() , 사용자에게 대기명단 등록을 보여준다.
					System.out.print(">>> 전화번호 : "); // [7] 출력함수, print() , 사용자에게 전화번호 입력을 받는다.
					String phone = scan.next(); // [8] 입력함수, next() , 사용자에게 입력받은 전화번호를 변수에 저장한다.
					System.out.print(">>> 인원수 : "); // [9] 출력함수, print() , 사용자에게 인원수 입력을 받는다.
					int count = scan.nextInt(); // [10] 입력함수, nextInt() , 사용자에게 입력받은 인원수를 변수에 저장한다.

					if (phone1 == null) { // [11] 조건문, if() , 대기명단 1번이 비어있으면 대기명단 1번에 저장한다.
						phone1 = phone; // [12] 대입연산자, = , 사용자에게 입력받은 전화번호를 변수에 저장한다.
						count1 = count; // [13] 대입연산자, = , 사용자에게 입력받은 인원수를 변수에 저장한다.
					} else if (phone2 == null) { // [14] 조건문, else if() , 대기명단 2번이 비어있으면 대기명단 2번에 저장한다.
						phone2 = phone; // [15] 대입연산자, = , 사용자에게 입력받은 전화번호를 변수에 저장한다.
						count2 = count; // [16] 대입연산자, = , 사용자에게 입력받은 인원수를 변수에 저장한다.
					} else if (phone3 == null) { // [17] 조건문, else if() , 대기명단 3번이 비어있으면 대기명단 3번에 저장한다.
						phone3 = phone; // [18] 대입연산자, = , 사용자에게 입력받은 전화번호를 변수에 저장한다.
						count3 = count; // [19] 대입연산자, = , 사용자에게 입력받은 인원수를 변수에 저장한다.
					} // if end
				} else if (choose == 2) {
					System.out.println(">>> 대기명단 현황 >>>");
					if (phone1 != null) {
						System.out.printf("인원수 %d 명 , 연락처 : %s \n", count1, phone1);
					}
					if (phone2 != null) {
						System.out.printf("인원수 %d 명 , 연락처 : %s \n", count2, phone2);
					}
					if (phone3 != null) {
						System.out.printf("인원수 %d 명 , 연락처 : %s \n", count3, phone3);
					} else {
						System.out.println("대기명단이 비어있습니다.");
					} // if end
				} else if (choose == 3) {
					System.out.println(">>> 프로그램 종료 <<<");
					break; // [20] 반복문 탈출, break , 사용자가 3번을 입력하면 프로그램을 종료한다.
				} else {
					System.out.println(">>> 잘못된 입력입니다. 다시 입력해주세요. <<<");
				} // if end
			} // while end
		} // try end
	} // main end
} // class end