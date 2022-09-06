# trabalhoWebII

SCRIPT TABELA BANCO:

CREATE DATABASE trabalhowebii;
USE trabalhowebii;

CREATE TABLE tb_usuario (
	id_usuario int PRIMARY KEY auto_increment,
    nome_usuario varchar(50),
    email_usuario varchar(50),
    senha_usuario varchar(50),
    cpf_usuario varchar(11),
    rua_usuario varchar(30),
    numero_usuario varchar(10),
    complemento_usuario varchar(30),
    bairro_usuario varchar(30),
    cep_usuario varchar(8),
    cidade_usuario int,
    estado_usuario int,
    telefone_usuario varchar(20),
    cargo_usuario int
);

INSERT INTO tb_usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, rua_usuario, numero_usuario,
	complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario) VALUES
    ("cliente", "cliente@cliente.com", "cliente", "98909035424", "rua cliente", "123", "2", "bairro cliente",
		"76272349", 2800, 18, "4198842376", 1);
        
INSERT INTO tb_usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, rua_usuario, numero_usuario,
	complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario) VALUES
    ("funcionario", "funcionario@funcionario.com", "funcionario", "34322211156", "rua funcionario", "456", "3", "bairro funcionario",
		"56454343", 259, 13, "41988009989", 2), 
	("gerente", "gerente@gerente.com", "gerente", "11122233345", "rua gerente", "789", "4", "bairro gerente",
		"11232444", 907, 9, "41229883212", 3);
