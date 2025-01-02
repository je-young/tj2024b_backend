# SQL 과제1 : 키오스크 개발의 메모리 설계 하고 DB와 테이블 생성을 SQL로 작성하여 제출 하시오.
/*
	https://www.youtube.com/watch?v=ksuYwD1oC3A
	위 링크와 같은 프로그램을 만들기 위한 DB 설계를 하시오.
	[요구사항]
	1. 여러개 카테고리중에 카테고리를 선택을 해서 카테고리 별로 제품들을 출력/확인 한다.
	2. 해당 제품을 선택해서 수량 입력받아 주문처리 한다. 단, 하나의 주문의 여러개 제품을 주문할수있다.
	3. 주문번호를 받아서 대기한다.
	4. 설계 조건
		1. [ 메모리 설계 필수 속성 ]	
		- 식별자코드 , 카테고리명 , 가격 , 제품명 , 주문수량 , 주문날짜 하되 추가 가능 합니다.
		2. 테이블간의 데이터 중복을 최소화한다.
		3. 총 테이블은 3개 이상으로 설계한다.
		4. 적절한 타입과 제약조건을 최대한 활용하시오.
        5. DB명 , 테이블명, 속성명은 임의로 합니다. 
        
	* 제출 : 카카오톡방에 SQL 과제 코드가 존재하는 본인 git 상세주소 제출 
*/

CREATE DATABASE Kiosk;																					# [1] DB 생성
USE Kiosk;																											# [2] DB 활성화

# 주의할점은 테이블 생성시 상위PK 테이블 먼저 생성

# [4] 카테고리 테이블
CREATE TABLE Category(
	cno		INT AUTO_INCREMENT,									# 카테고리번호
	cname	VARCHAR(30) NOT NULL,								# 카테고리명
	CONSTRAINT PRIMARY KEY( cno )								# PK 필드 선정
);

# [5] 제품 테이블
CREATE TABLE Product(
	pno 	INT AUTO_INCREMENT,									# 제품번호
	pname	VARCHAR(100) NOT NULL,								# 제품명
  pprice  INT UNSIGNED DEFAULT 0,								# 제품가격
	CONSTRAINT PRIMARY KEY(pno),								# PK필드 설정
  cno		INT,												# FK필드 선언(PK필드와 동일한 타입 권장)
  CONSTRAINT FOREIGN KEY(cno) REFERENCES Category(cno)			# FK필드 설정
);

# [6] 주문 테이블
CREATE TABLE Porder(
	pono INT AUTO_INCREMENT,									# 주문번호
  pndate DATETIME DEFAULT now(),								# 주문날짜, 현재 시스템 날짜 자동
  CONSTRAINT PRIMARY KEY(pono)									# PK필드 선정
);

# [7] 주문상세 테이블
CREATE TABLE Porderdetail(
	podno INT AUTO_INCREMENT, 									# 주문상세
  podamount TINYINT UNSIGNED NOT NULL, 							# 주문수량 
  CONSTRAINT PRIMARY KEY( podno ),					 			# 주문상세 PK 설정 
  pno INT, 														# 제품번호FK 필드
  CONSTRAINT FOREIGN KEY( pno ) REFERENCES product( pno ),
  pono INT, 													# 주문번호FK 필드 
  CONSTRAINT FOREIGN KEY( pono ) REFERENCES porder( pono )
);