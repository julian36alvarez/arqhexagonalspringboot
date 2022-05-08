package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * Permite crear un usuario
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un usuario
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(Long identificacion);

    /**
     * Permite validar si existe un cliente
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
