package day13.boardprogram8.model.dao;

import day13.boardprogram8.model.dto.BoardDto;

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

public class BoardDao {

  // + 싱글톤
  private BoardDao() {}
  private static BoardDao instance = new BoardDao();
  public static BoardDao getInstance() {
    return instance;
  } // class ene // - 싱글톤 end

  // + 멤버변수( 모든 게시물 정보를 갖는 배열, 데이터베이스 역할 )
  private BoardDto[] boardDB = new BoardDto[100];

  // 1. 글쓰기 처리 메소드 , 함수명: 임의 , 매개변수: BoardDto , 리턴: boolean
  public boolean write(BoardDto boardDto) {
    // [1] 매개변수로 받은 저장할 boardDto를 boardDB[배열]에 저장
    for (int index = 0; index <= boardDB.length - 1; index++) {
      if (boardDB[index] == null) {
        boardDB[index] = boardDto;
        return true; // 결과를 controller 응답한다.
      } // if end
    } // for end
    return false; // 결과를 controller 응답한다.
  } // write end

  // 2. 모든 글출력 처리 메소드 , 함수명: 임의 , 매개변수: 없음 , 리턴: BoardDto[]
  public BoardDto[] findAll() {
    // [1] boardDB[배열]에 저장된 모든 객체를 controller 에게 응담한다.
    return boardDB;
  } // findAll end
} // class end