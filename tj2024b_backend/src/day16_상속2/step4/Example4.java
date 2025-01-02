package day16_상속2.step4;

// 자동차 상위 클래스
class Car {
  Tire tire; // 멤버변수

  public void run() {
    this.tire.roll();
  }
}

// 타이어 상위 클래스
class Tire {
  public void roll() {
    System.out.println("일반 타이어가 회전합니다."); // 메소드
  }
}

// 타이어 하위 클래스
class HankookTire extends Tire {
  @Override // 오버라이딩 : 상위 클래스의 메소드를 재정의
  public void roll() {
    System.out.println("한국 타이어가 회전합니다."); // 메소드 재정의
  }
}

// 타이어 하위 클래스
class KumhoTire extends Tire {
  @Override // 오버라이딩 : 상위 클래스의 메소드를 재정의
  public void roll() {
    System.out.println("금호 타이어가 회전합니다."); // 메소드 재정의
  }
}

// 실행 클래스
public class Example4 { // class start
  public static void main(String[] args) { // main start
    Car myCar = new Car(); // 내차 객체 생성
    // myCar.run();
    Car yourCar = new Car(); // 너의 차 객체 생성
    yourCar.tire = new Tire(); // 너의 차 일반타이어 객체 생성
    yourCar.run(); // 일반 타이어가 회전합니다.

    myCar.tire = new Tire(); // 내차 타이어 일반타이어로 객체 생성
    myCar.run(); // 일반 타이어가 회전합니다.

    myCar.tire = new HankookTire(); // 내차 타이어 한국타이어로 객체 생성
    myCar.run(); // 한국 타이어가 회전합니다.

    myCar.tire = new KumhoTire(); // 내차 타이어 금로타이어로 객체 생성
    myCar.run(); // 금호 타이어가 회전합니다.
    yourCar.run(); // 일반 타이어가 회전합니다.

    System.out.println(myCar.tire instanceof KumhoTire); // 내차에 금호타이어가 끼워져 있니? // true
    if (myCar.tire instanceof Tire) { // 내차 타이어가 일반타이어인지 확인
      myCar.tire = new HankookTire(); // 내차 타이어를 한국타이어로 교체
    }
    myCar.run(); // 한국 타이어가 회전합니다.
  } // main end
} // class end