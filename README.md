# trabalhoWebII

SCRIPT TABELA BANCO:
CREATE DATABASE trabalhowebii;
USE trabalhowebii;
SELECT * FROM tb_usuario;
SELECT * FROM atendimento;
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

UPDATE tb_usuario SET nome_usuario = "Fernando Carvalho Birznek", senha_usuario = "teste123", rua_usuario = "Rua Octavio schiavon", 
			numero_usuario = "64",
            complemento_usuario = "3", bairro_usuario = "Uberaba", cep_usuario = "81580530", cidade_usuario = 2799, estado_usuario = 18, 
            telefone_usuario = "41996112606", email_usuario = "fernandocbirznek@hotmail.com", cpf_usuario = "08036453924" WHERE id_usuario = 4;

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

SELECT * FROM tb_usuario;

/* ATENDIMENTO E PRODUTOS */

CREATE TABLE Atendimento (
    id int PRIMARY KEY,
    dataAtenidmento date,
    cliente int,
    situacao boolean,
    descricao varchar(100),
    solucao varchar(100),
    fk_TipoAtendimento_idTipoAtendimento int
);

CREATE TABLE TipoAtendimento (
    idTipoAtendimento int PRIMARY KEY,
    nomeTipoAtendimento varchar(50),
    fk_Produto_idProduto int
);

CREATE TABLE Produto (
    idProduto int PRIMARY KEY,
    nomeProduto varchar(50),
    categoria int,
    descricaoProduto varchar(100),
    pesoProduto int
);
 
ALTER TABLE Atendimento ADD CONSTRAINT FK_Atendimento_2
    FOREIGN KEY (fk_TipoAtendimento_idTipoAtendimento)
    REFERENCES TipoAtendimento (idTipoAtendimento)
    ON DELETE CASCADE;
 
ALTER TABLE TipoAtendimento ADD CONSTRAINT FK_TipoAtendimento_2
    FOREIGN KEY (fk_Produto_idProduto)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE;

INSERT INTO Produto VALUES (1, 'shampo barato', 1, 'para usar nos cabelos', 2), (2, 'dentadura', 2, 'para usar na boca', 1),
	(3, 'mascara facial', 3, 'para usar no rosto', 5);
    
INSERT INTO TipoAtendimento VALUES (1, 'Lavar cabelo', 1), (2, 'Arrumar dente', 2),
	(3, 'tratamento de beleza', 3);
    
INSERT INTO Atendimento VALUES
	(1, "20140605", 4, false, "Quero que seja lavado duas vezes", "solu????o", 1),
    (2, "20220817", 1, true, "Implante dentario da melhor qualidade, com dente de ouro se possivel", "solu????o aaaa", 2),
    (3, "20220810", 4, true, "Mascara facial para rejuvenecer", "solu????o 123", 3);

/* ESTADOS E CIDADES */
SELECT * FROM estados;
CREATE TABLE estados (
  id int(11) PRIMARY KEY NOT NULL,
  nome varchar(75) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL
);

INSERT INTO estados (id, nome, uf) VALUES
(1, 'Acre', 'AC'), (2, 'Alagoas', 'AL'), (3, 'Amazonas', 'AM'), (4, 'Amap??', 'AP'), (5, 'Bahia', 'BA'), (6, 'Cear??', 'CE'),
(7, 'Distrito Federal', 'DF'), (8, 'Esp??rito Santo', 'ES'), (9, 'Goi??s', 'GO'), (10, 'Maranh??o', 'MA'), (11, 'Minas Gerais', 'MG'), (12, 'Mato Grosso do Sul', 'MS'),
(13, 'Mato Grosso', 'MT'), (14, 'Par??', 'PA'), (15, 'Para??ba', 'PB'), (16, 'Pernambuco', 'PE'), (17, 'Piau??', 'PI'),
(18, 'Paran??', 'PR'), (19, 'Rio de Janeiro', 'RJ'), (20, 'Rio Grande do Norte', 'RN'), (21, 'Rond??nia', 'RO'), (22, 'Roraima', 'RR'),
(23, 'Rio Grande do Sul', 'RS'), (24, 'Santa Catarina', 'SC'), (25, 'Sergipe', 'SE'), (26, 'S??o Paulo', 'SP'), (27, 'Tocantins', 'TO');

