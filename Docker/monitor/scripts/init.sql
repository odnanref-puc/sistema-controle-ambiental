create database monitoramento;

\c monitoramento

CREATE TABLE Sensor (
  id SERIAL NOT NULL,
  situacao TEXT NULL,
  unidade_exploracao_id INT NOT NULL,
  PRIMARY KEY (id));

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
