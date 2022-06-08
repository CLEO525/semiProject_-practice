drop table comments;
drop table movie;
create table movie
(
	mnum number(5) primary key,
	title varchar2(50),
	content varchar2(100),
	director varchar2(20)
);

create table comments
(
	num number(5) primary key, --댓글번호 
	mnum number(5) references movie(mnum), --영화번호
	id varchar2(10), --작성자
	comments varchar2(100) --내용
);
create sequence movie_seq;
create sequence comments_seq;