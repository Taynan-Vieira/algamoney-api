CREATE TABLE IF NOT EXISTS PUBLIC.pessoa
(
    codigo      SERIAL      NOT NULL,
    nome        VARCHAR(50) NOT NULL,
    ativo       BOOLEAN     NOT NULL,
    logradouro  VARCHAR(50),
    numero      VARCHAR(5),
    complemento VARCHAR(50),
    bairro      VARCHAR(50),
    cep         VARCHAR(8),
    cidade      VARCHAR(50),
    estado      VARCHAR(50),

    CONSTRAINT pkpes_codigo PRIMARY KEY (codigo)
);

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('Ruan Raul Gabriel Nogueira', true, 'Rua Osvaldo Cruz', '124', null, 'Cabral', '64000540', 'Teresina', 'PI'),
       ('Elisa Simone Rita da Mata', true, 'Rua Adilson da Fraga', '170', null, 'Carlos Germano Naumann', '29705221',
        'Colatina', 'ES'),
       ('Julio Ruan Pedro da Mota', false, 'Rodovia Antiga GO-352', '955', 'Parque Trindade II',
        'Aparecida de Goiânia', '68542789', 'Goias', 'GO'),
       ('Benício Samuel Raul Nunes', true, 'Rua Moisés Misael de Paula', '744', null, 'Jargoes', '58410518',
        'Campina Grande', 'PB'),
       ('Danilo Leandro Levi Silva', true, 'Quadra 605 Sul Alameda 10', '311', null, 'Taubate', '68954112',
        'Plano Diretor Sul', 'TO'),
       ('Bryan Isaac André Moreira', false, 'Rua Delcio Antunes Drumond', '978', null, 'Trizidela', '87459663',
        'Três Marias', 'MG'),
       ('Cauê Noah Rezende', true, 'Rua Barata Ribeiro', '512', null, 'Copacabana', '45879663', 'Copacabana', 'RJ'),
       ('Cláudia Sabrina Sandra Pinto', true, 'Rua alem do horizonte', '869', null, 'Samambaia', '65896334', 'Brasília', 'DF'),
       ('Vinicius Rafael Paulo Assis', true, 'Rua do eucalipto', '153', null, 'Fazenda', '68965221', 'Itajaí', 'SC'),
       ('Breno Pedro Ryan da Rosa', false, 'Rua itajaba', '205', null, 'Cascavel Velho','67452889', 'Cascavel','MA');