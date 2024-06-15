insert INTO estilo (nome, descricao) values ('StreetWear', 'Camisa estilo Street');
insert INTO estilo (nome, descricao) values ('Esportivo', 'Camisas de Esportes');
insert INTO estilo (nome, descricao) values ('Casual', 'Camisas Casuais');


insert INTO marca (nome) values ('Nike');
insert INTO marca (nome) values ('Puma');
insert INTO marca (nome) values ('SRB');

insert into telefone(codigoArea, numero) values ('11', '123456789'); --1
insert into telefone(codigoArea, numero) values ('22', '2222-2222'); --2
insert into telefone(codigoArea, numero) values ('33', '3333-3333'); --3
insert into telefone(codigoArea, numero) values ('45', '4545-4545'); --4
insert into telefone(codigoArea, numero) values ('77', '7777-7777'); --5
insert into telefone(codigoArea, numero) values ('88', '8888-8888'); --6
insert into telefone(codigoArea, numero) values ('123', '7474-4747'); --7
insert into telefone(codigoArea, numero) values ('234', '7897-4566'); --8
insert into telefone(codigoArea, numero) values ('345', '8524-9645'); --9
insert into telefone(codigoArea, numero) values ('101', '1010-1010'); --10
insert into telefone(codigoArea, numero) values ('111', '1111-1111'); --11
insert into telefone(codigoArea, numero) values ('112', '1212-1212'); --12
insert into telefone(codigoArea, numero) values ('113', '1313-1313'); --13
insert into telefone(codigoArea, numero) values ('114', '1414-1414'); --14


insert INTO fornecedor(nome, gmail, id_telefone) values ('fornecedor1', 'f1@gmail.com', 1);
insert into fornecedor(nome, gmail, id_telefone) values ('Fornecedor2', 'f2@gmail.com', 2);
insert into fornecedor(nome, gmail, id_telefone) values ('Fornecedor3', 'f3@gmail.com', 3);

insert INTO material (nome, porcentagem) values ('Algodao', 100), ('Cetim', 100), ('Poliester', 50), ('DryFit', 100), ('DryFit', 50);

insert into camisa (nome, descricao, cor, preco, largura, comprimento, estoque, tamanho, id_fornecedor, id_estilo, id_marca) 
            values ('Camisa1', 'CamisaD1','Preto', 100.00, 45, 55, 100, 1, 1, 1, 1);
insert into camisa_material (id_camisa, id_material) values (1, 1),(1,2);

insert into camisa (nome, descricao, cor, preco, largura, comprimento, estoque, tamanho, id_fornecedor, id_estilo, id_marca) 
            values ('CamisaFlamengo', 'Camisa do Flamengo','Vermelho e Preto', 150.00, 45, 55, 50, 2, 2, 2, 2);
insert into camisa_material (id_camisa, id_material) values (2, 4);

insert into camisa (nome, descricao, cor, preco, largura, comprimento, estoque, tamanho, id_fornecedor, id_estilo, id_marca) 
            values ('Camisa3', 'Camisa3','Rosa', 50.00, 40, 50, 30, 3, 3, 3, 3);
insert into camisa_material (id_camisa, id_material) values (3, 2);


insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('111111','lugar1','bairro1','11','complementando1','palmas','tocantins');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('222222','l2','b2','22','c2','goias','goiania');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('333333','l3','b3','33','c3','São Paulo','São Paulo');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('444444','l4','b4','44','c4','Manaus','Amazonas');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('555555','l5','b5','55','c5','Luzimangues','Luzivegas');


insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('Erick', 'erick@gmail.com', 'GU5e4piE62AOdQr2e5/r0In9A7OJ89TjYO0SxgzZysU5HyEtOo2uzOiH3xUqXEQXEWXQCTkB/LQeiS4m0bFs7w==', 1, 4, 1,'erick');
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('Amir', 'amir@gmail.com','GU5e4piE62AOdQr2e5/r0In9A7OJ89TjYO0SxgzZysU5HyEtOo2uzOiH3xUqXEQXEWXQCTkB/LQeiS4m0bFs7w==', 1, 5, 2, 'amir');
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('fulano', 'fulano@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2, 6, 3, 'fulano');
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('ciclano', 'ciclano@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1, 7, 3, 'ciclano');
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('mussatto', 'mussarela@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1, 8, 4, 'mussatto');


insert into funcionario (cargo, id_usuario) values ('administrador', 1);
insert into funcionario (cargo, id_usuario) values ('patrão', 2);

insert into cliente (cpf, id_usuario) values ('11111111111', 3);
insert into cliente (cpf, id_usuario) values ('22222222222', 4);
insert into cliente (cpf, id_usuario) values ('33333333333', 5);

insert into itemPedido(quantidade, id_camisa) values (1, 1);

INSERT INTO pedido (data, total, status, pagamento, id_cliente)
VALUES ('2024-06-14 10:00:00', 250.00, 1, 1, 1);


