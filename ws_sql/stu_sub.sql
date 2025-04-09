CREATE TABLE student(
    stu_no CHAR(9) PRIMARY KEY,
    stu_name VARCHAR2(30),
    stu_dept VARCHAR2(20),
    stu_grade NUMBER(1),
    stu_class CHAR(1),
    stu_gender CHAR(1),
    stu_height NUMBER(5,2),
    stu_weight NUMBER(5,2)
);

CREATE TABLE subject(
    sub_no CHAR(3) PRIMARY KEY,
    sub_name VARCHAR2(30),
    sub_prof VARCHAR2(20),
    sub_grade NUMBER(1),
    sub_dept VARCHAR2(20)
);

CREATE TABLE enrol(
    sub_no CHAR(3),
    stu_no CHAR(9),
    enr_grade NUMBER(3),
    CONSTRAINT p_course PRIMARY KEY(sub_no, stu_no)
);

INSERT INTO student VALUES (20153075, '옥한빛', '기계', 1, 'C', 'M', 177, 80);
INSERT INTO student VALUES (20153088, '이태연', '기계', 1, 'C', 'F', 162, 50);
INSERT INTO student VALUES (20143054, '유가인', '기계', 2, 'C', 'F', 154, 47);
INSERT INTO student VALUES (20152088, '조민우', '전기전자', 1, 'C', 'M', 188, 90);
INSERT INTO student VALUES (20142021, '심수정', '전기전자', 2, 'A', 'F', 168, 45);
INSERT INTO student VALUES (20132003, '박희철', '전기전자', 3, 'B', 'M', NULL, 63);
INSERT INTO student VALUES (20151062, '김민중', '컴퓨터정보', 1, 'B', 'M', 166, 67);
INSERT INTO student VALUES (20141007, '전현무', '컴퓨터정보', 2, 'A', 'M', 174, 64);
INSERT INTO student VALUES (20131001, '김종현', '컴퓨터정보', 3, 'C', 'M', NULL, 72);
INSERT INTO student VALUES (20131025, '옥성우', '컴퓨터정보', 3, 'A', 'F', 172, 63);

SELECT * FROM student;

INSERT INTO subject VALUES ('111', '데이터베이스', '이재영', 2, '컴퓨터정보');
INSERT INTO subject VALUES ('110', '자동제어', '정순정', 2, '전기전자');
INSERT INTO subject VALUES ('109', '자동화설계', '박민영', 3, '기계');
INSERT INTO subject VALUES ('101', '컴퓨터개론', '김종영', 3, '컴퓨터정보');
INSERT INTO subject VALUES ('102', '기계공작법', '김태영', 1, '기계');
INSERT INTO subject VALUES ('103', '기초전자실험', '김유석', 1, '전기전자');
INSERT INTO subject VALUES ('104', '시스템분석설계', '김석현', 3, '컴퓨터정보');
INSERT INTO subject VALUES ('105', '기계요소설계', '김명성', 1, '기계');
INSERT INTO subject VALUES ('106', '전자회로실험', '최영민', 3, '전기전자');
INSERT INTO subject VALUES ('107', 'CAD응용실습', '구봉규', 2, '기계');
INSERT INTO subject VALUES ('108', '소프트웨어공학', '권민성', 1, '컴퓨터정보');

SELECT * FROM subject;

INSERT INTO enrol VALUES ('101', '20131001', 80);
INSERT INTO enrol VALUES ('104', '20131001', 56);
INSERT INTO enrol VALUES ('106', '20132003', 72);
INSERT INTO enrol VALUES ('103', '20152088', 45);
INSERT INTO enrol VALUES ('101', '20131025', 65);
INSERT INTO enrol VALUES ('104', '20131025', 65);
INSERT INTO enrol VALUES ('108', '20151062', 81);
INSERT INTO enrol VALUES ('107', '20143054', 41);
INSERT INTO enrol VALUES ('102', '20153075', 66);
INSERT INTO enrol VALUES ('105', '20153075', 56);
INSERT INTO enrol VALUES ('102', '20153088', 61);
INSERT INTO enrol VALUES ('105', '20153088', 78);

SELECT * FROM enrol;

---------------------------------------
--1.학생 테이블의 구조를 확인하시오.
DESCRIBE student;

--2.과목 테이블의 구조를 확인하시오.
DESC subject;

--3.수강 테이블의 구조를 확인하시오.
DESC enrol;

--4.학생 테이블의 학번, 학생 이름을 조회하시오.
SELECT stu_no, stu_name FROM student;

