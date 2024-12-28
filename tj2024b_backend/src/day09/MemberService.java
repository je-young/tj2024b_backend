package day09;

/*
	1. 기본타입 : boolean char byte short int long float double (*8*)
		== 기본타입 비교   
	2. 참조/클래스타입 : String , Scanner , Member , MemberService ( 8개 외 )
		.equals() 참조타입 비교 함수 
*/

import java.util.Scanner;

public class MemberService { // class s
	// 회원 객체가 사용하는 메소드 설계
	void signup(Scanner scan, Member[] memberArray) { // void s

		System.out.print("아이디 : ");
		String id = scan.next();

		System.out.println("비밀번호 : ");
		String pw = scan.next();

		System.out.println("닉네임 : ");
		String name = scan.next();

		Member member = new Member();
		member.id = id;
		member.pw = pw;
		member.name = name;

		boolean sigupState = false;
		for (int index = 0; index <= memberArray.length - 1; index++) { // for s
			if (memberArray[index] == null) { // if s
				memberArray[index] = member;
				sigupState = true;
				break;
			} // if end
		} // for end
		if (sigupState) { // if s
			System.out.println("회원가입 성공");
		} // if end
		else { // else s
			System.out.println("회원가입 실패");
		} // else end
	} // void end

	void login(Scanner scan, Member[] memberArray) { // void s
		System.out.print("로그인 아이디 : ");
		String id = scan.next();

		System.out.print("로그인 비밀번호 : ");
		String pw = scan.next();

		boolean loginState = false;
		for (int index = 0; index <= memberArray.length - 1; index++) { // for s
			if (memberArray[index] != null) { // if s
				if (memberArray[index].id.equals(id) && memberArray[index].pw.equals(pw)) { // if s
					System.out.println("로그인 성공");
					loginState = true;
					break;
				} // if end
				else {
					System.out.println("로그인 실패");
				}
			} // if end
		} // for end
		// if (loginState) { // if s
		// System.out.println("로그인 성공");
		// } // if end
		// else { // else s
		// System.out.println("로그인 실패");
		// } // else end
	} // void end
} // class end
