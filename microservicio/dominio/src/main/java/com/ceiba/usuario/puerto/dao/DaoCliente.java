package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCliente;


import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar usuarios
     * @return los clientes
     */
    List<DtoCliente> listar();
}
