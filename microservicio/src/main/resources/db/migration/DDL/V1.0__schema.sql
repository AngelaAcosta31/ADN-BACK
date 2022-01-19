CREATE TABLE habitacion (
id SERIAL NOT NULL,
numero_habitacion varchar(5) NOT NULL,
tipo varchar(100) NOT NULL,
no_camas int4 NOT NULL,
no_bannos int4 NOT NULL,
descripcion varchar(100) NOT NULL,
 precio numeric(19, 2)DEFAULT 0 NOT NULL,
 piso varchar(2) NOT NULL,
 estado varchar(1) NOT NULL,
 PRIMARY KEY (id)
 );
CREATE TABLE cliente (
id SERIAL NOT NULL,
nombre varchar(100) NOT NULL,
apellido varchar(100) NOT NULL,
numero_identificacion varchar(15) NOT NULL,
telefono varchar(15),
correo varchar(100),
sexo varchar(1) NOT NULL,
fecha_nacimiento date NOT NULL,
direccion varchar(100),
PRIMARY KEY (id)
);
CREATE TABLE reserva (
id SERIAL NOT NULL,
valor numeric(19, 2) DEFAULT 0 NOT NULL,
 fecha_Entrada timestamp,
  fecha_salida timestamp,
  id_habitacion integer NOT NULL,
  id_cliente integer NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_HABITACION_RESERVA FOREIGN KEY (id_habitacion) REFERENCES habitacion (id),
  CONSTRAINT FK_CLIENTE_RESERVA FOREIGN KEY (id_cliente) REFERENCES cliente (id)
);



