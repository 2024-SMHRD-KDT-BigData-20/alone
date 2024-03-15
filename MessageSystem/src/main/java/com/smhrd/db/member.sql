select * from member;
drop table member;

create table member(
	email VARCHAR2(50) NOT NULL,
	pw VARCHAR2(50) NOT NULL,
	tel VARCHAR2(50) NOT NULL,
	address VARCHAR2(50) NOT NULL,
	constraint member_pk primary key (email)
);


create table web_message(
	idx number(36),
	sendName varchar2(100),
	receiveEmail varchar2(100),
	msg varchar2(200),
	indate date,
	constraint msg_pk primary key(idx)
);

-- 시퀀스 생성
create sequence 시퀀스이름 increment by 시작 start with 몇씩;
create sequence idx_msg increment by 1 start with 1;

     insert into web_message values
   (idx_msg.nextval, 'smart', 'test', '오늘은 목요일', sysdate);
   
select * from WEB_MESSAGE;
select * from web_message where receiveEmail='44'
select * from web_message where receiveEmail='test'


-- 테이블 생성
create table 테이블명(
	컬럼명1 VARCHAR2(길이) NOT NULL,
	컬럼명2 VARCHAR2(길이),
	constraint 테이블명_pk primary key (컬럼명1)
);

-- 데이터 입력
-- 전체 데이터 입력하는 경우 : 컬럼 순서대로 값을 입력
insert into 테이블명 values ('값1','값2');
-- 일부 데이터 입력하는 경우 : 순서를 직접 지정 가능
insert into 테이블명 (컬럼명2, 컬럼명1) values ('값2','값1');

-- 데이터 조회
select * from 테이블명; -- 전체 정보 조회
select * from 테이블명 where 컬럼명1='smart'; -- 조건대로 조회
select * from 테이블명 where 컬럼명1='smart' order by 컬럼명2 asc -- 특정 기준으로 정렬

-- 데이터 수정
update 테이블명 set 컬럼명1='smart2' where 컬럼명1='smart';

-- 데이터 한줄 삭제
delete 테이블명 where 컬럼명1='smart';

-- 테이블 삭제
drop table 테이블명;

-- 트랜잭션 정리 반영
commit;


