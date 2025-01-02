package day17_인스턴스.step5;

interface InterfaceTest2 {
  // 인터페이스의 구성멤버
  // 1. 상수 : 수정이 불가능한 변수
  public static final int value = 10;

  // 2. 추상메소드 : 메소드의 선언부( 접근제한자 반환타입 메소드명 매개변수 )만 있고 구현부는 없는 메소드
  public abstract void method(); // { } // 추상메소드는 구현부가 없다.
  // + 추가된 메소드

  // 3. default 메소드 : 인터페이스의 구현부가 있는 메소드
  public default void Method2() {
  } // 인터페이스에 구현한 메소드를 만들 수 있다.

  // 4. static 메소드 : 인터페이스의 구현부가 있는 메소드
  public static void Method3() {
  } // 인터페이스에 구현한 메소드를 만들 수 있다.

  // 5. private 메소드 : 인터페이스의 구현부가 있는 메소드
  private void Method4() {
  } // 인터페이스에 구현한 메소드를 만들 수 있다.

  // 6. private static 메소드 : 인터페이스의 구현부가 있는 메소드
  private static void Method5() {
  } // 인터페이스에 구현한 메소드를 만들 수 있다.

  // + : 인터페이스는 클래스와 다르게 생성자가 없다. 즉] 인터페이스는 new 인터페이스명(); , 인터페이스는 인스턴스를 만들 수 없다.
  // - 생성자란? 클래스의 구성 멤버이자. 클래스로 인스턴스를 만들떼 인스턴스의 초기화 하는 메소드/역할
  // + : static 이란? 프로그램이 시작될때 메모리 할당 되고 프로그램이 종료할때 메모리 초기화. [ 상수 / 전역(공유) ]
  // - static 있는 변수 또는 메소드는 인스턴스가 없어도 사용이 가능하다.

} // interface end

public class Example5 {
  public static void main(String[] args) {

    // [1] 인터페이스의 상수 호출 , O
    System.out.println(InterfaceTest2.value); // 10

    // [2] 인터페이스의 추상메소드 호출, X
    // InterfaceTest2.method(); // 오류

    // [3] 인터페이스의 default 메소드 호출, X
    // InterfaceTest2.Method2(); // 오류

    // [4] 인터페이스의 static 정적 메소드 호출, O
    InterfaceTest2.Method3();

    // [*] 인터페이스 타입은 new 할수없다. 즉] 인스턴스 생성 불가능
    // InterfaceTest2 inter = new InterfaceTest2(); // 오류

  } // main end
} // class end
