package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.dto.DtoTipoCliente;
import com.ceiba.usuario.modelo.entidad.Servicio;

import java.util.List;

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
