CREATE TABLE members(
    mno VARCHAR2(3) PRIMARY KEY,
    mname VARCHAR2(20),
    mphone VARCHAR2(8)
);

CREATE TABLE book(
    bno VARCHAR2(3) PRIMARY KEY,
    title VARCHAR2(50),
    author VARCHAR2(20)
);

CREATE TABLE loaninfo(
    lno VARCHAR2(3) PRIMARY KEY,
    lreturn DATE,
    mno VARCHAR2(3),
    bno VARCHAR2(3),
    FOREIGN KEY(mno) REFERENCES members(mno),
    FOREIGN KEY(bno) REFERENCES book(bno)
);

INSERT INTO members VALUES ('101', '김철수', '010-1234');
INSERT INTO members VALUES ('102', '이영희', '010-5678');
INSERT INTO book VALUES ('201', '자바의 정석, 이펙티브 자바', '남궁민, 조슈아');
INSERT INTO book VALUES ('202', '클린코드', '로버트 마틴');
INSERT INTO loaninfo VALUES ('001', '2025-04-10', '101', '201');
INSERT INTO loaninfo VALUES ('002', '2025-04-12', '102', '202');

SELECT lno, mname, mphone, title, author, lreturn 
FROM (SELECT members.*, book.*, loaninfo.*
    FROM members, book, loaninfo
    WHERE members.mno = loaninfo.mno AND book.bno = loaninfo.bno);


