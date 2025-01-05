package day18_예외_JDBC.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example1 { // class start
  public static void main(String[] args) { // main start

    // 인터페이스 타입
    Connection connection; // DB 서버와 연결을 위한 객체, import java.sql.Connection

    // [1] DB 연동
    // 1. mysql JDBC 클래스 존재하는지 로드 / 불러오기, Class.forName() : 클래스 로드 함수 , 일반 예외 처리
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); // mysql JDBC 클래스 로드
      // "com.mysql.cj.jdbc" : 패키지 경로, "Driver" : 클래스 이름
      // mysql : com.mysql.cj.jdbc.Driver
      // oracle : oracle.jdbc.driver.OracleDriver

      // 2. db 서버와 연동 시도
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0103", "root", "2965");
      // DriverManager : DB 서버와 연동을 위한 클래스, import java.sql
      // --> 연동함수 : .getConnection("jdbc:mysql://DB서버IP:DB서버PORT/DB명",
      // "DB계정명","DB비밀번호");
      // --> 로컬 : .getConnection("jdbc:mysql://localhost:3306/DB명", "root", "2965");
      System.out.println("DB 연동 성공");
    } catch (ClassNotFoundException e) {
      System.out.println("프로젝트내 jdbc 드라이버가 존재하지 않습니다." + e);
    } catch (Exception e) {
      System.out.println("DB 연동 실패" + e);
    } // try end

  } // main end

} // class end
