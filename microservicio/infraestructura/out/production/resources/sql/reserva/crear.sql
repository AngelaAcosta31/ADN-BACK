INSERT INTO reserva(
            valor,
            fecha_entrada,
            fecha_salida,
            id_habitacion,
            id_cliente)
VALUES ( :valor,
         :fecha_entrada,
         :fecha_salida,
         :id_habitacion,
         :id_cliente);