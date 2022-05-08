package com.ceiba.mascota.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.mascota.servicio.ServicioEliminarMascota;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarMascota implements ManejadorComando<Long> {

    private final ServicioEliminarMascota servicioEliminarMascota;

    public ManejadorEliminarMascota(ServicioEliminarMascota servicioEliminarMascota) {
        this.servicioEliminarMascota = servicioEliminarMascota;
    }

    public void ejecutar(Long idCliente) {
        this.servicioEliminarMascota.ejecutar(idCliente);
    }
}
