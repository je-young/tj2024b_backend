package day13.boardprogram8.controller;

import day13.boardprogram8.model.dao.BoardDao;
import day13.boardprogram8.model.dto.BoardDto;

public class BoardController { // class s
  
  // + 싱글톤
  private BoardController() {}
  private static BoardController instance = new BoardController();
  public static BoardController getInstance() {
    return instance;
  } // class ene // - 싱글톤 end

  // 1. 글쓰기 제어 메소드 [함수명 : 임의 , 매개변수]
  public boolean write(BoardDto BoardDto) {
    boolean result = BoardDao.getInstance().write(BoardDto); // [1] dao에게 게시물 정보를 저장하라고 요청하고 응답받기.
    return result; // [2] 결과를 view에게 응답한다.
  } // write end

  // 2. 모든 글출력 메소드 [함수명 : findAll]
  public BoardDto[] findAll() {
    BoardDto[] result = BoardDao.getInstance().findAll(); // [1] dao에게 모든 게시물 정보를 요청하고 응답받기.
    return result; // [2] 결과를 view에게 응답한다.
  } // findAll end

} // class end
