create database negocios_comunicacao;

\c negocios_comunicacao

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
