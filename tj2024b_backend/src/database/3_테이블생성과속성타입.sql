/*
	1. [정수]
		TINYINT					1바이트					-128 ~ +127		    vs byte
        SMALLINT				2바이트					+-3만정도			 vs short
        MEDIUMINT				3바이트					+-800만정도
		INT						4바이트					+-21억이상
        BINGINT 				8바이트 				+-21억이상 		     vs long 
        
	2. [실수]
        FLOAT 					4바이트 								부동소수점(표현 범위 이상일 경우 오차 발생)
        DOUBLE		 			8바이트 								부동소수점(표현 범위 이상일 경우 오차 발생)
        DECIMAL 				문자타입 								실수를 문자로 처리하는 타입, 오차 없음
        
	3. [날짜/시간]
		DATE				날짜표현, 0000-00-00,					1000년 ~ 9999년
		TIME 				시간표현, 00:00:00				
        DATETIME 			날짜/시가표현, 0000-00-00 00:00:00
        
	4. [문자]
		CHAR(문자길이) 		문자열표현, 고정길이, 최대 255글자, char(5)			--> "유재석" --> [유] [재] [석] [ ] [ ] 2칸이 남는다.
		VARCHAR(문자길이)		문자열표현, 가변길이, 최대 255글자, varchar(5)		--> "유재석" --> [유] [재] [석] 남는 길이는 제거
		TEXT				문자열표현, 최대 6만 글자
		LONGTEXT			문자열표현, 최대 42억개 글자, 4GB, 대용량
	
*/

-- 한줄 주석
# 한줄 주석
/* 여러줄 주석 */
-- 실행 : 실행할 명령어에 커서를 두고 COMMAND + ENTER
# 대문자 단축키 : COMMAND + SHIFT + U
# 소문자 단축키 : COMMAND + SHIFT + L

# [1] db server 의 전체 데이터베이스 목록 조회
SHOW DATABASES;

# [2] db server 의 local path 조회 
SHOW VARIABLES LIKE 'datadir';

# [3] db server 의 db 생성
CREATE DATABASE mydb1230;

# [4] db server 의 db 삭제
DROP DATABASE mydb1230;
DROP DATABASE if exists mydb1230;

# [5] db server 의 사용할 db 활성화
USE mydb1230;

CREATE DATABASE my1230;
USE my1230;

# [1] 테이블 생성한다. create table 테이블명( 필드명 );
CREATE TABLE testtable1( 필드명 int );

# [2] 현재 활성화(사용) 중인 DB내 모든 테이블 조회
SHOW TABLES;

# [3] 테이블 생성한다. create table 테이블명( 필드명 타입, 필드명 타입 );
# 여러개 필드가 존재할 경우 ,(쉼표) 구분한다.
CREATE TABLE testtable2( 필드명1 int, 필드명2 double );

# [4] 테이블 삭제한다. drop table 테이블명;
DROP TABLE testtable1;
DROP TABLE IF EXISTS testtable2;

# [5] MYSQL 데이터 타입
# 다양한 데이터 타입 이용한 테이블 생성 실습
CREATE TABLE testtable3( # 테이블 생성 시작 # 주의할점 : DB 사용 활성화가 된 상태에서 가능, use ~~ 실행 확인
	# 속성명 타입, 속성명 타입
    정수필드1 TINYINT,
    정수필드2 SMALLINT,
    정수필드3 MEDIUMINT,
    정수필드4 INT,
    정수필드5 BIGINT,
    실수필드1 FLOAT,
    실수필드2 DOUBLE,
    날짜필드 DATE,
    시간필드 TIME,
    날짜시간 DATETIME,
    문자필드1 CHAR(100),
    문자필드2 VARCHAR(100),
    문자필드3 TEXT,
    문자필드4 LONGTEXT,
    논리필드 BOOL	# 마지막 필드 뒤에는 ,(쉼표) 넣지 않는다.
    ); # 테이블 생성 끝
    
SHOW TABLES; # 전체 테이블 목록 조회

# [6] 특정한 테이블 조회
SELECT * FROM testtable3;

# 실습1 : boardservice9 의 DB 설계 하시오.
# 단계1 : DB 서버의 DB 만들기
CREATE DATABASE boardservice9;

# 단계2 : 지정한 DB의 테이블 만들기 위해서 DB 활성화
USE boardservice9;

