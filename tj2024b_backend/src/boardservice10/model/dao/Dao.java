package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

  protected Connection conn; // DB와 연동 결과를 조작하는 인터페이스

  private String dburl = "jdbc:mysql://localhost:3306/boardservice10"; // DB 서버와 연동하는 URL
  private String dbuser = "root"; // DB 계정명
  private String dbpwd = "2965"; // DB 비밀번호

  public Dao() {
    try {
      // 1. JDBC 클래스 드라이버 로드 , Class.forName() * 예외처리 try{}catch{}
      Class.forName("com.mysql.cj.jdbc.Driver");
      // 2. 설정한 경로 / 계정 / 비밀번호 로 DB 서버 연동 시도 하고 결과를 ( 구현체 )-return
      conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
    } catch (Exception e) {
      System.out.println("[DB 연동 실패] : " + e);
    } // try end
  } // constructor end
} // class end
