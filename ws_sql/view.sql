--VIEW
--이미 저장되어있는 테이블(물리적인 테이블)을 가지고 논리적 테이블 생성
--보안성이 높아지며, 쿼리가 간단
--GRANT CREATE VIEW TO green; 권한 부여 필요
--REVOKE CREATE VIEW FROM green; 권한 부여 해제
CREATE VIEW v_student AS SELECT * FROM student;
CREATE VIEW v_book2 AS SELECT * FROM book;

--학생, 과목, 수강테이블을 조인하여 새로운 뷰 생성 후 점수가 60점이 넘는 학생들을 조회하시오.
CREATE VIEW stu_sub
AS SELECT student.stu_no, stu_name, subject.sub_no, sub_name, enr_grade
FROM student, subject, enrol WHERE student.stu_no = enrol.stu_no AND subject.sub_no = enrol.sub_no;

SELECT * FROM stu_sub WHERE enr_grade >= 60;

SELECT * FROM student1;
INSERT INTO student1 VALUES(20250417, '홍길동', '기계', 1, 'C', 'M', 190, 90);

SAVEPOINT sp1;

INSERT INTO student1 VALUES(20250418, '임꺽정', '기계', 1, 'C', 'M', 160, 90);

SAVEPOINT sp2;

INSERT INTO student1 VALUES(20250418, 'james', '기계', 2, 'C', 'M', 170, 80);

ROLLBACK; --INSERT 하기 이전으로 돌아감.
ROLLBACK TO sp2; --SAVEPOINT sp2 하기 이전으로 돌아감. 












