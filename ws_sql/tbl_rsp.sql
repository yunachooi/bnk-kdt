CREATE TABLE tbl_rsp(
    id VARCHAR2(10) PRIMARY KEY,
    pw VARCHAR2(10),
    win NUMBER,
    lose NUMBER,
    draw NUMBER
);

SELECT * FROM TBL_RSP;

delete from tbl_rsp;

commit;