package com.ceiba.servicio.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioMysql implements RepositorioServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="crear")
    private static String sqlCrearServicio;

    @SqlStatement(namespace="servicio", value="actualizar")
    private static String sqlActualizarServicio;

    @SqlStatement(namespace="servicio", value="eliminar")
    private static String sqlEliminarServicio;

    @SqlStatement(namespace="servicio", value="existePorId")
    private static String sqlExisteServicioPorId;

    @SqlStatement(namespace="servicio", value="existePorIdCliente")
    private static String sqlExisteServicioPorIdCliente;

    @SqlStatement(namespace="servicio", value="existePorIdMascota")
    private static String sqlExisteServicioPorIdMascota;

    public RepositorioServicioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Servicio servicio) {
        return this.customNamedParameterJdbcTemplate.crear(servicio, sqlCrearServicio);
    }

    @Override
    public void actualizar(Servicio servicio) {
        this.customNamedParameterJdbcTemplate.actualizar(servicio, sqlActualizarServicio);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarServicio, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteServicioPorId, paramSource, Boolean.class));
    }

    @Override
    public boolean existePorIdCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteServicioPorIdCliente, paramSource, Boolean.class));
    }

    @Override
    public boolean existePorIdMascota(Long idMascota) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idMascota", idMascota);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteServicioPorIdMascota, paramSource, Boolean.class));
    }


}
