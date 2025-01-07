# 프로젝트 : boardservice10 DML과 샘플 INSERT

# 1. DB 구성한다.
DROP DATABASE IF EXISTS boardservice10;
CREATE DATABASE boardservice10;
USE boardservice10;
# 2. 테이블 생성 , PK 테이블 먼저 생성 한다. 적절하게 타입 과 제약조건을 고려한다.

# [1] 회원테이블 생성
CREATE TABLE member(
  mno INT UNSIGNED AUTO_INCREMENT,
  mid VARCHAR(30) NOT NULL UNIQUE,
  mpwd VARCHAR(30) NOT NULL,
  mname VARCHAR(20) NOT NULL,
  mphone VARCHAR(13) NOT NULL,
  mdate DATETIME DEFAULT NOW(),
  CONSTRAINT PRIMARY KEY( mno )
); -- table end

# [1] 회원테이블 샘플 레코드 삽입
INSERT INTO member ( mid , mpwd , mname , mphone ) VALUES( 'qwe123' , 'a123456' , '유재석' ,  '010-3333-3333' );
INSERT INTO member ( mid , mpwd , mname , mphone ) VALUES( 'asd123' , 'b123456' , '강호동' ,  '010-4444-4444' );
INSERT INTO member ( mid , mpwd , mname , mphone ) VALUES( 'zxc123' , 'c123456' , '신동엽' ,  '010-5555-5555' );
INSERT INTO member ( mid , mpwd , mname , mphone ) VALUES( 'vbn123' , 'd123456' , '서장훈' ,  '010-6666-6666' );
INSERT INTO member ( mid , mpwd , mname , mphone ) VALUES( 'rty123' , 'e123456' , '하하'   ,  '010-7777-7777' );

# [2] 카테고리 테이블 생성
CREATE TABLE category(
  cno INT UNSIGNED AUTO_INCREMENT,
  cname VARCHAR(10) NOT NULL, 
  cdate DATETIME DEFAULT NOW(), 
  CONSTRAINT PRIMARY KEY( cno )
); -- table end

# [2] 카테고리 샘플 레코드 삽입
INSERT INTO category( cname ) VALUES( '자유' );
INSERT INTO category( cname ) VALUES( '질문' );
INSERT INTO category( cname ) VALUES( '노하우' );
INSERT INTO category( cname ) VALUES( '공부' );
INSERT INTO category( cname ) VALUES( '친목' );

# [3] 게시물 테이블 생성
CREATE TABLE board(
  bno INT UNSIGNED AUTO_INCREMENT,
  btitle VARCHAR(100) NOT NULL,
  bcontent LONGTEXT,
  bview INT UNSIGNED DEFAULT 0,
  bdate DATETIME DEFAULT NOW(),
  mno INT UNSIGNED,
  cno INT UNSIGNED,
  CONSTRAINT PRIMARY KEY( bno ),
  # FK 제약조건 옵션 , on update/delete
    # on update / delete [옵션]
    # 1. restrict (기본값)       : FK 가 PK 를 참조 중 이면 PK 레코드를 삭제 / 수정 불가능
    # 2. cascade                : PK 값이 삭제 / 수정 되면 FK 같이 삭제 / 수정
    # 3. set null               : PK 값이 삭제 / 수정 되면 FK는 참조 없애고 null 변경
  -- 만약에 특정 회원이 회원탈퇴(PK 레코드) 삭제되면 그를 참조하는 게시물(FK 레코드)도 같이 삭제 / 수정 한다.
  CONSTRAINT FOREIGN KEY( mno ) REFERENCES member( mno ) ON UPDATE CASCADE ON DELETE CASCADE,
  -- 만약에 특정 카테고리가 삭제되면 그를 참조하고 있는 게시물도 같이 삭제 / 수정한다.
  CONSTRAINT FOREIGN KEY( cno ) REFERENCES category( cno ) ON UPDATE CASCADE ON DELETE CASCADE
); -- table end

# [3] 카테고리 샘플 레코드 삽입
INSERT INTO board( btitle , bcontent , mno , cno ) VALUES( '안녕하세요1', '힘찬 자바1', 1, 1 );
INSERT INTO board( btitle , bcontent , mno , cno ) VALUES( '안녕하세요2', '힘찬 자바2', 2, 2 );
INSERT INTO board( btitle , bcontent , mno , cno ) VALUES( '안녕하세요3', '힘찬 자바3', 4, 3 );
INSERT INTO board( btitle , bcontent , mno , cno ) VALUES( '안녕하세요4', '힘찬 자바4', 2, 5 );
INSERT INTO board( btitle , bcontent , mno , cno ) VALUES( '안녕하세요5', '힘찬 자바5', 3, 2 );

# [4] 댓글 테이블 생성
CREATE TABLE reply(
  rno INT UNSIGNED AUTO_INCREMENT,
  rcontent TEXT NOT NULL,
  rdate DATETIME DEFAULT NOW(),
  mno INT UNSIGNED NOT NULL,
  bno INT UNSIGNED NOT NULL,
  CONSTRAINT PRIMARY KEY( rno ),
  CONSTRAINT FOREIGN KEY( mno ) REFERENCES member( mno ) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY( bno ) REFERENCES board( bno ) ON UPDATE CASCADE ON DELETE CASCADE
);

# [4] 댓글 테이블 샘플 레코드 삽입
INSERT INTO reply( rcontent, mno, bno) VALUES('하하하 댓글1', 3, 3);
INSERT INTO reply( rcontent, mno, bno) VALUES('하하하 댓글2', 3, 3);
INSERT INTO reply( rcontent, mno, bno) VALUES('하하하 댓글3', 4, 5);
INSERT INTO reply( rcontent, mno, bno) VALUES('하하하 댓글4', 5, 5);
INSERT INTO reply( rcontent, mno, bno) VALUES('하하하 댓글5', 1, 4);

# [확인] 조회
SELECT * FROM member;
SELECT * FROM category;
SELECT * FROM board;
SELECT * FROM reply;
