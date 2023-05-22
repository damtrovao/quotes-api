create table orcamentos(

    id bigint not null auto_increment,
    id_cliente bigint not null,
    data_inicio date not null,
    data_entrega date,
    valor decimal(10,2),
    ativo tinyint,

    primary key(id),
    constraint fk_consultas_id_cliente foreign key(id_cliente) references clientes(id)

);