# 단계3 : 지정한 DB 의 테이블 생성하기.
CREATE TABLE board(
	title VARCHAR(100),		# 임의로 제목은 최대 100글자로 설계 			    # 자바: private String title;
    CONTENT LONGTEXT, 		# 임의로 내용은 긴글과 사진도 넣기위해 설계		     # 자바: private STRING CONTENT;
    writer VARCHAR(30)		# 임의로 작성자는 최대 30글자로 설계 			   # 자바: private String writer;
); # 테이블 생성 끝

SHOW TABLES;	# 전체 테이블 목록 조회

# 실습2 : day09 패키지의 WaitingService 의 DB 설계 하시오.
CREATE DATABASE waitingservice; 	# 단계1 : DB 서버의 DB 만들기
USE waitingservice;					# 단계2 : DB 서버의 사용할 DB 활성화 하기
CREATE TABLE waiting(				# 단계3 : 활성화 한 DB 내 테이블을 적절한 타입으로 선언한다.
	phone CHAR(13),					# 임의로 핸드폰 번호는 13자리로 고정해서 사용 하겠다는 설계 	# String phone;
    COUNT INT 						# 임의로 인원수는 int 타입 설계
); # 테이블 생성 끝
SHOW TABLES; 	# 전체 테이블 목록 조회

# [7] 제약조건 : 테이블에서 문제/결함 되는 데이터가 입력되지 않도록 제약
USE mydb1230;
CREATE TABLE testtable4(
	# 필드명 타입 제약조건
    필드명1 TINYINT NOT NULL, 			         # 지정한 필드에는 null 을 대입할 수 없다.
    필드명2 SMALLINT UNIQUE, 				     # 지정한 필드에는 중복값을 대입할 수 없다.
    필드명3 INT DEFAULT 10,				         # 지정한 필드에는 레코드 삽입시 값을 생략하면 자동으로 기본값이 대입된다.
    필드명4 BIGINT AUTO_INCREMENT,		         # 지정한 필드에는 레코드 삽입시 순서대로 자동번호가 대입된다.
    pk필드명5 DOUBLE,
    CONSTRAINT PRIMARY KEY( pk필드명5 )	         # 지정한 필드를 pk필드로 설정 ( not null 과 unique 포함 )
);
CREATE TABLE testtable5(
	FK필드명1 DOUBLE,
    CONSTRAINT FOREIGN KEY( Fk필드명1 ) REFERENCES testtable4(PK필드명5)
    -- 지정한 필드를 fk필드로 설정하고 참조할 pk필드가 위치한 테이블명과 pk필드명을 작성한다.    
);

# 실습1 : boardservice7 에서 회원제 게시판 DB 설계하시오.
	# 회원테이블, 게시판테이블 => 회원이 존재해야 게시물이 존재한다. 즉] 회원(PK) 게시물(FK)
CREATE DATABASE boardservice7;
USE boardservice7;
# 회원 테이블
CREATE TABLE MEMBER(
	mno INT AUTO_INCREMENT,				-- 회원번호 는 자동번호를 부여하기 위해 auto_increment 제약조건 선택. / 회원번호 는 최대 20억 이상이 될 경우가 없을것 같아서 int 타입 선택.
    MID VARCHAR(30) NOT NULL UNIQUE,	-- 회원아이디 는 공백이라는 아이디가 존재하면 안되서 not null 제약조건 선택. / 회원아이디 는 중복을 차단해야 하므로 unique 제약조건 선택.
    mpwd VARCHAR(30) NOT NULL,			-- 회원비밀번호 는 공백을 차단하기 위해 not null 제약조건 선택.
    mname VARCHAR(10) NOT NULL,			-- 회원명은 공백을 차단하기 위해 not null 제약조건 선택, / 회원명은 최대 10글자까지 입력받기 위해 VARCHAR(10)
    CONSTRAINT PRIMARY KEY( mno )		-- 회원번호를 pk필드로 선정, not null 과 unique 포함
);
# 게시판 테이블
CREATE TABLE board(
	bno BIGINT AUTO_INCREMENT,			# 게시물 번호는 자동번호를 부여하기 위해 auto_increment 사용, 20억이상의 게시물 번호를 표현하기 위해 BIGINT 사용.
    btitle VARCHAR(100) NOT NULL, 		# 게시물 제목은 공백을 없애기 위해 not null 사용, 문자가 최대 100글자까지 가능하도록 사용
    bcontent TEXT,						# 게시물 내용은 공백을 허용하고, 최대 4GB 까지 대용량 입력 가능하도록 사용.
    bdate DATETIME DEFAULT NOW(),		# 게시물 작성일 에는 default 기본값에 now() 함수를 사용하면 자동으로 시스템 날짜/시간이 삽입된다.
    CONSTRAINT PRIMARY KEY( bno ),		# 게시물 번호를 PK필드로 선정.
    mno INT,							# FK필드 # 회원번호FK # 참조할 필드와 동일한 타입으로 선정.
    CONSTRAINT FOREIGN KEY( mno ) REFERENCES MEMBER( mno ) # board 테이블의 mno 필드가 member 테이블의 mno 필드를 참조한다.
);

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

