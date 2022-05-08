package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;


    public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes) {
        this.manejadorListarClientes = manejadorListarClientes;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoCliente> listar() {
        return this.manejadorListarClientes.ejecutar();
    }

    @GetMapping("/{idCliente}")
    @ApiOperation("Listar Cliente por id")
    public List<DtoCliente> listar(@PathVariable Long idCliente){
        return this.manejadorListarClientes.ejecutarPorIdCliente(idCliente);
    }

}
