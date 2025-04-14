--1.부서번호가 20, 30인 자료들로 emp1 테이블을 만드시오.
CREATE TABLE emp1 AS SELECT * FROM emp WHERE deptno IN(20, 30);

--2.dept 테이블을 바탕으로 dept1 테이블을 만드시오.
CREATE TABLE dept1 AS SELECT * FROM dept;

--3.salgrade테이블을 바탕으로 salgrade1 테이블을 만드시오.
CREATE TABLE salgrade1 AS SELECT * FROM salgrade;

--4.사원번호 7703, 사원이름 JOSH, 사원직무 SALESMAN, 상급자사원번호 7566, 급여 1400, 커미션 0, 부서번호 20인 사원이 오늘 입사하였다.
INSERT INTO emp1 VALUES(7703, 'JOSH', 'SALESMAN', 7566, TO_DATE('14-04-2025', 'dd-mm-yyyy'), 1400, 0, 20);

--5.사원번호 7401, 사원이름 HOMER, 급여 1300, 부서번호 10인 사원이 입사하였다.
INSERT INTO emp1 VALUES(7401, 'HOMER', NULL, NULL, TO_DATE('14-04-2025', 'dd-mm-yyyy'), 1300, NULL, 10);

--6.사원번호 7323, 사원이름 BRANDA, 부서번호 30, 사원번호 7499와 동일한 급여를 받는 사원이 입사하였다.
INSERT INTO emp1 VALUES(7323, 'BRANDA', NULL, NULL, TO_DATE('14-04-2025', 'dd-mm-yyyy'), 1300, NULL, 30);

--7.사원(emp)테이블에서 부서번호가 10인 데이터를 emp1테이블에 삽입하시오.
INSERT INTO emp1 SELECT * FROM emp WHERE deptno = 10;

--8.사원번호 7369의 사원직무를 ALALYST로 바꾸시오.
UPDATE emp1 SET job = 'ALALYST' WHERE empno = 7369;

--9. 부서번호 20인 직원들의 급여를 10% 감하시오.
UPDATE emp1 SET sal = sal * 0.9 WHERE deptno = 20;

--10.모든 사원의 급여를 100 증가시키시오.
UPDATE emp1 SET sal = sal + 100;

--11.사원번호 7902의 상급자사원번호를 7654, 부서번호를 30으로 바꾸시오.
UPDATE emp1 SET mgr = 7654, deptno = 30 WHERE empno = 7902;

--12.지역이 DALLAS인 사원들의 급여를 10 감하시오.
UPDATE emp1 SET sal = sal - 10 WHERE deptno = (SELECT deptno FROM dept1 WHERE loc = 'DALLAS');

--13.급여등급이 2인 사원들의 급여를 20 감하시오.
UPDATE emp1 SET sal = sal - 20 WHERE sal >= (SELECT losal FROM salgrade WHERE grade = 2) 
    OR sal <= (SELECT hisal FROM salgrade WHERE grade = 2);

--14.사원번호 7499가 퇴사하였다.
DELETE FROM emp1 WHERE empno = 7499;

--15.부서번호 50, 부서이름 'PLANNING', 지역 'MIAMI'가 추가되었다.
INSERT INTO dept1 VALUES(50, 'PLANNING', 'MIAMI');

--16.부서번호가 40인 부서가 60으로 변경되었다.
UPDATE dept1 SET deptno = 60 WHERE deptno = 40;

--17.부서번호가 30인 부서가 폐쇄되었다.
DELETE FROM dept1 WHERE deptno = 30;

--18.dept1 테이블이 없는 부서번호들을 갖고 있는 사원들의 부서번호를 99로 변경하시오.
UPDATE emp1 SET deptno = 99 WHERE deptno NOT IN(SELECT deptno FROM dept1);

--19.emp1에서 99번 부서번호를 삭제하시오.
DELETE FROM emp1 WHERE deptno = 99;

--20.상급자사원번호가 없는 사원의 급여를 100 올렸다.
UPDATE emp1 SET sal = sal + 100 WHERE mgr IS NULL;

--21.JONES, JOSH, CLATK가 30번 부서로 바뀌었다.
UPDATE emp1 SET deptno = 30 WHERE ename = 'JONES' OR ename = 'JOSH' OR ename = 'CLATK';

--22.커미션이 NULL인 데이터를 0으로 바꾸시오.
UPDATE emp1 SET comm = 0 WHERE comm IS NULL;

--23.emp1 전체 테이블의 데이터를 삭제하시오.
DELETE FROM emp1;