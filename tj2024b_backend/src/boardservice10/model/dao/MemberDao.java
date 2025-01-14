package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boardservice10.model.dto.MemberDto;

public class MemberDao {

  private Connection conn; // DB 연동 결과를 조작하는 인터페이스
  private String dburl = "jdbc:mysql://localhost:3306/boardservice10"; // 연동할 DB 서버의 URL
  private String dbuser = "root"; // 연동할 DB 서버의 계정명
  private String dbpwd = "2965"; // 연동할 DB 서버의 패스워드

  // + 싱글톤
  private static MemberDao instance = new MemberDao();

  private MemberDao() {
    try {
      // 1. JDBC 클래스 드라이버 로드 , Class.forName() * 예외처리 try{}catch{}
      Class.forName("com.mysql.cj.jdbc.Driver");
      // 2. 설정한 경로 / 계정 / 비밀번호 로 DB 서버 연동 시도 하고 결과를 ( 구현체 ) 반환
      conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
    } catch (Exception e) {
      System.out.println("[DB 연동 실패] : " + e);
    } // try end
  } // class end

  public static MemberDao getInstance() {
    return instance;
  }

  // 1. 회원가입 SQL 처리 메소드
  public boolean signup(MemberDto memberDto) {

    try {
      // [1] SQL 작성한다.
      String sql = "insert into member (mid, mpwd, mname, mphone) values('" + memberDto.getMid() + "', '"
          + memberDto.getMpwd() + "', '" + memberDto.getMname() + "', '" + memberDto.getMphone() + "')";
      // [2] DB와 연동된 곳에 SQL 기재한다. - 연동된 DB에 SQL 기재하는 방법 : conn.prepareStatement(sql);
      PreparedStatement ps = conn.prepareStatement(sql);
      // [3] 기재된 SQL문을 실행하고 결과를 받는다. - 기재된 sql을 실행하는 방법
      int count = ps.executeUpdate();
      // [4] 결과에 따른 처리 및 반활을 한다.
      if (count == 1) {
        return true;
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return false;
  } // signup() end

  // 2. 로그인 SQL 처리 메소드
  public int login(MemberDto memberDto) {
    // int : SQL 로 조회된 회원번호를 반환하기 위해서
    try {
      // [1] SQL 작성하기
      String sql = "select mno from member where mid = ? and mpwd = ?";
      // [2] DB와 연동된 곳에 SQL 기재하기
      PreparedStatement ps = conn.prepareStatement(sql);
      // [*] 기재된 SQL에 매개변수 값 대입한다.
      ps.setString(1, memberDto.getMid());
      ps.setString(2, memberDto.getMpwd());
      // [3] 기재된 SQL을 실행하고 결과를 받는다
      ResultSet rs = ps.executeQuery();
      // [4] 결과에 따른 처리 및 반활을 한다
      if (rs.next()) {
        int mno = rs.getInt("mno");
        return mno;
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return 0;
  }

  // 3. 아이디찾기 SQL 처리 메소드
  public String findId(MemberDto memberDto) {
    try {
      // [1] SQL 작성한다. // mname = '유재석' ---> mname 은 어떤 값이 들어갈지 정해져 있지 않다. 매개(중매)변수
      String sql = "select mid from member where mname = ? and mphone = ? ";

      // [2] DB 와 연동된 곳에 SQL 기재한다.
      PreparedStatement ps = conn.prepareStatement(sql);
      // ps.setString(1, "유재석"); // ps.setString() : mname 이 String 타입이라서.
      ps.setString(1, memberDto.getMname());
      ps.setString(2, memberDto.getMphone());

      // [3] 기재된 SQL을 실행하고 결과를 받는다.
      ResultSet rs = ps.executeQuery();

      // [4] 결과에 따른 처리 및 반활을 한다.
      if (rs.next()) { // .next() 다음레코드 이동.
        String findMid = rs.getString("mid");
        return findMid; // 찾았다. 찾은 아이디 반환
      } // if end
    } catch (SQLException e) {
      System.out.println(e);
    }
    return null; // 못 찾았다. null 반환
  } // finId end

  // 4. 비밀번호찾기 SQL 처리 메소드
  public String findPwd(MemberDto memberDto) {
    try {
      String sql = "select * from member where mid = ? and mphone = ? ";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, memberDto.getMid());
      ps.setString(2, memberDto.getMphone());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        String findMid = rs.getString("mpwd");
        return findMid;
      } // if end
    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  } // findPwd end

  // 5. 로그아웃 SQL 처리 메소드
  public boolean logout() {
    try {
      // [1] SQL 작성하기
      String sql = "delete from member where mid = 'qwe123' and mphone = '010-3333-3333' ";
      // [2] DB와 연동된 곳에 SQL 기재하기
      PreparedStatement ps = conn.prepareStatement(sql);
      // [3] 기재된 SQL을 실행하고 결과를 받는다
      int count = ps.executeUpdate();
      // [4] 결과에 따른 처리 및 반활을 한다
      if (count == 1) {
        return true;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return false;
  } // logout end

  // 6. 내정보 보기 SQL 처리 메소드
  public MemberDto myInfo(int loginMno) {
    try {
      // [1] SQL 작성하기
      String sql = "select * from member where mno = ?";
      // [2] DB와 연동된 곳에 SQL 기재하기
      PreparedStatement ps = conn.prepareStatement(sql);
      // [*] 기재된 SQL에 매개변수 값 대입하여.
      ps.setInt(1, loginMno);
      // [3] 기재된 SQL을 실행하고 결과를 받는다
      ResultSet rs = ps.executeQuery();
      // [4] 결과에 따른 처리 및 반활을 한다
      if (rs.next()) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMid(rs.getString("mid"));
        memberDto.setMname(rs.getString("mname"));
        memberDto.setMphone(rs.getString("mphone"));
        memberDto.setMdate(rs.getString("mdate"));
        return memberDto; // 조회된 회원정보를 반환한다.
      } // if end
    } catch (SQLException e) {
      System.out.println(e);
    } // try-catch end
    return null; // 회원정보가 없을때 null-return
  } // myInfo end

  // 7. 회원탈퇴 SQL 처리 메소드
  public void delete(int loginMno) {
    try {
      String sql = "delete from member where mno = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, loginMno);
      int count = ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    } // try-catch end
  } // delete end

  // 8. 회원 수정 SQL 처리 메소드
  public boolean update(MemberDto memberDto) {
    try {
      // [1] SQL 작성하기
      String sql = "update member set mpwd = ?, mname = ?, mphone = ? where mno = ?";
      // [2] DB와 연동된 곳(conn)에 SQL 기재하기
      PreparedStatement ps = conn.prepareStatement(sql);
      // [*] 기재된 SQL에 매개변수 값 대입하기
      ps.setString(1, memberDto.getMpwd());
      ps.setString(2, memberDto.getMname());
      ps.setString(3, memberDto.getMphone());
      ps.setInt(4, memberDto.getMno());
      // [3] 기재된 SQL을 실행하고 결과를 받는다
      int count = ps.executeUpdate();
      // [4] 결과에 따른 처리 및 반활을 한다
      if (count == 1) {
        return true; // 수정 성공 했을때
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return false; // 수정 실패 했을때
  } // update end

  // 9. 특정한 속성의 중복값 검색
  // [1] 아이디 중복 검사
  public boolean check(String field, String value) {
    // StringBuilder builder = new StringBuilder();
    // builder.append("select * from member where ");
    // builder.append(field);
    // builder.append(" = ");
    // builder.append("'" + value + "'");
    // System.out.println(builder.toString());

    try {
      String sql = "select * from member where ? = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, field);
      ps.setString(2, value);
      ResultSet rs = ps.executeQuery();
      int count = ps.executeUpdate();
      if (count == 1) {
        return true;
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return false;
  }

  // [2]
} // class end
