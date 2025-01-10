DROP DATABASE student_management; -- 데이터베이스 제거

# 데이터베이스 생성
CREATE DATABASE student_management; -- 데이터베이스 생성
USE student_management; -- 데이터베이스 사용

# 테이블 설계
CREATE TABLE students ( -- 테이블 생성
  id INT AUTO_INCREMENT PRIMARY KEY, -- id[PK] : 학생의 고유 식별자 (자동증가)
  name VARCHAR(50) NOT NULL, -- name : 학생의 이름
  korean_score INT NOT NULL, -- korean_score : 국어점수
  english_score INT NOT NULL, -- english_score : 영어점수
  math_score INT NOT NULL -- math_score : 수학점수
);

# 데이터 삽입
INSERT INTO students (name, korean_score, english_score, math_score) VALUES ('홍길동', 85, 90, 80), ('김철수', 75, 85, 95), ('이영희', 90, 88, 92);