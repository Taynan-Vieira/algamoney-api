CREATE TABLE IF NOT EXISTS public.categoria(
    codigo SERIAL NOT null ,
    nome VARCHAR(50),
    CONSTRAINT pktcc_codigo PRIMARY KEY (codigo)

);

INSERT INTO categoria(nome)
VALUES ('LAZER'),
       ('ALIMENTACAO'),
       ('SUPERMECADO'),
       ('FARMACIA'),
       ('OUTROS');