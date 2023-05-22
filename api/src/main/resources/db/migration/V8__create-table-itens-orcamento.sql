create table itens_orcamento(

    id bigint not null auto_increment,
    id_orcamento bigint not null,
    id_movel bigint not null,
    material_corpo varchar(100) not null,
    material_frentes varchar(100) not null,
    largura int(6) not null,
    altura int(6) not null,
    profundidade int(6) not null,
    tipo_puxador varchar(100) not null,
    tipo_porta varchar(100) not null,
    numero_portas int(2) not null,
    numero_gavetas int(2) not null,
    tipo_base varchar(100) not null,
    tipo_tampo varchar(100) not null,
    ativo tinyint,

    primary key(id),
    constraint fk_itens_orcamento_id_orcamento foreign key(id_orcamento) references orcamentos(id),
    constraint fk_itens_orcamento_id_movel foreign key(id_movel) references moveis(id)

);