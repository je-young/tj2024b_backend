package day08_BoardProgram3_메소드;

import java.util.Scanner;

/*
 	자바 과제7 : (식당) 대기번호 발행 프로그램
 		- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문), 클래스/객체, 배열
 		- 전화번호, 인원수 를 입력 받아서 저장/출력 구현
 		- 명단 클래스 설계한다.
 		- 총 대기명단은 100개 까지 가능하다.
 		제출 : 카카오톡방에 과제 코드가 존재하는 본인 git 상세주솧 제출
 */

public class Example1 { // class s

	public static void main(String[] args) { // main s

		// [5] 클래스 정의
		Waiting[] waitingArray = new Waiting[100];

		try (Scanner scan = new Scanner(System.in)) {

			// [1] 반복문
			while (true) { // while s

				System.out.println(">>>> (식당) 대기번호 발행 프로그램");
				System.out.print(">>> 1.대기명단등록 2. 대기명단현황 :"); // [2] 출력함수
				int choose = scan.nextInt(); // [3] 입력함수

				// [4] 조건문
				if (choose == 1) { // if s
					System.out.print(">> 전화번호 : ");
					String phone = scan.next();

					System.out.print(">> 인원수 : ");
					int count = scan.nextInt();

					// [6] 객체 생성후 입력받은 값 대입
					Waiting waiting = new Waiting();
					waiting.phone = phone;
					waiting.count = count;

					for (int index = 0; index <= waitingArray.length - 1; index++) { // for s
						if (waitingArray[index] == null) { // if s
							waitingArray[index] = waiting;
							break;
						} // if end
					} // for end
				} // if end

				else if (choose == 2) { // else if s
					for (int index = 0; index <= waitingArray.length - 1; index++) { // for s
						if (waitingArray[index] != null) { // if s
							System.out.printf(">> 인원수 %d 명 , 연락처 : %s \n",
									waitingArray[index].count, waitingArray[index].phone);
						} // if end
					} // for end
				} // else if end
			} // while end
		} // try end
	} // main end
} // class end
