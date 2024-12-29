package day11_BoardProgram6_1개월차미니프로젝트발표;

import java.util.Scanner;

/*
자바 과제11 : 회원제 게시판
	- 초기메뉴는 로그인 과 회원가입 를 제공한다. 
	- 로그인 성공하면 게시물등록과 게시물출력 를 제공합니다.
		- 단 게시물 등록시 작성자를 현재 로그인된 회원아이디로 자동 등록 됩니다.
		
제출 : 카카오톡방에 과제 코드가 존재하는 본인 git 상세주소 제출 
*/

public class Example1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		MemberService1 memberService1 = new MemberService1();

		while (true) { // while s

			System.out.println("===== 회원 서비스 프로그램 =====");
			System.out.println(">>> 1.회원가입");
			System.out.println(">>> 2.로그인");
			System.out.println(">>> 0.프로그램 종료");
			System.out.println(">>> 메뉴를 선택하세요 : ");

			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 0) {
				System.out.println(">>> 프로그램을 종료합니다.");
				break;
			} // if end

			switch (choice) {
				case 1:
					System.out.println(">> 회원가입을 진행합니다.");
					System.out.println(">> 아이디 : ");
					String id = scan.nextLine();

					System.out.println(">> 비밀번호 : ");
					String password = scan.nextLine();

					System.out.println(">> 닉네임 : ");
					String nickname = scan.nextLine();

					memberService1.registerMember(id, password, nickname);
					break;

				case 2:
					System.out.println(">> 로그인을 진행합니다.");
					System.out.println(">> 아이디 :");
					String loginId = scan.nextLine();

					System.out.println(">> 비밀번호 : ");
					String loginPassword = scan.nextLine();

					memberService1.loginMember(loginId, loginPassword);
					break;

				default:
					System.out.println(">> 올바른 메뉴를 선택하세요.");
					break;
			} // switch end

		} // while end

		scan.close();
	}

}
