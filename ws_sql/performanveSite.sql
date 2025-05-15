CREATE TABLE tbl_performance(
    p_code VARCHAR2(10) primary key,
    p_name VARCHAR2(100),
    p_genre VARCHAR2(20),
    p_schedule VARCHAR2(100),
    p_time VARCHAR2(100),
    p_runningTime VARCHAR2(10),
    p_grade VARCHAR2(50),
    p_info VARCHAR2(2000),
    p_state VARCHAR2(20)
);

INSERT INTO tbl_performance VALUES ('P001', '햄릿', '연극', '2025-06-01~2025-06-30', '19:00', '120', '15세 이상 관람가', '셰익스피어의 고전 비극을 현대적으로 재해석한 작품입니다.', '상영예정');
INSERT INTO tbl_performance VALUES ('P002', '리어왕', '연극', '2025-07-05~2025-07-25', '18:30', '130', '15세 이상 관람가', '가족 간의 배신과 권력 투쟁을 다룬 비극.', '상영예정');
INSERT INTO tbl_performance VALUES ('P011', '뮤지컬 레미제라블', '공연', '2025-06-01~2025-06-20', '19:30', '150', '12세 이상 관람가', '프랑스 혁명을 배경으로 한 감동적인 뮤지컬.', '상영예정');
INSERT INTO tbl_performance VALUES ('P012', '디즈니 온 아이스', '공연', '2025-07-10~2025-07-30', '15:00', '90', '12세 이상 관람가', '디즈니 캐릭터들이 출연하는 가족 공연.', '상영예정');
INSERT INTO tbl_performance VALUES ('P008', '듄', '영화', '2025-08-10~2025-08-25', '20:30', '155', '12세 이상 관람가', '사막 행성 아라키스를 배경으로 한 SF 대작.', '상영예정');
INSERT INTO tbl_performance VALUES ('P003', '오셀로', '연극', '2025-05-01~2025-05-31', '20:00', '110', '15세 이상 관람가', '질투로 인한 파멸을 그린 연극 작품.', '상영중');
INSERT INTO tbl_performance VALUES ('P006', '인터스텔라', '영화', '2025-05-10~2025-05-25', '21:00', '169', '12세 이상 관람가', '인류의 생존을 위한 우주 탐사 이야기.', '상영중');
INSERT INTO tbl_performance VALUES ('P013', '태양의 서커스', '공연', '2025-05-01~2025-05-31', '18:00', '120', '12세 이상 관람가', '아크로바틱과 예술이 결합된 퍼포먼스 쇼.', '상영중');
INSERT INTO tbl_performance VALUES ('P014', '피아노 콘서트', '공연', '2025-05-10~2025-05-25', '20:00', '100', '12세 이상 관람가', '세계적인 피아니스트의 독주회.', '상영중');
INSERT INTO tbl_performance VALUES ('P007', '기생충', '영화', '2025-05-05~2025-05-20', '18:00', '132', '15세 이상 관람가', '빈부 격차를 주제로 한 사회 풍자 영화.', '상영중');
INSERT INTO tbl_performance VALUES ('P004', '로미오와 줄리엣', '연극', '2025-03-01~2025-03-20', '17:00', '100', '12세 이상 관람가', '운명적인 사랑 이야기를 그린 로맨스 비극.', '상영종료');
INSERT INTO tbl_performance VALUES ('P005', '갈릴레이의 생애', '연극', '2025-04-01~2025-04-20', '19:00', '140', '15세 이상 관람가', '과학자 갈릴레이의 삶과 진실을 향한 투쟁.', '상영종료');
INSERT INTO tbl_performance VALUES ('P009', '타이타닉', '영화', '2025-02-01~2025-02-20', '19:00', '195', '12세 이상 관람가', '실제 사건을 바탕으로 한 로맨틱 드라마.', '상영종료');
INSERT INTO tbl_performance VALUES ('P010', '어벤져스: 엔드게임', '영화', '2025-01-10~2025-01-30', '22:00', '181', '12세 이상 관람가', '마블 슈퍼히어로들의 최종 전투를 그린 영화.', '상영종료');
INSERT INTO tbl_performance VALUES ('P015', 'K-pop 콘서트', '공연', '2025-03-10~2025-03-25', '19:00', '120', '12세 이상 관람가', '인기 K-pop 아이돌들이 총출동하는 대형 공연.', '상영종료');

CREATE TABLE tbl_notice (
    n_no NUMBER PRIMARY KEY,
    n_genre VARCHAR(10),
    n_title VARCHAR(200),
    n_content VARCHAR(2000),
    n_regdate DATE
);

CREATE SEQUENCE notice_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE tbl_comment(
    c_no NUMBER PRIMARY KEY,
    c_writer VARCHAR2(30),
    c_comment VARCHAR2(200),
    c_regdate DATE,
    p_code VARCHAR2(10),
    FOREIGN KEY(c_writer) REFERENCES tbl_member(id),
    FOREIGN KEY(p_code) REFERENCES tbl_performance(p_code)
);

CREATE SEQUENCE comment_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE tbl_qna(
    q_no NUMBER PRIMARY KEY,
    q_title VARCHAR2(100),
    q_content VARCHAR2(2000),
    q_status VARCHAR2(10),
    q_writer VARCHAR2(30),
    q_regdate DATE
);

CREATE SEQUENCE qna_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


SELECT * FROM tbl_qna;
SELECT * FROM tbl_comment;
SELECT * FROM tbl_notice;
SELECT * FROM tbl_member;
SELECT * FROM tbl_performance;
SELECT * FROM tbl_member;

DROP TABLE tbl_performance;
DROP TABLE tbl_comment;
DROP TABLE tbl_qna;
DROP TABLE tbl_notice;
DROP SEQUENCE notice_seq;
DROP SEQUENCE comment_seq;
DROP SEQUENCE qna_seq;

COMMIT;
