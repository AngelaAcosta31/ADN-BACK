update reserva
set  valor = :valor,
     fechaEntrada = :fechaEntrada,
     fechaSalida = :fechaSalida,
     idHabitacion = :idHabitacion,
     idCliente = :idCliente
where  id = :id