commit;

--*****테이블 생성*****--

--member 테이블
create table member (
	id varchar(100) primary key,
	password varchar(100) not null,
	email varchar(100),
	nickname varchar(100) not null,
	certified varchar(100) not null,
	enabled int default 1 not null
);

--권한 테이블
create table authorities(
	id varchar(100) not null,
	authority varchar(30) not null,
	constraint member_authorities primary key(id,authority),
	constraint fk_authorities foreign key(id) references member(id)
	on delete cascade
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
	channel_id varchar(100) not null,
	folder_name varchar(100) not null,
	id varchar(100) not null,
	channel_info text not null,
	description varchar(255),
	constraint pk_info_youtube_channel primary key(channel_id, folder_name, id),
	constraint fk_info_youtube_channel foreign key(folder_name, id) references folder_youtube_channel(folder_name, id)
	on delete cascade
	on update cascade
);

--post 테이블
create table post(
	num int AUTO_INCREMENT primary key,
	title varchar(255) not null,
	content blob not null,
	channel_info text not null,
	folder_name varchar(255) not null,
	posting_date timestamp not null default now(),
	recommend_type varchar(100) not null,
	hits int default 0 not null,
	likes int default 0 not null,
	certified int default 0 not null,
	id varchar(100) not null,
	constraint fk_post foreign key(id) references member(id)
);

--post용 channel 테이블
/*create table post_youtube_channel(
	channel_id varchar(100) not null,
	num int not null,
	channel_info text not null,
	folder_name varchar(100) not null,
	description varchar(255),
	constraint pk_post_youtube_channel primary key(channel_id, num),
	constraint fk_post_youtube_channel foreign key(num) references post(num)
	on delete cascade
)*/


drop table authorities;
drop table list_youtube_channel;
drop table folder_youtube_channel;
--drop table post_youtube_channel;
drop table post;
drop table member;

select * from member;
select * from authorities;
select * from folder_youtube_channel;
select * from list_youtube_channel;
--select * from post_youtube_channel;
select * from post;