--5.학생 테이블에서 학과를 중복데이터 없이 조회하시오.
SELECT DISTINCT stu_dept FROM student;

--6.학생 테이블에서 학년과 반을 중복데이터 없이 조회하시오.
SELECT DISTINCT stu_grade, stu_class FROM student;

--7.수강 테이블에서 학번, 과목번호, 점수 기존 점수에 10을 더한 점수를 조회하시오.
SELECT stu_no, sub_no, enr_grade, enr_grade + 10 FROM enrol;

--8.수강 테이블에서 학번, 과목번호, 점수 기존 점수에 10을 더한 점수를 조회하시오.
--이때, 기존 점수에 10을 더한 점수의 열 제목은 plus10으로 하시오. (별칭 사용 : ALIAS)
SELECT stu_no, sub_no, enr_grade, enr_grade + 10 AS plus10 FROM enrol;

-- 연결연산자 사용 : 두 개이상의 열을 함쳐서 조회할 수 있음.
SELECT stu_dept || stu_name AS 학과성명 FROM student;
SELECT stu_dept || ',' || stu_name || '입니다.' AS 학과성명 FROM student;

-- WHERE절 사용하기
--9.학과가 '컴퓨터정보'인 학생의 이름, 학과, 학년, 반 정보를 조회하시오.
SELECT stu_name, stu_dept, stu_grade, stu_class FROM student WHERE stu_dept = '컴퓨터정보';

--10.학과가 '컴퓨터정보'가 아닌 학생의 이름, 학과, 학년, 반 정보를 조회하시오.
SELECT stu_name, stu_dept, stu_grade, stu_class FROM student WHERE stu_dept != '컴퓨터정보';
SELECT stu_name, stu_dept, stu_grade, stu_class FROM student WHERE stu_dept <> '컴퓨터정보';
SELECT stu_name, stu_dept, stu_grade, stu_class FROM student WHERE stu_dept ^= '컴퓨터정보';

--11.학과가 '컴퓨터정보'이고, 2학년인 학생의 모든 정보를 조회하시오.
SELECT * FROM student WHERE stu_dept = '컴퓨터정보' AND stu_grade = 2;

--12.1, 2학년 학생의 모든 정보를 조회하시오.
SELECT * FROM student WHERE stu_grade = 1 OR stu_grade = 2;

--13.체중이 60이상 70이하인 학생의 이름과 학과, 학년을 조회하시오.
SELECT stu_name, stu_dept, stu_grade FROM student WHERE stu_weight >= 60 AND stu_weight <= 70;
SELECT stu_name, stu_dept, stu_grade FROM student WHERE stu_weight BETWEEN 60 AND 70;

--14.키가 170 이상인 학생의 이름과 학번, 학년을 조회하시오.
SELECT stu_name, stu_dept, stu_grade FROM student WHERE stu_height >= 170;

--15.키가 170 이상인 학생의 수를 조회하시오.
SELECT COUNT(stu_no) FROM student WHERE stu_height >= 170;

-- LIKE를 이용한 검색
-- LIKE와 함께 쓰이는 기호(와일드카드) %, _(언더바)
--16.학생 중 성이 김씨인 학생들의 정보를 검색하시오.
SELECT * FROM student WHERE stu_name LIKE '김%';

--17.학생 중 이름의 두 번째 글자가 '수'인 학생의 이름을 검색하시오.
SELECT * FROM student WHERE stu_name LIKE '_수%';

--18.학생 중 이름이 '우'로 끝나는 학생의 수가 몇 명인지 검색하시오.
SELECT COUNT(*) FROM student WHERE stu_name LIKE '%우';

--19.학번이 2014번인 학생의 정보를 조회하시오.
SELECT * FROM student WHERE stu_no LIKE '2014%';

--20.NULL 확인
SELECT stu_no, stu_name, stu_height FROM student;

--21.학생정보 중 키 값이 없는 학생의 학번, 이름, 키를 조회하시오.
SELECT stu_no, stu_name, stu_height FROM student WHERE stu_height IS NULL;

--22.학생정보 중 키 값이 있는 학생의 학번, 이름, 키를 조회하시오.
SELECT stu_no, stu_name, stu_height FROM student WHERE stu_height IS NOT NULL;

--23.학과가 '컴퓨터정보'이거나 '기계'과인 학생의 학번과 이름, 학과을 검색하시오.
SELECT stu_no, stu_name, stu_dept FROM student WHERE stu_dept = '컴퓨터정보' OR stu_dept = '기계';
SELECT stu_no, stu_name, stu_dept FROM student WHERE stu_dept IN('컴퓨터정보', '기계');

