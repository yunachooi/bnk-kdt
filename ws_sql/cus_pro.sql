--'A전자'회사의 자재 관리 프로그램을 만들기 위해 DB 설계를 하려합니다.
--거래처 정보와 구매 상품 정보를 관리합니다.

CREATE TABLE customer(
    c_code VARCHAR2(10) PRIMARY KEY,
    c_name VARCHAR2(20),
    c_ceo VARCHAR2(10),
    c_addr VARCHAR2(30),
    c_phone VARCHAR2(13)
);

CREATE TABLE product(
    p_code VARCHAR2(10) PRIMARY KEY,
    p_name VARCHAR2(20),
    p_cost NUMBER,
    p_group VARCHAR2(10)
);

CREATE TABLE store(
    p_code VARCHAR2(10) PRIMARY KEY,
    s_sto NUMBER,
    FOREIGN KEY(p_code) REFERENCES product(p_code)
);

CREATE TABLE delivery(
    p_code VARCHAR2(10) PRIMARY KEY,
    s_del NUMBER,
    FOREIGN KEY(p_code) REFERENCES product(p_code)
);

CREATE TABLE stock(
    p_code VARCHAR2(10) PRIMARY KEY,
    s_qty NUMBER,
    FOREIGN KEY(p_code) REFERENCES product(p_code)
);

CREATE TABLE trade(
    t_seq VARCHAR2(10) PRIMARY KEY,
    t_date DATE,
    t_qty NUMBER,
    t_cost NUMBER,
    p_code VARCHAR2(10),
    c_code VARCHAR2(10),
    FOREIGN KEY(p_code) REFERENCES product(p_code),
    FOREIGN KEY(c_code) REFERENCES customer(c_code)
);

CREATE TABLE employee(
    e_no NUMBER PRIMARY KEY,
    e_name VARCHAR2(10),
    e_rank VARCHAR2(10),
    e_date DATE
);

CREATE TABLE sales(
    e_no NUMBER PRIMARY KEY,
    s_sales NUMBER,
    p_code VARCHAR2(10),
    FOREIGN KEY(e_no) REFERENCES employee(e_no),
    FOREIGN KEY(p_code) REFERENCES product(p_code)
);


------테스트------
--1)거래처정보
--2)1-1.거래처생성
INSERT INTO customer VALUES('sm', 's사', '이*용', '서울특별시 서초구', '02-2255-0114');
INSERT INTO customer VALUES('lg', 'l사', '구*모', '서울특별시 영등포구', '02-3777-1114');

--2)입출고 재고 -> 구매팀
--2)1-1. 상품생성
--2)2-1. 입고 2-2. 재고 확인 2-3. 출고(JAVA구현)
INSERT INTO product VALUES('m-f-01', '냉장고01', 100, '냉장고');
INSERT INTO product VALUES('m-f-02', '냉장고02', 200, '냉장고');
INSERT INTO product VALUES('m-f-03', '냉장고03', 300, '냉장고');
INSERT INTO product VALUES('m-a-01', '에어컨01', 100, '에어컨');
INSERT INTO product VALUES('m-a-02', '에어컨02', 200, '에어컨');
INSERT INTO product VALUES('m-a-03', '에어컨03', 300, '에어컨');
INSERT INTO product VALUES('m-r-01', '세탁기01', 100, '세탁기');
INSERT INTO product VALUES('m-r-02', '세탁기02', 200, '세탁기');
INSERT INTO product VALUES('m-r-03', '세탁기03', 300, '세탁기');

INSERT INTO stock VALUES('m-f-01', 1);
INSERT INTO stock VALUES('m-f-02', 2);
INSERT INTO stock VALUES('m-f-03', 3);
INSERT INTO stock VALUES('m-a-01', 1);
INSERT INTO stock VALUES('m-a-02', 2);
INSERT INTO stock VALUES('m-a-03', 3);
INSERT INTO stock VALUES('m-r-01', 1);
INSERT INTO stock VALUES('m-r-02', 2);
INSERT INTO stock VALUES('m-r-03', 3);

--3)영업사원
--3)1.영업사원고용
INSERT INTO employee VALUES(202501, '김사원', '사원', '2025-01-01');
INSERT INTO employee VALUES(202502, '이대리', '대리', '2024-01-01');
INSERT INTO employee VALUES(202503, '박팀장', '팀장', '2022-01-01');
INSERT INTO employee VALUES(202504, '최사원', '사원', '2025-01-01');
INSERT INTO employee VALUES(202505, '문대리', '대리', '2023-01-01');

--4)거래 -> 거래 단가 + (거래 단가 * 0.1) (JAVA구현)
--5)판매실적 -> (JAVA구현)












