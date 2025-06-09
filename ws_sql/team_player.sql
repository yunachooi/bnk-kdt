insert into team (name, emblem_animal) values('A', '독수리');
insert into team (name, emblem_animal) values('B', '호랑이');

insert into player (pno, name, position, team_id) values (player_seq.nextval, 'James', 'CENTER', 'A');
insert into player (pno, name, position, team_id) values (player_seq.nextval, 'Ann', 'POINT_GUARD', 'A');
insert into player (pno, name, position, team_id) values (player_seq.nextval, 'Tom', 'SHOOTING_GUARD', 'A');
insert into player (pno, name, position, team_id) values (player_seq.nextval, 'Chales', 'CENTER', 'A');

SELECT * FROM TEAM;
SELECT * FROM PLAYER;

COMMIT;