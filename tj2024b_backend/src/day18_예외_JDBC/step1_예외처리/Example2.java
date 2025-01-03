package day18_예외_JDBC.step1_예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 { // class start
  public static void main(String[] args) { // main start

    // [1] 실행 예외 : 프로그램 실생 도중에 발생하는 예외, 예측
    try {
      String str1 = "강호동";
      System.out.println(str1.length()); // 3
      String str2 = null;
      System.out.println(str2.length()); // nullPointerException 예외 발생!
    } catch (NullPointerException e) {
      System.err.println("인스턴스가 존재하지 않습니다." + e);
    } // try-catch end

    // [2] 실행 예외
    // Integer.parseInt("문자열") : String 문자열을 타입을 int 타입 정수로 변환 함수
    try {
      String str3 = "100";
      String str4 = "laa";
      int value1 = Integer.parseInt(str3); // "100" --> 100 OK
      int value2 = Integer.parseInt(str4); // "laa" --> ?? NumberFormatException 예외 발생!
    } catch (NumberFormatException e) {
      System.out.println("int 타입으로 변환할 수 없습니다." + e); // 예외 발생시 출력
    } // try-catch end

    // [3] 실행 예외
    // ArrayIndexOutOfBoundsException : 배열의 인덱스 범위를 벗어난 예외
    try {
      int[] intArray = { 1, 2, 3 }; // 배열 선언
      System.out.println(intArray[0]); // 1 , 0번째 인덱스 값 출력
      System.out.println(intArray[3]); // 3번째 인덱스 값 출력 , ArrayIndexOutOfBoundsException 예외 발생!
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("배열의 인덱스 범위를 벗어났습니다." + e); // 예외 발생시 출력
    } // try-catch end

    // [4] 실행 예외
    try {
      Scanner scan = new Scanner(System.in); // Scanner 객체 생성
      System.out.print("정수 입력 : "); // 출력
      int value3 = scan.nextInt(); // 정수 입력
    } catch (InputMismatchException e) {
      System.out.println("정수를 입력해야 합니다." + e); // 예외 발생시 출력
    } // try-catch end

    // [5] 다중 try ~ catch ~ catch
    try {
      Integer.parseInt("laa"); // NumberFormatException 예외 발생 , 문자열을 정수로 변환할 수 없음

      int[] intArray = { 1, 2, 3 }; // 배열 선언
      System.out.println(intArray[3]); // 3번째 인덱스 값 출력 , ArrayIndexOutOfBoundsException 예외 발생

      String str = null; // null 값으로 초기화
      System.out.println(str.length()); // nullPointerException 예외 발생 , null 값으로 초기화 되어있음
    } catch (NumberFormatException e1) { // NumberFormatException 예외 발생시 실행코드
      System.out.println(e1);
    } catch (ArrayIndexOutOfBoundsException e2) { // ArrayIndexOutOfBoundsException 예외 발생시 실행코드
      System.out.println(e2);
    } catch (NullPointerException e3) { // NullPointerException 예외 발생시 실행코드
      System.out.println(e3);
    } catch (Exception e) { // 예외 발생시 실행코드
      System.out.println(e);
    } finally { // 예외 발생 여부 상관없이 무조건 실행코드
      System.out.println("예외 여부 상관없이 무조건 실행코드"); // 주로 안전하게 메모리 초기화, 연결 종료
    } // try-catch end

  } // main end
} // class end
