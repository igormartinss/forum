create table user(
    id bigint not null auto_increment,
    username varchar(50) not null,
    email varchar(50),
    password text not null,
    primary key(id)
);
insert into user(id, username, email, password) values (1, 'admin', 'admin@admin.com', '$2y$12$rnZ4zWxhPv.7iSOhBKkGqu2PVsJf./W78TScYJd.EWdaEeWhnhQW.');