--rownum 범위를 지정하여 가져오는 쿼리
SELECT * FROM (SELECT rownum num, student.* FROM student) WHERE num BETWEEN 3 AND 5;
--동일한 순위를 가지고 있을 경우에도 전체순위의 개수가 변함 없음(ex. 1 1 3)
SELECT RANK() OVER (ORDER BY stu_height) rank, stu_name, stu_height FROM student;
--동일한 순위를 가지고 있을 경우에는 전체순위의 개수가 변함(ex. 1 1 2)
SELECT DENSE_RANK() OVER (ORDER BY stu_height) rank, stu_name, stu_height FROM student;
