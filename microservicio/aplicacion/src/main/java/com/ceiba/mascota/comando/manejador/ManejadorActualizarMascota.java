package com.ceiba.mascota.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.comando.fabrica.FabricaMascota;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.servicio.ServicioActualizarCliente;
import com.ceiba.usuario.servicio.ServicioActualizarMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarMascota implements ManejadorComando<ComandoMascota> {

    private final FabricaMascota fabricaMascota;
    private final ServicioActualizarMascota servicioActualizarMascota;

    public ManejadorActualizarMascota(FabricaMascota fabricaMascota, ServicioActualizarMascota servicioActualizarMascota) {
        this.fabricaMascota = fabricaMascota;
        this.servicioActualizarMascota = servicioActualizarMascota;
    }

    public void ejecutar(ComandoMascota comandoMascota) {
        Mascota mascota = this.fabricaMascota.crear(comandoMascota);
        this.servicioActualizarMascota.ejecutar(mascota);
    }
}
