package studentservice.view;

import studentservice.model.dto.StudentDto;

import java.util.List;
import java.util.Scanner;

// 사용자 입력을 받고, 결과를 출력하는 클래스
public class StudentView {

  // 1. Scanner 객체를 생성
  private Scanner sc = new Scanner(System.in);

  // 2. 메뉴를 출력
  public void showMenu() {
    System.out.println("1. 점수 등록");
    System.out.println("2. 전체 점수 조회");
    System.out.println("3. 점수 삭제");
    System.out.println("4. 점수 수정");
    System.out.println("5. 종료");
  }

  // 3. 학생 정보를 입력받아 반환
  public StudentDto getStudentInfo() {
    System.out.print("학생 이름 : ");
    String name = sc.next();
    System.out.print("국어 점수 : ");
    int koreanScore = sc.nextInt();
    System.out.print("영어 점수 : ");
    int englishScore = sc.nextInt();
    System.out.print("수학 점수 : ");
    int mathScore = sc.nextInt();
    sc.nextLine();
    return new StudentDto(name, koreanScore, englishScore, mathScore);
  } // getStudentInfo end

  // 4. 학생 이름을 입력받아 반환
  public String getStudentName() {
    System.out.print("학생 이름 : ");
    return sc.nextLine();
  } // getStudentName end

  // 5. 수정할 점수를 입력받아 반환
  public int[] getUpdatedScores() {
    System.out.print("국어 점수 : ");
    int koreanScore = sc.nextInt();
    System.out.print("영어 점수 : ");
    int englishScore = sc.nextInt();
    System.out.print("수학 점수 : ");
    int mathScore = sc.nextInt();
    return new int[] { koreanScore, englishScore, mathScore };
  } // getUpdateScores end

  // 6. 모든 학생 정보를 출력
  public void displayAllStudents(List<StudentDto> students) {
    for (StudentDto student : students) {
      System.out.println("이름 : " + student.getName() + ", 국어 : " + student.getKoreanScore() + ", 영어 : "
          + student.getEnglishScore() + ", 수학 : " + student.getMathScore());
    } // for end
  } // displayAllStudents end

  // 7. 메시지를 출력
  public void displayMessage(String message) {
    System.out.println(message);
  } // displayMessage end

  // 8. Scanner 객체를 반환
  public Scanner getScanner() {
    return sc;
  } // getScanner end

} // class end
