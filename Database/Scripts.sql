-- DROP TABLE Pessoa;
-- DROP TABLE residencia_risco;
-- DROP TABLE risco;
-- DROP TABLE unidade_exploracao;

-- -----------------------------------------------------
-- Table NegociosComunicacao.Unidade_Exploracao
-- -----------------------------------------------------
CREATE TABLE unidade_exploracao (
  id SERIAL NOT NULL,
  nome TEXT NULL,
  latitude TEXT NULL,
  longitude TEXT NULL,
  bairro TEXT NULL,
  cidade TEXT NULL,
  estado TEXT NULL,
  pais TEXT NULL,
  inicio_operacao DATE NULL,
  fim_operacao DATE NULL,
  situacao TEXT NULL,
  capacidade_prevista DECIMAL NULL,
  PRIMARY KEY (id));
  
-- -----------------------------------------------------
-- Table NegociosComunicacao.Risco
-- -----------------------------------------------------
CREATE TABLE risco (
  id SERIAL NOT NULL,
  descricao TEXT NULL,
  gravidade INT NULL,
  impacto TEXT NULL,
  probabilidade DECIMAL NULL,
  acao TEXT NULL,
  situacao TEXT NULL,
  unidade_exploracao_id INT NOT NULL,
  PRIMARY KEY (id, unidade_exploracao_id),
  CONSTRAINT fk_risco_unidade_exploracao
    FOREIGN KEY (unidade_exploracao_id)
    REFERENCES unidade_exploracao (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Table NegociosComunicacao.Residencia_Risco
-- -----------------------------------------------------
CREATE TABLE residencia_risco (
  id SERIAL NOT NULL,
  endereco TEXT NULL,
  numero INT NULL,
  bairro TEXT NULL,
  cidade TEXT NULL,
  estado TEXT NULL,
  pais TEXT NULL,
  cep TEXT NULL,
  unidade_exploracao_id INT NOT NULL,
  PRIMARY KEY (id, unidade_exploracao_id),
  CONSTRAINT fk_residencia_risco_unidade_exploracao
    FOREIGN KEY (unidade_exploracao_id)
    REFERENCES unidade_exploracao (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table NegociosComunicacao.Pessoa
-- -----------------------------------------------------
CREATE TABLE Pessoa (
  id SERIAL NOT NULL,
  documento TEXT,
  nome TEXT NULL,
  nascimento DATE NULL,
  email TEXT NULL,
  telefone TEXT NULL,
  residencia_risco_id INT NOT NULL,
  unidade_exploracao_id INT NOT NULL,
  PRIMARY KEY (id, residencia_risco_id, unidade_exploracao_id),
  CONSTRAINT fk_pessoa_residencia_risco
    FOREIGN KEY (residencia_risco_id, unidade_exploracao_id)
    REFERENCES residencia_risco (id, unidade_exploracao_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
	
	
-- DROP TABLE Dados_Sensor;
-- DROP TABLE Sensor;	
-- -----------------------------------------------------
-- Table Monitoramento.Sensor
-- -----------------------------------------------------
CREATE TABLE Sensor (
  id SERIAL NOT NULL,
  situacao TEXT NULL,
  unidade_exploracao_id INT NOT NULL,
  PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table Monitoramento.Dados_Sensor
-- -----------------------------------------------------
CREATE TABLE Dados_Sensor (
  id SERIAL NOT NULL,
  temperatura DECIMAL NULL,
  pressao DECIMAL NULL,
  sensor_id INT NOT NULL,
  data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id, sensor_id),
  CONSTRAINT fk_dados_sensor_sensor
    FOREIGN KEY (sensor_id)
    REFERENCES Sensor (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



-- DROP TABLE Problema;
-- DROP TABLE Funcionario_na_Producao_Diaria;
-- DROP TABLE Ativo_na_Producao_Diaria;
-- DROP TABLE Producao_Diaria;
-- -----------------------------------------------------
-- Table Producao.Producao_Diaria
-- -----------------------------------------------------
CREATE TABLE Producao_Diaria (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  minerio TEXT NOT NULL,
  qde_etapa_extracao DECIMAL NULL,
  qde_etapa_britagem DECIMAL NULL,
  qde_etapa_classificacao DECIMAL NULL,
  qde_etapa_remocao_rejeitos DECIMAL NULL,
  qde_etapa_estocagem DECIMAL NULL,
  qde_etapa_carregamento DECIMAL NULL,
  qde_etapa_embarque DECIMAL NULL,
  unidade_exploracao_id INT NOT NULL,
  CONSTRAINT unico_diario_producao UNIQUE (minerio, data, unidade_exploracao_id),
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table Producao.Ativo_na_Producao_Diaria
-- -----------------------------------------------------
CREATE TABLE Ativo_na_Producao_Diaria (
  ativo_id INT NOT NULL,
  producao_diaria_id INT NOT NULL,
  PRIMARY KEY (ativo_id, producao_diaria_id),
  CONSTRAINT fk_ativo_has_producao_diaria_producao_diaria
    FOREIGN KEY (producao_diaria_id)
    REFERENCES Producao_Diaria (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table Producao.Funcionario_na_Producao_Diaria
-- -----------------------------------------------------
CREATE TABLE Funcionario_na_Producao_Diaria (
  funcionario_id INT NOT NULL,
  producao_diaria_id INT NOT NULL,
  PRIMARY KEY (funcionario_id, producao_diaria_id),
  CONSTRAINT fk_funcionario_has_producao_diaria_producao_diaria
    FOREIGN KEY (producao_diaria_id)
    REFERENCES Producao_Diaria (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table Producao.Problema
-- -----------------------------------------------------
CREATE TABLE Problema (
  id SERIAL NOT NULL,
  descricao TEXT NULL,
  producao_diaria_id INT NOT NULL,
  PRIMARY KEY (id, producao_diaria_id),
  CONSTRAINT fk_problema_producao_diaria
    FOREIGN KEY (producao_diaria_id)
    REFERENCES Producao_Diaria (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);






-- DROP TABLE Ativo;
-- DROP TABLE Funcionario;
-- -----------------------------------------------------
-- Table Recursos.Ativo
-- -----------------------------------------------------
CREATE TABLE Ativo (
  id SERIAL NOT NULL,
  nome TEXT NULL,
  marca TEXT NULL,
  modelo TEXT NULL,
  descricao TEXT NULL,
  fabricante TEXT NULL,
  data_aquisicao DATE NULL,
  valor_aquisicao DECIMAL NULL,
  tempo_garantia INT NULL,
  vida_util INT NULL,
  valor_residual DECIMAL NULL,
  situacao TEXT NULL,
  tipo TEXT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table Recursos.Funcionario
-- -----------------------------------------------------
CREATE TABLE Funcionario (
  id SERIAL NOT NULL,
  nome TEXT NULL,
  endereco TEXT NULL,
  bairro TEXT NULL,
  cidade TEXT NULL,
  estado TEXT NULL,
  pais TEXT NULL,
  data_inicio DATE NULL,
  cargo TEXT NULL,
  situacao TEXT NULL,
  PRIMARY KEY (id));




	
