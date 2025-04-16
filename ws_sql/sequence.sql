--SEQUENCE
--자동으로 증가하는 숫자 생성.

CREATE SEQUENCE seq_test
START WITH 1 --처음 시각할 숫자
INCREMENT BY 1 --증가할 값
MINVALUE 1 --최소값
--MAXVALUE 10 --최대값
--CYCLE --최대값 도달 시 순환여부(NOCYCLE, CYCLE)
NOCACHE; --시퀀스번호 캐시할 지 여부

SELECT seq_test.NEXTVAL FROM dual; --1부터 10까지 반복되며, 10 다음 숫자는 1이 나옴. 호출 시 하나씩 증가됨.
SELECT seq_test.CURRVAL FROM dual; --NEXTVAL을 확인해야할 필요가 있을 경우 사용. 호출된 값이 출력.

CREATE TABLE t2(
    tno NUMBER PRIMARY KEY,
    tname VARCHAR2(20)
);

INSERT INTO t2(tno, tname) VALUES (seq_test.NEXTVAL, 'test2');

CREATE TABLE t2_cpy AS SELECT * FROM t2 WHERE tno = 1;

--두 개의 테이블 병합
MERGE INTO t2_cpy
    USING t2 ON (t2.tno = t2_cpy.tno)
WHEN MATCHED THEN
    UPDATE SET t2_cpy.tname = t2.tname
WHEN NOT MATCHED THEN
    INSERT VALUES (t2.tno, t2.tname);

UPDATE t2 SET tname = 'test1' WHERE tno = 1;

SELECT * FROM T2 ORDER BY tno;

--ROCKING
--명령프롬프트 상에서는 COMMIT이 자동으로되지 않음.
--따라서 동시에 같은 기본키에 접근하게 될 경우 '무결성제약조건'에 위배되는 경우가 발생.
--이를 해결하기 위하여
--SELECT * FROM t2 WHERE tno = 1 FOR UPDATE.
--위의 명령어로 업데이트를 할 예정이라는 것을 다른 명령프롬프트 들에게 알리는 역할을 수행.
--해당 명령프롬프트 내에서 업무를 마쳤을 경우 COMMIT을 해서 업무가 끝났음을 다른 명령프롬프트 들에게 알림.

--무결성 제약조건 위배 케이스
CREATE TABLE parent(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100)
);

CREATE TABLE child(
    id NUMBER PRIMARY KEY,
    parent_id NUMBER,
    CONSTRAINT fk_parent FOREIGN KEY (parent_id)
    REFERENCES parent(id)
    ON DELETE CASCADE --를 사용하므로서 DELETE 할 때 위배되는 제약 조건을 해결.
);

INSERT INTO child VALUES (1, 1); --parent 테이블에 데이터가 없어서 위배됨.
INSERT INTO parent VALUES(1, 'parent');


DELETE FROM parent WHERE id = 1; --child 테이블에 자식 레코드가 있어서 위배됨.
DELETE FROM child WHERE parent_id = 1;

DROP TABLE parent; --외래 키에 의해 참조되는 고유/기본 키가 테이블에 있어서 위배됨.
DROP TABLE child;

COMMIT;






