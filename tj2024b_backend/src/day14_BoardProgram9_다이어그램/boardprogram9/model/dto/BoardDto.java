package day14_BoardProgram9_다이어그램.boardprogram9.model.dto;

public class BoardDto { // class start

  // - 싱글톤X : 각 게시물 정보를 저장할 목적 이므로 서로 고유한 객체가 필요하다.
  // 1. 멤버변수
  private String title;
  private String content;
  private String writer;

  // 2. 생성자
  public BoardDto() { // default constructor start
  } // default constructor end

  public BoardDto(String title, String content, String writer) { // constructor start
    this.title = title;
    this.content = content;
    this.writer = writer;
  } // constructor end

  // 3. getter, setter 메소드
  public String getTitle() { // getTitle start
    return this.title;
  } // getTitle end

  public void setTitle(String title) { // setTitle start
    this.title = title;
  } // setTitle end

  public String getContent() { // getContent start
    return this.content;
  } // getContent end

  public void setContent(String content) { // setContent start
    this.content = content;
  } // setContent end

  public String getWriter() { // getWriter start
    return this.writer;
  } // getWriter end

  public void setWriter(String writer) { // setWriter start
    this.writer = writer;
  } // setWriter end
} // class end
