package day13.boardprogram8.model.dao;

import day13.boardprogram8.model.dto.BoardDto;

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