package day12_BoardProgram7_this_변수유효범위_static.boardprogram7;

public class BoardDto {

	private String title;
	private String content;
	private String writer;

	public BoardDto() {
	}

	public BoardDto(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public String getWriter() {
		return this.writer;
	}

} // class end
