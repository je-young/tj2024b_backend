package day10;

public class Member {
	
	// 멤버 변수 (private 키워드 적용)
	private String id;				// 아이디
	private String password;		// 비밀번호
	private String nickname;		// 닉네임
	
	// 생성자: 회원 객체 생성시 필수 정보 입력
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}

	// Getter / Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
