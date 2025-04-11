--기존 테이블을 활용하여 새로운 테이블 생성
CREATE TABLE t_student AS SELECT * FROM student WHERE stu_dept = '기계';

DESC t_student; --구조는 기존 테이블과 동일
SELECT * FROM t_student; --'기계'과 학생들만 추출

--테이블에 새로운 열 추가(DDL: 테이블의 구조를 변경 - 기본 값은 NULL)
ALTER TABLE t_student ADD (army CHAR(1));
ALTER TABLE t_student ADD (age NUMBER(3) DEFAULT 20);

--테이블에 열 삭제
ALTER TABLE t_student DROP COLUMN age;
ALTER TABLE t_student DROP (army);

--'이태연'학생의 나이를 22살, '유가인'학생의 나이를 25살로 변경
UPDATE t_student SET age = 22 WHERE stu_name = '이태연';
UPDATE t_student SET age = 25 WHERE stu_name = '유가인';

--테이블 이름 변경
RENAME t_student TO test_student;
SELECT * FROM test_student; --기존 테이블이 삭제되고, 새로운 이름의 테이블로 변경된 것을 확인.

--테이블 내 데이터 삭제
--DDL로 작업하면 커밋을 하지 않아도 DB에 영구적으로 저장 가능
--DML은 커밋을 해야만 DB에 반영
--DML에서 커밋을 하지 않아도 DDL 명령어를 실행하면 자동으로 커밋
DELETE FROM test_student;
TRUNCATE TABLE test_student; --테이블이 잘렸습니다.
ROLLBACK; --DELETE(DML)를 사용할 경우 복원이 가능하지만, TRUNCATE(DDL)을 사용하게 될 경우 복원이 불가능함.


---------------------------
--제약조건
--데이터 무결성을 위배하지 않기 위함
--데이터베이스 상태(인스턴스, 객체, 테이블)가 항상 만족해야할 기본 규칙.
--해당 열의 규칙이 부여됨. (열에 제약조건)
CREATE TABLE member(
    mno NUMBER PRIMARY KEY, --PRIMARY KEY: 식별해야하는 키로 유일해야하며, NULL값이면 안됨 (UNIQUE + NOT NULL).
    moblic CHAR(13) UNIQUE, --NULL가능, 중복 불가, UNIQUE NOT NULL으로 할 경우 NULL불가능
    gender CHAR(1) CHECK(gender IN('M', 'F')), --남자:M 여자:F로만 들어오게 제약, NULL가능
    hobby VARCHAR2(30) NOT NULL --반드시 입력(NULL 값 불가)
);

INSERT INTO member VALUES(101, NULL, NULL, 'baseball');
INSERT INTO member VALUES(102, '010-0000-0000', NULL, 'saccer');
INSERT INTO member VALUES(103, NULL, 'M', 'swimming');
INSERT INTO member VALUES(104, '010-1111-1111', 'M', 'baseball');

SELECT * FROM member;

--제약조건을 일시적으로 해제
ALTER TABLE member DISABLE CONSTRAINT SYS_C007594;
INSERT INTO member VALUES(105, '010-2222-2222', 'M', NULL);
ALTER TABLE member ENABLE CONSTRAINT SYS_C007594; --해제했을 때 데이터를 삭제하지 않으면 실행 불가






