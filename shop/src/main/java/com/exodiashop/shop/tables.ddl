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

-- auto-generated definition
create table product
(
    id       int auto_increment,
    name     varchar(45)  not null,
    gender   varchar(45)  null,
    brand    varchar(45)  not null,
    color    varchar(45)  null,
    type     varchar(45)  not null,
    category varchar(45)  not null,
    size     varchar(45)  null,
    price    double       not null,
    total    int          not null,
    image    varchar(200) not null,
    seller   varchar(100) not null,
    constraint id_UNIQUE
        unique (id)
)
    collate = utf8_turkish_ci;

alter table product
    add primary key (id);

