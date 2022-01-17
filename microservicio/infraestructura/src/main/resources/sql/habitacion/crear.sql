INSERT INTO habitacion (
    numero_habitacion,
    tipo,
    no_camas,
    no_bannos,
    descripcion,
    precio,
    piso,
    estado)
VALUES ( :numero_habitacion,
         :tipo,
         :no_camas,
         :no_bannos,
         :descripcion,
         :precio,
         :piso,
         :estado);