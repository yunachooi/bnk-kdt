-- 사용자 정보 테이블
CREATE TABLE tbl_shop_user (
    username VARCHAR2(100),
    password VARCHAR2(100),
    CONSTRAINT PK_TBL_SHOP_USER PRIMARY KEY (username)
);

-- 상품 테이블
CREATE TABLE tbl_shop_product (
    productNo NUMBER,
    productName VARCHAR2(2000),
    productPrice NUMBER,
    productStock NUMBER,
    CONSTRAINT PK_TBL_SHOP_PRODUCT PRIMARY KEY (productNo)
);

-- 장바구니 테이블
CREATE TABLE tbl_shop_basket (
    basketNo NUMBER,
    username VARCHAR2(100),
    productNo NUMBER,
    productCount NUMBER,
    CONSTRAINT PK_TBL_SHOP_BASKET PRIMARY KEY (basketNo),
    CONSTRAINT FK_BASKET_USER FOREIGN KEY (username) REFERENCES tbl_shop_user(username),
    CONSTRAINT FK_BASKET_PRODUCT FOREIGN KEY (productNo) REFERENCES tbl_shop_product(productNo)
);

-- 시퀀스
CREATE SEQUENCE seq_basket_no START WITH 1 INCREMENT BY 1 NOCACHE;

-- 조회
SELECT * FROM tbl_shop_user;
SELECT * FROM tbl_shop_product;
SELECT * FROM tbl_shop_basket;

-- 삭제
DROP TABLE tbl_shop_basket;
DROP TABLE tbl_shop_product;
DROP TABLE tbl_shop_user;

-- 더미데이터
INSERT INTO tbl_shop_user (username, password) VALUES('user01', '1234');

INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (1, 'OORIGINAL BLACK - 조리 블랙', 62100, 5);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (2, '[WOMEN] 오리지날 플레이 숏 레인부츠 - 블랙 WFS2020RMABLK', 1049000, 3);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (3, '스웨이드 위드 레더 텅 스웨이드 토프/탄 / PT203SL-TPTN', 131990, 2);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (4, '[WOMEN] 오리지날 플레이 톨 레인부츠 - 블랙 WFT2007RMABLK', 169000, 0);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (5, '810s 마르케 모디', 74700, 1);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (6, 'FLATFORM RAIN BOOTS LONG - 7 colors', 99800, 1);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (7, '[2팩] FEROA 플리플랍 - 5컬러', 49900, 2);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (8, '[무료반품][유튜버 PICK]볼드 앵클 레인부츠 2 COLOR + 방수 주머니', 82500, 3);
INSERT INTO tbl_shop_product (productNo, productName, productPrice, productStock) VALUES (9, 'NEW ORIGINAL RAIN BOOTS SHORT - 8 colors', 60900, 4);

COMMIT;