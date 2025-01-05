# 1. 데이터베이스 생성
DROP DATABASE IF EXISTS mydb0102;			            -- 데이터베이스 삭제
CREATE DATABASE mydb0102;					            -- 데이터베이스 생성
use mydb0102;								            -- 데이터베이스 활성화

# 2. 테이블 생성
CREATE TABLE table1(                                    -- 테이블 생성
	mno INT AUTO_INCREMENT,                             -- 속성1 : mno, 자동증가
    mname VARCHAR(30) NOT NULL UNIQUE,                  -- 속성2 : mname, 30자 이내, null 불가능, 중복 불가능
    mcount INT,                                         -- 속성3 : mcount, 정수형
    CONSTRAINT PRIMARY KEY(mno)                         -- 기본키 설정
);
# DML : 데이터베이스 조작어
# 1. insert		2. select	3. update	4. delete
#	   [C]			[R]			[U]			[D]

# [1] insert : 레코드(행/튜플) 삽입
# insert into 테이블명( 속성명1 , 속성명2 ) values( 값1 , 값2 );
INSERT INTO table1 ( mname , mcount ) VALUES( '박명수' , 10 );          -- 레코드 삽입

INSERT INTO table1 ( mname , mcount ) VALUES( 20 , '유재석');           -- 에러 / mname 속성에 제약조건이 unique 이므로 중복 삽입 불가능하다.

INSERT INTO table1 ( mname , mcount ) VALUES( 30 );                    -- 에러 / mname 속성에 제약조건이 not null 이므로 초기값 대입 해야한다.
# mno 속성은 auto_increment 이므로 값을 대입하지 않아도 자동으로 증가된다.

INSERT INTO table1 ( mno, mname , mcount ) VALUES( 3, '강호동' , 30 );
# 테이블의 모든 속성들을 순서대로 초기값 대입할 경우 속성명은 생략해도 된다.

INSERT INTO table1 VALUES( 4, '신동엽' , 40 );

# insert 에 여러개 레코드 삽입 하기.
INSERT INTO table1 VALUES( 5, '서장훈', 50 ),( 6, '하하', 60 );


# [2] select : 레코드(행/튜플) 조회
    # 1. 전체 속성의 레코드 조회 : select * from 테이블명;  , *[와일드카드] 모든 속성명 뜻
    SELECT * FROM table1;

    # 2. 특정 속성의 레코드 조회 : select 속성명1, 속성명2 from 테이블명;   , 속성명이 2개 이상 일때, 속성명 사이에 콤마(,)로 구분
    SELECT mno FROM table1;                                             -- mno 속성만 조회

    SELECT mno , mname FROM table1;                                     -- mno, mname 속성만 조회

    SELECT mno , mname , mcount FROM table1;                            -- mno, mname, mcount 속성만 조회


# [3] update : 레코드(행/튜플) 수정
    # 1. 전체 레코드의 속성값 수정 : update 테이블명 set 속성명 = 새로운값
    UPDATE table1 SET mcount = 10;                                     -- 모든 레코드의 mcount 속성값을 10으로 수정 / 오류 해결 방안 : mySQL workbench safe mode 끄기 / 다시 실행.
    SET SQL_SAFE_UPDATES = 0;                                          -- safe mode 끄기
    SET SQL_SAFE_UPDATES = 1;                                          -- safe mode 켜기

    # 2. 특정 레코드의 속성값 수정 : update 테이블명 set 속성명 = 새로운값 where 조건식
    UPDATE table1 SET mcount = 100 WHERE mname = '유재석';              -- mname 속성값이 '유재석'인 레코드의 mcount 속성값을 100으로 수정
    UPDATE table1 SET mcount = 200 WHERE mno = 3;                      -- mno 속성값이 3인 레코드의 mcount 속성값을 200으로 수정

    # 3. 여러 속성값 수정 : update 테이블명 set 속성명1 = 새로운값, 속성명2 = 새로운값 where 조건식
    UPDATE table1 SET mname = '강호동2', mcount = 200 WHERE mno = 3;    -- mno 속성값이 3인 레코드의 mname 속성값을 '강호동2', mcount 속성값을 200으로 수정


# [4] delete : 레코드(행/튜플) 삭제
    # 1. 전체 레코드 삭제 : delete from 테이블명;
    DELETE FROM table1; -- 모든 레코드 삭제

    # 2. 특정 레코드 삭제 : delete from 테이블명 where 조건식
    DELETE FROM table1 WHERE mno = 3; -- mno 속성값이 3인 레코드 삭제



DROP DATABASE mydb0102; -- DB 삭제


# 실습 문제 8개 
# 테이블이 있다는 가정하에 SQL만 작성, 풀이후 (테스트)실행 불가능

# [문제1]: employees 테이블에 새로운 직원을 추가하세요. 직원의 정보는 다음과 같습니다:
# employee_id: 101
# first_name: 'John'
# last_name: 'Doe'
# email: 'johndoe@example.com'
# hire_date: '2024-06-24'
# job_id: 'IT_PROG'
SELECT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id)
VALUES (101, 'John', 'Doe', 'johndoe@example.com', '2024-06-24', 'IT_PROG');

# [문제2]: products 테이블에 새로운 제품을 추가하세요. 제품의 정보는 다음과 같습니다:
# product_id: 201
# product_name: 'Wireless Mouse'
# category: 'Electronics'
# price: 29.99
# stock_quantity: 150
INSERT INTO products (product_id, product_name, category, price, stock_quantity)
VALUES (201, 'Wireless Mouse', 'Electronics', 29.99, 150);

# [문제3]: employees 테이블에서 모든 직원의 first_name과 email을 조회하세요.
SELECT first_name, email
FROM employees;

# [문제4]: products 테이블에서 price가 1000 인 제품의 product_name과 price를 조회하세요.
SELECT product_name, price 
FROM products WHERE price = 1000;

# [문제5]: employees 테이블에서 employee_id가 101인 직원의 email을 'john.doe@company.com'으로 업데이트하세요.
UPDATE employees
SET email = 'john.doe@company.com'
WHERE employee_id = 101;

# [문제6]: products 테이블에서 product_id가 201인 제품의 price를 24.99로 업데이트하세요.
UPDATE products
SET price = 24.99
WHERE product_id = 201;

# [문제7]: employees 테이블에서 employee_id가 101인 직원을 삭제하세요.
DELETE FROM employees
WHERE employee_id = 101;

# [문제8]: products 테이블에서 product_id가 201인 제품을 삭제하세요.
DELETE FROM products
WHERE product_id = 201;

