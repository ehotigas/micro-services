create table user (
    id int auto_increment primary key,
    name varchar(255) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    password text not null,
    created_at datetime not null,
    deleted tinyint(1) not null default 0
);
