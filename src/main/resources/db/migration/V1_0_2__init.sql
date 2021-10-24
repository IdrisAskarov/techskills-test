drop table public.users;

create table usr.users
(
    user_id    bigint default nextval('user_id_seq'::regclass)
        constraint user_id_pk primary key,
    email      varchar(250) not null,
    first_name varchar(250) not null,
    last_name varchar(250) not null,
    password   varchar(250) not null,
    enabled    bool,
    created_at timestamp,
    updated_at timestamp
);
