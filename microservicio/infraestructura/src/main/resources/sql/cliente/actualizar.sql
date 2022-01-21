update cliente
set nombre = :nombre,
    apellido = :apellido,
    numeroIdentificacion = :numeroIdentificacion,
    telefono = :telefono,
    correo = :correo,
    sexo = :sexo,
    fechaNacimiento = :fechaNacimiento,
    direccion = :direccion
where id = :id