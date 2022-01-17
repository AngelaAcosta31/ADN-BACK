update habitacion
set numero_habitacion = :numero_habitacion,
    tipo = :tipo,
    no_camas = :no_camas,
    no_bannos = :no_bannos,
    descripcion = :descripcion,
    precio = :precio,
    piso = :piso,
    estado = :estado
where id_habitacion = :id_habitacion