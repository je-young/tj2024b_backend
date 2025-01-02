package day17_인터페이스.step2;

public class 축구게임 implements 키보드 {
  @Override
  public void akey() {
    System.out.println("[슛팅]");
  }

  @Override
  public void bkey() {
    System.out.println("[패스]");
  }
} // class end
