package day06;

import java.util.Scanner;

/*
 	자바 과제3 : (식당) 대기번호 발행 프로그램
 	- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문)
 	- 전화번호, 인원수 를 입력받아서 저장/출력 구현
 	- 총 대기명단은 3개 까지 가능하다. 대기 명단 1개당 전화번호/인원수 저장소(변수) 2개 필요, 대기명단 3개 --> 변수 6개 필요.
*/


public class Example1 {		// class start

	public static void main(String[] args) {	// main start
		
		// [5] 각 사용자에게 입력받은 값들을 저장할 변수 선언
		String phone1 = null; int count1 = 0;
		String phone2 = null; int count2 = 0;
		String phone3 = null; int count3 = 0;

		while (true) {	// [1] while 반복문, while(true){ } 무한반복문, 대기 명단을 등록과 출력을 24시간 하기 위해서 무한루프 사용했다.
			System.out.print("1.대기등록	2.대기현황 : "); // [2] 출력함수, print() , 사용자에게 등록과 출력 메뉴를 보여준다.
			
			// [3] 입력함수 , Scanner 객체필요
			Scanner scan =  new Scanner(System.in);
			int choose = scan.nextInt();
			
			// [4] 논리 연산에 따른 제
			if (choose == 1) {
				System.out.println(">>> 대기명단 등록 >>>");
				System.out.print(">>> 전화번호 : ");	String phone = scan.next();
				System.out.print(">>> 인원수 : ");	int count = scan.nextInt();
				
				if ( phone1 == null ) {
					phone1 = phone; count1 = count;
				}else if ( phone2 == null ) {
					phone2 = phone; count2 = count;
				}else if ( phone3 == null ) {
					phone3 = phone; count3 = count;;
				}
				else if (choose == 2) {
					System.out.println(">>> 대기명단 현황 >>>");
					if ( phone1 != null ) {System.out.printf("인원수 %d 명 , 연락처 : %s \n" , count1 , phone1);}
					if ( phone2 != null ) {System.out.printf("인원수 %d 명 , 연락처 : %s \n" , count2 , phone2);}
					if ( phone2 != null ) {System.out.printf("인원수 %d 명 , 연락처 : %s \n" , count2 , phone2);}
				}
			} // if end
		} // while end
	}	// main end

}	// class end
