select id,
       id_usuario,
       tipo_usuario,
       tipo_servicio,
       id_mascota,
       total,
       fecha_programada, fecha_entrega,  fecha_contable
from servicio where id = :idServicio