-- 키오스크 DB 설계 및 테이블 생성
-- 데이터베이스 생성
CREATE DATABASE kiosk_db; -- 새로운 데이터베이스 생성
USE kiosk_db; -- 해당 데이터베이스를 사용하도록 설정

-- 1. 카테고리 테이블 생성
CREATE TABLE Category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY, -- 각 카테고리를 고유하게 식별하는 ID
    CategoryName VARCHAR(100) NOT NULL        -- 카테고리의 이름, NULL 값을 허용하지 않음
);

-- 디버깅 로그
SELECT 'Category 테이블 생성 완료' AS log; -- Category 테이블 생성 확인 로그

-- 2. 제품 테이블 생성
CREATE TABLE Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY, -- 각 제품을 고유하게 식별하는 ID
    ProductName VARCHAR(100) NOT NULL,        -- 제품의 이름, NULL 값을 허용하지 않음
    Price DECIMAL(10, 2) NOT NULL,            -- 제품의 가격, 소수점 이하 2자리까지 허용
    CategoryID INT NOT NULL,                  -- 해당 제품이 속한 카테고리의 ID
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID) -- 카테고리와 연결된 외래키
);

-- 디버깅 로그
SELECT 'Product 테이블 생성 완료' AS log; -- Product 테이블 생성 확인 로그

-- 3. 주문 테이블 생성
CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,   -- 각 주문을 고유하게 식별하는 ID
    OrderDate DATETIME NOT NULL DEFAULT NOW() -- 주문이 생성된 날짜와 시간, 기본값은 현재 시간
);

-- 디버깅 로그
SELECT 'Orders 테이블 생성 완료' AS log; -- Orders 테이블 생성 확인 로그

-- 4. 주문 상세 테이블 생성
CREATE TABLE OrderDetails (
    OrderDetailID INT AUTO_INCREMENT PRIMARY KEY, -- 각 주문 상세 항목을 고유하게 식별하는 ID
    OrderID INT NOT NULL,                         -- 주문 번호, Orders 테이블과 연결
    ProductID INT NOT NULL,                       -- 제품 번호, Product 테이블과 연결
    Quantity INT NOT NULL,                        -- 주문된 제품의 수량
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID), -- Orders 테이블의 OrderID와 연결된 외래키
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) -- Product 테이블의 ProductID와 연결된 외래키
);

-- 디버깅 로그
SELECT 'OrderDetails 테이블 생성 완료' AS log; -- OrderDetails 테이블 생성 확인 로그

-- 예제 데이터 삽입
-- 카테고리 데이터 삽입
INSERT INTO Category (CategoryName) VALUES ('Beverages'), ('Snacks'), ('Desserts'); -- 기본 카테고리 데이터 추가

-- 디버깅 로그
SELECT 'Category 데이터 삽입 완료' AS log; -- 카테고리 데이터 삽입 확인 로그

-- 제품 데이터 삽입
INSERT INTO Product (ProductName, Price, CategoryID) 
VALUES 
('Americano', 3.50, 1), -- Beverages 카테고리의 Americano 제품
('Latte', 4.00, 1),     -- Beverages 카테고리의 Latte 제품
('Chips', 1.50, 2),     -- Snacks 카테고리의 Chips 제품
('Cake', 2.50, 3);      -- Desserts 카테고리의 Cake 제품

-- 디버깅 로그
SELECT 'Product 데이터 삽입 완료' AS log; -- 제품 데이터 삽입 확인 로그

-- 주문 데이터 삽입
INSERT INTO Orders (OrderDate) VALUES (NOW()); -- 현재 시간으로 주문 데이터 추가

-- 디버깅 로그
SELECT 'Orders 데이터 삽입 완료' AS log; -- 주문 데이터 삽입 확인 로그

-- 주문 상세 데이터 삽입
INSERT INTO OrderDetails (OrderID, ProductID, Quantity) 
VALUES 
(1, 1, 2), -- 첫 번째 주문에 Americano 2개 주문
(1, 3, 1); -- 첫 번째 주문에 Chips 1개 주문

-- 디버깅 로그
SELECT 'OrderDetails 데이터 삽입 완료' AS log; -- 주문 상세 데이터 삽입 확인 로그
