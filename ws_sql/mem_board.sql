CREATE TABLE tbl_member(
    id VARCHAR2(20) PRIMARY KEY,
    pw VARCHAR2(10),
    name VARCHAR2(50), --VARCHAR2:가변길이
    phone CHAR(13), --CHAR:고정길이
    grade CHAR(1) --'A', 'B', 'C' 등급
);

CREATE TABLE tbl_board(
    bno NUMBER PRIMARY KEY,
    title VARCHAR2(100),
    content VARCHAR2(1000),
    regdate DATE,
    writer VARCHAR2(20),
    FOREIGN KEY(writer) REFERENCES tbl_member(id)
);

INSERT INTO tbl_member VALUES('id1', '1234', '홍길동', '010-1234-1234', 'A');
INSERT INTO tbl_member VALUES('id2', '1234', '홍길은', '010-5678-5678', 'B');
INSERT INTO tbl_member VALUES('id3', '1234', '홍길금', '010-4321-4321', 'C');
INSERT INTO tbl_member VALUES('id4', '1234', '홍길순', '010-8765-8765', 'A');
INSERT INTO tbl_board VALUES(1, 'test', 'test content', SYSDATE, 'id1');
INSERT INTO tbl_board VALUES(2, 'test', 'test content', SYSDATE, 'id2');
INSERT INTO tbl_board VALUES(3, 'test', 'test content', SYSDATE, 'id3');
INSERT INTO tbl_board VALUES(4, 'test', 'test content', SYSDATE, 'id4');
INSERT INTO tbl_board VALUES(5, 'test', 'test content', SYSDATE, 'id1');
INSERT INTO tbl_board VALUES(6, 'test', 'test content', SYSDATE, 'id2');
INSERT INTO tbl_board VALUES(7, 'test', 'test content', SYSDATE, 'id3');
INSERT INTO tbl_board VALUES(8, 'test', 'test content', SYSDATE, 'id3');
INSERT INTO tbl_board VALUES(9, 'test', 'test content', SYSDATE, 'id4');

SELECT bno, title, content, regdate, id
FROM (SELECT tbl_member.*, tbl_board.*
    FROM tbl_member, tbl_board
    WHERE tbl_member.id = tbl_board.writer);
    
select * from tbl_member;
delete from tbl_member where id = 'id5'; 
delete from tbl_board where writer = 'id5';
delete from tbl_board where bno = 10;

commit;