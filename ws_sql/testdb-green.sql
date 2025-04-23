CREATE TABLE t_member(
    id VARCHAR2(10) PRIMARY KEY,
    pw VARCHAR2(10),
    name VARCHAR2(10),
    grade VARCHAR2(10)
);

SELECT * FROM T_MEMBER;
DESC T_MEMBER;

DROP TABLE T_MEMBER;

commit;

INSERT INTO t_member VALUES ('aaa', 'bbb', 'ccc', 'ddd');