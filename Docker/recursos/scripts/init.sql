create database recursos;

\c recursos

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
