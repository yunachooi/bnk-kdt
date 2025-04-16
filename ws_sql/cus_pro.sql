--'A전자'회사의 자재 관리 프로그램을 만들기 위해 DB 설계를 하려합니다.
--거래처 정보와 구매 상품 정보를 관리합니다.
--거래처 정보(customer)는 '거래처코드(c_code)', 거래처명(c_name), 경영자명(c_ceo), 거래처 주소(c_addr), 거래처 연락처(c_phone)로 구성됩니다.
--상품정보(product)는 '상품코드(p_code)', '상품명(p_name)', '상품단가(p_cost)', '소분류(p_group)'으로 구성됩니다.
--상품재고(stock)는 '상품코드(p_code)', '재고수량(s_qty)'으로 구성됩니다.
--거래내역(trade)은 '거래내역 일련번호(t_seq)', '상품코드(p_code)', '거래처코드(c_code)', '거래일자(t_date)', '거래수량(t_qty)', '거래단가(t_cost)'로 구성된다.

CREATE TABLE customer(
    c_code VARCHAR2(10) PRIMARY KEY,
    c_name VARCHAR2(20),
    c_ceo VARCHAR2(10),
    c_addr VARCHAR2(20),
    c_phone VARCHAR2(13)
);

CREATE TABLE product(
    p_code VARCHAR2(10) PRIMARY KEY,
    p_name VARCHAR2(20),
    p_cost NUMBER,
    p_group VARCHAR2(10)
);

CREATE TABLE stock(
    p_code VARCHAR2(10) PRIMARY KEY,
    s_qty NUMBER,
    FOREIGN KEY(p_code) REFERENCES product(p_code)
);

CREATE TABLE trade(
    t_seq VARCHAR2(10) PRIMARY KEY,
    p_code VARCHAR2(10),
    c_code VARCHAR2(10),
    t_date DATE,
    t_qty NUMBER,
    t_cost NUMBER,
    FOREIGN KEY(p_code) REFERENCES product(p_code),
    FOREIGN KEY(c_code) REFERENCES customer(c_code)
);






