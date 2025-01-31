package day13_BoardProgram8_싱글톤_MVC패턴_DB생성과삭제.boardprogram8;

import day13_BoardProgram8_싱글톤_MVC패턴_DB생성과삭제.boardprogram8.view.BoardView;

/*
  프로그램 실행 로직
  1. AppStart 클래스의 main 메소드 호출
  2. BoardView 클래스의 index 메소드 호출
  3. index 메소드에서 1 또는 2를 입력받아 write 또는 findAll 메소드 호출
  4. write 메소드에서 제목, 내용, 작성자를 입력받아 BoardDto 객체 생성
  5. BoardController 클래스의 write 메소드 호출
  6. BoardDao 클래스의 write 메소드 호출
  7. BoardDao 클래스의 boardDB 배열에 BoardDto 객체 저장
  8. BoardDao 클래스의 write 메소드에서 true 또는 false 반환
  9. BoardController 클래스의 write 메소드에서 true 또는 false 반환
  10. BoardView 클래스의 write 메소드에서 true 또는 false에 따라 출력
  11. findAll 메소드에서 BoardController 클래스의 findAll 메소드 호출
  12. BoardDao 클래스의 findAll 메소드 호출
  13. BoardDao 클래스의 boardDB 배열 반환
  14. BoardController 클래스의 findAll 메소드에서 boardDB 배열 반환
  15. BoardView 클래스의 findAll 메소드에서 boardDB 배열 출력
  16. 3으로 돌아가 반복

  graph TD
    A[AppStart] -->|main 메소드 호출| B[BoardView]
    B -->|index 메소드 호출| C{메뉴 선택}
    C -->|1. 글등록| D[write 메소드 호출]
    C -->|2. 글출력| E[findAll 메소드 호출]
    D -->|게시물 정보 입력| F[BoardDto 객체 생성]
    D -->|BoardDto 객체 전달| G[BoardController]
    G -->|write 메소드 호출| H[BoardDao]
    H -->|게시물 저장| I[boardDB 배열]
    E -->|모든 게시물 요청| G
    G -->|findAll 메소드 호출| H
    H -->|모든 게시물 반환| J[BoardDto 배열]
    E -->|게시물 출력| J
 */

public class AppStart { // class s

  public static void main(String[] args) {

    // + 싱글톤의 메소드 호출
    BoardView.getInstance().index();
    // new BoardView().index();

  } // main end

} // class ene
