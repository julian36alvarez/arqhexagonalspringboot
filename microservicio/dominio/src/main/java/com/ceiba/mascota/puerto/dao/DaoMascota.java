package com.ceiba.mascota.puerto.dao;

import com.ceiba.mascota.modelo.dto.DtoMascota;

import java.util.List;

public interface DaoMascota {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoMascota> listar();
}
