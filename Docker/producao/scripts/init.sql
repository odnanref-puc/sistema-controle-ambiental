create database producao;

\c producao

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

CREATE TABLE Ativo_na_Producao_Diaria (
  ativo_id INT NOT NULL,
  producao_diaria_id INT NOT NULL,
  PRIMARY KEY (ativo_id, producao_diaria_id),
  CONSTRAINT fk_ativo_has_producao_diaria_producao_diaria
    FOREIGN KEY (producao_diaria_id)
    REFERENCES Producao_Diaria (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE Funcionario_na_Producao_Diaria (
  funcionario_id INT NOT NULL,
  producao_diaria_id INT NOT NULL,
  PRIMARY KEY (funcionario_id, producao_diaria_id),
  CONSTRAINT fk_funcionario_has_producao_diaria_producao_diaria
    FOREIGN KEY (producao_diaria_id)
    REFERENCES Producao_Diaria (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

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
