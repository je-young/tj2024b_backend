package day07_BoardProgram2_배열;

import java.util.Scanner;

/*
  실습2 : 게시판 프로그램
  	- 문법 : 변수, 입출력함수, 
  
*/

public class BoardProgram2 { // class s

	// main + 자동완성
	public static void main(String[] args) { // main s
		// [5] 클래스 만들기, 객체 생성
		Board board1 = new Board();
		Board board2 = new Board();
		Board board3 = new Board();

		try (// [3] 입력함수, Scanner,
				Scanner scan = new Scanner(System.in)) {
			// [1] 반복문, while, while(true){ } 무한루프
			while (true) { // while s

				// [2] 출력함수, println
				System.out.print("1.등록 2.출력 3.종료 : ");

				int choose = scan.nextInt();

				// [4] 조건문, if, 코드의 흐름제어
				if (choose == 1) { // if s
					System.out.println(">> 등록 선택했습니다.");
					System.out.print("> 제목 : ");
					String title = scan.next();
					System.out.print("> 내용 : ");
					String content = scan.next();
					System.out.print("> 작성자 : ");
					String writer = scan.next();
					if (board1.title == null) { // [6] 첫번째 객체의 내용물이 비어 있으면 대입
						board1.title = title;
						board1.content = content;
						board1.writer = writer;
					} else if (board2.title == null) {
						board2.title = title;
						board2.content = content;
						board2.writer = writer;
					} else if (board3.title == null) {
						board3.title = title;
						board3.content = content;
						board3.writer = writer;
					}
				} // if end
				else if (choose == 2) {
					System.out.println(">> 출력 선택했습니다.");
					if (board1.title != null) { // [6] 첫번째 객체의 내용물이 비어 있으면 대입
						System.out.println("제목:" + board1.title + " / 내용:" + board1.content + " / 작성자:" + board1.writer);
					} else if (board2.title != null) {
						System.out.println("제목:" + board2.title + " / 내용:" + board2.content + " / 작성자:" + board2.writer);
					} else if (board3.title != null) {
						System.out.println("제목:" + board3.title + " / 내용:" + board3.content + " / 작성자:" + board3.writer);
					}
				} // else if end
				else if (choose == 3) {
					System.out.println(">> 종료 선택했습니다.");
					break;
				} // else if end
			} // while end
		} // try end
	} // main end
} // class end
