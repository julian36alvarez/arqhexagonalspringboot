package com.ceiba.cliente.consulta;

import com.ceiba.usuario.modelo.dto.DtoCliente;
import com.ceiba.usuario.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarClientes {

    private final DaoCliente daoCliente;

    public ManejadorListarClientes(DaoCliente daoCliente){
        this.daoCliente = daoCliente;
    }

    public List<DtoCliente> ejecutar(){ return this.daoCliente.listar(); }
}
