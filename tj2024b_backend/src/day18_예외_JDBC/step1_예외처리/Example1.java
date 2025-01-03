package day18_예외_JDBC.step1_예외처리;

public class Example1 { // class start
  public static void main(String[] args) { // main start

    // [1] 일반 예외 : 컴파일러 예외처리 검사 , 자동으로 예외처리 하라고 경고가 뜸.
    // Class.forName("패키지경로.클래스명") : 지정한 클래스를 로드
    try {
      // 만약에 예외가 발생하거나 발생할것 같은 코드를 작성
      Class.forName("java.lang.String"); // String 클래스가 존재하므로 예외 발생하지 않음
      Class.forName("java.lang.String2"); // String2 클래스가 존재하지 않으므로 예외 발생
    } catch (ClassNotFoundException e) { // try에서 예외가 발생하거나 할것 같은 예외클래스명 변수명
      e.printStackTrace(); // // 예외클래스명 변수명.printStackTrace() : 예외 발생시 출력
      System.out.println(e); // 만일 try에서 지정한 예외클래스가 발생하면 실행코드
    } // try-catch end

    // [2] 일반 예외
    // system.in.read(); : 시스템 으로 부터 읽기 함수 , IOException 예외 발생
    try {
      System.in.read(); // 예외 발생
    } catch (Exception e) { // try에서 예외가 발생하거나 할것 같은 예외클래스명 변수명
      System.out.println(e); // 예외 발생시 출력 , 예외클래스명 변수명
    } // try-catch end

  } // main end
} // class end
