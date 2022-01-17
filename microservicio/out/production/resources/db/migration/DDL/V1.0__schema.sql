CREATE TABLE habitacion (
id_habitacion SERIAL NOT NULL,
numero_habitacion varchar(5) NOT NULL,
tipo varchar(100) NOT NULL,
no_camas int4 NOT NULL,
no_bannos int4 NOT NULL,
descripcion varchar(100) NOT NULL,
 precio numeric(19, 2)DEFAULT 0 NOT NULL,
 piso varchar(2) NOT NULL,
 estado varchar(1) NOT NULL,
 PRIMARY KEY (id_habitacion)
 );
CREATE TABLE cliente (
id_cliente SERIAL NOT NULL,
nombre varchar(100) NOT NULL,
apellido varchar(100) NOT NULL,
numero_identificacion varchar(15) NOT NULL,
telefono varchar(15),
correo varchar(100),
sexo varchar(1) NOT NULL,
fecha_nacimiento date NOT NULL,
direccion varchar(100),
PRIMARY KEY (id_cliente)
);
CREATE TABLE reserva (
id_reserva SERIAL NOT NULL,
valor numeric(19, 2) DEFAULT 0 NOT NULL,
 fecha_Entrada date NOT NULL,
  fecha_salida date,
  id_habitacion int4 NOT NULL,
  id_cliente int4 NOT NULL,
  PRIMARY KEY (id_reserva)
 );



--- creacion llaves foraneas -----------
ALTER TABLE reserva ADD CONSTRAINT FK_HABITACION_RESERVA FOREIGN KEY (id_habitacion) REFERENCES habitacion (id_habitacion);
ALTER TABLE reserva ADD CONSTRAINT FK_CLIENTE_RESERVA FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);