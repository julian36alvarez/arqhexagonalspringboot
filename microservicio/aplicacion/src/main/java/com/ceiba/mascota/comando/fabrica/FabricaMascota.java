package com.ceiba.mascota.comando.fabrica;

import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.usuario.modelo.entidad.Mascota;
import org.springframework.stereotype.Component;

@Component
public class FabricaMascota {

    public Mascota crear(ComandoMascota comandoMascota) {
        return new Mascota(
                comandoMascota.getId(),
                comandoMascota.getNombre(),
                comandoMascota.getEspecie(),
                comandoMascota.getRaza(),
                comandoMascota.getIdCliente()
        );
    }

}
