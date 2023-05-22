create table moveis(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    tipo_movel varchar(100) not null,
    tipo_puxador varchar(100) not null,
    tipo_base varchar(100) not null,
    tipo_tampo varchar(100) not null,
    numero_portas int(2) not null,
    tipo_porta varchar(100) not null,
    numero_gavetas int(2) not null,
    ativo tinyint,

    primary key(id)

);