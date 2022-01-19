INSERT INTO habitacion (id, numero_habitacion, tipo, no_camas, no_bannos, descripcion, precio, piso, estado) VALUES (1, '221', 'DOBLE',1 , 1, 'HABITACION CON CAMA DOBLE, TV, WIFI Y AGUA CALIENTE', 100000.00, '2','D');
INSERT INTO habitacion (id, numero_habitacion, tipo, no_camas, no_bannos, descripcion, precio, piso, estado) VALUES (2, '111', 'TRIPLE', 2, 1, 'HABITACION CON UNA CAMA DOBLE Y UNA CAMA SENCILLA, CON TV, WIFI Y AGUA CALIENTE', 120000.00, '1','D');
INSERT INTO habitacion (id, numero_habitacion, tipo, no_camas, no_bannos, descripcion, precio, piso, estado) VALUES (3, '111', 'SENCILLA', 1, 1, 'HABITACION CON UNA CAMA SENCILLA, CON TV, WIFI Y AGUA CALIENTE', 120000.00, '1','D');



INSERT INTO cliente (id, nombre, apellido, numero_identificacion, telefono, correo, sexo, fecha_nacimiento,direccion) VALUES (1, 'DANIEL', 'FORERO', '1005754420', '3194382743', 'DANIEL@HOTMAIL.COM', 'M', '2001-03-25','CARRERA 85 C # 45-59');
INSERT INTO cliente (id, nombre, apellido, numero_identificacion, telefono, correo, sexo, fecha_nacimiento,direccion) VALUES (2, 'CAMILA', 'LOPEZ',  '1584587505', '3205689367', 'CAMILA123@HOTMAIL.COM', 'F', '1990-12-11','CARRERA 98 D # 56-66');
INSERT INTO cliente (id, nombre, apellido, numero_identificacion, telefono, correo, sexo, fecha_nacimiento,direccion) VALUES (3, 'ANGELA', 'ACOSTA', '1005874280', '3104542773', 'ANGELAMARIA731@HOTMAIL.COM', 'F', '2000-07-31','CALLE 30 # 1-160');


INSERT INTO reserva (id, valor, fecha_entrada, fecha_salida, id_habitacion, id_cliente) VALUES (1, 4000.00, '2021-04-20', '2021-04-30', 1, 1);
INSERT INTO reserva (id, valor, fecha_entrada, fecha_salida, id_habitacion, id_cliente) VALUES (2, 60000.00, '2021-08-20', '2021-08-25', 2, 1);