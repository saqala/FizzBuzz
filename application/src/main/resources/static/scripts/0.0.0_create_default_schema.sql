create table if not exists fizz_buzz_counter(
    id int auto_increment primary key,
    param1 int not null,
    param2 int not null,
    limit_ int not null,
    str1 varchar(255) not null,
    str2 varchar(255) not null,
    counter int not null,
    constraint unique_params unique (param1,param2, limit_, str1, str2, counter)
    )