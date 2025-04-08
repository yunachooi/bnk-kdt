CREATE TABLE dept(
    deptno CHAR(2) PRIMARY KEY,
    dname VARCHAR2(14),
    loc VARCHAR2(13)
);

CREATE TABLE salgrade(
    grade CHAR(2) PRIMARY KEY,
    losal NUMBER(7),
    hisal NUMBER(7)
);

CREATE TABLE emp(
    empno CHAR(3) PRIMARY KEY,
    ename VARCHAR2(30),
    job VARCHAR2(20),
    mgr CHAR(4),
    hiredate DATE,
    sal NUMBER(7),
    comm NUMBER(7),
    deptno CHAR(2)
);