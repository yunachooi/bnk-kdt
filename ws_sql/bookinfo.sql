CREATE TABLE bookinfo(
    bno NUMBER PRIMARY KEY,
    title VARCHAR2(30),
    author VARCHAR2(10),
    publisher VARCHAR2(20),
    price NUMBER
);

SELECT * FROM bookinfo;
DELETE FROM bookinfo WHERE bno = 102;
DROP TABLE bookinfo;
commit;