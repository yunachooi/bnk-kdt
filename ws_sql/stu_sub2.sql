--*1,2학년 학생정보로 student1 테이블을 생성하시오.
CREATE TABLE student1 AS SELECT * FROM student WHERE stu_grade IN(1, 2);

--*subject 테이블을 바탕으로 subject1 테이블을 생성하시오.
CREATE TABLE subject1 AS SELECT * FROM subject;

--*enrol 테이블을 바탕으로 enrol1 테이블을 생성하시오.
CREATE TABLE enrol1 AS SELECT * FROM enrol;

--1.학번 20101059, 이름 조병준, 학과 컴퓨터정보, 학년 1 반 B, 키 164, 몸무게 70인 남학생이 추가되었다.
INSERT INTO student1 VALUES(20101059, '조병준', '컴퓨터정보', 1, 'B', 'M', 164, 70);

--2.학번 20102038, 이름 남지선, 학과 전기전자, 학년 1, 반 C, 여학생이 추가되었다.
INSERT INTO student1 VALUES(20102038, '남지선', '전기전자', 1, 'C', 'F', NULL, NULL);

--3.학번 20103009, 이름 박소신, 학과 기계, 20153075 학생과 같은 학년, 반을 갖는 남학생이 추가되었다.
INSERT INTO student1 VALUES(20103009, '박소신', '기계', (SELECT stu_grade FROM student1 WHERE stu_no = 20153075), 
    (SELECT stu_class FROM student1 WHERE stu_no = 20153075), 'M', NULL, NULL);
    
--4.student1 테이블에 학생(student) 테이블의 3학년 학생들 데이터를 입력하시오.
INSERT INTO student1 SELECT * FROM student WHERE stu_grade = 3;

--5.학번 20131001 학생의 반을 B로 바꾸시오.
UPDATE student1 SET stu_class = 'B' WHERE stu_no = 20131001;

--6.20152088 학생의 키가 2cm 자랐다.
UPDATE student1 SET stu_height = stu_height + 2 WHERE stu_no = 20152088;

--7.모든 학생의 학년이 올랐다.
UPDATE student1 SET stu_grade = stu_grade + 1;

--8.20142021 학생의 학과를 컴퓨터정보로 바꾸시오.(단, 학번은 입학년도+학과코드+일련번호, 학과코드 1:컴퓨터정보, 2:전기전자, 3:기계)
UPDATE student1 SET stu_dept = '컴퓨터정보' WHERE stu_no = 20142021;

--9.전자회로실험 과목의 점수를 1점 감하시오.
UPDATE enrol1 SET enr_grade = enr_grade -1 WHERE sub_no = (SELECT sub_no FROM subject1 WHERE sub_name = '전자회로실험');

--10.20151062 학생이 소프트웨어공학 시험 중 부정행위로 0점이 되었다.
UPDATE enrol1 SET enr_grade = 0 WHERE stu_no = 20151062 AND sub_no = (SELECT sub_no FROM subject WHERE sub_name = '소프트웨어공학');

--11.20153088 학생이 자퇴하였다.
DELETE FROM student1 WHERE stu_no = 20153088;

--12.과목번호 112, 과목이름 자동화시스템, 교수명 고종민, 학년 3, 학과 기계를 추가하시오.
INSERT INTO subject1 VALUES(112, '자동화시스템', '고종민', 3, '기계');

--13.과목번호가 110에서 501로 변경되었다.
UPDATE subject1 SET sub_no = 501 WHERE sub_no = 110;

--14.과목번호 101이 폐강되었다.
DELETE FROM subject1 WHERE sub_no = 101;

--15.enrol1 테이블에서 subject1에 없는 과목번호를 999로 변경하시오.
UPDATE enrol1 SET sub_no = 999 WHERE sub_no NOT IN(SELECT sub_no FROM subject1);

--16.enrol1 테이블에서 student1에 없는 학번을 99999999로 변경하시오.
UPDATE enrol1 SET stu_no = 99999999 WHERE stu_no NOT IN(SELECT stu_no FROM student1);

--17.enrol1 테이블에서 과목번호 999를 삭제하시오.
DELETE FROM enrol1 WHERE sub_no = 999;

--18.enrol1 테이블에서 학번 99999999를 삭제하시오.
DELETE FROM enrol1 WHERE stu_no = 99999999;

--19.enrol1 테이블에 없는 과목을 삭제하시오.
DELETE FROM subject WHERE sub_no NOT IN(SELECT sub_no FROM enrol1);

--20.enrol1 테이블의 전체 데이터를 삭제하시오.
DELETE FROM enrol1;