package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoMascota;

import java.util.List;

public interface DaoMascota {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoMascota> listar();
}
