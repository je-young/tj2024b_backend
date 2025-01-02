package day17_인스턴스.step4;

public class Example4 {
  public static void main(String[] args) {

    // [1] customer 인스턴스(객체) 생성
    Customer customer = new Customer();
    // 하위 타입이 생성될때 상위 타입도 같이 참조한다.
    // Customer ---> Buy, Sell

    // [2] customer 인스턴스(객체)가 Buy 타입 형 변환
    Buy buyer = customer;
    buyer.buy(); // 구매하기

    // [3] customer 인스턴스(객체)가 Sell 타입 형 변환
    Sell seller = customer;
    seller.sell(); // 판매하기

    // [4] 변수명 instanceof 타입 : 변수가 참조하는 인스턴스의 타입 조회
    if (seller instanceof Customer) {
      Customer customer2 = (Customer) seller;
      customer2.buy(); // 구매하기
      customer2.sell(); // 판매하기
    } // if end

  } // main end

} // class end
