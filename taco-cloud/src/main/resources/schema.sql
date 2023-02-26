create table if not exists Ingredient (
    id varchar(4) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Taco (
    id identity,
    name varchar(50) not null,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP
);

create table if not exists Taco_Ingredients (
   taco bigint not null,
   ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);
alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
    id identity,
       deliveryName varchar(50) not null,
       deliveryStreet varchar(50) not null,
       deliveryCity varchar(50) not null,
       deliveryState varchar(20) not null,
       deliveryZip varchar(10) not null,
       ccNumber varchar(16) not null,
       ccExpiration varchar(5) not null,
       ccCVV varchar(3) not null,
       placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
    tacoOrder bigint not null,
    taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);

create table if not exists Users (
    username varchar(50) not null primary key,
    password varchar(250) not null,
    fullname varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    zip int(50) not null,
    phoneNumber int(50) not null,
    enabled boolean not null
);

create table if not exists UserAuthorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on UserAuthorities (username, authority);
