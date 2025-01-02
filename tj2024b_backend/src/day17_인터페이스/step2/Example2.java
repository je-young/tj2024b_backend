package day17_인터페이스.step2;

public class Example2 { // class start
  public static void main(String[] args) { // main start
    // (1) 인터페이스 타입의 변수 생성, 키보드 변수 선언
    키보드 mykeyBoard;
    // (2) 구현체 : 인터페이스의 추상메소드를 구현(한 객)체
    // 1. 사냥게임 해야지...
    // 2. 키보드에 사냥게임 연결
    mykeyBoard = new 사냥게임(); // new 사냥게임() ==> 구현한 인스턴스(객체)
    mykeyBoard.akey(); // [공격]
    mykeyBoard.bkey(); // [방어]
    // 1. 게임 바꿔야지. (타입변환)
    mykeyBoard = new 축구게임(); // new 축구게임() ==> 구현한 인스턴스(객체)
    mykeyBoard.akey(); // [슛팅]
    mykeyBoard.bkey(); // [패스]

    // (3) 생각해보기 : 키보드 타입이 없어도 게임타입으로 실행이 가능하다.
    사냥게임 게임1 = new 사냥게임();
    게임1.akey(); // [공격]
    게임1.bkey(); // [방어]
    // 게임1 = new 축구게임(); // 오류 : 사냥게임 인스턴스는 축구게임의 타입을 모른다.

  } // main end
} // class end
