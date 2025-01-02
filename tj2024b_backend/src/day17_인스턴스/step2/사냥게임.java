package day17_인스턴스.step2;

// 키보드 인터페이스를 사냥게임 클래스가 구현한다.
public class 사냥게임 implements 키보드 { // class start
  // class 클래스명 implements 인터페이스명
  // 키보드 인터페이스의 추상메소드를 구현 , 오버라이딩
  @Override
  public void akey() {
    System.out.println("[공격]");
  }

  @Override
  public void bkey() {
    System.out.println("[방어]");
  }
} // class end
