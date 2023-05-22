create table clientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100),
    telefone varchar(11) not null,
    logradouro varchar(100) not null,
    numero varchar(20) not null,
    complemento varchar(100),
    bairro varchar(100),
    cidade varchar(100),
    uf char(2),
    cep varchar(9),

    primary key(id)

);