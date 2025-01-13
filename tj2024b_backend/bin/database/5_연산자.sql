DROP DATABASE IF EXISTS example5_연산자;
CREATE DATABASE example5_연산자;
USE example5_연산자;

# 1. 회원테이블
DROP TABLE IF EXISTS MEMBER;
CREATE TABLE MEMBER(                  # 아이돌 그룹
   MID CHAR(8) NOT NULL ,             # 식별키       최대 8자리
    mname VARCHAR(10) NOT NULL ,      # 그룹명      최대 10자리
    mnumber INT NOT NULL ,            # 인원수      정수 +-21억정도
    maddr CHAR(2) NOT NULL ,          # 지역      최대 2자리
    mphone1 CHAR(3) ,                 # 지역번호   최대 2자리 
    mphone2 CHAR(8) ,                 # 전화번호    최대 8자리
    mheight SMALLINT ,                # 평균키       정수 +-3만정도
   mdebut DATE ,                      # 데뷔일       yyyy-mm-dd 
    CONSTRAINT PRIMARY KEY ( MID )    # 제약조건 
);
# 2. 구매테이블
DROP TABLE IF EXISTS buy;
CREATE TABLE buy(
   bnum INT AUTO_INCREMENT ,                              # 구매번호   정수    자동번호 부여 
    MID CHAR(8),                                          # 구매자      FK 
    bpname CHAR(6) NOT NULL ,                             # 제품명      최대 6자리 
    bgname CHAR(4) ,                                      # 분류명       최대   4자리
    bprice INT NOT NULL ,                                 # 가격       정수 
    bamount SMALLINT NOT NULL ,                           # 구매수량   정수 
    CONSTRAINT PRIMARY KEY(bnum) ,                        # 제약조건 
    CONSTRAINT FOREIGN KEY ( MID ) REFERENCES MEMBER(MID) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);


# DMl : insert : 삽입 , select : 조회 , update : 수정 , delete : 삭제
# [1] 모든 속송의 레코드 조회
# select * from 테이블명;
SELECT * FROM member;
SELECT * FROM buy;


# [2] 특정 속성명 , 속성명 from 테이블명;
SELECT mid FROM member;
SELECT MID , mname FROM member;


# [3] 속성명과 테이블명에 별칭 , 별칭이란? 조회 결과의 속성명 변경 , 원본 속성명은 그대로 , *다중테이블 조회시 속성명 중복 또는 간소화
# 속석명 as 별칭 , 주의할점 : as 생략 가능하다.
SELECT mid AS 회원아이디 FROM member; -- 조회결과 'mid' 속성명을 '회원아이디' 로 변경
SELECT mid AS 회원아이디 , mname 회원명 FROM member; -- 조회결과 'mid' -> '회원아이디' , 'mname' -> '회원명'로 변경
SELECT mid 회원아이디 , mname 회원명 FROM member; -- AS 생략 가능하다.
SELECT mid 회원아이디 , mname 회원명 FROM member AS m; -- 속성명과 테이블명에 별칭이 가능하다.
SELECT mid 회원아이디 , mname 회원명 FROM member m; -- 주로 AS는 생략한다. 테이블명 간소화 가능.


# [4] 속성값이 중복 인 레코드 제거
# DISTINCT 속성명
SELECT maddr FROM member; -- maddr(주소) 속성값 레코드 조회
SELECT DISTINCT maddr FROM member; -- maddr(주소) 속성값 중복 제거된 레코드 조회


# [5] 속성값에 산술연산
# 산술연산자 : 속성명 + 값 , 속성명 - 값 , 속성명 * 값 , 속성명 / 값 , 속성명 div 값 , 속성명 mod 값  
SELECT 
  mnumber AS 인원수, 
  mnumber + 3 AS 더하기, 
  mnumber - 3 AS 빼기, 
  mnumber * 3 AS 곱셈, 
  mnumber / 3 AS 나눗셈,
  mnumber DIV 3 AS 몫, 
  mnumber MOD 3 AS 나머지 
FROM member;


# [6] 조건철 WHERE
# 비교연산자 : 속성명 = 값 , 속성명 != 값 ,
# 논리연산자 : NOT 조건 , 조건1 AND 조건2 ,
# 기타연삱자 : 속송명 BETWEEN 시작값 AND 종료값 ,
# 문자열패턴 : 속성명 LIKE '문자패턴'
#                 % : 모든 문자 대응                 ex] 삼성전자/LG전자/물전자 , %전자 -> 삼성전자/LG전자/물전자
#                 _ : _개수 만큼 문자 대응            ex] 삼성전자/LG전자/물전자 , _전자 -> 물전자

