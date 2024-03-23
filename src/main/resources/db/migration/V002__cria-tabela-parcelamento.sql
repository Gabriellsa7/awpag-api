create table parcelamento (
	id bigint not null auto_increment,
    client_id bigint not null,
    descricao varchar(20) not null,
    valor_total decimal(10,2) not null,
    quantidade_parcelas tinyint,
    data_criacao datetime not null,

    primary key (id)
);

alter table parcelamento add constraint fk_parcelamento_client foreign key(client_id) references client(id)
