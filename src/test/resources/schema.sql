drop table weather if exists;

create table weather (

    id UUID PRIMARY KEY,
    city_name VARCHAR,
    temperature VARCHAR
);

insert into weather(id,city_name, temperature) VALUES (random_uuid(),'Haarlem', '21')