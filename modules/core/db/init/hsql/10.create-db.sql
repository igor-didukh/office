-- begin OFFICE_REQUEST
create table OFFICE_REQUEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    APPLICANT_ID varchar(36) not null,
    POSITION_ integer not null,
    WORKER_ID varchar(36) not null,
    COUNTER integer,
    CREATED date,
    CLOSED date,
    DESCRIPTION varchar(100),
    --
    primary key (ID)
)^
-- end OFFICE_REQUEST
-- begin OFFICE_ACT
create table OFFICE_ACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ varchar(50) not null,
    POSITION_ integer not null,
    DESCRIPTION varchar(100),
    WORK_DAYS integer not null,
    RESULT_REQUIRED boolean,
    --
    primary key (ID)
)^
-- end OFFICE_ACT
-- begin OFFICE_REQUEST_ACT
create table OFFICE_REQUEST_ACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REQUEST_ID varchar(36),
    ACT_ID varchar(36),
    DESCRIPTION varchar(100),
    CREATED date,
    DEADLINE date,
    CLOSED date,
    RESULT_ varchar(255),
    --
    primary key (ID)
)^
-- end OFFICE_REQUEST_ACT
-- begin OFFICE_REQUEST_STATUS
create table OFFICE_REQUEST_STATUS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REQUEST_ID varchar(36),
    DATE_ date not null,
    POSITION_ integer not null,
    USER_ID varchar(36),
    DESCRIPTION varchar(100),
    --
    primary key (ID)
)^
-- end OFFICE_REQUEST_STATUS
-- begin OFFICE_REQUEST_FILE
create table OFFICE_REQUEST_FILE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REQUEST_ID varchar(36),
    FILE_ID varchar(36),
    DESCRIPTION varchar(100),
    --
    primary key (ID)
)^
-- end OFFICE_REQUEST_FILE
-- begin SEC_USER
alter table SEC_USER add column REQUEST_POSITION integer ^
alter table SEC_USER add column REQUEST_COUNT integer ^
alter table SEC_USER add column REQUEST_THRESHOLD integer ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'office$ExtUser' where DTYPE is null ^
-- end SEC_USER
