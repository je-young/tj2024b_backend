package day14.boardprogram9.view;

import java.util.ArrayList;
import java.util.Scanner;
import day14.boardprogram9.controller.BoardController;
import day14.boardprogram9.model.dto.BoardDto;

public class BoardView { // class start

  private BoardView() {} // + 싱글톤
  private static BoardView instance = new BoardView();
  public static BoardView getInstance() {
    return instance;
  } // - 싱글톤

  // + 입력객체( 현재 클래스 내부의 모든 함수들에서 사용하기 위해 멤버변수에 선언)
  private Scanner sc = new Scanner(System.in);

  // 0. 메인 페이지 표현 함수
  public void run() {
    while (true) {
      System.out.print(" 게시물 1.C 2.R 3.U 4.D : ");
      int choose = sc.nextInt();
      if (choose == 1) {
        create();
      } else if (choose == 2) {
        readAll();
      } else if (choose == 3) {
        update();
      } else if (choose == 4) {
        delete();
      } else {
        break;
        
      }
    } // while end
  } // run end

  // 1. 게시물 쓰기 페이지 함수
  public void create() { // create start
    System.out.println("[C]");

    // [1] 저장할 게시물 정보 입력
    System.out.println("title : ");
    String title = sc.next();
    System.out.println("content : ");
    String content = sc.next();
    System.out.println("writer : ");
    String writer = sc.next();

    // [2] 입력받은 정보를 객체로 만들어서 dao로 전달
    BoardDto boardDto = new BoardDto(title, content, writer);

    // [3] dao에서 전달받은 결과를 출력
    boolean result = BoardController.getInstance().create(boardDto);

    // [4] 결과 출력
    if (result) {
      System.out.println("[ save success ]");
    } else {
      System.out.println("[ save fail ]");
    } // if end
  } // create end

  // 2. 게시물 출력 페이지 함수
  public void readAll() { // readAll start
    System.out.println("[R]");

    // [1] 컨트롤러에게 모든 게시물 정보를 요청
    ArrayList<BoardDto> result = BoardController.getInstance().readAll();

    // [2] 요청받은 모든 게시물 정보를 출력
    System.out.println("순번\t작성자\t제목\t내용");
    for (int index = 0; index <= result.size() - 1; index++) {
      BoardDto board = result.get(index);
      System.out.printf("%d \t %s \t %s \t %s \n " , index , board.getWriter() , board.getTitle() , board.getContent());
    } // for end
  } // readAll end

  // 3. 게시물 수정 페이지 함수
  public void update() { // update start
    System.out.println("[U]");

    // [1] 수정할 정보들을 입력받는다.
    System.out.print("update Index : ");
    int uIndex = sc.nextInt();
    System.out.print("update Title : ");
    String title = sc.next();
    System.out.print("update Content : ");
    String content = sc.next();
    System.out.print("update Writer : ");
    String writer = sc.next();

    // [2] 입력받은 정보를 객체로 만들어서 컨트롤러에게 전달
    BoardDto boardDto = new BoardDto(title, content, writer);

    // [3] 컨트롤러에게 수정할 인덱스와 수정할 객체를 전달하고 결과를 받는다.
    boolean result = BoardController.getInstance().update(uIndex, boardDto);

    // [4] 결과에 따른 메시지 출력한다.
    if (result) {
      System.out.println("[ update success ]");
    } else {
      System.out.println("[ update fail ]");
    } // if end
  } // update end

  // 4. 게시물 삭제 페이지 함수
  public void delete() { // delete start
    System.out.println("[D]");

    // [1] 삭제할 인덱스(식별)게시물 번호 입력
    System.out.print("delete index : ");
    int dIndex = sc.nextInt();
    
    // [2] 삭제할 번호를 컨트롤러에게 전달하고 처리결과를 받는다.
    boolean result = BoardController.getInstance().delete(dIndex);

    // [3] 처리 결과 출력
    if (result) {
      System.out.println("[ delete success ]");
    } else {
      System.out.println("[ delete fail ]");
    } // if end
  } // delete end

} // class end
