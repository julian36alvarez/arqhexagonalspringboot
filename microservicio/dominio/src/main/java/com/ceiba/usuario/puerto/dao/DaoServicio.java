package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoServicio;
import java.util.List;

public interface DaoServicio {

    /**
     * Permite listar servicios
     * @return los servicios
     */
    List<DtoServicio> listar();
}
