DROP TABLE USERS;
DROP TABLE RESERVE_BOOK;
DROP TABLE BOOK;
DROP TABLE SEAT;
DROP TABLE USE_SEAT;
DROP SEQUENCE SEQ_SEAT;
DROP SEQUENCE SEQ_BOOK;

CREATE TABLE USERS (
	ID		VARCHAR2(20),
	PWD		VARCHAR2(20),
	NAME		VARCHAR2(30),
	POSITION	NUMBER(1),
    CONSTRAINT USERS_PK PRIMARY KEY(ID)
);

CREATE TABLE RESERVE_BOOK (
	ID		VARCHAR(20),
	USERID	VARCHAR2(20),
	BOOKID	VARCHAR2(20),
	BRDATE	DATE,
	RTDATE	DATE,
	DUEDATE	DATE,
	STATE		VARCHAR2(2),
    CONSTRAINT RESERVE_BOOK_PK PRIMARY KEY(ID)
);

CREATE TABLE BOOK(
	ID		VARCHAR2(20),
	NAME		VARCHAR2(30),
	QT		NUMBER(3),
	REGDATE	DATE,
	AUTHOR	VARCHAR2(20),
	PUBLISHER	VARCHAR2(20),
	CATEGORY	VARCHAR2(20),
	IMG		VARCHAR2(30),
	CONTENTS	VARCHAR2(255),
    CONSTRAINT BOOK_PK PRIMARY KEY(ID)	
);



CREATE TABLE SEAT (
	ID	VARCHAR2(5),
	OCCUPY	NUMBER(1),
    CONSTRAINT SEAT_PK PRIMARY KEY(ID)		
);

CREATE TABLE USE_SEAT (
	ID		NUMBER(10),
	USERID	VARCHAR2(20),
	SID		VARCHAR2(5),
	INTIME	DATE,
	OUTTIME 	DATE,
    CONSTRAINT USE_SEAT_PK PRIMARY KEY(ID)
);


/*?? ???*/
CREATE SEQUENCE SEQ_BOOK
INCREMENT BY 1
START WITH 1;

/*???? ???*/
CREATE SEQUENCE SEQ_SEAT
INCREMENT BY 1
START WITH 1;

INSERT INTO USERS
VALUES('testid', 'testpwd', '???', 0);

INSERT INTO USERS
VALUES('admin', 'adminpwd', '???', 1);


