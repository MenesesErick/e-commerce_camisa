insert INTO estilo (nome, descricao) values ('StreetWear', 'Camisa estilo Street');
insert INTO estilo (nome, descricao) values ('Esportivo', 'Camisas de Esportes');

insert INTO marca (nome) values ('Nike');
insert INTO marca (nome) values ('Puma');
insert INTO marca (nome) values ('Seila');
insert INTO marca (nome) values ('SRB');

insert into telefone(codigoArea, numero) values ('11', '123456789');
insert into telefone(codigoArea, numero) values ('22', '2222-2222');
insert into telefone(codigoArea, numero) values ('33', '3333-3333');
insert into telefone(codigoArea, numero) values ('45', '4545-4545');
insert into telefone(codigoArea, numero) values ('77', '7777-7777');
insert into telefone(codigoArea, numero) values ('88', '8888-8888');
insert into telefone(codigoArea, numero) values ('123', '7474-4747');
insert into telefone(codigoArea, numero) values ('234', '7897-4566');
insert into telefone(codigoArea, numero) values ('345', '8524-9645');
insert into telefone(codigoArea, numero) values ('101', '1010-1010');
insert into telefone(codigoArea, numero) values ('111', '1111-1111');
insert into telefone(codigoArea, numero) values ('112', '1212-1212');
insert into telefone(codigoArea, numero) values ('113', '1313-1313');
insert into telefone(codigoArea, numero) values ('114', '1414-1414');



insert INTO fornecedor(nome, gmail, id_telefone) values ('tomaAi', 'tomaai@gmail.com', 6);
insert into fornecedor(nome, gmail, id_telefone) values ('FornecedorTeste', 'ft@gmail.com', 7);
insert into fornecedor(nome, gmail, id_telefone) values ('FornecedorLegal', 'forneLegal@gmail.com', 8);

insert INTO material (nome, porcentagem) values ('Algodao', 100), ('Cetim', 100), ('Poliester', 50),('DryFit', 100), ('DryFit', 50);

insert into camisa (nome, descricao, cor, preco, largura, comprimento, estoque, tamanho, id_fornecedor, id_estilo, id_marca) 
            values ('Camisa1', 'CamisaComDragão','Branco', 100.00, 45, 55, 100, 1, 1, 1, 1);
insert into camisa_material (id_camisa, id_material) values (1, 1),(1,2);

insert into camisa (nome, descricao, cor, preco, largura, comprimento, estoque, tamanho, id_fornecedor, id_estilo, id_marca) 
            values ('CamisaTeste', 'CamisaTestesdelete','Branco', 100.00, 45, 55, 100, 4, 1, 1, 1);
insert into camisa_material (id_camisa, id_material) values (2,1);

insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('741741','lugar','arnos','74','ali','palmas','tocantins');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('33333','p','a','8','hum','goias','goiania');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('454545','qu','qa','5','ixi','baixa','DaEgua');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('888','teste','teste','8','teste','testec','testee');
insert into endereco(cep, logradouro, bairro, numero, complemento, cidade, estado) 
            values ('000','deleteteste','delete','0','dteste','deleteteste','deletee');

insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco) 
            values ('ciclano', 'cleitonmatadordeporco@gmail.com', '123', 1, 1, 1);
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco) 
            values ('fulano', 'dragaoguerreiro@gmail.com', '321', 2, 2, 2);
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco) 
            values ('euuu', 'euzinhoo@gmail.com', '222', 1, 3, 3);
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco) 
            values ('user2', 'user2@gmail.com', '444', 2, 4, 1);
insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('eu', 'euzão@gmail.com', 'GU5e4piE62AOdQr2e5/r0In9A7OJ89TjYO0SxgzZysU5HyEtOo2uzOiH3xUqXEQXEWXQCTkB/LQeiS4m0bFs7w==', 1, 5, 4,'programador');


insert into cliente (cpf, id_usuario) values ('745896123', 1);
insert into cliente (cpf, id_usuario) values ('123789456', 2);

insert into funcionario (cargo, id_usuario) values ('admiro', 3);
insert into funcionario (cargo, id_usuario) values ('ti', 4);


insert into usuario (nome, gmail, senha, sexo, id_telefone, id_endereco, username) 
            values ('admer', 'adminis@gmail.com', '123', 2,8, 1, 'admin');

insert into funcionario (cargo, id_usuario) values ('administrador', 5);