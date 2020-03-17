CREATE TABLE IF NOT EXISTS PUBLIC.lancamento
(
    codigo           SERIAL       NOT NULL,
    descricao        VARCHAR(50)  NOT NULL,
    data_vencimento  DATE         NOT NULL,
    data_pagamento   DATE,
    valor            DECIMAL      NOT NULL,
    observacao       VARCHAR(100),
    tipo             VARCHAR(20)  NOT NULL,
    codigo_categoria BIGINT       NOT NULL,
    codigo_pessoa    BIGINT       NOT NULL,

    CONSTRAINT pklan_codigo PRIMARY KEY (codigo),
    constraint codigo_categoria foreign key (codigo_categoria)
        references categoria (codigo),
    constraint codigo_pessoa foreign key (codigo_pessoa)
        references pessoa (codigo)
);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria,
                        codigo_pessoa)
values ('Salário mensal', '2020-06-10', null, 500.00, 'Distribuição de lucros', 'RECEITA', 1, 1),
       ('Bahamas', '2020-02-10', '2020-02-10', 100.32, null, 'DESPESA', 2, 2),
       ('Top Club', '2020-06-10', null, 120, null, 'RECEITA', 3, 3),
       ('CEMIG', '2020-02-10', '2020-02-10', 110.44, 'Geração', 'RECEITA', 3, 4),
       ('DMAE', '2020-06-10', null, 200.30, null, 'DESPESA', 3, 5),
       ('Extra', '2020-03-10', '2020-03-10', 1010.32, null, 'RECEITA', 4, 6),
       ('Bahamas', '2020-06-10', null, 500, null, 'RECEITA', 1, 7),
       ('Top Club', '2020-03-10', '2020-03-10', 400.32, null, 'DESPESA', 4, 8),
       ('Despachante', '2020-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 9),
       ('Pneus', '2020-04-10', '2020-04-10', 665.33, null, 'RECEITA', 5, 10),
       ('Café', '2020-06-10', null, 8.32, null, 'DESPESA', 1, 5),
       ('Eletrônicos', '2020-04-10', '2020-04-10', 2100.32, null, 'DESPESA', 5, 4),
       ('Instrumentos', '2020-06-10', null, 1040.32, null, 'DESPESA', 4, 3),
       ('Café', '2020-04-10', '2020-04-10', 4.32, null, 'DESPESA', 4, 2),
       ('Lanche', '2020-06-10', null, 10.20, null, 'DESPESA', 4, 1);
