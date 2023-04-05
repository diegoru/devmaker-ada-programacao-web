insert into autor(nome) values ('Robert C. Martin');
insert into autor(nome) values ('Eric Evans');
insert into autor(nome) values ('Martin Fowler');

insert into editora(nome) values ('Alta Books');
insert into editora(nome) values ('Novatec Editora');

insert into livro(titulo, editora_id) values ('Código limpo: Habilidades práticas do Agile Software', 1);
insert into livro(titulo, editora_id) values ('Domain-Driven Design: Atacando as complexidades no coração do software', 1);
insert into livro(titulo, editora_id) values ('Refatoração: Aperfeiçoando o Design de Códigos Existentes', 2);

insert into livros_autores(livro_id, autor_id) values (1, 1);
insert into livros_autores(livro_id, autor_id) values (2, 2);
insert into livros_autores(livro_id, autor_id) values (3, 3);

