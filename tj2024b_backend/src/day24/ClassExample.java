package day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 우리가 코드를 작성하는 파일은 .java 라는 확장자 파일이다.
// - .java파일 실행(컴파일/번역) 하면 .class 파일생성된다.
// .java (src) -> .class (bin)
public class ClassExample {
  public static void main(String[] args) {

    // 해당 타입들의 클래스 정보를 JVM 으로 가져오는 방법.
    // [1] .getClass() 메소드 / Class 변수명 = (인스턴스).getClass() : 인스턴스의 class 정보 반환 함수
    String s = new String();
    Class c = s.getClass();
    System.out.println(c); // class java.lang.String

    Integer i = 3;
    Class c1 = i.getClass();
    System.out.println(c1); // class java.lang.Integer

    // [2] .Class / Class 변수명 = 타입.class : 타입의 class 정보 반환 함수
    Class c2 = String.class;
    System.out.println(c2); // class java.lang.String

    // [3] Class.forName("패키지경로.클래스명") : 지정한 클래스 정보를 가져오는 함수
    // 주로 : 외부 라이브러리(MYSQL Driver)클래스 가져올때 사용된다. / 일반예외 발생 하므로 예외처리 필수이다.
    try {
      Class c3 = Class.forName("java.lang.String");
      System.out.println(c3); // class java.lang.String
    } catch (ClassNotFoundException e) {
      System.out.println(e); // java.lang.ClassNotFoundException
    } // try-catch end

    // [-]
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    } // try-catch end

    // 클래스 정보 반환(클래스멤버 = 멤버변수/생성자/메소드)를 반환 함수 / c : String클래스/타입
    Field[] fields = c.getFields();
    for (int index = 0; index <= fields.length - 1; index++) {
      System.out.println(fields[index]);
    } // for end

    //
    Constructor[] constructors = c.getConstructors();
    for (int index = 0; index <= constructors.length - 1; index++) {
      System.out.println(constructors[index]);
    } // for end

    //
    Method[] methods = c.getMethods();
    for (int index = 0; index <= methods.length - 1; index++) {
      System.out.println(methods[index]);
    } // for end

  } // main end

} // Class end
