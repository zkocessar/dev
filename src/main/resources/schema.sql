create table t_cliente
(
   c_id bigint auto_increment,
   c_nombre varchar(255) not null,
   c_apellido varchar(255) not null,
   c_edad integer not null,
   c_fec_nav date not null,
   primary key(c_id)       
);