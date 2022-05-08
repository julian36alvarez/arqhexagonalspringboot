package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Long identificacion = resultSet.getLong("identificacion");
        Long telefono = resultSet.getLong("telefono");
        String direccion = resultSet.getString("direccion");

        return new DtoCliente(id, identificacion, nombre, direccion, telefono);
    }

}
