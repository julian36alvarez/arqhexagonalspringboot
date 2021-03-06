package com.ceiba.mascota.controlador;

import com.ceiba.mascota.consulta.ManejadorListarMascotas;
import com.ceiba.mascota.modelo.dto.DtoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@Api(tags={"Controlador consulta mascotas"})
public class ConsultaControladorMascota {

    private final ManejadorListarMascotas manejadorListarMascotas;

    public ConsultaControladorMascota(ManejadorListarMascotas manejadorListarMascotas) {
        this.manejadorListarMascotas = manejadorListarMascotas;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoMascota> listar() {
        return this.manejadorListarMascotas.ejecutar();
    }

    @GetMapping("/cliente/{idCliente}")
    @ApiOperation("Listar Macotas por id Cliente")
    public List<DtoMascota> listarMascotaCliente(@PathVariable Long idCliente){
        return this.manejadorListarMascotas.ejecutarMascotaPorIdCliente(idCliente);
    }

    @GetMapping("/{idMascota}")
    @ApiOperation("Listar Macotas por id Cliente")
    public List<DtoMascota> listarMascota(@PathVariable Long idMascota){
        return this.manejadorListarMascotas.ejecutarPorIdMascota(idMascota);
    }

}
