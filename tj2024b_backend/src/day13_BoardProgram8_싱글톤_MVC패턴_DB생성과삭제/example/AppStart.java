package day13_BoardProgram8_싱글톤_MVC패턴_DB생성과삭제.example;

import day13_BoardProgram8_싱글톤_MVC패턴_DB생성과삭제.example.view.WaitingView;

/*
  자바 과제12 : (식당) 대기번호 발행 프로그램
  - 1. MVC 패턴으로 패키지와 클래스 구성
    - AppStart 클래스
    - WaitingView 클래스
    - waitingController 클래스
    - WaitingDao 클래스
    - WaitingDto 클래스
  
  - 2. 전화번호 와 인원수를 입력받아 대기등록 기능 구축하기.
  - 3. 현재 모든 대기 명단을 출력하는 기능 구축하기.

  제출 : 카카오톡방에 과제 코드가 존재하는 본인 github 주소를 제출해주세요.
*/

public class AppStart { // class start

  public static void main(String[] args) { // main start

    // + 싱글톤의 메소드 호출
    WaitingView.getInstance().index();
    // new WaitingView().index();

  } // main end

} // class ene
