CREATE TABLE MEMBER(
 	ID VARCHAR2(20) PRIMARY KEY,
 	PWD VARCHAR2(16) NOT NULL,
 	NAME VARCHAR2(20) NOT NULL,
 	EMAIL VARCHAR2(30) NOT NULL,
 	INTEREST_CATEGORY NUMBER(1) NOT NULL,--ISBN 부가 기호표에 따른 내용 대분류 기준, 관심 분야
 	POINT INT NOT NULL,
 	CASH INT NOT NULL
);

CREATE TABLE BOOK(
    booki_d NUMBER(10) PRIMARY KEY,
	ISBN VARCHAR2(30) NOT NULL,
	CATEGORY NUMBER(1)NOT NULL,
	BNAME VARCHAR2(128)NOT NULL,
	WRITER VARCHAR2(40)NOT NULL,
	PRENT NUMBER(10),
	ORIGIN_PRICE NUMBER(10) NOT NULL,
	SUMMARY VARCHAR2(1800),
    IMAGE VARCHAR(2000)
);

CREATE TABLE HISTORY(
 	ID VARCHAR2(20) PRIMARY KEY,
 	ISBN VARCHAR2(20) NOT NULL,
 	b_name VARCHAR2(128) NOT NULL,
    WRITER VARCHAR2(30)NOT NULL
);


CREATE TABLE QUIZ(
	QUIZID  NUMBER(13) PRIMARY KEY,
    ISBN VARCHAR2(20) not null,
	QUESTION VARCHAR2(300) NOT NULL,
	ANSWER NUMBER(1) NOT NULL
);
 
CREATE SEQUENCE QUIZ_ID  
	INCREMENT BY 1 
	START WITH 1 
	MINVALUE 1 
	MAXVALUE 1000 
	NOCYCLE 
; 


 
 
