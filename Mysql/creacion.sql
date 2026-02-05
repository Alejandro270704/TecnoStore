create database tecnostore_db ;
use tecnostore_db;
create table marca(id int not null auto_increment,nombre_marca varchar(50),primary key(id));
create table modelo(id int not null auto_increment ,nombre_modelo varchar(50),primary key(id));
create table celular(id int not null auto_increment, marca_id int not null, modelo_id int not null
,sistema_operativo enum('Android','iOS','WindowsPhone','BlackBerry','HarmonyOS')
,gama enum('alta','media','baja'),precio double not null
,stock int default 0 not null, primary key(id),foreign key(marca_id) references marca(id)
,foreign key(modelo_id) references modelo(id));

create table cliente(id int not null auto_increment,nombre varchar (50) not null,identificacion varchar(50),correo varchar(50)not null,telefono varchar(50),primary key(id));
create table venta(id int not null auto_increment, id_cliente int not null, fecha timestamp not null,total double not null,primary key(id),foreign key (id_cliente)references cliente(id)); 
create table detalle_venta(id int not null auto_increment,id_venta int not null,id_celular int not null,cantidad int not null,subtotal double not null ,primary key(id),foreign key(id_venta) references venta(id),foreign key(id_celular) references celular(id));