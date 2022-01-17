update cliente
set nombre = :nombre,
    apellido = :apellido,
    numero_identificacion = :numero_identificacion,
    telefono = :telefono,
    correo = :correo,
    sexo = :sexo,
    fecha_nacimiento = :fecha_nacimiento,
    direccion = :direccion
where id_cliente = :id_cliente