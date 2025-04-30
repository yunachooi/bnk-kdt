CREATE TABLE accounts(
    account_id VARCHAR(10) PRIMARY KEY,
    owner_name VARCHAR(50) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

INSERT INTO accounts VALUES('A001', '김철수', 1000000);
INSERT INTO accounts VALUES('A002', '이영희', 500000);

SELECT * FROM accounts;
delete  from accounts;
commit;