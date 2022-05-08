package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicio implements RowMapper<DtoServicio>, MapperResult {

    @Override
    public DtoServicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {


         Long id  = resultSet.getLong("id");
         Long idUsuario = resultSet.getLong("id_usuario");
         Long tipoUsuario = resultSet.getLong("tipo_usuario");
         Long tipoServicio = resultSet.getLong("tipo_servicio");
         Long idMascota = resultSet.getLong("id_mascota");
         double total = resultSet.getDouble("total");
         LocalDateTime fechaProgramada = extraerLocalDateTime(resultSet,"fecha_programada");
         LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet,"fecha_entrega");
         LocalDateTime fechaContable = extraerLocalDateTime(resultSet,"fecha_contable");
         return new DtoServicio(id,idUsuario,tipoUsuario,tipoServicio,idMascota,total, fechaProgramada, fechaEntrega, fechaContable);

    }

}
