# 전체 실행 : Command + Shift + Enter
# 단위 실행 : 커서위치 

# [1] 데이터베이스 준비
drop database if exists mydb0103;
create database mydb0103;
use mydb0103;

# [2] 테이블 생성
create table user(
   uno int unsigned auto_increment ,
    uname varchar(30) not null , 
    uage int not null,
    constraint primary key(uno)
);
