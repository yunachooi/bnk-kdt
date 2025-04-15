--CROSS JOIN
--두 개 이상의 테이블을 조건 없이 합치는 연산 수행.
SELECT student.*, enrol.* FROM student CROSS JOIN enrol;

--EQIT JOIN
--두 개 이상의 테이블에 관련 있는 공통 열의 값을 이용하여 논리적으로 결합하는 연산 수행.
--WHERE절에서 '=' 사용.
SELECT student.stu_no, stu_name, stu_dept, enr_grade FROM student, enrol WHERE student.stu_no = enrol.stu_no;
SELECT s.stu_no, stu_dept, enr_grade FROM student s, enrol e WHERE s.stu_no = e.stu_no;

--NATURAL JOIN
--공통된 열이 하나만 있을 경우에는 사용 가능하지만, 여러 개 일 경우에는 위의 EQIT JOIN을 사용하는 것이 더 바람직.
SELECT stu_no, stu_name, stu_dept, enr_grade FROM student NATURAL JOIN enrol;
--공통된 열이 두 개 이상일 경우 - JOIN ~ USING
SELECT stu_no, stu_name, stu_dept, enr_grade FROM student JOIN enrol USING(stu_no);

--JOIN ~ ON
SELECT student.stu_no, stu_name, stu_dept, enr_grade FROM student JOIN enrol ON student.stu_no = enrol.stu_no;

--101번 과목을 수강하는 학생들의 학번과 이름을 검색하시오.
SELECT student.stu_no, stu_name FROM student, enrol WHERE student.stu_no = enrol.stu_no AND sub_no = 101;
SELECT stu_no, stu_name FROM student NATURAL JOIN enrol WHERE sub_no = 101;
SELECT stu_no, stu_name FROM student JOIN enrol USING(stu_no) WHERE sub_no = 101;
SELECT student.stu_no, stu_name FROM student JOIN enrol ON student.stu_no = enrol.stu_no AND sub_no = 101;
SELECT stu_no, stu_name FROM student WHERE stu_no IN(SELECT stu_no FROM enrol WHERE sub_no = 101);

--101번 또는 102번 과목을 수강하는 학생들의 학번과 이름을 검색하시오.
SELECT student.stu_no, stu_name FROM student, enrol WHERE student.stu_no = enrol.stu_no AND sub_no IN(101, 102);
SELECT stu_no, stu_name FROM student NATURAL JOIN enrol WHERE sub_no IN(101, 102);
SELECT stu_no, stu_name FROM student JOIN enrol USING(stu_no) WHERE sub_no IN(101, 102);
SELECT student.stu_no, stu_name FROM student JOIN enrol ON student.stu_no = enrol.stu_no AND sub_no IN(101, 102);

--'컴퓨터개론'과목을 수강하는 학생들의 학번, 이름, 과목이름을 검색하시오.
SELECT student.stu_no, stu_name, sub_name FROM student, subject, enrol
WHERE student.stu_no = enrol.stu_no AND subject.sub_no = enrol.sub_no AND sub_name = '컴퓨터개론';

--NON-EQIT JOIN
--'='연산자를 사용하지 않는다.
--기본키와 외래키 관계가 아닌 열 값들의 의미있는 관계로 조인하는 경우임.
--인사관리 DB에서 사원테이블(emp)의 급여(sal) 열 값이 급여테이블의 하위급여(losal)와 상위급여(hisal) 사이에 사원의 급여 등급을 경정하는 질의문
SELECT empno, ename, sal, grade FROM emp, salgrade WHERE sal BETWEEN losal AND hisal;

--SELF JOIN
--자기 자신 테이블과의 조인
--사원의 상급자사원을 구하는 질의문
SELECT a.empno AS 사원번호, a.ename AS 사원이름, b.empno AS 상급자사원번호, b.ename AS 상급자이름 
FROM emp a, emp b 
WHERE a.mgr = b.empno;

