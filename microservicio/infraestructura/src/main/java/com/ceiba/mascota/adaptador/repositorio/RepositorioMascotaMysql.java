package com.ceiba.mascota.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMascotaMysql implements RepositorioMascota {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="mascota", value="crear")
    private static String sqlCrearMascota;

    @SqlStatement(namespace="mascota", value="actualizar")
    private static String sqlActualizarMascota;

    @SqlStatement(namespace="mascota", value="eliminar")
    private static String sqlEliminarMascota;

    @SqlStatement(namespace="mascota", value="existePorId")
    private static String sqlExisteMascotaPorId;

    @SqlStatement(namespace="cliente", value="existePorId")
    private static String sqlExisteClientesParaMascota;

    public RepositorioMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Mascota mascota) {
        return this.customNamedParameterJdbcTemplate.crear(mascota, sqlCrearMascota);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarMascota, paramSource);
    }


    @Override
    public void actualizar(Mascota mascota) {
        this.customNamedParameterJdbcTemplate.actualizar(mascota, sqlActualizarMascota);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteMascotaPorId,paramSource, Boolean.class);
    }

    @Override
    public boolean existe(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idCliente);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteClientesParaMascota, paramSource, Boolean.class));
    }
}
