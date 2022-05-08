package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioServicio;

public class ServicioEliminarServicio {

    private final RepositorioServicio repositorioServicio;

    public ServicioEliminarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutar(Long id) {
        this.repositorioServicio.eliminar(id);
    }
}
