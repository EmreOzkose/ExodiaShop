create table user
(
    id          int auto_increment,
    username    varchar(50)  not null,
    password    varchar(255) not null,
    name        varchar(50)  not null,
    surname     varchar(50)  not null,
    dateofbirth date         null,
    gender      varchar(6)   not null,
    email       varchar(50)  not null,
    address     varchar(255) null,
    phonenumber varchar(20)  null,
    role        varchar(45)  not null,
    constraint id_UNIQUE
        unique (id),
    constraint phonenumber_UNIQUE
        unique (phonenumber),
    constraint username_UNIQUE
        unique (username)
)

    collate = utf8_turkish_ci;

alter table user
    add primary key (id);
