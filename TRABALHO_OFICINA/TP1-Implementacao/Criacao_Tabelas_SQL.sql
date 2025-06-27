USE tap; -- Nome do seu banco (pode causar erros caso o comando não seja adicionado)
DROP TABLE IF EXISTS clientes;
CREATE TABLE IF NOT EXISTS clientes (
  nome TEXT,
  idade INT,
  telefone TEXT,
  cpf TEXT,
  idPedidos TEXT
);

DROP TABLE IF EXISTS tecnicos;
CREATE TABLE IF NOT EXISTS tecnicos(
	nome TEXT,
    cpf TEXT, 
    idPedidosAlocados TEXT
    );


#SELECT * FROM clientes;
#SELECT * FROM tecnicos;
