package day16_상속2.step2;

class 상위클래스 { // class s

  int value1 = 10;
  int value3 = 30;
  int value4 = 400;

  public 상위클래스() { // 생성자 s
    System.out.println("상위클래스 인스턴스 생성");
  } // 생성자 e

  public void showSuperValue() { // method s
    System.out.println("[상위클래스]");
  } // method e

} // class e

class 하위클래스 extends 상위클래스 { // class s

  int value1 = 100;
  int value2 = 200;

  public 하위클래스() { // 생성자 s
    System.out.println("하위클래스 인스턴스 생성");
  } // 생성자 e

  public void showSubValue() { // method s
    System.out.println("[하위클래스]" + (this.value1) + " " + (super.value1)); // 현재 인스턴스의 멤버변수와 상위클래스의 멤버변수 호출
  } // method e

} // class e

public class Example2 { // class s
  public static void main(String[] args) { // main s

    // 1. 상위클래스 인스턴스 생성
    상위클래스 obj1 = new 상위클래스(); // 상위클래스 인스턴스 생성
    System.out.println(obj1.value1); // 본인 인스턴스의 멤버변수 호출 // 단 하위 클래스의 멤버변수 접근 불가능 // 10

    // 2. 하위클래스 인스턴스 생성
    하위클래스 obj2 = new 하위클래스(); // 하위클래스 인스턴스 생성
    System.out.println(obj2.value1); // 만일 상위클래스와 하위클래스의 멤버변수가 같으면 현재 클래스의 멤버변수가 우선순위 // 100
    System.out.println(obj2.value2); // 200
    System.out.println(obj2.value3); // 하위 클래스의 인스턴스는 상위 클래스의 멤버변수 호출 가능 // 30

    // 3. 하위클래스 에서 메소드 호출
    obj2.showSuperValue(); // 현재 인스턴스의 메소드 호출
    obj2.showSubValue(); // 현재 인스턴스가 물려받은 메소드 호출

    // *
    하위클래스 obj3 = new 하위클래스(); // 하위클래스 인스턴스 생성
    obj3.value1 = 300; // 하위클래스의 멤버변수에 값 대입
    obj3.showSubValue(); // [하위클래스]300 10

    // * 생성자
    하위클래스 obj4 = new 하위클래스(); // 생성자 실행 총 횟수 : 3번 // 인스턴스 개수 : 3개
    obj4.value4 = 4000; // 하위클래스의 멤버변수에 값 대입
    obj4.showSubValue(); // [하위클래스]100 10

  } // main e

} // class e
