CREATE TABLE IF NOT EXISTS cliente(
     idCliente serial PRIMARY KEY,
     nomeEmpresa varchar(50),
     cnpj varchar(14),
     contato varchar(15)
);

CREATE TABLE IF NOT EXISTS obra(
     idObra serial Primary Key,
     idCliente int,
     nomeObra varchar(50),
     endereco varchar(50),
     nEndereco varchar(10),
     bairro varchar(20),
     cidade varchar(20),
     responsavel varchar(50),
     contato varchar(15),
     descricao text,
     FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)
);

CREATE TABLE IF NOT EXISTS fornecedor(
     idFornecedor serial Primary Key,
     nomeFornecedor varchar(50),
     contato varchar(15),
     tipo varchar(25),
     endereco varchar(15)
);