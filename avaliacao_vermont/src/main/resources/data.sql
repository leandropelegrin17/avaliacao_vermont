DROP TABLE IF EXISTS ESTUDANTE;

CREATE TABLE ESTUDANTE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NOME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  TELEFONE VARCHAR(20) DEFAULT NULL
);

INSERT INTO ESTUDANTE (NOME, EMAIL, TELEFONE) VALUES
  ('Xawoy', 'xawoy@tms.com.br', '7777'),
  ('Furae', 'furae@tms.com.br', 'B7778'),
  ('Fupuy', 'fupuy@tms.com.br', '7779'),
  ('Kuer', 'kuer@tms.com.br', '7780'),
  ('Blias', 'blias@tms.com.br', '7781');