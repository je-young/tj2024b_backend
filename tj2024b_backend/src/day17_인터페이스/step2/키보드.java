package day17_인터페이스.step2;

// 키보드를 인터페이스로 사용하는 이유? 여러 게임(클래스)에서 키보드를 사용할 수 있도록 하기 위해서.
public interface 키보드 {
  // 1. 상수 : 수정 불가능한 변수.
  public static final String 제조사 = "HP";
  String 제조일 = "2025-01-02"; // public static final 생략 가능.

  // 2. 추상메소드 : 메소드의 선언()만 존재하고 구현{}은 없는 메소드.
  public abstract void akey();

  void bkey(); // public abstract 생략 가능.

}
