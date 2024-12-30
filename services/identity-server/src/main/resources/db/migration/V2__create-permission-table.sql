create table permission (
    id int auto_increment primary key,
    role varchar(255) not null,
    created_at datetime not null
);