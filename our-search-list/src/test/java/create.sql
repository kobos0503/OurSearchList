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
);

--my youtube channel list 용 폴더 테이블
create table folder_youtube_channel(
	folder_name varchar(100) not null,
	id varchar(100) not null,
	constraint fk_folder_youtube_channel foreign key(id) references member(id),
	constraint pk_folder_youtube_channel primary key(folder_name, id)
);

--my youtube channel list 채널 정보 테이블
create table list_youtube_channel(
	channel_info text not null,
	folder_name varchar(100) not null,
	id varchar(100) not null,
	description varchar(200),
	
	constraint fk_info_youtube_channel foreign key(folder_name, id) references folder_youtube_channel(folder_name, id)
	on delete cascade
	on update cascade
);
constraint pk_info_youtube_channel primary key(channel_info, folder_name, id),
drop table authorities;
drop table member;
drop table list_youtube_channel;
drop table folder_youtube_channel;

select * from member;
select * from authorities;
select * from folder_youtube_channel;
select * from list_youtube_channel;

insert into folder_youtube_channel(id, folder_name) values('1','aa')
delete from folder_youtube_channel where folder_name ='aa'
select * from youtube_channel_member where id = '1'
