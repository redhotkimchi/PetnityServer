CREATE TABLE post (
        dog_age smallint,
        salt varchar(6) not null,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        dog_name varchar(25) not null,
        title varchar(30) not null,
        location varchar(50),
        password varchar(512) not null,
        message varchar(255) not null,
        primary key (id)
    ) engine=InnoDB