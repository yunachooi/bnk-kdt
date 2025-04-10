CREATE TABLE professor(
    pno VARCHAR2(4) PRIMARY KEY,
    pname VARCHAR2(15),
    phone VARCHAR2(8)
);

CREATE TABLE subject2(
    sno VARCHAR2(4) PRIMARY KEY,
    sname VARCHAR2(30),
    sday VARCHAR2(10),
    stime VARCHAR(10),
    pno VARCHAR(4),
    FOREIGN KEY(pno) REFERENCES professor(pno)
);

INSERT INTO professor VALUES ('101', '김교수', '010-1234');
INSERT INTO professor VALUES ('102', '이교수', '010-5678');
INSERT INTO professor VALUES ('103', '최교수', '010-4321');
INSERT INTO subject2 VALUES ('C101', '데이터베이스', '월요일', '10시', '101');
INSERT INTO subject2 VALUES ('C102', '운영체제', '화요일', '13시', '102');
INSERT INTO subject2 VALUES ('C103', '데이터베이스', '수요일', '14시', '103');

SELECT sno, sname, pname, phone, sday, stime 
FROM (SELECT subject2.*, professor.*
    FROM subject2, professor
    WHERE subject2.pno = professor.pno);
    
    
    
    