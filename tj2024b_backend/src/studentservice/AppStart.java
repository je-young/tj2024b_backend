package studentservice;

// 필요한 클래스 임포트
import studentservice.controller.StudentController;
import studentservice.model.dao.StudentDao;
import studentservice.view.StudentView;

public class AppStart {
  public static void main(String[] args) {

    // 1. Model 객체 생성
    // StudentDao 객체를 생성하여 데이터베이스와 상호작용하는 모델을 초기화.
    StudentDao studentDao = new StudentDao();

    // 2. View 객체 생성
    // StudentView 객체를 생성하여 사용자 인터페이스를 초기화.
    StudentView studentView = new StudentView();

    // 3. Controller 객체 생성
    // StudentController 객체를 생성하여 모델과 뷰를 연결하고 사용자 입력을 처리.
    StudentController studentController = new StudentController(studentDao, studentView);

    // 4. 프로그램 실행
    // run() 메서드를 호출하여 프로그램 실행.
    studentController.run();
  } // main end

} // class end
