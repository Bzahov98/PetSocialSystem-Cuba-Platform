-- begin PETAGRAM_USER
create table PETAGRAM_USER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    STATUS varchar(255),
    PIC_ID varchar(36),
    --
    primary key (ID)
)^
-- end PETAGRAM_USER
-- begin PETAGRAM_POST
create table PETAGRAM_POST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEXT varchar(255),
    PIC_ID varchar(36),
    DATE_ timestamp,
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end PETAGRAM_POST
-- begin PETAGRAM_COMMENT
create table PETAGRAM_COMMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEXT varchar(255),
    DATE_ timestamp,
    USER_ID varchar(36) not null,
    POST_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end PETAGRAM_COMMENT
