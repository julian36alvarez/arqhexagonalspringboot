package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClienteMysql implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="cliente", value="listarPorIdCliente")
    private static String sqlListarPorIdCliente;

    public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCliente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCliente());
    }

    /**
     * @param idCliente
     * @return
     */
    @Override
    public List<DtoCliente> listarPorIdCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdCliente, paramSource, new MapeoCliente());
    }
}
