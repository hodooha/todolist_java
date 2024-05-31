USE SCOTT;

drop table user cascade constraints;
create table user(
	user_id varchar(20) primary key,
	pw varchar(20) not null,
	name varchar(20) not null,
	phone varchar(20) not null,
	create_date timestamp DEFAULT CURRENT_TIMESTAMP,
	isdeleted char(2) default 'N',
	del_date timestamp
);

drop table task cascade constraints;
create table task(
	user_id varchar(20),
	task_id varchar(20), 
	content varchar(20) not null,
	complete char(2) DEFAULT 'N',
	CONSTRAINT pk_task PRIMARY KEY (USER_ID, task_id),
    CONSTRAINT fk_task FOREIGN KEY (USER_ID) REFERENCES user(USER_ID)
);

drop table diary cascade constraints;
create table diary(
	user_id varchar(20),
	create_date timestamp default CURRENT_TIMESTAMP,
	title varchar(20) not null,
	content varchar(20) not null,
	CONSTRAINT pk_diary PRIMARY KEY (USER_ID, create_date),
    CONSTRAINT fk_diary FOREIGN KEY (USER_ID) REFERENCES user(USER_ID)
);

INSERT INTO user (user_id, pw, name, phone) VALUES( '111', '111', '회원1', '010-1111-1111');

COMMIT;

