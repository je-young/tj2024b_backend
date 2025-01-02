# SQL 과제2 : 마켓컬리 홈페이지 DB 설계하기
/*
    조건
		1. 최소 회원기능, 제품기능, 주문기능 가능하도록 테이블 설계하기
        2. 적절한 타입과 제약조건을 사용하기
        3. 테이블 1개당 속성들을 최소 3개 이상 설계한다.
        
	결과물
		1. 엑셀에 샘플 테이블과 데이터
        2. SQL 코드
        3. ERD 다이어그램 캡처
	
    https://docs.google.com/spreadsheets/d/1KdUcGaOcm3QW3OeiwOikTxZRsuWU_idvy2NTlV-IIpY/edit?gid=1214489080#gid=1214489080
*/

CREATE DATABASE market;  -- DB 생성
USE market; -- DB 활성화

# [1] 회원기능
CREATE TABLE joinlist(
    jno INT AUTO_INCREMENT, -- 회원번호
    CONSTRAINT PRIMARY KEY( jno ), -- PK 필드 선정
    jid VARCHAR(30) NOT NULL UNIQUE, -- 회원아이디
    jpwd VARCHAR(30) NOT NULL, -- 회원비밀번호
    jname VARCHAR(10) NOT NULL, -- 회원이름
    jphone VARCHAR(13) NOT NULL, -- 회원전화번호
    jaddress VARCHAR(100) NOT NULL -- 회원주소
);

# [2] 주소기능
CREATE TABLE ADDRESS(
    ano INT AUTO_INCREMENT, -- 주소번호
    CONSTRAINT PRIMARY KEY( ano ), -- PK 필드 선정
    aroad VARCHAR(100) NOT NULL, -- 도로명주소
    astreet VARCHAR(100) NOT NULL, -- 지번주소
    adetail VARCHAR(100) NOT NULL, -- 상세주소
    anote VARCHAR(100) NOT NULL, -- 주소메모
    jno INT, -- 회원번호 FK 필드
    CONSTRAINT FOREIGN KEY( jno ) REFERENCES joinlist( jno ) -- FK 필드 설정
);

# [3] 카테고리
CREATE TABLE categorie(
    cno INT AUTO_INCREMENT, -- 카테고리번호
    CONSTRAINT PRIMARY KEY( cno ), -- PK 필드 선정
    cname VARCHAR(30) NOT NULL UNIQUE -- 카테고리명
);

# [4] 카테고리 디테일
CREATE TABLE cdetail(
    cdno INT AUTO_INCREMENT, -- 카테고리디테일번호
    CONSTRAINT PRIMARY KEY( cdno ), -- PK 필드 선정
    cdname VARCHAR(30) NOT NULL unique, -- 카테고리디테일명
    cno INT, -- 카테고리번호 FK 필드
    CONSTRAINT FOREIGN KEY( cno ) REFERENCES categorie( cno ) -- FK 필드 설정
);

# [5] 제품기능
create table product(
    pno INT AUTO_INCREMENT, -- 제품번호
    CONSTRAINT PRIMARY KEY( pno ), -- PK 필드 선정
    pname VARCHAR(30) NOT NULL UNIQUE, -- 제품명
    pprice INT UNSIGNED DEFAULT 0, -- 제품가격
    cdno INT, -- 카테고리디테일번호 FK 필드
    CONSTRAINT FOREIGN KEY( cdno ) REFERENCES cdetail( cdno ) -- FK 필드 설정
);

# [6] 주문기능
CREATE TABLE porder(
    pono INT AUTO_INCREMENT, -- 주문번호
    CONSTRAINT PRIMARY KEY( pono ), -- PK 필드 선정
    podate DATETIME DEFAULT NOW(), -- 주문날짜
    jno INT, -- 회원번호 FK 필드
    CONSTRAINT FOREIGN KEY( jno ) REFERENCES joinlist( jno ) -- FK 필드 설정
);

# [7] 주문 디테일
CREATE TABLE porderdetail(
    podno INT AUTO_INCREMENT, -- 주문상세번호
    CONSTRAINT PRIMARY KEY( podno ), -- PK 필드 선정
    podamount INT NOT NULL default 0, -- 주문수량
    pno INT, -- 제품번호 FK 필드
    CONSTRAINT FOREIGN KEY( pno ) REFERENCES product( pno ), -- FK 필드 설정
    pono INT, -- 주문번호 FK 필드
    CONSTRAINT FOREIGN KEY( pono ) REFERENCES porder( pono ) -- FK 필드 설정
);

DROP DATABASE market; -- DB 삭제

