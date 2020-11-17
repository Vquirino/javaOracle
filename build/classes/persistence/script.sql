-- conexão com DBA (simples)
conn system/quirino

select user from dual;

select name from v$database;

select banner from v$version;

-- criando BD caveiras
crate user caveiras01 identified by quirino
 default tablespace users
 quota 40m on users;
 
-- permissões 
grant create table, create view, create procedure, create sequence,
  create session, connect to caveiras01;
  
-- conectando
conn caveiras01/quirino

-- criando as tabelas
create table cliente(id number (20) primary key,
  nome varchar2 (50),
  email varchar2 (50) unique);
  
create table endereco(idEndereco number (15) primary key,
  cidade varchar2 (50),
  idClientefk number (15),
  foreign key(idClientefk) references Cliente on delete cascade);
  
-- olhar as tabelas
select * from cat;

-- criar sequencia
create sequence seq_cliente;
create sequence seq_endereco;

create or replace function inclusao(vnome in varchar, vmail in varchar, vcidade in varchar)
  return varchar2
  as

  begin
	
	insert into cliente values (seq_cliente.nextval, vnome, vemail);
	insert into endereco values (seq_endereco.nextval, vcidade, seq_cliente.currval);
	
	  commit;
	
	return '1';
	Exception when others then
	rollback;
	return '-1';

  end;
/

var resposta varchar2(100);

exec :resposta := inclusao('lucas', 'lucas@gmail.com', 'rio de janeiro');
print resposta;

ste linesize 2000;
colunm nome format a15;
colunm email format a20;
colunm cidade format a20;

select * from cliente;
select * from endereco;

create or replace view v$clienteendereco as
  select id, nome, email, idEndereco, cidade, idClientefk
  from cliente c
    inner join
  endereco e
    on c.id = idClientefk;
    
select * from v$clienteendereco;