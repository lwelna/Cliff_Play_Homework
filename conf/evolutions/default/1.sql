# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table post (
  id                        integer auto_increment not null,
  user_name                 varchar(255),
  id_post                   integer,
  post                      varchar(255),
  constraint pk_post primary key (id))
;

create table user (
  id                        integer auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  user_name                 varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table post;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

