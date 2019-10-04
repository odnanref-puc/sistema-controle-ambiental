------------------------------------------------------------------------
------------------------- SegurancaComunicacao -------------------------
------------------------------------------------------------------------

------------ UNIDADE_EXPLORACAO ------------
insert into unidade_exploracao (nome,latitude,longitude,bairro,cidade,estado,pais,inicio_operacao,fim_operacao,situacao,capacidade_prevista)values('Mina Córrego do Feijão', '20º 08´ 36" S', '44º 11´ 59" W', 'Córrego do Feijão', 'Brumadinho', 'Minas Gerais', 'Brasil', '1976-01-01', null, '2', 300);
insert into unidade_exploracao (nome,latitude,longitude,bairro,cidade,estado,pais,inicio_operacao,fim_operacao,situacao,capacidade_prevista)values('Barragem de Mariana', '20º 22 40´ S', '43º 24´ 58" W', 'Santa Rita Durão', 'Mariana', 'Minas Gerais', 'Brasil', '2007-01-01', null, '3', 250);


------------ RISCO ------------
insert into risco (descricao,gravidade,impacto,probabilidade,acao,situacao,unidade_exploracao_id)values
('Rachaduras nas barragens e umidade excessiva aos redores', 5, 'Alagamento dos arredores, podendo afetar as populações próximas', 40, 'Reforçar as barragens, com início urgente', 'Aguardando aprovação de orçamento', 1);


------------ RESIDENCIA_RISCO ------------
insert into residencia_risco (endereco,numero,bairro,cidade,estado,pais,cep,unidade_exploracao_id)values
('Rua Cesar Brumo', 123, 'Córrego do Feijão', 'Brumadinho', 'Minas Gerais', 'Brasil', '35460-000', 1),
('Rua Cesar Brumo', 157, 'Córrego do Feijão', 'Brumadinho', 'Minas Gerais', 'Brasil', '35460-000', 1),
('Rua Cesar Brumo', 284, 'Córrego do Feijão', 'Brumadinho', 'Minas Gerais', 'Brasil', '35460-000', 1);

insert into residencia_risco (endereco,numero,bairro,cidade,estado,pais,cep,unidade_exploracao_id)values
('Rua Minas', 999, 'Santa Rita Durão', 'Mariana', 'Minas Gerais', 'Brasil', '99999-999', 2);

------------ PESSOA ------------
insert into pessoa (documento,nome,nascimento,email,telefone,residencia_risco_id,unidade_exploracao_id)values
('853.857.570-80','Maria Fonseca','1980-06-03','maria@gmail.com','(31)99871-3018',1,1),
('021.979.310-75','João Cardoso','1995-03-18','joao@hotmail.com','(31)99872-2015',3,1),
('626.795.890-68','Erika Pereira','1998-12-27','erika@yahoo.com.br','(31)99873-9412',2,1),
('302.725.990-34','Fabricio Carvalho','2005-01-11','fabricio@gmail.com','(31)99874-9911',1,1);

insert into pessoa (documento,nome,nascimento,email,telefone,residencia_risco_id,unidade_exploracao_id)values
('626.795.890-68','Fernando PUC','2000-01-01','odnanref.puc@gmail.com','(31)99999-9999',4,2);
	
------------------------------------------------------------------------
---------------------------- Monitoramento -----------------------------
------------------------------------------------------------------------
insert into sensor (situacao,unidade_exploracao_id)values
('ativo',1),
('ativo',1),
('desativo',1),
('ativo',2),
('desativo',2);

-- -----------------------------------------------------
-- Table Dados_Sensor
-- -----------------------------------------------------
insert into dados_sensor (temperatura,pressao,sensor_id)values
(22.5, 50.4, 6),
(23.3, 62.8, 6),
(23.4, 70.1, 7),
(24.1, 40.2, 7),
(25.2, 50.9, 8),
(22.7, 48.0, 8),
(23.9, 46.5, 9),
(40.6, 77.1, 9),
(41.8, 76.8, 9),
(43.3, 56.8, 9);


  
------------------------------------------------------------------------
---------------------------- Producao -----------------------------
------------------------------------------------------------------------  
insert into Producao_Diaria (data, minerio, qde_etapa_extracao, qde_etapa_britagem, qde_etapa_classificacao, qde_etapa_remocao_rejeitos, qde_etapa_estocagem, qde_etapa_carregamento, qde_etapa_embarque, unidade_exploracao_id)values
('2019-08-01', 'Ferro', 700, 600, 500, 400, 300, 200, 100, 1),
('2019-08-02', 'Alumínio', 400, 380, 350, 200, 180, 170, 160, 1),
('2019-08-03', 'Ferro', 790, 670, 600, 500, 450, 430, 420, 1),
('2019-08-04', 'Ferro', 660, 650, 600, 580, 550, 530, 510, 2),
('2019-08-05', 'Alumínio', 990, 920, 880, 850, 840, 810, 760, 2);
 

