-- multi transactions

Insert into hr.test (username)
values ('culmanu');
COMMIT ;

Insert into hr.test (username)
values ('ipopov');
COMMIT ;

Insert into hr.test (username)
values ('vmoraru');
COMMIT ;

Delete from hr.test;
Commit;

Rollback;


-- single transaction
Insert into hr.test (username)
values ('culmanu');
Insert into hr.test (username)
values ('ipopov');
Insert into hr.test (username)
values ('vmoraru');
COMMIT ;

Insert into hr.test (username)
values ('culmanu1');
SAVEPOINT A;
Insert into hr.test (username)
values ('ipopov2');
Insert into hr.test (username)
values ('vmoraru');
-- Rollback to A;
COMMIT ;