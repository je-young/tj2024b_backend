package day17_인스턴스.step3;

// Car 클래스 : Tire 인터페이스 타입의 멤버변수 tire를 갖는 클래스
class Car {
  Tire tire; // Tire 인터페이스 타입의 멤버변수 tire 선언

  // run 메소드 : tire의 roll 메소드 호출
  public void run() {
    this.tire.roll();
  } // run 메소드 end
} // Car 클래스 end

// Tire 인터페이스 : roll 추상메소드를 갖는 인터페이스
interface Tire {
  void roll();
}

// HankookTire 클래스 : Tire 인터페이스를 구현한 클래스
class HankookTire implements Tire {
  @Override // 오버라이딩 : 상속 또는 구현 했을때 메소드를 재정의 // 생략가능
  public void roll() {
    System.out.println("한국 타이어가 회전합니다.");
  }
}

// KumhoTire 클래스 : Tire 인터페이스를 구현한 클래스
class KumhoTire implements Tire {
  @Override
  public void roll() {
    System.out.println("금호 타이어가 회전합니다.");
  }
}

// Example3 클래스 : main 메소드를 갖는 실행 클래스
public class Example3 { // class start
  public static void main(String[] args) { // main start

    Car myCar = new Car(); // Car 클래스의 객체 생성 // myCar 객체 생성
    // myCar.run(); // NullPointerException
    Car yourCar = new Car(); // Car 클래스의 객체 생성 // yourCar 객체 생성
    // yourCar.tire = new Tire(); // Tire는 인터페이스이므로 객체 생성 불가능
    // yourCar.run(); // NullPointerException

    // myCar.tire = new Tire(); // Tire는 인터페이스이므로 객체 생성 불가능
    // myCar.run(); // NullPointerException

    myCar.tire = new HankookTire(); // HankookTire 객체 생성
    myCar.run(); // 한국 타이어가 회전합니다.

    myCar.tire = new KumhoTire(); // KumhoTire 객체 생성
    myCar.run(); // 금호 타이어가 회전합니다.
    // yourCar.run(); // NullPointerException

    System.out.println(myCar.tire instanceof KumhoTire); // myCar.tire는 KumhoTire 타입이 아님 // false
    if (myCar.tire instanceof Tire) { // 만약에 myCar.tire가 Tire 타입이면 // true
      myCar.tire = new HankookTire(); // HankookTire 객체 생성
    }
    myCar.run(); // 한국 타이어가 회전합니다.

  } // main end

} // class end
