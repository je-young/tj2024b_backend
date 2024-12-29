package day11_BoardProgram6_1개월차미니프로젝트발표;

import java.util.Scanner;

public class BoardService { // class s

	// 1. 멤버변수
	// 2. 생성자
	// 3. 메소드

	// 3-1 게시물 등록
	public void boardAdd(Scanner scan, BoardDto[] boards) { // boardAdd s

		System.out.println(">> 게시물 등록하세요!");
		System.out.print("> 제목 : ");
		String title = scan.nextLine();

		System.out.print("> 내용 : ");
		String content = scan.nextLine();

		System.out.print("> 작성자 : ");
		String writer = scan.nextLine();

		// * 생성자를 이용한 객체 생성
		BoardDto boardDto = new BoardDto(title, content, writer);

		// * 배열에 저장
		boolean saveState = false;
		for (int index = 0; index <= boards.length - 1; index++) {
			if (boards[index] == null) {
				boards[index] = boardDto;
				saveState = true;
				break;
			} // if end
		} // for end
		if (saveState) {
			System.out.println("> 등록 성공!");
		} else {
			System.out.println("> 등록 실패!");
		} // if else end
	} // boardAdd end

	// 3-2. 모든 게시물 출력
	public void boardPrint(BoardDto[] boards) { // boardPrint s
		for (int index = 0; index <= boards.length - 1; index++) {
			if (boards[index] != null) {
				System.out.println("===== 출력내용 =====");
				System.out.printf("제목 : %s , 내용 : %s , 작성자 : %s \n",
						boards[index].getTitle(),
						boards[index].getContent(),
						boards[index].getWriter());
			} // if end
		} // for end

	} // boardPrint end

} // class end
