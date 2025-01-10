package studentservice.model.dao;

import studentservice.model.dto.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 학생 데이터를 관리하는 클래스
public class StudentDao {

  // 1. 데이터베이스 연결 정보 설정
  private static final String DB_URL = "jdbc:mysql://localhost:3306/student_management";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "2965";

  // 2. 학생 점수를 데이터 베이스에 추가
  public void addStudent(StudentDto student) {

    String sql = "INSERT INTO students (name, korean_score, english_score, math_score) VALUES (?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, student.getName());
      pstmt.setInt(2, student.getKoreanScore());
      pstmt.setInt(3, student.getEnglishScore());
      pstmt.setInt(4, student.getMathScore());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } // try-catch end
  } // addStudent() end

  // 3. 모든 학생 정보를 데이터베이스에서 조회
  public List<StudentDto> getAllStudents() {
    List<StudentDto> students = new ArrayList<>();
    String sql = "SELECT * FROM students";
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        StudentDto student = new StudentDto(
            rs.getString("name"),
            rs.getInt("korean_score"),
            rs.getInt("english_score"),
            rs.getInt("math_score"));
        students.add(student);
      } // while end
    } catch (SQLException e) {
      e.printStackTrace();
    } // try-catch end
    return students;
  } // getAllStudents() end

  // 4. 학생 이름으로 데이터베이스에서 점수를 삭제
  public void deleteStudent(String name) {
    String sql = "DELETE FROM students WHERE name = ?";
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, name);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } // try-catch end
  } // deleteStudent() end

  // 5. 학생 이름으로 데이터베이스에서 점수를 수정
  public void updateStudent(String name, int koreanScore, int englishScore, int mathScore) {
    String sql = "UPDATE students SET korean_score = ?, english_score = ?, math_score = ? WHERE name = ?";
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, koreanScore);
      pstmt.setInt(2, englishScore);
      pstmt.setInt(3, mathScore);
      pstmt.setString(4, name);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } // try-catch end
  } // updateStudent() end
} // class end
