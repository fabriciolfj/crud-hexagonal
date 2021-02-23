create  is table person(
id bigint not null auto_increment,
name varchar(255) not null,
document varchar(15) not null,
type varchar(15) not null,
primary key (id)
) engine=InnoDB default charset=utf8;