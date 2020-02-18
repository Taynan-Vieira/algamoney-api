CREATE TABLE IF NOT EXISTS PUBLIC.categoria(
    codigo SERIAL NOT NULL ,
    nome VARCHAR(50) NOT NULL,
    CONSTRAINT pkcat_codigo PRIMARY KEY (codigo)

);

INSERT INTO categoria(nome)
VALUES ('LAZER'),
       ('ALIMENTACAO'),
       ('SUPERMECADO'),
       ('FARMACIA'),
       ('OUTROS');