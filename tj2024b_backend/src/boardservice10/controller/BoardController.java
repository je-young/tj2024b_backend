package boardservice10.controller;

import java.util.ArrayList;

import boardservice10.model.dao.BoardDao;
import boardservice10.model.dto.BoardDto;

public class BoardController {

  // + 싱글톤
  private static BoardController instance = new BoardController();

  private BoardController() {
  };

  public static BoardController getInstance() {
    return instance;
  }

  // 1. 전체 게시물 컨트롤러 메소드
  public ArrayList<BoardDto> findAll() {
    ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
    return result;
  }

  // 2. 개별 게시물 컨트롤러 메소드
  public BoardDto findById(int bno) {
    BoardDto boardDto = BoardDao.getInstance().findById(bno);
    return boardDto;
  }

  // 3. 게시물 작성 컨트롤러 메소드
  public boolean write(BoardDto boardDto) {
    // 현재 로그인 회원의 번호 넣어주기.
    int loginMno = MemberController.getInstance().getLoginMno();
    boardDto.setMno(loginMno); // Dto에 넣어주기
    return BoardDao.getInstance().write(boardDto);
  }

  // 4. 게시물 전체 조회 컨트롤러 메소드
  public ArrayList<BoardDto> categoryAll() {
    return BoardDao.getInstance().categoryAll();
  }

  // 5. 게시물 수정 컨트롤러 메소드
  public boolean update(BoardDto boardDto) {
    return BoardDao.getInstance().update(boardDto);
  }

  // 6.게시물 삭제 컨트롤러 메소드
  public boolean delete(int dIndex) {
    return BoardDao.getInstance().delete(dIndex);
  }

} // class end
