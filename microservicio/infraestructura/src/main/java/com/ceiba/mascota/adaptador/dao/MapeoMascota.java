package com.ceiba.mascota.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMascota implements RowMapper<DtoMascota>, MapperResult {

    @Override
    public DtoMascota mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String especie = resultSet.getString("especie");
        String raza = resultSet.getString( "raza");
        Long idCliente = resultSet.getLong("id_cliente");

        return new DtoMascota(id,nombre, especie,raza, idCliente);
    }

}
