package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCliente;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
