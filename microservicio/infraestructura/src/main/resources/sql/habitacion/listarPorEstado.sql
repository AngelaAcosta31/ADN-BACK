select *
from habitacion
where upper(estado) = upper(:estado)