-- 정렬하기(오름차순, 내림차순)
-- 오름차순 : ASC (기본)
-- 내림차순 : DESC
SELECT * FROM student ORDER BY stu_no DESC;
SELECT stu_no, stu_name, stu_dept, stu_weight-5 AS target FROM student ORDER BY stu_dept, target DESC;

--24.남학생의 이름, 학과, 학년을 조회하시오.
SELECT stu_name, stu_dept, stu_grade FROM student WHERE stu_gender = 'M';

--25.학생들의 이름과 현재 체중, 그리고 현재 체중에 5를 더한 체중값을 조회하시오.
-- 이 때, 별칭은 'plus5'로 하시오.
SELECT stu_name, stu_dept, stu_grade, stu_weight+5 AS plus5 FROM student WHERE stu_gender = 'M';

--26.수강 테이블의 모든 정보를 검색하시오. 이 때, 별칭을 한글로 부여하여 검색하시오.
SELECT sub_no AS 과목번호, stu_no AS 학번, enr_grade AS 점수 FROM enrol;

--27.학생의 이름과 학과를 '컴퓨터정보과 옥한빛입니다.' 식으로 검색하시오.
SELECT stu_dept || '과 ' || stu_name || '입니다.' AS 이름학과 FROM student;

--28.'전기전자'과 이외 학생들의 모든 정보를 검색하시오.
SELECT * FROM student WHERE stu_dept <> '전기전자';

--29.'기계'과 이면서 2학년인 학생들의 모든 정보를 검색하시오.
SELECT * FROM student WHERE stu_dept = '기계' AND stu_grade = 2;

--30.여학생 중 체중이 60이하인 학생을 모두 검색하시오.
SELECT * FROM student WHERE stu_gender = 'F' AND stu_weight <= 60;

--31.키가 160이상이며, 170이하인 학생의 학번과 이름을 검색하시오.
SELECT stu_no, stu_name FROM student WHERE stu_height BETWEEN 160 AND 170;

--32.이름의 '옥'이 들어있는 학생의 이름을 검색하시오.
SELECT stu_name FROM student WHERE stu_name LIKE '%옥%';

--33.키가 NULL인 학생의 이름을 검색하시오.
SELECT stu_name FROM student WHERE stu_height IS NULL;

--34.키가 NULL이 아닌 학생의 이름을 검색하시오.
SELECT stu_name FROM student WHERE stu_height IS NOT NULL;

--35.학번이 'XXXX20XX'인 학생의 모든 정보를 검색하시오.
SELECT * FROM student WHERE stu_no LIKE '____20%';

--36.학번이 2014인 학생들을 이름 순으로 조회하시오(오름차순)
SELECT * FROM student WHERE stu_no LIKE '2014%' ORDER BY stu_name;

--37.학과정보를 이름을 기준으로 내림차순으로 검색하시오.
SELECT stu_dept FROM student ORDER BY stu_name DESC;

--그룹(집계 함수와 함께 사용됨.)
--MAX, MIN
SELECT MAX(stu_height) FROM student;
SELECT MIN(stu_height) FROM student;

--SUM
SELECT SUM(enr_grade) FROM enrol;

--COUNT
SELECT COUNT(*), COUNT(stu_height) FROM student;

--GROUP BY
--38.학생테이블에서 학과별 몸무게 평균을 구하시오.
SELECT stu_dept, AVG(stu_weight) FROM student GROUP BY stu_dept;

--39.학생테이블에서 체중이 50이상인 학생들의 학과별 인원수를 구하시오.
SELECT stu_dept, COUNT(*) FROM student WHERE stu_weight >= 50 GROUP BY stu_dept;

--40.학생테이블에서 학과별, 학년별 인원수를 구하시오.
SELECT stu_dept, stu_grade, COUNT(*) FROM student GROUP BY stu_dept, stu_grade ORDER BY stu_dept;

--41.'기계'과 학생들 중에 학년별 평균 신장이 160이상인 학년과 평균 신장을 구하시오.
SELECT stu_grade, AVG(stu_height) FROM student WHERE stu_dept = '기계' GROUP BY stu_grade HAVING AVG(stu_height) >= 160;

--42.최대 신장이 175이상인 학과들을 구하고 학과별 최대 신장을 구하시오.
SELECT stu_dept, MAX(stu_height) FROM student GROUP BY stu_dept HAVING MAX(stu_height) >= 175;

--43.학과별 평균 신장 중 가장 높은 평균 신장을 구하시오.
SELECT to_char(MAX(AVG(stu_height)), '999.99') FROM student GROUP BY stu_dept;























