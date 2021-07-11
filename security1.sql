create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database security;
use security;

update user set role = 'ROLE_MANAGER' where id=2;
update user set role = 'ROLE_ADMIN' where id=3;