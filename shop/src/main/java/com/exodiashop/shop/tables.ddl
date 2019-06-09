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
    profilePhoto        varchar(100) null,
    shoppingCart varchar(10000) null,
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
    name     varchar(45)   not null,
    gender   varchar(45)   null,
    brand    varchar(45)   not null,
    color    varchar(45)   null,
    type     varchar(45)   not null,
    category varchar(45)   not null,
    size     varchar(45)   null,
    price    double        not null,
    total    int           not null,
    img_path varchar(200)  not null,
    seller   varchar(100)  not null,
    location varchar(1000) null,
    constraint id_UNIQUE
        unique (id)
)
    collate = utf8_turkish_ci;

alter table product
    add primary key (id);



-- auto-generated definition
create table seller
(
    id        int auto_increment,
    name      varchar(50)  not null,
    locations varchar(255) null,
    products  varchar(100) null,
    password  varchar(45)  not null,
    wallet    float        null,
    constraint id_UNIQUE
        unique (id)
)
    collate = utf8_turkish_ci;

alter table seller
    add primary key (id);



-- auto-generated definition
create table `order`
(
    id          int                  not null,
    Customer    varchar(50)          not null,
    ProductIDs  varchar(10000)       not null,
    isConfirmed int default 0 null,
    isFinished  int default 0 null,
    constraint order_id_uindex
        unique (id)
);

alter table `order`
    add primary key (id);


-- auto-generated definition
create table comment
(
    id          int auto_increment,
    Commentator varchar(50)                                     not null,
    Text        varchar(1000)                                   null,
    ProductID   int                                             not null,
    Date        date                                            null,
    Star        enum ('0', '1', '2', '3', '4', '5') default '0' null,
    constraint Comment_id_uindex
        unique (id)
);

alter table comment
    add primary key (id);

