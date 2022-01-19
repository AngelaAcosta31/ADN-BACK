update reserva
set  valor = :valor,
     fecha_entrada = :fecha_entrada,
     fecha_salida = :fecha_salida,
     id_habitacion = :id_habitacion,
     id_cliente = :id_cliente
where  id = :id