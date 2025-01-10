package studentservice.controller;

import studentservice.model.dto.StudentDto;
import studentservice.model.dao.StudentDao;
import studentservice.view.StudentView;

// 사용자 입력을 받아 Model을 업데이트하고, View를 통해 결과를 출력하는 클래스
public class StudentController {

  // 1. 필드 선언
  private StudentDao studentDao;
  private StudentView studentView;

  // 2. 생성자
  public StudentController(StudentDao studentDao, StudentView studentView) {
    this.studentDao = studentDao;
    this.studentView = studentView;
  } // constructor end

  // 3. 사용자 입력을 처리
  public void run() {
    while (true) {
      studentView.showMenu();
      int choice = studentView.getScanner().nextInt();
      studentView.getScanner().nextLine();

      switch (choice) {
        case 1:
          registerStudent();
          break;
        case 2:
          viewAllStudents();
          break;
        case 3:
          deleteStudent();
          break;
        case 4:
          updateStudent();
          break;
        case 5:
          return;
        default:
          System.out.println("잘못된 선택입니다. 다시 시도하세요.");
      } // switch end
    } // while end
  } // run end

  // 4. 학생 점수를 등록
  public void registerStudent() {
    StudentDto student = studentView.getStudentInfo();
    studentDao.addStudent(student);
    System.out.println("학생 점수가 등록되었습니다.");
  } // registerStudent end

  // 5. 모든 학생 점수를 조회
  private void viewAllStudents() {
    studentView.displayAllStudents(studentDao.getAllStudents());
  } // viewAllStudents end

  // 6. 학생 점수를 삭제
  private void deleteStudent() {
    String name = studentView.getStudentName();
    studentDao.deleteStudent(name);
    System.out.println("학생 점수가 삭제되었습니다.");
  } // deleteStudent end

  // 7. 학생 점수를 수정
  private void updateStudent() {
    String name = studentView.getStudentName();
    int[] scores = studentView.getUpdatedScores();
    studentDao.updateStudent(name, scores[0], scores[1], scores[2]);
    System.out.println("학생 점수가 수정되었습니다.");
  } // updateStudent end

} // class
