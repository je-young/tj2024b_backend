package day07;

import java.util.Scanner;

/*자바 조별 과제 1 
주제 : 회원 서비스 구현하기 
	- 문법 : 변수 , 입출력함수 , 연산자 , 제어문(조건문/반복문) , 클래스 (멤버변수) / 객체
	- 회원 최대 3명까지 저장
	- 회원 정보는 아이디 , 비밀번호 , 닉네임을 갖는다
	- 회원클래스를 정의하고 회원 객체 활용하여 구현
	- 프로그램 초기 메뉴 : 1. 회원가입 2. 로그인 :
		1 선택시 : 아이디 , 비밀번호 , 닉네임 3개 각 정보를 입력받아 저장
		2. 선택시 : 아이디, 비밀번호를 입력받아 기존의 저장된 정보와 일치한 정보가 있으면 '로그인성공' 아니면 '로그인 실패' 출력

 1. 코드 구현 : 카카오톡방에 과제 코드가 존재하는 본인 git 상세주소 제출 
 2. 구현 된 코드에서 문법찾기 : 아래 링크의 각 슬라이드에서 조별 작성 , 카톡방 링크 참고
https://docs.google.com/presentation/d/1k7xc6I3MwnBI57zr1WTGm0mVgzQ5CXkmrEro2PFc9UI/edit?usp=sharing
		*/

public class Example3 { // 클래스 시작
	public static void main(String[] args) { // main 시작
		Scanner scan = new Scanner(System.in); // 스캐너 객체를 한 번만 생성

		// [2] 최대 3명의 회원을 저장할 Member 객체 생성
		Member m1 = null; // 첫 번째 회원
		Member m2 = null; // 두 번째 회원
		Member m3 = null; // 세 번째 회원

		while (true) { // 무한 반복문 시작
			// [3] 메뉴 출력
			System.out.println("=== 회원 서비스 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴를 선택하세요 (1 또는 2): ");

			int choose = scan.nextInt(); // 메뉴 선택
			scan.nextLine(); // 버퍼 비우기

			if (choose == 1) { // [4] 회원가입 처리
				System.out.print("아이디: ");
				String id = scan.nextLine();

				System.out.print("비밀번호: ");
				String pw = scan.nextLine();

				System.out.print("닉네임: ");
				String nkname = scan.nextLine();

				// [5] 중복 아이디 체크 및 빈 슬롯에 회원 저장
				if ((m1 != null && m1.id.equals(id)) || (m2 != null && m2.id.equals(id))
						|| (m3 != null && m3.id.equals(id))) {
					System.out.println("이미 존재하는 아이디입니다.\n");
					continue;
				}

				if (m1 == null) { // 첫 번째 슬롯이 비어있으면 저장
					m1 = new Member();
					m1.id = id;
					m1.pw = pw;
					m1.nkname = nkname;
					System.out.println("회원가입이 완료되었습니다.\n");
				} else if (m2 == null) { // 두 번째 슬롯이 비어있으면 저장
					m2 = new Member();
					m2.id = id;
					m2.pw = pw;
					m2.nkname = nkname;
					System.out.println("회원가입이 완료되었습니다.\n");
				} else if (m3 == null) { // 세 번째 슬롯이 비어있으면 저장
					m3 = new Member();
					m3.id = id;
					m3.pw = pw;
					m3.nkname = nkname;
					System.out.println("회원가입이 완료되었습니다.\n");
				} else {
					System.out.println("더 이상 회원가입이 불가능합니다. 최대 회원 수는 3명입니다.\n");
				}
			} else if (choose == 2) { // [6] 로그인 처리
				System.out.print("아이디: ");
				String id = scan.nextLine();

				System.out.print("비밀번호: ");
				String pw = scan.nextLine();

				// [7] 입력받은 정보와 회원 정보 비교
				if ((m1 != null && m1.id.equals(id) && m1.pw.equals(pw))
						|| (m2 != null && m2.id.equals(id) && m2.pw.equals(pw))
						|| (m3 != null && m3.id.equals(id) && m3.pw.equals(pw))) {
					System.out.println("로그인 성공! 환영합니다.\n");
				} else {
					System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.\n");
				}
			} else {
				// [8] 잘못된 입력 처리
				System.out.println("잘못된 메뉴 선택입니다. 1 또는 2를 입력하세요.\n");
			}
		}
	}
}