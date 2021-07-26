commit;

--*****테이블 생성*****--

--member 테이블
create table member (
	id varchar(100) primary key,
	password varchar(100) not null,
	email varchar(100) not null,
	nickname varchar(100) not null,
	certified varchar(100) not null,
	enabled int default 1 not null
);

--권한 테이블
create table authorities(
	id varchar(100) not null,
	authority varchar(30) not null,
	constraint fk_authorities foreign key(id) references member(id),
	constraint member_authorities primary key(id,authority)
)

drop table authorities
drop table member

select * from member;
select * from authorities;