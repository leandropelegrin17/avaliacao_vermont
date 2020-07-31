DROP TABLE IF EXISTS ESTUDANTE;

CREATE TABLE ESTUDANTE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NOME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  TELEFONE VARCHAR(20) DEFAULT NULL,
  MATRICULA VARCHAR(20) NOT NULL,
  CURSO VARCHAR(250) DEFAULT NULL
);

INSERT INTO ESTUDANTE (NOME, EMAIL, TELEFONE, MATRICULA, CURSO) VALUES
  ('Xawoy', 'xawoy@tms.com.br', '7777', '123456', 'Engenharia da Computação'),
  ('Furae', 'furae@tms.com.br', 'B7778', '678912', 'Ciência da Computação'),
  ('Fupuy', 'fupuy@tms.com.br', '7779', '321654', 'Engenharia da Computação'),
  ('Kuer', 'kuer@tms.com.br', '7780', '654987', 'Análise de Dados'),
  ('Blias', 'blias@tms.com.br', '7781', '666131', 'Ciência da Computação');