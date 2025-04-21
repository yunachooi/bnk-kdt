CREATE TABLE tbl_board(
    bno number primary key,
    title varchar2(50),
    content varchar2(1000),
    writer varchar2(50),
    regdate date
 );
 CREATE SEQUENCE seq_board;
 INSERT INTO tbl_board VALUES(seq_board.nextval, 'TITLE01', 'CONTENT01', 'USER01', SYSDATE);
 
 SELECT * FROM tbl_board;