-- -----------------------------------------------------
-- Table Ativo_na_Producao_Diaria
-- -----------------------------------------------------
insert into Ativo_na_Producao_Diaria (ativo_id, producao_diaria_id)values
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5);

-- -----------------------------------------------------
-- Table Funcionario_na_Producao_Diaria
-- -----------------------------------------------------
insert into Funcionario_na_Producao_Diaria (funcionario_id, producao_diaria_id)values
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5),
(10, 5);

-- -----------------------------------------------------
-- Table Problema
-- -----------------------------------------------------
insert into Problema (descricao, producao_diaria_id)values
('Quebrou o caminhao de placa ABC-1234', 1),
('Acidente envolvendo os funcionários Carlos Braga e Marcos Souza', 3),
('Forte tempestade ocasionou desmoronamento em partes da obra', 5);

  
------------------------------------------------------------------------
---------------------------- Recursos -----------------------------
------------------------------------------------------------------------  
insert into Ativo(
nome,
marca,
modelo,
descricao,
fabricante,
data_aquisicao,
valor_aquisicao,
tempo_garantia,
vida_util,
valor_residual,
situacao,
tipo
)values
('Perfuratriz Giratória', 'Cater', 'MD6250', 'Perfuratriz Giratória', 'Cater', '2019-05-01', 200000, 2, 10, 20000, 'OPERACAO', 'IMOBILIZADO' ),
('Perfuratriz Giratória', 'Cater', 'MD6540C', 'Perfuratriz Giratória', 'Cater', '2016-05-01', 150000, 2, 10, 15000, 'MANUTENCAO', 'IMOBILIZADO' ),
('Escavadeira a cabo', 'Cater', '7495 COM HYDRACROWD', 'Escavadeira a cabo', 'Cater', '2017-12-01', 300000, 2, 10, 30000, 'OPERACAO', 'IMOBILIZADO' ),
('Caminhão articulado', 'Cater', '725C2', 'Caminhão articulado', 'Cater', '208-08-01', 120000, 2, 10, 12000, 'MANUTENCAO', 'IMOBILIZADO' ),
('Escavadeira hidráulica', 'Cater', '6020B', 'Escavadeira hidráulica de mineração', 'Cater', '2019-02-01', 400000, 2, 7, 40000, 'OPERACAO', 'IMOBILIZADO' );
  
  
 -- -----------------------------------------------------
-- Table Funcionario
-- ----------------------------------------------------- 
insert into Funcionario(
nome,
endereco,
bairro,
cidade,
estado,
pais,
data_inicio,
cargo,
situacao
)values
('Marcelo Cardoso', 'Av do Estado', 'Mooca', 'São Paulo', 'SP', 'Brasil', '2019-05-02', 'Engenheiro', 'ativo'),
('Marcos Fonseca', 'Av Paulista', 'Consolação', 'São Paulo', 'SP', 'Brasil', '2009-11-23', 'Operador De Equipamento De Mineração II', 'ativo'),
('João Silva', 'Av do Estado', 'Mooca', 'São Paulo', 'SP', 'Brasil', '2019-05-02', 'Operador De Equipamento De Mineração I', 'ativo'),
('Sebastião Gomes', 'Av do Estado', 'Consolação', 'São Paulo', 'SP', 'Brasil', '2019-05-02', 'Inspetor De Manutenção Mecânica', 'ativo'),
('Celso Pereira', 'Av do Estado', 'Mooca', 'São Paulo', 'SP', 'Brasil', '2019-05-02', 'Comprador Sênior', 'ativo');
  
  
  
  
  
  
  
  
  
  
  
  