CREATE TABLE tb_cidade (
    id int PRIMARY KEY,
    nome varchar(100),
    fk_estado_id int
);

ALTER TABLE tb_cidade ADD CONSTRAINT FK_cidade_2
    FOREIGN KEY (fk_estado_id)
    REFERENCES estados (id)
    ON DELETE RESTRICT;
    
DROP TABLE tb_cidade;
SELECT  * FROM tb_cidade;

INSERT INTO tb_cidade (id, nome, fk_estado_id) VALUES
(1, 'Afonso Cl??udio', 8), (2, '??gua Doce do Norte', 8), (3, '??guia Branca', 8), (4, 'Alegre', 8), (5, 'Alfredo Chaves', 8), (6, 'Alto Rio Novo', 8),
(7, 'Anchieta', 8), (8, 'Apiac??', 8), (9, 'Aracruz', 8), (10, 'Atilio Vivacqua', 8),
(79, 'Acrel??ndia', 1), (80, 'Assis Brasil', 1), (81, 'Brasil??ia', 1), (82, 'Bujari', 1), (83, 'Capixaba', 1), (84, 'Cruzeiro do Sul', 1), (85, 'Epitaciol??ndia', 1),
(86, 'Feij??', 1), (87, 'Jord??o', 1), (88, 'M??ncio Lima', 1),
(108, 'Bel??m', 2), (109, 'Belo Monte', 2), (110, 'Boca da Mata', 2), (111, 'Branquinha', 2), (112, 'Cacimbinhas', 2), (113, 'Cajueiro', 2), (114, 'Campestre', 2), 
(115, 'Campo Alegre', 2), (116, 'Campo Grande', 2), (117, 'Canapi', 2),
(209, 'Macap??', 4), (210, 'Mazag??o', 4), (211, 'Oiapoque', 4), (212, 'Pedra Branca do Amapar??', 4), (213, 'Porto Grande', 4),
(214, 'Pracu??ba', 4), (215, 'Santana', 4), (216, 'Serra do Navio', 4), (217, 'Tartarugalzinho', 4), (218, 'Vit??ria do Jari', 4),
(225, 'Autazes', 3), (226, 'Barcelos', 3), (227, 'Barreirinha', 3), (228, 'Benjamin Constant', 3), (229, 'Beruri', 3), (230, 'Boa Vista do Ramos', 3),
(231, 'Boca do Acre', 3), (232, 'Borba', 3), (233, 'Caapiranga', 3), (234, 'Canutama', 3), (235, 'Carauari', 3),
(288, 'Alcoba??a', 5), (289, 'Almadina', 5), (290, 'Amargosa', 5), (291, 'Am??lia Rodrigues', 5), (292, 'Am??rica Dourada', 5),
(293, 'Anag??', 5), (294, 'Andara??', 5), (295, 'Andorinha', 5), (296, 'Angical', 5), (297, 'Anguera', 5),
(729, 'Camocim', 6), (730, 'Campos Sales', 6), (731, 'Canind??', 6), (732, 'Capistrano', 6), (733, 'Caridade', 6), (734, 'Carir??', 6), (735, 'Cariria??u', 6), (736, 'Cari??s', 6),
(737, 'Carnaubal', 6), (738, 'Cascavel', 6),
(907, 'Araguapaz', 9), (908, 'Aren??polis', 9), (909, 'Aruan??', 9), (910, 'Auril??ndia', 9), (911, 'Avelin??polis', 9), (912, 'Baliza', 9),
(913, 'Barro Alto', 9), (914, 'Bela Vista de Goi??s', 9), (915, 'Bom Jardim de Goi??s', 9), (916, 'Bom Jesus de Goi??s', 9),
(1143, 'Araguan??', 10), (1144, 'Araioses', 10), (1145, 'Arame', 10), (1146, 'Arari', 10), (1147, 'Axix??', 10), (1148, 'Bacabal', 10),
(1149, 'Bacabeira', 10), (1150, 'Bacuri', 10), (1151, 'Bacurituba', 10), (1152, 'Balsas', 10), (1364, 'Brasnorte', 13), (1365, 'C??ceres', 13), (1366, 'Campin??polis', 13),
(1367, 'Campo Novo do Parecis', 13), (1368, 'Campo Verde', 13), (1374, 'Chapada dos Guimar??es', 13),
(1521, 'Figueir??o', 12), (1522, 'Gl??ria de Dourados', 12), (1523, 'Guia Lopes da Laguna', 12), (1524, 'Iguatemi', 12), (1525, 'Inoc??ncia', 12), (1526, 'Itapor??', 12), (1527, 'Itaquira??', 12),
(1528, 'Ivinhema', 12), (1529, 'Japor??', 12), (1530, 'Jaraguari', 12),
(1590, 'Alvin??polis', 11), (1591, 'Alvorada de Minas', 11), (1592, 'Amparo do Serra', 11), (1593, 'Andradas', 11), (1594, 'Andrel??ndia', 11),
(1595, 'Angel??ndia', 11), (1596, 'Ant??nio Carlos', 11), (1597, 'Ant??nio Dias', 11), (1598, 'Ant??nio Prado de Minas', 11), (1599, 'Ara??a??', 11), (1600, 'Aracitaba', 11),
(2445, 'Breves', 14), (2446, 'Bujaru', 14), (2447, 'Cachoeira do Arari', 14), (2448, 'Cachoeira do Piri??', 14), (2449, 'Camet??', 14), (2450, 'Cana?? dos Caraj??s', 14),
(2451, 'Capanema', 14), (2452, 'Capit??o Po??o', 14), (2453, 'Castanhal', 14), (2454, 'Chaves', 14), (2455, 'Colares', 14), (2456, 'Concei????o do Araguaia', 14),
(2590, 'Boa Vista', 15), (2591, 'Bom Jesus', 15), (2592, 'Bom Sucesso', 15), (2593, 'Bonito de Santa F??', 15), (2594, 'Boqueir??o', 15),
(2595, 'Borborema', 15), (2596, 'Brejo do Cruz', 15), (2597, 'Brejo dos Santos', 15), (2598, 'Caapor??', 15), (2599, 'Cabaceiras', 15),
(2793, 'Alvorada do Sul', 18), (2794, 'Amapor??', 18), (2795, 'Amp??re', 18), (2796, 'Anahy', 18), (2797, 'Andir??', 18), (2798, '??ngulo', 18),
(2799, 'Antonina', 18), (2800, 'Ant??nio Olinto', 18), (2801, 'Apucarana', 18), (2802, 'Arapongas', 18), (2803, 'Arapoti', 18),
(3212, 'Bu??que', 16), (3213, 'Cabo de Santo Agostinho', 16), (3214, 'Cabrob??', 16), (3215, 'Cachoeirinha', 16), (3216, 'Caet??s', 16), (3217, 'Cal??ado', 16),
(3218, 'Calumbi', 16), (3219, 'Camaragibe', 16), (3220, 'Camocim de S??o F??lix', 16), (3221, 'Camutanga', 16), (3222, 'Canhotinho', 16),
(3403, 'Brejo do Piau??', 17), (3404, 'Buriti dos Lopes', 17), (3405, 'Buriti dos Montes', 17), (3406, 'Cabeceiras do Piau??', 17), (3407, 'Cajazeiras do Piau??', 17),
(3408, 'Cajueiro da Praia', 17), (3409, 'Caldeir??o Grande do Piau??', 17), (3410, 'Campinas do Piau??', 17), (3411, 'Campo Alegre do Fidalgo', 17), (3412, 'Campo Grande do Piau??', 17),
(3413, 'Campo Largo do Piau??', 17), (3414, 'Campo Maior', 17), (3415, 'Canavieira', 17),
(3631, 'Maric??', 19), (3632, 'Mendes', 19), (3633, 'Mesquita', 19), (3634, 'Miguel Pereira', 19), (3635, 'Miracema', 19), (3636, 'Natividade', 19),
(3637, 'Nil??polis', 19), (3638, 'Niter??i', 19), (3639, 'Nova Friburgo', 19), (3640, 'Nova Igua??u', 19),  (3641, 'Paracambi', 19), (3642, 'Para??ba do Sul', 19),
(3719, 'Equador', 20), (3720, 'Esp??rito Santo', 20), (3721, 'Extremoz', 20), (3722, 'Felipe Guerra', 20), (3723, 'Fernando Pedroza', 20), (3724, 'Flor??nia', 20),
(3725, 'Francisco Dantas', 20), (3726, 'Frutuoso Gomes', 20), (3727, 'Galinhos', 20), (3728, 'Goianinha', 20),
(3877, 'Augusto Pestana', 23), (3878, '??urea', 23), (3879, 'Bag??', 23), (3880, 'Balne??rio Pinhal', 23), (3881, 'Bar??o', 23),
(3882, 'Bar??o de Cotegipe', 23), (3883, 'Bar??o do Triunfo', 23), (3884, 'Barra do Guarita', 23), (3885, 'Barra do Quara??', 23), (3886, 'Barra do Ribeiro', 23),
(4351, 'Buritis', 21), (4352, 'Cabixi', 21), (4353, 'Cacaul??ndia', 21), (4354, 'Cacoal', 21), (4355, 'Campo Novo de Rond??nia', 21), (4356, 'Candeias do Jamari', 21), (4357, 'Castanheiras', 21),
(4358, 'Cerejeiras', 21), (4359, 'Chupinguaia', 21), (4360, 'Colorado do Oeste', 21), (4361, 'Corumbiara', 21), (4362, 'Costa Marques', 21),
(4363, 'Cujubim', 21), (4364, 'Espig??o d`Oeste', 21), (4365, 'Governador Jorge Teixeira', 21), (4366, 'Guajar??-Mirim', 21),
(4427, 'Ant??nio Carlos', 24), (4428, 'Api??na', 24), (4429, 'Arabut??', 24), (4430, 'Araquari', 24), (4431, 'Ararangu??', 24), (4432, 'Armaz??m', 24), (4433, 'Arroio Trinta', 24),
(4434, 'Arvoredo', 24), (4435, 'Ascurra', 24), (4436, 'Atalanta', 24),
(4750, 'Aruj??', 26), (4751, 'Asp??sia', 26), (4752, 'Assis', 26), (4753, 'Atibaia', 26), (4754, 'Auriflama', 26), (4755, 'Ava??', 26),
(4756, 'Avanhandava', 26), (4757, 'Avar??', 26), (4758, 'Bady Bassitt', 26), (4759, 'Balbinos', 26),
(5406, 'Propri??', 25), (5407, 'Riach??o do Dantas', 25), (5408, 'Riachuelo', 25), (5409, 'Ribeir??polis', 25), (5410, 'Ros??rio do Catete', 25), (5411, 'Salgado', 25),
(5412, 'Santa Luzia do Itanhy', 25), (5413, 'Santa Rosa de Lima', 25), (5414, 'Santana do S??o Francisco', 25), (5415, 'Santo Amaro das Brotas', 25), (5416, 'S??o Crist??v??o', 25),
(5454, 'Cachoeirinha', 27), (5455, 'Campos Lindos', 27), (5456, 'Cariri do Tocantins', 27), (5457, 'Carmol??ndia', 27), (5458, 'Carrasco Bonito', 27), (5459, 'Caseara', 27),
(5460, 'Centen??rio', 27), (5461, 'Chapada da Natividade', 27), (5462, 'Chapada de Areia', 27), (5463, 'Colinas do Tocantins', 27);

