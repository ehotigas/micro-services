create table user_permission (
    id int auto_increment primary key,
    user_id int not null,
    permission_id int not null,
    foreign key (user_id) references user(id) on delete cascade,
    foreign key (permission_id) references permission(id) on delete cascade
);