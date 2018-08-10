create table Member (
    userid varchar(50) not null,
    userpw varchar(50) not null,
    username varchar(5) not null,
    email varchar(100),
    regdate timestamp default now(),
    updatedate timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(userid)
);

desc Member;
select * from Member;

-- getTime
select now();

-- insert
/*
INSERT INTO Member(  userid,    userpw,    username,    email)
            VALUES(#{userid}, #{userpw}, #{username}, #{email})
*/