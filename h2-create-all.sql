create table book_order (
  id                            bigint auto_increment not null,
  book_name                     varchar(255),
  version                       bigint not null,
  constraint pk_book_order primary key (id)
);

