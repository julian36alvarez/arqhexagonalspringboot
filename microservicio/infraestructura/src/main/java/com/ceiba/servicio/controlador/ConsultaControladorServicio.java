package com.ceiba.servicio.controlador;

import com.ceiba.servicio.consulta.ManejadorListarServicios;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoServicio;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@Api(tags={"Controlador consulta servicios"})
public class ConsultaControladorServicio {

    private final ManejadorListarServicios manejadorListarServicios;

    public ConsultaControladorServicio(ManejadorListarServicios manejadorListarServicios) {
        this.manejadorListarServicios = manejadorListarServicios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoServicio> listar() {
        return this.manejadorListarServicios.ejecutar();
    }

}
