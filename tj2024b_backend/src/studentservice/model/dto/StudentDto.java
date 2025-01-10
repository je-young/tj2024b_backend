package studentservice.model.dto;

// 학생 정보를 저장하는 DTO 클래스
public class StudentDto {
  // 1. 필드 선언
  private String name; // 학생명
  private int koreanScore; // 국어점수
  private int englishScore; // 영어점수
  private int mathScore; // 수학점수

  // 2. 생성자
  public StudentDto(String name, int koreanScore, int englishScore, int mathScore) {
    this.name = name;
    this.koreanScore = koreanScore;
    this.englishScore = englishScore;
    this.mathScore = mathScore;
  }

  // 3. getter, setter 메소드
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKoreanScore() {
    return koreanScore;
  }

  public void setKoreanScore(int koreanScore) {
    this.koreanScore = koreanScore;
  }

  public int getEnglishScore() {
    return englishScore;
  }

  public void setEnglishScore(int englishScore) {
    this.englishScore = englishScore;
  }

  public int getMathScore() {
    return mathScore;
  }

  public void setMathScore(int mathScore) {
    this.mathScore = mathScore;
  }

  // // 4. toString 메소드
  // @Override
  // public String toString() {
  //   return "StudentDto [name=" + name + ", koreanScore=" + koreanScore + ", englishScore=" + englishScore
  //       + ", mathScore=" + mathScore + "]";
  // }

} // class end
