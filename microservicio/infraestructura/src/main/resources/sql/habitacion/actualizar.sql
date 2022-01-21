update habitacion
set numeroHabitacion = :numeroHabitacion,
    tipo = :tipo,
    noCamas = :noCamas,
    noBannos = :noBannos,
    descripcion = :descripcion,
    precio = :precio,
    piso = :piso,
    estado = :estado
where id = :id