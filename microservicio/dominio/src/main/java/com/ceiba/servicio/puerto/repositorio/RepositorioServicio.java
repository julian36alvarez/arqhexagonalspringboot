package com.ceiba.servicio.puerto.repositorio;

import com.ceiba.servicio.modelo.entidad.Servicio;

public interface RepositorioServicio {

    /**
     * Permite crear un usuario
     * @param servicio
     * @return el id generado
     */
    Long crear(Servicio servicio);

    /**
     * Permite actualizar un usuario
     * @param servicio
     */
    void actualizar(Servicio servicio);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    boolean existePorIdCliente(Long idCliente);

    boolean existePorIdMascota(Long idMascota);

}
