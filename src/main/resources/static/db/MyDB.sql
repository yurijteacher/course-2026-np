create table addresses
(
    id        bigint not null auto_increment,
    city      varchar(255),
    country   varchar(255),
    street    varchar(255),
    zip       varchar(255),
    client_id bigint,
    primary key (id)
) engine = InnoDB;

create table attribute
(
    id    bigint    not null auto_increment,
    name  varchar(255),
    value float(53) not null,
    primary key (id)
) engine = InnoDB;

create table attribute_has_products
(
    id           bigint not null auto_increment,
    attribute_id bigint,
    product_id   bigint,
    primary key (id)
) engine = InnoDB;

create table brands
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;

create table categories
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;

create table clients
(
    id         bigint  not null,
    age        integer not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    phone      integer not null,
    primary key (id)
) engine = InnoDB;

create table delivery
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;

create table orders
(
    id            bigint not null auto_increment,
    creation_date datetime(6),
    client_id     bigint,
    delivery_id   bigint,
    payment_id    bigint,
    primary key (id)
) engine = InnoDB;
create table payment
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;
create table product_has_brand
(
    id         bigint not null auto_increment,
    brand_id   bigint,
    product_id bigint,
    primary key (id)
) engine = InnoDB;
create table products
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    price       decimal(38, 2),
    category_id bigint,
    primary key (id)
) engine = InnoDB;
create table products_has_order
(
    id         bigint  not null auto_increment,
    quantity   integer not null,
    order_id   bigint,
    product_id bigint,
    primary key (id)
) engine = InnoDB;
create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table users
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;
create table users_roles
(
    users_id bigint not null,
    roles_id bigint not null,
    primary key (users_id, roles_id)
) engine = InnoDB;
alter table addresses
    add constraint FKrf3c1s9gxxx0wubkv5maokv9y foreign key (client_id) references clients (id);
alter table attribute_has_products
    add constraint FK1uptct16wl9s7jcu4m7g7s9h7 foreign key (attribute_id) references attribute (id);
alter table attribute_has_products
    add constraint FKh5hk07ssnf7a12tmseyughfbj foreign key (product_id) references products (id);
alter table clients
    add constraint FK1hgwdp9vl25xl9i7s354sifey foreign key (id) references users (id);
alter table orders
    add constraint FKm2dep9derpoaehshbkkatam3v foreign key (client_id) references clients (id);
alter table orders
    add constraint FKtkrur7wg4d8ax0pwgo0vmy20c foreign key (delivery_id) references delivery (id);
alter table orders
    add constraint FKag8ppnkjvx255gj7lm3m18wkj foreign key (payment_id) references payment (id);
alter table product_has_brand
    add constraint FK1ugre6vqklrckcmcigri91m2v foreign key (brand_id) references brands (id);
alter table product_has_brand
    add constraint FK4vrdmqcck9felxiq46pbx2gr1 foreign key (product_id) references products (id);
alter table products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9 foreign key (category_id) references categories (id);
alter table products_has_order
    add constraint FKq2kttko92vym92vc5nfllxxyg foreign key (order_id) references orders (id);
alter table products_has_order
    add constraint FKtikyb0gmevslu58v18mumf9lx foreign key (product_id) references products (id);
alter table users_roles
    add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles
    add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);