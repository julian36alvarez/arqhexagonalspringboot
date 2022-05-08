package com.ceiba.mascota.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;


public class ServicioCrearMascota {

    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";
    private final RepositorioMascota repositorioMascota;

    public ServicioCrearMascota(RepositorioMascota repositorioMascota) {
        this.repositorioMascota = repositorioMascota;
    }

    private void validarExistenciaPrevia(Mascota mascota) {
        boolean existe = this.repositorioMascota.existe(mascota.getIdCliente());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public Long ejecutar(Mascota mascota) {
        validarExistenciaPrevia(mascota);
        return this.repositorioMascota.crear(mascota);
    }


}
