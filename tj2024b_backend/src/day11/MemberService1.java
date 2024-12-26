package day11;

import day10.Member;

public class MemberService1 {
	// 최대 100명의 회원을 저장할 수 있는 배열
		private Member[] members = new Member[100];
		private int memberCount = 0; // 현재 저장된 회원 수
		
		// 회원가입 함수
		public void registerMember(String id, String password, String nickname) {
			if (memberCount >= 100) {
				System.out.println("회원 저장 공간이 가득 찼습니다.");
				return;		} // if end
			
			// 새로운 회원 객체 생성 후 배열에 저장
			members[memberCount] = new Member(id, password, nickname);
			memberCount++;
			System.out.println("회원가입이 완료되었습니다.");
		} // 회원가입 함수 end
		
		// 로그인 함수
		public boolean loginMember(String id, String password) {
			for (int index = 0; index <= members.length -1; index++) {
				if (members[index].getId().equals(id) && members[index].getPassword().equals(password)) {
					System.out.println("로그인 성공! 환영합니다." + members[index].getNickname() + "님!");
					return true;
				}
			} // for end
			System.out.println("로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.");
			return false;
			
		}

}
