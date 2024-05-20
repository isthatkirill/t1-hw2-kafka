create table metrics (
    id bigint generated by default as identity primary key,
    method varchar(16) not null,
    path varchar(256) not null,
    requested_at timestamp not null,
    response_time bigint not null,
    memory_used bigint not null
);
