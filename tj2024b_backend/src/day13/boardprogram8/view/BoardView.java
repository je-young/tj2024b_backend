package day13.boardprogram8.view;

import java.util.Scanner;

import day13.boardprogram8.controller.BoardController;
import day13.boardprogram8.model.dto.BoardDto;

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