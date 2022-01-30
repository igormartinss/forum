create table user(
    id bigint not null auto_increment,
    username varchar(50) not null,
    email varchar(50),
    password varchar(50) not null,
    primary key(id)
);
insert into user values (1, 'admin', 'admin@admin.com', 'admin');