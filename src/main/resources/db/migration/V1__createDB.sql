begin;

drop schema if exists tracker cascade;
create schema tracker;

drop table if exists tracker.projects;
create table tracker.projects (
id bigserial,
project_name varchar(100) unique not null,
start_date   timestamp    not null,
complete_date   timestamp    not null,
p_priority   integer    not null,
project_status   varchar(20) not null,

primary key (id)
);

drop table if exists tracker.tasks;
create table tracker.tasks (
id bigserial,
task_name varchar(100) unique not null,
description varchar(255) not null,
t_priority   integer    not null,
task_status   varchar(20) not null,

project_id BIGINT not null references tracker.projects (id) on delete cascade,

primary key (id)
);

commit;