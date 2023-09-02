create table autoria (autor_codigo bigint not null, livro_isbn varchar(255) not null, primary key (autor_codigo, livro_isbn));
alter table if exists autoria add constraint FKi8rpd5a40sqajl3g25eh9q6rg foreign key (autor_codigo) references autor;
alter table if exists autoria add constraint FK2mypkvxjfifux7pvuypikirbv foreign key (livro_isbn) references livro;