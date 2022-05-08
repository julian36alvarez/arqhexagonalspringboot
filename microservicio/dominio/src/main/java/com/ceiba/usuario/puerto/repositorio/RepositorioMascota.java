package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Mascota;

public interface RepositorioMascota {
    /**
     * Permite crear una mascota
     * @param mascota
     * @return el id generado
     */
    Long crear(Mascota mascota);

    /**
     * Permite actualizar una mascota
     * @param mascota
     */
    void actualizar(Mascota mascota);

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

    boolean existe(Long idCliente);

}
