package day18_예외_JDBC.step2_JDBC;

public class Example2 { // class start
  public static void main(String[] args) { // main start

    // 확인
    Dao.getInstance();

    // [insert 확인]
    Dao.getInstance().insert();

    // [select 확인]
    Dao.getInstance().select();

    // [update 확인] : uno = 2 인 uname = "강호동"
    Dao.getInstance().update();

    // [delete 확인] : uno = 1 인 레코드 삭제
    Dao.getInstance().delete();

  } // main end

} // class end
