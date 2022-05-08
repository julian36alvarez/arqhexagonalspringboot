select id,
       nombre,
       especie,
       raza,
       id_cliente
from mascota where id_cliente = :idCliente