package day14.boardprogram9.model.dao;

import java.util.ArrayList;
import day14.boardprogram9.model.dto.BoardDto;

public class BoardDao { // class start

  // + 싱글톤
  private BoardDao() {} 
  public static BoardDao instance = new BoardDao(); 
  public static BoardDao getInstance() {
    return instance;
  } // - 싱글톤

  // + 게시물 리스트 선언
  private ArrayList<BoardDto> boards = new ArrayList<BoardDto>();

  // 1. 게시물 쓰기 처리 함수
  public boolean create(BoardDto boardDto) { // create start
    // [1] 매개변수로 받은 객체를 add() 함수로 리스트에 추가
    boards.add(boardDto);
    // [2] 저장 결과 반환
    return true;
  } // create end

  // 2. 게시물 반환 처리 함수
  public ArrayList<BoardDto> readAll() { // readAll start
    // [1] 모든 게시물 갖는 리스트 객체 반환
    return boards;
  } // readAll end

  // 3. 게시물 수정 처리 함수
  public boolean update(int uIndex, BoardDto boardDto) { // update start
    // [1] 리스트에 존재하지 않는 인덱스 이면 실패
    if (uIndex > boards.size() - 1 || uIndex < 0) {
      // 마지막 인덱스 보다 크거나 음수를 요청하면
      return false; // 수정 실패 반환
    } // if end
    // [2] 지정한 인덱스 새로운 개체 대입 , .set(인덱스 , 새로운 요소) 함수
    boards.set(uIndex, boardDto);
    // [3] 수정 결과 반환
    return true; // 수정 성공 반환
  } // update end

  // 4. 게시물 삭제 처리 함수
  public boolean delete(int dIndex) {
    // [1] 리스트 에서 특정한 인덱스를 .remove() 함수로 삭제
    if (dIndex > boards.size() - 1) { // 존재하지 않는 인덱스를 요청하면
      return false; // 삭제 실패
    } // if end
    boards.remove(dIndex); // 삭제 성공

    // [2] 삭제 결과 반환
    return true; // 삭제 성공
  } // delete end
} // class end