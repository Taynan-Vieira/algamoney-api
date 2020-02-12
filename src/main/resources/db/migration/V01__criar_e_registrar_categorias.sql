CREATE TABLE IF NOT EXISTS public.categoria(
    codigo SERIAL NOT NULL ,
    nome VARCHAR(50) NOT NULL,
    CONSTRAINT pktcc_codigo PRIMARY KEY (codigo)

);

INSERT INTO categoria(nome)
VALUES ('LAZER'),
       ('ALIMENTACAO'),
       ('SUPERMECADO'),
       ('FARMACIA'),
       ('OUTROS');