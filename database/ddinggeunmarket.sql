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
