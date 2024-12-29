package day14_BoardProgram9_다이어그램.boardprogram9.controller;

import java.util.ArrayList;

import day14_BoardProgram9_다이어그램.boardprogram9.model.dao.BoardDao;
import day14_BoardProgram9_다이어그램.boardprogram9.model.dto.BoardDto;

public class BoardController { // class start

  // + 싱글톤
  private BoardController() {
  }

  private static BoardController instance = new BoardController();

  public static BoardController getInstance() {
    return instance;
  } // - 싱글톤

  // 1. 게시물 쓰기 제어 함수
  public boolean create(BoardDto boardDto) { // create start
    // [1] 매개변수로 받은 값들을 DAO에게 전달하여 처리결과를 요청하고 받는다.
    boolean result = BoardDao.getInstance().create(boardDto);
    // [2] 처리 결과를 VIEW 에게 반환한다.
    return result;
  } // create end

  // 2. 게시물 출력 제어 함수
  public ArrayList<BoardDto> readAll() { // readAll start
    // [1] DAO에게 모든 게시물을 요청하고 받는다.
    ArrayList<BoardDto> result = BoardDao.getInstance().readAll();
    // [2] 받은 결과를 VIEW에게 반환한다.
    return result;
  } // readAll end

  // 3. 게시물 수정 제어 함수
  public boolean update(int uIndex, BoardDto boardDto) {
    // [1] 매개변수 받은 값들을 DAO 에게 전달하고 처리 결과를 받는다.
    boolean result = BoardDao.getInstance().update(uIndex, boardDto);

    // [2] 처리 결과를 VIEW 에게 반환한다.
    return result;
  }

  // 4. 게시물 삭제 제어 함수
  public boolean delete(int index) { // delete start
    // [1] DAO에게 삭제할 게시물 번호를 전달하여 처리결과를 요청하고 받는다.
    boolean result = BoardDao.getInstance().delete(index);
    // [2] 처리 결과를 VIEW에게 반환한다.
    return result;
  } // delete end

} // class end
