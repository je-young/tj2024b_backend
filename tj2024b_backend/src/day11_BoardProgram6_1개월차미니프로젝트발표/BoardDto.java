package day11_BoardProgram6_1개월차미니프로젝트발표;

public class BoardDto { // class s

	// * 클래스 멤버
	// 1. 멤버변수, 접근제한자, 객체속성
	private String title; // private 은 다른 클래스로 부터 접근 차단
	private String content;
	private String writer;

	// 2. 생성자
	// + 디폴트 생성자 규칙 : 1.클래스 명과 동일 2.매개변수 와 인수값 타입 / 개수 일치
	// 1. 디폴트 생성자
	public BoardDto() {
	}

	// 2. (전체) 매개변수가 3개인 생성자
	public BoardDto(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	// 3. 메소드 // 멤버변수, 객체가 실행할 함수 정의
	// 1. getter(호출) / setter(저장) : private 멈버변수를 다른 클래스로 부터 간접 접근 제공함수
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

} // class end