# 주의할점 : 문자열 처리는 " " 혹은 ' ' 권장 ,
SELECT * FROM member WHERE mname = '블랙핑크'; -- 'mname' 속성값이 '블랙핑크' 인 레코드 조회
SELECT * FROM member WHERE mnumber = 4; -- 'mnumber' 속성값이 4인 레코드 조회
SELECT * FROM member WHERE mname != '블랙핑크'; -- 'mname' 속성값이 '블랙핑크' 가 아닌 레코더 조회
SELECT * FROM member WHERE NOT mname = '블랙핑크'; -- 'mname' 속성값이 '블랙핑크' 가 아닌 레코더 조회
SELECT * FROM member WHERE mheight <= 162; -- 'mheight' 속성값이 162보다 작은 레코더 조회
SELECT * FROM member WHERE mheight BETWEEN 165 AND 170; -- 'mheight' 속성값이 165보다 크고 170보다 작은 레코더 조회
# 'maddr' 속성값이 '경기' 이거나 'maddr' 속성값이 '전남' 이거나 'maddr' 속성값이 '경남' 인 레코더 조회
SELECT * FROM member WHERE maddr = '경기' OR maddr = '전남' OR maddr = '경남';
SELECT * FROM member WHERE maddr IN ('경기' , '전남' , '경남');
SELECT * FROM member WHERE mphone1 = ' '; -- 'mphone1' 속성값이 ' '인 레코더 조회
SELECT * FROM member WHERE mphone1 = NULL; -- 'mphone1' 속성값이 NULL인 레코더 조회
SELECT * FROM member WHERE mphone1 IS NULL; -- 'mphone1' 속성값이 NULL인 레코더 조회
SELECT * FROM member WHERE mphone1 IS NOT NULL; -- 'mphone1' 속성값이 NULL이 아닌 레코더 조회
SELECT * FROM member WHERE mname LIKE '에이%'; -- 'mname' 속성값이 '에이'로 시작하는 레코더 조회
SELECT * FROM member WHERE mname LIKE '에이_'; -- 'mname' 속성값이 '에이'로 시작하는 세글자 인 레코더 조회
SELECT * FROM member WHERE mname LIKE '%핑크'; -- 'mname' 속성값이 '핑크'로 끝나는 레코더 조회
SELECT * FROM member WHERE mname LIKE '%이%'; -- 'mname' 속성값이 '이'가 포함된 레코드 조회
SELECT * FROM member WHERE mname LIKE '_이_'; -- 'mname' 속성값이 '이'가 두번째 글자인 세글자 값 레코드 조회


# [7] 정렬 , 조회 결과의 레코드를 특정한 필드 기준으로 정렬
# ORDER BY 속성명 ASC , [기본값/생략가능] , 지정한 속성명 기준으로 속성값들을 오름차순 정렬 , 작은값 -> 큰값 , 과거날짜 -> 최근날짜 , ABC,ㄱㄴㄷ
# ORDER BY 속성명 DESC ,                , 지정한 속성명 기준으로 속성값들을 내림차순 정렬 , 큰값 -> 작은값 , 최근날짜 -> 과거날짜 , CBA, ㄷㄴㄱ
SELECT * FROM member ORDER BY mdebut ASC; -- 'mdebut' 속성값을 [오름차순] 으로 레코드 조회
SELECT * FROM member ORDER BY mdebut DESC; -- 'mdebut' 속성값을 [내림차순] 으로 레코드 조회
SELECT * FROM member ORDER BY mname; -- 'mname' 속성값을 [오름차순] 으로 레코드 조회 // ASC 생략가능
# 먼저 'maddr' 속성값을 정렬 후 동일한 속성값이 존재할경우 동일한 속성값 끼리 'mdebut' 속성값을 정렬
SELECT * FROM member ORDER BY maddr DESC , mdebut ASC; 


# [8] 제한 , 조회 결과의 레코드 수 제한
# LIMIT 레코드 수
# LIMIT 시작레코드(0~) , 개수
SELECT * FROM member LIMIT 2; -- 조회 결과의 레코드에서 상위 2개만 조회 제한
SELECT * FROM member LIMIT 0 , 2; -- 조회 결과의 레코드에서 0(첫번째)레코드 부터 2개만 조회 제한
SELECT * FROM member LIMIT 2 , 3; -- 조회 결과의 레코드에서 2(세번째)레코드 부터 3개만 조회 제한
SELECT * FROM member ORDER BY mheight DESC LIMIT 3; -- 'mheight' 가 상위 3개만 조회 제한

# 실습1 : 주소가 '서울'인 레코드를 데뷔일 기준으로 내림차순으로 조회 결과에 상위 2개만 조회 하시오.
SELECT * FROM member; -- 'member' 테이블 전체 레코드 조회
SELECT * FROM member WHERE maddr = '서울' ORDER BY mdebut DESC; -- 'mdebut' 속성명 기준 오름차순 조회
SELECT * FROM member WHERE maddr = '서울' ORDER BY mdebut DESC LIMIT 2; -- 'mdebut' 속성명 기준 오름차순 조회에서 상위 2개만 조회


