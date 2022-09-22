insert into tbl_users (username, password) values ('user1', 'password1');
insert into tbl_users (username, password) values ('user2', 'password2');

insert into tbl_authorities (username, authority)
values ('user1', 'ROLE_USER');
insert into tbl_authorities (username, authority)
values ('user2', 'ROLE_USER');

commit;