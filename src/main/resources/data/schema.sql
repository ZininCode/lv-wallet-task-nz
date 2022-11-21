drop table if exists wallet CASCADE;
drop table if exists transaction CASCADE;
-- drop sequence if exists hibernate_sequence;
-- create sequence hibernate_sequence start with 1 increment by 1;

create table wallet
(
    id      bigint not null auto_increment,
    player_id bigint,
    balance decimal(10, 2),
    primary key (id)
);

create table transaction
(
    id         varchar(50) not null unique,
    type varchar(20),
    amount     decimal(10, 2),
    time timestamp,
    wallet_id        bigint not null,
    primary key (id),
    foreign key (wallet_id) references wallet
);


insert into wallet (id, player_id, balance) values (1, 123, 1000);
