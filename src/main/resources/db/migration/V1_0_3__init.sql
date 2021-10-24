create sequence tech_id_seq start 100;
create sequence tech_sub_id_seq start 100;
create sequence topic_id_seq start 100;
create sequence test_set_id_seq start 100;
create sequence test_id_seq start 100;
create sequence test_option_id_seq start 100;
create sequence test_question_id_seq start 100;
create sequence qu_an_id_seq start 100;
create sequence quan_question_id_seq start 100;
create sequence quan_option_id_seq start 100;
create sequence sort_statement_id_seq start 100;
create sequence stmt_task_id_seq start 100;
create sequence stmt_id_seq start 100;
create sequence stmt_arg_id_seq start 100;

create table tech.technos
(
    tech_id    bigint    default nextval('tech_id_seq'::regclass)
        constraint pk_tech_id_key primary key,
    tech       varchar(250) not null,
    code       varchar(250) not null,
    descr      varchar(1000),
    enabled    bool      default true,
    created_at timestamp default current_date,
    updated_at timestamp
);

insert into tech.technos(tech, code, descr)
values ('Java', 'JAVA', 'One of the most popular OOP programming language');
insert into tech.technos(tech, code, descr)
values ('Spring Framework', 'SPRING', 'Lightweight multi-modular framework that supports Inversion Control');
insert into tech.technos(tech, code, descr)
values ('Spring Boot', 'SPRING_BOOT',
        'Spring Boot is an open source Java-based framework used to create a micro Service');

create table tech.topics
(
    topic_id        bigint default nextval('topic_id_seq'::regclass)
        constraint topic_id_pk primary key,
    parent_topic_id bigint,
    tech_id         bigint,
    title           varchar(250),
    code            varchar(250),
    content         text,
    descr           varchar(1000),
    enabled         bool   default true,
    created_at      timestamp,
    updated_at      timestamp,
    constraint parent_topic_id_fk foreign key (parent_topic_id) references tech.topics (topic_id),
    constraint topic_tech_id_fk foreign key (tech_id) references tech.technos (tech_id)
);

create table assess.test_sets
(
    test_set_id bigint default nextval('test_set_id_seq'::regclass)
        constraint test_id_pk primary key,
    topic_id    bigint,
    name        varchar(250),
    code        varchar(250),
    descr       varchar(500),
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp,
    constraint test_set_topic_id_fk foreign key (topic_id) references tech.topics (topic_id)
);

create table assess.tests
(
    test_id     bigint default nextval('test_id_seq'::regclass)
        constraint tests_pk primary key,
    test_set_id bigint,
    duration    int    default 0,
    test_mode   varchar(250),
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp,
    constraint test_test_set_fk foreign key (test_set_id) references assess.test_sets (test_set_id)
);

create table assess.test_questions
(
    question_id  bigint  default nextval('test_question_id_seq'::regclass)
        constraint quest_id_pk primary key,
    test_id      bigint,
    question     varchar(500),
    code         varchar(250),
    answer       varchar(1000),
    hint         varchar(250),
    points       int,
    multiple_var boolean default false,
    enabled      bool    default true,
    created_at   timestamp,
    updated_at   timestamp,
    constraint ques_test_id_fk foreign key (test_id) references assess.tests (test_id)
);

create table assess.test_options
(
    option_id   bigint default nextval('test_option_id_seq'::regclass)
        constraint option_id_pk primary key,
    question_id bigint,
    text        varchar(500),
    code        varchar(250),
    description varchar(750),
    correct     boolean,
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp,
    constraint opt_quest_id_fk foreign key (question_id) references assess.test_questions (question_id)
);


create table assess.quans
(
    quan_id    bigint default nextval('qu_an_id_seq'::regclass)
        constraint quan_id_pk primary key,
    topic_id   bigint not null,
    name       varchar(250),
    code       varchar(250),
    descr      varchar(500),
    enabled    bool   default true,
    created_at timestamp,
    updated_at timestamp,
    constraint quan_topic_id_fk foreign key (topic_id) references tech.topics (topic_id)
);

create table assess.quan_questions
(
    question_id bigint default nextval('quan_question_id_seq'::regclass)
        constraint quan_ques_pk primary key,
    quan_id     bigint,
    question    varchar(250),
    code        varchar(250),
    answer      varchar(250),
    hint        varchar(250),
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp
--     constraint quest_quan_id_fk foreign key (quan_id) references assess.quans (quan_id)
);

create table assess.quan_options
(
    option_id   bigint default nextval('quan_option_id_seq'::regclass),
    question_id bigint,
    option      varchar(250),
    code        varchar(250),
    descr       varchar(250),
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp,
    constraint option_quan_quest_id_fk foreign key (question_id) references assess.quan_questions (question_id)
);

create table assess.sort_statements
(
    sort_stmt_id bigint default nextval('sort_statement_id_seq'::regclass)
        constraint sort_stmt_id_pk primary key,
    topic_id     bigint,
    name         varchar(250),
    code         varchar(250),
    descr        varchar(500),
    enabled      bool   default true,
    created_at   timestamp,
    updated_at   timestamp,
    constraint sort_state_topic_id_fk foreign key (topic_id) references tech.topics (topic_id)
);

create table assess.statement_tasks
(
    stmt_task_id bigint default nextval('stmt_task_id_seq'::regclass)
        constraint stmt_task_pk primary key,
    sort_stmt_id bigint,
    task         varchar(250),
    code         varchar(250),
    descr        varchar(250),
    hint         varchar(250),
    enabled      bool   default true,
    created_at   timestamp,
    updated_at   timestamp,
    constraint stmt_task_sort_stmt_fk foreign key (sort_stmt_id) references assess.sort_statements (sort_stmt_id)
);

create table assess.statements
(
    stmt_id      bigint default nextval('stmt_id_seq'::regclass)
        constraint stmt_pk primary key,
    stmt_task_id bigint,
    statement    varchar(250),
    code         varchar(250),
    descr        varchar(250),
    enabled      bool   default true,
    created_at   timestamp,
    updated_at   timestamp,
    constraint stmt_stmt_task_fk foreign key (stmt_task_id) references assess.statement_tasks (stmt_task_id)
);

create table assess.statement_arguments
(
    stmt_arg_id bigint default nextval('stmt_arg_id_seq'::regclass)
        constraint stmt_arg_pk primary key,
    stmt_id     bigint,
    argument    varchar(250),
    code        varchar(250),
    enabled     bool   default true,
    created_at  timestamp,
    updated_at  timestamp,
    constraint stmt_arg_stmt_fk foreign key (stmt_id) references assess.statements (stmt_id)
);