CREATE USER dding1 IDENTIFIED BY 1234;

GRANT CREATE SESSION TO dding;
GRANT ALTER SESSION TO dding;
GRANT CREATE TABLE TO dding;
GRANT CREATE ANY TABLE TO dding;
GRANT CREATE TABLESPACE TO dding;
GRANT UNLIMITED TABLESPACE TO dding;


CREATE TABLE users2 (
                        id VARCHAR2(255) PRIMARY KEY NOT NULL,
                        phoneNumb VARCHAR2(255) NOT NULL,
                        password VARCHAR2(255) NOT NULL,
                        dob VARCHAR2(255) NOT NULL,
                        email VARCHAR2(255) NOT NULL,
                        address VARCHAR2(255) NOT NULL,
                        name VARCHAR2(255) NOT NULL
);
create table board (
  board_idx number(4) primary key,
  board_name varchar2(20),
  board_title varchar2(100),
  board_content varchar2(300),
  board_date date default sysdate,
  board_hit number(4) default 0,
  board_likes number(4) default 0
  );
  
 create sequence board_seq;
 create table reply (
  reply_idx number(4) primary key,
  reply_name varchar2(20),
  reply_content varchar2(300),
  reply_date date default sysdate,
  reply_board_idx number(4)
  );
  create table sub_reply (
  sub_reply_idx number(4) primary key,
  sub_reply_name varchar2(20),
  sub_reply_content varchar2(300),
  sub_reply_date date default sysdate,
  sub_reply_reply_idx number(4)
  );
 create sequence sub_reply_seq;
 create sequence reply_board_seq;
