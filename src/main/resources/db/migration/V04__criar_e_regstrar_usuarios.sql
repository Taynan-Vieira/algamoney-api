CREATE TABLE IF NOT EXISTS PUBLIC.usuario(
    codigo BIGINT,
    nome VARCHAR(50),
    email VARCHAR(50),
    senha VARCHAR(150),
    CONSTRAINT pkusua_codigo PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS PUBLIC.permissao(
    codigo BIGINT,
    descricao VARCHAR(50) NOT NULL,
    CONSTRAINT pkperm_codigo PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS PUBLIC.usuario_permissao(
    codigo_usuario BIGINT NOT NULL,
    codigo_permissao BIGINT NOT NULL,

    CONSTRAINT codigo_usuario FOREIGN KEY(codigo_usuario)
        REFERENCES usuario (codigo),
    CONSTRAINT codigo_permissao FOREIGN KEY (codigo_permissao)
        REFERENCES permissao (codigo)
);

INSERT INTO usuario (codigo, nome, email, senha)
    values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.'),
            (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO permissao (codigo, descricao)
values (1, 'ROLE_CADASTRAR_CATEGORIA'),
       (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (codigo, descricao)
    values  (3, 'ROLE_CADASTRAR_PESSOA'),
            (4, 'ROLE_REMOVER_PESSOA'),
            (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO permissao (codigo, descricao)
values (6, 'ROLE_CADASTRAR_LANCAMENTO'),
       (7, 'ROLE_REMOVER_LANCAMENTO'),
       (8, 'ROLE_PESQUISAR_LANCAMENTO');

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (2, 2),
       (2, 5),
       (2, 8);
