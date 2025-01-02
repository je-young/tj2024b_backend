package day17_인터페이스.step1;

class Tool1 implements InterfaceTest { // class start
  // [1] 클래스가 인터페이스의 추상메소드를 구현하기
  // - class 클래스명 implements 인터페이스명 { }
  // - 인터페이스의 모든 추상메소드를 구현하기 전까지 오류메세지. 발생
  // [2] 추상메소드 구현하기.
  // 1. 선언부 동일하게 작성해야 한다. 반환타입명 메소드명 (타입 매개변수)
  // 2. 오버라이딩 : 상속 또는 구현 했을때 메소드를 재정의
  public int method2(int a) { // method2 start
    System.out.println("tool1 클래스 구현한 method2");
    return a;
  } // method2 end

  @Override // 오버라이딩 : 상속 또는 구현 했을때 메소드를 재정의 // 생략가능
  public int method3(int a) { // method3 start
    System.out.println("tool1 클래스 구현한 method3");
    return a;
  } // method3 end
} // class end

class Tool2 implements InterfaceTest { // class start

  // 추상메소드 구현하기. 자동완성 : 빈공간에 컨트롤 + 스페이스
  @Override // 오버라이딩 : 상속 또는 구현 했을때 메소드를 재정의 // 생략가능
  public int method2(int a) { // method2 start
    System.out.println("tool2 클래스 구현한 method2");
    return a;
  } // method2 end

  @Override // 오버라이딩 : 상속 또는 구현 했을때 메소드를 재정의 // 생략가능
  public int method3(int a) { // method3 start
    System.out.println("tool2 클래스 구현한 method3");
    return a;
  } // method3 end
} // class end

public class Example1 { // class start
  public static void main(String[] args) { // main start

    // 1. 인테페이스의 상수 사용
    // 인터페이스명
    System.out.println(InterfaceTest.value2); // 10
    System.out.println(InterfaceTest.value3); // 20

    // 2. 인터페이스의 추상메소드 사용
    // 추상메소드란? 메소드의 선언만 있고 구현 { } 이 없는 메소드 이므로 호출이 불가능하다.
    // InterfaceTest.method2(); // 오류

    // !!! : 추상메소드를 (클래스들이) 구체적으로 구현하기.
    // 인터페이스는 하나의 타입이고 추상메소드는 클래스가 구현한다.
    // 인테페이스타입은 추상메소드를 구현한 클래스의 인스턴스를 참조할 수 있다.
    Tool1 tool1 = new Tool1(); // Tool1 클래스의 객체 생성
    tool1.method2(10); // tool1.method2(10) 호출
    tool1.method3(20); // tool1.method3(20) 호출

    InterfaceTest inter1 = new Tool1();
    inter1.method2(10); // inter1.method2(10) 호출
    inter1.method3(20); // inter1.method3(20) 호출

    InterfaceTest inter2 = new Tool2();
    inter2.method2(10); // inter2.method2(10) 호출
    inter2.method3(20); // inter2.method3(20) 호출

  } // main end
} // class end
