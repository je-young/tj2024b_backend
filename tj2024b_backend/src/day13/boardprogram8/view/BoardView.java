package day13.boardprogram8.view;

import java.util.Scanner;

import day13.boardprogram8.controller.BoardController;
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

public class BoardView { // class s

  // + 싱글톤
  private BoardView() {}
  private static BoardView instance = new BoardView();
  public static BoardView getInstance() {
    return instance;
  } // class ene // - 싱글톤 end

  // + 멤버변수( 입력객체 : 모든 메소드에서 사용하기 위해서 )
  private Scanner sc = new Scanner(System.in);

  // 1. 메인페이지 입출력 메소드 [함수명 : 임의]
  public void index() {
    while (true) {
      System.out.println("[메인 페이지] 1.글등록 2.글출력 : ");
      int choose = sc.nextInt();
      if (choose == 1) {
        write();
      }
      else if (choose == 2) {
        findAll();
      }
    } // while end
  } // index end

  // 2. 글쓰기 입출력 메소드 [함수명 : 임의 , 매개변수:x , 리턴값 : x]
  public void write() {
    System.out.println("[글쓰기 페이지]");
    
    // [1] 제목, 내용, 작성자 입력받기
    System.out.print("제목 : ");
    String title = sc.next();
    System.out.print("내용 : ");
    String content = sc.next();
    System.out.print("작성자 : ");
    String writer = sc.next();

    // [2] 객체화 : 입력받은 정보를 dto에 저장
    BoardDto boardDto = new BoardDto(title, content, writer);

    // [3] controller에게 저장할 객체를 전달하고 결과를 받기
    boolean result = BoardController.getInstance().write(boardDto);

    // [4] 결과에 따라 출력
    if (result == true) {
      System.out.println("글쓰기 성공");
    }
    else {
      System.out.println("글쓰기 실패");
    }
  } // write end

  // 3. 모든 글출력 메소드 [함수명 : 임의 매개변수:x , 리턴값 : x]
  public void findAll() {
    System.out.println("[모든글출력 페이지]");

    // [1] controller에게 모든 게시물 정보를 요청하고 응답받기
    BoardDto[] result = BoardController.getInstance().findAll();

    // [2] 결과에 따라 출력
    for (int index = 0; index <= result.length - 1; index++) {
      BoardDto board = result[index];
      if (board != null) {
        System.out.printf("%d , %s , %s , %s \n", index, board.getTitle(), board.getContent(), board.getWriter());
      } // if end
    } // for end

  } // findAll end
    
} // class end