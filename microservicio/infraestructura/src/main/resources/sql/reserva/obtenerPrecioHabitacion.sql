select precio from reserva
inner join habitacion h on (reserva.id_habitacion = h.id)
where reserva.id_habitacion = :reserva.id_habitacion;