# [9] 그룹
# GROUP BY 그룹속성명 having 그룹조건
# 주의할점 : 두 개 이상의 속성명 사용[ 그룹대상의 속성명 값은 동일하더라도 다른 속성명의 값이 다를 수 있으므로 ]
SELECT * FROM buy; -- 'buy' 테이블 전체 레코드 조회
SELECT bpname FROM buy GROUP BY bpname; -- 'buy' 테이블의 'bpname' 속성명 값을 그룹 , 중복 값이 없다.
SELECT bpname , bprice FROM buy GROUP BY bpname; -- 오류 : bpname이 동일하더라도 bprice 다를 수 있으므로
/*
  학년 , 점수 , 1학년의 총 점수합계
  1   ,  30
  2   ,  20
  3   ,  40
*/
# [10] 집계 / 통계 + 그룹
SELECT bamount FROM buy; -- 'bamount'(구매수량) 속성명 값들
SELECT SUM(bamount) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 총합계
SELECT AVG(bamount) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 평균합계
SELECT MIN(bamount) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 최솟값
SELECT MAX(bamount) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 최댓값
SELECT COUNT(bamount) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 개수 * null 제외한다.
SELECT COUNT(*) FROM buy; -- 'bamount'(구매수량) 속성명 값들의 개수 * null 포함한다.

# 1. 회원아이디 별 구매수량 총합계
SELECT MID , SUM(bamount) FROM buy GROUP BY mid; -- 'mid' 속성명의 값으로 (중복)그룹 하고 'bamount' 속성명을 집계한 레코드 죄회
# 2. 회원아이디 별 총구매금액 총합계 조회 , 구매수량 * 구매가격
SELECT MID , SUM(bamount * bprice) FROM buy GROUP BY mid;
# 3. 회원아이디 별 구매금액 평균 조회
SELECT MID , AVG(bprice) FROM buy GROUP BY mid;
# 4. 총 구매횟수(판매횟수) 조회
SELECT COUNT(*) FROM buy;
# 5. 회원아이디 별 구매횟수 조회
SELECT MID , COUNT(*) FROM buy GROUP BY mid;


# [11] HAVING 그룹조건 vs WHERE 그룹조건
# 1. 회원아이디 별 구매수량(bamount)이 3 초과인 레코드 조회
SELECT MID FROM buy WHERE bamount > 3;
# 2. 회원아이디 별 총 구매금액(bamount * bprice)이 1000 초과 인 레코드 조회
SELECT MID , SUM(bamount * bprice) FROM buy GROUP BY MID HAVING SUM(bamount * bprice) >= 1000;
SELECT MID , SUM(bamount * bprice) AS 총구매금액 FROM buy GROUP BY MID HAVING 총구매금액 >= 1000;
SELECT MID , bprice 구매가격 FROM buy WHERE 구매가격 >= 500; -- 오류 : WHERE 별칭으로 조건속성명 불가능  
SELECT MID , bprice AS 구매가격 FROM buy WHERE bprice >= 500; -- 위 오류 코드 수정으로 정상작동 조회

# 실습2 : buy 테이블의 구매수량(bamount)이 2개 초과 인 레코드 에서 회원아이디별 구매가격(bprice)평균 이 50 이상인 레코드 조회
# + 구매가격평균 내림차순 조회 , + 상위 2개만 조회

# 1. buy 테이블의 구매수량(bamount)이 2개 초과 인 레코드
SELECT * FROM buy WHERE bamount > 2;

# 2. 회원아이디(mid)별 구매가격(bprice)평균 * ~~별 집계(합계/평균/개수)
SELECT MID AS 회원아이디 , AVG(bprice) AS 구매가격평균
FROM buy
WHERE bamount > 2
GROUP BY 회원아이디;

# 3. 구매가격(bprice)평균 이 50 이상, 구매가격평균은 집계인지 아닌지 판다, 집계이면 HAVING 아니면 WHERE
SELECT MID AS 회원아이디 , AVG(bprice) AS 구매가격평균
FROM buy WHERE bamount > 2
GROUP BY 회원아이디 HAVING 구매가격평균 >= 50;

# 4. + 구매가격평균 내림차순 조회
SELECT MID AS 회원아이디 , AVG(bprice) AS 구매가격평균
FROM buy WHERE bamount > 2
GROUP BY 회원아이디 HAVING 구매가격평균 >= 50
ORDER BY 구매가격평균 DESC;

# 5. + 구매가격평균 상위 2개만 조회
SELECT MID AS 회원아이디 , AVG(bprice) AS 구매가격평균
FROM buy WHERE bamount > 2
GROUP BY 회원아이디 HAVING 구매가격평균 >= 50
ORDER BY 구매가격평균 DESC
LIMIT 0 , 2;

## [12] SELECT 사용시 여러 절 이 있을때 작성순ㄱ서
# SELECT 속성명 FROM 테이블명 WHERE 조건절 GROUP BY 그룹속성명 HAVING 그룹조건 ORDER BY 정렬속성명 정렬기준 LIMIT 시작번호 , 개수
## select 를 컴퓨터가 처리하는 순서.
# select [3] from [1] where [2] group by [4] having [5] order by [6] limit [7]