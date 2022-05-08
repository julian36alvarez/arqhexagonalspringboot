package com.ceiba.mascota.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.puerto.dao.DaoMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMascotaMysql implements DaoMascota {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="mascota", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="mascota", value="listarMascotaPorIdCliente")
    private static String sqlListarMascotaPorIdCliente;

    @SqlStatement(namespace="mascota", value="listarPorIdMascota")
    private static String sqlListarPorIdMascota;

    public DaoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMascota> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMascota());
    }

    /**
     * @param idMascota
     * @return
     */
    @Override
    public List<DtoMascota> listarPorIdMascota(Long idMascota) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idMascota", idMascota);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdMascota, paramSource, new MapeoMascota());
    }

    /**
     * @param idCliente
     * @return
     */
    @Override
    public List<DtoMascota> listarMascotasPorIdCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarMascotaPorIdCliente, paramSource, new MapeoMascota());
    }
}
