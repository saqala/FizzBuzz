create table if not exists fizz_buzz_counter(
    id bigint not null primary key,-- AUTO_INCREMENT
    param1 int not null,
    param2 int not null,
    limit_ int not null,
    str1 varchar(255) not null,
    str2 varchar(255) not null,
    counter int not null
    )