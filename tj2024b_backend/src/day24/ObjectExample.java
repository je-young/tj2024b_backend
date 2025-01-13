package day24;

class Book {
} // Book end

public class ObjectExample {
  public static void main(String[] args) {
    // object 클래 이용한 객제 / 인스턴스
    Object obj1 = new Object(); // Object 타입
    Object obj2 = 3; // int 타입
    Object obj3 = 3.14; // double 타입
    Object obj4 = "유재석"; // String 타입
    Object obj5 = new int[] { 3, 10, 20 }; // int[] 타입
    Object obj6 = new Book(); // Book 타입

    // ---> Object 가 모든 타입을 참조할 수 있는 이유? Object 는 최상위 클래스(부모)이므로
    // ---> 하위 타입은 상위 타입으로 타입변환이 가능하다.

    // Object 메소드
    // (1) toString() : 인스턴스의 참조(주소) 값(16진수) 반환 함수
    // 주로 오버라이딩(재정의)해서 객체의 설명 변경한다.
    System.out.println(obj6.toString()); // day24.Book@6bf2d08e

    // (2) equals() : 인스턴스의 참조(주소) 값(16진수) 비교 함수
    // == : 스택 메모리 값 비교 , 리터럴 값 비교
    // equals() : 힙 메모리 값 비교 , 참조(주소) 비교
    System.out.println(obj1 == obj2); // false
    Object obj7 = obj6; // obj6와 obj7의 참조(주소)는 동일
    System.out.println(obj6 == obj7); // true
    System.out.println(obj1.equals(obj2)); // false
    System.out.println(obj7.equals(obj6)); // true

    // (3) hashCode() : 인스턴스의 참조(주소) 값(16진수) 해시 함수
    // 인스턴스의 주소 값을 정수로 반환하는 함수 , 주로 객체가 저장된 위치를 검색할 때 사용되는 자료구조
    System.out.println(obj1.hashCode()); // 2121744517(객체의 위치를 정수로 표현)
    System.out.println(obj6.hashCode()); // 1811075214
    System.out.println(obj7.hashCode()); // 1811075214

  } // main end

} // class end
