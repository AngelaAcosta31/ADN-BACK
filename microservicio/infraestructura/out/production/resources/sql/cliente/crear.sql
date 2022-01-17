INSERT INTO cliente (
                    nombre,
                    apellido,
                    numero_identificacion,
                    telefono,
                    correo,
                    sexo,
                    fecha_nacimiento,
                    direccion)
VALUES ( :nombre,
         :apellido,
         :numero_identificacion,
         :telefono,
         :correo,
         :sexo,
         :fecha_nacimiento,
         :direccion);