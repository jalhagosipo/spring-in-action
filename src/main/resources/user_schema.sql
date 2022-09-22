drop table if exists tbl_authorities;
drop table if exists tbl_users;
drop index if exists ix_auth_username;

create table if not exists tbl_users(
                                    username varchar2(50) not null primary key,
                                    password varchar2(50) not null,
                                    enabled char(1) default '1',
                                    enabled_2 char(1) default '1');

create table if not exists tbl_authorities (
                                           username varchar2(50) not null,
                                           authority varchar2(50) not null,
                                           json text default '',
                                           constraint fk_authorities_users
                                               foreign key(username) references tbl_users(username));

create unique index ix_auth_username
    on tbl_authorities (username, authority);