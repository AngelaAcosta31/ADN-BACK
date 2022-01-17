select *
from cliente
where upper(correo) = upper(:correo)