--OUTER JOIN
--조인 조건을 만족하지 않는 행들도 결과에 포함시키기 위한 조인
SELECT enrol.*, sub_name FROM enrol, subject WHERE enrol.sub_no = subject.sub_no; --왼쪽에 없는 값이 오른 쪽에는 있을 경우
SELECT enrol.*, sub_name FROM enrol RIGHT OUTER JOIN subject ON enrol.sub_no = subject.sub_no; --RIGHT OUTER JOIN 사용
SELECT enrol.*, sub_name FROM enrol LEFT OUTER JOIN subject ON enrol.sub_no = subject.sub_no;
--KING이 나오지 않는 문제점을 해결.
SELECT a.empno AS 사원번호, a.ename AS 사원이름, b.empno AS 상급자사원번호, b.ename AS 상급자이름
FROM emp a LEFT OUTER JOIN emp b 
ON a.mgr = b.empno;

CREATE TABLE a_student AS SELECT * FROM student WHERE stu_dept IN('기계', '전기전자');
CREATE TABLE b_student AS SELECT * FROM student WHERE stu_dept IN('전기전자', '컴퓨터정보');

--집합 연산자
--UNION : 두 질의 결과값의 합. 중복값 없음.
SELECT * FROM a_student UNION SELECT * FROM b_student;
--UNION ALL : 두 질의 결과값의 합. 중복 포함.
SELECT * FROM a_student UNION ALL SELECT * FROM b_student;
--INTERSECT : 두 질의 결과 공통되는 값(교집합)
SELECT * FROM a_student INTERSECT SELECT * FROM b_student;
--MINUS : 첫 번째 질의 결과에서 두 번째 질의 결과에 있는 행을 제거함(차집합)
SELECT * FROM a_student MINUS SELECT * FROM b_student;

--부질의(subQuery)
--SELECT문 안에 또 다른 SELECT 문을 포함시킨 것을 서브쿼리라고 한다.
--'옥성우' 학생보다 신장이 큰 학생들의 학번, 이름, 신장을 구하시오.
SELECT stu_no, stu_name, stu_height FROM student WHERE stu_height > (SELECT stu_height FROM student WHERE stu_name = '옥성우');

SELECT a.stu_no, a.stu_name, a.stu_height 
FROM student a, student b
WHERE a.stu_height > b.stu_height AND b.stu_name = '옥성우';

--학생테이블에서 '박희철' 학생과 같은 체중인 학생의 정보를 구하시오.
SELECT * FROM student WHERE stu_weight = (SELECT stu_weight FROM student WHERE stu_name = '박희철')
AND stu_name <> '박희철';

--학생테이블에서 '컴퓨터정보'학과와 같은 반인 다른 학과의 학생 정보를 구하시오.
SELECT * FROM student WHERE stu_class IN('A', 'B', 'C') AND stu_dept <> '컴퓨터정보';
SELECT * FROM student WHERE stu_class IN(SELECT stu_class FROM student WHERE stu_dept = '컴퓨터정보') 
AND stu_dept <> '컴퓨터정보';

--전체학생들의 평균 신장보다 큰 학생을 구하시오.
SELECT * FROM student WHERE stu_height > (SELECT AVG(stu_height) FROM student);

--모든 학과들의 평균 신장 중 가장 큰 학생의 키를 구하시오.
SELECT MAX(AVG(stu_height)) FROM student GROUP BY stu_dept;

--컴퓨터정보과의 최소 신장과 비교하여 최소 신장이 더 큰 학과의 학과명과 최소 신장을 구하시오.
SELECT stu_dept, MIN(stu_height) FROM student GROUP BY stu_dept HAVING MIN(stu_height) > 
(SELECT MIN(stu_height) FROM student GROUP BY stu_dept HAVING stu_dept = '컴퓨터정보');

--101번 과목을 수강한 학생들의 학번, 이름, 점수를 구하시오.
SELECT student.stu_no, stu_name, enr_grade FROM student, enrol WHERE student.stu_no = enrol.stu_no AND sub_no = 101;

--학과별 평균 신장보다 큰 학생의 정보를 구하시오.
SELECT * FROM student WHERE stu_height > (SELECT AVG(AVG(stu_height)) FROM student GROUP BY stu_dept);







