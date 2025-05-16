CREATE TABLE tbl_exam_member(
    e_number VARCHAR2(10) PRIMARY KEY,
    e_name VARCHAR2(10)
);

CREATE TABLE tbl_exam_response(
    e_number VARCHAR2(10),
    q_number NUMBER,
    answer NUMBER,
    PRIMARY KEY (e_number, q_number),
    FOREIGN KEY (e_number) REFERENCES tbl_exam_member(e_number)
);

CREATE TABLE tbl_correct_answer(
    subject_number VARCHAR2(10),
    q_number NUMBER,
    correct_answer NUMBER,
    PRIMARY KEY (subject_number, q_number)
);

INSERT INTO tbl_exam_member VALUES('E001', '홍길동');
INSERT INTO tbl_exam_member VALUES('E002', '홍길순');

INSERT INTO tbl_correct_answer VALUES('S001', 1, 2);
INSERT INTO tbl_correct_answer VALUES('S001', 2, 1);
INSERT INTO tbl_correct_answer VALUES('S001', 3, 2);
INSERT INTO tbl_correct_answer VALUES('S001', 4, 1);
INSERT INTO tbl_correct_answer VALUES('S001', 5, 3);

commit;