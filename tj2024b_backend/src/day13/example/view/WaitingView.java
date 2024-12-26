package day13.example.view;

import java.util.Scanner;

public class WaitingView { // class start

  // + 싱글톤
  private WaitingView() {}
  private static WaitingView instance = new WaitingView();
  public static WaitingView getInstance() {
    return instance;
  } // - 싱글톤 end

  // + 멤버변수( 입력객체 : 모든 메소드에서 사용하기 위해서 )
  private Scanner sc = new Scanner(System.in);

  // 1. 메인페이지 입출력 메소드 [함수명 : 임의]
  public void index() {
    while (true) {
      System.out.println("[메인 페이지] 1.대기등록 2.대기출력 : ");
      int choose = sc.nextInt();
      if (choose == 1) {

      }
      else if (choose == 2) {
      }
    } // while end
  }

} // class end
